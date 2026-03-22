# ping6 - IPv6网络测试

## 1. 命令简介
ping6 命令用于 IPv6 网络测试，是 Linux 系统中常用的网络工具命令之一。

## 2. 命令语法
```bash
ping6 [选项] [目标]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -c | 指定发送的包数 |
| -i | 指定发送间隔 |
| -s | 指定数据包大小 |
| -t | 设置TTL值 |
| -v | 显示详细信息 |
| --help | 显示帮助信息 |
| --version | 显示版本信息 |

## 4. 实战示例

### 4.1 测试IPv6网络连接
```bash
ping6 ipv6.google.com
```

### 4.2 指定发送的包数
```bash
ping6 -c 4 ipv6.google.com
```

### 4.3 指定发送间隔
```bash
ping6 -i 2 ipv6.google.com
```

### 4.4 指定数据包大小
```bash
ping6 -s 100 ipv6.google.com
```

## 5. 注意事项
- ping6 命令用于 IPv6 网络测试，检查目标主机是否可达
- ping6 命令与 ping 命令类似，但专门用于 IPv6 网络
- ping6 命令是一个常用的网络工具，用于测试 IPv6 网络连接