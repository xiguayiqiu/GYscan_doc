# fondue命令

## 命令简介

`fondue`命令是Windows中的一个命令，用于启用Windows功能。

## 语法

```cmd
fondue [选项]
```

## 选项

| 选项 | 描述 |
|------|------|
| `/enable-feature:<功能>` | 启用指定功能 |
| `/enable-feature:<功能> /all` | 启用指定功能及其所有依赖项 |
| `/norestart` | 启用功能后不重启计算机 |

## 示例

### 启用Windows功能

```cmd
# 启用.NET Framework 3.5
fondue /enable-feature:NetFx3

# 启用.NET Framework 3.5及其所有依赖项
fondue /enable-feature:NetFx3 /all

# 启用功能后不重启计算机
fondue /enable-feature:NetFx3 /norestart
```

## 高级用法

### 批量启用功能

```cmd
# 创建一个批处理文件
@echo off

# 批量启用功能
echo 启用.NET Framework 3.5
fondue /enable-feature:NetFx3 /all /norestart

echo 启用Windows Subsystem for Linux
fondue /enable-feature:Microsoft-Windows-Subsystem-Linux /all /norestart

echo 操作完成
```

## 常见问题

### 问题：fondue命令执行失败

**原因**：可能是权限不足，或者功能名称不正确。

**解决方法**：以管理员身份运行命令提示符，确保功能名称正确。

### 问题：功能启用失败

**原因**：可能是网络连接问题，或者功能依赖项缺失。

**解决方法**：检查网络连接，确保所有依赖项可用。

## 命令对比

| 命令 | 功能 | 特点 |
|------|------|------|
| `fondue` | 启用Windows功能 | 用于启用Windows功能 |
| `dism` | 部署映像服务管理 | 用于管理Windows映像 |
| `optionalfeatures` | 启用或关闭Windows功能 | 图形界面的功能管理工具 |

## 注意事项

1. **权限要求**：使用`fondue`命令需要管理员权限。

2. **网络连接**：`fondue`命令可能需要网络连接来下载功能所需的文件。

3. **适用场景**：`fondue`命令适用于启用Windows功能的场景。