# whois - 查询域名信息

## 1. 命令简介
whois 命令用于查询域名信息，是 Linux 系统中常用的网络工具命令之一。

## 2. 命令语法
```bash
whois [选项] [域名]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -h | 指定whois服务器 |
| -p | 指定端口 |
| -v | 详细输出 |
| --help | 显示帮助信息 |
| --version | 显示版本信息 |

## 4. 实战示例

### 4.1 查询域名信息
```bash
whois example.com
```

### 4.2 指定whois服务器
```bash
whois -h whois.verisign-grs.com example.com
```

### 4.3 详细输出
```bash
whois -v example.com
```

## 5. 注意事项
- whois 命令用于查询域名信息，包括注册人、注册日期、到期日期等
- whois 命令是一个常用的网络工具，用于域名信息查询