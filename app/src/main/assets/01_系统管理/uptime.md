# uptime - 显示系统运行时间

## 1. 命令简介
uptime 命令用于显示系统运行时间，是 Linux 系统中常用的系统监控命令之一。它可以显示系统的运行时间、平均负载等信息。

## 2. 命令语法
```bash
uptime [选项]
```

## 3. 常用选项

| 选项 | 说明 |
|------|------|
| -h, --help | 显示帮助信息 |
| --version | 显示版本信息 |
| -p, --pretty | 以人类可读的格式显示 |
| -s, --since | 显示系统启动时间 |

## 4. 输出格式

| 字段 | 说明 |
|------|------|
| 时间 | 当前时间 |
| up | 系统运行时间 |
| users | 登录用户数 |
| load average | 系统平均负载（1分钟、5分钟、15分钟） |

## 5. 实战示例

### 5.1 基本用法
```bash
# 显示系统运行时间
uptime

# 以人类可读的格式显示
uptime -p

# 显示系统启动时间
uptime -s
```

## 6. 高级用法

### 6.1 组合选项
```bash
# 显示系统运行时间和启动时间
uptime && uptime -s

# 批量显示系统信息
uptime && free -m && df -h
```

### 6.2 与其他命令结合使用
```bash
# 显示系统运行时间并管道到其他命令
uptime | awk '{print $3}'

# 监控系统运行时间
watch uptime
```

### 6.3 自动化脚本
```bash
#!/bin/bash

# 自动化显示系统运行时间
display_uptime() {
    local options=${1:-""}
    
    echo "系统运行时间信息:"
    uptime $options
}

# 使用函数
display_uptime
display_uptime "-p"
display_uptime "-s"
```

## 7. 常见问题与解决方案

### 7.1 问题：uptime: command not found
**解决方案**：安装 procps
- Ubuntu/Debian: `apt install procps`
- CentOS/RHEL: `yum install procps`

### 7.2 问题：无法显示系统运行时间
**解决方案**：确保系统正常运行

### 7.3 问题：uptime 命令执行缓慢
**解决方案**：系统负载较高，这是正常现象

## 8. 命令对比

| 命令 | 功能 | 适用场景 |
|------|------|----------|
| uptime | 显示系统运行时间 | 所有 Linux 系统 |
| w | 显示登录用户信息 | 所有 Linux 系统 |
| who | 显示登录用户 | 所有 Linux 系统 |
| last | 显示登录历史 | 所有 Linux 系统 |

## 9. 注意事项
- uptime 命令用于显示系统运行时间，是 Linux 系统中常用的系统监控命令之一
- uptime 命令可以显示系统的运行时间、平均负载等信息
- 常用的操作包括：基本用法、以人类可读的格式显示、显示系统启动时间等
- uptime 命令不需要 root 权限来执行
- uptime 命令支持的选项较少，主要用于显示系统运行时间
- uptime 命令是所有 Linux 系统的标准工具，用于显示系统运行时间