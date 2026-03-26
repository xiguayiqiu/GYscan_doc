# sfdisk 命令

## 命令说明

`sfdisk` 是 Linux 系统中一个脚本化的磁盘分区工具，适用于自动化脚本中使用。

## 语法

```bash
sfdisk [选项] 设备
```

## 常用选项

| 选项 | 描述 |
|------|------|
| `-l` | 列出所有磁盘分区 |
| `-d` | 显示分区表的详细信息 |
| `-u` | 指定单位（S:扇区, B:字节, C:柱面, H:磁头, S:扇区） |
| `-N` | 只操作指定的分区 |
| `-f` | 强制操作，不进行检查 |

## 示例

### 列出所有磁盘分区

```bash
sfdisk -l
```

### 备份分区表

```bash
sfdisk -d /dev/sda > partition_table_backup.txt
```

### 恢复分区表

```bash
sfdisk /dev/sda < partition_table_backup.txt
```

### 创建分区

```bash
echo ',,83;' | sfdisk /dev/sdb
```

## 注意事项

- `sfdisk` 命令需要 root 权限
- 修改分区表后需要重启系统或使用 `partprobe` 命令让内核重新读取分区表
- 操作分区表时要小心，错误的操作可能导致数据丢失
- `sfdisk` 适合在脚本中使用，提供了非交互式的分区管理方式