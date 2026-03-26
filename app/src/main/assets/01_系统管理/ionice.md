# ionice - 调整进程I/O优先级

## 1. 命令简介
ionice 命令用于调整进程I/O优先级，是 Linux 系统中常用的进程管理命令之一。它可以修改进程的I/O调度优先级。

## 2. 命令语法
```bash
ionice [选项] [命令]
```

## 3. 常用选项

| 选项 | 说明 |
|------|------|
| -h, --help | 显示帮助信息 |
| --version | 显示版本信息 |
| -c, --class=<类> | 设置I/O类 |
| -n, --classdata=<级别> | 设置I/O级别 |
| -p, --pid=<PID> | 调整指定PID的进程 |

## 4. I/O类

| 类 | 说明 |
|------|------|
| 0 | 空闲（Idle） |
| 1 | 实时（Realtime） |
| 2 | 最佳-effort（默认） |
| 3 | 空闲（Idle） |

## 5. I/O级别

| 类 | 级别范围 | 说明 |
|------|------|------|
| 0 | 0-7 | 实时类，级别0最高 |
| 2 | 0-7 | 最佳-effort类，级别0最高 |
| 3 | 0 | 空闲类，只有一个级别 |

## 6. 实战示例

### 6.1 基本用法
```bash
# 以默认I/O优先级运行命令
ionice command

# 以实时I/O优先级运行命令
ionice -c 1 -n 0 command

# 以空闲I/O优先级运行命令
ionice -c 3 command
```

### 6.2 调整运行进程的I/O优先级
```bash
# 调整运行进程的I/O优先级
ionice -c 2 -n 5 -p 1234

# 调整多个运行进程的I/O优先级
ionice -c 2 -n 5 -p 1234 5678 9012
```

## 7. 高级用法

### 7.1 组合选项
```bash
# 以指定I/O优先级运行复杂命令
ionice -c 2 -n 3 bash -c "command1 && command2"

# 批量调整I/O优先级
for pid in $(pgrep bash); do ionice -c 2 -n 5 -p $pid; done
```

### 7.2 与其他命令结合使用
```bash
# 后台运行并设置I/O优先级
ionice -c 3 command &

# 调整进程I/O优先级后查看
ionice -c 2 -n 5 -p 1234 && ionice -p 1234
```

### 7.3 自动化脚本
```bash
#!/bin/bash

# 自动化调整进程I/O优先级
adjust_io_priority() {
    local class=${1:-"2"}
    local level=${2:-"0"}
    local target=${3:-"command"}
    
    if [[ $target =~ ^[0-9]+$ ]]; then
        echo "调整进程 $target 的I/O优先级为类 $class，级别 $level"
        ionice -c $class -n $level -p $target
    else
        echo "以I/O优先级类 $class，级别 $level 运行命令: $target"
        ionice -c $class -n $level $target
    fi
}

# 使用函数
adjust_io_priority 2 0 "ls -la"
adjust_io_priority 3 0 "find / -name "*.txt""
adjust_io_priority 2 5 1234
```

## 8. 常见问题与解决方案

### 8.1 问题：ionice: command not found
**解决方案**：安装 util-linux
- Ubuntu/Debian: `apt install util-linux`
- CentOS/RHEL: `yum install util-linux`

### 8.2 问题：无法设置实时I/O优先级
**解决方案**：需要root权限
```bash
sudo ionice -c 1 -n 0 command
```

### 8.3 问题：进程未找到
**解决方案**：确保进程存在
```bash
ps -p 1234 && ionice -p 1234
```

### 8.4 问题：权限不足
**解决方案**：确保有足够的权限
```bash
sudo ionice -c 1 -n 0 -p 1234
```

### 8.5 问题：I/O优先级调整无效
**解决方案**：确保进程存在且权限足够
```bash
sudo ionice -c 1 -n 0 -p 1234
```

## 9. 命令对比

| 命令 | 功能 | 适用场景 |
|------|------|----------|
| ionice | 调整进程I/O优先级 | 所有 Linux 系统 |
| nice | 调整进程优先级 | 所有 Linux 系统 |
| renice | 调整运行进程的优先级 | 所有 Linux 系统 |

## 10. 注意事项
- ionice 命令用于调整进程I/O优先级，是 Linux 系统中常用的进程管理命令之一
- ionice 命令可以修改进程的I/O调度优先级
- 常用的操作包括：基本用法、调整运行进程的I/O优先级等
- ionice 命令需要 root 权限来设置实时I/O优先级
- ionice 命令支持多种选项，可以根据需要选择合适的选项
- ionice 命令是所有 Linux 系统的标准工具，用于调整进程I/O优先级