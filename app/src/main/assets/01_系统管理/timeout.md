# timeout - 设置命令超时

## 1. 命令简介
timeout 命令用于设置命令的执行超时时间，是 Linux 系统中常用的系统管理命令之一。它可以在命令执行超过指定时间后终止命令的执行。

## 2. 命令语法
```bash
timeout [选项] 时间 命令 [参数...]
```

## 3. 时间格式

| 格式 | 说明 |
|------|------|
| N | N 秒 |
| Ns | N 秒 |
| Nm | N 分钟 |
| Nh | N 小时 |
| Nd | N 天 |

## 4. 常用选项

| 选项 | 说明 |
|------|------|
| -s, --signal=<信号> | 指定终止命令时发送的信号 |
| --preserve-status | 保留命令的退出状态 |
| --help | 显示帮助信息 |
| --version | 显示版本信息 |

## 5. 实战示例

### 5.1 设置命令超时时间为 5 秒
```bash
timeout 5s sleep 10
```

### 5.2 设置命令超时时间为 1 分钟
```bash
timeout 1m command
```

### 5.3 指定终止信号
```bash
timeout -s SIGINT 5s sleep 10
```

### 5.4 保留命令的退出状态
```bash
timeout --preserve-status 5s sleep 10
```

### 5.5 在脚本中使用
```bash
#!/bin/bash

echo "执行命令，超时时间为 10 秒"
timeout 10s command

if [ $? -eq 124 ]; then
    echo "命令执行超时"
else
    echo "命令执行成功"
fi
```

### 5.6 结合其他命令使用
```bash
# 限制网络请求的时间
timeout 5s curl https://www.example.com

# 限制文件下载的时间
timeout 30s wget https://example.com/file.zip

# 限制命令的执行时间
timeout 1m find / -name "*.txt"
```

## 6. 高级用法

### 6.1 在脚本中控制命令执行时间
```bash
#!/bin/bash

# 执行命令并设置超时时间
execute_with_timeout() {
    local timeout=$1
    shift
    local command=$@
    
    echo "执行命令: $command"
    echo "超时时间: $timeout"
    
    timeout $timeout $command
    
    local exit_code=$?
    if [ $exit_code -eq 124 ]; then
        echo "命令执行超时"
    elif [ $exit_code -eq 0 ]; then
        echo "命令执行成功"
    else
        echo "命令执行失败，退出码: $exit_code"
    fi
}

# 使用函数
execute_with_timeout 10s sleep 5
execute_with_timeout 5s sleep 10
```

### 6.2 批量处理文件时设置超时
```bash
#!/bin/bash

# 批量处理文件并设置超时
files=(file1.txt file2.txt file3.txt file4.txt file5.txt)

for file in "${files[@]}"; do
    echo "处理文件: $file"
    timeout 30s process_file "$file"
    
    if [ $? -eq 124 ]; then
        echo "处理 $file 超时"
    else
        echo "处理 $file 完成"
    fi
done
```

### 6.3 与管道结合使用
```bash
# 限制管道命令的执行时间
timeout 10s (find / -name "*.txt" | grep "test" | wc -l)

# 限制重定向命令的执行时间
timeout 10s (cat large_file.txt > output.txt)

# 限制后台命令的执行时间
timeout 10s (sleep 5 & wait)
```

### 6.4 测试命令的响应时间
```bash
#!/bin/bash

echo "测试命令的响应时间:"
echo "-------------------"

commands=(
    "ls -la"
    "find / -name \"*.txt\" | head -n 10"
    "curl https://www.example.com"
)

for cmd in "${commands[@]}"; do
    echo "\n测试命令: $cmd"
    timeout 10s bash -c "$cmd"
    
    if [ $? -eq 124 ]; then
        echo "命令执行超时"
    fi
done
```

## 7. 常见问题与解决方案

### 7.1 问题：timeout: command not found
**解决方案**：安装 timeout 工具
- Ubuntu/Debian: `apt install coreutils`
- CentOS/RHEL: `yum install coreutils`

### 7.2 问题：timeout 命令无法终止某些进程
**解决方案**：使用更强制的信号
```bash
timeout -s SIGKILL 5s command
```

### 7.3 问题：timeout 命令的退出状态码不明确
**解决方案**：使用 --preserve-status 选项保留命令的退出状态
```bash
timeout --preserve-status 5s command
```

### 7.4 问题：timeout 命令执行缓慢
**解决方案**：timeout 命令本身执行很快，慢的是被执行的命令

### 7.5 问题：timeout 无法处理复杂命令
**解决方案**：使用 bash -c 执行复杂命令
```bash
timeout 5s bash -c "command1 && command2"
```

### 7.6 问题：timeout 命令在脚本中不工作
**解决方案**：确保脚本有执行权限，并且 timeout 命令的路径正确

## 8. 命令对比

| 命令 | 功能 | 适用场景 |
|------|------|----------|
| timeout | 设置命令超时 | 限制命令执行时间 |
| time | 测量命令执行时间 | 性能分析 |
| nice | 调整进程优先级 | 资源管理 |
| renice | 调整运行进程的优先级 | 资源管理 |
| nohup | 忽略挂起信号运行命令 | 后台执行 |

## 9. 注意事项
- timeout 命令用于设置命令的执行超时时间，是 Linux 系统中常用的系统管理命令之一
- timeout 命令可以在命令执行超过指定时间后终止命令的执行
- 常用的操作包括：设置命令超时时间、指定终止信号、保留命令的退出状态等
- timeout 命令是 coreutils 包的一部分，几乎所有 Linux 系统都默认安装
- timeout 命令的时间参数可以是秒、分钟、小时或天
- 使用 -s 选项可以指定终止命令时发送的信号
- 使用 --preserve-status 选项可以保留命令的退出状态
- timeout 命令的退出状态码为 124 表示命令执行超时
- timeout 命令可以与其他命令结合使用，实现更复杂的操作