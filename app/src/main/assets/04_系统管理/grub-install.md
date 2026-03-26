# grub-install - GRUB 引导加载器安装工具

## 1. 命令简介
grub-install 是 GRUB 引导加载器的安装工具，用于将 GRUB 安装到指定的设备上。它负责将 GRUB 的核心文件复制到引导分区，并设置设备的引导扇区。

## 2. 命令语法
```bash
grub-install [选项] <device>
grub-install [选项] --root-directory=<dir> <device>
```

## 3. 常用选项

| 选项 | 说明 |
|------|------|
| -h, --help | 显示帮助信息 |
| -v, --version | 显示版本信息 |
| --boot-directory=<dir> | 指定引导目录，默认为 /boot |
| --root-directory=<dir> | 指定根目录，用于从外部安装 |
| --modules=<modules> | 指定要加载的模块，用逗号分隔 |
| --locales=<locales> | 指定要安装的语言环境 |
| --themes=<themes> | 指定要安装的主题 |
| --fonts=<fonts> | 指定要安装的字体 |
| --no-floppy | 不检查软盘设备 |
| --force | 强制安装，忽略某些错误 |
| --recheck | 重新检查设备映射 |
| --target=<target> | 指定目标平台（如 i386-pc、x86_64-efi 等） |
| --efi-directory=<dir> | 指定 EFI 系统分区目录 |
| --removable | 以可移动媒体模式安装 |
| --bootloader-id=<id> | 指定 EFI 引导加载器 ID |

## 4. 实战示例

### 4.1 安装 GRUB 到 /dev/sda
```bash
grub-install /dev/sda
```

### 4.2 指定引导目录
```bash
grub-install --boot-directory=/boot /dev/sda
```

### 4.3 指定根目录
```bash
grub-install --root-directory=/mnt /dev/sda
```

### 4.4 强制安装
```bash
grub-install --force /dev/sda
```

### 4.5 安装到 EFI 系统
```bash
grub-install --target=x86_64-efi --efi-directory=/boot/efi --bootloader-id=ubuntu /dev/sda
```

### 4.6 安装到可移动设备
```bash
grub-install --removable --target=x86_64-efi --efi-directory=/boot/efi /dev/sdb
```

## 5. 高级用法

### 5.1 安装 GRUB 并生成配置文件
```bash
# 安装 GRUB
grub-install /dev/sda

# 生成配置文件
grub-mkconfig -o /boot/grub/grub.cfg
```

### 5.2 从 Live CD 安装 GRUB
```bash
# 挂载根分区
mount /dev/sda1 /mnt

# 绑定必要的目录
mount --bind /dev /mnt/dev
mount --bind /proc /mnt/proc
mount --bind /sys /mnt/sys

# chroot 到挂载的系统
chroot /mnt

# 安装 GRUB
grub-install /dev/sda

# 生成配置文件
grub-mkconfig -o /boot/grub/grub.cfg

# 退出 chroot
exit

# 卸载目录
umount /mnt/sys
umount /mnt/proc
umount /mnt/dev
umount /mnt
```

### 5.3 安装到特定分区
```bash
# 安装 GRUB 到 /dev/sda1 分区
grub-install --force --root-directory=/mnt /dev/sda1
```

### 5.4 安装到 USB 设备
```bash
# 安装 GRUB 到 USB 设备
grub-install --target=i386-pc --boot-directory=/media/usb/boot /dev/sdb
```

### 5.5 安装特定模块
```bash
# 安装 GRUB 并指定模块
grub-install --modules="part_gpt part_msdos ext2 fat" /dev/sda
```

## 6. 常见问题与解决方案

### 6.1 问题：grub-install: error: failed to get canonical path of `/cow'
**解决方案**：这通常发生在 Live CD 环境中，需要使用 --root-directory 选项
```bash
grub-install --root-directory=/mnt /dev/sda
```

### 6.2 问题：grub-install: error: cannot find EFI directory
**解决方案**：指定 EFI 系统分区目录
```bash
grub-install --target=x86_64-efi --efi-directory=/boot/efi /dev/sda
```

### 6.3 问题：grub-install: error: will not proceed with blocklists
**解决方案**：使用 --force 选项强制安装
```bash
grub-install --force /dev/sda
```

### 6.4 问题：grub-install: error: disk `hd0' not found
**解决方案**：重新检查设备映射
```bash
grub-install --recheck /dev/sda
```

### 6.5 问题：grub-install: error: cannot stat `/boot/grub/i386-pc/modinfo.sh'
**解决方案**：确保安装了 grub-pc 包
```bash
apt install grub-pc
```

### 6.6 问题：grub-install: error: /usr/lib/grub/i386-pc/modinfo.sh doesn't exist
**解决方案**：安装 grub-pc-bin 包
```bash
apt install grub-pc-bin
```

## 7. 命令对比

| 命令 | 功能 | 适用场景 |
|------|------|----------|
| grub-install | 安装 GRUB 引导加载器 | 系统安装或修复引导 |
| grub-mkconfig | 生成 GRUB 配置文件 | 更新引导菜单 |
| grub-mkrescue | 创建 GRUB 救援镜像 | 创建可启动的救援媒体 |
| grub-probe | 探测设备信息 | 诊断引导问题 |
| grub-script-check | 检查 GRUB 脚本 | 验证配置文件语法 |
| update-grub | 更新 GRUB 配置 | 简化配置更新过程 |

## 8. 注意事项
- grub-install 是 GRUB 引导加载器的安装工具，用于将 GRUB 安装到指定的设备上
- 它负责将 GRUB 的核心文件复制到引导分区，并设置设备的引导扇区
- 常用的操作包括：安装 GRUB 到硬盘、指定引导目录、从 Live CD 修复引导等
- 在使用 grub-install 时，可能需要 root 权限才能执行操作
- 对于 EFI 系统，需要使用 --target=x86_64-efi 和 --efi-directory 选项
- 安装 GRUB 后，通常需要运行 grub-mkconfig 生成配置文件
- 从 Live CD 修复 GRUB 时，需要正确挂载根分区并 chroot 到系统
- 强制安装（--force）可能会解决某些安装问题，但应该谨慎使用
- 对于可移动设备，应该使用 --removable 选项
- 安装前应该备份重要数据，以防操作失误导致系统无法启动