# rsh 命令

## 命令说明
远程shell

## 语法
```
rsh [主机名] [命令]
```

## 功能
在远程计算机上执行shell命令。

## 示例
```
rsh server1 dir
rsh server2 ipconfig
```

## 注意事项
- 用于在远程计算机上执行shell命令
- 需要远程计算机运行rsh服务
- 安全性较低，建议使用SSH等更安全的替代方案
- 在现代Windows系统中可能需要启用相关服务