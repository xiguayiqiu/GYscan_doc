# rm - 删除文件或目录

## 1. 命令简介
rm 命令用于删除文件或目录，是 Linux 系统中常用的文件操作命令之一。它可以删除文件或目录，支持多种选项来控制删除行为。

## 2. 命令语法
```bash
rm [选项] [文件或目录]
```

## 3. 常用选项

| 选项 | 说明 |
|------|------|
| -h, --help | 显示帮助信息 |
| --version | 显示版本信息 |
| -i, --interactive | 交互式操作，删除前提示 |
| -f, --force | 强制删除，不提示 |
| -r, -R, --recursive | 递归删除目录 |
| -v, --verbose | 详细显示删除过程 |
| -d, --dir | 删除空目录 |

## 4. 实战示例

### 4.1 基本用法
```bash
# 删除文件
rm file.txt

# 删除多个文件
rm file1.txt file2.txt file3.txt
```

### 4.2 删除目录
```bash
rm -r dir
```

### 4.3 交互式操作
```bash
rm -i file.txt
```

### 4.4 强制删除
```bash
rm -f file.txt
```

### 4.5 详细显示过程
```bash
rm -v file.txt
```

### 4.6 删除空目录
```bash
rm -d empty_dir
```

## 5. 高级用法

### 5.1 组合选项
```bash
# 递归删除目录，交互式操作，详细显示过程
rm -riv dir

# 强制递归删除目录
rm -rf dir
```

### 5.2 与其他命令结合使用
```bash
# 删除所有 .txt 文件
rm *.txt

# 删除以 a 开头的文件
rm a*

# 删除当前目录的所有文件
rm *
```

### 5.3 批量操作
```bash
#!/bin/bash

# 批量删除文件
files=("file1.txt" "file2.txt" "file3.txt")

for file in "${files[@]}"; do
    echo "删除 $file"
    rm $file
done
```

### 5.4 自动化脚本
```bash
#!/bin/bash

# 自动化删除文件
delete_file() {
    local file=$1
    local options=${2:-""}
    
    echo "删除 $file"
    rm $options $file
    
    if [ $? -eq 0 ]; then
        echo "删除成功"
    else
        echo "删除失败"
    fi
}

# 使用函数
delete_file "file1.txt"
delete_file "dir1" "-r"
delete_file "file3.txt" "-f"
```

## 6. 常见问题与解决方案

### 6.1 问题：rm: command not found
**解决方案**：安装 coreutils
- Ubuntu/Debian: `apt install coreutils`
- CentOS/RHEL: `yum install coreutils`

### 6.2 问题：无法删除文件
**解决方案**：确保有足够的权限
```bash
sudo rm file.txt
```

### 6.3 问题：删除目录失败
**解决方案**：使用 -r 选项
```bash
rm -r dir
```

### 6.4 问题：删除文件时没有提示
**解决方案**：使用 -i 选项
```bash
rm -i file.txt
```

### 6.5 问题：无法删除非空目录
**解决方案**：使用 -r 选项
```bash
rm -r dir
```

## 7. 命令对比

| 命令 | 功能 | 适用场景 |
|------|------|----------|
| rm | 删除文件或目录 | 所有 Linux 系统 |
| rmdir | 删除空目录 | 所有 Linux 系统 |
| mv | 移动或重命名文件 | 所有 Linux 系统 |
| cp | 复制文件或目录 | 所有 Linux 系统 |

## 8. 注意事项
- rm 命令用于删除文件或目录，是 Linux 系统中常用的文件操作命令之一
- rm 命令可以删除文件或目录，支持多种选项来控制删除行为
- 常用的操作包括：基本用法、删除目录、交互式操作、强制删除等
- rm 命令不需要 root 权限来执行，但删除受保护文件时需要
- rm 命令支持多种选项，可以根据需要选择合适的选项
- rm 命令是所有 Linux 系统的标准工具，用于删除文件或目录
- 注意：rm 命令删除的文件通常无法恢复，使用时请谨慎