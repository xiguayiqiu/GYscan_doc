# findmnt - 查找挂载点

## 1. 命令简介
findmnt 命令用于查找挂载点，是 Linux 系统中常用的磁盘管理命令之一。它可以显示文件系统的挂载信息，包括挂载点、设备、文件系统类型等。

## 2. 命令语法
```bash
findmnt [选项] [挂载点或设备]
findmnt [选项] [--target 挂载点] [--source 设备]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -a | 显示所有文件系统，包括虚拟文件系统 |
| -b | 以字节为单位显示大小 |
| -D | 显示详细信息 |
| -f | 显示文件系统类型 |
| -i | 不区分大小写 |
| -l | 以列表形式显示 |
| -n | 不显示表头 |
| -o | 显示指定的列，如TARGET,SOURCE,FSTYPE,OPTIONS |
| -p | 显示完整路径，不使用相对路径 |
| -r | 以原始格式显示，适合脚本处理 |
| -t | 显示指定类型的文件系统，多个类型用逗号分隔 |
| -u | 显示UUID |
| -v | 显示详细信息 |
| --target | 指定挂载点 |
| --source | 指定设备 |
| --kernel | 显示内核挂载表 |
| --all | 显示所有文件系统，包括未挂载的 |
| --raw | 以原始格式显示，不进行任何格式化 |

## 4. 实战示例

### 4.1 查找挂载点
```bash
findmnt
```

### 4.2 显示指定设备的挂载点
```bash
findmnt /dev/sda1
```

### 4.3 显示指定挂载点的信息
```bash
findmnt /mnt
```

### 4.4 以列表形式显示
```bash
findmnt -l
```

### 4.5 显示指定类型的文件系统
```bash
findmnt -t ext4
```

### 4.6 显示UUID
```bash
findmnt -u
```

### 4.7 显示指定列
```bash
findmnt -o TARGET,SOURCE,FSTYPE,SIZE
```

### 4.8 以原始格式显示
```bash
findmnt -r
```

### 4.9 显示所有文件系统
```bash
findmnt -a
```

### 4.10 显示内核挂载表
```bash
findmnt --kernel
```

## 5. 高级用法

### 5.1 过滤显示特定文件系统
```bash
# 显示ext4和xfs文件系统
findmnt -t ext4,xfs

# 显示除tmpfs外的所有文件系统
findmnt -t "not tmpfs"
```

### 5.2 自定义输出格式
```bash
# 显示指定列，用逗号分隔
findmnt -o TARGET,SOURCE,FSTYPE,OPTIONS,SIZE

# 显示人类可读的大小
findmnt -o TARGET,SOURCE,FSTYPE,SIZE -b
```

### 5.3 结合其他命令使用
```bash
# 查找所有挂载的ext4文件系统并检查磁盘使用情况
findmnt -t ext4 -o SOURCE | grep -v "^TARGET" | xargs df -h

# 查找挂载点并检查inode使用情况
findmnt -o TARGET | grep -v "^TARGET" | xargs df -i
```

### 5.4 脚本中的应用
```bash
# 检查文件系统是否已挂载
if findmnt -r -n -o TARGET | grep -q "/mnt/data"; then
    echo "/mnt/data is mounted"
else
    echo "/mnt/data is not mounted"
fi

# 获取特定设备的挂载点
MOUNT_POINT=$(findmnt -r -n -o TARGET --source /dev/sda1)
echo "Mount point for /dev/sda1: $MOUNT_POINT"
```

### 5.5 显示文件系统层次结构
```bash
# 以树状结构显示文件系统
findmnt

# 以树状结构显示特定类型的文件系统
findmnt -t ext4
```

## 6. 常见问题与解决方案

### 6.1 问题：findmnt: command not found
**解决方案**：安装 util-linux 包，findmnt 命令包含在该包中

### 6.2 问题：findmnt 显示的信息不完整
**解决方案**：使用 -a 选项显示所有文件系统，包括虚拟文件系统

### 6.3 问题：无法找到特定设备的挂载点
**解决方案**：确保设备已挂载，或使用 --all 选项显示所有设备

### 6.4 问题：findmnt 输出格式不适合脚本处理
**解决方案**：使用 -r 选项以原始格式显示，适合脚本处理

### 6.5 问题：如何查看文件系统的UUID
**解决方案**：使用 -u 选项显示UUID，或使用 -o UUID 显示UUID列

## 7. 命令对比

| 命令 | 功能 | 适用场景 |
|------|------|----------|
| findmnt | 查找挂载点，显示文件系统信息 | 查看挂载情况，脚本处理 |
| mount | 挂载文件系统，显示挂载信息 | 挂载操作，查看基本挂载信息 |
| df | 显示磁盘使用情况 | 查看磁盘空间使用 |
| lsblk | 显示块设备信息 | 查看磁盘分区情况 |
| blkid | 显示块设备的UUID和类型 | 查看设备标识符 |

## 8. 注意事项
- findmnt 命令可以查找文件系统的挂载点
- findmnt 命令的输出结果清晰易读，是查看系统挂载情况的常用工具
- 使用 -t 选项可以过滤显示指定类型的文件系统
- 使用 -o 选项可以自定义显示的列
- findmnt 命令是 util-linux 包的一部分，确保该包已安装
- 使用 -r 选项可以获得适合脚本处理的原始输出
- findmnt 命令可以显示文件系统的层次结构，有助于理解系统的存储布局
- 对于复杂的存储环境，findmnt 命令提供了灵活的过滤和显示选项