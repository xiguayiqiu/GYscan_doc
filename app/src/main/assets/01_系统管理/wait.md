# wait - 等待进程完成

## 1. 命令简介
wait 命令用于等待后台进程完成，是 Linux 系统中常用的系统管理命令之一。它可以暂停当前脚本的执行，直到指定的进程或所有后台进程完成。

## 2. 命令语法
```bash
wait [进程ID...]
```

## 3. 实战示例

### 3.1 等待所有后台进程完成
```bash
# 启动后台进程
command1 &
command2 &

# 等待所有后台进程完成
wait

echo "所有进程已完成"
```

### 3.2 等待指定的进程完成
```bash
# 启动后台进程
command1 &
p1=$!

command2 &
p2=$!

# 等待进程 1 完成
wait $p1
echo "进程 1 已完成"

# 等待进程 2 完成
wait $p2
echo "进程 2 已完成"
```

### 3.3 在脚本中使用
```bash
#!/bin/bash

# 启动多个后台进程
echo "启动后台进程"
sleep 5 &
p1=$!

sleep 10 &
p2=$!

# 等待所有进程完成
echo "等待进程完成"
wait

echo "所有进程已完成"
```

### 3.4 等待作业完成
```bash
# 启动作业
command &

# 等待作业完成
wait %1
echo "作业已完成"
```

## 4. 高级用法

### 4.1 在脚本中管理进程
```bash
#!/bin/bash

# 启动并等待进程
start_and_wait() {
    local command=$1
    
    echo "启动进程: $command"
    $command &
    
    local pid=$!
    echo "进程 ID: $pid"
    
    # 等待进程完成
    wait $pid
    echo "进程已完成"
}

# 使用函数
start_and_wait "sleep 5"
start_and_wait "echo 'Hello World'"
```

### 4.2 批量管理进程
```bash
#!/bin/bash

# 启动多个进程
echo "启动多个进程"
pids=()

for i in {1..5}; do
    sleep $((i * 2)) &
    pids+=($!)
done

# 等待所有进程完成
echo "等待所有进程完成"
for pid in "${pids[@]}"; do
    wait $pid
    echo "进程 $pid 已完成"
done

echo "所有进程已完成"
```

### 4.3 与其他命令结合使用
```bash
# 启动进程并等待
command & wait

# 启动多个进程并等待
command1 & command2 & wait

# 等待进程完成并获取退出状态
command &
wait $!
echo "进程退出状态: $?"
```

### 4.4 监控进程执行时间
```bash
#!/bin/bash

# 监控进程执行时间
echo "监控进程执行时间"

# 记录开始时间
start_time=$(date +%s)

# 启动进程
sleep 5 &

# 等待进程完成
wait

# 记录结束时间
end_time=$(date +%s)

execution_time=$((end_time - start_time))
echo "进程执行时间: $execution_time 秒"
```

## 5. 常见问题与解决方案

### 5.1 问题：wait: command not found
**解决方案**：wait 是 shell 内置命令，确保使用支持它的 shell（如 bash）

### 5.2 问题：wait 命令无法找到进程
**解决方案**：确保进程存在，使用 ps 命令查看进程状态

### 5.3 问题：wait 命令执行后脚本卡住
**解决方案**：wait 命令会等待进程完成，这是正常现象

### 5.4 问题：wait 命令无法等待所有进程完成
**解决方案**：确保所有进程都在后台运行，使用 & 符号

### 5.5 问题：wait 命令在脚本中不工作
**解决方案**：确保脚本在支持 wait 命令的 shell 中运行

### 5.6 问题：wait 命令无法与某些命令结合使用
**解决方案**：确保命令在后台运行，使用 & 符号

## 6. 命令对比

| 命令 | 功能 | 适用场景 |
|------|------|----------|
| wait | 等待进程完成 | 等待后台作业执行完成 |
| sleep | 暂停执行 | 控制命令执行间隔 |
| timeout | 设置命令超时 | 限制命令执行时间 |
| nohup | 忽略挂起信号运行命令 | 后台长时间运行任务 |
| disown | 从作业表中移除作业 | 使作业与终端脱离关系 |

## 7. 注意事项
- wait 命令用于等待后台进程完成，是 Linux 系统中常用的系统管理命令之一
- wait 命令可以暂停当前脚本的执行，直到指定的进程或所有后台进程完成
- 常用的操作包括：等待所有后台进程完成、等待指定的进程完成、在脚本中管理进程等
- wait 是 shell 内置命令，几乎所有 Linux 系统的默认 shell 都支持
- wait 命令可以等待单个进程或多个进程完成
- wait 命令的执行不会影响进程的功能，只会等待进程完成
- wait 命令适合用于需要确保后台进程完成后再执行后续操作的场景