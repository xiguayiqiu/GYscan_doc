# reboot - 重启系统

## 1. 命令简介
reboot 命令用于重启系统，是 Linux 系统中常用的系统管理命令之一。它可以安全地重启系统，确保所有进程都能正常关闭。

## 2. 命令语法
```bash
reboot [选项]
```

## 3. 常用选项

| 选项 | 说明 |
|------|------|
| -h, --help | 显示帮助信息 |
| --version | 显示版本信息 |
| -f, --force | 强制重启 |
| -w, --wtmp-only | 只更新 wtmp 文件，不实际重启 |
| -d, --no-wtmp | 不更新 wtmp 文件 |
| -n, --no-sync | 不同步文件系统 |

## 4. 实战示例

### 4.1 基本用法
```bash
sudo reboot
```

### 4.2 强制重启
```bash
sudo reboot -f
```

### 4.3 只更新 wtmp 文件
```bash
sudo reboot -w
```

### 4.4 不更新 wtmp 文件
```bash
sudo reboot -d
```

### 4.5 不同步文件系统
```bash
sudo reboot -n
```

## 5. 高级用法

### 5.1 与其他命令结合使用
```bash
# 执行命令后重启
echo "系统将在 5 秒后重启" && sleep 5 && sudo reboot

# 检查系统状态后重启
if [ -f "/var/run/reboot-required" ]; then
    echo "系统需要重启"
    sudo reboot
else
    echo "系统不需要重启"
fi
```

### 5.2 自动化重启
```bash
#!/bin/bash

# 自动化重启
echo "系统将在 10 秒后重启"
echo "按 Ctrl+C 取消"

for i in {10..1}; do
    echo -ne "$i...\r"
    sleep 1
done

echo "\n重启系统..."
sudo reboot
```

### 5.3 定时重启
```bash
#!/bin/bash

# 定时重启
echo "设置定时重启"
echo "系统将在今天 23:59 重启"

sudo shutdown -r 23:59
```

## 6. 常见问题与解决方案

### 6.1 问题：reboot: command not found
**解决方案**：安装 coreutils
- Ubuntu/Debian: `apt install coreutils`
- CentOS/RHEL: `yum install coreutils`

### 6.2 问题：无法重启系统
**解决方案**：确保有足够的权限
```bash
sudo reboot
```

### 6.3 问题：重启失败
**解决方案**：检查系统状态和硬件

### 6.4 问题：reboot 命令执行缓慢
**解决方案**：系统正在关闭进程，这是正常现象

### 6.5 问题：重启后系统无法启动
**解决方案**：检查启动加载器和系统配置

## 7. 命令对比

| 命令 | 功能 | 适用场景 |
|------|------|----------|
| reboot | 重启系统 | 所有 Linux 系统 |
| shutdown | 关闭系统 | 所有 Linux 系统 |
| halt | 停止系统 | 所有 Linux 系统 |
| poweroff | 关闭电源 | 所有 Linux 系统 |
| systemctl | 控制系统和服务 | systemd 系统 |

## 8. 注意事项
- reboot 命令用于重启系统，是 Linux 系统中常用的系统管理命令之一
- reboot 命令可以安全地重启系统，确保所有进程都能正常关闭
- 常用的操作包括：基本用法、强制重启、只更新 wtmp 文件等
- reboot 命令需要 root 权限来执行
- reboot 命令支持多种选项，可以根据需要选择合适的选项
- reboot 命令是所有 Linux 系统的标准工具，用于重启系统