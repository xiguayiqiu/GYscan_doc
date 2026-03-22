# extract 命令

## 命令说明
提取文件

## 语法
```
extract [源文件] [目标文件]
extract [选项] [源文件] [目标目录]
```

## 功能
从压缩文件中提取文件，与 `expand` 命令类似。

## 选项
- `/y`：覆盖现有文件而不提示
- `/a`：处理所有后续的压缩文件
- `/d`：显示压缩文件中的文件列表
- `/e`：提取所有文件

## 示例
```
extract file.cab
extract file.cab destination
extract /d file.cab
```

## 注意事项
- 常用于从 CAB 格式的压缩文件中提取文件
- 是 `expand` 命令的替代命令
- 支持从多个压缩文件中提取文件