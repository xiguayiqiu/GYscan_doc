# pwsh 命令

## 命令说明
PowerShell Core

## 语法
```
pwsh [选项] [命令]
```

## 功能
启动PowerShell Core，执行PowerShell命令和脚本。

## 选项
- `-Command`：执行指定的PowerShell命令
- `-File`：执行指定的PowerShell脚本
- `-ExecutionPolicy`：设置执行策略
- `-NoProfile`：不加载用户配置文件

## 示例
```
pwsh
pwsh -Command "Get-Process"
pwsh -File script.ps1
```

## 注意事项
- PowerShell Core是跨平台的PowerShell版本
- 支持Windows、macOS和Linux
- 提供与Windows PowerShell相似的功能
- 是未来PowerShell的主要发展方向