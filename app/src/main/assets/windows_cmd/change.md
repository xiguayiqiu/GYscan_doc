# change 命令

## 命令说明
更改

## 语法
```
change [logon | port | user]
```

## 功能
更改终端服务器设置。

## 选项
- `logon`：更改登录设置
- `port`：更改端口设置
- `user`：更改用户设置

## 示例
```
# 更改登录设置

change logon /disable

# 更改端口设置

change port /disable

# 更改用户设置

change user /install
```

## 注意事项
- 用于更改终端服务器设置
- 可以更改登录、端口和用户设置
- 适用于终端服务器管理
- 需要管理员权限才能使用