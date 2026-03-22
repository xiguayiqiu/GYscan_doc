# grep - 搜索文本

## 1. 命令简介
grep 命令用于在文件中搜索文本，是 Linux 系统中最常用的文本搜索命令之一。

## 2. 命令语法
```bash
grep [选项] 模式 文件
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -i | 忽略大小写 |
| -v | 反向搜索，显示不匹配的行 |
| -n | 显示行号 |
| -c | 显示匹配的行数 |
| -l | 显示包含匹配的文件名 |
| -r | 递归搜索目录 |
| -A | 显示匹配行及其后n行 |
| -B | 显示匹配行及其前n行 |
| -C | 显示匹配行及其前后n行 |
| -E | 使用扩展正则表达式 |
| -F | 使用固定字符串，不使用正则表达式 |

## 4. 实战示例

### 4.1 在文件中搜索文本
```bash
grep "pattern" file.txt
```

### 4.2 忽略大小写
```bash
grep -i "pattern" file.txt
```

### 4.3 显示行号
```bash
grep -n "pattern" file.txt
```

### 4.4 反向搜索
```bash
grep -v "pattern" file.txt
```

### 4.5 递归搜索目录
```bash
grep -r "pattern" directory/
```

### 4.6 显示匹配的行数
```bash
grep -c "pattern" file.txt
```

## 5. 注意事项
- grep 命令默认使用基本正则表达式
- 使用 -E 选项可以使用扩展正则表达式
- 使用 -F 选项可以使用固定字符串，不使用正则表达式
- grep 命令也可以从标准输入读取数据，如 `cat file.txt | grep pattern`