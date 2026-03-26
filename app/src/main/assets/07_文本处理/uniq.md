# uniq - 去除重复行

## 1. 命令简介
uniq 命令用于去除文本文件中的重复行，是 Linux 系统中常用的文本处理命令之一。它通常与 sort 命令结合使用，先排序后去重。

## 2. 命令语法
```bash
uniq [选项] [文件...]
```

## 3. 常用选项

| 选项 | 说明 |
|------|------|
| -c, --count | 显示每行出现的次数 |
| -d, --repeated | 只显示重复的行 |
| -u, --unique | 只显示唯一的行 |
| -i, --ignore-case | 忽略大小写 |
| -f, --skip-fields=<N> | 跳过前 N 个字段 |
| -s, --skip-chars=<N> | 跳过前 N 个字符 |
| -w, --check-chars=<N> | 只比较前 N 个字符 |
| --help | 显示帮助信息 |
| --version | 显示版本信息 |

## 4. 实战示例

### 4.1 去除重复行
```bash
sort file.txt | uniq
```

### 4.2 显示每行出现的次数
```bash
sort file.txt | uniq -c
```

### 4.3 只显示重复的行
```bash
sort file.txt | uniq -d
```

### 4.4 只显示唯一的行
```bash
sort file.txt | uniq -u
```

### 4.5 忽略大小写
```bash
sort file.txt | uniq -i
```

### 4.6 跳过前 2 个字段
```bash
sort file.txt | uniq -f 2
```

### 4.7 只比较前 5 个字符
```bash
sort file.txt | uniq -w 5
```

## 5. 高级用法

### 5.1 在脚本中使用uniq
```bash
#!/bin/bash

# 去除重复行
echo "去重前:"
cat file.txt

echo "\n去重后:"
sort file.txt | uniq

# 统计重复次数
echo "\n重复次数:"
sort file.txt | uniq -c

# 只显示重复的行
echo "\n重复的行:"
sort file.txt | uniq -d
```

### 5.2 结合其他命令使用
```bash
# 统计日志文件中出现最多的错误
grep "error" log.txt | sort | uniq -c | sort -nr | head -n 5

# 统计文件中不同单词的出现次数
tr ' ' '\n' < file.txt | sort | uniq -c | sort -nr

# 查找重复的文件
tfind . -type f -exec md5sum {} \; | sort | uniq -d -w 32
```

### 5.3 批量处理多个文件
```bash
#!/bin/bash

# 批量处理多个文件
files=(file1.txt file2.txt file3.txt)

echo "文件去重结果:"
echo "----------------"
for file in "${files[@]}"; do
    if [ -f "$file" ]; then
        echo "=== $file ==="
        sort "$file" | uniq
        echo
    else
        echo "$file: 不存在"
    fi
done
```

### 5.4 与管道结合使用
```bash
# 去除重复的进程名
ps aux | awk '{print $11}' | sort | uniq

# 统计网络连接状态
etstat -an | grep ESTABLISHED | sort | uniq -c

# 查找重复的 IP 地址
cat access.log | grep -E '([0-9]{1,3}\.){3}[0-9]{1,3}' | sort | uniq -c | sort -nr
```

## 6. 常见问题与解决方案

### 6.1 问题：uniq: command not found
**解决方案**：安装 uniq 工具
- Ubuntu/Debian: `apt install coreutils`
- CentOS/RHEL: `yum install coreutils`

### 6.2 问题：uniq 没有去除所有重复行
**解决方案**：uniq 只能去除相邻的重复行，因此需要先排序
```bash
sort file.txt | uniq
```

### 6.3 问题：uniq 无法正确处理大小写
**解决方案**：使用 -i 选项忽略大小写
```bash
sort file.txt | uniq -i
```

### 6.4 问题：uniq 无法正确处理多字段数据
**解决方案**：使用 -f 选项跳过不需要比较的字段
```bash
sort file.txt | uniq -f 2
```

### 6.5 问题：uniq 命令执行缓慢
**解决方案**：对于大文件，uniq 命令可能会执行较慢，这是正常现象

### 6.6 问题：uniq 无法处理二进制文件
**解决方案**：uniq 命令主要用于处理文本文件，对于二进制文件可能会产生不可预期的结果

## 7. 命令对比

| 命令 | 功能 | 适用场景 |
|------|------|----------|
| uniq | 去除重复行 | 处理重复数据 |
| sort | 对文本文件进行排序 | 排序文本数据 |
| wc | 统计文件信息 | 统计行数、字数等 |
| grep | 搜索文本 | 查找特定内容 |
| sed | 文本处理工具 | 更复杂的文本操作 |

## 8. 注意事项
- uniq 命令用于去除文本文件中的重复行，是 Linux 系统中常用的文本处理命令之一
- uniq 命令通常与 sort 命令结合使用，先排序后去重
- 常用的操作包括：去除重复行、显示每行出现的次数、只显示重复的行等
- uniq 命令是 coreutils 包的一部分，几乎所有 Linux 系统都默认安装
- uniq 命令可以从标准输入读取数据，也可以处理多个文件
- uniq 命令只能去除相邻的重复行，因此需要先排序
- 使用 -c 选项可以显示每行出现的次数，使用 -d 选项可以只显示重复的行
- 使用 -u 选项可以只显示唯一的行，使用 -i 选项可以忽略大小写
- uniq 命令可以与其他命令通过管道结合使用，实现更复杂的操作