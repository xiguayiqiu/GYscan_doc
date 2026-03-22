# net 命令

## 命令说明
网络命令

## 语法
```
net [options] [command]
```

## 功能
管理网络资源和服务。

## 选项
- `use`：连接到网络资源
- `share`：管理网络共享
- `start`：启动服务
- `stop`：停止服务
- `user`：管理用户账户
- `group`：管理用户组
- `view`：查看网络资源

## 示例
```
# 连接到网络共享

net use Z: \\server\share

# 管理网络共享

net share

# 启动服务

net start "Windows Firewall"

# 停止服务

net stop "Windows Firewall"
```

## 注意事项
- 用于管理网络资源和服务
- 可以连接到网络共享、管理用户账户和组
- 支持启动和停止服务
- 适用于网络管理和资源共享