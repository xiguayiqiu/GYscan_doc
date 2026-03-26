# partx 命令

## 命令说明

`partx` 是 Linux 系统中用于管理分区的命令，它可以列出、添加或删除设备上的分区。

## 语法

```bash
partx [选项] [设备]
```

## 常用选项

| 选项 | 描述 |
|------|------|
| `-a` | 添加分区 |
| `-d` | 删除分区 |
| `-l` | 列出分区 |
| `-s` | 显示分区大小 |
| `-u` | 更新分区信息 |

## 示例

### 列出设备上的分区

```bash
partx -l /dev/sda
```

### 添加分区

```bash
partx -a /dev/sda
```

### 删除分区

```bash
partx -d /dev/sda1
```

### 更新分区信息

```bash
partx -u /dev/sda
```

## 注意事项

- `partx` 命令需要 root 权限
- `partx` 命令可以在不重启系统的情况下让内核识别新的分区
- 可以使用 `partx` 命令替代 `partprobe` 命令来更新分区表