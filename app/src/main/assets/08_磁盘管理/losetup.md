# losetup 命令

## 命令说明

`losetup` 是 Linux 系统中用于设置循环设备的命令，它可以将文件或块设备映射为循环设备。

## 语法

```bash
losetup [选项] [循环设备] [文件]
```

## 常用选项

| 选项 | 描述 |
|------|------|
| `-a` | 显示所有循环设备 |
| `-d` | 卸载循环设备 |
| `-f` | 查找第一个可用的循环设备 |
| `-P` | 自动创建分区设备 |
| `-r` | 以只读方式挂载 |

## 示例

### 显示所有循环设备

```bash
losetup -a
```

### 将文件映射为循环设备

```bash
losetup /dev/loop0 image.iso
```

### 查找第一个可用的循环设备并映射文件

```bash
losetup -f image.iso
```

### 卸载循环设备

```bash
losetup -d /dev/loop0
```

### 自动创建分区设备

```bash
losetup -P /dev/loop0 disk.img
```

## 注意事项

- `losetup` 命令需要 root 权限
- 循环设备允许将文件作为块设备使用
- 常用于挂载 ISO 镜像文件或创建虚拟磁盘
- 可以使用 `mount` 命令挂载循环设备