# fsutil 命令

## 命令说明
文件系统工具

## 语法
```
fsutil [子命令] [选项]
```

## 功能
管理文件系统。

## 子命令
- `file`：管理文件
- `fsinfo`：文件系统信息
- `hardlink`：管理硬链接
- `objectid`：管理对象ID
- `quota`：管理配额
- `repair`：修复文件系统
- `sparse`：管理稀疏文件
- `usn`：管理USN日志

## 示例
```
fsutil fsinfo volumeinfo C:
fsutil file createnew C:\test.txt 1024
fsutil quota query C:
```

## 注意事项
- 用于管理文件系统
- 功能丰富，包括文件管理、配额管理等
- 需要管理员权限才能使用
- 适用于文件系统管理和故障排除