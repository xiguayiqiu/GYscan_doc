# arch-chroot - Arch chroot

## 1. 命令简介
arch-chroot 命令用于在 Arch Linux 安装过程中切换到新安装的系统，是 Linux 系统中常用的 Arch 工具命令之一。

## 2. 命令语法
```bash
arch-chroot [选项] [挂载点] [命令]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -h | 显示帮助信息 |
| --help | 显示帮助信息 |
| --version | 显示版本信息 |

## 4. 实战示例

### 4.1 切换到新安装的系统
```bash
arch-chroot /mnt
```

### 4.2 在新系统中执行命令
```bash
arch-chroot /mnt pacman -Syu
```

## 5. 注意事项
- arch-chroot 命令用于在 Arch Linux 安装过程中切换到新安装的系统
- arch-chroot 命令是 Arch Linux 安装过程中的重要工具
- arch-chroot 命令需要 root 权限