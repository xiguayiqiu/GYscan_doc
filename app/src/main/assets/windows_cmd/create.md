# create命令

## 命令简介

`create`命令是Windows磁盘管理工具中的一个命令，用于创建磁盘、分区或卷。

## 语法

```cmd
create [选项] [参数]
```

## 选项

| 选项 | 描述 |
|------|------|
| `partition` | 创建分区 |
| `volume` | 创建卷 |
| `vdisk` | 创建虚拟磁盘 |
| `simple` | 创建简单卷 |
| `striped` | 创建带区卷 |
| `mirror` | 创建镜像卷 |
| `raid5` | 创建RAID-5卷 |

## 示例

### 创建主分区

```cmd
# 打开磁盘管理工具
diskpart

# 选择磁盘
select disk 0

# 创建主分区
create partition primary size=10000

# 退出磁盘管理工具
exit
```

### 创建简单卷

```cmd
# 打开磁盘管理工具
diskpart

# 选择磁盘
select disk 0

# 创建简单卷
create volume simple size=10000

# 退出磁盘管理工具
exit
```

### 创建虚拟磁盘

```cmd
# 打开磁盘管理工具
diskpart

# 创建虚拟磁盘
create vdisk file="D:\VirtualDisk.vhdx" maximum=10000 type=fixed

# 附加虚拟磁盘
attach vdisk

# 退出磁盘管理工具
exit
```

### 创建镜像卷

```cmd
# 打开磁盘管理工具
diskpart

# 选择第一个磁盘
select disk 0

# 创建镜像卷
create volume simple size=10000 mirror disk=1

# 退出磁盘管理工具
exit
```

## 高级用法

### 创建扩展分区和逻辑分区

```cmd
# 打开磁盘管理工具
diskpart

# 选择磁盘
select disk 0

# 创建主分区
create partition primary size=10000

# 创建扩展分区
create partition extended

# 在扩展分区中创建逻辑分区
create partition logical size=5000

# 退出磁盘管理工具
exit
```

### 创建带区卷

```cmd
# 打开磁盘管理工具
diskpart

# 创建带区卷
create volume striped size=10000 disk=0,1,2

# 退出磁盘管理工具
exit
```

## 常见问题

### 问题：无法创建分区

**原因**：可能是磁盘空间不足，或者磁盘分区表已满。

**解决方法**：确保有足够的磁盘空间，检查磁盘分区表是否已满。

### 问题：创建卷后无法访问

**原因**：可能是卷未格式化，或者文件系统损坏。

**解决方法**：格式化卷，或者修复文件系统。

## 命令对比

| 命令 | 功能 | 特点 |
|------|------|------|
| `create` | 创建磁盘/分区/卷 | 用于创建新的磁盘、分区或卷 |
| `delete` | 删除磁盘/分区/卷 | 用于删除现有的磁盘、分区或卷 |
| `select` | 选择对象 | 用于选择要操作的磁盘、分区或卷 |

## 注意事项

1. **权限要求**：使用diskpart工具需要管理员权限。

2. **磁盘空间**：创建分区或卷时需要确保有足够的磁盘空间。

3. **数据备份**：创建分区或卷可能会导致数据丢失，操作前请备份重要数据。

4. **适用场景**：`create`命令适用于创建新的磁盘、分区或卷的场景。