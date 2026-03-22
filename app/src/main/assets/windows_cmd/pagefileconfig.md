# pagefileconfig 命令

## 命令说明
页面文件配置

## 语法
```
pagefileconfig [选项]
```

## 功能
配置虚拟内存页面文件。

## 选项
- `/list`：列出当前页面文件配置
- `/set`：设置页面文件大小
- `/delete`：删除页面文件

## 示例
```
pagefileconfig /list
pagefileconfig /set C:\pagefile.sys 1024 2048
pagefileconfig /delete D:\pagefile.sys
```

## 注意事项
- 用于配置虚拟内存页面文件
- 可以设置页面文件的大小和位置
- 需要管理员权限才能使用
- 页面文件大小通常建议为物理内存的1.5-2倍