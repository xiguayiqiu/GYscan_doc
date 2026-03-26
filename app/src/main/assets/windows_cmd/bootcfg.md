# bootcfg命令

## 命令简介

`bootcfg`命令是Windows中的一个命令，用于配置和修改Boot.ini文件，用于管理Windows启动选项。

## 语法

```cmd
bootcfg [选项]
```

## 选项

| 选项 | 描述 |
|------|------|
| `/add` | 添加启动项 |
| `/copy` | 复制启动项 |
| `/delete` | 删除启动项 |
| `/raw` | 编辑启动项的原始数据 |
| `/default` | 设置默认启动项 |
| `/timeout` | 设置启动菜单超时时间 |
| `/query` | 显示当前启动配置 |
| `/debug` | 配置调试设置 |
| `/ems` | 配置紧急管理服务设置 |

## 示例

### 显示启动配置

```cmd
# 显示当前启动配置
bootcfg /query
```

### 添加启动项

```cmd
# 添加启动项
bootcfg /add /d "Windows XP" /l C: /f /sos
```

### 设置默认启动项

```cmd
# 设置默认启动项
bootcfg /default /id 1
```

### 设置启动菜单超时时间

```cmd
# 设置启动菜单超时时间为30秒
bootcfg /timeout 30
```

### 删除启动项

```cmd
# 删除启动项
bootcfg /delete /id 2
```

## 高级用法

### 配置调试设置

```cmd
# 启用内核调试
bootcfg /debug /id 1 /port com1 /baud 115200

# 禁用内核调试
bootcfg /debug /id 1 /off
```

### 配置紧急管理服务

```cmd
# 启用紧急管理服务
bootcfg /ems /id 1 /port com1 /baud 115200

# 禁用紧急管理服务
bootcfg /ems /id 1 /off
```

## 常见问题

### 问题：bootcfg命令不可用

**原因**：在较新的Windows版本中，bootcfg命令已被bcdedit命令取代。

**解决方法**：在较新的Windows版本中使用bcdedit命令。

### 问题：命令执行失败

**原因**：可能是权限不足，或者Boot.ini文件不存在。

**解决方法**：以管理员身份运行命令提示符，确保Boot.ini文件存在。

## 命令对比

| 命令 | 功能 | 特点 |
|------|------|------|
| `bootcfg` | 配置Boot.ini | 用于配置和修改Boot.ini文件 |
| `bcdedit` | 编辑启动配置 | 用于编辑BCD设置，取代bootcfg |
| `bootrec` | 修复启动记录 | 用于修复MBR和BCD |

## 注意事项

1. **命令可用性**：在较新的Windows版本中，`bootcfg`命令已被`bcdedit`命令取代。

2. **权限要求**：使用`bootcfg`命令需要管理员权限。

3. **适用场景**：`bootcfg`命令适用于配置和修改Boot.ini文件的场景，在较新的Windows版本中建议使用`bcdedit`命令。