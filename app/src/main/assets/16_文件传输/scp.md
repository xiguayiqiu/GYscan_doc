# scp - 安全复制文件

## 1. 命令简介
scp 命令用于在网络上安全地复制文件，是 Linux 系统中最常用的文件传输工具之一。

## 2. 命令语法
```bash
scp [选项] 源文件 目标文件
scp [选项] 源文件... 目标目录
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -r | 递归复制目录 |
| -P | 指定端口号 |
| -p | 保留文件的权限、所有者、时间戳等属性 |
| -v | 详细模式，显示复制的进度 |
| -C | 启用压缩 |
| -i | 指定身份文件（私钥） |

## 4. 实战示例

### 4.1 复制文件到远程服务器
```bash
scp file.txt user@remote:/path/to/destination/
```

### 4.2 从远程服务器复制文件
```bash
scp user@remote:/path/to/file.txt /local/path/
```

### 4.3 递归复制目录
```bash
scp -r directory/ user@remote:/path/to/destination/
```

### 4.4 指定端口号
```bash
scp -P 2222 file.txt user@remote:/path/to/destination/
```

### 4.5 使用压缩
```bash
scp -C file.txt user@remote:/path/to/destination/
```

### 4.6 使用身份文件
```bash
scp -i ~/.ssh/id_rsa file.txt user@remote:/path/to/destination/
```

## 5. 注意事项
- scp 命令基于 SSH 协议，需要远程服务器运行 SSH 服务
- 复制大文件时，使用 -v 选项可以查看复制进度
- 使用 -i 选项可以指定私钥文件，避免输入密码