# resolvectl命令

## 命令简介

`resolvectl`命令是systemd-resolved服务的控制工具，用于管理系统的DNS解析设置，它可以显示和修改DNS解析配置、查看DNS缓存等。

## 语法

```bash
resolvectl [选项] 命令 [参数]
```

## 主要命令

| 命令 | 描述 |
|------|------|
| `status` | 显示解析器状态 |
| `query` | 查询DNS记录 |
| `service` | 管理解析器服务 |
| `flush-caches` | 刷新DNS缓存 |
| `statistics` | 显示DNS统计信息 |
| `monitor` | 监控解析器事件 |

## 选项

| 选项 | 描述 |
|------|------|
| `-h`, `--help` | 显示帮助信息 |
| `-V`, `--version` | 显示版本信息 |
| `--no-pager` | 不使用分页器显示输出 |
| `--no-legend` | 不显示图例 |

## 示例

### 显示解析器状态

```bash
resolvectl status
```

### 查询DNS记录

```bash
# 查询A记录
resolvectl query www.google.com

# 查询MX记录
resolvectl query -t MX gmail.com

# 查询NS记录
resolvectl query -t NS google.com
```

### 刷新DNS缓存

```bash
resolvectl flush-caches
```

### 显示DNS统计信息

```bash
resolvectl statistics
```

### 监控解析器事件

```bash
resolvectl monitor
```

## 高级用法

### 管理DNS服务器

```bash
# 为特定接口设置DNS服务器
resolvectl dns eth0 8.8.8.8 8.8.4.4

# 为特定接口设置搜索域
resolvectl domain eth0 example.com

# 显示特定接口的DNS配置
resolvectl status eth0
```

### 管理LLMNR和mDNS

```bash
# 启用LLMNR
resolvectl llmnr yes

# 禁用mDNS
resolvectl mdns no
```

## 常见问题

### 问题：resolvectl命令不存在

**原因**：系统中没有安装systemd-resolved服务。

**解决方法**：安装systemd-resolved服务，或使用其他DNS管理工具。

### 问题：DNS解析失败

**原因**：可能是DNS服务器配置错误、网络连接问题或DNS缓存问题。

**解决方法**：检查DNS服务器配置，刷新DNS缓存，或尝试使用其他DNS服务器。

## 命令对比

| 命令 | 功能 | 特点 |
|------|------|------|
| `resolvectl` | 管理DNS解析 | 现代的DNS管理工具，集成在systemd中 |
| `nslookup` | 查询DNS记录 | 传统的DNS查询工具 |
| `dig` | 查询DNS记录 | 功能强大的DNS查询工具 |
| `host` | 查询DNS记录 | 简单的DNS查询工具 |

## 注意事项

1. **权限要求**：修改DNS配置需要root权限。

2. **服务依赖**：resolvectl命令依赖于systemd-resolved服务，需要确保该服务正在运行。

3. **网络配置**：修改DNS配置后，可能需要重启网络服务才能生效。

4. **DNS缓存**：DNS缓存可能会影响DNS查询结果，必要时可以刷新缓存。

5. **适用场景**：resolvectl命令适用于管理系统DNS解析配置、查询DNS记录和监控DNS解析活动等场景。