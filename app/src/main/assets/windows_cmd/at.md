# at 命令

## 命令说明
计划任务

## 语法
```
at [时间] [/interactive] [/every:日期] [/next:日期] 命令
```

## 功能
在指定的时间和日期执行命令或程序。

## 选项
- `/interactive`：允许任务与登录用户的桌面交互
- `/every:日期`：在指定的日期（1-31）执行任务
- `/next:日期`：在下次指定的日期（如 Monday, Tuesday 等）执行任务

## 示例
```
at 14:30 notepad.exe
at 00:00 /every:1,15 diskpart.exe
at 18:00 /next:Friday shutdown -s
```

## 注意事项
- 此命令在 Windows 7 及以后版本中已被 `schtasks` 命令替代
- 需要管理员权限才能使用
- 任务会在后台执行