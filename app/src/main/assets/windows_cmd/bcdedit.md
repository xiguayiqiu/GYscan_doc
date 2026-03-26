# bcdedit命令

## 命令简介

`bcdedit`命令是Windows中的一个命令，用于编辑启动配置数据（BCD），用于管理Windows启动选项。

## 语法

```cmd
bcdedit [选项]
```

## 选项

| 选项 | 描述 |
|------|------|
| `/enum` | 显示启动配置 |
| `/create` | 创建新的启动项 |
| `/delete` | 删除启动项 |
| `/set` | 设置启动项属性 |
| `/default` | 设置默认启动项 |
| `/timeout` | 设置启动菜单超时时间 |
| `/displayorder` | 设置启动菜单显示顺序 |
| `/bootsequence` | 设置启动序列 |
| `/import` | 导入BCD配置 |
| `/export` | 导出BCD配置 |

## 示例

### 显示启动配置

```cmd
# 显示所有启动配置
bcdedit /enum

# 显示固件启动配置
bcdedit /enum firmware

# 显示引导管理器配置
bcdedit /enum bootmgr
```

### 设置默认启动项

```cmd
# 设置默认启动项
bcdedit /default {current}

# 设置指定启动项为默认
bcdedit /default {guid}
```

### 设置启动菜单超时时间

```cmd
# 设置启动菜单超时时间为30秒
bcdedit /timeout 30

# 禁用启动菜单超时
bcdedit /timeout 0
```

### 创建和删除启动项

```cmd
# 创建新的启动项
bcdedit /create /d "Windows 10" /application osloader

# 删除启动项
bcdedit /delete {guid}

# 删除所有非活动启动项
bcdedit /delete value
```

## 高级用法

### 修改启动项属性

```cmd
# 修改启动项的描述
bcdedit /set {guid} description "Windows 10 Pro"

# 启用测试模式
bcdedit /set testsigning on

# 启用安全启动
bcdedit /set {bootmgr} secureboot on
```

### 导出和导入BCD配置

```cmd
# 导出BCD配置
bcdedit /export C:\bcd_backup

# 导入BCD配置
bcdedit /import C:\bcd_backup
```

## 常见问题

### 问题：bcdedit命令执行失败

**原因**：可能是权限不足，或者BCD配置损坏。

**解决方法**：以管理员身份运行命令提示符，使用`bootrec /rebuildbcd`修复BCD配置。

### 问题：启动项未显示

**原因**：可能是启动项被隐藏，或者BCD配置损坏。

**解决方法**：使用`bcdedit /enum all`显示所有启动项，使用`bootrec /rebuildbcd`修复BCD配置。

## 命令对比

| 命令 | 功能 | 特点 |
|------|------|------|
| `bcdedit` | 编辑启动配置 | 用于编辑BCD设置 |
| `bcdboot` | 创建或修复启动配置 | 用于创建或修复BCD |
| `bootrec` | 修复启动记录 | 用于修复MBR和BCD |

## 注意事项

1. **权限要求**：使用`bcdedit`命令需要管理员权限。

2. **谨慎操作**：修改BCD配置可能会影响系统启动，操作前请备份BCD配置。

3. **适用场景**：`bcdedit`命令适用于编辑Windows启动配置的场景。