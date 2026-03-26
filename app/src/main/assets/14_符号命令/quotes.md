# Shell 引号和转义字符

## 命令简介

Shell 引号和转义字符用于控制命令中特殊字符的解释，是 Shell 命令中常用的功能。

## 引号和转义字符

| 符号 | 说明 | 示例 |
|------|------|------|
| `\` | 转义字符：转义下一个字符的特殊含义 | `echo \$VAR` |
| `'` | 单引号：完全引用，所有字符按字面意思解释 | `echo 'Hello $VAR'` |
| `"` | 双引号：部分引用，保留变量和命令替换 | `echo "Hello $VAR"` |
| `\\` | 反斜杠：转义字符或续行 | `echo "Line 1 \\nLine 2"` |
| `#` | 注释：Shell忽略#之后的内容 | `echo "Hello" # This is a comment` |

## 命令示例

### 使用转义字符

```bash
echo \$VAR  # 输出 $VAR 而不是变量值
echo "Line 1\nLine 2"  # 输出两行
```

### 使用单引号

```bash
echo 'Hello $VAR'  # 输出 Hello $VAR 而不是变量值
echo 'It\'s a test'  # 输出 It's a test
```

### 使用双引号

```bash
VAR="World"
echo "Hello $VAR"  # 输出 Hello World
echo "Current date: $(date)"  # 执行命令替换
```

### 使用反斜杠续行

```bash
echo "Line 1 \
Line 2"  # 输出两行
```

### 使用注释

```bash
echo "Hello"  # This is a comment
echo "World"  # Another comment
```

## 常用组合

### 组合引号和转义字符

```bash
echo "It\'s a \"test\""  # 输出 It's a "test"
```

### 在脚本中使用引号

```bash
#!/bin/bash

NAME="John"
echo "Hello, $NAME!"
echo 'Hello, $NAME!'  # 注意单引号不会替换变量
```

### 使用引号保护包含空格的路径

```bash
cd "My Documents"
cp "file with spaces.txt" "another directory/"
```

## 相关命令

- `echo`: 显示文本或变量值
- `date`: 显示日期时间
- `cd`: 切换目录
- `cp`: 复制文件或目录