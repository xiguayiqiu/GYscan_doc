# pnpunattend 命令

## 命令说明
即插即用无人值守

## 语法
```
pnpunattend [选项]
```

## 功能
配置即插即用设备的无人值守安装。

## 选项
- `/audit`：审核模式
- `/offline`：离线模式
- `/s`：指定设备路径

## 示例
```
pnpunattend /audit
pnpunattend /offline /s C:\Devices
```

## 注意事项
- 用于配置即插即用设备的无人值守安装
- 可以在审核模式或离线模式下使用
- 适用于系统部署和自动化安装场景