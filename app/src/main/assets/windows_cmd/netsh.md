# netsh命令

## 命令简介

`netsh`命令是Windows中的一个命令，用于网络配置命令。

## 语法

```cmd
netsh [上下文] [子命令] [选项]
```

## 上下文

| 上下文 | 描述 |
|--------|------|
| `advfirewall` | 高级防火墙 |
| `branchcache` | 分支缓存 |
| `bridge` | 网络桥接 |
| `dhcpclient` | DHCP客户端 |
| `dnsclient` | DNS客户端 |
| `firewall` | 防火墙 |
| `http` | HTTP设置 |
| `interface` | 网络接口 |
| `ipsec` | IP安全 |
| `lan` | 局域网 |
| `namespace` | 命名空间 |
| `ras` | 远程访问服务 |
| `rpc` | 远程过程调用 |
| `trace` | 网络跟踪 |
| `wfp` | Windows筛选平台 |
| `wins` | WINS服务 |

## 示例

### 网络配置

```cmd
# 显示网络接口
netsh interface show interface

# 配置IP地址
netsh interface ipv4 set address "本地连接" static 192.168.1.100 255.255.255.0 192.168.1.1

# 配置DNS服务器
netsh interface ipv4 set dns "本地连接" static 8.8.8.8

# 显示防火墙状态
netsh advfirewall show allprofiles

# 配置防火墙规则
netsh advfirewall firewall add rule name="Allow HTTP" dir=in action=allow protocol=TCP localport=80
```

## 高级用法

### 批量网络配置

```cmd
# 创建一个批处理文件
@echo off

# 批量网络配置
echo 显示网络接口
netsh interface show interface

echo 配置IP地址
netsh interface ipv4 set address "本地连接" static 192.168.1.100 255.255.255.0 192.168.1.1

echo 配置DNS服务器
netsh interface ipv4 set dns "本地连接" static 8.8.8.8

echo 操作完成
```

## 常见问题

### 问题：netsh命令执行失败

**原因**：可能是权限不足，或者命令语法错误。

**解决方法**：以管理员身份运行命令提示符，确保命令语法正确。

### 问题：网络配置失败

**原因**：可能是网络连接问题，或者权限不足。

**解决方法**：确保网络连接正常，以管理员身份运行命令提示符。

## 命令对比

| 命令 | 功能 | 特点 |
|------|------|------|
| `netsh` | 网络配置命令 | 用于网络配置管理 |
| `ipconfig` | 显示网络配置 | 用于网络配置管理 |
| `netcfg` | 网络配置 | 用于网络配置 |

## 注意事项

1. **权限要求**：使用`netsh`命令需要管理员权限。

2. **网络连接**：需要确保网络连接正常。

3. **适用场景**：`netsh`命令适用于网络配置管理的场景。