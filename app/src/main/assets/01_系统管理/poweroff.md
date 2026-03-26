# poweroff - 关闭电源

## 1. 命令简介
poweroff 命令用于关闭电源，是 Linux 系统中常用的系统管理命令之一。它可以安全地关闭系统并切断电源。

## 2. 命令语法
```bash
poweroff [选项]
```

## 3. 常用选项

| 选项 | 说明 |
|------|------|
| -h, --help | 显示帮助信息 |
| --version | 显示版本信息 |
| -f, --force | 强制关闭 |
| -w, --wtmp-only | 只更新 wtmp 文件，不实际关闭 |
| -d, --no-wtmp | 不更新 wtmp 文件 |
| -n, --no-sync | 不同步文件系统 |

## 4. 实战示例

### 4.1 基本用法
```bash
sudo poweroff
```

### 4.2 强制关闭
```bash
sudo poweroff -f
```

### 4.3 只更新 wtmp 文件
```bash
sudo poweroff -w
```

### 4.4 不更新 wtmp 文件
```bash
sudo poweroff -d
```

### 4.5 不同步文件系统
```bash
sudo poweroff -n
```

## 5. 高级用法

### 5.1 与其他命令结合使用
```bash
# 执行命令后关闭电源
echo "系统将在 5 秒后关闭" && sleep 5 && sudo poweroff

# 检查系统状态后关闭电源
if [ -f "/var/run/shutdown-required" ]; then
    echo "系统需要关闭"
    sudo poweroff
else
    echo "系统不需要关闭"
fi
```

### 5.2 自动化关闭
```bash
#!/bin/bash

# 自动化关闭
echo "系统将在 10 秒后关闭"
echo "按 Ctrl+C 取消"

for i in {10..1}; do
    echo -ne "$i...\r"
    sleep 1
done

echo "\n关闭系统..."
sudo poweroff
```

### 5.3 定时关闭
```bash
#!/bin/bash

# 定时关闭
echo "设置定时关闭"
echo "系统将在今天 23:59 关闭"

sudo shutdown -P 23:59
```

## 6. 常见问题与解决方案

### 6.1 问题：poweroff: command not found
**解决方案**：安装 coreutils
- Ubuntu/Debian: `apt install coreutils`
- CentOS/RHEL: `yum install coreutils`

### 6.2 问题：无法关闭系统
**解决方案**：确保有足够的权限
```bash
sudo poweroff
```

### 6.3 问题：关闭失败
**解决方案**：检查系统状态和硬件

### 6.4 问题：poweroff 命令执行缓慢
**解决方案**：系统正在关闭进程，这是正常现象

### 6.5 问题：关闭后系统无法启动
**解决方案**：检查电源和硬件

## 7. 命令对比

| 命令 | 功能 | 适用场景 |
|------|------|----------|
| poweroff | 关闭电源 | 所有 Linux 系统 |
| shutdown | 关闭系统 | 所有 Linux 系统 |
| halt | 停止系统 | 所有 Linux 系统 |
| reboot | 重启系统 | 所有 Linux 系统 |
| systemctl | 控制系统和服务 | systemd 系统 |

## 8. 注意事项
- poweroff 命令用于关闭电源，是 Linux 系统中常用的系统管理命令之一
- poweroff 命令可以安全地关闭系统并切断电源
- 常用的操作包括：基本用法、强制关闭、只更新 wtmp 文件等
- poweroff 命令需要 root 权限来执行
- poweroff 命令支持多种选项，可以根据需要选择合适的选项
- poweroff 命令是所有 Linux 系统的标准工具，用于关闭电源