# sc 命令

## 命令说明
服务控制

## 语法
```
sc [命令] [服务名] [选项]
```

## 功能
管理系统服务。

## 命令
- `query`：查询服务状态
- `start`：启动服务
- `stop`：停止服务
- `pause`：暂停服务
- `continue`：继续服务
- `config`：配置服务
- `create`：创建服务
- `delete`：删除服务

## 示例
```
sc query
sc start wuauserv
sc stop wuauserv
sc config wuauserv start= auto
```

## 注意事项
- 用于管理系统服务
- 可以启动、停止、暂停、继续和配置服务
- 需要管理员权限才能使用
- 适用于系统管理员管理服务