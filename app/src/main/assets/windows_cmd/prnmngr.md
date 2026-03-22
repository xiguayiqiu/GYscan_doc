# prnmngr 命令

## 命令说明
打印机管理器

## 语法
```
prnmngr [选项]
```

## 功能
管理打印机。

## 选项
- `-l`：列出所有打印机
- `-a`：添加打印机
- `-d`：删除打印机
- `-x`：删除所有打印机
- `-t`：设置默认打印机

## 示例
```
prnmngr -l
prnmngr -a -p "HP LaserJet" -m "HP LaserJet" -r "LPT1"
prnmngr -d -p "HP LaserJet"
```

## 注意事项
- 用于管理打印机
- 可以添加、删除和列出打印机
- 需要管理员权限才能使用
- 适用于系统管理员管理打印机