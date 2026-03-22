# eventquery 命令

## 命令说明
查询事件

## 语法
```
eventquery [选项]
```

## 功能
查询事件日志中的事件。

## 选项
- `/s`：指定远程计算机
- `/u`：指定用户名
- `/p`：指定密码
- `/l`：指定事件日志（APPLICATION、SYSTEM、SECURITY）
- `/fi`：指定过滤条件
- `/fo`：指定输出格式（TABLE、LIST、CSV）

## 示例
```
eventquery /l APPLICATION
eventquery /l SYSTEM /fi "Type eq ERROR"
eventquery /s remotecomputer /l SECURITY
```

## 注意事项
- 用于查询事件日志中的事件
- 可以根据事件类型、日期、源等条件进行过滤
- 在 Windows Vista 及以后版本中已被 `wevtutil` 命令替代