# rundll32 命令

## 命令说明
运行DLL

## 语法
```
rundll32 [DLL文件] [函数名] [参数]
```

## 功能
运行DLL文件中的函数。

## 示例
```
rundll32 shell32.dll,Control_RunDLL
rundll32 user32.dll,LockWorkStation
rundll32 advapi32.dll,ProcessIdleTasks
```

## 注意事项
- 用于运行DLL文件中的函数
- 可以执行各种系统功能
- 需要指定正确的DLL文件和函数名
- 适用于执行系统级操作