# partx - 管理分区

## 1. 命令简介
partx 命令用于管理分区，是 Linux 系统中常用的磁盘管理命令之一。它可以显示、添加、删除设备上的分区。

## 2. 命令语法
```bash
partx [选项] [设备]
```

## 3. 常用选项

| 选项 | 说明 |
|------|------|
| -h, --help | 显示帮助信息 |
| --version | 显示版本信息 |
| -a, --add | 添加分区 |
| -d, --delete | 删除分区 |
| -u, --update | 更新分区 |
| -l, --list | 列出分区 |
| -g, --noheadings | 不显示标题 |
| -n, --nr=<范围> | 指定分区范围 |
| -o, --output=<列> | 指定输出列 |
| -s, --summary | 显示摘要信息 |
| -v, --verbose | 详细显示操作过程 |

## 4. 实战示例

### 4.1 基本用法
```bash
# 列出设备上的分区
partx -l /dev/sda

# 添加分区
partx -a /dev/sda

# 删除分区
partx -d /dev/sda
```

### 4.2 指定分区范围
```bash
# 指定分区范围
partx -n 1-3 /dev/sda
```

### 4.3 显示摘要信息
```bash
# 显示摘要信息
partx -s /dev/sda
```

## 5. 高级用法

### 5.1 组合选项
```bash
# 详细显示操作过程，列出分区
partx -lv /dev/sda

# 添加指定范围的分区
partx -a -n 1-3 /dev/sda
```

### 5.2 与其他命令结合使用
```bash
# 列出分区后添加
partx -l /dev/sda && partx -a /dev/sda

# 批量管理分区
devices=("/dev/sda" "/dev/sdb")
for dev in "${devices[@]}"; do partx -a $dev; done
```

### 5.3 批量操作
```bash
#!/bin/bash

# 批量管理分区
devices=("/dev/sda" "/dev/sdb" "/dev/sdc")

for dev in "${devices[@]}"; do
    echo "\n=== 管理 $dev ==="
    partx -l $dev
    partx -a $dev
done
```

### 5.4 自动化脚本
```bash
#!/bin/bash

# 自动化管理分区
manage_partitions() {
    local device=$1
    local operation=${2:-"-l"}
    local options=${3:-""}
    
    echo "管理 $device 的分区: $operation"
    partx $options $operation $device
    
    if [ $? -eq 0 ]; then
        echo "操作成功"
    else
        echo "操作失败"
    fi
}

# 使用函数
manage_partitions "/dev/sda"
manage_partitions "/dev/sda" "-a"
manage_partitions "/dev/sda" "-d" "-n 1-3"
```

## 6. 常见问题与解决方案

### 6.1 问题：partx: command not found
**解决方案**：安装 util-linux
- Ubuntu/Debian: `apt install util-linux`
- CentOS/RHEL: `yum install util-linux`

### 6.2 问题：无法管理分区
**解决方案**：确保有足够的权限
```bash
sudo partx -a /dev/sda
```

### 6.3 问题：设备未找到
**解决方案**：确保设备存在
```bash
ls -la /dev/sda
```

### 6.4 问题：partx 命令执行缓慢
**解决方案**：系统正在管理分区，这是正常现象

### 6.5 问题：无法添加分区
**解决方案**：确保分区表正确
```bash
fdisk -l /dev/sda && partx -a /dev/sda
```

## 7. 命令对比

| 命令 | 功能 | 适用场景 |
|------|------|----------|
| partx | 管理分区 | 所有 Linux 系统 |
| partprobe | 通知内核分区表变化 | 所有 Linux 系统 |
| fdisk | 磁盘分区工具 | 所有 Linux 系统 |
| sfdisk | 脚本化磁盘分区工具 | 所有 Linux 系统 |

## 8. 注意事项
- partx 命令用于管理分区，是 Linux 系统中常用的磁盘管理命令之一
- partx 命令可以显示、添加、删除设备上的分区
- 常用的操作包括：基本用法、指定分区范围、显示摘要信息等
- partx 命令需要 root 权限来执行
- partx 命令支持多种选项，可以根据需要选择合适的选项
- partx 命令是所有 Linux 系统的标准工具，用于管理分区