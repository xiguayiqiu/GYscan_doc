# grub-script-check - GRUB 脚本语法检查工具

## 1. 命令简介
grub-script-check 是 GRUB 引导加载器的工具，用于检查 GRUB 脚本的语法。它可以验证 GRUB 配置文件和脚本的语法正确性，帮助避免引导问题。

## 2. 命令语法
```bash
grub-script-check [选项] <文件>
grub-script-check [选项] - 
```

## 3. 常用选项

| 选项 | 说明 |
|------|------|
| -h, --help | 显示帮助信息 |
| -v, --version | 显示版本信息 |
| -v, --verbose | 详细输出，显示更多检查信息 |
| --no-floppy | 不检查软盘设备 |

## 4. 实战示例

### 4.1 检查 GRUB 脚本
```bash
grub-script-check /boot/grub/grub.cfg
```

### 4.2 详细检查 GRUB 脚本
```bash
grub-script-check -v /boot/grub/grub.cfg
```

### 4.3 检查标准输入中的脚本
```bash
echo "set timeout=10" | grub-script-check -
```

### 4.4 检查自定义菜单项文件
```bash
grub-script-check /etc/grub.d/40_custom
```

## 5. 高级用法

### 5.1 生成并检查 GRUB 配置文件
```bash
# 生成配置文件
grub-mkconfig -o /boot/grub/grub.cfg

# 检查配置文件
grub-script-check /boot/grub/grub.cfg
```

### 5.2 检查多个 GRUB 脚本
```bash
for file in /etc/grub.d/*; do
    echo "Checking $file..."
    grub-script-check $file
done
```

### 5.3 在脚本中使用
```bash
#!/bin/bash

# 检查 GRUB 配置文件
if grub-script-check /boot/grub/grub.cfg; then
    echo "GRUB configuration file is valid"
else
    echo "Error: GRUB configuration file has syntax errors"
    exit 1
fi
```

### 5.4 检查修改后的配置文件
```bash
# 备份原始配置
cp /boot/grub/grub.cfg /boot/grub/grub.cfg.bak

# 修改配置文件
# ... 进行修改 ...

# 检查修改后的配置
if grub-script-check /boot/grub/grub.cfg; then
    echo "Configuration is valid, applying changes"
else
    echo "Error: Invalid configuration, restoring backup"
    cp /boot/grub/grub.cfg.bak /boot/grub/grub.cfg
fi
```

## 6. 常见问题与解决方案

### 6.1 问题：grub-script-check: command not found
**解决方案**：安装 GRUB 工具包
- Ubuntu/Debian: `apt install grub2-common`
- CentOS/RHEL: `yum install grub2-tools`

### 6.2 问题：syntax error at line X
**解决方案**：检查指定行的语法错误，修复后重新检查

### 6.3 问题：error: invalid number `NaN'
**解决方案**：检查配置文件中的数值设置，确保使用有效的数字

### 6.4 问题：error: can't find command `xxx'
**解决方案**：确保使用的命令在 GRUB 中可用，检查命令拼写是否正确

### 6.5 问题：error: variable `xxx' not found
**解决方案**：确保变量已定义，或者使用默认值

### 6.6 问题：error: syntax error near unexpected token `xxx'
**解决方案**：检查语法结构，确保括号、引号等符号配对正确

## 7. 命令对比

| 命令 | 功能 | 适用场景 |
|------|------|----------|
| grub-script-check | 检查 GRUB 脚本语法 | 验证配置文件正确性 |
| grub-install | 安装 GRUB 引导加载器 | 系统安装或修复引导 |
| grub-mkconfig | 生成 GRUB 配置文件 | 更新引导菜单 |
| grub-mkrescue | 创建 GRUB 救援镜像 | 创建可启动的救援媒体 |
| grub-probe | 探测设备信息 | 诊断引导问题 |
| update-grub | 更新 GRUB 配置 | 简化配置更新过程 |

## 8. 注意事项
- grub-script-check 是 GRUB 引导加载器的工具，用于检查 GRUB 脚本的语法
- 它可以验证 GRUB 配置文件和脚本的语法正确性，帮助避免引导问题
- 常用的操作包括：检查配置文件、检查自定义脚本、验证修改后的配置等
- 在使用 grub-script-check 时，可能需要 root 权限才能读取某些文件
- 语法检查通过并不保证配置文件的逻辑正确性，只是确保语法没有错误
- 在修改 GRUB 配置文件后，应该使用 grub-script-check 进行检查
- 对于复杂的 GRUB 脚本，详细模式（-v）可以提供更多的检查信息
- 可以通过管道将脚本内容传递给 grub-script-check 进行检查
- 定期检查 GRUB 配置文件可以帮助预防引导问题
- 如果检查失败，应该根据错误信息修复问题，然后重新检查