# cprofile 命令

## 命令说明
配置文件管理

## 语法
```
cprofile [选项]
```

## 功能
管理用户配置文件。

## 选项
- `/create`：创建新的用户配置文件
- `/delete`：删除用户配置文件
- `/copy`：复制用户配置文件
- `/rename`：重命名用户配置文件

## 示例
```
cprofile /create user1
cprofile /delete user2
cprofile /copy user1 user3
```

## 注意事项
- 用于管理用户配置文件
- 需要管理员权限才能使用
- 可以在用户登录前管理配置文件