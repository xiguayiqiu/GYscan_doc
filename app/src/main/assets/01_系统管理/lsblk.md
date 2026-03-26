# lsblk - 列出块设备

## 1. 命令简介
lsblk 命令用于列出块设备，是 Linux 系统中常用的磁盘管理命令之一。它可以显示块设备的层次结构、大小、挂载点等信息。

## 2. 命令语法
```bash
lsblk [选项]
```

## 3. 常用选项

| 选项 | 说明 |
|------|------|
| -h, --help | 显示帮助信息 |
| --version | 显示版本信息 |
| -a, --all | 显示所有设备 |
| -b, --bytes | 以字节为单位显示大小 |
| -d, --nodeps | 不显示依赖关系 |
| -e, --exclude=<设备> | 排除指定设备 |
| -f, --fs | 显示文件系统信息 |
| -i, --ascii | 使用 ASCII 字符显示 |
| -l, --list | 以列表形式显示 |
| -m, --perms | 显示权限信息 |
| -n, --noheadings | 不显示标题 |
| -o, --output=<列> | 指定输出列 |
| -p, --paths | 显示完整路径 |
| -r, --raw | 以原始格式显示 |
| -t, --topology | 显示拓扑信息 |

## 4. 输出列

| 列 | 说明 |
|------|------|
| NAME | 设备名称 |
| MAJ:MIN | 主设备号:次设备号 |
| RM | 可移动设备 |
| SIZE | 设备大小 |
| RO | 只读设备 |
| TYPE | 设备类型 |
| MOUNTPOINT | 挂载点 |
| UUID | 文件系统 UUID |
| LABEL | 文件系统标签 |
| FSTYPE | 文件系统类型 |
| MODEL | 设备模型 |
| SERIAL | 设备序列号 |
| WWN | 全球名称 |
| ROTA | 旋转设备 |
| SCHED | I/O 调度器 |
| RQ-SIZE | 请求大小 |
| TYPE | 设备类型 |
| DISC-ALN | 磁盘对齐 |
| DISC-GRAN | 磁盘粒度 |
| DISC-MAX | 磁盘最大值 |
| DISC-ZERO | 磁盘零 |

## 5. 实战示例

### 5.1 基本用法
```bash
# 列出所有块设备
lsblk

# 以列表形式显示块设备
lsblk -l

# 显示文件系统信息
lsblk -f
```

### 5.2 指定输出列
```bash
# 只显示名称、大小和挂载点
lsblk -o NAME,SIZE,MOUNTPOINT

# 显示完整路径和文件系统信息
lsblk -p -o NAME,SIZE,FSTYPE,MOUNTPOINT
```

### 5.3 排除指定设备
```bash
# 排除指定设备
lsblk -e 7
```

### 5.4 显示所有设备
```bash
# 显示所有设备，包括空设备
lsblk -a
```

## 6. 高级用法

### 6.1 组合选项
```bash
# 以列表形式显示所有设备的文件系统信息
lsblk -la -f

# 以原始格式显示设备信息
lsblk -r -o NAME,SIZE,MOUNTPOINT
```

### 6.2 与其他命令结合使用
```bash
# 显示块设备并管道到其他命令
lsblk | grep "sd"

# 批量显示设备信息
lsblk -o NAME,SIZE,MOUNTPOINT | sort -k2 -n
```

### 6.3 批量操作
```bash
#!/bin/bash

# 批量显示设备信息
lsblk -o NAME,SIZE,MOUNTPOINT,FSTYPE

# 显示特定类型的设备
lsblk -o NAME,SIZE,TYPE | grep "disk"
```

### 6.4 自动化脚本
```bash
#!/bin/bash

# 自动化显示设备信息
display_block_devices() {
    local options=${1:-""}
    local columns=${2:-"NAME,SIZE,MOUNTPOINT"}
    
    echo "显示块设备信息:"
    lsblk $options -o $columns
}

# 使用函数
display_block_devices
display_block_devices "-f" "NAME,SIZE,FSTYPE,UUID"
display_block_devices "-l" "NAME,SIZE,TYPE,MOUNTPOINT"
```

## 7. 常见问题与解决方案

### 7.1 问题：lsblk: command not found
**解决方案**：安装 util-linux
- Ubuntu/Debian: `apt install util-linux`
- CentOS/RHEL: `yum install util-linux`

### 7.2 问题：无法显示设备信息
**解决方案**：确保有足够的权限
```bash
sudo lsblk
```

### 7.3 问题：设备未找到
**解决方案**：确保设备存在
```bash
ls -la /dev/sda
```

### 7.4 问题：lsblk 命令执行缓慢
**解决方案**：系统正在扫描设备，这是正常现象

### 7.5 问题：无法显示文件系统信息
**解决方案**：使用 -f 选项
```bash
lsblk -f
```

## 8. 命令对比

| 命令 | 功能 | 适用场景 |
|------|------|----------|
| lsblk | 列出块设备 | 所有 Linux 系统 |
| blkid | 显示块设备属性 | 所有 Linux 系统 |
| fdisk | 磁盘分区工具 | 所有 Linux 系统 |
| parted | 磁盘分区工具 | 所有 Linux 系统 |

## 9. 注意事项
- lsblk 命令用于列出块设备，是 Linux 系统中常用的磁盘管理命令之一
- lsblk 命令可以显示块设备的层次结构、大小、挂载点等信息
- 常用的操作包括：基本用法、指定输出列、排除指定设备、显示所有设备等
- lsblk 命令需要 root 权限来执行
- lsblk 命令支持多种选项，可以根据需要选择合适的选项
- lsblk 命令是所有 Linux 系统的标准工具，用于列出块设备