# eventtriggers 命令

## 命令说明
事件触发器

## 语法
```
eventtriggers [选项]
```

## 功能
管理事件触发器，用于响应系统事件。

## 选项
- `/create`：创建新的事件触发器
- `/delete`：删除事件触发器
- `/query`：查询事件触发器
- `/enable`：启用事件触发器
- `/disable`：禁用事件触发器

## 示例
```
eventtriggers /create /tr "Backup" /tk "C:\backup.bat" /l SYSTEM /eid 6005
eventtriggers /query
eventtriggers /delete /tid 1
```

## 注意事项
- 用于创建和管理事件触发器
- 可以根据系统事件自动执行命令或脚本
- 在 Windows Vista 及以后版本中已被任务计划程序替代