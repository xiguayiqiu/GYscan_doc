# powershell 命令

## 命令说明
PowerShell

## 语法
```
powershell [选项] [命令]
```

## 功能
启动Windows PowerShell，执行PowerShell命令和脚本。

## 选项
- `-Command`：执行指定的PowerShell命令
- `-File`：执行指定的PowerShell脚本
- `-ExecutionPolicy`：设置执行策略
- `-NoProfile`：不加载用户配置文件

## 示例
```
powershell
powershell -Command "Get-Process"
powershell -File script.ps1
```

## 注意事项
- PowerShell是Windows的强大命令行shell和脚本语言
- 支持复杂的命令和脚本编写
- 可以访问和管理Windows系统的各种资源
- 提供比传统命令提示符更强大的功能