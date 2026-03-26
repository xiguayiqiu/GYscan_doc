# nm-dispatcher 命令

## 命令说明

`nm-dispatcher` 是 NetworkManager 的事件调度器，用于在网络状态变化时执行特定的脚本。

## 语法

```bash
nm-dispatcher [选项]
```

## 常用选项

| 选项 | 描述 |
|------|------|
| `-h` | 显示帮助信息 |
| `-V` | 显示版本信息 |
| `-v` | 详细输出 |
| `-l` | 日志级别 |
| `-p` | 不使用 polkit 进行权限检查 |

## 工作原理

`nm-dispatcher` 会在以下网络事件发生时执行相应的脚本：

1. 网络设备状态变化
2. 网络连接状态变化
3. 网络连接激活或停用
4. 网络连接配置变化

## 脚本目录

`nm-dispatcher` 会在以下目录中查找并执行脚本：

- `/etc/NetworkManager/dispatcher.d/` - 系统级脚本目录
- `/usr/lib/NetworkManager/dispatcher.d/` - 系统默认脚本目录

## 脚本命名规则

脚本文件名通常以数字开头，用于确定执行顺序，例如：

- `00-netplan` - 网络配置脚本
- `10-glib-networking` - GLib 网络配置脚本
- `20-ntpd` - NTP 服务配置脚本

## 脚本参数

`nm-dispatcher` 会向脚本传递以下参数：

1. 设备名称（如 `eth0`、`wlan0` 等）
2. 事件类型（如 `up`、`down`、`pre-up`、`pre-down` 等）

## 示例脚本

### 网络连接激活时执行的脚本

```bash
#!/bin/bash

# /etc/NetworkManager/dispatcher.d/99-custom

INTERFACE=$1
ACTION=$2

if [ "$ACTION" = "up" ]; then
    # 网络连接激活时执行的命令
    echo "Network $INTERFACE is up" >> /var/log/nm-dispatcher.log
    # 例如，启动服务或配置防火墙
    systemctl restart sshd
fi
```

## 注意事项

- `nm-dispatcher` 是 NetworkManager 的事件调度器，用于在网络状态变化时执行脚本
- 脚本需要具有可执行权限
- 脚本执行顺序由文件名的数字前缀决定
- 脚本执行时间不应过长，否则可能会影响网络连接的建立
- 可以使用 `nm-dispatcher` 来实现网络状态变化时的自动配置，如启动服务、配置防火墙等