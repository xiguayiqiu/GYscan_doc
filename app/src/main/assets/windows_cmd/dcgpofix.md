# dcgpofix 命令

## 命令说明
域控制器组策略修复

## 语法
```
dcgpofix [选项]
```

## 功能
修复域控制器的组策略对象（GPO）。

## 选项
- `/target:Domain`：修复域级别策略
- `/target:DC`：修复域控制器级别策略
- `/target:Both`：修复两者

## 示例
```
dcgpofix /target:Both
dcgpofix /target:Domain
dcgpofix /target:DC
```

## 注意事项
- 用于修复损坏的组策略对象
- 需要域管理员权限才能使用
- 会将组策略重置为默认值