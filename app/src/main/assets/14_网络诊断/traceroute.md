# traceroute - 跟踪网络路径

## 1. 命令简介
traceroute 命令用于跟踪数据包从本地到目标主机的网络路径，是 Linux 系统中最常用的网络诊断工具之一。

## 2. 命令语法
```bash
traceroute [选项] 目标主机
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -n | 使用IP地址而不是主机名 |
| -p | 指定端口号 |
| -t | 设置TTL值 |
| -m | 设置最大跳数 |
| -q | 设置每个跳数的探测包数量 |
| -w | 设置超时时间（秒） |
| -4 | 使用IPv4 |
| -6 | 使用IPv6 |

## 4. 实战示例

### 4.1 跟踪网络路径
```bash
traceroute google.com
```

### 4.2 使用IP地址而不是主机名
```bash
traceroute -n google.com
```

### 4.3 指定最大跳数
```bash
traceroute -m 20 google.com
```

### 4.4 指定每个跳数的探测包数量
```bash
traceroute -q 3 google.com
```

### 4.5 设置超时时间
```bash
traceroute -w 2 google.com
```

### 4.6 使用IPv6
```bash
traceroute -6 ipv6.google.com
```

## 5. 注意事项
- traceroute 命令需要网络权限，在某些系统中可能需要root权限
- traceroute 通过发送不同TTL值的数据包来跟踪网络路径
- 如果某个节点不响应ICMP数据包，会显示为 * * *