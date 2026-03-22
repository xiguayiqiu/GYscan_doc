# cp - 复制文件或目录

## 1. 命令简介
cp 命令用于复制文件或目录，是 Linux 系统中最常用的文件操作命令之一。

## 2. 命令语法
```bash
cp [选项] 源文件 目标文件
cp [选项] 源文件... 目标目录
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -a | 归档模式，保留文件的所有属性（包括权限、时间戳、链接等） |
| -f | 强制复制，覆盖已存在的文件 |
| -i | 交互式复制，覆盖前询问用户 |
| -r | 递归复制目录及其内容 |
| -p | 保留文件的权限、所有者、时间戳等属性 |
| -v | 详细模式，显示复制的文件列表 |
| -u | 仅复制源文件比目标文件新的文件 |
| -l | 创建硬链接而不是复制文件 |
| -s | 创建符号链接而不是复制文件 |

## 4. 实战示例

### 4.1 复制文件到目标位置
```bash
cp file.txt /path/to/destination/
```

### 4.2 复制多个文件到目标目录
```bash
cp file1.txt file2.txt /path/to/destination/
```

### 4.3 递归复制目录
```bash
cp -r directory/ /path/to/destination/
```

### 4.4 复制文件并保留属性
```bash
cp -p file.txt /path/to/destination/
```

### 4.5 交互式复制，覆盖前询问
```bash
cp -i file.txt /path/to/destination/
```

### 4.6 强制复制，覆盖已存在的文件
```bash
cp -f file.txt /path/to/destination/
```

## 5. 注意事项
- 复制目录时需要使用 -r 选项
- 使用 -a 选项可以保留文件的所有属性，相当于 -dR --preserve=all
- 在复制大文件时，使用 -v 选项可以查看复制进度