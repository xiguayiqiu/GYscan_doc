# eventcreate 命令

## 命令说明
创建事件

## 语法
```
eventcreate [选项]
```

## 功能
在事件日志中创建自定义事件。

## 选项
- `/t`：指定事件类型（ERROR、WARNING、INFORMATION、SUCCESS、AUDIT_SUCCESS、AUDIT_FAILURE）
- `/id`：指定事件ID
- `/l`：指定事件日志（APPLICATION、SYSTEM、SECURITY）
- `/so`：指定事件源
- `/d`：指定事件描述

## 示例
```
eventcreate /t INFORMATION /id 1000 /l APPLICATION /so MyApp /d "Application started"
eventcreate /t ERROR /id 999 /l SYSTEM /so MyService /d "Service failed to start"
```

## 注意事项
- 用于在事件日志中创建自定义事件
- 需要管理员权限才能使用
- 可以用于脚本和批处理文件中记录事件