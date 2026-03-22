# bcdedit 命令

## 命令说明
启动配置数据编辑

## 语法
```
bcdedit [/store <store>] [/create [<id>]] [/delete <id>] [/export <file>] [/import <file>] [/copy <id>] [/displayorder <id> [...]] [/default <id>] [/timeout <seconds>] [/bootsequence <id> [...]] [/set <id> <data>] [/enum [<type>]]
```

## 功能
编辑启动配置数据。

## 选项
- `/store <store>`：指定存储位置
- `/create [<id>]`：创建新项
- `/delete <id>`：删除项
- `/export <file>`：导出配置
- `/import <file>`：导入配置
- `/copy <id>`：复制项
- `/displayorder <id> [...]]`：设置显示顺序
- `/default <id>`：设置默认项
- `/timeout <seconds>`：设置超时
- `/bootsequence <id> [...]]`：设置启动序列
- `/set <id> <data>`：设置数据
- `/enum [<type>]`：枚举项

## 示例
```
# 枚举所有启动项

bcdedit /enum

# 设置默认启动项

bcdedit /default {current}

# 设置启动超时

bcdedit /timeout 30
```

## 注意事项
- 用于编辑启动配置数据
- 可以创建、删除、复制和修改启动项
- 支持设置默认启动项和超时
- 需要管理员权限才能使用
- 适用于系统启动配置和多系统引导管理