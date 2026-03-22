# basenc - 多种编码

## 1. 命令简介
basenc 命令用于多种编码，是 Linux 系统中常用的文本处理命令之一。

## 2. 命令语法
```bash
basenc [选项] [文件]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| --base64 | Base64编码 |
| --base64url | Base64 URL编码 |
| --base32 | Base32编码 |
| --base32hex | Base32十六进制编码 |
| --base16 | Base16编码 |
| --decode | 解码模式 |
| --wrap | 指定每行宽度 |
| --help | 显示帮助信息 |
| --version | 显示版本信息 |

## 4. 实战示例

### 4.1 Base64编码
```bash
basenc --base64 file.txt
```

### 4.2 Base64 URL编码
```bash
basenc --base64url file.txt
```

### 4.3 Base32编码
```bash
basenc --base32 file.txt
```

### 4.4 解码
```bash
basenc --base64 --decode file.txt
```

## 5. 注意事项
- basenc 命令用于多种编码，支持 Base64、Base64 URL、Base32、Base32hex 和 Base16 编码
- basenc 命令是一个更通用的编码工具，提供了多种编码选项
- basenc 命令是一个常用的编码工具，用于处理二进制数据