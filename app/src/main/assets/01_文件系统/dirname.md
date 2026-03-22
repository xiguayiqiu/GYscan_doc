# dirname - 获取目录名

## 1. 命令简介
dirname 命令用于获取目录名，是 Linux 系统中常用的文件系统命令之一。

## 2. 命令语法
```bash
dirname [选项] [路径]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -z | 输出用NUL分隔 |
| --help | 显示帮助信息 |
| --version | 显示版本信息 |

## 4. 实战示例

### 4.1 获取目录名
```bash
dirname /path/to/file.txt
```

### 4.2 处理多个路径
```bash
dirname /path/to/file1.txt /path/to/file2.txt
```

## 5. 注意事项
- dirname 命令用于获取路径中的目录部分
- dirname 命令是一个常用的文件路径处理工具