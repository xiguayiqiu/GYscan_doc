# uconv - Unicode转换

## 1. 命令简介
uconv 命令用于 Unicode 转换，是 Linux 系统中常用的文本处理命令之一。

## 2. 命令语法
```bash
uconv [选项] [文件]
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

### 4.1 Unicode转换
```bash
uconv -f UTF-8 -t UTF-16 file.txt -o output.txt
```

### 4.2 忽略无效字符
```bash
uconv -f UTF-8 -t UTF-16 -c file.txt -o output.txt
```

### 4.3 显示支持的编码
```bash
uconv --list
```

## 5. 注意事项
- uconv 命令用于 Unicode 转换，支持多种 Unicode 编码格式
- uconv 命令是 ICU (International Components for Unicode) 工具的一部分
- uconv 命令是一个常用的文本处理工具，用于处理 Unicode 文本