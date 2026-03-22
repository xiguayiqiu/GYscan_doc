# journalctl - 查询系统日志

## 1. 命令简介
journalctl 命令用于查询系统日志，是 Linux 系统中最常用的日志查看命令之一。

## 2. 命令语法
```bash
journalctl [选项]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -n | 显示最近的N条日志 |
| -f | 实时跟踪日志 |
| -p | 按优先级过滤日志 |
| -u | 按服务过滤日志 |
| -k | 显示内核日志 |
| -b | 显示当前启动的日志 |
| -S | 显示指定时间开始的日志 |
| -U | 显示指定时间结束的日志 |
| --since | 显示指定时间开始的日志 |
| --until | 显示指定时间结束的日志 |

## 4. 日志优先级
| 优先级 | 数值 | 说明 |
|--------|------|------|
| emerg | 0 | 紧急情况 |
| alert | 1 | 需要立即处理的问题 |
| crit | 2 | 严重问题 |
| err | 3 | 错误 |
| warning | 4 | 警告 |
| notice | 5 | 注意 |
| info | 6 | 信息 |
| debug | 7 | 调试 |

## 5. 实战示例

### 5.1 显示系统日志
```bash
journalctl
```

### 5.2 显示最近的100条日志
```bash
journalctl -n 100
```

### 5.3 实时跟踪日志
```bash
journalctl -f
```

### 5.4 按服务过滤日志
```bash
journalctl -u nginx
```

### 5.5 按优先级过滤日志
```bash
journalctl -p err
```

### 5.6 显示内核日志
```bash
journalctl -k
```

### 5.7 显示指定时间的日志
```bash
journalctl --since "2023-12-25 00:00:00" --until "2023-12-25 23:59:59"
```

## 6. 注意事项
- journalctl 命令需要 root 权限才能查看所有日志
- journalctl 是 systemd 系统的一部分，用于管理系统日志
- 使用 -f 选项可以实时跟踪日志，类似于 tail -f 命令