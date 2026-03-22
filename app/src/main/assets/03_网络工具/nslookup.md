# nslookup - DNS查询

## 1. 命令简介
nslookup 命令用于 DNS 查询，是 Linux 系统中常用的网络工具命令之一。

## 2. 命令语法
```bash
nslookup [选项] [域名]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -type | 指定查询类型 |
| -debug | 启用调试模式 |
| -sil | 静默模式 |
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
nslookup example.com
```

### 5.2 查询域名的IPv6地址
```bash
nslookup -type=AAAA example.com
```

### 5.3 反向查询
```bash
nslookup 8.8.8.8
```

### 5.4 查询邮件服务器
```bash
nslookup -type=MX example.com
```

## 6. 注意事项
- nslookup 命令用于 DNS 查询，获取域名的各种记录信息
- nslookup 命令是一个常用的网络工具，用于 DNS 故障排查