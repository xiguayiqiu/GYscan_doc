# goto 命令

## 命令说明
跳转到标签

## 语法
```
goto 标签
```

## 功能
在批处理文件中跳转到指定的标签。

## 示例
```
:start
echo 开始
if %ERRORLEVEL% neq 0 goto error
echo 成功
goto end
:error
echo 错误
:end
echo 结束
```

## 注意事项
- 用于批处理文件中的流程控制
- 标签以冒号（:）开头
- 可以实现条件跳转和循环结构