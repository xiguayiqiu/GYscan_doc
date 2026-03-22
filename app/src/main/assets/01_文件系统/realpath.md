# realpath - 获取真实路径

## 1. 命令简介
realpath 命令用于获取文件的真实路径，是 Linux 系统中常用的文件系统命令之一。

## 2. 命令语法
```bash
realpath [选项] [文件]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -e | 只显示存在的文件 |
| -m | 不检查文件是否存在 |
| -L | 跟随符号链接 |
| -P | 不跟随符号链接 |
| --help | 显示帮助信息 |
| --version | 显示版本信息 |

## 4. 实战示例

### 4.1 获取真实路径
```bash
realpath file.txt
```

### 4.2 只显示存在的文件
```bash
realpath -e file.txt
```

### 4.3 不检查文件是否存在
```bash
realpath -m file.txt
```

## 5. 注意事项
- realpath 命令用于获取文件的真实路径，解析所有的符号链接
- realpath 命令可以将相对路径转换为绝对路径
- realpath 命令是一个常用的文件路径处理工具