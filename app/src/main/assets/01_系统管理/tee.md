# tee - 读取标准输入并写入文件和标准输出

## 1. 命令简介
tee 命令用于读取标准输入并写入文件和标准输出，是 Linux 系统中常用的文件操作命令之一。它可以将命令的输出同时保存到文件和显示在屏幕上。

## 2. 命令语法
```bash
tee [选项] [文件...]
```

## 3. 常用选项

| 选项 | 说明 |
|------|------|
| -h, --help | 显示帮助信息 |
| --version | 显示版本信息 |
| -a, --append | 追加到文件，而不是覆盖 |
| -i, --ignore-interrupts | 忽略中断信号 |

## 4. 实战示例

### 4.1 基本用法
```bash
# 读取标准输入并写入文件和标准输出
echo "Hello World" | tee file.txt

# 读取命令输出并写入文件和标准输出
ls -la | tee file.txt
```

### 4.2 追加到文件
```bash
# 追加到文件
echo "Hello World" | tee -a file.txt
```

### 4.3 忽略中断信号
```bash
# 忽略中断信号
echo "Hello World" | tee -i file.txt
```

### 4.4 写入多个文件
```bash
# 写入多个文件
echo "Hello World" | tee file1.txt file2.txt file3.txt
```

## 5. 高级用法

### 5.1 组合选项
```bash
# 追加到多个文件
echo "Hello World" | tee -a file1.txt file2.txt

# 忽略中断信号并追加到文件
echo "Hello World" | tee -ia file.txt
```

### 5.2 与其他命令结合使用
```bash
# 执行命令并保存输出
sudo apt update | tee update.log

# 执行命令并同时保存到多个文件
sudo apt upgrade -y | tee upgrade.log | grep "upgraded"

# 读取文件并写入多个文件
cat file.txt | tee file1.txt file2.txt
```

### 5.3 批量操作
```bash
#!/bin/bash

# 批量执行命令并保存输出
commands=(
    "ls -la"
    "df -h"
    "free -m"
)

for command in "${commands[@]}"; do
    echo "执行命令: $command"
    $command | tee -a output.log
done
```

### 5.4 自动化脚本
```bash
#!/bin/bash

# 自动化执行命令并保存输出
execute_command() {
    local command=$1
    local file=${2:-"output.log"}
    local options=${3:-"-a"}
    
    echo "执行命令: $command"
    $command | tee $options $file
}

# 使用函数
execute_command "ls -la"
execute_command "df -h" "disk.log"
execute_command "free -m" "memory.log" ""
```

## 6. 常见问题与解决方案

### 6.1 问题：tee: command not found
**解决方案**：安装 coreutils
- Ubuntu/Debian: `apt install coreutils`
- CentOS/RHEL: `yum install coreutils`

### 6.2 问题：无法写入文件
**解决方案**：确保有足够的权限
```bash
echo "Hello World" | sudo tee /root/file.txt
```

### 6.3 问题：文件被覆盖
**解决方案**：使用 -a 选项
```bash
echo "Hello World" | tee -a file.txt
```

### 6.4 问题：tee 命令执行缓慢
**解决方案**：输出过大，这是正常现象

### 6.5 问题：无法写入多个文件
**解决方案**：确保所有文件路径正确
```bash
echo "Hello World" | tee file1.txt file2.txt
```

## 7. 命令对比

| 命令 | 功能 | 适用场景 |
|------|------|----------|
| tee | 读取标准输入并写入文件和标准输出 | 所有 Linux 系统 |
| cat | 连接并显示文件内容 | 所有 Linux 系统 |
| echo | 输出文本 | 所有 Linux 系统 |
| printf | 格式化输出 | 所有 Linux 系统 |

## 8. 注意事项
- tee 命令用于读取标准输入并写入文件和标准输出，是 Linux 系统中常用的文件操作命令之一
- tee 命令可以将命令的输出同时保存到文件和显示在屏幕上
- 常用的操作包括：基本用法、追加到文件、忽略中断信号、写入多个文件等
- tee 命令不需要 root 权限来执行，但写入到受保护文件时需要
- tee 命令支持多种选项，可以根据需要选择合适的选项
- tee 命令是所有 Linux 系统的标准工具，用于读取标准输入并写入文件和标准输出