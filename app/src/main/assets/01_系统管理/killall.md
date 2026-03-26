# killall - 按名称终止进程

## 1. 命令简介
killall 命令用于按名称终止进程，是 Linux 系统中常用的系统管理命令之一。它可以根据进程名称终止所有匹配的进程。

## 2. 命令语法
```bash
killall [选项] [进程名...]
```

## 3. 常用选项

| 选项 | 说明 |
|------|------|
| -e, --exact | 精确匹配进程名 |
| -I, --ignore-case | 忽略大小写 |
| -g, --process-group | 终止进程组 |
| -i, --interactive | 交互式确认 |
| -l, --list | 显示所有已知信号 |
| -q, --quiet | 不显示错误信息 |
| -r, --regexp | 使用正则表达式匹配进程名 |
| -s, --signal <信号> | 指定信号 |
| -u, --user <用户> | 只终止指定用户的进程 |
| -v, --verbose | 显示详细信息 |
| -w, --wait | 等待进程终止 |
| --help | 显示帮助信息 |
| --version | 显示版本信息 |

## 4. 常用信号

| 信号 | 说明 |
|------|------|
| SIGINT (2) | 中断信号 |
| SIGTERM (15) | 终止信号（默认） |
| SIGKILL (9) | 强制终止信号 |
| SIGSTOP (19) | 停止信号 |

## 5. 实战示例

### 5.1 终止指定名称的进程
```bash
killall firefox
```

### 5.2 精确匹配进程名
```bash
killall -e firefox
```

### 5.3 忽略大小写
```bash
killall -I FIREFOX
```

### 5.4 交互式确认
```bash
killall -i firefox
```

### 5.5 使用正则表达式
```bash
killall -r 'fire.*'
```

### 5.6 指定信号
```bash
# 使用 SIGKILL 信号
killall -s SIGKILL firefox

# 使用信号编号
killall -s 9 firefox
```

### 5.7 只终止指定用户的进程
```bash
killall -u user firefox
```

### 5.8 显示详细信息
```bash
killall -v firefox
```

## 6. 高级用法

### 6.1 在脚本中使用killall
```bash
#!/bin/bash

# 终止进程
terminate_process() {
    local process_name=$1
    local signal=${2:-SIGTERM}
    
    echo "终止进程: $process_name"
    echo "使用信号: $signal"
    
    killall -s $signal $process_name
    
    if [ $? -eq 0 ]; then
        echo "进程 $process_name 已终止"
    else
        echo "进程 $process_name 终止失败"
    fi
}

# 使用函数
terminate_process firefox
terminate_process chrome SIGKILL
```

### 6.2 批量终止进程
```bash
#!/bin/bash

# 批量终止进程
processes=(
    "firefox"
    "chrome"
    "opera"
)

for process in "${processes[@]}"; do
    echo "终止进程: $process"
    killall -q $process
    if [ $? -eq 0 ]; then
        echo "进程 $process 已终止"
    else
        echo "进程 $process 不存在"
    fi
done
```

### 6.3 与其他命令结合使用
```bash
# 查找并终止占用 CPU 最多的进程
ps aux --sort=-%cpu | head -n 6 | tail -n 5 | awk '{print $11}' | xargs killall

# 终止所有 Java 进程
killall java

# 终止所有 Python 进程
killall python
```

### 6.4 监控和终止进程
```bash
#!/bin/bash

# 监控并终止进程
echo "监控进程，按 Ctrl+C 退出"

while true; do
    echo "\n当前运行的进程:"
    ps aux | grep -E "firefox|chrome" | grep -v "grep"
    
    read -p "输入要终止的进程名称: " process_name
    
    if [ -n "$process_name" ]; then
        killall -i $process_name
    fi
done
```

## 7. 常见问题与解决方案

### 7.1 问题：killall: command not found
**解决方案**：安装 killall 工具
- Ubuntu/Debian: `apt install psmisc`
- CentOS/RHEL: `yum install psmisc`

### 7.2 问题：killall 无法终止进程
**解决方案**：使用更强制的信号
```bash
killall -s SIGKILL process_name
```

### 7.3 问题：killall 命令执行失败
**解决方案**：检查进程名称是否正确，或者使用 -e 选项精确匹配

### 7.4 问题：killall 命令无法找到进程
**解决方案**：确保进程存在，使用 ps 命令查看进程状态

### 7.5 问题：killall 命令终止了不需要终止的进程
**解决方案**：使用 -e 选项精确匹配进程名，或者使用 -i 选项交互式确认

### 7.6 问题：killall 命令在脚本中不工作
**解决方案**：确保脚本有执行权限，并且 killall 命令的路径正确

## 8. 命令对比

| 命令 | 功能 | 适用场景 |
|------|------|----------|
| killall | 按名称终止进程 | 批量终止同名进程 |
| kill | 按 PID 终止进程 | 精确终止单个进程 |
| pkill | 按名称或属性终止进程 | 更灵活的进程终止 |
| pgrep | 按名称或属性查找进程 | 查找进程 PID |
| ps | 显示进程状态 | 查看进程信息 |

## 9. 注意事项
- killall 命令用于按名称终止进程，是 Linux 系统中常用的系统管理命令之一
- killall 命令可以根据进程名称终止所有匹配的进程
- 常用的操作包括：终止指定名称的进程、精确匹配进程名、忽略大小写、交互式确认等
- killall 命令在大多数 Linux 系统中需要单独安装
- 使用 -e 选项可以精确匹配进程名，使用 -I 选项可以忽略大小写
- 使用 -s 选项可以指定信号，默认使用 SIGTERM 信号
- 使用 -i 选项可以交互式确认，避免误操作
- killall 命令需要谨慎使用，避免终止系统关键进程
- killall 命令的执行不会影响其他进程的功能，只会终止匹配的进程