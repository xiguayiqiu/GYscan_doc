# bcdboot 命令

## 命令说明
启动配置数据引导

## 语法
```
bcdboot <source> [/l <locale>] [/s <volume>] [/v] [/m [{OS Loader ID}]]
```

## 功能
为系统创建或修复启动配置数据。

## 选项
- `<source>`：Windows 系统根目录的路径
- `/l <locale>`：指定区域设置
- `/s <volume>`：指定系统分区
- `/v`：启用详细输出
- `/m [{OS Loader ID}]`：合并启动菜单

## 示例
```
bcdboot C:\Windows

# 指定系统分区

bcdboot C:\Windows /s E:

# 启用详细输出

bcdboot C:\Windows /v
```

## 注意事项
- 用于创建或修复启动配置数据
- 可以指定系统分区和区域设置
- 支持合并启动菜单
- 需要管理员权限才能使用
- 适用于系统启动修复和多系统引导配置