# attributes命令

## 命令简介

`attributes`命令是Windows磁盘管理工具中的一个命令，用于查看或修改磁盘、分区或卷的属性。

## 语法

```cmd
attributes [选项]
```

## 选项

| 选项 | 描述 |
|------|------|
| `volume` | 查看或修改卷的属性 |
| `disk` | 查看或修改磁盘的属性 |
| `set` | 设置属性 |
| `clear` | 清除属性 |

## 示例

### 查看卷的属性

```cmd
# 打开磁盘管理工具
diskpart

# 选择卷
select volume 1

# 查看卷的属性
attributes volume

# 退出磁盘管理工具
exit
```

### 查看磁盘的属性

```cmd
# 打开磁盘管理工具
diskpart

# 选择磁盘
select disk 0

# 查看磁盘的属性
attributes disk

# 退出磁盘管理工具
exit
```

### 设置卷的属性

```cmd
# 打开磁盘管理工具
diskpart

# 选择卷
select volume 1

# 设置卷为只读
attributes volume set readonly

# 退出磁盘管理工具
exit
```

### 清除卷的属性

```cmd
# 打开磁盘管理工具
diskpart

# 选择卷
select volume 1

# 清除卷的只读属性
attributes volume clear readonly

# 退出磁盘管理工具
exit
```

## 高级用法

### 批量修改卷的属性

```cmd
# 打开磁盘管理工具
diskpart

# 列出所有卷
list volume

# 循环修改卷的属性
for /l %%i in (1,1,3) do (
    select volume %%i
    attributes volume clear readonly
)

# 退出磁盘管理工具
exit
```

## 常见问题

### 问题：无法修改属性

**原因**：可能是权限不足，或者磁盘正在被使用。

**解决方法**：以管理员身份运行命令提示符，确保磁盘没有被其他程序使用。

### 问题：修改属性后没有生效

**原因**：可能需要重启系统才能生效。

**解决方法**：重启系统，或者重新挂载磁盘。

## 命令对比

| 命令 | 功能 | 特点 |
|------|------|------|
| `attributes` | 管理磁盘/卷属性 | 查看或修改磁盘、分区或卷的属性 |
| `attrib` | 管理文件属性 | 查看或修改文件的属性 |
| `list` | 列出对象 | 显示磁盘、分区或卷的信息 |

## 注意事项

1. **权限要求**：使用diskpart工具需要管理员权限。

2. **磁盘状态**：修改磁盘属性时，确保磁盘没有被其他程序使用。

3. **系统影响**：修改系统磁盘的属性可能会影响系统的正常运行，操作前请谨慎。

4. **适用场景**：`attributes`命令适用于管理磁盘、分区或卷属性的场景。