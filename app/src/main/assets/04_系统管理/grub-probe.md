# grub-probe - GRUB 设备信息探测工具

## 1. 命令简介
grub-probe 是 GRUB 引导加载器的工具，用于探测设备信息。它可以获取文件系统的 UUID、标签、设备路径等信息，是诊断引导问题的重要工具。

## 2. 命令语法
```bash
grub-probe [选项] <path>
grub-probe [选项] --target=<target> <path>
```

## 3. 常用选项

| 选项 | 说明 |
|------|------|
| -h, --help | 显示帮助信息 |
| -v, --version | 显示版本信息 |
| --device-map=<file> | 指定设备映射文件 |
| --target=<target> | 指定目标信息类型 |
| --fs-uuid | 显示文件系统 UUID |
| --fs-label | 显示文件系统标签 |
| --drive | 显示驱动器信息 |
| --device | 显示设备信息 |
| --module | 显示模块信息 |
| --tftp | 显示 TFTP 信息 |
| --no-floppy | 不检查软盘设备 |
| --verbose | 显示详细信息 |

## 4. 目标类型

| 目标类型 | 说明 |
|----------|------|
| device | 显示设备路径 |
| fs | 显示文件系统类型 |
| fs_uuid | 显示文件系统 UUID |
| fs_label | 显示文件系统标签 |
| drive | 显示驱动器信息 |
| module | 显示需要的模块 |
| tftp | 显示 TFTP 路径 |
| cryptodisk_uuid | 显示加密磁盘 UUID |

## 5. 实战示例

### 5.1 探测文件系统 UUID
```bash
grub-probe --fs-uuid /boot
```

### 5.2 探测文件系统标签
```bash
grub-probe --fs-label /boot
```

### 5.3 探测设备信息
```bash
grub-probe --device /boot
```

### 5.4 探测模块信息
```bash
grub-probe --module /boot
```

### 5.5 探测文件系统类型
```bash
grub-probe --target=fs /boot
```

### 5.6 探测引导设备信息
```bash
grub-probe --target=device /boot
```

### 5.7 探测加密磁盘 UUID
```bash
grub-probe --target=cryptodisk_uuid /boot
```

## 6. 高级用法

### 6.1 探测引导设备信息
```bash
grub-probe --target=device /boot
```

### 6.2 探测文件系统类型
```bash
grub-probe --target=fs /boot
```

### 6.3 探测需要的模块
```bash
grub-probe --target=module /boot
```

### 6.4 在脚本中使用
```bash
#!/bin/bash

# 探测引导设备
BOOT_DEVICE=$(grub-probe --target=device /boot)
echo "Boot device: $BOOT_DEVICE"

# 探测文件系统类型
FS_TYPE=$(grub-probe --target=fs /boot)
echo "Filesystem type: $FS_TYPE"

# 探测文件系统 UUID
FS_UUID=$(grub-probe --fs-uuid /boot)
echo "Filesystem UUID: $FS_UUID"
```

### 6.5 探测根分区信息
```bash
grub-probe --target=device /
grub-probe --target=fs /
grub-probe --fs-uuid /
```

## 7. 常见问题与解决方案

### 7.1 问题：grub-probe: command not found
**解决方案**：安装 GRUB 工具包
- Ubuntu/Debian: `apt install grub2-common`
- CentOS/RHEL: `yum install grub2-tools`

### 7.2 问题：grub-probe: error: cannot find a device for /boot (is /dev mounted?)
**解决方案**：确保根文件系统已正确挂载
```bash
mount /dev/sda1 /mnt
chroot /mnt
```

### 7.3 问题：grub-probe: error: unknown filesystem
**解决方案**：确保安装了支持该文件系统的模块
```bash
apt install grub-pc-bin
```

### 7.4 问题：grub-probe: error: cannot open `/boot/grub/device.map'
**解决方案**：创建设备映射文件
```bash
echo "(hd0) /dev/sda" > /boot/grub/device.map
```

### 7.5 问题：grub-probe: error: failed to get canonical path of `/cow'
**解决方案**：在 Live CD 环境中使用正确的路径
```bash
grub-probe --root-directory=/mnt --target=device /mnt/boot
```

### 7.6 问题：grub-probe 返回空结果
**解决方案**：检查路径是否存在，以及文件系统是否已挂载
```bash
ls -la /boot
mount | grep /boot
```

## 8. 命令对比

| 命令 | 功能 | 适用场景 |
|------|------|----------|
| grub-probe | 探测设备信息 | 诊断引导问题 |
| grub-install | 安装 GRUB 引导加载器 | 系统安装或修复引导 |
| grub-mkconfig | 生成 GRUB 配置文件 | 更新引导菜单 |
| grub-mkrescue | 创建 GRUB 救援镜像 | 创建可启动的救援媒体 |
| grub-script-check | 检查 GRUB 脚本 | 验证配置文件语法 |
| update-grub | 更新 GRUB 配置 | 简化配置更新过程 |

## 9. 注意事项
- grub-probe 是 GRUB 引导加载器的工具，用于探测设备信息
- 它可以获取文件系统的 UUID、标签、设备路径等信息，是诊断引导问题的重要工具
- 常用的操作包括：探测文件系统 UUID、探测设备信息、探测文件系统类型等
- 在使用 grub-probe 时，可能需要 root 权限才能执行操作
- grub-probe 可以帮助确定引导设备的正确路径，这对于修复引导问题非常重要
- 对于加密磁盘，可以使用 --target=cryptodisk_uuid 选项获取加密磁盘的 UUID
- 在脚本中使用 grub-probe 可以自动化获取设备信息的过程
- grub-probe 的输出可以直接用于 GRUB 配置文件中
- 探测结果可以帮助确定正确的 root 设备和引导参数
- 对于复杂的存储配置，grub-probe 可以帮助识别正确的设备路径