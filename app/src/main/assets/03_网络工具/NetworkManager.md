# NetworkManager 命令

## 命令说明

`NetworkManager` 是 Linux 系统中用于管理网络连接的系统服务，它提供了统一的网络管理接口，支持有线、无线和移动网络连接。

## 功能特性

- 自动检测和配置网络设备
- 支持有线以太网连接
- 支持 Wi-Fi 无线网络连接
- 支持移动网络连接（3G/4G）
- 支持 VPN 连接
- 支持网络连接的自动切换
- 提供命令行工具 `nmcli` 和文本界面工具 `nmtui`
- 提供图形界面工具 `nm-connection-editor`

## 相关命令

| 命令 | 描述 |
|------|------|
| `nmcli` | NetworkManager 命令行工具 |
| `nmtui` | NetworkManager 文本界面工具 |
| `nm-connection-editor` | NetworkManager 图形界面工具 |
| `nm-online` | 检查网络连接状态 |
| `nm-dispatcher` | NetworkManager 事件调度器 |

## 服务管理

### 启动 NetworkManager 服务

```bash
systemctl start NetworkManager
```

### 停止 NetworkManager 服务

```bash
systemctl stop NetworkManager
```

### 重启 NetworkManager 服务

```bash
systemctl restart NetworkManager
```

### 查看 NetworkManager 服务状态

```bash
systemctl status NetworkManager
```

### 设置 NetworkManager 服务开机自启

```bash
systemctl enable NetworkManager
```

## 配置文件

NetworkManager 的配置文件主要位于以下目录：

- `/etc/NetworkManager/` - 主配置目录
- `/etc/NetworkManager/NetworkManager.conf` - 主配置文件
- `/etc/NetworkManager/system-connections/` - 网络连接配置文件

## 示例配置

### 基本配置示例

```ini
# /etc/NetworkManager/NetworkManager.conf
[main]
dns=none
[logging]
level=INFO
```

### 禁用网络管理的接口

```ini
# /etc/NetworkManager/NetworkManager.conf
[main]
plugins=ifupdown,keyfile
[ifupdown]
managed=false
```

## 注意事项

- NetworkManager 是现代 Linux 发行版中默认的网络管理服务
- 它替代了传统的网络管理方式，提供了更统一和灵活的网络管理接口
- NetworkManager 会自动管理网络连接，包括有线、无线和移动网络
- 可以使用 `nmcli` 命令行工具来配置和管理网络连接
- 可以使用 `nmtui` 文本界面工具来交互式地配置网络连接
- 可以使用 `nm-connection-editor` 图形界面工具来配置网络连接