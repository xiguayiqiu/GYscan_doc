# sfdisk - 脚本化磁盘分区工具

## 1. 命令简介
sfdisk 命令是一个脚本化磁盘分区工具，是 Linux 系统中常用的磁盘管理命令之一。它可以通过脚本或命令行参数来创建、删除、修改磁盘分区。

## 2. 命令语法
```bash
sfdisk [选项] [设备]
```

## 3. 常用选项

| 选项 | 说明 |
|------|------|
| -h, --help | 显示帮助信息 |
| --version | 显示版本信息 |
| -l, --list | 列出分区表 |
| -s, --show-size | 显示设备大小 |
| -d, --dump | 导出分区表 |
| -f, --force | 强制模式 |
| -u, --unit=<单位> | 显示单位 |
| -N, --partno=<编号> | 指定分区编号 |
| --wipe | 擦除签名 |
| --wipe-partitions | 擦除分区 |

## 4. 实战示例

### 4.1 基本用法
```bash
# 列出所有磁盘分区
sfdisk -l

# 导出分区表
sfdisk -d /dev/sda > partition.txt

# 导入分区表
sfdisk /dev/sda < partition.txt
```

### 4.2 创建分区
```bash
# 创建分区
echo "1,1000000" | sfdisk /dev/sda

# 创建多个分区
echo "1,1000000\n,,L" | sfdisk /dev/sda
```

### 4.3 显示设备大小
```bash
# 显示设备大小
sfdisk -s /dev/sda
```

## 5. 高级用法

### 5.1 与其他命令结合使用
```bash
# 导出分区表并备份
sfdisk -d /dev/sda > partition.txt && cp partition.txt partition.bak

# 检查分区后导入
sfdisk -l /dev/sda && sfdisk /dev/sda < partition.txt
```

### 5.2 批量操作
```bash
#!/bin/bash

# 批量导出分区表
disks=("/dev/sda" "/dev/sdb" "/dev/sdc")

for disk in "${disks[@]}"; do
    echo "导出 $disk 的分区表"
    sfdisk -d $disk > ${disk##*/}.txt
done
```

### 5.3 自动化脚本
```bash
#!/bin/bash

# 自动化分区
disk_partition() {
    local disk=$1
    local partitions=${2:-"1,1000000\n,,L"}
    
    echo "为磁盘 $disk 创建分区"
    echo "$partitions" | sfdisk $disk
    
    if [ $? -eq 0 ]; then
        echo "分区成功"
    else
        echo "分区失败"
    fi
}

# 使用函数
disk_partition "/dev/sda"
disk_partition "/dev/sdb" "1,2000000\n,,L"
```

## 6. 常见问题与解决方案

### 6.1 问题：sfdisk: command not found
**解决方案**：安装 util-linux
- Ubuntu/Debian: `apt install util-linux`
- CentOS/RHEL: `yum install util-linux`

### 6.2 问题：无法分区
**解决方案**：确保有足够的权限
```bash
sudo sfdisk /dev/sda
```

### 6.3 问题：分区表写入失败
**解决方案**：确保磁盘未被使用
```bash
umount /dev/sda* && sudo sfdisk /dev/sda
```

### 6.4 问题：sfdisk 命令执行缓慢
**解决方案**：磁盘较大，这是正常现象

### 6.5 问题：无法识别分区类型
**解决方案**：在分区定义中指定类型
```bash
echo "1,1000000,83" | sfdisk /dev/sda
```

## 7. 命令对比

| 命令 | 功能 | 适用场景 |
|------|------|----------|
| sfdisk | 脚本化磁盘分区工具 | 所有 Linux 系统 |
| fdisk | 磁盘分区工具 | 所有 Linux 系统 |
| cfdisk | 交互式磁盘分区工具 | 所有 Linux 系统 |
| parted | 磁盘分区工具 | 所有 Linux 系统 |
| gdisk | GPT磁盘分区工具 | 所有 Linux 系统 |

## 8. 注意事项
- sfdisk 命令是一个脚本化磁盘分区工具，是 Linux 系统中常用的磁盘管理命令之一
- sfdisk 命令可以通过脚本或命令行参数来创建、删除、修改磁盘分区
- 常用的操作包括：基本用法、创建分区、显示设备大小等
- sfdisk 命令需要 root 权限来执行
- sfdisk 命令支持多种选项，可以根据需要选择合适的选项
- sfdisk 命令是所有 Linux 系统的标准工具，用于脚本化磁盘分区