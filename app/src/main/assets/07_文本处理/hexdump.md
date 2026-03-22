# hexdump - 十六进制转储

## 1. 命令简介
hexdump 命令用于十六进制转储，是 Linux 系统中常用的文本处理命令之一。

## 2. 命令语法
```bash
hexdump [选项] [文件]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -C | 显示ASCII字符 |
| -b | 以字节为单位显示 |
| -c | 以字符为单位显示 |
| -d | 以双字为单位显示 |
| -x | 以双字节为单位显示 |
| -s | 跳过指定字节数 |
| -n | 只显示指定字节数 |

## 4. 实战示例

### 4.1 十六进制转储
```bash
hexdump file.txt
```

### 4.2 显示ASCII字符
```bash
hexdump -C file.txt
```

### 4.3 以字节为单位显示
```bash
hexdump -b file.txt
```

### 4.4 跳过指定字节数
```bash
hexdump -s 10 file.txt
```

## 5. 注意事项
- hexdump 命令用于十六进制转储，显示文件的二进制内容
- hexdump 命令可以以不同的格式显示文件内容
- hexdump 命令是一个常用的二进制文件查看工具