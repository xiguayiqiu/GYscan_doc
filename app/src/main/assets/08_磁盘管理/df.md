# df - 显示磁盘空间使用情况

## 1. 命令简介
df 命令用于显示文件系统的磁盘空间使用情况，是 Linux 系统中最常用的磁盘空间查看工具。它可以显示文件系统的总空间、已用空间、可用空间和挂载点等信息。

## 2. 命令语法
```bash
df [选项] [文件或目录]
df [选项] --total
```

## 3. 常用选项

| 选项 | 说明 |
|------|------|
| -h, --human-readable | 以人类可读的格式显示 |
| -a, --all | 显示所有文件系统，包括特殊文件系统 |
| -T, --print-type | 显示文件系统类型 |
| -i, --inodes | 显示inode使用情况 |
| -k | 以KB为单位显示 |
| -m | 以MB为单位显示 |
| -P, --portability | 使用POSIX格式输出 |
| --total | 显示总计信息 |
| -t, --type=<类型> | 只显示指定类型的文件系统 |
| -x, --exclude-type=<类型> | 排除指定类型的文件系统 |
| --help | 显示帮助信息 |
| --version | 显示版本信息 |

## 4. 实战示例

### 4.1 显示所有文件系统的磁盘空间使用情况
```bash
df -h
```

### 4.2 显示指定文件系统的磁盘空间使用情况
```bash
df -h /dev/sda1
```

### 4.3 显示文件系统类型
```bash
df -Th
```

### 4.4 显示inode使用情况
```bash
df -i
```

### 4.5 显示特定目录所在文件系统的使用情况
```bash
df -h /home
```

### 4.6 显示总计信息
```bash
df -h --total
```

### 4.7 只显示特定类型的文件系统
```bash
df -h -t ext4
```

### 4.8 排除特定类型的文件系统
```bash
df -h -x tmpfs
```

## 5. 高级用法

### 5.1 在脚本中使用df
```bash
#!/bin/bash

# 检查磁盘空间使用情况
echo "磁盘空间使用情况:"
df -h

# 检查特定文件系统的使用情况
echo "\n根文件系统使用情况:"
df -h /

# 检查inode使用情况
echo "\ninode使用情况:"
df -i

# 检查磁盘空间是否不足
root_usage=$(df -h / | grep '/' | awk '{print $5}' | sed 's/%//')
if [ $root_usage -gt 90 ]; then
    echo "\n警告: 根文件系统空间不足！"
elif [ $root_usage -gt 80 ]; then
    echo "\n注意: 根文件系统空间紧张。"
else
    echo "\n根文件系统空间正常。"
fi
```

### 5.2 结合其他命令使用
```bash
# 显示磁盘空间使用情况并按使用百分比排序
df -h | sort -k 5 -n

# 显示磁盘空间使用情况并只显示本地文件系统
df -h -x tmpfs -x devtmpfs -x devfs

# 检查特定目录的磁盘使用情况
df -h /home && du -h --max-depth=1 /home
```

### 5.3 监控磁盘空间
```bash
#!/bin/bash

# 监控磁盘空间使用情况
while true; do
    clear
    echo "磁盘空间监控"
    echo "----------------"
    df -h
    echo "----------------"
    echo "按 Ctrl+C 退出"
    sleep 5
done
```

### 5.4 批量检查多个挂载点
```bash
#!/bin/bash

# 批量检查多个挂载点
mount_points=(/ /home /var /tmp)

for mount in "${mount_points[@]}"; do
    echo "=== $mount ==="
    df -h $mount
    echo
done
```

## 6. 常见问题与解决方案

### 6.1 问题：df: command not found
**解决方案**：安装 df 工具
- Ubuntu/Debian: `apt install coreutils`
- CentOS/RHEL: `yum install coreutils`

### 6.2 问题：df 显示的空间使用情况与实际不符
**解决方案**：检查是否有已删除但仍被进程占用的文件
```bash
lsof | grep deleted
```

### 6.3 问题：df 显示的 inode 使用率很高
**解决方案**：查找并删除大量小文件
```bash
find /path -type f | sort | uniq -c | sort -nr | head -10
```

### 6.4 问题：df 无法显示某些文件系统
**解决方案**：使用 -a 选项显示所有文件系统
```bash
df -a
```

### 6.5 问题：df 命令执行缓慢
**解决方案**：检查网络文件系统挂载点，或使用 -t 选项只显示本地文件系统
```bash
df -h -t ext4 -t xfs
```

### 6.6 问题：df 显示的挂载点与实际不符
**解决方案**：检查 /etc/fstab 文件和实际挂载情况
```bash
cat /etc/fstab
mount
```

## 7. 命令对比

| 命令 | 功能 | 适用场景 |
|------|------|----------|
| df | 显示文件系统的磁盘空间使用情况 | 查看整体磁盘空间使用 |
| du | 显示目录或文件的磁盘使用情况 | 查看具体目录或文件的大小 |
| lsblk | 显示块设备信息 | 查看磁盘分区情况 |
| fdisk | 磁盘分区工具 | 管理磁盘分区 |
| mount | 挂载文件系统 | 管理文件系统挂载 |

## 8. 注意事项
- df 命令用于显示文件系统的磁盘空间使用情况，是 Linux 系统中最常用的磁盘空间查看工具
- df 命令可以显示文件系统的总空间、已用空间、可用空间和挂载点等信息
- 常用的操作包括：显示所有文件系统的使用情况、显示特定文件系统的使用情况、显示inode使用情况等
- df 命令是 coreutils 包的一部分，几乎所有 Linux 系统都默认安装
- 使用 -h 选项可以使输出更加易读，显示为人类可读的格式
- df 命令显示的是文件系统的使用情况，而不是单个文件的大小
- df 命令需要读取文件系统的超级块信息，可能需要一定的权限
- 对于网络文件系统，df 命令可能会执行较慢
- df 命令可以使用 -t 和 -x 选项来过滤文件系统类型
- 定期检查磁盘空间使用情况可以帮助预防磁盘空间不足的问题