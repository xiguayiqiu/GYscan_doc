# bootcfg 命令

## 命令说明
启动配置

## 语法
```
bootcfg [/add | /copy | /delete | /default | /query | /raw | /redirect | /timeout]
```

## 功能
配置启动设置。

## 选项
- `/add`：添加启动项
- `/copy`：复制启动项
- `/delete`：删除启动项
- `/default`：设置默认启动项
- `/query`：查询启动配置
- `/raw`：设置原始启动参数
- `/redirect`：设置重定向
- `/timeout`：设置启动超时

## 示例
```
# 查询启动配置

bootcfg /query

# 添加启动项

bootcfg /add

# 设置默认启动项

bootcfg /default
```

## 注意事项
- 用于配置启动设置
- 可以添加、删除、复制和修改启动项
- 支持设置默认启动项和超时
- 需要管理员权限才能使用
- 适用于系统启动配置和多系统引导管理