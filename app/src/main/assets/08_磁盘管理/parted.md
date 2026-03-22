# parted - 磁盘分区工具

## 1. 命令简介
parted 命令用于管理磁盘分区，是 Linux 系统中常用的磁盘管理命令之一，支持更大的磁盘和更多的分区类型。

## 2. 命令语法
```bash
parted [选项] [设备] [命令]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -l | 显示所有磁盘的分区信息 |
| -s | 静默模式 |
| -a | 设置对齐方式 |

## 4. 常用命令
| 命令 | 说明 |
|------|------|
| mklabel | 创建分区表 |
| mkpart | 创建分区 |
| rm | 删除分区 |
| print | 显示分区信息 |
| resize | 调整分区大小 |
| unit | 设置单位 |
| quit | 退出 |

## 5. 实战示例

### 5.1 显示所有磁盘的分区信息
```bash
parted -l
```

### 5.2 管理磁盘分区
```bash
parted /dev/sda
```

### 5.3 创建分区表
```bash
parted /dev/sda mklabel gpt
```

### 5.4 创建分区
```bash
parted /dev/sda mkpart primary ext4 1MiB 100GiB
```

## 6. 注意事项
- parted 命令用于管理磁盘分区，支持更大的磁盘和更多的分区类型
- parted 命令可以处理大于2TB的磁盘
- parted 命令支持GPT分区表
- 分区操作有风险，请谨慎操作