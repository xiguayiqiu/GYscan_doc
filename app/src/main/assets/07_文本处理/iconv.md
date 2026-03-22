# iconv - 字符编码转换

## 1. 命令简介
iconv 命令用于字符编码转换，是 Linux 系统中常用的文本处理命令之一。

## 2. 命令语法
```bash
iconv [选项] [文件]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -f | 指定源编码 |
| -t | 指定目标编码 |
| -c | 忽略无效字符 |
| -o | 指定输出文件 |
| --list | 显示支持的编码 |

## 4. 实战示例

### 4.1 字符编码转换
```bash
iconv -f UTF-8 -t GBK file.txt -o output.txt
```

### 4.2 忽略无效字符
```bash
iconv -f UTF-8 -t GBK -c file.txt -o output.txt
```

### 4.3 显示支持的编码
```bash
iconv --list
```

## 5. 注意事项
- iconv 命令用于字符编码转换，支持多种编码格式
- 常见的编码格式包括 UTF-8、GBK、ISO-8859-1 等
- iconv 命令是一个常用的文本处理工具，用于处理不同编码的文本文件