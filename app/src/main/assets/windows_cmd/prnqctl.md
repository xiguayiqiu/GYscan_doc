# prnqctl 命令

## 命令说明
打印队列控制

## 语法
```
prnqctl [选项]
```

## 功能
控制打印队列。

## 选项
- `-l`：列出打印队列
- `-p`：暂停打印队列
- `-r`：恢复打印队列
- `-x`：取消所有打印作业

## 示例
```
prnqctl -l -p "HP LaserJet"
prnqctl -p -p "HP LaserJet"
prnqctl -r -p "HP LaserJet"
```

## 注意事项
- 用于控制打印队列
- 可以暂停、恢复和取消打印队列
- 需要适当的权限才能控制打印队列
- 适用于系统管理员管理打印队列