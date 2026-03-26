# losetup - 设置循环设备

## 1. 命令简介
losetup 命令用于设置循环设备，是 Linux 系统中常用的磁盘管理命令之一。它可以将文件或块设备映射为循环设备。

## 2. 命令语法
```bash
losetup [选项] [循环设备] [文件]
```

## 3. 常用选项

| 选项 | 说明 |
|------|------|
| -h, --help | 显示帮助信息 |
| --version | 显示版本信息 |
| -a, --all | 显示所有循环设备 |
| -d, --detach | 分离循环设备 |
| -f, --find | 查找可用的循环设备 |
| -e, --encryption=<类型> | 设置加密类型 |
| -o, --offset=<偏移量> | 设置偏移量 |
| -s, --show | 显示设备名称 |
| -P, --partscan | 扫描分区 |
| --sizelimit=<大小> | 设置大小限制 |

## 4. 实战示例

### 4.1 基本用法
```bash
# 查看所有循环设备
losetup -a

# 查找可用的循环设备
losetup -f

# 将文件映射为循环设备
losetup /dev/loop0 /path/to/file.img

# 分离循环设备
losetup -d /dev/loop0
```

### 4.2 扫描分区
```bash
# 映射文件并扫描分区
losetup -P /dev/loop0 /path/to/file.img
```

### 4.3 设置偏移量
```bash
# 设置偏移量映射文件
losetup -o 1048576 /dev/loop0 /path/to/file.img
```

## 5. 高级用法

### 5.1 组合选项
```bash
# 查找可用的循环设备并映射文件，显示设备名称
losetup -f -s /path/to/file.img

# 映射文件并扫描分区，显示设备名称
losetup -P -s /path/to/file.img
```

### 5.2 与其他命令结合使用
```bash
# 映射文件后挂载
losetup /dev/loop0 /path/to/file.img && mount /dev/loop0 /mnt

# 挂载后分离
umount /mnt && losetup -d /dev/loop0
```

### 5.3 批量操作
```bash
#!/bin/bash

# 批量映射文件
files=("file1.img" "file2.img" "file3.img")

for ((i=0; i<${#files[@]}; i++)); do
    loop_dev="/dev/loop$i"
    echo "映射 ${files[i]} 到 $loop_dev"
    losetup $loop_dev ${files[i]}
done
```

### 5.4 自动化脚本
```bash
#!/bin/bash

# 自动化设置循环设备
setup_loop() {
    local file=$1
    local offset=${2:-"0"}
    local options=${3:-""}
    
    echo "映射 $file 到循环设备"
    loop_dev=$(losetup -f)
    losetup $options -o $offset $loop_dev $file
    
    if [ $? -eq 0 ]; then
        echo "映射成功，设备: $loop_dev"
        echo $loop_dev
    else
        echo "映射失败"
        return 1
    fi
}

# 使用函数
loop_dev=$(setup_loop "/path/to/file.img")
mount $loop_dev /mnt

# 清理
umount /mnt
losetup -d $loop_dev
```

## 6. 常见问题与解决方案

### 6.1 问题：losetup: command not found
**解决方案**：安装 util-linux
- Ubuntu/Debian: `apt install util-linux`
- CentOS/RHEL: `yum install util-linux`

### 6.2 问题：无法设置循环设备
**解决方案**：确保有足够的权限
```bash
sudo losetup /dev/loop0 /path/to/file.img
```

### 6.3 问题：文件未找到
**解决方案**：确保文件存在
```bash
ls -la /path/to/file.img
```

### 6.4 问题：循环设备忙
**解决方案**：确保循环设备未被使用
```bash
losetup -d /dev/loop0 && losetup /dev/loop0 /path/to/file.img
```

### 6.5 问题：无法扫描分区
**解决方案**：使用 -P 选项
```bash
losetup -P /dev/loop0 /path/to/file.img
```

## 7. 命令对比

| 命令 | 功能 | 适用场景 |
|------|------|----------|
| losetup | 设置循环设备 | 所有 Linux 系统 |
| mount | 挂载文件系统 | 所有 Linux 系统 |
| umount | 卸载文件系统 | 所有 Linux 系统 |
| dd | 复制和转换文件 | 所有 Linux 系统 |

## 8. 注意事项
- losetup 命令用于设置循环设备，是 Linux 系统中常用的磁盘管理命令之一
- losetup 命令可以将文件或块设备映射为循环设备
- 常用的操作包括：基本用法、扫描分区、设置偏移量等
- losetup 命令需要 root 权限来执行
- losetup 命令支持多种选项，可以根据需要选择合适的选项
- losetup 命令是所有 Linux 系统的标准工具，用于设置循环设备