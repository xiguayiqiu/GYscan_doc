# dfsrmig 命令

## 命令说明
DFS复制迁移

## 语法
```
dfsrmig [选项]
```

## 功能
管理分布式文件系统（DFS）复制的迁移过程。

## 选项
- `/getglobalstate`：获取全局迁移状态
- `/setglobalstate`：设置全局迁移状态
- `/getmigrationstate`：获取迁移状态
- `/createglobalobjects`：创建全局对象

## 示例
```
dfsrmig /getglobalstate
dfsrmig /setglobalstate 3
dfsrmig /getmigrationstate
```

## 注意事项
- 用于管理DFS复制的迁移过程
- 需要域管理员权限才能使用
- 迁移状态包括：0（开始）、1（准备）、2（重定向）、3（消除）