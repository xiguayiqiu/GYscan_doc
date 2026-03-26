# Shell 重定向

## 命令简介

Shell 重定向用于控制命令的输入和输出流向，是 Shell 命令中常用的功能。

## 重定向符号

| 符号 | 说明 | 示例 |
|------|------|------|
| `>` | 将输出重定向到文件（覆盖） | `echo "Hello" > file.txt` |
| `>>` | 将输出追加到文件 | `echo "Hello" >> file.txt` |
| `<` | 从文件读取输入 | `cat < file.txt` |
| `2>` | 将错误输出重定向到文件 | `command 2> error.txt` |
| `2>>` | 将错误输出追加到文件 | `command 2>> error.txt` |
| `&>` | 将标准输出和错误输出重定向到文件 | `command &> output.txt` |

## 命令示例

### 将输出重定向到文件（覆盖）

```bash
echo "Hello World" > output.txt
```

### 将输出追加到文件

```bash
echo "Hello Again" >> output.txt
```

### 从文件读取输入

```bash
cat < input.txt
```

### 将错误输出重定向到文件

```bash
ls non_existent_file 2> error.txt
```

### 将错误输出追加到文件

```bash
ls non_existent_file 2>> error.txt
```

### 将标准输出和错误输出重定向到文件

```bash
command &> output.txt
```

### 将标准输出重定向到文件，错误输出重定向到另一个文件

```bash
command > output.txt 2> error.txt
```

## 常用组合

### 丢弃错误输出

```bash
command 2> /dev/null
```

### 将标准输出和错误输出都追加到文件

```bash
command >> output.txt 2>&1
```

### 使用管道和重定向

```bash
ls -l | grep "txt" > txt_files.txt
```

## 相关命令

- `echo`: 显示文本或变量值
- `cat`: 连接并显示文件内容
- `grep`: 搜索文本模式