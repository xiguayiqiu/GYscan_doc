# shutdown - 关闭系统

## 1. 命令简介
shutdown 命令用于关闭系统，是 Linux 系统中常用的系统管理命令之一。它可以安全地关闭系统，并支持定时关闭。

## 2. 命令语法
```bash
shutdown [选项] [时间] [消息]
```

## 3. 常用选项

| 选项 | 说明 |
|------|------|
| -h, --help | 显示帮助信息 |
| --version | 显示版本信息 |
| -r, --reboot | 重启系统 |
| -h, --halt | 停止系统 |
| -P, --poweroff | 关闭电源 |
| -c, --cancel | 取消关闭 |
| -k, --kill | 发送警告消息但不关闭 |

## 4. 时间格式

| 时间格式 | 说明 |
|---------|------|
| now | 立即执行 |
| +m | m 分钟后执行 |
| hh:mm | 在指定时间执行 |

## 5. 实战示例

### 5.1 立即关闭系统
```bash
sudo shutdown now
```

### 5.2 定时关闭系统
```bash
# 5 分钟后关闭系统
sudo shutdown +5

# 在指定时间关闭系统
sudo shutdown 23:59
```

### 5.3 重启系统
```bash
sudo shutdown -r now
```

### 5.4 停止系统
```bash
sudo shutdown -h now
```

### 5.5 关闭电源
```bash
sudo shutdown -P now
```

### 5.6 取消关闭
```bash
sudo shutdown -c
```

### 5.7 发送警告消息
```bash
sudo shutdown -k +5 "系统将在 5 分钟后关闭"
```

## 6. 高级用法

### 6.1 与其他命令结合使用
```bash
# 执行命令后关闭系统
echo "系统将在 5 秒后关闭" && sleep 5 && sudo shutdown now

# 检查系统状态后关闭系统
if [ -f "/var/run/shutdown-required" ]; then
    echo "系统需要关闭"
    sudo shutdown now
else
    echo "系统不需要关闭"
fi
```

### 6.2 自动化关闭
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
sudo shutdown now
```

### 6.3 定时关闭并发送消息
```bash
#!/bin/bash

# 定时关闭并发送消息
echo "设置定时关闭"
echo "系统将在今天 23:59 关闭"
echo "正在发送警告消息..."

sudo shutdown 23:59 "系统将在今天 23:59 关闭，请保存您的工作"
```

## 7. 常见问题与解决方案

### 7.1 问题：shutdown: command not found
**解决方案**：安装 coreutils
- Ubuntu/Debian: `apt install coreutils`
- CentOS/RHEL: `yum install coreutils`

### 7.2 问题：无法关闭系统
**解决方案**：确保有足够的权限
```bash
sudo shutdown now
```

### 7.3 问题：关闭失败
**解决方案**：检查系统状态和硬件

### 7.4 问题：shutdown 命令执行缓慢
**解决方案**：系统正在关闭进程，这是正常现象

### 7.5 问题：无法取消关闭
**解决方案**：使用 -c 选项
```bash
sudo shutdown -c
```

## 8. 命令对比

| 命令 | 功能 | 适用场景 |
|------|------|----------|
| shutdown | 关闭系统 | 所有 Linux 系统 |
| poweroff | 关闭电源 | 所有 Linux 系统 |
| halt | 停止系统 | 所有 Linux 系统 |
| reboot | 重启系统 | 所有 Linux 系统 |
| systemctl | 控制系统和服务 | systemd 系统 |

## 9. 注意事项
- shutdown 命令用于关闭系统，是 Linux 系统中常用的系统管理命令之一
- shutdown 命令可以安全地关闭系统，并支持定时关闭
- 常用的操作包括：立即关闭系统、定时关闭系统、重启系统、停止系统等
- shutdown 命令需要 root 权限来执行
- shutdown 命令支持多种选项，可以根据需要选择合适的选项
- shutdown 命令是所有 Linux 系统的标准工具，用于关闭系统