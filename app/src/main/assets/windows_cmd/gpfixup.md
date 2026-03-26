# gpfixup命令

## 命令简介

`gpfixup`命令是Windows中的一个命令，用于组策略修复。

## 语法

```cmd
gpfixup [选项]
```

## 选项

| 选项 | 描述 |
|------|------|
| `/olddns:<旧DNS名称>` | 指定旧的DNS名称 |
| `/newdns:<新DNS名称>` | 指定新的DNS名称 |
| `/oldnb:<旧NetBIOS名称>` | 指定旧的NetBIOS名称 |
| `/newnb:<新NetBIOS名称>` | 指定新的NetBIOS名称 |
| `/dc:<域控制器>` | 指定域控制器 |
| `/user:<用户名>` | 指定用户名 |
| `/pwd:<密码>` | 指定密码 |

## 示例

### 组策略修复

```cmd
# 修复DNS名称
gpfixup /olddns:old.domain.com /newdns:new.domain.com

# 修复NetBIOS名称
gpfixup /oldnb:OLD /newnb:NEW

# 指定域控制器
gpfixup /olddns:old.domain.com /newdns:new.domain.com /dc:dc1.domain.com

# 指定用户名和密码
gpfixup /olddns:old.domain.com /newdns:new.domain.com /user:administrator /pwd:password
```

## 高级用法

### 批量组策略修复

```cmd
# 创建一个批处理文件
@echo off

# 批量组策略修复
echo 修复DNS名称
gpfixup /olddns:old.domain.com /newdns:new.domain.com
echo 修复NetBIOS名称
gpfixup /oldnb:OLD /newnb:NEW
echo 操作完成
```

## 常见问题

### 问题：gpfixup命令执行失败

**原因**：可能是权限不足，或者命令语法错误。

**解决方法**：以管理员身份运行命令提示符，确保命令语法正确。

### 问题：组策略修复失败

**原因**：可能是权限不足，或者域控制器不可用。

**解决方法**：以管理员身份运行命令提示符，确保域控制器可用。

## 命令对比

| 命令 | 功能 | 特点 |
|------|------|------|
| `gpfixup` | 组策略修复 | 用于修复组策略中的域名信息 |
| `gpupdate` | 组策略更新 | 用于更新组策略 |
| `gpresult` | 组策略结果 | 用于显示组策略结果 |

## 注意事项

1. **权限要求**：使用`gpfixup`命令需要管理员权限。

2. **域控制器**：需要确保域控制器可用。

3. **适用场景**：`gpfixup`命令适用于修复组策略中域名信息的场景。