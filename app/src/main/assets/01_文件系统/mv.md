# mv - 移动或重命名文件

## 1. 命令简介
mv 命令用于移动文件或目录，也可以用于重命名文件或目录，是 Linux 系统中最常用的文件操作命令之一。它可以在不同目录之间移动文件，也可以在同一目录中重命名文件。

## 2. 命令语法
```bash
mv [选项] 源文件 目标文件
mv [选项] 源文件... 目标目录
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -f | 强制移动，覆盖已存在的文件，不提示 |
| -i | 交互式移动，覆盖前询问用户 |
| -n | 不覆盖已存在的文件 |
| -v | 详细模式，显示移动的文件列表 |
| -u | 仅移动源文件比目标文件新的文件，或目标文件不存在的文件 |
| -b | 为已存在的文件创建备份 |
| --backup[=CONTROL] | 控制备份文件的命名方式 |
| --strip-trailing-slashes | 移除源文件路径末尾的斜杠 |
| --target-directory=DIRECTORY | 将所有源文件移动到指定目录 |

## 4. 实战示例

### 4.1 移动文件到目标位置
```bash
mv file.txt /path/to/destination/
```

### 4.2 移动多个文件到目标目录
```bash
mv file1.txt file2.txt /path/to/destination/
```

### 4.3 重命名文件
```bash
mv oldname.txt newname.txt
```

### 4.4 移动目录
```bash
mv directory/ /path/to/destination/
```

### 4.5 交互式移动，覆盖前询问
```bash
mv -i file.txt /path/to/destination/
```

### 4.6 强制移动，覆盖已存在的文件
```bash
mv -f file.txt /path/to/destination/
```

### 4.7 详细模式移动
```bash
mv -v file.txt /path/to/destination/
```

### 4.8 仅移动较新的文件
```bash
mv -u file.txt /path/to/destination/
```

### 4.9 移动时创建备份
```bash
mv -b file.txt /path/to/destination/
```

### 4.10 重命名目录
```bash
mv olddirectory/ newdirectory/
```

### 4.11 使用目标目录选项
```bash
mv --target-directory=/path/to/destination/ file1.txt file2.txt
```

## 5. 高级用法

### 5.1 批量重命名文件
```bash
# 将所有.txt文件重命名为.bak文件
for file in *.txt; do
    mv "$file" "${file%.txt}.bak"
done

# 批量重命名文件，添加前缀
for file in *.jpg; do
    mv "$file" "prefix_$file"
done
```

### 5.2 移动文件并保持目录结构
```bash
# 使用rsync保持目录结构
rsync -av --remove-source-files source/ destination/

# 或者使用find和mv
find source/ -type f -exec mv {} destination/ \;
```

### 5.3 移动隐藏文件
```bash
# 移动所有隐藏文件
mv .* /path/to/destination/

# 移动所有文件（包括隐藏文件）
mv * .* /path/to/destination/
```

### 5.4 移动大文件
```bash
# 移动大文件并显示进度
rsync -P largefile.iso /path/to/destination/
rm largefile.iso
```

### 5.5 跨文件系统移动
```bash
# 跨文件系统移动（会复制后删除源文件）
mv file.txt /mnt/other/filesystem/
```

## 6. 性能优化

### 6.1 移动文件的性能
- 在同一文件系统内移动文件是即时的，因为只是修改文件系统的元数据
- 跨文件系统移动文件会先复制再删除，速度较慢
- 对于大文件，跨文件系统移动时可以考虑使用rsync

### 6.2 示例：移动大量文件
```bash
# 使用find和xargs移动大量文件
find source/ -type f -print0 | xargs -0 mv -t destination/

# 或者使用rsync
rsync -av --remove-source-files source/ destination/
```

### 6.3 移动目录的性能
```bash
# 同一文件系统内移动目录（快速）
mv directory/ /path/to/destination/

# 跨文件系统移动目录（较慢）
rsync -av --remove-source-files directory/ /path/to/destination/
rm -rf directory/
```

## 7. 常见问题与解决方案

### 7.1 问题：移动文件时覆盖了重要文件
**解决方案**：使用`-i`选项进行交互式移动，或使用`-n`选项不覆盖文件

### 7.2 问题：移动目录时出现错误
**解决方案**：确保目标目录存在，或使用`mkdir -p`创建目标目录结构

### 7.3 问题：移动跨文件系统的大文件时速度慢
**解决方案**：使用`rsync`命令，它提供更好的性能和断点续传功能

### 7.4 问题：无法移动文件，权限被拒绝
**解决方案**：确保有足够的权限，或使用`sudo`命令

### 7.5 问题：移动隐藏文件时出错
**解决方案**：使用`mv .*`移动所有隐藏文件，或单独指定隐藏文件

## 8. 命令对比

| 命令 | 功能 | 适用场景 |
|------|------|----------|
| mv | 移动或重命名文件 | 基本文件移动和重命名操作 |
| cp | 复制文件和目录 | 文件复制操作 |
| rsync | 远程同步和复制 | 增量复制，远程复制，大文件复制 |
| rm | 删除文件和目录 | 文件删除操作 |

## 9. 注意事项
- mv 命令可以用来重命名文件或目录
- 移动目录时不需要使用 -r 选项
- 使用 -i 选项可以避免意外覆盖文件
- 在同一文件系统内移动文件是即时的，因为只是修改文件系统的元数据
- 跨文件系统移动文件会先复制再删除，速度较慢
- 对于重要文件，建议使用 -i 选项进行交互式移动，避免意外覆盖
- 使用 -b 选项可以为已存在的文件创建备份，防止数据丢失