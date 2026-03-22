# test - 测试文件类型和值

## 1. 命令简介
test 命令用于测试文件类型和值，是 Linux 系统中常用的命令之一。

## 2. 命令语法
```bash
test [表达式]
[表达式]
```

## 3. 常用测试操作符

### 3.1 文件测试
| 操作符 | 说明 |
|--------|------|
| -e | 文件存在 |
| -f | 文件是普通文件 |
| -d | 文件是目录 |
| -r | 文件可读 |
| -w | 文件可写 |
| -x | 文件可执行 |
| -s | 文件大小不为0 |
| -L | 文件是符号链接 |

### 3.2 字符串测试
| 操作符 | 说明 |
|--------|------|
| -z | 字符串长度为0 |
| -n | 字符串长度不为0 |
| str1 = str2 | 字符串相等 |
| str1 != str2 | 字符串不相等 |

### 3.3 数值测试
| 操作符 | 说明 |
|--------|------|
| -eq | 等于 |
| -ne | 不等于 |
| -gt | 大于 |
| -lt | 小于 |
| -ge | 大于等于 |
| -le | 小于等于 |

### 3.4 逻辑操作符
| 操作符 | 说明 |
|--------|------|
| ! | 逻辑非 |
| -a | 逻辑与 |
| -o | 逻辑或 |

## 4. 实战示例

### 4.1 测试文件是否存在
```bash
if test -e file.txt; then
    echo "File exists"
else
    echo "File does not exist"
fi
```

### 4.2 测试文件是否是普通文件
```bash
if [ -f file.txt ]; then
    echo "File is a regular file"
else
    echo "File is not a regular file"
fi
```

### 4.3 测试字符串长度是否为0
```bash
if [ -z "$var" ]; then
    echo "Variable is empty"
else
    echo "Variable is not empty"
fi
```

### 4.4 测试数值是否相等
```bash
if [ 10 -eq 10 ]; then
    echo "Numbers are equal"
else
    echo "Numbers are not equal"
fi
```

### 4.5 测试多个条件
```bash
if [ -f file.txt -a -r file.txt ]; then
    echo "File exists and is readable"
else
    echo "File does not exist or is not readable"
fi
```

## 5. 注意事项
- test 命令和 [] 语法是等价的
- 在使用 [] 语法时，操作符两边需要有空格
- 测试字符串时，最好使用双引号包围变量，以防止变量为空时出现语法错误