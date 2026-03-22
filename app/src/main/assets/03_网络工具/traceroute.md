# traceroute - 跟踪网络路径

## 1. 命令简介
traceroute 命令用于跟踪网络路径，是 Linux 系统中常用的网络工具命令之一。

## 2. 命令语法
```bash
traceroute [选项] [目标]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -n | 使用数字地址 |
| -p | 指定端口 |
| -T | 使用TCP协议 |
| -U | 使用UDP协议 |
| -I | 使用ICMP协议 |
| -m | 设置最大跳数 |
| -q | 设置每跳的查询数 |
| --help | 显示帮助信息 |
| --version | 显示版本信息 |

## 4. 实战示例

### 4.1 跟踪网络路径
```bash
traceroute google.com
```

### 4.2 使用数字地址
```bash
traceroute -n google.com
```

### 4.3 使用TCP协议
```bash
traceroute -T google.com
```

### 4.4 设置最大跳数
```bash
traceroute -m 20 google.com
```

## 5. 注意事项
- traceroute 命令用于跟踪网络路径，显示数据包从源到目标的路径
- traceroute 命令通过发送不同TTL值的数据包来确定路径
- traceroute 命令是一个常用的网络工具，用于网络故障排查