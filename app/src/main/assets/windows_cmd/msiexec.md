# msiexec 命令

## 命令说明
Windows安装程序

## 语法
```
msiexec [选项] [包文件]
```

## 功能
安装、卸载、修复或配置Windows安装程序包。

## 选项
- `/i`：安装包
- `/x`：卸载包
- `/f`：修复包
- `/a`：管理安装
- `/j`：广告安装
- `/q`：静默安装

## 示例
```
msiexec /i package.msi
msiexec /x package.msi
msiexec /i package.msi /q
```

## 注意事项
- 用于管理Windows安装程序包（.msi文件）
- 可以执行安装、卸载、修复等操作
- 支持静默安装和自定义安装选项