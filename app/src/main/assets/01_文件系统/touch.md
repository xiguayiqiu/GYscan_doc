# touch - 创建空文件或更新时间戳

## 1. 命令简介
touch 命令用于创建空文件或更新文件的时间戳，是 Linux 系统中最常用的文件操作命令之一。

## 2. 命令语法
```bash
touch [选项] 文件
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -a | 仅更新访问时间 |
| -m | 仅更新修改时间 |
| -t | 指定时间戳 |
| -c | 不创建新文件 |

## 4. 实战示例

### 4.1 创建空文件
```bash
touch file.txt
```

### 4.2 创建多个空文件
```bash
touch file1.txt file2.txt file3.txt
```

### 4.3 更新文件的访问时间
```bash
touch -a file.txt
```

### 4.4 更新文件的修改时间
```bash
touch -m file.txt
```

### 4.5 指定时间戳
```bash
touch -t 202312251200.00 file.txt
```

### 4.6 不创建新文件，仅更新时间戳
```bash
touch -c file.txt
```

## 5. 注意事项
- touch 命令默认会创建不存在的文件
- 使用 -c 选项可以避免创建新文件
- -t 选项的时间格式为 [[CC]YY]MMDDhhmm[.ss]