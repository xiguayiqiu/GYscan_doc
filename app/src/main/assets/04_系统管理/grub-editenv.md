# grub-editenv - GRUB 环境变量编辑工具

## 1. 命令简介
grub-editenv 是 GRUB 引导加载器的工具，用于编辑 GRUB 环境变量。它可以创建、修改、删除 GRUB 环境变量，这些变量用于存储 GRUB 的配置信息。

## 2. 命令语法
```bash
grub-editenv [选项] <文件> <命令>
grub-editenv [选项] <文件> set [变量=值...]
grub-editenv [选项] <文件> unset <变量...>
```

## 3. 常用选项

| 选项 | 说明 |
|------|------|
| -h, --help | 显示帮助信息 |
| -v, --version | 显示版本信息 |
| --no-floppy | 不检查软盘设备 |

## 4. 命令参数

| 命令 | 说明 |
|------|------|
| create | 创建环境变量文件 |
| list | 列出环境变量 |
| set [name=value] | 设置环境变量 |
| unset <name> | 取消设置环境变量 |

## 5. 实战示例

### 5.1 创建环境变量文件
```bash
grub-editenv /boot/grub/grubenv create
```

### 5.2 列出环境变量
```bash
grub-editenv /boot/grub/grubenv list
```

### 5.3 设置环境变量
```bash
grub-editenv /boot/grub/grubenv set default=0
```

### 5.4 取消设置环境变量
```bash
grub-editenv /boot/grub/grubenv unset default
```

### 5.5 同时设置多个环境变量
```bash
grub-editenv /boot/grub/grubenv set default=0 timeout=5
```

### 5.6 同时取消多个环境变量
```bash
grub-editenv /boot/grub/grubenv unset default timeout
```

## 6. 高级用法

### 6.1 设置默认引导项
```bash
grub-editenv /boot/grub/grubenv set default=0
```

### 6.2 设置引导超时
```bash
grub-editenv /boot/grub/grubenv set timeout=5
```

### 6.3 设置引导菜单隐藏
```bash
grub-editenv /boot/grub/grubenv set menu_auto_hide=1
```

### 6.4 设置 GRUB 密码
```bash
grub-editenv /boot/grub/grubenv set superusers="user"
grub-editenv /boot/grub/grubenv set password_pbkdf2 user grub.pbkdf2.sha512.10000.xxx
```

### 6.5 在脚本中使用
```bash
#!/bin/bash

# 备份当前环境变量
grub-editenv /boot/grub/grubenv list > /boot/grub/grubenv.bak

# 设置新的环境变量
grub-editenv /boot/grub/grubenv set default=0 timeout=10

# 验证设置
echo "Current GRUB environment variables:"
grub-editenv /boot/grub/grubenv list
```

### 6.6 恢复默认环境变量
```bash
grub-editenv /boot/grub/grubenv create
grub-editenv /boot/grub/grubenv set default=0 timeout=5
```

## 7. 常见问题与解决方案

### 7.1 问题：grub-editenv: command not found
**解决方案**：安装 GRUB 工具包
- Ubuntu/Debian: `apt install grub2-common`
- CentOS/RHEL: `yum install grub2-tools`

### 7.2 问题：grub-editenv: error: cannot open `/boot/grub/grubenv'
**解决方案**：创建环境变量文件
```bash
grub-editenv /boot/grub/grubenv create
```

### 7.3 问题：grub-editenv: error: cannot write to `/boot/grub/grubenv'
**解决方案**：确保有写入权限
```bash
chmod 644 /boot/grub/grubenv
```

### 7.4 问题：grub-editenv: error: invalid environment block
**解决方案**：重新创建环境变量文件
```bash
rm /boot/grub/grubenv
grub-editenv /boot/grub/grubenv create
grub-editenv /boot/grub/grubenv set default=0 timeout=5
```

### 7.5 问题：环境变量设置后不生效
**解决方案**：确保 GRUB 配置文件使用环境变量
```bash
grub-mkconfig -o /boot/grub/grub.cfg
```

### 7.6 问题：无法设置某些环境变量
**解决方案**：检查变量名是否正确，某些变量可能需要在 GRUB 配置文件中设置

## 8. 命令对比

| 命令 | 功能 | 适用场景 |
|------|------|----------|
| grub-editenv | 编辑 GRUB 环境变量 | 配置 GRUB 行为 |
| grub-install | 安装 GRUB 引导加载器 | 系统安装或修复引导 |
| grub-mkconfig | 生成 GRUB 配置文件 | 更新引导菜单 |
| grub-mkrescue | 创建 GRUB 救援镜像 | 创建可启动的救援媒体 |
| grub-probe | 探测设备信息 | 诊断引导问题 |
| update-grub | 更新 GRUB 配置 | 简化配置更新过程 |

## 9. 注意事项
- grub-editenv 是 GRUB 引导加载器的工具，用于编辑 GRUB 环境变量
- 它可以创建、修改、删除 GRUB 环境变量，这些变量用于存储 GRUB 的配置信息
- 常用的操作包括：设置默认引导项、设置引导超时、管理 GRUB 密码等
- 在使用 grub-editenv 时，可能需要 root 权限才能执行操作
- 环境变量文件通常位于 /boot/grub/grubenv
- 对于 EFI 系统，环境变量文件可能位于 /boot/efi/EFI/ubuntu/grubenv 或类似路径
- 环境变量的更改会在下次启动时生效
- 可以同时设置或取消多个环境变量
- 建议在修改环境变量前备份原始文件
- 环境变量的优先级低于 GRUB 配置文件中的设置