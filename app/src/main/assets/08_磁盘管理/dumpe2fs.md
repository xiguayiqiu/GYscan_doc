# dumpe2fs 命令

## 命令说明

`dumpe2fs` 是 Linux 系统中用于显示 ext2/ext3/ext4 文件系统信息的命令。

## 语法

```bash
dumpe2fs [选项] 设备
```

## 常用选项

| 选项 | 描述 |
|------|------|
| `-h` | 只显示超级块信息 |
| `-b` | 显示坏块信息 |
| `-o` | 指定输出格式 |

## 示例

### 显示文件系统信息

```bash
dumpe2fs /dev/sda1
```

### 只显示超级块信息

```bash
dumpe2fs -h /dev/sda1
```

### 显示坏块信息

```bash
dumpe2fs -b /dev/sda1
```

## 注意事项

- `dumpe2fs` 命令需要 root 权限
- 输出信息包括超级块信息、块组信息、inode 信息等
- 可以使用 `tune2fs` 命令调整文件系统参数