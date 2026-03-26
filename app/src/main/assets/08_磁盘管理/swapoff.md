# swapoff 命令

## 命令说明

`swapoff` 是 Linux 系统中用于禁用交换分区或交换文件的命令。

## 语法

```bash
swapoff [选项] [设备|文件]
```

## 常用选项

| 选项 | 描述 |
|------|------|
| `-a` | 禁用 /etc/fstab 中所有的交换设备 |
| `-e` | 跳过不存在的设备 |

## 示例

### 禁用交换分区

```bash
swapoff /dev/sda2
```

### 禁用交换文件

```bash
swapoff /swapfile
```

### 禁用所有交换设备

```bash
swapoff -a
```

## 注意事项

- `swapoff` 命令需要 root 权限
- 可以使用 `swapon` 命令启用交换设备
- 禁用交换设备可能会导致系统内存不足，应谨慎使用
- 通常只在维护或故障排除时使用 `swapoff` 命令