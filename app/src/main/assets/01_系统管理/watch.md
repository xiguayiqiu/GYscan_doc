# watch - 定期执行命令

## 1. 命令简介
watch 命令用于定期执行指定的命令，并将结果显示在终端上，是 Linux 系统中常用的系统管理命令之一。它可以实时监控命令的输出变化。

## 2. 命令语法
```bash
watch [选项] 命令
```

## 3. 常用选项

| 选项 | 说明 |
|------|------|
| -n, --interval=<秒数> | 指定执行命令的间隔时间，默认 2 秒 |
| -d, --differences | 高亮显示差异 |
| -t, --no-title | 不显示标题 |
| -b, --beep | 当命令执行失败时发出蜂鸣音 |
| -e, --errexit | 当命令执行失败时退出 |
| --help | 显示帮助信息 |
| --version | 显示版本信息 |

## 4. 实战示例

### 4.1 监控系统负载
```bash
watch uptime
```

### 4.2 监控磁盘使用情况
```bash
watch df -h
```

### 4.3 监控内存使用情况
```bash
watch free -h
```

### 4.4 监控进程状态
```bash
watch ps aux | grep java
```

### 4.5 监控文件变化
```bash
watch ls -l
```

### 4.6 自定义执行间隔
```bash
watch -n 10 "ls -l"
```

### 4.7 高亮显示差异
```bash
watch -d "ls -l"
```

### 4.8 不显示标题
```bash
watch -t "ls -l"
```

## 5. 高级用法

### 5.1 在脚本中使用watch
```bash
#!/bin/bash

# 监控系统状态
echo "监控系统状态，按 Ctrl+C 退出"
watch -n 5 "uptime && echo '---' && free -h && echo '---' && df -h"

# 监控特定进程
echo "\n监控 Java 进程，按 Ctrl+C 退出"
watch -n 2 "ps aux | grep java"
```

### 5.2 结合其他命令使用
```bash
# 监控网络连接
watch -n 1 "netstat -tuln"

# 监控日志文件
watch -n 1 "tail -n 10 /var/log/syslog"

# 监控系统资源使用情况
watch -n 5 "top -b -n 1 | head -20"
```

### 5.3 监控命令执行结果
```bash
# 监控网站响应时间
watch -n 10 "curl -o /dev/null -s -w '%{http_code} %{time_total}s\n' https://www.example.com"

# 监控数据库连接数
watch -n 5 "mysql -u root -p -e 'show processlist;'"

# 监控磁盘 I/O
watch -n 1 "iostat -x"
```

### 5.4 与管道结合使用
```bash
# 监控特定端口的连接
watch -n 1 "netstat -tuln | grep 8080"

# 监控系统用户登录情况
watch -n 1 "who"

# 监控系统启动时间
watch -n 60 "uptime | cut -d ',' -f 1"
```

## 6. 常见问题与解决方案

### 6.1 问题：watch: command not found
**解决方案**：安装 watch 工具
- Ubuntu/Debian: `apt install procps`
- CentOS/RHEL: `yum install procps-ng`

### 6.2 问题：watch 命令执行缓慢
**解决方案**：减少执行间隔，或者优化命令执行速度

### 6.3 问题：watch 无法显示彩色输出
**解决方案**：使用 `--color` 选项或设置 `TERM=xterm-256color`

### 6.4 问题：watch 无法执行复杂命令
**解决方案**：将复杂命令放在引号中，或者使用脚本

### 6.5 问题：watch 占用太多系统资源
**解决方案**：增加执行间隔，或者减少命令的复杂度

### 6.6 问题：watch 无法监控后台进程
**解决方案**：watch 只能监控命令的输出，不能直接监控后台进程

## 7. 命令对比

| 命令 | 功能 | 适用场景 |
|------|------|----------|
| watch | 定期执行命令 | 实时监控命令输出 |
| top | 实时显示进程信息 | 监控系统进程 |
| htop | 交互式进程查看器 | 交互式监控系统进程 |
| vmstat | 虚拟内存统计 | 监控系统内存使用 |
| iostat | 输入/输出统计 | 监控磁盘 I/O |

## 8. 注意事项
- watch 命令用于定期执行指定的命令，并将结果显示在终端上，是 Linux 系统中常用的系统管理命令之一
- watch 命令可以实时监控命令的输出变化
- 常用的操作包括：监控系统负载、监控磁盘使用情况、监控内存使用情况、监控进程状态等
- watch 命令在大多数 Linux 系统中需要单独安装
- 使用 -n 选项可以指定执行命令的间隔时间，默认 2 秒
- 使用 -d 选项可以高亮显示差异，使用 -t 选项可以不显示标题
- watch 命令的执行速度取决于被执行命令的复杂度
- watch 命令可以与其他命令通过管道结合使用，实现更复杂的监控
- 按 Ctrl+C 可以退出 watch 命令