# diskshadow 命令

## 命令说明
磁盘卷影副本

## 语法
```
diskshadow
```

## 功能
创建和管理卷影副本。

## 子命令
- `set context`：设置上下文
- `add volume`：添加卷
- `create`：创建卷影副本
- `delete`：删除卷影副本
- `list`：列出卷影副本

## 示例
```
diskshadow
set context persistent
add volume C:\
create
list shadows all
```

## 注意事项
- 用于创建和管理卷影副本
- 可以创建磁盘的快照
- 需要管理员权限才能使用
- 适用于备份和恢复操作