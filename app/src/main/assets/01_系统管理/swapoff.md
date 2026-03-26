# swapoff - 禁用交换分区

## 1. 命令简介
swapoff 命令用于禁用交换分区，是 Linux 系统中常用的磁盘管理命令之一。它可以禁用指定的交换设备或文件。

## 2. 命令语法
```bash
swapoff [选项] [设备或文件]
```

## 3. 常用选项

| 选项 | 说明 |
|------|------|
| -h, --help | 显示帮助信息 |
| --version | 显示版本信息 |
| -a, --all | 禁用所有交换设备 |
| -v, --verbose | 详细显示操作过程 |

## 4. 实战示例

### 4.1 基本用法
```bash
# 禁用交换设备
swapoff /dev/sda2

# 禁用交换文件
swapoff /swapfile

# 禁用所有交换设备
swapoff -a
```

### 4.2 详细显示操作过程
```bash
# 详细显示操作过程
swapoff -v /dev/sda2
```

## 5. 高级用法

### 5.1 组合选项
```bash
# 禁用所有交换设备，详细显示操作过程
swapoff -av
```

### 5.2 与其他命令结合使用
```bash
# 禁用交换设备后检查
swapoff /dev/sda2 && free -m

# 批量禁用交换设备
devices=("/dev/sda2" "/dev/sdb1")
for dev in "${devices[@]}"; do swapoff $dev; done
```

### 5.3 批量操作
```bash
#!/bin/bash

# 批量禁用交换设备
devices=("/dev/sda2" "/dev/sdb1" "/swapfile")

for dev in "${devices[@]}"; do
    echo "禁用交换设备: $dev"
    swapoff $dev
done
```

### 5.4 自动化脚本
```bash
#!/bin/bash

# 自动化禁用交换设备
disable_swap() {
    local device=$1
    local options=${2:-""}
    
    echo "禁用交换设备: $device"
    swapoff $options $device
    
    if [ $? -eq 0 ]; then
        echo "禁用成功"
    else
        echo "禁用失败"
    fi
}

# 使用函数
disable_swap "/dev/sda2"
disable_swap "/dev/sdb1" "-v"
disable_swap "/swapfile"
```

## 6. 常见问题与解决方案

### 6.1 问题：swapoff: command not found
**解决方案**：安装 util-linux
- Ubuntu/Debian: `apt install util-linux`
- CentOS/RHEL: `yum install util-linux`

### 6.2 问题：无法禁用交换设备
**解决方案**：确保有足够的权限
```bash
sudo swapoff /dev/sda2
```

### 6.3 问题：设备未找到
**解决方案**：确保设备存在
```bash
ls -la /dev/sda2
```

### 6.4 问题：swapoff 命令执行缓慢
**解决方案**：系统正在同步数据到内存，这是正常现象

### 6.5 问题：无法禁用所有交换设备
**解决方案**：使用 -a 选项
```bash
swapoff -a
```

## 7. 命令对比

| 命令 | 功能 | 适用场景 |
|------|------|----------|
| swapoff | 禁用交换分区 | 所有 Linux 系统 |
| swapon | 启用交换分区 | 所有 Linux 系统 |
| mkswap | 创建交换分区 | 所有 Linux 系统 |
| free | 显示内存使用情况 | 所有 Linux 系统 |

## 8. 注意事项
- swapoff 命令用于禁用交换分区，是 Linux 系统中常用的磁盘管理命令之一
- swapoff 命令可以禁用指定的交换设备或文件
- 常用的操作包括：基本用法、详细显示操作过程等
- swapoff 命令需要 root 权限来执行
- swapoff 命令支持多种选项，可以根据需要选择合适的选项
- swapoff 命令是所有 Linux 系统的标准工具，用于禁用交换分区