# tracepath6 - IPv6网络路径跟踪

## 1. 命令简介
tracepath6 命令用于 IPv6 网络路径跟踪，是 Linux 系统中常用的网络工具命令之一。

## 2. 命令语法
```bash
tracepath6 [选项] [目标]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -n | 使用数字地址 |
| -m | 设置最大跳数 |
| -p | 指定端口 |
| --help | 显示帮助信息 |
| --version | 显示版本信息 |

## 4. 实战示例

### 4.1 跟踪IPv6网络路径
```bash
tracepath6 ipv6.google.com
```

### 4.2 使用数字地址
```bash
tracepath6 -n ipv6.google.com
```

### 4.3 设置最大跳数
```bash
tracepath6 -m 20 ipv6.google.com
```

### 4.4 指定端口
```bash
tracepath6 -p 80 ipv6.google.com
```

## 5. 注意事项
- tracepath6 命令用于 IPv6 网络路径跟踪，显示数据包从源到目标的路径
- tracepath6 命令与 traceroute6 命令类似，但不需要 root 权限
- tracepath6 命令是一个常用的网络工具，用于网络故障排查