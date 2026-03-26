# cmdkey命令

## 命令简介

`cmdkey`命令是Windows中的一个命令，用于凭据管理器。

## 语法

```cmd
cmdkey [选项]
```

## 选项

| 选项 | 描述 |
|------|------|
| `/add:<目标>` | 添加凭据 |
| `/generic:<目标>` | 添加通用凭据 |
| `/user:<用户名>` | 指定用户名 |
| `/pass:<密码>` | 指定密码 |
| `/delete:<目标>` | 删除凭据 |
| `/delete:*` | 删除所有凭据 |
| `/list` | 列出所有凭据 |

## 示例

### 凭据管理

```cmd
# 添加凭据
cmdkey /add:servername /user:username /pass:password

# 添加通用凭据
cmdkey /generic:servername /user:username /pass:password

# 列出所有凭据
cmdkey /list

# 删除凭据
cmdkey /delete:servername

# 删除所有凭据
cmdkey /delete:*
```

## 高级用法

### 批量凭据管理

```cmd
# 创建一个批处理文件
@echo off

# 批量凭据管理
echo 列出当前凭据
cmdkey /list
echo 添加新凭据
cmdkey /add:server1 /user:user1 /pass:pass1
echo 列出更新后的凭据
cmdkey /list
echo 操作完成
```

## 常见问题

### 问题：cmdkey命令执行失败

**原因**：可能是权限不足，或者命令语法错误。

**解决方法**：以管理员身份运行命令提示符，确保命令语法正确。

### 问题：凭据管理失败

**原因**：可能是权限不足，或者凭据已存在。

**解决方法**：以管理员身份运行命令提示符，确保凭据不存在。

## 命令对比

| 命令 | 功能 | 特点 |
|------|------|------|
| `cmdkey` | 凭据管理器 | 用于管理Windows凭据 |
| `net use` | 网络连接 | 用于建立网络连接 |
| `runas` | 以其他用户身份运行 | 用于以其他用户身份运行程序 |

## 注意事项

1. **权限要求**：使用`cmdkey`命令需要管理员权限。

2. **凭据安全**：需要确保凭据安全，避免明文密码。

3. **适用场景**：`cmdkey`命令适用于管理Windows凭据的场景。