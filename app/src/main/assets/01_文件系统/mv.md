# mv - 移动或重命名文件

## 1. 命令简介
mv 命令用于移动文件或目录，也可以用于重命名文件或目录，是 Linux 系统中最常用的文件操作命令之一。

## 2. 命令语法
```bash
mv [选项] 源文件 目标文件
mv [选项] 源文件... 目标目录
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -f | 强制移动，覆盖已存在的文件 |
| -i | 交互式移动，覆盖前询问用户 |
| -n | 不覆盖已存在的文件 |
| -v | 详细模式，显示移动的文件列表 |
| -u | 仅移动源文件比目标文件新的文件 |

## 4. 实战示例

### 4.1 移动文件到目标位置
```bash
mv file.txt /path/to/destination/
```

### 4.2 移动多个文件到目标目录
```bash
mv file1.txt file2.txt /path/to/destination/
```

### 4.3 重命名文件
```bash
mv oldname.txt newname.txt
```

### 4.4 移动目录
```bash
mv directory/ /path/to/destination/
```

### 4.5 交互式移动，覆盖前询问
```bash
mv -i file.txt /path/to/destination/
```

### 4.6 强制移动，覆盖已存在的文件
```bash
mv -f file.txt /path/to/destination/
```

## 5. 注意事项
- mv 命令可以用来重命名文件或目录
- 移动目录时不需要使用 -r 选项
- 使用 -i 选项可以避免意外覆盖文件