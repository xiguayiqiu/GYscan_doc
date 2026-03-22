# setlocal 命令

## 命令说明
设置本地

## 语法
```
setlocal [enableextensions | disableextensions] [enabledelayedexpansion | disabledelayedexpansion]
```

## 功能
开始本地化环境更改。

## 选项
- `enableextensions`：启用命令扩展
- `disableextensions`：禁用命令扩展
- `enabledelayedexpansion`：启用延迟环境变量扩展
- `disabledelayedexpansion`：禁用延迟环境变量扩展

## 示例
```
# 启用命令扩展和延迟环境变量扩展

setlocal enableextensions enabledelayedexpansion

# 禁用命令扩展

setlocal disableextensions

# 禁用延迟环境变量扩展

setlocal disabledelayedexpansion
```

## 注意事项
- 用于开始本地化环境更改
- 可以启用或禁用命令扩展和延迟环境变量扩展
- 通常与 endlocal 命令配合使用
- 适用于批处理脚本的环境管理