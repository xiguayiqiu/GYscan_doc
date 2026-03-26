# fdisk - 磁盘分区工具

## 1. 命令简介
fdisk 命令用于磁盘分区，是 Linux 系统中常用的磁盘管理命令之一。它可以创建、删除、修改磁盘分区。

## 2. 命令语法
```bash
fdisk [选项] [设备]
```

## 3. 常用选项

| 选项 | 说明 |
|------|------|
| -h, --help | 显示帮助信息 |
| --version | 显示版本信息 |
| -l, --list | 列出分区表 |
| -s, --size=<分区> | 显示分区大小 |
| -u, --units=<单位> | 显示单位 |

## 4. 交互式命令

| 命令 | 说明 |
|------|------|
| a | 设置可启动标记 |
| b | 编辑bsd磁盘标签 |
| c | 设置DOS兼容标记 |
| d | 删除分区 |
| g | 创建GPT分区表 |
| G | 创建SGI分区表 |
| l | 显示分区类型 |
| m | 显示帮助菜单 |
| n | 创建新分区 |
| o | 创建DOS分区表 |
| p | 显示分区表 |
| q | 退出不保存 |
| s | 创建Sun磁盘标签 |
| t | 更改分区类型 |
| u | 切换单位 |
| v | 验证分区表 |
| w | 写入分区表并退出 |
| x | 专家模式 |

## 5. 实战示例

### 5.1 基本用法
```bash
# 列出所有磁盘分区
fdisk -l

# 编辑指定磁盘的分区表
fdisk /dev/sda
```

### 5.2 交互式操作
```bash
# 进入fdisk交互式模式
fdisk /dev/sda

# 创建新分区
Command (m for help): n
Partition type:
   p   primary (0 primary, 0 extended, 4 free)
   e   extended
Select (default p): p
Partition number (1-4, default 1): 1
First sector (2048-20971519, default 2048): 
Using default value 2048
Last sector, +sectors or +size{K,M,G} (2048-20971519, default 20971519): +10G

# 显示分区表
Command (m for help): p

# 写入分区表并退出
Command (m for help): w
```

### 5.3 显示分区大小
```bash
# 显示指定分区的大小
fdisk -s /dev/sda1
```

## 6. 高级用法

### 6.1 与其他命令结合使用
```bash
# 列出磁盘分区并管道到其他命令
fdisk -l | grep "Disk"

# 检查分区后分区
fdisk -l /dev/sda && fdisk /dev/sda
```

### 6.2 批量操作
```bash
#!/bin/bash

# 批量显示磁盘分区
disks=("/dev/sda" "/dev/sdb" "/dev/sdc")

for disk in "${disks[@]}"; do
    echo "\n=== 磁盘 $disk 的分区信息 ==="
    fdisk -l $disk
done
```

### 6.3 自动化脚本
```bash
#!/bin/bash

# 自动化分区
disk_partition() {
    local disk=$1
    local size=${2:-"+10G"}
    
    echo "为磁盘 $disk 创建分区，大小为 $size"
    
    (echo n; echo p; echo 1; echo ; echo $size; echo w) | fdisk $disk
    
    if [ $? -eq 0 ]; then
        echo "分区成功"
    else
        echo "分区失败"
    fi
}

# 使用函数
disk_partition "/dev/sda"
disk_partition "/dev/sdb" "+20G"
```

## 7. 常见问题与解决方案

### 7.1 问题：fdisk: command not found
**解决方案**：安装 util-linux
- Ubuntu/Debian: `apt install util-linux`
- CentOS/RHEL: `yum install util-linux`

### 7.2 问题：无法分区
**解决方案**：确保有足够的权限
```bash
sudo fdisk /dev/sda
```

### 7.3 问题：分区表写入失败
**解决方案**：确保磁盘未被使用
```bash
umount /dev/sda* && sudo fdisk /dev/sda
```

### 7.4 问题：fdisk 命令执行缓慢
**解决方案**：磁盘较大，这是正常现象

### 7.5 问题：无法识别分区类型
**解决方案**：使用 t 命令更改分区类型
```bash
Command (m for help): t
Partition number (1-4): 1
Hex code (type L to list all codes): 83
```

## 8. 命令对比

| 命令 | 功能 | 适用场景 |
|------|------|----------|
| fdisk | 磁盘分区工具 | 所有 Linux 系统 |
| cfdisk | 交互式磁盘分区工具 | 所有 Linux 系统 |
| sfdisk | 脚本化磁盘分区工具 | 所有 Linux 系统 |
| parted | 磁盘分区工具 | 所有 Linux 系统 |
| gdisk | GPT磁盘分区工具 | 所有 Linux 系统 |

## 9. 注意事项
- fdisk 命令用于磁盘分区，是 Linux 系统中常用的磁盘管理命令之一
- fdisk 命令可以创建、删除、修改磁盘分区
- 常用的操作包括：基本用法、交互式操作、显示分区大小等
- fdisk 命令需要 root 权限来执行
- fdisk 命令支持多种选项，可以根据需要选择合适的选项
- fdisk 命令是所有 Linux 系统的标准工具，用于磁盘分区