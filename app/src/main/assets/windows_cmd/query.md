# query 命令

## 命令说明
查询

## 语法
```
query [子命令]
```

## 功能
查询系统信息，如用户、会话、进程等。

## 子命令
- `user`：查询用户
- `session`：查询会话
- `process`：查询进程
- `termserver`：查询终端服务器

## 示例
```
query user
query session
query process
```

## 注意事项
- 用于查询系统信息
- 可以查询用户登录状态、会话信息、进程信息等
- 适用于终端服务环境
- 需要适当的权限才能查询某些信息