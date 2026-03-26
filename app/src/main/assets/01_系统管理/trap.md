# trap - 捕获信号

## 1. 命令简介
trap 命令用于捕获并处理信号，是 Linux 系统中常用的系统管理命令之一。它可以在脚本中设置信号处理程序，当接收到指定的信号时执行相应的操作。

## 2. 命令语法
```bash
trap [选项] [动作] [信号...]
```

## 3. 常用信号

| 信号 | 说明 |
|------|------|
| SIGINT (2) | 中断信号（Ctrl+C） |
| SIGTERM (15) | 终止信号 |
| SIGQUIT (3) | 退出信号（Ctrl+\） |
| SIGKILL (9) | 强制终止信号（不可捕获） |
| SIGHUP (1) | 挂起信号 |
| SIGUSR1 (10) | 用户定义信号 1 |
| SIGUSR2 (12) | 用户定义信号 2 |
| EXIT (0) | 脚本退出时 |
| ERR | 命令执行失败时 |

## 4. 实战示例

### 4.1 捕获 SIGINT 信号
```bash
#!/bin/bash

# 捕获 SIGINT 信号
trap "echo '捕获到 SIGINT 信号'" SIGINT

echo "脚本运行中，按 Ctrl+C 测试"
sleep 10
echo "脚本正常结束"
```

### 4.2 捕获多个信号
```bash
#!/bin/bash

# 捕获多个信号
trap "echo '捕获到信号'" SIGINT SIGTERM SIGQUIT

echo "脚本运行中，按 Ctrl+C 或发送其他信号测试"
sleep 10
echo "脚本正常结束"
```

### 4.3 捕获退出信号
```bash
#!/bin/bash

# 捕获退出信号
trap "echo '脚本退出'" EXIT

echo "脚本运行中"
sleep 5
echo "脚本正常结束"
```

### 4.4 捕获错误信号
```bash
#!/bin/bash

# 捕获错误信号
trap "echo '命令执行失败'" ERR

echo "脚本运行中"
# 故意执行一个不存在的命令
nonexistent_command
echo "脚本继续执行"
sleep 2
echo "脚本正常结束"
```

### 4.5 重置信号处理
```bash
#!/bin/bash

# 捕获 SIGINT 信号
trap "echo '捕获到 SIGINT 信号'" SIGINT

echo "脚本运行中，按 Ctrl+C 测试"
sleep 5

# 重置 SIGINT 信号处理
trap - SIGINT
echo "已重置 SIGINT 信号处理，按 Ctrl+C 测试"
sleep 5
echo "脚本正常结束"
```

## 5. 高级用法

### 5.1 在脚本中使用复杂的信号处理
```bash
#!/bin/bash

# 定义信号处理函数
cleanup() {
    echo "清理资源"
    # 执行清理操作
    rm -f temporary_file.txt
    echo "清理完成"
    exit 0
}

# 捕获信号
trap cleanup SIGINT SIGTERM EXIT

echo "脚本运行中，按 Ctrl+C 测试"

# 创建临时文件
touch temporary_file.txt
echo "创建临时文件"

# 模拟长时间运行
sleep 10
echo "脚本正常结束"
```

### 5.2 批量处理信号
```bash
#!/bin/bash

# 定义信号处理函数
handle_signal() {
    local signal=$1
    echo "捕获到信号: $signal"
}

# 批量捕获信号
signals=(SIGINT SIGTERM SIGQUIT SIGHUP)

for signal in "${signals[@]}"; do
    trap "handle_signal $signal" $signal
done

echo "脚本运行中，发送信号测试"
sleep 20
echo "脚本正常结束"
```

### 5.3 与其他命令结合使用
```bash
#!/bin/bash

# 捕获信号并记录日志
trap "echo $(date) '捕获到信号' >> signal.log" SIGINT SIGTERM

echo "脚本运行中，按 Ctrl+C 测试"
sleep 10
echo "脚本正常结束"
```

### 5.4 监控脚本执行
```bash
#!/bin/bash

# 定义信号处理函数
handle_sigint() {
    echo "用户中断，脚本退出"
    exit 1
}

# 捕获 SIGINT 信号
trap handle_sigint SIGINT

echo "脚本开始执行"

# 执行主任务
for i in {1..10}; do
    echo "执行任务 $i"
    sleep 1
done

echo "脚本执行完成"
```

## 6. 常见问题与解决方案

### 6.1 问题：trap: command not found
**解决方案**：trap 是 shell 内置命令，确保使用支持它的 shell（如 bash）

### 6.2 问题：trap 命令无法捕获某些信号
**解决方案**：某些信号（如 SIGKILL）是不可捕获的

### 6.3 问题：trap 命令的信号处理函数不执行
**解决方案**：确保信号处理函数的语法正确，并且脚本在后台运行时也能接收信号

### 6.4 问题：trap 命令执行后脚本卡住
**解决方案**：确保信号处理函数不会导致死循环

### 6.5 问题：trap 命令在脚本中不工作
**解决方案**：确保脚本在支持 trap 命令的 shell 中运行

### 6.6 问题：trap 命令无法与某些命令结合使用
**解决方案**：确保命令在正确的上下文中执行

## 7. 命令对比

| 命令 | 功能 | 适用场景 |
|------|------|----------|
| trap | 捕获并处理信号 | 脚本信号处理 |
| kill | 发送信号 | 进程管理 |
| signal | 信号相关函数 | 程序信号处理 |
| wait | 等待进程完成 | 后台作业管理 |
| nohup | 忽略挂起信号 | 后台运行命令 |

## 8. 注意事项
- trap 命令用于捕获并处理信号，是 Linux 系统中常用的系统管理命令之一
- trap 命令可以在脚本中设置信号处理程序，当接收到指定的信号时执行相应的操作
- 常用的操作包括：捕获 SIGINT 信号、捕获多个信号、捕获退出信号、捕获错误信号等
- trap 是 shell 内置命令，几乎所有 Linux 系统的默认 shell 都支持
- trap 命令可以捕获大多数信号，但某些信号（如 SIGKILL）是不可捕获的
- 使用 trap 命令可以在脚本中实现优雅的退出和清理操作
- trap 命令的执行不会影响脚本的功能，只会在接收到信号时执行相应的操作