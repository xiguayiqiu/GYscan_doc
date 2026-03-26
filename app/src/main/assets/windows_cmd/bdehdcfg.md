# bdehdcfg命令

## 命令简介

`bdehdcfg`命令是Windows中的一个命令，用于BitLocker驱动器配置。

## 语法

```cmd
bdehdcfg [选项]
```

## 选项

| 选项 | 描述 |
|------|------|
| `-target <目标>` | 指定目标驱动器 |
| `-size <大小>` | 指定系统分区大小 |
| `-default` | 使用默认设置 |
| `-quiet` | 静默模式 |
| `-restart` | 配置后重启 |
| `-unlock` | 解锁驱动器 |
| `-lock` | 锁定驱动器 |
| `-status` | 显示状态 |

## 示例

### 配置BitLocker驱动器

```cmd
# 配置BitLocker驱动器
bdehdcfg -target c: -size 350

# 使用默认设置配置BitLocker驱动器
bdehdcfg -default

# 静默模式配置BitLocker驱动器
bdehdcfg -target c: -size 350 -quiet

# 配置后重启
bdehdcfg -target c: -size 350 -restart

# 显示BitLocker驱动器状态
bdehdcfg -status
```

## 高级用法

### 批量配置BitLocker驱动器

```cmd
# 创建一个批处理文件
@echo off

# 批量配置BitLocker驱动器
echo 配置BitLocker驱动器
bdehdcfg -target c: -size 350 -quiet

echo 显示BitLocker驱动器状态
bdehdcfg -status

echo 操作完成
```

## 常见问题

### 问题：bdehdcfg命令执行失败

**原因**：可能是权限不足，或者驱动器不支持BitLocker。

**解决方法**：以管理员身份运行命令提示符，确保驱动器支持BitLocker。

### 问题：BitLocker配置失败

**原因**：可能是磁盘空间不足，或者权限不足。

**解决方法**：确保磁盘空间足够，以管理员身份运行命令提示符。

## 命令对比

| 命令 | 功能 | 特点 |
|------|------|------|
| `bdehdcfg` | BitLocker驱动器配置 | 用于BitLocker驱动器配置 |
| `manage-bde` | BitLocker管理 | 用于BitLocker管理 |
| `diskpart` | 磁盘分区管理 | 用于磁盘分区管理 |

## 注意事项

1. **权限要求**：使用`bdehdcfg`命令需要管理员权限。

2. **驱动器支持**：确保驱动器支持BitLocker。

3. **适用场景**：`bdehdcfg`命令适用于BitLocker驱动器配置的场景。