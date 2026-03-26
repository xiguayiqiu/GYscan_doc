# fsck - 检查和修复文件系统

## 1. 命令简介
fsck 命令用于检查和修复文件系统，是 Linux 系统中常用的磁盘管理命令之一。它可以检查文件系统的一致性并修复发现的问题。

## 2. 命令语法
```bash
fsck [选项] [设备...]
```

## 3. 常用选项

| 选项 | 说明 |
|------|------|
| -h, --help | 显示帮助信息 |
| --version | 显示版本信息 |
| -a, --auto | 自动修复错误 |
| -r, --recursive | 递归检查 |
| -s, --sequential | 顺序检查 |
| -t, --type=<类型> | 指定文件系统类型 |
| -C, --progress | 显示进度 |
| -N, --dry-run | 模拟操作 |
| -l, --local | 只检查本地文件系统 |
| -M, --no-mount | 不检查已挂载的文件系统 |
| -P, --progress | 显示进度 |
| -R, --root=<目录> | 设置根目录 |
| -T, --no-time | 不显示时间信息 |
| -V, --verbose | 详细显示操作过程 |

## 4. 实战示例

### 4.1 基本用法
```bash
# 检查文件系统
fsck /dev/sda1

# 自动修复错误
fsck -a /dev/sda1

# 检查指定类型的文件系统
fsck -t ext4 /dev/sda1
```

### 4.2 显示进度
```bash
# 检查文件系统并显示进度
fsck -C /dev/sda1
```

### 4.3 模拟操作
```bash
# 模拟检查文件系统
fsck -N /dev/sda1
```

## 5. 高级用法

### 5.1 组合选项
```bash
# 自动修复错误，显示详细信息
fsck -av /dev/sda1

# 检查多个文件系统
fsck /dev/sda1 /dev/sda2
```

### 5.2 与其他命令结合使用
```bash
# 检查文件系统后挂载
fsck /dev/sda1 && mount /dev/sda1 /mnt

# 批量检查文件系统
devices=("/dev/sda1" "/dev/sda2" "/dev/sdb1")
for dev in "${devices[@]}"; do fsck $dev; done
```

### 5.3 批量操作
```bash
#!/bin/bash

# 批量检查文件系统
devices=("/dev/sda1" "/dev/sda2" "/dev/sdb1")

for dev in "${devices[@]}"; do
    echo "\n=== 检查 $dev ==="
    fsck $dev
done
```

### 5.4 自动化脚本
```bash
#!/bin/bash

# 自动化检查文件系统
check_filesystem() {
    local device=$1
    local options=${2:-""}
    
    echo "检查 $device"
    fsck $options $device
    
    if [ $? -eq 0 ]; then
        echo "检查成功"
    else
        echo "检查失败"
    fi
}

# 使用函数
check_filesystem "/dev/sda1"
check_filesystem "/dev/sda2" "-a"
check_filesystem "/dev/sdb1" "-v"
```

## 6. 常见问题与解决方案

### 6.1 问题：fsck: command not found
**解决方案**：安装 util-linux
- Ubuntu/Debian: `apt install util-linux`
- CentOS/RHEL: `yum install util-linux`

### 6.2 问题：无法检查文件系统
**解决方案**：确保有足够的权限
```bash
sudo fsck /dev/sda1
```

### 6.3 问题：文件系统已挂载
**解决方案**：卸载后检查
```bash
umount /dev/sda1 && fsck /dev/sda1
```

### 6.4 问题：fsck 命令执行缓慢
**解决方案**：文件系统较大，这是正常现象

### 6.5 问题：无法修复错误
**解决方案**：使用 -a 选项自动修复
```bash
fsck -a /dev/sda1
```

## 7. 命令对比

| 命令 | 功能 | 适用场景 |
|------|------|----------|
| fsck | 检查和修复文件系统 | 所有 Linux 系统 |
| e2fsck | 检查和修复ext2/ext3/ext4文件系统 | 所有 Linux 系统 |
| xfs_repair | 检查和修复XFS文件系统 | 所有 Linux 系统 |
| btrfs-check | 检查和修复Btrfs文件系统 | 所有 Linux 系统 |

## 8. 注意事项
- fsck 命令用于检查和修复文件系统，是 Linux 系统中常用的磁盘管理命令之一
- fsck 命令可以检查文件系统的一致性并修复发现的问题
- 常用的操作包括：基本用法、自动修复错误、显示进度、模拟操作等
- fsck 命令需要 root 权限来执行
- fsck 命令支持多种选项，可以根据需要选择合适的选项
- fsck 命令是所有 Linux 系统的标准工具，用于检查和修复文件系统