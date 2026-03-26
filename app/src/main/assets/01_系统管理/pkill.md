# pkill - 按名称终止进程

## 1. 命令简介
pkill 命令用于按名称终止进程，是 Linux 系统中常用的进程管理命令之一。它可以根据进程名称终止匹配的进程。

## 2. 命令语法
```bash
pkill [选项] [模式]
```

## 3. 常用选项

| 选项 | 说明 |
|------|------|
| -h, --help | 显示帮助信息 |
| --version | 显示版本信息 |
| -s, --signal=<信号> | 指定信号 |
| -u, --euid=<用户> | 按有效用户ID筛选 |
| -U, --uid=<用户> | 按用户ID筛选 |
| -g, --pgroup=<组> | 按进程组ID筛选 |
| -P, --parent=<PID> | 按父进程ID筛选 |
| -t, --terminal=<终端> | 按终端筛选 |
| -l, --list-name | 显示进程名称 |
| -f, --full | 匹配完整命令行 |
| -n, --newest | 只匹配最新的进程 |
| -o, --oldest | 只匹配最旧的进程 |
| -c, --count | 显示匹配的进程数 |

## 4. 实战示例

### 4.1 基本用法
```bash
# 按名称终止进程
pkill bash

# 强制终止进程
pkill -9 bash

# 按完整命令行终止进程
pkill -f "python script.py"
```

### 4.2 按用户筛选
```bash
# 按用户筛选终止进程
pkill -u user bash

# 按用户ID筛选终止进程
pkill -U 1000 bash
```

### 4.3 按终端筛选
```bash
# 按终端筛选终止进程
pkill -t pts/0 bash
```

### 4.4 显示匹配的进程数
```bash
# 显示匹配的进程数
pkill -c bash
```

## 5. 高级用法

### 5.1 组合选项
```bash
# 强制终止指定用户的进程
pkill -9 -u user bash

# 按完整命令行终止进程，只匹配最新的进程
pkill -f -n "python script.py"
```

### 5.2 与其他命令结合使用
```bash
# 查找进程后终止
pgrep bash && pkill bash

# 批量终止进程
top -b -n 1 | grep "bash" | awk '{print $1}' | xargs pkill
```

### 5.3 批量操作
```bash
#!/bin/bash

# 批量终止进程
processes=("bash" "nginx" "mysql")

for process in "${processes[@]}"; do
    echo "终止进程 $process"
    pkill $process
done
```

### 5.4 自动化脚本
```bash
#!/bin/bash

# 自动化终止进程
kill_process() {
    local process=$1
    local options=${2:-""}
    
    echo "终止进程 $process"
    pkill $options $process
    
    if [ $? -eq 0 ]; then
        echo "操作成功"
    else
        echo "操作失败"
    fi
}

# 使用函数
kill_process "bash"
kill_process "nginx" "-9"
kill_process "python" "-f"
```

## 6. 常见问题与解决方案

### 6.1 问题：pkill: command not found
**解决方案**：安装 procps
- Ubuntu/Debian: `apt install procps`
- CentOS/RHEL: `yum install procps`

### 6.2 问题：无法终止进程
**解决方案**：使用 -9 选项
```bash
pkill -9 bash
```

### 6.3 问题：进程未找到
**解决方案**：确保进程存在
```bash
pgrep bash && pkill bash
```

### 6.4 问题：权限不足
**解决方案**：确保有足够的权限
```bash
sudo pkill bash
```

### 6.5 问题：无法匹配完整命令行
**解决方案**：使用 -f 选项
```bash
pkill -f "python script.py"
```

## 7. 命令对比

| 命令 | 功能 | 适用场景 |
|------|------|----------|
| pkill | 按名称终止进程 | 所有 Linux 系统 |
| kill | 终止进程 | 所有 Linux 系统 |
| killall | 按名称终止所有匹配的进程 | 所有 Linux 系统 |
| pgrep | 按名称查找进程 | 所有 Linux 系统 |

## 8. 注意事项
- pkill 命令用于按名称终止进程，是 Linux 系统中常用的进程管理命令之一
- pkill 命令可以根据进程名称终止匹配的进程
- 常用的操作包括：基本用法、按用户筛选、按终端筛选、显示匹配的进程数等
- pkill 命令需要 root 权限来终止其他用户的进程
- pkill 命令支持多种选项，可以根据需要选择合适的选项
- pkill 命令是所有 Linux 系统的标准工具，用于按名称终止进程