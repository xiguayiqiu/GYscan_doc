# nice - 调整进程优先级

## 1. 命令简介
nice 命令用于调整进程优先级，是 Linux 系统中常用的进程管理命令之一。它可以在启动进程时设置其优先级。

## 2. 命令语法
```bash
nice [选项] [命令]
```

## 3. 常用选项

| 选项 | 说明 |
|------|------|
| -h, --help | 显示帮助信息 |
| --version | 显示版本信息 |
| -n, --adjustment=<值> | 设置优先级调整值 |

## 4. 优先级范围

| 优先级 | 说明 |
|------|------|
| -20 | 最高优先级 |
| 0 | 默认优先级 |
| 19 | 最低优先级 |

## 5. 实战示例

### 5.1 基本用法
```bash
# 以默认优先级运行命令
nice command

# 以较高优先级运行命令
nice -n -5 command

# 以较低优先级运行命令
nice -n 10 command
```

### 5.2 常用优先级设置
```bash
# 高优先级（需要root权限）
sudo nice -n -10 command

# 低优先级
nice -n 15 command
```

## 6. 高级用法

### 6.1 组合选项
```bash
# 以指定优先级运行复杂命令
nice -n -5 bash -c "command1 && command2"

# 批量设置优先级
for i in {1..5}; do nice -n $i command; done
```

### 6.2 与其他命令结合使用
```bash
# 后台运行并设置优先级
nice -n 10 command &

# 查看进程优先级
nice -n 5 command & ps -p $! -o nice,command
```

### 6.3 自动化脚本
```bash
#!/bin/bash

# 自动化设置进程优先级
run_with_priority() {
    local priority=${1:-"0"}
    local command=${2:-"echo Hello"}
    
    echo "以优先级 $priority 运行命令: $command"
    nice -n $priority $command
}

# 使用函数
run_with_priority
run_with_priority "-5" "ls -la"
run_with_priority "10" "sleep 10"
```

## 7. 常见问题与解决方案

### 7.1 问题：nice: command not found
**解决方案**：安装 coreutils
- Ubuntu/Debian: `apt install coreutils`
- CentOS/RHEL: `yum install coreutils`

### 7.2 问题：无法设置负优先级
**解决方案**：需要root权限
```bash
sudo nice -n -10 command
```

### 7.3 问题：命令执行失败
**解决方案**：确保命令存在
```bash
which command && nice command
```

### 7.4 问题：优先级设置无效
**解决方案**：确保权限足够
```bash
sudo nice -n -10 command
```

### 7.5 问题：nice 命令执行缓慢
**解决方案**：命令本身执行缓慢，这是正常现象

## 8. 命令对比

| 命令 | 功能 | 适用场景 |
|------|------|----------|
| nice | 调整进程优先级 | 所有 Linux 系统 |
| renice | 调整运行进程的优先级 | 所有 Linux 系统 |
| ionice | 调整进程I/O优先级 | 所有 Linux 系统 |

## 9. 注意事项
- nice 命令用于调整进程优先级，是 Linux 系统中常用的进程管理命令之一
- nice 命令可以在启动进程时设置其优先级
- 常用的操作包括：基本用法、常用优先级设置等
- nice 命令需要 root 权限来设置负优先级
- nice 命令支持多种选项，可以根据需要选择合适的选项
- nice 命令是所有 Linux 系统的标准工具，用于调整进程优先级