# partprobe - 通知内核分区表变化

## 1. 命令简介
partprobe 命令用于通知内核分区表变化，是 Linux 系统中常用的磁盘管理命令之一。它可以让内核重新读取分区表，而不需要重启系统。

## 2. 命令语法
```bash
partprobe [选项] [设备...]
```

## 3. 常用选项

| 选项 | 说明 |
|------|------|
| -h, --help | 显示帮助信息 |
| -d, --dry-run | 模拟操作 |
| -s, --summary | 显示摘要信息 |
| -v, --verbose | 详细显示操作过程 |

## 4. 实战示例

### 4.1 基本用法
```bash
# 通知内核分区表变化
partprobe

# 通知指定设备的分区表变化
partprobe /dev/sda
```

### 4.2 显示摘要信息
```bash
# 显示摘要信息
partprobe -s
```

### 4.3 详细显示操作过程
```bash
# 详细显示操作过程
partprobe -v /dev/sda
```

## 5. 高级用法

### 5.1 组合选项
```bash
# 详细显示操作过程，显示摘要信息
partprobe -vs /dev/sda
```

### 5.2 与其他命令结合使用
```bash
# 分区后通知内核
fdisk /dev/sda && partprobe /dev/sda

# 批量通知内核
devices=("/dev/sda" "/dev/sdb")
for dev in "${devices[@]}"; do partprobe $dev; done
```

### 5.3 批量操作
```bash
#!/bin/bash

# 批量通知内核分区表变化
devices=("/dev/sda" "/dev/sdb" "/dev/sdc")

for dev in "${devices[@]}"; do
    echo "通知内核 $dev 的分区表变化"
    partprobe $dev
done
```

### 5.4 自动化脚本
```bash
#!/bin/bash

# 自动化通知内核分区表变化
notify_kernel() {
    local device=$1
    local options=${2:-""}
    
    echo "通知内核 $device 的分区表变化"
    partprobe $options $device
    
    if [ $? -eq 0 ]; then
        echo "操作成功"
    else
        echo "操作失败"
    fi
}

# 使用函数
notify_kernel "/dev/sda"
notify_kernel "/dev/sdb" "-v"
notify_kernel "/dev/sdc" "-s"
```

## 6. 常见问题与解决方案

### 6.1 问题：partprobe: command not found
**解决方案**：安装 parted
- Ubuntu/Debian: `apt install parted`
- CentOS/RHEL: `yum install parted`

### 6.2 问题：无法通知内核
**解决方案**：确保有足够的权限
```bash
sudo partprobe /dev/sda
```

### 6.3 问题：设备未找到
**解决方案**：确保设备存在
```bash
ls -la /dev/sda
```

### 6.4 问题：partprobe 命令执行缓慢
**解决方案**：系统正在重新读取分区表，这是正常现象

### 6.5 问题：无法检测到分区表变化
**解决方案**：尝试使用 -v 选项查看详细信息
```bash
partprobe -v /dev/sda
```

## 7. 命令对比

| 命令 | 功能 | 适用场景 |
|------|------|----------|
| partprobe | 通知内核分区表变化 | 所有 Linux 系统 |
| partx | 管理分区 | 所有 Linux 系统 |
| fdisk | 磁盘分区工具 | 所有 Linux 系统 |
| sfdisk | 脚本化磁盘分区工具 | 所有 Linux 系统 |

## 8. 注意事项
- partprobe 命令用于通知内核分区表变化，是 Linux 系统中常用的磁盘管理命令之一
- partprobe 命令可以让内核重新读取分区表，而不需要重启系统
- 常用的操作包括：基本用法、显示摘要信息、详细显示操作过程等
- partprobe 命令需要 root 权限来执行
- partprobe 命令支持多种选项，可以根据需要选择合适的选项
- partprobe 命令是所有 Linux 系统的标准工具，用于通知内核分区表变化