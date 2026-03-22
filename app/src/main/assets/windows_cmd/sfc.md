# sfc 命令

## 命令说明
系统文件检查器

## 语法
```
sfc [选项]
```

## 功能
检查和修复系统文件。

## 选项
- `/scannow`：立即扫描并修复系统文件
- `/verifyonly`：只扫描不修复
- `/scannonce`：扫描一次
- `/scanboot`：每次启动时扫描

## 示例
```
sfc /scannow
sfc /verifyonly
sfc /scannonce
```

## 注意事项
- 用于检查和修复系统文件
- 可以检测并替换损坏的系统文件
- 需要管理员权限才能使用
- 适用于系统维护和故障排除