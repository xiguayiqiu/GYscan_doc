# xargs - 构建和执行命令行

## 1. 命令简介
xargs 命令用于从标准输入构建和执行命令行，是 Linux 系统中常用的命令之一。

## 2. 命令语法
```bash
xargs [选项] [命令]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -n | 每个命令执行最多使用n个参数 |
| -d | 指定分隔符 |
| -0 | 使用null作为分隔符 |
| -p | 交互式执行命令 |
| -t | 显示执行的命令 |
| -I | 替换字符串 |
| -r | 如果标准输入为空，不执行命令 |

## 4. 实战示例

### 4.1 批量删除文件
```bash
find . -name "*.txt" | xargs rm
```

### 4.2 每个命令执行最多使用2个参数
```bash
echo "a b c d e f" | xargs -n 2 echo
```

### 4.3 使用null作为分隔符
```bash
find . -name "*.txt" -print0 | xargs -0 rm
```

### 4.4 交互式执行命令
```bash
echo "file1.txt file2.txt" | xargs -p rm
```

### 4.5 显示执行的命令
```bash
echo "file1.txt file2.txt" | xargs -t rm
```

### 4.6 替换字符串
```bash
echo "file1.txt file2.txt" | xargs -I {} cp {} {}.bak
```

## 5. 注意事项
- xargs 命令从标准输入读取数据，构建并执行命令行
- 使用 -0 选项可以处理包含空格的文件名
- 使用 -I 选项可以在命令中替换字符串
- xargs 命令常用于与 find 命令配合使用，处理找到的文件