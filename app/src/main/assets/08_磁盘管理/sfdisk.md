# sfdisk - 脚本化磁盘分区工具

## 1. 命令简介
sfdisk 命令是一个脚本化磁盘分区工具，是 Linux 系统中常用的磁盘管理命令之一。

## 2. 命令语法
```bash
sfdisk [选项] [设备]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -l | 显示磁盘分区信息 |
| -s | 显示分区大小 |
| -d | 备份分区表 |
| -f | 强制操作 |
| -N | 编辑指定分区 |

## 4. 实战示例

### 4.1 显示磁盘分区信息
```bash
sfdisk -l /dev/sda
```

### 4.2 备份分区表
```bash
sfdisk -d /dev/sda > partition_table.bak
```

### 4.3 恢复分区表
```bash
sfdisk /dev/sda < partition_table.bak
```

## 5. 注意事项
- sfdisk 命令是一个脚本化磁盘分区工具
- sfdisk 命令适合在脚本中使用
- 分区操作有风险，请谨慎操作