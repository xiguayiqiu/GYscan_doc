# timedatectl - 控制系统时间和日期

## 1. 命令简介
timedatectl 命令用于控制系统时间和日期，是 Linux 系统中常用的时间日期命令之一。

## 2. 命令语法
```bash
timedatectl [选项] [命令]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -h | 显示帮助信息 |
| --version | 显示版本信息 |

## 4. 常用命令
| 命令 | 说明 |
|------|------|
| status | 显示当前时间和日期状态 |
| set-time | 设置系统时间 |
| set-timezone | 设置系统时区 |
| set-local-rtc | 设置本地RTC |
| set-ntp | 设置NTP同步 |

## 5. 实战示例

### 5.1 显示当前时间和日期状态
```bash
timedatectl status
```

### 5.2 设置系统时间
```bash
timedatectl set-time "2024-01-01 12:00:00"
```

### 5.3 设置系统时区
```bash
timedatectl set-timezone Asia/Shanghai
```

### 5.4 设置NTP同步
```bash
timedatectl set-ntp true
```

## 6. 注意事项
- timedatectl 命令用于控制系统时间和日期
- timedatectl 命令是 systemd 系统的一部分
- timedatectl 命令需要 root 权限
- timedatectl 命令是一个常用的系统管理工具，用于管理时间和日期