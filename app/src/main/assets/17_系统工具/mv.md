# mv - 移动或重命名文件或目录

## 1. 命令简介
mv 命令用于移动或重命名文件或目录，是 Linux 系统中最常用的命令之一。

## 2. 命令语法
```bash
mv [选项] 源 目标
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -i | 交互式移动，提示确认 |
| -f | 强制移动，覆盖已存在的文件 |
| -v | 显示移动的文件 |
| -u | 仅移动源文件比目标文件新的文件 |

## 4. 实战示例

### 4.1 重命名文件
```bash
mv file.txt new_file.txt
```

### 4.2 移动文件到目录
```bash
mv file.txt directory/
```

### 4.3 交互式移动文件
```bash
mv -i file.txt directory/
```

### 4.4 强制移动文件
```bash
mv -f file.txt directory/
```

### 4.5 显示移动的文件
```bash
mv -v file.txt directory/
```

### 4.6 移动多个文件到目录
```bash
mv file1.txt file2.txt file3.txt directory/
```

## 5. 注意事项
- mv 命令可以用于重命名文件或目录，也可以用于移动文件或目录到另一个位置
- 使用 -i 选项可以在覆盖文件时提示确认
- 使用 -f 选项可以强制覆盖已存在的文件，使用时要谨慎
- mv 命令移动文件时，文件的属性会被保留