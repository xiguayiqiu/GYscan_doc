# partprobe 命令

## 命令说明

`partprobe` 是 Linux 系统中用于通知内核分区表变化的命令，它会让内核重新读取分区表。

## 语法

```bash
partprobe [选项] [设备]
```

## 常用选项

| 选项 | 描述 |
|------|------|
| `-d` | 不更新内核 |
| `-s` | 显示分区表信息 |

## 示例

### 通知内核分区表变化

```bash
partprobe /dev/sda
```

### 显示分区表信息

```bash
partprobe -s
```

## 注意事项

- `partprobe` 命令需要 root 权限
- 修改分区表后，使用 `partprobe` 命令可以让内核重新读取分区表，而不需要重启系统
- 如果 `partprobe` 命令失败，可能需要重启系统才能让内核识别新的分区表