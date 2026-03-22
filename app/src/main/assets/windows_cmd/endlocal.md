# endlocal 命令

## 命令说明
结束本地化

## 语法
```
endlocal
```

## 功能
结束本地化环境，恢复之前的环境变量设置。

## 示例
```
setlocal
g set PATH=%PATH%;C:\Tools
endlocal
```

## 注意事项
- 与 `setlocal` 命令配合使用
- 用于在批处理文件中创建局部环境变量
- 执行后，环境变量会恢复到 `setlocal` 之前的状态