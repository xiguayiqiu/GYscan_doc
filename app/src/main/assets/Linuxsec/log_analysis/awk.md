# awk 命令

## 命令说明
awk是一款功能强大的文本处理工具，用于处理和分析文本数据。它支持模式匹配、条件判断、循环控制和数学运算等功能，是日志分析、数据处理和报表生成的重要工具。

## 语法
```
awk [选项] '程序' 文件
```

## 常用选项
- `-F <分隔符>`：指定字段分隔符
- `-v <变量=值>`：定义变量
- `-f <文件>`：从文件读取程序
- `-O`：优化输出
- `-W <警告级别>`：设置警告级别

## awk 程序结构

awk程序由模式（pattern）和动作（action）组成：

```
pattern { action }
```

- **模式**：用于匹配输入行的条件
- **动作**：当模式匹配时执行的操作

## 内置变量

### 字段相关
- `$0`：整行内容
- `$1, $2, ...`：第1, 2, ... 个字段
- `NF`：当前行的字段数
- `NR`：当前处理的行号
- `FNR`：当前文件的行号

### 系统相关
- `FILENAME`：当前处理的文件名
- `FS`：字段分隔符（默认是空格）
- `OFS`：输出字段分隔符（默认是空格）
- `RS`：记录分隔符（默认是换行）
- `ORS`：输出记录分隔符（默认是换行）

### 其他
- `ARGC`：命令行参数个数
- `ARGV`：命令行参数数组

## 操作符

### 算术操作符
- `+`：加法
- `-`：减法
- `*`：乘法
- `/`：除法
- `%`：取模
- `^`：幂运算

### 比较操作符
- `==`：等于
- `!=`：不等于
- `<`：小于
- `<=`：小于等于
- `>`：大于
- `>=`：大于等于

### 逻辑操作符
- `&&`：逻辑与
- `||`：逻辑或
- `!`：逻辑非

### 其他操作符
- `~`：匹配正则表达式
- `!~`：不匹配正则表达式
- `in`：检查数组中是否存在某个键

## 内置函数

### 字符串函数
- `length(s)`：返回字符串长度
- `substr(s, start, length)`：提取子字符串
- `index(s, t)`：返回t在s中的位置
- `split(s, a, sep)`：将s分割到数组a中
- `tolower(s)`：转换为小写
- `toupper(s)`：转换为大写

### 数值函数
- `int(x)`：取整
- `sqrt(x)`：平方根
- `exp(x)`：指数
- `log(x)`：自然对数
- `sin(x)`：正弦
- `cos(x)`：余弦
- `rand()`：随机数
- `srand()`：设置随机数种子

### 其他函数
- `system(cmd)`：执行系统命令
- `getline`：读取下一行
- `close(file)`：关闭文件

## 控制结构

### 条件语句
```awk
if (condition) {
    action1
} else if (condition2) {
    action2
} else {
    action3
}
```

### 循环语句
```awk
# while循环
while (condition) {
    action
}

# for循环
for (i = 1; i <= 10; i++) {
    action
}

# for-in循环（遍历数组）
for (i in array) {
    action
}
```

### 其他控制语句
- `break`：跳出循环
- `continue`：跳过当前循环的剩余部分
- `next`：跳过当前行，处理下一行
- `exit`：退出程序

## 示例

### 基本操作
```bash
# 打印第一列
awk '{print $1}' file.txt

# 打印多列
awk '{print $1, $3}' file.txt

# 打印整行
awk '{print $0}' file.txt

# 打印行号和内容
awk '{print NR, $0}' file.txt
```

### 条件过滤
```bash
# 过滤包含error的行
awk '/error/ {print $0}' /var/log/syslog

# 过滤不包含info的行
awk '!/info/ {print $0}' /var/log/syslog

# 过滤第3列大于10的行
awk '$3 > 10 {print $0}' file.txt

# 过滤第1列等于"user"的行
awk '$1 == "user" {print $0}' file.txt
```

### 字段分隔符
```bash
# 使用逗号作为分隔符
awk -F, '{print $1, $2}' csvfile.txt

# 使用多个分隔符（空格或制表符）
awk -F'[ \t]+' '{print $1, $2}' file.txt

# 使用正则表达式作为分隔符
awk -F'[[:space:]]+' '{print $1, $2}' file.txt
```

### 计算和统计
```bash
# 计算第二列的和
awk '{sum += $2} END {print sum}' file.txt

# 计算第二列的平均值
awk '{sum += $2; count++} END {print sum/count}' file.txt

# 计算第二列的最大值
awk 'NR == 1 {max = $2} $2 > max {max = $2} END {print max}' file.txt

# 统计每个值出现的次数
awk '{count[$1]++} END {for (i in count) print i, count[i]}' file.txt
```

### 格式化输出
```bash
# 格式化输出
awk '{printf "%s\t%d\n", $1, $2}' file.txt

# 设置输出分隔符
awk 'BEGIN {OFS=","} {print $1, $2, $3}' file.txt

# 输出带标题的报表
awk 'BEGIN {print "Name\tAge\tScore"} {print $1, $2, $3}' file.txt
```

### 高级应用
```bash
# 处理日志文件，提取IP地址和请求URL
awk '/GET/ {print $1, $7}' /var/log/apache2/access.log

# 统计日志中每个IP的访问次数
awk '{count[$1]++} END {for (ip in count) print ip, count[ip]}' /var/log/apache2/access.log

# 计算文件大小总和
ls -l | awk '{sum += $5} END {print sum}'

# 查找进程占用内存最多的前5个
ps aux | awk '{print $1, $2, $4, $11}' | sort -nrk3 | head -5
```

## 适用场景

### 日志分析
- 提取关键信息
- 统计错误和警告
- 分析访问模式
- 监控系统性能

### 数据处理
- 处理CSV和TSV文件
- 数据转换和格式化
- 数据清洗和过滤
- 生成报表

### 系统管理
- 分析系统日志
- 监控进程和资源使用
- 处理配置文件
- 自动化脚本编写

### 网络管理
- 分析网络日志
- 监控网络流量
- 处理网络配置
- 分析网络性能

### 开发辅助
- 代码分析
- 数据格式转换
- 测试数据生成
- 日志处理

## 高级技巧

### 使用BEGIN和END块
```bash
# 在处理数据前和处理完数据后执行操作
awk 'BEGIN {print "开始处理"} {print $0} END {print "处理完成"}' file.txt

# 设置初始值和输出结果
awk 'BEGIN {sum=0} {sum+=$1} END {print "总和：", sum}' file.txt
```

### 使用数组
```bash
# 统计每个单词出现的次数
awk '{for (i=1; i<=NF; i++) count[$i]++} END {for (word in count) print word, count[word]}' file.txt

# 去重
awk '!seen[$0]++' file.txt
```

### 多文件处理
```bash
# 处理多个文件
awk '{print FILENAME, NR, $0}' file1.txt file2.txt

# 处理不同文件的不同逻辑
awk 'FNR==1 {print "处理文件：", FILENAME} {print $0}' file1.txt file2.txt
```

### 与其他命令结合
```bash
# 查找包含error的行并统计数量
grep 'error' /var/log/syslog | awk '{count++} END {print count}'

# 处理管道输入
ls -l | awk '$5 > 1000 {print $9}'

# 与sed结合处理文本
sed 's/\r//' file.txt | awk '{print $1}'
```

### 性能优化
- 对于大型文件，使用更具体的模式减少处理量
- 避免在循环中使用复杂的正则表达式
- 合理使用数组和变量
- 对于简单任务，考虑使用更轻量级的工具

## 总结
awk是一款功能强大、灵活的文本处理工具，提供了丰富的内置变量、函数和控制结构，适用于各种文本处理场景。通过掌握awk的使用方法，用户可以更有效地分析日志、处理数据、管理系统和辅助开发。

awk的优势在于：
- 强大的文本处理能力
- 丰富的内置函数和变量
- 灵活的控制结构
- 良好的可扩展性
- 与其他命令的良好集成

作为文本处理的瑞士军刀，awk是每个Linux用户必备的工具之一。