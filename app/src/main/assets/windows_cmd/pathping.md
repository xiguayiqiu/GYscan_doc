# pathping命令

## 命令简介

`pathping`命令是Windows中的一个命令，用于路径ping。

## 语法

```cmd
pathping [选项] [目标]
```

## 选项

| 选项 | 描述 |
|------|------|
| `-g <主机列表>` | 沿着主机列表指定的路径进行路由 |
| `-h <最大跳数>` | 指定最大跳数 |
| `-i <TTL>` | 指定TTL值 |
| `-n` | 以数字形式显示地址 |
| `-p <周期>` | 指定探测之间的时间间隔（毫秒） |
| `-q <探测数>` | 指定每个节点的探测数 |
| `-w <超时>` | 指定超时时间（毫秒） |
| `-4` | 仅使用IPv4 |
| `-6` | 仅使用IPv6 |

## 示例

### 路径ping

```cmd
# 基本路径ping
pathping example.com

# 以数字形式显示地址
pathping -n example.com

# 指定最大跳数
pathping -h 10 example.com

# 指定每个节点的探测数
pathping -q 5 example.com
```

## 高级用法

### 批量路径ping

```cmd
# 创建一个批处理文件
@echo off

# 批量路径ping
echo 路径ping example.com
pathping example.com

echo 路径ping google.com
pathping google.com

echo 操作完成
```

## 常见问题

### 问题：pathping命令执行失败

**原因**：可能是权限不足，或者命令语法错误。

**解决方法**：以管理员身份运行命令提示符，确保命令语法正确。

### 问题：路径ping失败

**原因**：可能是网络连接问题，或者目标不可达。

**解决方法**：确保网络连接正常，确保目标可达。

## 命令对比

| 命令 | 功能 | 特点 |
|------|------|------|
| `pathping` | 路径ping | 用于路径分析 |
| `ping` | 网络连接测试 | 用于网络连接测试 |
| `tracert` | 路由跟踪 | 用于路由跟踪 |

## 注意事项

1. **权限要求**：使用`pathping`命令需要管理员权限。

2. **网络连接**：需要确保网络连接正常。

3. **适用场景**：`pathping`命令适用于路径分析的场景。