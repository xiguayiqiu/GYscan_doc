# wget - 网络下载工具

## 1. 命令简介
wget 命令用于网络下载，是 Linux 系统中常用的网络工具命令之一。

## 2. 命令语法
```bash
wget [选项] [URL]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -O | 指定输出文件 |
| -P | 指定保存目录 |
| -c | 断点续传 |
| -r | 递归下载 |
| -l | 指定递归深度 |
| -k | 转换链接 |
| -p | 下载页面所需的所有资源 |
| --help | 显示帮助信息 |
| --version | 显示版本信息 |

## 4. 实战示例

### 4.1 下载文件
```bash
wget https://example.com/file.txt
```

### 4.2 指定输出文件
```bash
wget -O output.txt https://example.com/file.txt
```

### 4.3 断点续传
```bash
wget -c https://example.com/file.txt
```

### 4.4 递归下载
```bash
wget -r https://example.com/
```

## 5. 注意事项
- wget 命令用于网络下载，支持HTTP、HTTPS、FTP等协议
- wget 命令是一个常用的网络工具，用于文件下载