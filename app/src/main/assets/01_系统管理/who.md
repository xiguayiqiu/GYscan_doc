# who - 显示登录用户

## 1. 命令简介
who 命令用于显示登录用户，是 Linux 系统中常用的系统监控命令之一。它可以显示当前登录到系统的用户信息。

## 2. 命令语法
```bash
who [选项]
```

## 3. 常用选项

| 选项 | 说明 |
|------|------|
| -h, --help | 显示帮助信息 |
| --version | 显示版本信息 |
| -a, --all | 显示所有信息 |
| -b, --boot | 显示系统启动时间 |
| -d, --dead | 显示已死亡的进程 |
| -H, --heading | 显示头部信息 |
| -l, --login | 显示登录进程 |
| -m | 只显示当前用户 |
| -p, --process | 显示进程信息 |
| -q, --count | 显示登录用户数 |
| -r, --runlevel | 显示运行级别 |
| -s, --short | 显示简短格式（默认） |
| -t, --time | 显示系统时间 |
| -u, --users | 显示用户信息 |

## 4. 输出格式

| 字段 | 说明 |
|------|------|
| USER | 用户名 |
| TTY | 终端设备 |
| FROM | 登录来源 |
| LOGIN@ | 登录时间 |
| IDLE | 空闲时间 |
| JCPU | 该终端所有进程使用的CPU时间 |
| PCPU | 当前进程使用的CPU时间 |
| WHAT | 当前执行的命令 |

## 5. 实战示例

### 5.1 基本用法
```bash
# 显示登录用户
who

# 只显示当前用户
who -m

# 显示登录用户数
who -q
```

### 5.2 显示系统启动时间
```bash
# 显示系统启动时间
who -b

# 显示运行级别
who -r
```

### 5.3 显示所有信息
```bash
# 显示所有信息
who -a
```

## 6. 高级用法

### 6.1 组合选项
```bash
# 显示所有信息，包括头部
who -aH

# 显示系统启动时间和运行级别
who -br
```

### 6.2 与其他命令结合使用
```bash
# 显示登录用户并管道到其他命令
who | grep user

# 监控登录用户
watch who
```

### 6.3 自动化脚本
```bash
#!/bin/bash

# 自动化显示登录用户信息
display_login_users() {
    local options=${1:-""}
    
    echo "登录用户信息:"
    who $options
}

# 使用函数
display_login_users
display_login_users "-m"
display_login_users "-q"
display_login_users "-b"
```

## 7. 常见问题与解决方案

### 7.1 问题：who: command not found
**解决方案**：安装 coreutils
- Ubuntu/Debian: `apt install coreutils`
- CentOS/RHEL: `yum install coreutils`

### 7.2 问题：无法显示用户信息
**解决方案**：确保系统正常运行

### 7.3 问题：who 命令执行缓慢
**解决方案**：系统负载较高，这是正常现象

## 8. 命令对比

| 命令 | 功能 | 适用场景 |
|------|------|----------|
| who | 显示登录用户 | 所有 Linux 系统 |
| w | 显示登录用户信息 | 所有 Linux 系统 |
| uptime | 显示系统运行时间 | 所有 Linux 系统 |
| last | 显示登录历史 | 所有 Linux 系统 |

## 9. 注意事项
- who 命令用于显示登录用户，是 Linux 系统中常用的系统监控命令之一
- who 命令可以显示当前登录到系统的用户信息
- 常用的操作包括：基本用法、只显示当前用户、显示登录用户数、显示系统启动时间等
- who 命令不需要 root 权限来执行
- who 命令支持多种选项，可以根据需要选择合适的选项
- who 命令是所有 Linux 系统的标准工具，用于显示登录用户