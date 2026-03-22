# rcp 命令

## 命令说明
远程复制

## 语法
```
rcp [options] <source> <destination>
```

## 功能
在本地和远程系统之间复制文件。

## 选项
- `-p`：保留文件属性
- `-r`：递归复制目录
- `-v`：启用详细输出

## 示例
```
# 从本地复制文件到远程

rcp file.txt user@remote:/path/to/destination

# 从远程复制文件到本地

rcp user@remote:/path/to/file.txt .

# 递归复制目录

rcp -r directory user@remote:/path/to/destination
```

## 注意事项
- 用于在本地和远程系统之间复制文件
- 支持递归复制目录
- 可以保留文件属性
- 适用于网络文件传输和远程管理