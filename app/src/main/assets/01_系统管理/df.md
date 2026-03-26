# df - 显示磁盘使用情况

## 1. 命令简介
df 命令用于显示磁盘使用情况，是 Linux 系统中常用的系统管理命令之一。它可以显示文件系统的磁盘空间使用情况，包括总空间、已用空间和可用空间。

## 2. 命令语法
```bash
df [选项] [文件或目录...]
```

## 3. 常用选项

| 选项 | 说明 |
|------|------|
| -h, --help | 显示帮助信息 |
| --version | 显示版本信息 |
| -h, --human-readable | 以人类可读的格式显示大小 |
| -H, --si | 以 SI 单位显示大小 |
| -T, --print-type | 显示文件系统类型 |
| -t, --type=<类型> | 只显示指定类型的文件系统 |
| -x, --exclude-type=<类型> | 排除指定类型的文件系统 |
| -a, --all | 显示所有文件系统 |
| --total | 显示总计 |

## 4. 实战示例

### 4.1 基本用法
```bash
# 显示所有文件系统的磁盘使用情况
df

# 显示指定文件系统的磁盘使用情况
df /dev/sda1
```

### 4.2 以人类可读的格式显示
```bash
df -h
```

### 4.3 显示文件系统类型
```bash
df -T
```

### 4.4 只显示指定类型的文件系统
```bash
df -t ext4
```

### 4.5 排除指定类型的文件系统
```bash
df -x tmpfs
```

### 4.6 显示所有文件系统
```bash
df -a
```

### 4.7 显示总计
```bash
df --total
```

## 5. 高级用法

### 5.1 组合选项
```bash
# 以人类可读的格式显示文件系统类型
df -hT

# 只显示 ext4 类型的文件系统，以人类可读的格式显示
df -ht ext4
```

### 5.2 与其他命令结合使用
```bash
# 显示磁盘使用情况并排序
df -h | sort -k 5 -n

# 显示磁盘使用情况并只显示使用率超过 80% 的文件系统
df -h | awk '{if ($5 > 80) print $0}'

# 监控磁盘使用情况
watch -n 1 df -h
```

### 5.3 批量操作
```bash
#!/bin/bash

# 批量检查文件系统
devices=("/dev/sda1" "/dev/sda2" "/dev/sdb1")

echo "检查文件系统:"
for device in "${devices[@]}"; do
    echo "\n=== $device ==="
    df -h $device
done
```

### 5.4 自动化脚本
```bash
#!/bin/bash

# 自动化检查磁盘使用情况
check_disk() {
    local options=${1:-"-h"}
    local path=${2:-.}
    
    echo "检查 $path 的磁盘使用情况:"
    df $options $path
}

# 使用函数
check_disk
check_disk "-hT" "/"
check_disk "-ht ext4" "/home"
```

## 6. 常见问题与解决方案

### 6.1 问题：df: command not found
**解决方案**：安装 coreutils
- Ubuntu/Debian: `apt install coreutils`
- CentOS/RHEL: `yum install coreutils`

### 6.2 问题：无法显示磁盘使用情况
**解决方案**：确保有足够的权限
```bash
sudo df
```

### 6.3 问题：磁盘使用情况显示错误
**解决方案**：检查文件系统
```bash
sudo fsck /dev/sda1
```

### 6.4 问题：df 命令执行缓慢
**解决方案**：文件系统问题，检查磁盘状态

### 6.5 问题：无法显示指定类型的文件系统
**解决方案**：使用正确的类型名称
```bash
df -t ext4
```

## 7. 命令对比

| 命令 | 功能 | 适用场景 |
|------|------|----------|
| df | 显示磁盘使用情况 | 所有 Linux 系统 |
| du | 显示目录大小 | 所有 Linux 系统 |
| lsblk | 显示块设备信息 | 所有 Linux 系统 |
| fdisk | 磁盘分区管理 | 所有 Linux 系统 |

## 8. 注意事项
- df 命令用于显示磁盘使用情况，是 Linux 系统中常用的系统管理命令之一
- df 命令可以显示文件系统的磁盘空间使用情况，包括总空间、已用空间和可用空间
- 常用的操作包括：基本用法、以人类可读的格式显示、显示文件系统类型、只显示指定类型的文件系统等
- df 命令不需要 root 权限来执行
- df 命令支持多种选项，可以根据需要选择合适的选项
- df 命令是所有 Linux 系统的标准工具，用于显示磁盘使用情况