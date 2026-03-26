# ip命令

## 命令简介

`ip`命令是Linux系统中用于显示和配置网络接口、路由表、ARP缓存等网络相关信息的强大工具，它是`ifconfig`命令的现代替代品。

## 语法

```bash
ip [选项] 命令 [参数]
```

## 主要命令

| 命令 | 描述 |
|------|------|
| `link` | 管理网络接口 |
| `addr` | 管理IP地址 |
| `route` | 管理路由表 |
| `neigh` | 管理ARP缓存 |
| `tunnel` | 管理IP隧道 |
| `maddr` | 管理多播地址 |
| `mroute` | 管理多播路由 |
| `netns` | 管理网络命名空间 |

## 选项

| 选项 | 描述 |
|------|------|
| `-h`, `--help` | 显示帮助信息 |
| `-V`, `--version` | 显示版本信息 |
| `-s`, `--stats` | 显示详细统计信息 |
| `-d`, `--details` | 显示详细信息 |
| `-f`, `--family <协议>` | 指定协议族（inet、inet6、link） |
| `-l`, `--loops <次数>` | 指定循环次数 |
| `-o`, `--oneline` | 每行显示一个记录 |
| `-r`, `--resolve` | 解析主机名 |

## 示例

### 显示网络接口信息

```bash
# 显示所有网络接口
ip link show

# 显示指定网络接口
ip link show eth0
```

### 配置网络接口

```bash
# 激活网络接口
ip link set eth0 up

# 禁用网络接口
ip link set eth0 down

# 修改网络接口MTU
ip link set eth0 mtu 1500

# 修改网络接口MAC地址
ip link set eth0 address 00:11:22:33:44:55
```

### 管理IP地址

```bash
# 添加IP地址
ip addr add 192.168.1.100/24 dev eth0

# 删除IP地址
ip addr del 192.168.1.100/24 dev eth0

# 显示IP地址
ip addr show

# 显示指定接口的IP地址
ip addr show eth0
```

### 管理路由表

```bash
# 添加默认路由
ip route add default via 192.168.1.1 dev eth0

# 添加静态路由
ip route add 10.0.0.0/8 via 192.168.1.2 dev eth0

# 删除路由
ip route del 10.0.0.0/8

# 显示路由表
ip route show
```

### 管理ARP缓存

```bash
# 显示ARP缓存
ip neigh show

# 添加ARP条目
ip neigh add 192.168.1.1 lladdr 00:11:22:33:44:55 dev eth0

# 删除ARP条目
ip neigh del 192.168.1.1 dev eth0

# 刷新ARP缓存
ip neigh flush dev eth0
```

## 高级用法

### 管理网络命名空间

```bash
# 创建网络命名空间
ip netns add testns

# 在命名空间中执行命令
ip netns exec testns ip addr show

# 删除网络命名空间
ip netns del testns
```

### 配置VLAN接口

```bash
# 创建VLAN接口
ip link add link eth0 name eth0.100 type vlan id 100

# 激活VLAN接口
ip link set eth0.100 up

# 为VLAN接口添加IP地址
ip addr add 192.168.100.1/24 dev eth0.100
```

## 常见问题

### 问题：ip命令执行失败，提示权限不足

**原因**：修改网络配置需要root权限。

**解决方法**：使用sudo或以root用户身份执行ip命令。

### 问题：添加的IP地址在系统重启后丢失

**原因**：使用ip命令添加的IP地址是临时的，系统重启后会恢复默认配置。

**解决方法**：将网络配置添加到网络配置文件中，如`/etc/network/interfaces`或`/etc/sysconfig/network-scripts/`目录下的配置文件。

## 命令对比

| 命令 | 功能 | 特点 |
|------|------|------|
| `ip` | 网络配置工具 | 功能强大，支持更多网络配置选项 |
| `ifconfig` | 网络接口配置 | 传统工具，功能相对有限 |
| `route` | 路由管理 | 专门用于路由表管理 |
| `arp` | ARP缓存管理 | 专门用于ARP缓存管理 |

## 注意事项

1. **权限要求**：修改网络配置需要root权限。

2. **临时配置**：使用ip命令进行的配置在系统重启后会丢失，需要保存到配置文件中。

3. **命令复杂度**：ip命令功能强大，但语法相对复杂，需要熟悉各种子命令和选项。

4. **兼容性**：ip命令在现代Linux系统中已经成为标准工具，但在一些老系统中可能需要单独安装。

5. **网络中断**：修改网络配置时要小心，避免导致网络连接中断，特别是在远程管理服务器时。