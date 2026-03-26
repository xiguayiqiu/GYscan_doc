# grub-mkrescue - GRUB 救援镜像创建工具

## 1. 命令简介
grub-mkrescue 是 GRUB 引导加载器的工具，用于创建 GRUB 救援镜像。它可以创建可启动的 ISO 镜像或软盘镜像，用于系统救援和修复引导问题。

## 2. 命令语法
```bash
grub-mkrescue [选项] -o <output_file>
grub-mkrescue [选项] <output_file>
```

## 3. 常用选项

| 选项 | 说明 |
|------|------|
| -h, --help | 显示帮助信息 |
| -v, --version | 显示版本信息 |
| -o <file>, --output=<file> | 指定输出文件 |
| --modules=<modules> | 指定要加载的模块，用逗号分隔 |
| --locales=<locales> | 指定要包含的语言环境 |
| --themes=<themes> | 指定要包含的主题 |
| --fonts=<fonts> | 指定要包含的字体 |
| --no-floppy | 不检查软盘设备 |
| --compress=<method> | 指定压缩方法（gzip、xz、lzma 等） |
| --format=<format> | 指定输出格式（iso、floppy 等） |
| --directory=<dir> | 指定 GRUB 目录 |

## 4. 实战示例

### 4.1 创建 GRUB 救援镜像
```bash
grub-mkrescue -o grub-rescue.iso
```

### 4.2 指定要包含的模块
```bash
grub-mkrescue --modules="ext2 part_msdos part_gpt" -o grub-rescue.iso
```

### 4.3 使用压缩方法
```bash
grub-mkrescue --compress=xz -o grub-rescue.iso
```

### 4.4 指定 GRUB 目录
```bash
grub-mkrescue --directory=/usr/lib/grub/i386-pc -o grub-rescue.iso
```

## 5. 高级用法

### 5.1 创建 GRUB 救援 USB 启动盘
```bash
# 创建救援镜像
grub-mkrescue -o grub-rescue.iso

# 将镜像写入 USB 设备
dd if=grub-rescue.iso of=/dev/sdb bs=4M status=progress
```

### 5.2 创建包含自定义配置的救援镜像
```bash
# 创建自定义配置文件
cat > grub.cfg << 'EOF'
set timeout=10
set default=0

menuentry "Rescue Mode" {
    set root=(hd0,1)
    linux /vmlinuz root=/dev/sda1 ro rescue
    initrd /initrd.img
}

menuentry "Boot from HD" {
    set root=(hd0,1)
    chainloader +1
}
EOF

# 创建救援镜像并包含自定义配置
grub-mkrescue --modules="ext2 part_msdos" -o grub-rescue.iso --directory=. 
```

### 5.3 创建支持多种文件系统的救援镜像
```bash
grub-mkrescue --modules="ext2 ext3 ext4 fat ntfs part_msdos part_gpt" -o grub-rescue.iso
```

### 5.4 创建可启动的软盘镜像
```bash
grub-mkrescue --format=floppy -o grub-rescue.img
```

## 6. 常见问题与解决方案

### 6.1 问题：grub-mkrescue: command not found
**解决方案**：安装 GRUB 救援工具
- Ubuntu/Debian: `apt install grub-rescue-pc`
- CentOS/RHEL: `yum install grub2-tools-extra`

### 6.2 问题：grub-mkrescue: error: cannot find mtools
**解决方案**：安装 mtools 工具
```bash
apt install mtools
```

### 6.3 问题：grub-mkrescue: error: cannot find xorriso
**解决方案**：安装 xorriso 工具
```bash
apt install xorriso
```

### 6.4 问题：grub-mkrescue: error: cannot open `/usr/lib/grub/i386-pc/modinfo.sh'
**解决方案**：安装 grub-pc-bin 包
```bash
apt install grub-pc-bin
```

### 6.5 问题：grub-mkrescue: error: failed to create the ISO image
**解决方案**：确保有足够的磁盘空间和写入权限
```bash
df -h
chmod 755 .
```

### 6.6 问题：救援镜像无法启动
**解决方案**：检查 BIOS/UEFI 设置，确保从正确的设备启动

## 7. 命令对比

| 命令 | 功能 | 适用场景 |
|------|------|----------|
| grub-mkrescue | 创建 GRUB 救援镜像 | 创建可启动的救援媒体 |
| grub-install | 安装 GRUB 引导加载器 | 系统安装或修复引导 |
| grub-mkconfig | 生成 GRUB 配置文件 | 更新引导菜单 |
| grub-probe | 探测设备信息 | 诊断引导问题 |
| grub-script-check | 检查 GRUB 脚本 | 验证配置文件语法 |
| update-grub | 更新 GRUB 配置 | 简化配置更新过程 |

## 8. 注意事项
- grub-mkrescue 是 GRUB 引导加载器的工具，用于创建 GRUB 救援镜像
- 它可以创建可启动的 ISO 镜像或软盘镜像，用于系统救援和修复引导问题
- 常用的操作包括：创建救援镜像、写入 USB 设备、包含自定义配置等
- 在使用 grub-mkrescue 时，可能需要 root 权限才能执行操作
- 创建救援镜像需要 mtools 和 xorriso 等依赖工具
- 救援镜像可以用于修复引导问题、恢复系统或从故障中启动
- 建议定期创建救援镜像并存储在安全的位置
- 写入 USB 设备时，要确保选择正确的设备，避免覆盖重要数据
- 救援镜像的大小通常在几十兆字节左右
- 对于 EFI 系统，可能需要创建支持 EFI 的救援镜像