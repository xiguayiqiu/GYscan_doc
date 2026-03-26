# grub-mkconfig - GRUB 配置文件生成工具

## 1. 命令简介
grub-mkconfig 是 GRUB 引导加载器的配置文件生成工具，用于根据当前系统的安装情况生成 GRUB 配置文件。它会自动检测系统中安装的操作系统，并生成相应的引导菜单项。

## 2. 命令语法
```bash
grub-mkconfig [选项]
grub-mkconfig [选项] -o <文件>
```

## 3. 常用选项

| 选项 | 说明 |
|------|------|
| -h, --help | 显示帮助信息 |
| -v, --version | 显示版本信息 |
| -o <file>, --output=<file> | 指定输出文件，默认为标准输出 |
| --no-floppy | 不检查软盘设备 |
| --verbose | 显示详细的生成过程 |
| --config-file=<file> | 指定配置文件模板 |

## 4. 实战示例

### 4.1 生成 GRUB 配置文件并输出到标准输出
```bash
grub-mkconfig
```

### 4.2 生成 GRUB 配置文件并保存到指定文件
```bash
grub-mkconfig -o /boot/grub/grub.cfg
```

### 4.3 显示详细的生成过程
```bash
grub-mkconfig --verbose -o /boot/grub/grub.cfg
```

### 4.4 使用自定义配置文件模板
```bash
grub-mkconfig --config-file=/etc/grub.d/custom.cfg -o /boot/grub/grub.cfg
```

## 5. 高级用法

### 5.1 安装 GRUB 并生成配置文件
```bash
# 安装 GRUB
grub-install /dev/sda

# 生成配置文件
grub-mkconfig -o /boot/grub/grub.cfg
```

### 5.2 更新 GRUB 配置
```bash
# 生成新的配置文件
grub-mkconfig -o /boot/grub/grub.cfg
```

### 5.3 备份并更新 GRUB 配置
```bash
# 备份当前配置文件
cp /boot/grub/grub.cfg /boot/grub/grub.cfg.bak

# 生成新的配置文件
grub-mkconfig -o /boot/grub/grub.cfg
```

### 5.4 在 chroot 环境中生成配置文件
```bash
# 在 chroot 环境中生成配置文件
chroot /mnt grub-mkconfig -o /boot/grub/grub.cfg
```

### 5.5 手动添加自定义菜单项
```bash
# 创建自定义菜单项文件
cat > /etc/grub.d/40_custom << 'EOF'
#!/bin/sh
 exec tail -n +3 $0
# This file provides an easy way to add custom menu entries.
# For example, you can add the following menu entry:

menuentry "Custom Linux" {
    set root=(hd0,1)
    linux /vmlinuz root=/dev/sda1 ro
    initrd /initrd.img
}
EOF

# 使文件可执行
chmod +x /etc/grub.d/40_custom

# 生成配置文件
grub-mkconfig -o /boot/grub/grub.cfg
```

## 6. 常见问题与解决方案

### 6.1 问题：grub-mkconfig: command not found
**解决方案**：安装 GRUB 包
- Ubuntu/Debian: `apt install grub2-common`
- CentOS/RHEL: `yum install grub2-tools`

### 6.2 问题：grub-mkconfig: error: cannot find a device for / (is /dev mounted?)
**解决方案**：确保根文件系统已正确挂载
```bash
mount /dev/sda1 /mnt
chroot /mnt
```

### 6.3 问题：grub-mkconfig 不检测 Windows 系统
**解决方案**：安装 os-prober 工具
```bash
apt install os-prober
update-grub
```

### 6.4 问题：grub-mkconfig 生成的配置文件没有更新
**解决方案**：检查 /etc/grub.d/ 目录下的脚本是否可执行
```bash
chmod +x /etc/grub.d/*
grub-mkconfig -o /boot/grub/grub.cfg
```

### 6.5 问题：grub-mkconfig: error: cannot stat `/boot/grub/grub.cfg.new'
**解决方案**：确保 /boot 目录有足够的空间和写入权限
```bash
df -h /boot
chmod 755 /boot/grub
```

### 6.6 问题：自定义菜单项不显示
**解决方案**：确保自定义脚本文件可执行并重新生成配置
```bash
chmod +x /etc/grub.d/40_custom
grub-mkconfig -o /boot/grub/grub.cfg
```

## 7. 命令对比

| 命令 | 功能 | 适用场景 |
|------|------|----------|
| grub-mkconfig | 生成 GRUB 配置文件 | 更新引导菜单 |
| grub-install | 安装 GRUB 引导加载器 | 系统安装或修复引导 |
| grub-mkrescue | 创建 GRUB 救援镜像 | 创建可启动的救援媒体 |
| grub-probe | 探测设备信息 | 诊断引导问题 |
| grub-script-check | 检查 GRUB 脚本 | 验证配置文件语法 |
| update-grub | 更新 GRUB 配置 | 简化配置更新过程 |

## 8. 注意事项
- grub-mkconfig 是 GRUB 引导加载器的配置文件生成工具，用于根据当前系统的安装情况生成 GRUB 配置文件
- 它会自动检测系统中安装的操作系统，并生成相应的引导菜单项
- 常用的操作包括：生成配置文件、更新引导菜单、添加自定义菜单项等
- 在使用 grub-mkconfig 时，可能需要 root 权限才能执行操作
- 生成配置文件后，新的配置会在下次启动时生效
- 对于双系统或多系统用户，grub-mkconfig 会自动检测并添加其他操作系统的引导项
- 可以通过修改 /etc/grub.d/ 目录下的脚本来自定义引导菜单
- 在生成配置文件前，建议备份当前的配置文件，以防出现问题
- grub-mkconfig 生成的配置文件通常位于 /boot/grub/grub.cfg
- 对于 EFI 系统，配置文件可能位于 /boot/efi/EFI/ubuntu/grub.cfg 或类似路径