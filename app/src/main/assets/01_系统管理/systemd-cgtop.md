# systemd-cgtop - 显示控制组资源使用情况

## 1. 命令简介
systemd-cgtop 命令用于显示控制组资源使用情况，是 Linux 系统中常用的系统管理命令之一。它是 systemd 系统的一部分，用于实时监控控制组的 CPU、内存、IO 等资源使用情况。

## 2. 命令语法
```bash
systemd-cgtop [选项]
```

## 3. 常用选项

| 选项 | 说明 |
|------|------|
| -h, --help | 显示帮助信息 |
| --version | 显示版本信息 |
| -p, --raw | 以原始格式输出 |
| -d, --delay=<秒数> | 设置更新间隔 |
| -k, --cpu | 按 CPU 使用率排序 |
| -m, --memory | 按内存使用率排序 |
| -i, --io | 按 IO 使用率排序 |
| -b, --batch | 批处理模式 |

## 4. 实战示例

### 4.1 基本用法
```bash
systemd-cgtop
```

### 4.2 设置更新间隔
```bash
systemd-cgtop -d 1
```

### 4.3 按 CPU 使用率排序
```bash
systemd-cgtop -k
```

### 4.4 按内存使用率排序
```bash
systemd-cgtop -m
```

### 4.5 按 IO 使用率排序
```bash
systemd-cgtop -i
```

### 4.6 批处理模式
```bash
systemd-cgtop -b
```

### 4.7 以原始格式输出
```bash
systemd-cgtop -p
```

## 5. 高级用法

### 5.1 监控特定控制组
```bash
# 监控特定控制组
systemd-cgtop | grep <控制组名称>

# 监控多个控制组
systemd-cgtop | grep -E "<控制组1>|<控制组2>"
```

### 5.2 与其他命令结合使用
```bash
# 监控控制组并保存结果
systemd-cgtop -b -d 5 > cgtop.log

# 分析控制组资源使用情况
systemd-cgtop -b -n 10 | sort -k 3 -r
```

### 5.3 监控系统资源使用
```bash
# 同时监控控制组和系统资源
top & systemd-cgtop
```

### 5.4 自动化监控
```bash
#!/bin/bash

# 监控控制组资源使用情况
echo "监控控制组资源使用情况，按 Ctrl+C 退出"

while true; do
    echo "\n$(date)"
    systemd-cgtop -b -n 10
    sleep 60
done
```

## 6. 常见问题与解决方案

### 6.1 问题：systemd-cgtop: command not found
**解决方案**：安装 systemd
- Ubuntu/Debian: `apt install systemd`
- CentOS/RHEL: `yum install systemd`

### 6.2 问题：无法显示控制组资源使用情况
**解决方案**：确保控制组已启用
```bash
sudo systemctl status cgconfig
```

### 6.3 问题：systemd-cgtop 命令执行缓慢
**解决方案**：增加更新间隔
```bash
systemd-cgtop -d 5
```

### 6.4 问题：无法按特定资源排序
**解决方案**：使用相应的排序选项
```bash
systemd-cgtop -k  # 按 CPU 排序
systemd-cgtop -m  # 按内存排序
systemd-cgtop -i  # 按 IO 排序
```

### 6.5 问题：无法在批处理模式下运行
**解决方案**：使用 -b 选项
```bash
systemd-cgtop -b
```

## 7. 命令对比

| 命令 | 功能 | 适用场景 |
|------|------|----------|
| systemd-cgtop | 显示控制组资源使用情况 | systemd 系统 |
| top | 显示进程资源使用情况 | 所有 Linux 系统 |
| htop | 交互式进程查看器 | 所有 Linux 系统 |
| iotop | 显示 IO 资源使用情况 | 所有 Linux 系统 |
| vmstat | 虚拟内存统计 | 所有 Linux 系统 |

## 8. 注意事项
- systemd-cgtop 命令用于显示控制组资源使用情况，是 Linux 系统中常用的系统管理命令之一
- systemd-cgtop 命令是 systemd 系统的一部分，用于实时监控控制组的 CPU、内存、IO 等资源使用情况
- 常用的操作包括：基本用法、设置更新间隔、按资源使用率排序等
- systemd-cgtop 命令不需要 root 权限来执行
- systemd-cgtop 命令支持多种选项，可以根据需要选择合适的选项
- systemd-cgtop 命令是现代 Linux 系统的标准工具，用于监控控制组资源使用情况