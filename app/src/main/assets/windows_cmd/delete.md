# delete 命令

## 命令说明
删除项目

## 语法
```
delete [对象] [参数]
```

## 功能
在不同的上下文中删除项目，例如在 diskpart 中删除分区或卷。

## 示例
```
delete partition
delete volume
delete disk
```

## 注意事项
- 此命令在不同的上下文中有不同的用法
- 在 diskpart 中，用于删除磁盘、分区或卷
- 使用时要小心，删除操作通常不可恢复