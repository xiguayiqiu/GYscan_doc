# uniqueid命令

## 命令简介

`uniqueid`命令是Windows中的一个命令，用于显示或设置磁盘的唯一ID。

## 语法

```cmd
uniqueid [选项]
```

## 选项

| 选项 | 描述 |
|------|------|
| `disk` | 显示或设置磁盘的唯一ID |
| `partition` | 显示或设置分区的唯一ID |
| `id=<ID>` | 设置唯一ID |

## 示例

### 显示或设置唯一ID

```cmd
# 显示磁盘的唯一ID
uniqueid disk

# 设置磁盘的唯一ID
uniqueid disk id=12345678

# 显示分区的唯一ID
uniqueid partition

# 设置分区的唯一ID
uniqueid partition id=87654321
```

## 高级用法

### 批量显示或设置唯一ID

```cmd
# 创建一个批处理文件
@echo off

# 批量显示或设置唯一ID
echo 显示磁盘0的唯一ID
diskpart
select disk 0
uniqueid disk
exit

echo 操作完成
```

## 常见问题

### 问题：uniqueid命令执行失败

**原因**：可能是权限不足，或者命令不可用。

**解决方法**：以管理员身份运行命令提示符，确保命令可用。

### 问题：唯一ID显示或设置失败

**原因**：可能是磁盘不可用，或者权限不足。

**解决方法**：确保磁盘可用，以管理员身份运行命令提示符。

## 命令对比

| 命令 | 功能 | 特点 |
|------|------|------|
| `uniqueid` | 显示或设置唯一ID | 用于显示或设置唯一ID |
| `detail` | 显示详细信息 | 用于显示详细信息 |
| `select` | 选择对象 | 用于选择对象 |

## 注意事项

1. **权限要求**：使用`uniqueid`命令需要管理员权限。

2. **命令环境**：`uniqueid`命令通常在diskpart命令环境中使用。

3. **适用场景**：`uniqueid`命令适用于显示或设置唯一ID的场景。