# reg命令

## 命令简介

`reg`命令是Windows中的一个命令，用于注册表操作。

## 语法

```cmd
reg [操作] [选项] [键路径]
```

## 操作

| 操作 | 描述 |
|------|------|
| `add` | 添加注册表项 |
| `delete` | 删除注册表项 |
| `query` | 查询注册表项 |
| `copy` | 复制注册表项 |
| `save` | 保存注册表项 |
| `load` | 加载注册表项 |
| `unload` | 卸载注册表项 |
| `compare` | 比较注册表项 |
| `export` | 导出注册表项 |
| `import` | 导入注册表项 |
| `restore` | 恢复注册表项 |
| `flush` | 刷新注册表 |
| `set` | 设置注册表项 |
| `deletevalue` | 删除注册表值 |
| `addvalue` | 添加注册表值 |

## 选项

| 选项 | 描述 |
|------|------|
| `/v <值名>` | 指定值名 |
| `/t <类型>` | 指定值类型（REG_SZ、REG_DWORD、REG_BINARY等） |
| `/d <数据>` | 指定数据 |
| `/f` | 强制操作 |
| `/s <分隔符>` | 指定多值分隔符 |
| `/se <大小>` | 指定扩展大小 |
| `/sddl <SDDL>` | 指定安全描述符 |

## 示例

### 注册表操作

```cmd
# 添加注册表项
reg add HKCU\Software\Microsoft\Windows\CurrentVersion\Run /v MyApp /t REG_SZ /d "C:\MyApp\MyApp.exe"

# 删除注册表项
reg delete HKCU\Software\Microsoft\Windows\CurrentVersion\Run /v MyApp /f

# 查询注册表项
reg query HKCU\Software\Microsoft\Windows\CurrentVersion\Run

# 导出注册表项
reg export HKCU\Software\Microsoft\Windows\CurrentVersion\Run run.reg

# 导入注册表项
reg import run.reg
```

## 高级用法

### 批量注册表操作

```cmd
# 创建一个批处理文件
@echo off

# 批量注册表操作
echo 添加注册表项
reg add HKCU\Software\MyApp /v Version /t REG_SZ /d "1.0"
reg add HKCU\Software\MyApp /v Path /t REG_SZ /d "C:\MyApp"

echo 查询注册表项
reg query HKCU\Software\MyApp

echo 操作完成
```

## 常见问题

### 问题：reg命令执行失败

**原因**：可能是权限不足，或者命令语法错误。

**解决方法**：以管理员身份运行命令提示符，确保命令语法正确。

### 问题：注册表操作失败

**原因**：可能是权限不足，或者注册表项不存在。

**解决方法**：以管理员身份运行命令提示符，确保注册表项存在。

## 命令对比

| 命令 | 功能 | 特点 |
|------|------|------|
| `reg` | 注册表操作 | 用于注册表操作 |
| `regedit` | 注册表编辑器 | 用于图形化注册表编辑 |
| `regini` | 注册表初始化 | 用于注册表初始化 |

## 注意事项

1. **权限要求**：使用`reg`命令需要管理员权限。

2. **备份**：在修改注册表前，建议先备份注册表。

3. **适用场景**：`reg`命令适用于注册表操作的场景。