# refsutil 命令

## 命令说明
ReFS实用工具

## 语法
```
refsutil [options] [command]
```

## 功能
管理弹性文件系统（ReFS）。

## 选项
- `repair`：修复 ReFS 卷
- `salvage`：从损坏的 ReFS 卷中恢复数据
- `info`：显示 ReFS 卷信息
- `check`：检查 ReFS 卷

## 示例
```
# 检查 ReFS 卷

refsutil check D:

# 修复 ReFS 卷

refsutil repair D:

# 显示 ReFS 卷信息

refsutil info D:
```

## 注意事项
- 用于管理弹性文件系统（ReFS）
- 可以检查、修复 ReFS 卷和恢复数据
- 适用于 ReFS 文件系统的维护和故障排除
- 需要管理员权限才能使用