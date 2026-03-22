# mkinitcpio - 创建initramfs

## 1. 命令简介
mkinitcpio 命令用于创建 initramfs，是 Linux 系统中常用的 Arch 工具命令之一。

## 2. 命令语法
```bash
mkinitcpio [选项]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -c | 指定配置文件 |
| -g | 指定输出文件 |
| -k | 指定内核版本 |
| -s | 显示配置 |
| -v | 显示详细信息 |
| --help | 显示帮助信息 |
| --version | 显示版本信息 |

## 4. 实战示例

### 4.1 创建initramfs
```bash
mkinitcpio -g /boot/initramfs-linux.img
```

### 4.2 指定内核版本
```bash
mkinitcpio -k linux -g /boot/initramfs-linux.img
```

### 4.3 显示配置
```bash
mkinitcpio -s
```

## 5. 注意事项
- mkinitcpio 命令用于创建 initramfs，是 Arch Linux 启动过程中的重要组成部分
- mkinitcpio 命令可以定制 initramfs 包含的模块
- mkinitcpio 命令是 Arch Linux 系统中常用的工具