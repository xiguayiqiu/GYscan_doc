# cp - 复制文件或目录

## 1. 命令简介
cp 命令用于复制文件或目录，是 Linux 系统中最常用的命令之一。

## 2. 命令语法
```bash
cp [选项] 源 目标
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -i | 交互式复制，提示确认 |
| -f | 强制复制，覆盖已存在的文件 |
| -r | 递归复制目录及其内容 |
| -v | 显示复制的文件 |
| -p | 保留文件属性 |
| -a | 归档模式，保留所有属性 |
| -l | 创建硬链接 |
| -s | 创建符号链接 |

## 4. 实战示例

### 4.1 复制文件
```bash
cp file.txt file_copy.txt
```

### 4.2 交互式复制文件
```bash
cp -i file.txt file_copy.txt
```

### 4.3 递归复制目录
```bash
cp -r directory directory_copy
```

### 4.4 保留文件属性
```bash
cp -p file.txt file_copy.txt
```

### 4.5 归档模式复制
```bash
cp -a directory directory_copy
```

### 4.6 创建符号链接
```bash
cp -s file.txt file_link.txt
```

## 5. 注意事项
- cp 命令默认只复制文件，不复制目录
- 使用 -r 选项可以递归复制目录及其内容
- 使用 -i 选项可以在覆盖文件时提示确认
- 使用 -a 选项可以保留文件的所有属性，包括权限、所有者、修改时间等