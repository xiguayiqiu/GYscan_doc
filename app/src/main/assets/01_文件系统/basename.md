# basename - 获取文件名

## 1. 命令简介
basename 命令用于获取文件名，是 Linux 系统中常用的文件系统命令之一。

## 2. 命令语法
```bash
basename [选项] [路径]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -a | 处理多个路径 |
| -s | 移除指定的后缀 |
| --help | 显示帮助信息 |
| --version | 显示版本信息 |

## 4. 实战示例

### 4.1 获取文件名
```bash
basename /path/to/file.txt
```

### 4.2 移除指定的后缀
```bash
basename -s .txt /path/to/file.txt
```

### 4.3 处理多个路径
```bash
basename -a /path/to/file1.txt /path/to/file2.txt
```

## 5. 注意事项
- basename 命令用于获取路径中的文件名部分
- 使用 -s 选项可以移除指定的后缀
- basename 命令是一个常用的文件路径处理工具