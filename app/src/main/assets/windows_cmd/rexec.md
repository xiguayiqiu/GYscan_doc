# rexec 命令

## 命令说明
远程执行

## 语法
```
rexec [主机名] [命令]
```

## 功能
在远程计算机上执行命令。

## 示例
```
rexec server1 dir
rexec server2 ipconfig
```

## 注意事项
- 用于在远程计算机上执行命令
- 需要远程计算机运行rexec服务
- 安全性较低，建议使用SSH等更安全的替代方案
- 在现代Windows系统中可能需要启用相关服务