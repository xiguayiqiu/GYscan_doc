# genfstab - 生成fstab

## 1. 命令简介
genfstab 命令用于生成 fstab 文件，是 Linux 系统中常用的 Arch 工具命令之一。

## 2. 命令语法
```bash
genfstab [选项] [挂载点]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -U | 使用UUID |
| -L | 使用标签 |
| --help | 显示帮助信息 |
| --version | 显示版本信息 |

## 4. 实战示例

### 4.1 生成fstab文件
```bash
genfstab -U /mnt >> /mnt/etc/fstab
```

### 4.2 使用标签
```bash
genfstab -L /mnt >> /mnt/etc/fstab
```

## 5. 注意事项
- genfstab 命令用于生成 fstab 文件，定义文件系统的挂载信息
- genfstab 命令是 Arch Linux 安装过程中的重要工具
- genfstab 命令需要 root 权限