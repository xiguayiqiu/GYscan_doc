# bitsadmin 命令

## 命令说明
后台智能传输服务管理

## 语法
```
bitsadmin [子命令] [参数]
```

## 功能
管理后台智能传输服务（BITS），用于在后台传输文件。

## 子命令
- `create`：创建新的传输作业
- `addfile`：向作业添加文件
- `resume`：恢复暂停的作业
- `cancel`：取消作业
- `complete`：完成作业
- `list`：列出所有作业

## 示例
```
bitsadmin /create download
 bitsadmin /addfile download "http://example.com/file.zip" "C:\Downloads\file.zip"
 bitsadmin /resume download
```

## 注意事项
- BITS 服务用于在后台异步传输文件
- 支持断点续传
- 可以在网络空闲时自动传输文件