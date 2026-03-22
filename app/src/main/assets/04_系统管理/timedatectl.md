# timedatectl - 控制系统时间和日期

## 1. 命令简介
timedatectl 命令用于控制系统的时间和日期，是 Linux 系统中最常用的时间管理工具之一。

## 2. 命令语法
```bash
timedatectl [选项] [命令]
```

## 3. 常用命令
| 命令 | 说明 |
|------|------|
| status | 显示时间和日期状态 |
| set-time | 设置系统时间 |
| set-timezone | 设置系统时区 |
| set-local-rtc | 设置本地实时时钟 |
| set-ntp | 设置NTP同步 |

## 4. 实战示例

### 4.1 显示时间和日期状态
```bash
timedatectl status
```

### 4.2 设置系统时间
```bash
sudo timedatectl set-time "2023-12-25 12:00:00"
```

### 4.3 设置系统时区
```bash
sudo timedatectl set-timezone Asia/Shanghai
```

### 4.4 启用NTP同步
```bash
sudo timedatectl set-ntp true
```

### 4.5 禁用NTP同步
```bash
sudo timedatectl set-ntp false
```

### 4.6 列出可用的时区
```bash
timedatectl list-timezones
```

## 5. 注意事项
- timedatectl 命令需要 root 权限，使用 sudo 执行
- 使用 set-timezone 命令可以设置系统的时区
- 使用 set-ntp 命令可以启用或禁用NTP同步，以自动同步系统时间