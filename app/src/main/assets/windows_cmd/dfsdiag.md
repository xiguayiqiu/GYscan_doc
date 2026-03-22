# dfsdiag 命令

## 命令说明
DFS诊断

## 语法
```
dfsdiag [子命令] [参数]
```

## 功能
诊断分布式文件系统（DFS）的问题。

## 子命令
- `TestDCs`：测试域控制器连接
- `TestDFSConfig`：测试DFS配置
- `TestDFSRoots`：测试DFS根目录
- `TestSites`：测试站点连接

## 示例
```
dfsdiag TestDCs
dfsdiag TestDFSConfig
dfsdiag TestDFSRoots
```

## 注意事项
- 用于诊断DFS相关问题
- 需要管理员权限才能使用
- 可以帮助识别DFS配置错误和连接问题