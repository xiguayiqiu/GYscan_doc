# bootctl - 控制启动加载器

## 1. 命令简介
bootctl 命令用于控制启动加载器，是 Linux 系统中常用的系统管理命令之一。它是 systemd 系统的一部分，用于管理系统的启动加载器配置。

## 2. 命令语法
```bash
bootctl [选项] [命令]
```

## 3. 常用选项

| 选项 | 说明 |
|------|------|
| -h, --help | 显示帮助信息 |
| --version | 显示版本信息 |
| --no-pager | 不使用分页器 |
| --no-legend | 不显示图例 |

## 4. 常用命令

| 命令 | 说明 |
|------|------|
| status | 显示启动加载器状态 |
| install | 安装启动加载器 |
| update | 更新启动加载器 |
| remove | 移除启动加载器 |
| set-default | 设置默认启动项 |
| set-oneshot | 设置一次性启动项 |
| list | 显示启动项列表 |
| reboot-to-firmware | 重启到固件设置 |

## 5. 实战示例

### 5.1 查看启动加载器状态
```bash
bootctl status
```

### 5.2 安装启动加载器
```bash
sudo bootctl install
```

### 5.3 更新启动加载器
```bash
sudo bootctl update
```

### 5.4 移除启动加载器
```bash
sudo bootctl remove
```

### 5.5 设置默认启动项
```bash
sudo bootctl set-default <启动项名称>
```

### 5.6 设置一次性启动项
```bash
sudo bootctl set-oneshot <启动项名称>
```

### 5.7 显示启动项列表
```bash
bootctl list
```

### 5.8 重启到固件设置
```bash
sudo bootctl reboot-to-firmware
```

## 6. 高级用法

### 6.1 配置启动加载器
```bash
# 查看启动加载器配置
sudo cat /boot/loader/loader.conf

# 编辑启动加载器配置
sudo nano /boot/loader/loader.conf
```

### 6.2 管理启动项
```bash
# 查看启动项配置
sudo ls -la /boot/loader/entries/

# 编辑启动项配置
sudo nano /boot/loader/entries/<启动项文件>.conf
```

### 6.3 与其他命令结合使用
```bash
# 查看系统启动时间
systemd-analyze

# 查看启动项详情
bootctl list | grep "default"
```

### 6.4 监控启动加载器状态
```bash
# 监控启动加载器状态变化
bootctl status --no-pager | watch -n 1
```

## 7. 常见问题与解决方案

### 7.1 问题：bootctl: command not found
**解决方案**：安装 systemd-boot
- Ubuntu/Debian: `apt install systemd-boot`
- CentOS/RHEL: `yum install systemd-boot`

### 7.2 问题：无法安装启动加载器
**解决方案**：确保有足够的权限
```bash
sudo bootctl install
```

### 7.3 问题：启动加载器安装失败
**解决方案**：检查磁盘分区和文件系统

### 7.4 问题：无法设置默认启动项
**解决方案**：确保启动项存在
```bash
bootctl list
```

### 7.5 问题：bootctl 命令执行缓慢
**解决方案**：检查系统负载和磁盘状态

## 8. 命令对比

| 命令 | 功能 | 适用场景 |
|------|------|----------|
| bootctl | 控制启动加载器 | systemd 系统 |
| grub-install | 安装 GRUB 引导加载器 | GRUB 引导 |
| grub-mkconfig | 生成 GRUB 配置文件 | GRUB 引导 |
| efibootmgr | 管理 EFI 启动项 | EFI 系统 |

## 9. 注意事项
- bootctl 命令用于控制启动加载器，是 Linux 系统中常用的系统管理命令之一
- bootctl 命令是 systemd 系统的一部分，用于管理系统的启动加载器配置
- 常用的操作包括：查看启动加载器状态、安装启动加载器、更新启动加载器、移除启动加载器等
- bootctl 命令需要 root 权限来执行大部分操作
- bootctl 命令支持多种子命令，可以根据需要选择合适的命令
- bootctl 命令是现代 Linux 系统的标准工具，用于管理 systemd-boot 启动加载器