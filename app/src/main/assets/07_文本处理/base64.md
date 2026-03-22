# base64 - Base64编码

## 1. 命令简介
base64 命令用于 Base64 编码和解码，是 Linux 系统中常用的文本处理命令之一。

## 2. 命令语法
```bash
base64 [选项] [文件]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -d | 解码模式 |
| -i | 忽略非字母字符 |
| -w | 指定每行宽度（默认76） |
| --help | 显示帮助信息 |
| --version | 显示版本信息 |

## 4. 实战示例

### 4.1 Base64编码
```bash
base64 file.txt
```

### 4.2 Base64解码
```bash
base64 -d file.txt
```

### 4.3 指定每行宽度
```bash
base64 -w 50 file.txt
```

### 4.4 从标准输入编码
```bash
echo "Hello, World!" | base64
```

## 5. 注意事项
- base64 命令用于 Base64 编码和解码
- Base64 编码是一种将二进制数据转换为ASCII字符的编码方式
- base64 命令是一个常用的编码工具，用于处理二进制数据