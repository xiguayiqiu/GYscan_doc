# mv - 移动或重命名文件

## 1. 命令简介
mv 命令用于移动或重命名文件，是 Linux 系统中常用的文件操作命令之一。它可以将文件或目录从一个位置移动到另一个位置，也可以用于重命名文件或目录。

## 2. 命令语法
```bash
mv [选项] [源文件或目录] [目标文件或目录]
```

## 3. 常用选项

| 选项 | 说明 |
|------|------|
| -h, --help | 显示帮助信息 |
| --version | 显示版本信息 |
| -i, --interactive | 交互式操作，覆盖前提示 |
| -f, --force | 强制覆盖，不提示 |
| -v, --verbose | 详细显示移动过程 |
| -n, --no-clobber | 不覆盖已存在的文件 |
| -u, --update | 只移动更新的文件 |

## 4. 实战示例

### 4.1 基本用法（重命名文件）
```bash
mv file1.txt file2.txt
```

### 4.2 移动文件到目录
```bash
mv file.txt /home/user/
```

### 4.3 移动目录
```bash
mv dir1 dir2
```

### 4.4 交互式操作
```bash
mv -i file1.txt file2.txt
```

### 4.5 强制覆盖
```bash
mv -f file1.txt file2.txt
```

### 4.6 详细显示过程
```bash
mv -v file.txt /home/user/
```

## 5. 高级用法

### 5.1 组合选项
```bash
# 交互式移动，详细显示过程
mv -iv file1.txt file2.txt

# 强制移动，不覆盖已存在的文件
mv -fn file1.txt file2.txt
```

### 5.2 与其他命令结合使用
```bash
# 移动多个文件到目录
mv file1.txt file2.txt file3.txt /home/user/

# 移动所有 .txt 文件到目录
mv *.txt /home/user/

# 重命名目录
mv old_dir new_dir
```

### 5.3 批量操作
```bash
#!/bin/bash

# 批量移动文件
files=("file1.txt" "file2.txt" "file3.txt")
destination="/home/user/"

for file in "${files[@]}"; do
    echo "移动 $file 到 $destination"
    mv $file $destination
done
```

### 5.4 自动化脚本
```bash
#!/bin/bash

# 自动化移动文件
move_file() {
    local source=$1
    local destination=$2
    local options=${3:-""}
    
    echo "移动 $source 到 $destination"
    mv $options $source $destination
    
    if [ $? -eq 0 ]; then
        echo "移动成功"
    else
        echo "移动失败"
    fi
}

# 使用函数
move_file "file1.txt" "file2.txt"
move_file "dir1" "dir2"
move_file "file3.txt" "/home/user/" "-v"
```

## 6. 常见问题与解决方案

### 6.1 问题：mv: command not found
**解决方案**：安装 coreutils
- Ubuntu/Debian: `apt install coreutils`
- CentOS/RHEL: `yum install coreutils`

### 6.2 问题：无法移动文件
**解决方案**：确保有足够的权限
```bash
sudo mv file.txt /root/
```

### 6.3 问题：移动目录失败
**解决方案**：mv 命令默认支持移动目录，不需要额外选项
```bash
mv dir1 dir2
```

### 6.4 问题：覆盖文件时没有提示
**解决方案**：使用 -i 选项
```bash
mv -i file1.txt file2.txt
```

### 6.5 问题：无法覆盖已存在的文件
**解决方案**：使用 -f 选项
```bash
mv -f file1.txt file2.txt
```

## 7. 命令对比

| 命令 | 功能 | 适用场景 |
|------|------|----------|
| mv | 移动或重命名文件 | 所有 Linux 系统 |
| cp | 复制文件或目录 | 所有 Linux 系统 |
| rm | 删除文件或目录 | 所有 Linux 系统 |
| rename | 批量重命名文件 | 所有 Linux 系统 |

## 8. 注意事项
- mv 命令用于移动或重命名文件，是 Linux 系统中常用的文件操作命令之一
- mv 命令可以将文件或目录从一个位置移动到另一个位置，也可以用于重命名文件或目录
- 常用的操作包括：基本用法、移动文件到目录、移动目录、交互式操作等
- mv 命令不需要 root 权限来执行，但移动到受保护目录时需要
- mv 命令支持多种选项，可以根据需要选择合适的选项
- mv 命令是所有 Linux 系统的标准工具，用于移动或重命名文件