# blockdev 命令

## 命令说明

`blockdev` 是 Linux 系统中用于操作块设备的命令，它可以设置或获取块设备的属性。

## 语法

```bash
blockdev [选项] 设备
```

## 常用选项

| 选项 | 描述 |
|------|------|
| `--getsz` | 获取设备大小（扇区数） |
| `--setra` | 设置读取预读大小 |
| `--setro` | 设置设备为只读 |
| `--setrw` | 设置设备为可读写 |
| `--flushbufs` | 刷新缓冲区 |
| `--rereadpt` | 重新读取分区表 |

## 示例

### 获取设备大小

```bash
blockdev --getsz /dev/sda
```

### 设置读取预读大小

```bash
blockdev --setra 4096 /dev/sda
```

### 设置设备为只读

```bash
blockdev --setro /dev/sda1
```

### 设置设备为可读写

```bash
blockdev --setrw /dev/sda1
```

### 刷新缓冲区

```bash
blockdev --flushbufs /dev/sda
```

### 重新读取分区表

```bash
blockdev --rereadpt /dev/sda
```

## 注意事项

- `blockdev` 命令需要 root 权限
- 可以使用 `blockdev` 命令调整块设备的性能参数
- `--rereadpt` 选项可以在不重启系统的情况下让内核重新读取分区表