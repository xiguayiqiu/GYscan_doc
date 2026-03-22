# driverquery 命令

## 命令说明
驱动程序查询

## 语法
```
driverquery [选项]
```

## 功能
显示系统中已安装的设备驱动程序列表。

## 选项
- `/s`：指定远程计算机
- `/u`：指定用户名
- `/p`：指定密码
- `/fo`：指定输出格式（TABLE、LIST、CSV）
- `/v`：显示详细信息

## 示例
```
driverquery
driverquery /fo CSV /v > drivers.csv
driverquery /s remotecomputer
```

## 注意事项
- 显示设备驱动程序的名称、类型、状态等信息
- 可以导出驱动程序列表到文件
- 可以查询远程计算机的驱动程序