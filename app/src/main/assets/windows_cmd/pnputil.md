# pnputil 命令

## 命令说明
即插即用工具

## 语法
```
pnputil [选项]
```

## 功能
管理即插即用设备和驱动程序。

## 选项
- `/enum-devices`：枚举设备
- `/enum-drivers`：枚举驱动程序
- `/add-driver`：添加驱动程序
- `/delete-driver`：删除驱动程序
- `/export-driver`：导出驱动程序

## 示例
```
pnputil /enum-devices
pnputil /enum-drivers
pnputil /add-driver driver.inf
```

## 注意事项
- 用于管理即插即用设备和驱动程序
- 可以添加、删除、导出驱动程序
- 需要管理员权限才能使用
- 适用于系统管理员和技术支持人员