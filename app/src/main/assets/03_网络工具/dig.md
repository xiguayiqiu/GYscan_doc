# dig - DNS查询

## 1. 命令简介
dig 命令用于 DNS 查询，是 Linux 系统中常用的网络工具命令之一。

## 2. 命令语法
```bash
dig [选项] [域名]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -t | 指定查询类型 |
| -x | 反向查询 |
| -4 | 使用IPv4 |
| -6 | 使用IPv6 |
| +short | 简洁输出 |
| +trace | 跟踪查询过程 |
| --help | 显示帮助信息 |
| --version | 显示版本信息 |

## 4. 常用查询类型
| 类型 | 说明 |
|------|------|
| A | IPv4地址 |
| AAAA | IPv6地址 |
| MX | 邮件服务器 |
| NS | 域名服务器 |
| CNAME | 别名记录 |
| TXT | 文本记录 |

## 5. 实战示例

### 5.1 查询域名的IPv4地址
```bash
dig example.com
```

### 5.2 查询域名的IPv6地址
```bash
dig -t AAAA example.com
```

### 5.3 反向查询
```bash
dig -x 8.8.8.8
```

### 5.4 简洁输出
```bash
dig +short example.com
```

## 6. 注意事项
- dig 命令用于 DNS 查询，获取域名的各种记录信息
- dig 命令是一个常用的网络工具，用于 DNS 故障排查