# paste - 合并文本行

## 1. 命令简介
paste 命令用于合并多个文件的文本行，是 Linux 系统中常用的命令之一。

## 2. 命令语法
```bash
paste [选项] 文件
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -d | 指定分隔符 |
| -s | 串行合并，而不是并行 |

## 4. 实战示例

### 4.1 合并两个文件的文本行
```bash
paste file1.txt file2.txt
```

### 4.2 指定分隔符
```bash
paste -d, file1.txt file2.txt
```

### 4.3 串行合并文件
```bash
paste -s file1.txt file2.txt
```

### 4.4 从标准输入读取数据
```bash
echo "Hello" | paste - file1.txt
```

## 5. 注意事项
- paste 命令默认使用制表符作为分隔符
- 使用 -d 选项可以指定其他分隔符
- 使用 -s 选项可以串行合并文件，而不是并行合并