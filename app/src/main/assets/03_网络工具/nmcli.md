# nmcli 命令

## 命令说明

`nmcli` 是 NetworkManager 的命令行工具，用于管理网络连接和网络设备。它提供了丰富的命令和选项，允许用户在命令行中完成几乎所有的网络管理任务。

## 语法

```bash
nmcli [选项] [命令] [参数...]
```

## 常用命令

| 命令 | 描述 |
|------|------|
| `device` | 管理网络设备（显示、启用、禁用等） |
| `connection` | 管理网络连接（添加、修改、删除、激活等） |
| `networking` | 管理整体网络状态（启用、禁用） |
| `radio` | 管理无线设备状态（Wi-Fi、蓝牙等） |
| `agent` | 管理网络代理 |
| `monitor` | 监控网络状态变化 |
| `general` | 显示 NetworkManager 总体状态 |
| `help` | 显示帮助信息 |

## 常用选项

| 选项 | 描述 |
|------|------|
| `-a` | 自动询问密码 |
| `-c` | 设置输出颜色（auto、yes、no） |
| `-f` | 指定要显示的字段，多个字段用逗号分隔 |
| `-g` | 获取指定字段的值，用于脚本 |
| `-p` | 以表格形式显示输出 |
| `-t` | 以简洁形式显示输出，适合脚本使用 |
| `-v` | 显示版本信息 |
| `--ask` | 同 `-a`，自动询问密码 |
| `--color` | 同 `-c`，设置输出颜色 |
| `--fields` | 同 `-f`，指定要显示的字段 |
| `--get-values` | 同 `-g`，获取指定字段的值 |
| `--terse` | 同 `-t`，以简洁形式显示输出 |

## 设备管理命令

### 显示所有网络设备

```bash
nmcli device
```

### 显示设备详细信息

```bash
nmcli device show
nmcli device show eth0  # 显示特定设备的信息
```

### 启用网络设备

```bash
nmcli device connect eth0
```

### 禁用网络设备

```bash
nmcli device disconnect eth0
```

### 显示可用的 Wi-Fi 网络

```bash
nmcli device wifi list
```

### 连接到 Wi-Fi 网络

```bash
nmcli device wifi connect SSID password PASSWORD
```

### 连接到隐藏的 Wi-Fi 网络

```bash
nmcli device wifi connect SSID password PASSWORD hidden yes
```

## 连接管理命令

### 显示所有网络连接

```bash
nmcli connection
```

### 显示连接详细信息

```bash
nmcli connection show
nmcli connection show "Wired Connection"  # 显示特定连接的信息
```

### 创建新的以太网连接

```bash
nmcli connection add type ethernet ifname eth0 con-name "Wired Connection"
```

### 创建新的 Wi-Fi 连接

```bash
nmcli connection add type wifi ifname wlan0 con-name "Wi-Fi Connection" ssid SSID
```

### 修改连接设置

```bash
# 修改 IP 地址
nmcli connection modify "Wired Connection" ipv4.addresses 192.168.1.100/24

# 修改网关
nmcli connection modify "Wired Connection" ipv4.gateway 192.168.1.1

# 修改 DNS
nmcli connection modify "Wired Connection" ipv4.dns "8.8.8.8,8.8.4.4"

# 修改 IP 获取方式为手动
nmcli connection modify "Wired Connection" ipv4.method manual

# 修改 IP 获取方式为自动（DHCP）
nmcli connection modify "Wired Connection" ipv4.method auto
```

### 激活网络连接

```bash
nmcli connection up "Wired Connection"
```

### 停用网络连接

```bash
nmcli connection down "Wired Connection"
```

### 删除网络连接

```bash
nmcli connection delete "Wired Connection"
```

### 重新加载连接配置

```bash
nmcli connection reload
```

## 网络状态管理

### 启用网络

```bash
nmcli networking on
```

### 禁用网络

```bash
nmcli networking off
```

### 检查网络状态

```bash
nmcli networking status
```

## 无线设备管理

### 显示无线设备状态

```bash
nmcli radio
```

### 启用 Wi-Fi

```bash
nmcli radio wifi on
```

### 禁用 Wi-Fi

```bash
nmcli radio wifi off
```

### 启用蓝牙

```bash
nmcli radio bluetooth on
```

### 禁用蓝牙

```bash
nmcli radio bluetooth off
```

## 监控网络状态

### 监控网络状态变化

```bash
nmcli monitor
```

### 监控特定设备的状态变化

```bash
nmcli monitor device eth0
```

### 监控特定连接的状态变化

```bash
nmcli monitor connection "Wired Connection"
```

## 高级用法

### 创建 VPN 连接

```bash
# 创建 OpenVPN 连接
nmcli connection add type vpn con-name "VPN Connection" vpn.type openvpn vpn.gateway vpn.example.com vpn.user username

# 设置 VPN 密码
nmcli connection modify "VPN Connection" vpn.secrets password=PASSWORD
```

### 创建桥接连接

```bash
# 创建桥接接口
nmcli connection add type bridge con-name "Bridge Connection" ifname br0

# 将以太网接口添加到桥接
nmcli connection add type bridge-slave con-name "Bridge Slave" ifname eth0 master br0
```

### 创建 VLAN 连接

```bash
nmcli connection add type vlan con-name "VLAN 10" ifname eth0.10 vlan.id 10 vlan.interface eth0
```

### 使用 nmcli 脚本化网络管理

```bash
#!/bin/bash

# 检查网络连接状态
if nmcli networking status | grep -q "enabled"; then
    echo "网络已启用"
else
    echo "网络已禁用，正在启用..."
    nmcli networking on
fi

# 检查 Wi-Fi 状态
if nmcli radio wifi | grep -q "enabled"; then
    echo "Wi-Fi 已启用"
else
    echo "Wi-Fi 已禁用"
fi

# 显示当前活动连接
echo "当前活动连接："
nmcli connection show --active
```

## 常见问题及解决方法

### 问题1：nmcli 命令执行失败

**原因**：可能是 NetworkManager 服务未运行或权限不足

**解决方法**：
- 检查 NetworkManager 服务状态：
  ```bash
  sudo systemctl status NetworkManager
  ```
- 如果服务未运行，启动它：
  ```bash
  sudo systemctl start NetworkManager
  ```
- 确保使用 sudo 或 root 权限执行需要管理员权限的命令

### 问题2：无法连接到 Wi-Fi 网络

**原因**：可能是 Wi-Fi 未启用或密码错误

**解决方法**：
- 检查 Wi-Fi 状态：
  ```bash
  nmcli radio wifi
  ```
- 如果 Wi-Fi 未启用，启用它：
  ```bash
  nmcli radio wifi on
  ```
- 确保输入正确的 Wi-Fi 密码
- 检查 Wi-Fi 信号强度：
  ```bash
  nmcli device wifi list
  ```

### 问题3：网络连接速度慢

**原因**：可能是网络配置问题或信号强度问题

**解决方法**：
- 检查网络设备状态：
  ```bash
  nmcli device status
  ```
- 检查连接详细信息：
  ```bash
  nmcli connection show "Wired Connection" | grep -i speed
  ```
- 对于 Wi-Fi，检查信号强度：
  ```bash
  nmcli device wifi list | grep -i signal
  ```

### 问题4：无法获取 IP 地址

**原因**：可能是 DHCP 服务器问题或网络配置错误

**解决方法**：
- 检查 DHCP 配置：
  ```bash
  nmcli connection show "Wired Connection" | grep -i dhcp
  ```
- 尝试重新获取 IP 地址：
  ```bash
  nmcli connection down "Wired Connection" && nmcli connection up "Wired Connection"
  ```
- 检查网络设备是否正确识别：
  ```bash
  nmcli device
  ```

## 注意事项

- `nmcli` 是 NetworkManager 的命令行工具，提供了完整的网络管理功能
- 可以使用 `nmcli help` 查看详细的命令帮助
- 可以使用 `nmcli [命令] help` 查看特定命令的帮助，如 `nmcli device help`
- 大部分 `nmcli` 命令需要 root 权限执行
- `nmcli` 命令的输出格式可以通过 `-c`、`-p`、`-t` 等选项控制，适合不同的使用场景
- `nmcli` 支持脚本化操作，是自动化网络管理的理想工具
- 所有通过 `nmcli` 创建的连接都会被保存在 `/etc/NetworkManager/system-connections/` 目录中
- 可以通过编辑 `/etc/NetworkManager/system-connections/` 目录中的配置文件来手动修改连接设置，但建议使用 `nmcli` 命令进行修改

## 相关命令

- `nmtui`：NetworkManager 的文本用户界面工具
- `nm-connection-editor`：NetworkManager 的图形界面工具
- `nm-online`：检查网络连接状态的工具
- `NetworkManager`：网络管理服务本身
- `ip`：Linux 网络配置命令
- `ifconfig`：传统的网络配置命令（已被 ip 命令替代）