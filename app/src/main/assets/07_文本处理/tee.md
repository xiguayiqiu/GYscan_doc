# tee - 读取标准输入并写入文件和标准输出

## 1. 命令简介
tee 命令用于读取标准输入并写入文件和标准输出，是 Linux 系统中常用的文本处理命令之一。它可以同时将输入内容输出到文件和标准输出，方便用户在查看输出的同时保存结果。

## 2. 命令语法
```bash
tee [选项] [文件...]
```

## 3. 常用选项

| 选项 | 说明 |
|------|------|
| -a, --append | 追加到文件，而不是覆盖 |
| -i, --ignore-interrupts | 忽略中断信号 |
| -p, --output-error[=模式] | 设置写入错误处理模式 |
| --help | 显示帮助信息 |
| --version | 显示版本信息 |

## 4. 实战示例

### 4.1 基本用法
```bash
# 读取标准输入并写入文件和标准输出
echo "Hello World" | tee output.txt

# 读取标准输入并写入多个文件
echo "Hello World" | tee file1.txt file2.txt
```

### 4.2 追加到文件
```bash
# 追加到文件
echo "Hello World" | tee -a output.txt
```

### 4.3 忽略中断信号
```bash
# 忽略中断信号
echo "Hello World" | tee -i output.txt
```

### 4.4 与管道结合使用
```bash
# 读取命令输出并写入文件
echo "Hello World" | tee output.txt | grep "World"

# 读取文件内容并写入多个文件
cat input.txt | tee output1.txt output2.txt
```

### 4.5 在脚本中使用
```bash
#!/bin/bash

echo "执行命令并保存输出"
ls -la | tee output.txt

echo "输出已保存到 output.txt"
```

## 5. 高级用法

### 5.1 在脚本中使用tee
```bash
#!/bin/bash

# 执行命令并保存输出
execute_and_save() {
    local command=$1
    local output_file=$2
    
    echo "执行命令: $command"
    echo "保存输出到: $output_file"
    
    $command | tee $output_file
    
    echo "命令执行完成"
}

# 使用函数
execute_and_save "ls -la" "ls_output.txt"
execute_and_save "df -h" "df_output.txt"
```

### 5.2 批量处理文件
```bash
#!/bin/bash

# 批量处理文件并保存输出
files=(file1.txt file2.txt file3.txt)

for file in "${files[@]}"; do
    echo "处理文件: $file"
    cat "$file" | tee "${file}.output" | wc -l
done
```

### 5.3 与其他命令结合使用
```bash
# 备份配置文件并查看差异
cp /etc/config/config.txt /etc/config/config.txt.bak | tee backup.log

# 编译程序并保存输出
gcc -o program program.c 2>&1 | tee compile.log

# 执行命令并记录执行时间
time ls -la | tee time.log
```

### 5.4 多级管道
```bash
# 多级管道中使用tee
ls -la | tee output.txt | grep "txt" | tee grep_output.txt

# 复杂管道
find / -name "*.txt" 2>/dev/null | tee files.txt | head -n 10 | tee top10.txt
```

## 6. 常见问题与解决方案

### 6.1 问题：tee: command not found
**解决方案**：安装 tee 工具
- Ubuntu/Debian: `apt install coreutils`
- CentOS/RHEL: `yum install coreutils`

### 6.2 问题：tee 命令无法写入文件
**解决方案**：确保有文件写入权限
```bash
sudo tee output.txt
```

### 6.3 问题：tee 命令执行缓慢
**解决方案**：对于大文件，tee 命令可能会执行较慢，这是正常现象

### 6.4 问题：tee 命令无法处理二进制文件
**解决方案**：tee 命令可以处理二进制文件，但需要确保输出文件也是二进制模式

### 6.5 问题：tee 命令在脚本中不工作
**解决方案**：确保脚本有执行权限，并且 tee 命令的路径正确

### 6.6 问题：tee 命令无法处理多个文件
**解决方案**：tee 命令可以处理多个文件，只需在命令行中列出所有文件
```bash
echo "Hello" | tee file1.txt file2.txt file3.txt
```

## 7. 命令对比

| 命令 | 功能 | 适用场景 |
|------|------|----------|
| tee | 读取标准输入并写入文件和标准输出 | 同时输出到文件和终端 |
| cat | 连接文件并输出 | 输出文件内容 |
| echo | 输出字符串 | 输出单行文本 |
| printf | 格式化输出 | 格式化文本输出 |
| head | 显示文件开头 | 限制输出行数 |

## 8. 注意事项
- tee 命令用于读取标准输入并写入文件和标准输出，是 Linux 系统中常用的文本处理命令之一
- tee 命令可以同时将输入内容输出到文件和标准输出
- 常用的操作包括：基本用法、追加到文件、忽略中断信号、与管道结合使用等
- tee 命令是 coreutils 包的一部分，几乎所有 Linux 系统都默认安装
- 使用 -a 选项可以追加到文件，而不是覆盖
- 使用 -i 选项可以忽略中断信号
- tee 命令的执行速度取决于输入内容的大小
- tee 命令可以与其他命令通过管道结合使用，实现更复杂的操作