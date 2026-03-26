# sort - 排序文本

## 1. 命令简介
sort 命令用于对文本文件进行排序，是 Linux 系统中常用的文本处理命令之一。它可以按照不同的规则对文本进行排序，支持多种排序选项。

## 2. 命令语法
```bash
sort [选项] [文件...]
```

## 3. 常用选项

| 选项 | 说明 |
|------|------|
| -n, --numeric-sort | 按数值排序 |
| -r, --reverse | 反向排序 |
| -k, --key=<位置> | 指定排序键 |
| -t, --field-separator=<分隔符> | 指定字段分隔符 |
| -u, --unique | 去除重复行 |
| -f, --ignore-case | 忽略大小写 |
| -b, --ignore-leading-blanks | 忽略前导空白 |
| -o, --output=<文件> | 将结果输出到指定文件 |
| --help | 显示帮助信息 |
| --version | 显示版本信息 |

## 4. 实战示例

### 4.1 对文件进行排序
```bash
sort file.txt
```

### 4.2 按数值排序
```bash
sort -n file.txt
```

### 4.3 反向排序
```bash
sort -r file.txt
```

### 4.4 去除重复行
```bash
sort -u file.txt
```

### 4.5 按指定字段排序
```bash
sort -k 2 file.txt  # 按第二列排序
```

### 4.6 指定分隔符
```bash
sort -t "," -k 2 file.csv  # 按逗号分隔，按第二列排序
```

### 4.7 忽略大小写
```bash
sort -f file.txt
```

### 4.8 将结果输出到文件
```bash
sort file.txt -o sorted.txt
```

## 5. 高级用法

### 5.1 在脚本中使用sort
```bash
#!/bin/bash

# 对文件进行排序
echo "排序前:"
cat file.txt

echo "\n排序后:"
sort file.txt

# 按数值排序
echo "\n按数值排序:"
sort -n file.txt

# 反向排序
echo "\n反向排序:"
sort -r file.txt
```

### 5.2 结合其他命令使用
```bash
# 排序并去除重复行
sort -u file.txt

# 排序并统计重复次数
sort file.txt | uniq -c

# 按多个字段排序
sort -k 1,1 -k 2,2n file.txt  # 先按第一列排序，再按第二列数值排序
```

### 5.3 排序大文件
```bash
# 对大文件进行排序
sort -n large_file.txt -o sorted_large_file.txt

# 使用临时文件
sort -T /tmp large_file.txt -o sorted_large_file.txt
```

### 5.4 与管道结合使用
```bash
# 对命令输出进行排序
ls -l | sort -k 5 -n  # 按文件大小排序

# 对日志文件按时间排序
grep "error" log.txt | sort -k 1,2  # 按日期时间排序

# 对进程按CPU使用率排序
ps aux | sort -k 3 -r | head -n 10
```

## 6. 常见问题与解决方案

### 6.1 问题：sort: command not found
**解决方案**：安装 sort 工具
- Ubuntu/Debian: `apt install coreutils`
- CentOS/RHEL: `yum install coreutils`

### 6.2 问题：sort 排序结果不正确
**解决方案**：确保使用了正确的排序选项，特别是对于数值排序，需要使用 -n 选项

### 6.3 问题：sort 无法处理大文件
**解决方案**：使用 -T 选项指定临时目录，或者增加系统的临时空间

### 6.4 问题：sort 命令执行缓慢
**解决方案**：对于大文件，sort 命令可能会执行较慢，这是正常现象

### 6.5 问题：sort 无法处理特殊字符
**解决方案**：确保文件的编码正确，或者使用合适的排序规则

### 6.6 问题：sort 无法正确排序多列数据
**解决方案**：使用 -t 选项指定分隔符，使用 -k 选项指定排序键

## 7. 命令对比

| 命令 | 功能 | 适用场景 |
|------|------|----------|
| sort | 对文本文件进行排序 | 排序文本数据 |
| uniq | 去除重复行 | 处理重复数据 |
| wc | 统计文件信息 | 统计行数、字数等 |
| grep | 搜索文本 | 查找特定内容 |
| sed | 文本处理工具 | 更复杂的文本操作 |

## 8. 注意事项
- sort 命令用于对文本文件进行排序，是 Linux 系统中常用的文本处理命令之一
- sort 命令可以按照不同的规则对文本进行排序，支持多种排序选项
- 常用的操作包括：对文件进行排序、按数值排序、反向排序、去除重复行等
- sort 命令是 coreutils 包的一部分，几乎所有 Linux 系统都默认安装
- sort 命令可以从标准输入读取数据，也可以处理多个文件
- 使用 -n 选项可以按数值排序，使用 -r 选项可以反向排序，使用 -u 选项可以去除重复行
- 使用 -k 选项可以指定排序键，使用 -t 选项可以指定字段分隔符
- 对于大文件，sort 命令可能会执行较慢，因为它需要读取整个文件到内存
- sort 命令的默认排序规则是按字典序排序
- sort 命令可以与其他命令通过管道结合使用，实现更复杂的操作