# scp - 安全文件传输

## 1. 命令简介
scp 命令用于安全文件传输，是 Linux 系统中常用的网络工具命令之一。

## 2. 命令语法
```bash
scp [选项] [源文件] [目标文件]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -P | 指定端口 |
| -r | 递归传输 |
| -v | 详细输出 |
| -p | 保留文件属性 |
| -q | 安静模式 |
| --help | 显示帮助信息 |
| --version | 显示版本信息 |

## 4. 实战示例

### 4.1 本地文件传输到远程服务器
```bash
scp file.txt user@remote:/path/to/destination
```

### 4.2 远程服务器文件传输到本地
```bash
scp user@remote:/path/to/file.txt /path/to/destination
```

### 4.3 递归传输目录
```bash
scp -r directory/ user@remote:/path/to/destination
```

### 4.4 指定端口
```bash
scp -P 2222 file.txt user@remote:/path/to/destination
```

## 5. 注意事项
- scp 命令用于安全文件传输，基于SSH协议
- scp 命令是一个常用的网络工具，用于文件传输