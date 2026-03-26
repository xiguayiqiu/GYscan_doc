# journalctl - 查询系统日志

## 1. 命令简介
journalctl 命令用于查询系统日志，是 Linux 系统中常用的系统管理命令之一。它是 systemd 系统的一部分，用于查看和管理 systemd 日志。

## 2. 命令语法
```bash
journalctl [选项] [参数...]
```

## 3. 常用选项

| 选项 | 说明 |
|------|------|
| -h, --help | 显示帮助信息 |
| --version | 显示版本信息 |
| -u, --unit=<单元> | 显示指定单元的日志 |
| -k, --dmesg | 显示内核日志 |
| -b, --boot[=<ID>] | 显示指定启动的日志 |
| -p, --priority=<级别> | 显示指定优先级的日志 |
| -f, --follow | 实时跟踪日志 |
| -n, --lines=<行数> | 显示最后 N 行日志 |
| --since=<时间> | 显示指定时间之后的日志 |
| --until=<时间> | 显示指定时间之前的日志 |
| -o, --output=<格式> | 设置输出格式 |
| --no-pager | 不使用分页器 |
| --no-hostname | 不显示主机名 |

## 4. 日志优先级

| 优先级 | 名称 | 说明 |
|--------|------|------|
| 0 | emerg | 紧急情况 |
| 1 | alert | 需要立即处理的问题 |
| 2 | crit | 严重问题 |
| 3 | err | 错误 |
| 4 | warning | 警告 |
| 5 | notice | 通知 |
| 6 | info | 信息 |
| 7 | debug | 调试 |

## 5. 实战示例

### 5.1 查看所有日志
```bash
journalctl
```

### 5.2 查看指定服务的日志
```bash
# 查看 nginx 服务的日志
journalctl -u nginx

# 实时跟踪 nginx 服务的日志
journalctl -u nginx -f
```

### 5.3 查看内核日志
```bash
journalctl -k
```

### 5.4 查看指定启动的日志
```bash
# 查看当前启动的日志
journalctl -b

# 查看上一次启动的日志
journalctl -b -1
```

### 5.5 查看指定优先级的日志
```bash
# 查看错误及以上级别的日志
journalctl -p err

# 查看警告及以上级别的日志
journalctl -p warning
```

### 5.6 查看指定时间范围的日志
```bash
# 查看今天的日志
journalctl --since today

# 查看昨天的日志
journalctl --since yesterday --until today

# 查看指定时间范围的日志
journalctl --since "2023-01-01 00:00:00" --until "2023-01-01 23:59:59"
```

### 5.7 查看指定行数的日志
```bash
# 查看最后 100 行日志
journalctl -n 100

# 查看最后 50 行 nginx 服务的日志
journalctl -u nginx -n 50
```

### 5.8 按输出格式查看日志
```bash
# 以 JSON 格式输出
journalctl -o json

# 以简洁格式输出
journalctl -o short

# 以详细格式输出
journalctl -o verbose
```

## 6. 高级用法

### 6.1 搜索日志
```bash
# 搜索包含 "error" 的日志
journalctl | grep error

# 搜索 nginx 服务中包含 "error" 的日志
journalctl -u nginx | grep error
```

### 6.2 导出日志
```bash
# 导出所有日志到文件
journalctl > all.log

# 导出 nginx 服务的日志到文件
journalctl -u nginx > nginx.log
```

### 6.3 清理日志
```bash
# 清理超过 2 周的日志
sudo journalctl --vacuum-time=2w

# 清理日志，保留 100MB
sudo journalctl --vacuum-size=100M
```

### 6.4 查看日志统计信息
```bash
# 查看日志磁盘使用情况
sudo journalctl --disk-usage

# 查看日志文件列表
sudo journalctl --list-boots
```

### 6.5 与其他命令结合使用
```bash
# 查看系统启动时间
journalctl -b -n 1 | grep "Startup finished"

# 查看服务启动失败的原因
journalctl -u nginx | grep "Failed"

# 查看登录失败的记录
journalctl | grep "Failed password"
```

## 7. 常见问题与解决方案

### 7.1 问题：journalctl: command not found
**解决方案**：安装 systemd-journald
- Ubuntu/Debian: `apt install systemd-journald`
- CentOS/RHEL: `yum install systemd-journald`

### 7.2 问题：无法查看日志
**解决方案**：确保有足够的权限
```bash
sudo journalctl
```

### 7.3 问题：日志文件过大
**解决方案**：清理日志
```bash
sudo journalctl --vacuum-time=1w
```

### 7.4 问题：日志显示不完整
**解决方案**：使用 --no-pager 选项
```bash
journalctl --no-pager
```

### 7.5 问题：无法实时跟踪日志
**解决方案**：使用 -f 选项
```bash
journalctl -f
```

## 8. 命令对比

| 命令 | 功能 | 适用场景 |
|------|------|----------|
| journalctl | 查询系统日志 | systemd 系统 |
| dmesg | 查看内核日志 | 所有 Linux 系统 |
| cat | 查看日志文件 | 所有 Linux 系统 |
| grep | 搜索日志内容 | 所有 Linux 系统 |
| logwatch | 分析系统日志 | 所有 Linux 系统 |

## 9. 注意事项
- journalctl 命令用于查询系统日志，是 Linux 系统中常用的系统管理命令之一
- journalctl 命令是 systemd 系统的一部分，用于查看和管理 systemd 日志
- 常用的操作包括：查看所有日志、查看指定服务的日志、查看内核日志、查看指定启动的日志等
- journalctl 命令支持多种过滤选项，可以根据时间、优先级、服务等条件过滤日志
- journalctl 命令需要 root 权限来查看所有日志
- journalctl 命令的日志存储在 /var/log/journal/ 目录中
- journalctl 命令是现代 Linux 系统的标准工具，替代了传统的日志查看命令