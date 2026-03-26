# mkswap - 创建交换分区

## 1. 命令简介
mkswap 命令用于创建交换分区，是 Linux 系统中常用的磁盘管理命令之一。它可以在指定的设备或文件上创建交换分区。

## 2. 命令语法
```bash
mkswap [选项] [设备或文件]
```

## 3. 常用选项

| 选项 | 说明 |
|------|------|
| -h, --help | 显示帮助信息 |
| --version | 显示版本信息 |
| -f, --force | 强制创建交换分区 |
| -v, --verbose | 详细显示操作过程 |
| -U, --uuid=<UUID> | 设置 UUID |
| -L, --label=<标签> | 设置标签 |
| -p, --pagesize=<大小> | 设置页面大小 |

## 4. 实战示例

### 4.1 基本用法
```bash
# 在设备上创建交换分区
mkswap /dev/sda2

# 在文件上创建交换分区
mkswap /swapfile
```

### 4.2 设置标签
```bash
# 设置标签
mkswap -L SWAP /dev/sda2
```

### 4.3 详细显示操作过程
```bash
# 详细显示操作过程
mkswap -v /dev/sda2
```

## 5. 高级用法

### 5.1 组合选项
```bash
# 设置标签和UUID，详细显示操作过程
mkswap -L SWAP -U 12345678-1234-1234-1234-1234567890ab -v /dev/sda2
```

### 5.2 与其他命令结合使用
```bash
# 创建交换文件并设置
fallocate -l 4G /swapfile && chmod 600 /swapfile && mkswap /swapfile && swapon /swapfile

# 检查设备后创建交换分区
lsblk /dev/sda2 && mkswap /dev/sda2
```

### 5.3 批量操作
```bash
#!/bin/bash

# 批量创建交换分区
devices=("/dev/sda2" "/dev/sdb1")

for dev in "${devices[@]}"; do
    echo "在 $dev 上创建交换分区"
    mkswap $dev
done
```

### 5.4 自动化脚本
```bash
#!/bin/bash

# 自动化创建交换分区
create_swap() {
    local device=$1
    local label=${2:-"SWAP"}
    local options=${3:-""}
    
    echo "在 $device 上创建交换分区，标签: $label"
    mkswap $options -L $label $device
    
    if [ $? -eq 0 ]; then
        echo "创建成功"
    else
        echo "创建失败"
    fi
}

# 使用函数
create_swap "/dev/sda2"
create_swap "/dev/sdb1" "SWAP2" "-v"
create_swap "/swapfile" "SWAPFILE"
```

## 6. 常见问题与解决方案

### 6.1 问题：mkswap: command not found
**解决方案**：安装 util-linux
- Ubuntu/Debian: `apt install util-linux`
- CentOS/RHEL: `yum install util-linux`

### 6.2 问题：无法创建交换分区
**解决方案**：确保有足够的权限
```bash
sudo mkswap /dev/sda2
```

### 6.3 问题：设备未找到
**解决方案**：确保设备存在
```bash
ls -la /dev/sda2
```

### 6.4 问题：mkswap 命令执行缓慢
**解决方案**：设备较大，这是正常现象

### 6.5 问题：无法在文件上创建交换分区
**解决方案**：确保文件存在且有足够的大小
```bash
fallocate -l 4G /swapfile && mkswap /swapfile
```

## 7. 命令对比

| 命令 | 功能 | 适用场景 |
|------|------|----------|
| mkswap | 创建交换分区 | 所有 Linux 系统 |
| swapon | 启用交换分区 | 所有 Linux 系统 |
| swapoff | 禁用交换分区 | 所有 Linux 系统 |
| free | 显示内存使用情况 | 所有 Linux 系统 |

## 8. 注意事项
- mkswap 命令用于创建交换分区，是 Linux 系统中常用的磁盘管理命令之一
- mkswap 命令可以在指定的设备或文件上创建交换分区
- 常用的操作包括：基本用法、设置标签、详细显示操作过程等
- mkswap 命令需要 root 权限来执行
- mkswap 命令支持多种选项，可以根据需要选择合适的选项
- mkswap 命令是所有 Linux 系统的标准工具，用于创建交换分区