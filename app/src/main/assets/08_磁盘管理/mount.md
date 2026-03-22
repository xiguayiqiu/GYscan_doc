# mount - 挂载文件系统

## 1. 命令简介
mount 命令用于挂载文件系统，是 Linux 系统中常用的磁盘管理命令之一。

## 2. 命令语法
```bash
mount [选项] [设备] [挂载点]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -t | 指定文件系统类型 |
| -o | 指定挂载选项 |
| -r | 以只读方式挂载 |
| -w | 以读写方式挂载（默认） |
| -a | 挂载/etc/fstab中所有未挂载的文件系统 |
| -l | 显示挂载的文件系统及其标签 |
| -v | 显示详细信息 |

## 4. 常用文件系统类型
| 类型 | 说明 |
|------|------|
| ext2 | 第二扩展文件系统 |
| ext3 | 第三扩展文件系统 |
| ext4 | 第四扩展文件系统 |
| xfs | XFS文件系统 |
| btrfs | Btrfs文件系统 |
| ntfs | NTFS文件系统 |
| vfat | FAT文件系统 |
| iso9660 | ISO9660文件系统（光盘） |

## 5. 常用挂载选项
| 选项 | 说明 |
|------|------|
| rw | 读写模式 |
| ro | 只读模式 |
| noexec | 禁止执行文件 |
| nosuid | 禁止setuid文件 |
| nodev | 禁止设备文件 |
| noatime | 不更新访问时间 |
| nodiratime | 不更新目录访问时间 |
| defaults | 使用默认选项（rw, suid, dev, exec, auto, nouser, async） |

## 6. 实战示例

### 6.1 挂载文件系统
```bash
sudo mount /dev/sda1 /mnt
```

### 6.2 指定文件系统类型
```bash
sudo mount -t ext4 /dev/sda1 /mnt
```

### 6.3 以只读方式挂载
```bash
sudo mount -r /dev/sda1 /mnt
```

### 6.4 指定挂载选项
```bash
sudo mount -o rw,noatime /dev/sda1 /mnt
```

### 6.5 挂载/etc/fstab中所有未挂载的文件系统
```bash
sudo mount -a
```

### 6.6 显示挂载的文件系统
```bash
mount
```

## 7. 退出状态
- 0：命令执行成功
- 非0：命令执行失败

## 8. 注意事项
- mount 命令需要 root 权限，使用 sudo 执行
- 挂载点必须是一个已存在的目录
- 挂载前需要确保文件系统未被其他进程使用
- 可以使用 umount 命令卸载已挂载的文件系统