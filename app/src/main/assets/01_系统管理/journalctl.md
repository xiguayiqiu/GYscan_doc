# journalctl - 查看系统日志

## 1. 命令简介
journalctl 命令用于查看系统日志，是 Linux 系统中常用的系统管理命令之一。

## 2. 命令语法
```bash
journalctl [选项]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -u | 查看指定服务的日志 |
| -n | 显示最近的日志 |
| -f | 实时查看日志 |
| -p | 按优先级过滤 |
| --since | 从指定时间开始 |
| --until | 到指定时间结束 |
| --help | 显示帮助信息 |
| --version | 显示版本信息 |

## 4. 实战示例

### 4.1 查看系统日志
```bash
journalctl
```

### 4.2 查看指定服务的日志
```bash
journalctl -u service
```

### 4.3 实时查看日志
```bash
journalctl -f
```

### 4.4 显示最近的日志
```bash
journalctl -n 100
```

## 5. 注意事项
- journalctl 命令用于查看系统日志，是 systemd 系统的一部分
- journalctl 命令可以查看系统、服务和应用程序的日志
- journalctl 命令是一个常用的系统管理工具，用于系统故障排查