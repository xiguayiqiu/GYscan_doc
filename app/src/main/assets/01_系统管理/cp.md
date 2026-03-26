# cp - 复制文件或目录

## 1. 命令简介
cp 命令用于复制文件或目录，是 Linux 系统中常用的文件操作命令之一。它可以将文件或目录从一个位置复制到另一个位置，支持多种选项来控制复制行为。

## 2. 命令语法
```bash
cp [选项] [源文件或目录] [目标文件或目录]
```

## 3. 常用选项

| 选项 | 说明 |
|------|------|
| -h, --help | 显示帮助信息 |
| --version | 显示版本信息 |
| -i, --interactive | 交互式操作，覆盖前提示 |
| -f, --force | 强制覆盖，不提示 |
| -r, -R, --recursive | 递归复制目录 |
| -p, --preserve | 保留文件属性 |
| -a, --archive | 归档模式，保留所有属性 |
| -u, --update | 只复制更新的文件 |
| -v, --verbose | 详细显示复制过程 |
| -l, --link | 创建硬链接而不是复制 |
| -s, --symbolic-link | 创建符号链接而不是复制 |

## 4. 实战示例

### 4.1 基本用法
```bash
# 复制文件
cp file1.txt file2.txt

# 复制文件到目录
cp file.txt /home/user/
```

### 4.2 复制目录
```bash
cp -r dir1 dir2
```

### 4.3 交互式操作
```bash
cp -i file1.txt file2.txt
```

### 4.4 强制覆盖
```bash
cp -f file1.txt file2.txt
```

### 4.5 保留文件属性
```bash
cp -p file1.txt file2.txt
```

### 4.6 归档模式
```bash
cp -a dir1 dir2
```

### 4.7 只复制更新的文件
```bash
cp -u file1.txt file2.txt
```

## 5. 高级用法

### 5.1 组合选项
```bash
# 递归复制目录，保留属性，详细显示过程
cp -avr dir1 dir2

# 交互式复制，保留属性
cp -ip file1.txt file2.txt
```

### 5.2 与其他命令结合使用
```bash
# 复制多个文件到目录
cp file1.txt file2.txt file3.txt /home/user/

# 复制所有 .txt 文件到目录
cp *.txt /home/user/

# 复制文件并备份
cp -b file1.txt file2.txt
```

### 5.3 批量操作
```bash
#!/bin/bash

# 批量复制文件
files=("file1.txt" "file2.txt" "file3.txt")
destination="/home/user/"

for file in "${files[@]}"; do
    echo "复制 $file 到 $destination"
    cp $file $destination
done
```

### 5.4 自动化脚本
```bash
#!/bin/bash

# 自动化复制文件
copy_file() {
    local source=$1
    local destination=$2
    local options=${3:-""}
    
    echo "复制 $source 到 $destination"
    cp $options $source $destination
    
    if [ $? -eq 0 ]; then
        echo "复制成功"
    else
        echo "复制失败"
    fi
}

# 使用函数
copy_file "file1.txt" "file2.txt"
copy_file "dir1" "dir2" "-r"
copy_file "file3.txt" "/home/user/" "-p"
```

## 6. 常见问题与解决方案

### 6.1 问题：cp: command not found
**解决方案**：安装 coreutils
- Ubuntu/Debian: `apt install coreutils`
- CentOS/RHEL: `yum install coreutils`

### 6.2 问题：无法复制文件
**解决方案**：确保有足够的权限
```bash
sudo cp file.txt /root/
```

### 6.3 问题：复制目录失败
**解决方案**：使用 -r 选项
```bash
cp -r dir1 dir2
```

### 6.4 问题：覆盖文件时没有提示
**解决方案**：使用 -i 选项
```bash
cp -i file1.txt file2.txt
```

### 6.5 问题：复制后文件属性丢失
**解决方案**：使用 -p 或 -a 选项
```bash
cp -p file1.txt file2.txt
```

## 7. 命令对比

| 命令 | 功能 | 适用场景 |
|------|------|----------|
| cp | 复制文件或目录 | 所有 Linux 系统 |
| mv | 移动或重命名文件 | 所有 Linux 系统 |
| rm | 删除文件或目录 | 所有 Linux 系统 |
| rsync | 远程同步文件 | 所有 Linux 系统 |

## 8. 注意事项
- cp 命令用于复制文件或目录，是 Linux 系统中常用的文件操作命令之一
- cp 命令可以将文件或目录从一个位置复制到另一个位置，支持多种选项来控制复制行为
- 常用的操作包括：基本用法、复制目录、交互式操作、强制覆盖等
- cp 命令不需要 root 权限来执行，但复制到受保护目录时需要
- cp 命令支持多种选项，可以根据需要选择合适的选项
- cp 命令是所有 Linux 系统的标准工具，用于复制文件或目录