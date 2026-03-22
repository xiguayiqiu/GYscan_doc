# repadmin 命令

## 命令说明
复制管理

## 语法
```
repadmin [选项]
```

## 功能
管理Active Directory复制。

## 选项
- `/showrepl`：显示复制状态
- `/syncall`：同步所有复制
- `/replicate`：复制特定分区
- `/bridgeheads`：显示桥头服务器

## 示例
```
repadmin /showrepl
repadmin /syncall
repadmin /replicate DC1 DC2 DC=domain,DC=com
```

## 注意事项
- 用于管理Active Directory复制
- 可以显示复制状态、同步复制等
- 需要域管理员权限才能使用
- 适用于域环境中的Active Directory管理