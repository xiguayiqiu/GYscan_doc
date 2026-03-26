# Shell 后台运行

## 命令简介

Shell 后台运行用于在后台执行命令，不阻塞当前终端，是 Shell 命令中常用的功能。

## 后台运行符号

| 符号 | 说明 | 示例 |
|------|------|------|
| `&` | 后台运行：在后台执行命令 | `command &` |

## 命令示例

### 在后台执行命令

```bash
long_running_command &
```

### 在后台执行命令并将输出重定向到文件

```bash
long_running_command > output.txt 2>&1 &
```

### 查看后台运行的命令

```bash
jobs
```

### 将后台命令切换到前台

```bash
fg %1
```

### 将前台命令切换到后台

1. 按下 `Ctrl+Z` 暂停命令
2. 执行 `bg` 命令将其切换到后台

## 常用组合

### 在后台执行多个命令

```bash
(command1; command2; command3) &
```

### 在后台执行命令并忽略挂起信号

```bash
nohup long_running_command &
```

### 在后台执行命令并定期检查状态

```bash
long_running_command &
while ps -p $! > /dev/null; do
    sleep 10
    echo "Command is still running..."
done
echo "Command completed"
```

## 相关命令

- `jobs`: 显示后台作业
- `fg`: 将作业放到前台
- `bg`: 将作业放到后台
- `nohup`: 忽略挂起信号运行命令
- `ps`: 显示进程状态