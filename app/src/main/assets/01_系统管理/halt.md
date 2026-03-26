# halt - 停止系统

## 1. 命令简介
halt 命令用于停止系统，是 Linux 系统中常用的系统管理命令之一。它可以安全地停止系统，但不会切断电源。

## 2. 命令语法
```bash
halt [选项]
```

## 3. 常用选项

| 选项 | 说明 |
|------|------|
| -h, --help | 显示帮助信息 |
| --version | 显示版本信息 |
| -f, --force | 强制停止 |
| -w, --wtmp-only | 只更新 wtmp 文件，不实际停止 |
| -d, --no-wtmp | 不更新 wtmp 文件 |
| -n, --no-sync | 不同步文件系统 |

## 4. 实战示例

### 4.1 基本用法
```bash
sudo halt
```

### 4.2 强制停止
```bash
sudo halt -f
```

### 4.3 只更新 wtmp 文件
```bash
sudo halt -w
```

### 4.4 不更新 wtmp 文件
```bash
sudo halt -d
```

### 4.5 不同步文件系统
```bash
sudo halt -n
```

## 5. 高级用法

### 5.1 与其他命令结合使用
```bash
# 执行命令后停止系统
echo "系统将在 5 秒后停止" && sleep 5 && sudo halt

# 检查系统状态后停止系统
if [ -f "/var/run/shutdown-required" ]; then
    echo "系统需要停止"
    sudo halt
else
    echo "系统不需要停止"
fi
```

### 5.2 自动化停止
```bash
#!/bin/bash

# 自动化停止
echo "系统将在 10 秒后停止"
echo "按 Ctrl+C 取消"

for i in {10..1}; do
    echo -ne "$i...\r"
    sleep 1
done

echo "\n停止系统..."
sudo halt
```

### 5.3 定时停止
```bash
#!/bin/bash

# 定时停止
echo "设置定时停止"
echo "系统将在今天 23:59 停止"

sudo shutdown -H 23:59
```

## 6. 常见问题与解决方案

### 6.1 问题：halt: command not found
**解决方案**：安装 coreutils
- Ubuntu/Debian: `apt install coreutils`
- CentOS/RHEL: `yum install coreutils`

### 6.2 问题：无法停止系统
**解决方案**：确保有足够的权限
```bash
sudo halt
```

### 6.3 问题：停止失败
**解决方案**：检查系统状态和硬件

### 6.4 问题：halt 命令执行缓慢
**解决方案**：系统正在关闭进程，这是正常现象

### 6.5 问题：停止后系统无法启动
**解决方案**：检查电源和硬件

## 7. 命令对比

| 命令 | 功能 | 适用场景 |
|------|------|----------|
| halt | 停止系统 | 所有 Linux 系统 |
| shutdown | 关闭系统 | 所有 Linux 系统 |
| poweroff | 关闭电源 | 所有 Linux 系统 |
| reboot | 重启系统 | 所有 Linux 系统 |
| systemctl | 控制系统和服务 | systemd 系统 |

## 8. 注意事项
- halt 命令用于停止系统，是 Linux 系统中常用的系统管理命令之一
- halt 命令可以安全地停止系统，但不会切断电源
- 常用的操作包括：基本用法、强制停止、只更新 wtmp 文件等
- halt 命令需要 root 权限来执行
- halt 命令支持多种选项，可以根据需要选择合适的选项
- halt 命令是所有 Linux 系统的标准工具，用于停止系统