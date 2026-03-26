# mke2fs 命令

## 命令说明

`mke2fs` 是 Linux 系统中用于创建 ext2/ext3/ext4 文件系统的命令。

## 语法

```bash
mke2fs [选项] 设备
```

## 常用选项

| 选项 | 描述 |
|------|------|
| `-t` | 指定文件系统类型（ext2, ext3, ext4） |
| `-b` | 指定块大小 |
| `-c` | 检查坏块 |
| `-L` | 设置文件系统标签 |
| `-m` | 设置保留块百分比 |
| `-O` | 启用或禁用文件系统特性 |

## 示例

### 创建 ext4 文件系统

```bash
mke2fs -t ext4 /dev/sdb1
```

### 检查坏块并创建文件系统

```bash
mke2fs -c /dev/sdb1
```

### 设置文件系统标签

```bash
mke2fs -L mylabel /dev/sdb1
```

### 设置保留块百分比

```bash
mke2fs -m 5 /dev/sdb1
```

## 注意事项

- `mke2fs` 命令需要 root 权限
- 创建文件系统会清除设备上的所有数据，使用前请确保已备份重要数据
- `mke2fs` 是专门用于创建 ext2/ext3/ext4 文件系统的工具