# Shell 变量引用

## 命令简介

Shell 变量引用用于在命令中使用变量的值，是 Shell 命令中常用的功能。

## 变量引用符号

| 符号 | 说明 | 示例 |
|------|------|------|
| `$` | 变量：引用变量或命令替换 | `echo $VAR` |
| `${}` | 变量：更安全的变量引用方式 | `echo ${VAR}` |
| `$()` | 命令替换：执行命令并替换为输出结果 | `echo $(date)` |
| `` ` `` | 命令替换：执行命令并替换为输出结果（旧式） | `echo `date`` |
| `$?` | 退出状态：上一个命令的退出状态码 | `echo $?` |
| `$$` | 进程ID：当前Shell的进程ID | `echo $$` |
| `$!` | 后台进程ID：最后一个后台进程的进程ID | `echo $!` |
| `$0` | 脚本名称：当前执行的脚本名称 | `echo $0` |
| `$1-$9` | 位置参数：脚本或函数的参数 | `echo $1` |
| `$#` | 参数个数：传递给脚本的参数个数 | `echo $#` |
| `$@` | 所有参数：所有位置参数作为独立字符串 | `echo $@` |
| `$*` | 所有参数：所有位置参数作为单个字符串 | `echo $*` |

## 命令示例

### 引用变量

```bash
VAR="Hello World"
echo $VAR
echo ${VAR}
```

### 命令替换

```bash
echo "Current date: $(date)"
echo "Current date: `date`"
```

### 查看退出状态码

```bash
echo "Hello"
echo "Exit status: $?"
```

### 查看进程ID

```bash
echo "Current process ID: $$"
```

### 查看后台进程ID

```bash
sleep 10 &
echo "Background process ID: $!"
```

### 查看脚本名称

```bash
echo "Script name: $0"
```

### 查看位置参数

```bash
echo "First argument: $1"
echo "Second argument: $2"
```

### 查看参数个数

```bash
echo "Number of arguments: $#"
```

### 查看所有参数

```bash
echo "All arguments (as separate strings): $@"
echo "All arguments (as single string): $*"
```

## 常用组合

### 变量赋值和引用

```bash
NAME="John"
AGE=30
echo "$NAME is $AGE years old"
```

### 命令替换和变量赋值

```bash
DATE=$(date +"%Y-%m-%d")
echo "Today is $DATE"
```

### 位置参数和条件判断

```bash
if [ $# -eq 0 ]; then
    echo "No arguments provided"
else
    echo "Arguments: $@"
fi
```

## 相关命令

- `echo`: 显示文本或变量值
- `date`: 显示日期时间
- `sleep`: 暂停执行