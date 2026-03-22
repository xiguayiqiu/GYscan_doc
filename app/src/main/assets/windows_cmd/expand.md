# expand 命令

## 命令说明
展开文件

## 语法
```
expand [源文件] [目标文件]
expand [选项] [源文件] [目标目录]
```

## 功能
展开压缩文件，通常用于展开 Windows 安装文件。

## 选项
- `/r`：重命名展开的文件
- `/d`：显示压缩文件中的文件列表
- `/f:`：指定要展开的文件

## 示例
```
expand file.cab -f:* .
expand source.dll destination.dll
expand /d file.cab
```

## 注意事项
- 常用于展开 CAB 格式的压缩文件
- 可以从 Windows 安装媒体中提取文件
- 支持展开单个文件或多个文件