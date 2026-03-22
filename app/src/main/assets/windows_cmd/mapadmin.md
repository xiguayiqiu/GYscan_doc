# mapadmin 命令

## 命令说明
映射管理

## 语法
```
mapadmin [选项]
```

## 功能
管理网络驱动器映射。

## 选项
- `/list`：列出所有映射
- `/add`：添加新映射
- `/delete`：删除映射
- `/update`：更新映射

## 示例
```
mapadmin /list
mapadmin /add Z: \\server\share
mapadmin /delete Z:
```

## 注意事项
- 用于管理网络驱动器映射
- 可以添加、删除和列出映射
- 需要适当的权限才能管理映射