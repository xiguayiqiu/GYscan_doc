# cp - 复制文件或目录

## 1. 命令简介
cp 命令用于复制文件或目录，是 Linux 系统中最常用的文件操作命令之一。它可以将一个或多个文件复制到指定位置，也可以复制整个目录结构。

## 2. 命令语法
```bash
cp [选项] 源文件 目标文件
cp [选项] 源文件... 目标目录
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -a | 归档模式，保留文件的所有属性（包括权限、时间戳、链接等），相当于 -dR --preserve=all |
| -f | 强制复制，覆盖已存在的文件，不提示 |
| -i | 交互式复制，覆盖前询问用户 |
| -r | 递归复制目录及其内容 |
| -p | 保留文件的权限、所有者、时间戳等属性 |
| -v | 详细模式，显示复制的文件列表 |
| -u | 仅复制源文件比目标文件新的文件，或目标文件不存在的文件 |
| -l | 创建硬链接而不是复制文件，节省空间 |
| -s | 创建符号链接而不是复制文件 |
| -d | 复制符号链接本身，而不是链接指向的文件 |
| -n | 不覆盖已存在的文件 |
| --preserve=all | 保留所有文件属性 |
| --backup[=CONTROL] | 为已存在的文件创建备份 |
| --remove-destination | 复制前删除目标文件 |

## 4. 实战示例

### 4.1 复制文件到目标位置
```bash
cp file.txt /path/to/destination/
```

### 4.2 复制多个文件到目标目录
```bash
cp file1.txt file2.txt /path/to/destination/
```

### 4.3 递归复制目录
```bash
cp -r directory/ /path/to/destination/
```

### 4.4 复制文件并保留属性
```bash
cp -p file.txt /path/to/destination/
```

### 4.5 交互式复制，覆盖前询问
```bash
cp -i file.txt /path/to/destination/
```

### 4.6 强制复制，覆盖已存在的文件
```bash
cp -f file.txt /path/to/destination/
```

### 4.7 归档模式复制（保留所有属性）
```bash
cp -a source/ destination/
```

### 4.8 仅复制较新的文件
```bash
cp -u source.txt destination.txt
```

### 4.9 创建硬链接
```bash
cp -l source.txt link.txt
```

### 4.10 创建符号链接
```bash
cp -s source.txt symlink.txt
```

### 4.11 详细模式复制
```bash
cp -v file.txt /path/to/destination/
```

### 4.12 复制目录并保留所有属性
```bash
cp -a directory/ /path/to/destination/
```

## 5. 高级用法

### 5.1 复制大文件时显示进度
```bash
# 使用pv命令显示复制进度
pv largefile.iso | cp --sparse=always /dev/stdin /path/to/destination/

# 或者使用rsync命令
rsync -P largefile.iso /path/to/destination/
```

### 5.2 复制特定类型的文件
```bash
# 复制所有.txt文件
cp *.txt /path/to/destination/

# 复制所有以a开头的文件
cp a* /path/to/destination/

# 复制所有.txt和.log文件
cp *.{txt,log} /path/to/destination/
```

### 5.3 复制时创建备份
```bash
# 创建带日期戳的备份
cp --backup=numbered file.txt /path/to/destination/
```

### 5.4 复制文件到多个目录
```bash
# 使用循环复制到多个目录
dirs=(/path1 /path2 /path3)
for dir in "${dirs[@]}"; do
    cp file.txt "$dir"
done
```

### 5.5 复制并重命名文件
```bash
cp file.txt /path/to/destination/newfile.txt
```

## 6. 性能优化

### 6.1 复制大文件
- 使用`cp --sparse=always`复制稀疏文件，节省空间
- 对于非常大的文件，考虑使用`rsync`命令，它支持断点续传
- 在复制大量小文件时，先打包再复制可以提高效率

### 6.2 示例：复制大文件
```bash
# 复制大文件并显示进度
rsync -P largefile.iso /path/to/destination/

# 复制稀疏文件
cp --sparse=always sparsefile.img /path/to/destination/
```

### 6.3 复制大量文件
```bash
# 先打包再复制
tar -czf files.tar.gz directory/
cp files.tar.gz /path/to/destination/
tar -xzf files.tar.gz -C /path/to/destination/

# 或者使用rsync
rsync -av directory/ /path/to/destination/
```

## 7. 常见问题与解决方案

### 7.1 问题：复制目录时出现错误
**解决方案**：使用`-r`选项递归复制目录

### 7.2 问题：复制时覆盖文件而不提示
**解决方案**：使用`-i`选项进行交互式复制

### 7.3 问题：复制后文件权限改变
**解决方案**：使用`-p`或`-a`选项保留文件属性

### 7.4 问题：复制大文件时速度慢
**解决方案**：使用`rsync`命令，它提供更好的性能和断点续传功能

### 7.5 问题：复制符号链接时出错
**解决方案**：使用`-d`选项复制符号链接本身，或使用`-L`选项跟随链接

## 8. 命令对比

| 命令 | 功能 | 适用场景 |
|------|------|----------|
| cp | 复制文件和目录 | 基本文件复制操作 |
| rsync | 远程同步和复制 | 增量复制，远程复制，大文件复制 |
| scp | 安全复制 | 跨网络复制文件 |
| mv | 移动或重命名文件 | 文件重命名，移动文件 |

## 9. 注意事项
- 复制目录时需要使用 -r 选项
- 使用 -a 选项可以保留文件的所有属性，相当于 -dR --preserve=all
- 在复制大文件时，使用 -v 选项可以查看复制进度
- 对于重要文件，建议使用 -i 选项进行交互式复制，避免意外覆盖
- 在复制大量文件时，考虑使用 rsync 命令，它提供更好的性能和功能
- 复制符号链接时，默认会复制链接指向的文件，使用 -d 选项可以复制链接本身