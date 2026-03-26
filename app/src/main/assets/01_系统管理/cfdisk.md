# cfdisk - 交互式磁盘分区工具

## 1. 命令简介
cfdisk 命令是一个交互式磁盘分区工具，是 Linux 系统中常用的磁盘管理命令之一。它提供了一个用户友好的界面来创建、删除、修改磁盘分区。

## 2. 命令语法
```bash
cfdisk [选项] [设备]
```

## 3. 常用选项

| 选项 | 说明 |
|------|------|
| -h, --help | 显示帮助信息 |
| --version | 显示版本信息 |
| -z, --zero | 从新的空分区表开始 |
| -f, --force | 强制模式 |
| -P, --print | 打印分区表并退出 |
| -t, --type=<类型> | 指定分区表类型 |

## 4. 交互式操作

| 操作 | 说明 |
|------|------|
| 方向键 | 移动光标 |
| Enter | 选择选项 |
| New | 创建新分区 |
| Delete | 删除分区 |
| Quit | 退出不保存 |
| Write | 写入分区表并退出 |
| Type | 更改分区类型 |
| Help | 显示帮助信息 |
| Toggle bootable | 切换可启动标记 |

## 5. 实战示例

### 5.1 基本用法
```bash
# 启动cfdisk交互式分区工具
cfdisk /dev/sda

# 打印分区表并退出
cfdisk -P /dev/sda
```

### 5.2 交互式操作
1. 启动 cfdisk：`sudo cfdisk /dev/sda`
2. 使用方向键选择空闲空间
3. 按 Enter 键，选择 "New"
4. 输入分区大小（例如：10G）
5. 选择分区类型（Primary 或 Logical）
6. 按 Enter 键确认
7. 选择 "Write" 写入分区表
8. 输入 "yes" 确认
9. 选择 "Quit" 退出

## 6. 高级用法

### 6.1 与其他命令结合使用
```bash
# 检查磁盘后启动cfdisk
fdisk -l /dev/sda && cfdisk /dev/sda
```

### 6.2 批量操作
```bash
#!/bin/bash

# 批量显示磁盘分区
disks=("/dev/sda" "/dev/sdb" "/dev/sdc")

for disk in "${disks[@]}"; do
    echo "\n=== 磁盘 $disk 的分区信息 ==="
    cfdisk -P $disk
done
```

### 6.3 自动化脚本
```bash
#!/bin/bash

# 自动化启动cfdisk
test_cfdisk() {
    local disk=$1
    local options=${2:-""}
    
    echo "启动 cfdisk 对 $disk 进行分区"
    cfdisk $options $disk
}

# 使用函数
test_cfdisk "/dev/sda"
```

## 7. 常见问题与解决方案

### 7.1 问题：cfdisk: command not found
**解决方案**：安装 util-linux
- Ubuntu/Debian: `apt install util-linux`
- CentOS/RHEL: `yum install util-linux`

### 7.2 问题：无法启动cfdisk
**解决方案**：确保有足够的权限
```bash
sudo cfdisk /dev/sda
```

### 7.3 问题：分区表写入失败
**解决方案**：确保磁盘未被使用
```bash
umount /dev/sda* && sudo cfdisk /dev/sda
```

### 7.4 问题：cfdisk 命令执行缓慢
**解决方案**：磁盘较大，这是正常现象

### 7.5 问题：无法识别分区类型
**解决方案**：使用 Type 选项更改分区类型

## 8. 命令对比

| 命令 | 功能 | 适用场景 |
|------|------|----------|
| cfdisk | 交互式磁盘分区工具 | 所有 Linux 系统 |
| fdisk | 磁盘分区工具 | 所有 Linux 系统 |
| sfdisk | 脚本化磁盘分区工具 | 所有 Linux 系统 |
| parted | 磁盘分区工具 | 所有 Linux 系统 |
| gdisk | GPT磁盘分区工具 | 所有 Linux 系统 |

## 9. 注意事项
- cfdisk 命令是一个交互式磁盘分区工具，是 Linux 系统中常用的磁盘管理命令之一
- cfdisk 命令提供了一个用户友好的界面来创建、删除、修改磁盘分区
- 常用的操作包括：基本用法、交互式操作等
- cfdisk 命令需要 root 权限来执行
- cfdisk 命令支持多种选项，可以根据需要选择合适的选项
- cfdisk 命令是所有 Linux 系统的标准工具，用于交互式磁盘分区