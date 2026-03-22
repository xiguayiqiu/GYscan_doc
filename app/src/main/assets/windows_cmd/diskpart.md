# diskpart 命令

## 命令说明
磁盘分区

## 语法
```
diskpart
```

## 功能
管理磁盘分区。

## 子命令
- `list disk`：列出所有磁盘
- `select disk`：选择磁盘
- `list partition`：列出分区
- `select partition`：选择分区
- `create partition`：创建分区
- `delete partition`：删除分区
- `format`：格式化分区
- `active`：激活分区
- `assign`：分配驱动器号

## 示例
```
diskpart
list disk
select disk 0
list partition
create partition primary size=10240
format fs=ntfs quick
assign letter=E
```

## 注意事项
- 用于管理磁盘分区
- 功能强大，操作需谨慎
- 需要管理员权限才能使用
- 适用于磁盘分区管理