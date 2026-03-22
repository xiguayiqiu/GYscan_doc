# curl - 网络请求工具

## 1. 命令简介
curl 命令用于网络请求，是 Linux 系统中常用的网络工具命令之一。

## 2. 命令语法
```bash
curl [选项] [URL]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -X | 指定请求方法 |
| -H | 添加请求头 |
| -d | 添加请求数据 |
| -o | 输出到文件 |
| -O | 以远程文件名保存 |
| -L | 跟随重定向 |
| -s | 静默模式 |
| -v | 详细输出 |
| --help | 显示帮助信息 |
| --version | 显示版本信息 |

## 4. 实战示例

### 4.1 发送GET请求
```bash
curl https://example.com
```

### 4.2 发送POST请求
```bash
curl -X POST -d "key=value" https://example.com
```

### 4.3 下载文件
```bash
curl -o file.txt https://example.com/file.txt
```

### 4.4 跟随重定向
```bash
curl -L https://example.com
```

## 5. 注意事项
- curl 命令用于网络请求，支持HTTP、HTTPS、FTP等协议
- curl 命令是一个常用的网络工具，用于文件下载和API测试