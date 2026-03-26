# delete命令

## 命令简介

`delete`命令是Windows磁盘管理工具中的一个命令，用于删除磁盘、分区或卷。

## 语法

```cmd
delete [选项] [参数]
```

## 选项

| 选项 | 描述 |
|------|------|
| `partition` | 删除分区 |
| `volume` | 删除卷 |
| `vdisk` | 删除虚拟磁盘 |

## 示例

### 删除分区

```cmd
# 打开磁盘管理工具
diskpart

# 选择磁盘
select disk 0

# 选择分区
select partition 1

# 删除分区
delete partition

# 退出磁盘管理工具
exit
```

### 删除卷

```cmd
# 打开磁盘管理工具
diskpart

# 选择卷
select volume 1

# 删除卷
delete volume

# 退出磁盘管理工具
exit
```

### 删除虚拟磁盘

```cmd
# 打开磁盘管理工具
diskpart

# 选择虚拟磁盘
select vdisk file="D:\VirtualDisk.vhdx"

# 分离虚拟磁盘
detach vdisk

# 删除虚拟磁盘
delete vdisk

# 退出磁盘管理工具
exit
```

## 高级用法

### 强制删除分区

```cmd
# 打开磁盘管理工具
diskpart

# 选择磁盘
select disk 0

# 选择分区
select partition 1

# 强制删除分区
delete partition override

# 退出磁盘管理工具
exit
```

### 批量删除卷

```cmd
# 打开磁盘管理工具
diskpart

# 列出所有卷
list volume

# 循环删除卷
for /l %%i in (1,1,3) do (
    select volume %%i
    delete volume
)

# 退出磁盘管理工具
exit
```

## 常见问题

### 问题：无法删除分区

**原因**：可能是分区正在被使用，或者是系统分区。

**解决方法**：确保分区没有被使用，不是系统分区，或者使用`override`选项强制删除。

### 问题：删除分区后数据丢失

**原因**：删除分区会导致分区中的数据丢失。

**解决方法**：删除分区前请备份重要数据。

## 命令对比

| 命令 | 功能 | 特点 |
|------|------|------|
| `delete` | 删除磁盘/分区/卷 | 用于删除现有的磁盘、分区或卷 |
| `create` | 创建磁盘/分区/卷 | 用于创建新的磁盘、分区或卷 |
| `select` | 选择对象 | 用于选择要操作的磁盘、分区或卷 |

## 注意事项

1. **权限要求**：使用diskpart工具需要管理员权限。

2. **数据备份**：删除分区或卷会导致数据丢失，操作前请备份重要数据。

3. **系统分区**：删除系统分区会导致系统无法启动，操作前请谨慎。

4. **适用场景**：`delete`命令适用于删除不需要的磁盘、分区或卷的场景。