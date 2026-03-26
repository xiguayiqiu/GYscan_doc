# blockdev - 块设备操作

## 1. 命令简介
blockdev 命令用于操作块设备，是 Linux 系统中常用的磁盘管理命令之一。它可以对块设备执行各种操作，如获取大小、设置读写缓存等。

## 2. 命令语法
```bash
blockdev [选项] [设备]
```

## 3. 常用选项

| 选项 | 说明 |
|------|------|
| -h, --help | 显示帮助信息 |
| --version | 显示版本信息 |
| --getsize | 获取设备大小（以512字节扇区为单位） |
| --getsize64 | 获取设备大小（以字节为单位） |
| --getss | 获取扇区大小 |
| --getbsz | 获取块大小 |
| --setbsz=<大小> | 设置块大小 |
| --getioopt | 获取最优I/O大小 |
| --getalignoff | 获取对齐偏移量 |
| --flushbufs | 刷新缓冲区 |
| --rereadpt | 重新读取分区表 |
| --setro | 设置为只读 |
| --setrw | 设置为可读写 |

## 4. 实战示例

### 4.1 基本用法
```bash
# 获取设备大小（以512字节扇区为单位）
blockdev --getsize /dev/sda

# 获取设备大小（以字节为单位）
blockdev --getsize64 /dev/sda

# 获取扇区大小
blockdev --getss /dev/sda
```

### 4.2 获取块大小
```bash
# 获取块大小
blockdev --getbsz /dev/sda

# 设置块大小
blockdev --setbsz 4096 /dev/sda
```

### 4.3 刷新缓冲区
```bash
# 刷新缓冲区
blockdev --flushbufs /dev/sda
```

### 4.4 重新读取分区表
```bash
# 重新读取分区表
blockdev --rereadpt /dev/sda
```

## 5. 高级用法

### 5.1 组合选项
```bash
# 获取设备的多个参数
blockdev --getsize --getsize64 --getss /dev/sda

# 批量操作多个设备
devices=("/dev/sda" "/dev/sdb")
for dev in "${devices[@]}"; do blockdev --getsize64 $dev; done
```

### 5.2 与其他命令结合使用
```bash
# 获取设备大小并转换为GB
size=$(blockdev --getsize64 /dev/sda) && echo "$((size / 1024 / 1024 / 1024)) GB"

# 检查设备后操作
lsblk /dev/sda && blockdev --getsize64 /dev/sda
```

### 5.3 批量操作
```bash
#!/bin/bash

# 批量获取设备信息
devices=("/dev/sda" "/dev/sdb" "/dev/sdc")

for dev in "${devices[@]}"; do
    echo "\n=== 设备 $dev ==="
    echo "大小（扇区）: $(blockdev --getsize $dev)"
    echo "大小（字节）: $(blockdev --getsize64 $dev)"
    echo "扇区大小: $(blockdev --getss $dev)"
    echo "块大小: $(blockdev --getbsz $dev)"
done
```

### 5.4 自动化脚本
```bash
#!/bin/bash

# 自动化操作块设备
blockdev_operation() {
    local device=$1
    local operation=${2:-"--getsize64"}
    
    echo "操作 $device: $operation"
    blockdev $operation $device
}

# 使用函数
blockdev_operation "/dev/sda"
blockdev_operation "/dev/sda" "--getss"
blockdev_operation "/dev/sda" "--getbsz"
blockdev_operation "/dev/sda" "--flushbufs"
```

## 6. 常见问题与解决方案

### 6.1 问题：blockdev: command not found
**解决方案**：安装 util-linux
- Ubuntu/Debian: `apt install util-linux`
- CentOS/RHEL: `yum install util-linux`

### 6.2 问题：无法操作块设备
**解决方案**：确保有足够的权限
```bash
sudo blockdev --getsize /dev/sda
```

### 6.3 问题：设备未找到
**解决方案**：确保设备存在
```bash
ls -la /dev/sda
```

### 6.4 问题：blockdev 命令执行缓慢
**解决方案**：系统正在操作设备，这是正常现象

### 6.5 问题：无法设置块大小
**解决方案**：确保设备支持该块大小
```bash
blockdev --setbsz 4096 /dev/sda
```

## 7. 命令对比

| 命令 | 功能 | 适用场景 |
|------|------|----------|
| blockdev | 块设备操作 | 所有 Linux 系统 |
| lsblk | 列出块设备 | 所有 Linux 系统 |
| blkid | 显示块设备属性 | 所有 Linux 系统 |
| fdisk | 磁盘分区工具 | 所有 Linux 系统 |

## 8. 注意事项
- blockdev 命令用于操作块设备，是 Linux 系统中常用的磁盘管理命令之一
- blockdev 命令可以对块设备执行各种操作，如获取大小、设置读写缓存等
- 常用的操作包括：基本用法、获取块大小、刷新缓冲区、重新读取分区表等
- blockdev 命令需要 root 权限来执行
- blockdev 命令支持多种选项，可以根据需要选择合适的选项
- blockdev 命令是所有 Linux 系统的标准工具，用于操作块设备