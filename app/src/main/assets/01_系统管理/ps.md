# ps - 显示进程状态

## 1. 命令简介
ps 命令用于显示进程状态，是 Linux 系统中常用的进程管理命令之一。它可以显示当前系统中运行的进程信息。

## 2. 命令语法
```bash
ps [选项]
```

## 3. 常用选项

| 选项 | 说明 |
|------|------|
| -h, --help | 显示帮助信息 |
| --version | 显示版本信息 |
| -a | 显示所有进程 |
| -u | 显示用户相关的进程 |
| -x | 显示没有控制终端的进程 |
| -e | 显示所有进程 |
| -f | 显示完整格式 |
| -l | 显示长格式 |
| -o, --format=<格式> | 指定输出格式 |
| -p, --pid=<PID> | 显示指定PID的进程 |
| -t, --tty=<终端> | 显示指定终端的进程 |
| -C, --command=<命令> | 显示指定命令的进程 |
| --sort=<排序> | 按指定字段排序 |

## 4. 输出格式

| 字段 | 说明 |
|------|------|
| PID | 进程ID |
| PPID | 父进程ID |
| USER | 进程所有者 |
| %CPU | CPU使用率 |
| %MEM | 内存使用率 |
| VSZ | 虚拟内存大小 |
| RSS | 实际内存使用大小 |
| TTY | 控制终端 |
| STAT | 进程状态 |
| START | 启动时间 |
| TIME | 累计CPU时间 |
| COMMAND | 命令名称 |

## 5. 进程状态

| 状态 | 说明 |
|------|------|
| R | 运行中 |
| S | 睡眠中 |
| D | 不可中断睡眠 |
| T | 停止 |
| Z | 僵尸进程 |
| W | 换出 |
| < | 高优先级 |
| N | 低优先级 |
| + | 前台进程组 |
| l | 多线程 |
| s | 会话领导者 |

## 6. 实战示例

### 6.1 基本用法
```bash
# 显示当前用户的进程
ps

# 显示所有进程
ps -e

# 显示完整格式的进程信息
ps -ef

# 显示长格式的进程信息
ps -el
```

### 6.2 显示指定进程
```bash
# 显示指定PID的进程
ps -p 1234

# 显示指定命令的进程
ps -C bash

# 显示指定终端的进程
ps -t pts/0
```

### 6.3 自定义输出格式
```bash
# 自定义输出格式
ps -o pid,ppid,user,%cpu,%mem,command

# 按CPU使用率排序
ps --sort=-%cpu

# 按内存使用率排序
ps --sort=-%mem
```

## 7. 高级用法

### 7.1 组合选项
```bash
# 显示所有进程，完整格式，按CPU使用率排序
ps -ef --sort=-%cpu

# 显示所有进程，长格式，按内存使用率排序
ps -el --sort=-%mem
```

### 7.2 与其他命令结合使用
```bash
# 查找特定进程并显示详细信息
ps -ef | grep bash

# 显示进程树
ps -ef | grep -E "(PID|bash)"

# 批量显示进程信息
ps -p $(pgrep bash)
```

### 7.3 批量操作
```bash
#!/bin/bash

# 批量显示进程信息
commands=("bash" "nginx" "mysql")

for cmd in "${commands[@]}"; do
    echo "\n=== 命令 $cmd 的进程 ==="
    ps -C $cmd
done
```

### 7.4 自动化脚本
```bash
#!/bin/bash

# 自动化显示进程信息
display_processes() {
    local options=${1:-"-ef"}
    local filter=${2:-""}
    
    echo "显示进程信息:"
    if [ -n "$filter" ]; then
        ps $options | grep $filter
    else
        ps $options
    fi
}

# 使用函数
display_processes
display_processes "-ef" "bash"
display_processes "-el" "nginx"
```

## 8. 常见问题与解决方案

### 8.1 问题：ps: command not found
**解决方案**：安装 procps
- Ubuntu/Debian: `apt install procps`
- CentOS/RHEL: `yum install procps`

### 8.2 问题：无法显示所有进程
**解决方案**：使用 -e 选项
```bash
ps -e
```

### 8.3 问题：无法显示完整命令
**解决方案**：使用 -f 选项
```bash
ps -ef
```

### 8.4 问题：ps 命令执行缓慢
**解决方案**：系统进程较多，这是正常现象

### 8.5 问题：无法按CPU使用率排序
**解决方案**：使用 --sort 选项
```bash
ps --sort=-%cpu
```

## 9. 命令对比

| 命令 | 功能 | 适用场景 |
|------|------|----------|
| ps | 显示进程状态 | 所有 Linux 系统 |
| top | 实时显示系统进程 | 所有 Linux 系统 |
| htop | 交互式进程查看器 | 所有 Linux 系统 |
| pstree | 显示进程树 | 所有 Linux 系统 |

## 10. 注意事项
- ps 命令用于显示进程状态，是 Linux 系统中常用的进程管理命令之一
- ps 命令可以显示当前系统中运行的进程信息
- 常用的操作包括：基本用法、显示指定进程、自定义输出格式等
- ps 命令不需要 root 权限来执行
- ps 命令支持多种选项，可以根据需要选择合适的选项
- ps 命令是所有 Linux 系统的标准工具，用于显示进程状态