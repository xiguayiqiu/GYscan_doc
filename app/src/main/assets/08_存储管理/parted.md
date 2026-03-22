# parted - 分区管理

## 1. 命令简介
parted 命令用于分区管理，是 Linux 系统中常用的存储管理命令之一。

## 2. 命令语法
```bash
parted [选项] [设备] [命令]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -l | 显示所有设备的分区信息 |
| -s | 脚本模式 |
| --help | 显示帮助信息 |
| --version | 显示版本信息 |

## 4. 常用命令
| 命令 | 说明 |
|------|------|
| print | 显示分区信息 |
| mkpart | 创建分区 |
| rm | 删除分区 |
| resize | 调整分区大小 |
| unit | 设置单位 |

## 5. 实战示例

### 5.1 显示所有设备的分区信息
```bash
parted -l
```

### 5.2 显示指定设备的分区信息
```bash
parted /dev/sda print
```

### 5.3 创建分区
```bash
parted /dev/sda mkpart primary ext4 1MiB 100MiB
```

### 5.4 删除分区
```bash
parted /dev/sda rm 1
```

## 6. 注意事项
- parted 命令用于分区管理，创建、删除和调整分区
- parted 命令需要 root 权限
- parted 命令是一个常用的系统管理工具，用于磁盘分区管理