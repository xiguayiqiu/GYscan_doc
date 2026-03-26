# renice - 调整运行进程的优先级

## 1. 命令简介
renice 命令用于调整运行进程的优先级，是 Linux 系统中常用的进程管理命令之一。它可以修改正在运行的进程的优先级。

## 2. 命令语法
```bash
renice [选项] [优先级] [PID...]
```

## 3. 常用选项

| 选项 | 说明 |
|------|------|
| -h, --help | 显示帮助信息 |
| --version | 显示版本信息 |
| -n, --priority=<优先级> | 设置优先级 |
| -g, --pgrp | 操作进程组 |
| -u, --user | 操作用户的所有进程 |
| -p, --pid | 操作进程ID（默认） |

## 4. 优先级范围

| 优先级 | 说明 |
|------|------|
| -20 | 最高优先级 |
| 0 | 默认优先级 |
| 19 | 最低优先级 |

## 5. 实战示例

### 5.1 基本用法
```bash
# 调整进程优先级
renice 10 1234

# 调整多个进程的优先级
renice 5 1234 5678 9012
```

### 5.2 调整进程组优先级
```bash
# 调整进程组优先级
renice -g 10 1234
```

### 5.3 调整用户的所有进程优先级
```bash
# 调整用户的所有进程优先级
renice -u 10 user
```

## 6. 高级用法

### 6.1 组合选项
```bash
# 调整进程优先级，使用长选项
renice --priority=10 --pid=1234

# 批量调整进程优先级
for pid in $(pgrep bash); do renice 5 $pid; done
```

### 6.2 与其他命令结合使用
```bash
# 查找进程后调整优先级
pgrep bash | xargs renice 10

# 调整进程优先级后查看
renice 5 1234 && ps -p 1234 -o nice,command
```

### 6.3 自动化脚本
```bash
#!/bin/bash

# 自动化调整进程优先级
adjust_priority() {
    local priority=${1:-"10"}
    local pids=${2:-""}
    
    echo "调整进程优先级为 $priority"
    renice $priority $pids
    
    if [ $? -eq 0 ]; then
        echo "操作成功"
    else
        echo "操作失败"
    fi
}

# 使用函数
adjust_priority 10 1234
adjust_priority 5 5678 9012
```

## 7. 常见问题与解决方案

### 7.1 问题：renice: command not found
**解决方案**：安装 procps
- Ubuntu/Debian: `apt install procps`
- CentOS/RHEL: `yum install procps`

### 7.2 问题：无法设置负优先级
**解决方案**：需要root权限
```bash
sudo renice -5 1234
```

### 7.3 问题：进程未找到
**解决方案**：确保进程存在
```bash
ps -p 1234 && renice 10 1234
```

### 7.4 问题：权限不足
**解决方案**：确保有足够的权限
```bash
sudo renice 10 1234
```

### 7.5 问题：优先级调整无效
**解决方案**：确保进程存在且权限足够
```bash
sudo renice -5 1234
```

## 8. 命令对比

| 命令 | 功能 | 适用场景 |
|------|------|----------|
| renice | 调整运行进程的优先级 | 所有 Linux 系统 |
| nice | 调整进程优先级 | 所有 Linux 系统 |
| ionice | 调整进程I/O优先级 | 所有 Linux 系统 |

## 9. 注意事项
- renice 命令用于调整运行进程的优先级，是 Linux 系统中常用的进程管理命令之一
- renice 命令可以修改正在运行的进程的优先级
- 常用的操作包括：基本用法、调整进程组优先级、调整用户的所有进程优先级等
- renice 命令需要 root 权限来设置负优先级或调整其他用户的进程优先级
- renice 命令支持多种选项，可以根据需要选择合适的选项
- renice 命令是所有 Linux 系统的标准工具，用于调整运行进程的优先级