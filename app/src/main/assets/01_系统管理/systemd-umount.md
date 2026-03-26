# systemd-umount - 卸载文件系统

## 1. 命令简介
systemd-umount 命令用于卸载文件系统，是 Linux 系统中常用的系统管理命令之一。它是 systemd 系统的一部分，用于卸载文件系统并停止相应的 systemd 单元。

## 2. 命令语法
```bash
systemd-umount [选项] [挂载点...]
```

## 3. 常用选项

| 选项 | 说明 |
|------|------|
| -h, --help | 显示帮助信息 |
| --version | 显示版本信息 |
| --lazy | 延迟卸载 |
| --force | 强制卸载 |
| --no-block | 非阻塞模式 |

## 4. 实战示例

### 4.1 卸载文件系统
```bash
sudo systemd-umount /mnt/data
```

### 4.2 延迟卸载
```bash
sudo systemd-umount --lazy /mnt/data
```

### 4.3 强制卸载
```bash
sudo systemd-umount --force /mnt/data
```

### 4.4 非阻塞模式
```bash
sudo systemd-umount --no-block /mnt/data
```

### 4.5 卸载多个挂载点
```bash
sudo systemd-umount /mnt/data /mnt/backup /mnt/media
```

## 5. 高级用法

### 5.1 管理挂载点
```bash
# 查看挂载点
df -h

# 卸载挂载点
sudo systemd-umount /mnt/data

# 查看挂载状态
systemctl status mnt-data.mount
```

### 5.2 与其他命令结合使用
```bash
# 卸载并检查文件系统
sudo systemd-umount /mnt/data && ls -la /mnt/

# 批量卸载
sudo systemd-umount /mnt/data /mnt/backup /mnt/media
```

### 5.3 批量卸载文件系统
```bash
#!/bin/bash

# 批量卸载文件系统
mounts=("/mnt/data" "/mnt/backup" "/mnt/media")

for mount in "${mounts[@]}"; do
    echo "卸载 $mount"
    sudo systemd-umount $mount
done
```

### 5.4 自动化卸载
```bash
#!/bin/bash

# 自动化卸载
automate_umount() {
    local mount_point=$1
    local options=${2:-}
    
    echo "卸载 $mount_point"
    sudo systemd-umount $options $mount_point
    
    if [ $? -eq 0 ]; then
        echo "卸载成功"
    else
        echo "卸载失败"
    fi
}

# 使用函数
automate_umount "/mnt/data"
automate_umount "/mnt/backup" "--lazy"
automate_umount "/mnt/media" "--force"
```

## 6. 常见问题与解决方案

### 6.1 问题：systemd-umount: command not found
**解决方案**：安装 systemd
- Ubuntu/Debian: `apt install systemd`
- CentOS/RHEL: `yum install systemd`

### 6.2 问题：无法卸载文件系统
**解决方案**：确保有足够的权限
```bash
sudo systemd-umount /mnt/data
```

### 6.3 问题：卸载失败
**解决方案**：检查挂载点是否被使用
```bash
lsof /mnt/data
```

### 6.4 问题：systemd-umount 命令执行缓慢
**解决方案**：检查文件系统状态

### 6.5 问题：无法强制卸载
**解决方案**：使用 --force 选项
```bash
sudo systemd-umount --force /mnt/data
```

## 7. 命令对比

| 命令 | 功能 | 适用场景 |
|------|------|----------|
| systemd-umount | 卸载文件系统 | systemd 系统 |
| umount | 卸载文件系统 | 所有 Linux 系统 |
| systemd-mount | 挂载文件系统 | systemd 系统 |
| mount | 挂载文件系统 | 所有 Linux 系统 |

## 8. 注意事项
- systemd-umount 命令用于卸载文件系统，是 Linux 系统中常用的系统管理命令之一
- systemd-umount 命令是 systemd 系统的一部分，用于卸载文件系统并停止相应的 systemd 单元
- 常用的操作包括：卸载文件系统、延迟卸载、强制卸载等
- systemd-umount 命令需要 root 权限来执行
- systemd-umount 命令支持多种选项，可以根据需要选择合适的选项
- systemd-umount 命令是现代 Linux 系统的标准工具，用于卸载文件系统