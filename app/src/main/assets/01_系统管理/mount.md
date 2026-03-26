# mount - 挂载文件系统

## 1. 命令简介
mount 命令用于挂载文件系统，是 Linux 系统中常用的磁盘管理命令之一。它可以将文件系统挂载到指定的挂载点。

## 2. 命令语法
```bash
mount [选项] [设备] [挂载点]
```

## 3. 常用选项

| 选项 | 说明 |
|------|------|
| -h, --help | 显示帮助信息 |
| --version | 显示版本信息 |
| -a, --all | 挂载所有在 /etc/fstab 中定义的文件系统 |
| -t, --types=<类型> | 指定文件系统类型 |
| -o, --options=<选项> | 指定挂载选项 |
| -r, --read-only | 以只读方式挂载 |
| -w, --read-write | 以读写方式挂载 |
| -v, --verbose | 详细显示挂载过程 |
| -n, --no-mtab | 不更新 /etc/mtab |
| -L, --label=<标签> | 按标签挂载 |
| -U, --uuid=<UUID> | 按 UUID 挂载 |

## 4. 常用挂载选项

| 选项 | 说明 |
|------|------|
| defaults | 使用默认选项 |
| ro | 只读挂载 |
| rw | 读写挂载 |
| suid | 允许 suid 位 |
| nosuid | 禁止 suid 位 |
| dev | 允许设备文件 |
| nodev | 禁止设备文件 |
| exec | 允许执行文件 |
| noexec | 禁止执行文件 |
| auto | 自动挂载 |
| noauto | 不自动挂载 |
| user | 允许普通用户挂载 |
| nouser | 禁止普通用户挂载 |
| async | 异步写入 |
| sync | 同步写入 |
| dirsync | 目录同步写入 |
| atime | 更新访问时间 |
| noatime | 不更新访问时间 |
| relatime | 相对更新访问时间 |
| nodiratime | 不更新目录访问时间 |
| bind | 绑定挂载 |
| remount | 重新挂载 |

## 5. 实战示例

### 5.1 基本用法
```bash
# 挂载设备到指定挂载点
mount /dev/sda1 /mnt

# 以只读方式挂载
mount -r /dev/sda1 /mnt

# 挂载所有在 /etc/fstab 中定义的文件系统
mount -a
```

### 5.2 指定文件系统类型
```bash
# 指定文件系统类型挂载
mount -t ext4 /dev/sda1 /mnt

# 挂载 ISO 文件
mount -t iso9660 -o loop /path/to/file.iso /mnt
```

### 5.3 使用挂载选项
```bash
# 使用多个挂载选项
mount -o rw,noatime /dev/sda1 /mnt

# 绑定挂载
mount --bind /home /mnt/home
```

### 5.4 按标签或 UUID 挂载
```bash
# 按标签挂载
mount -L LABEL_NAME /mnt

# 按 UUID 挂载
mount -U 12345678-1234-1234-1234-1234567890ab /mnt
```

## 6. 高级用法

### 6.1 组合选项
```bash
# 详细显示挂载过程，指定文件系统类型和挂载选项
mount -v -t ext4 -o rw,noatime /dev/sda1 /mnt

# 重新挂载文件系统
mount -o remount,rw /dev/sda1
```

### 6.2 与其他命令结合使用
```bash
# 检查设备后挂载
lsblk /dev/sda1 && mount /dev/sda1 /mnt

# 挂载后检查
mount /dev/sda1 /mnt && df -h
```

### 6.3 批量操作
```bash
#!/bin/bash

# 批量挂载设备
mounts=(
    "/dev/sda1 /mnt/boot ext4 defaults"
    "/dev/sda2 /mnt ext4 defaults"
    "/dev/sda3 /mnt/home ext4 defaults"
)

for mount in "${mounts[@]}"; do
    read -r device mountpoint fstype options <<< "$mount"
    echo "挂载 $device 到 $mountpoint"
    mount -t $fstype -o $options $device $mountpoint
done
```

### 6.4 自动化脚本
```bash
#!/bin/bash

# 自动化挂载文件系统
mount_filesystem() {
    local device=$1
    local mountpoint=$2
    local fstype=${3:-"ext4"}
    local options=${4:-"defaults"}
    
    echo "挂载 $device 到 $mountpoint，文件系统类型: $fstype，选项: $options"
    mount -t $fstype -o $options $device $mountpoint
    
    if [ $? -eq 0 ]; then
        echo "挂载成功"
    else
        echo "挂载失败"
    fi
}

# 使用函数
mount_filesystem "/dev/sda1" "/mnt/boot"
mount_filesystem "/dev/sda2" "/mnt" "ext4" "rw,noatime"
mount_filesystem "/dev/sda3" "/mnt/home" "ext4" "defaults"
```

## 7. 常见问题与解决方案

### 7.1 问题：mount: command not found
**解决方案**：安装 util-linux
- Ubuntu/Debian: `apt install util-linux`
- CentOS/RHEL: `yum install util-linux`

### 7.2 问题：无法挂载
**解决方案**：确保有足够的权限
```bash
sudo mount /dev/sda1 /mnt
```

### 7.3 问题：挂载点不存在
**解决方案**：创建挂载点
```bash
mkdir -p /mnt && mount /dev/sda1 /mnt
```

### 7.4 问题：文件系统类型错误
**解决方案**：指定正确的文件系统类型
```bash
mount -t ext4 /dev/sda1 /mnt
```

### 7.5 问题：设备忙
**解决方案**：确保设备未被使用
```bash
umount /dev/sda1 && mount /dev/sda1 /mnt
```

## 8. 命令对比

| 命令 | 功能 | 适用场景 |
|------|------|----------|
| mount | 挂载文件系统 | 所有 Linux 系统 |
| umount | 卸载文件系统 | 所有 Linux 系统 |
| mountpoint | 检查目录是否为挂载点 | 所有 Linux 系统 |
| findmnt | 查找挂载点 | 所有 Linux 系统 |

## 9. 注意事项
- mount 命令用于挂载文件系统，是 Linux 系统中常用的磁盘管理命令之一
- mount 命令可以将文件系统挂载到指定的挂载点
- 常用的操作包括：基本用法、指定文件系统类型、使用挂载选项、按标签或 UUID 挂载等
- mount 命令需要 root 权限来执行
- mount 命令支持多种选项，可以根据需要选择合适的选项
- mount 命令是所有 Linux 系统的标准工具，用于挂载文件系统