# fondue 命令

## 命令说明
功能启用

## 语法
```
fondue [选项]
```

## 功能
启用 Windows 功能。

## 选项
- `/enable-feature`：启用指定功能
- `/enable-feature-with-package`：启用指定包中的功能
- `/caller-name`：指定调用方名称

## 示例
```
fondue /enable-feature /featurename:NetFx3
fondue /enable-feature-with-package /packagename:Microsoft-Windows-NetFx3-OC-Package
```

## 注意事项
- 用于启用 Windows 功能
- 需要管理员权限才能使用
- 可以通过命令行启用各种 Windows 功能