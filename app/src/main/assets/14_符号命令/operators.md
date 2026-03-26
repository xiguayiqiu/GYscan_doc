# Shell 命令分隔符和逻辑操作符

## 命令简介

Shell 命令分隔符和逻辑操作符用于控制命令的执行顺序和条件，是 Shell 命令中常用的功能。

## 命令分隔符和逻辑操作符

| 符号 | 说明 | 示例 |
|------|------|------|
| `;` | 命令分隔符：顺序执行多个命令 | `command1; command2; command3` |
| `&&` | 逻辑与：前一个命令成功时才执行后一个命令 | `command1 && command2` |
| `||` | 逻辑或：前一个命令失败时才执行后一个命令 | `command1 || command2` |
| `!` | 逻辑非：否定条件或执行历史命令 | `! command` |

## 命令示例

### 顺序执行多个命令

```bash
echo "Step 1"; echo "Step 2"; echo "Step 3"
```

### 前一个命令成功时才执行后一个命令

```bash
mkdir test && cd test && touch file.txt
```

### 前一个命令失败时才执行后一个命令

```bash
ls non_existent_file || echo "File not found"
```

### 否定条件

```bash
if [ ! -f file.txt ]; then
    echo "File not found"
fi
```

## 常用组合

### 组合逻辑操作符

```bash
command1 && command2 || command3
```

### 使用括号分组

```bash
(command1 && command2) || command3
```

### 复杂条件判断

```bash
if [ -f file.txt ] && [ -r file.txt ]; then
    echo "File exists and is readable"
fi
```

## 相关命令

- `if`: 条件判断
- `echo`: 显示文本或变量值
- `mkdir`: 创建目录
- `cd`: 切换目录
- `touch`: 创建空文件或更新时间戳