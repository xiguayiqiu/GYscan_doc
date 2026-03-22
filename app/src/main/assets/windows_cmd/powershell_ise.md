# powershell ise 命令

## 命令说明
PowerShell ISE

## 语法
```
powershell_ise [选项]
```

## 功能
启动Windows PowerShell集成脚本环境（ISE），提供图形化的PowerShell脚本编辑和执行环境。

## 选项
- `-File`：打开指定的PowerShell脚本文件
- `-NoProfile`：不加载用户配置文件

## 示例
```
powershell_ise
powershell_ise script.ps1
```

## 注意事项
- PowerShell ISE提供了图形化的脚本编辑环境
- 支持语法高亮、代码折叠、调试等功能
- 适合编写和测试复杂的PowerShell脚本
- 在Windows 10 1903及以后版本中已被Windows Terminal替代