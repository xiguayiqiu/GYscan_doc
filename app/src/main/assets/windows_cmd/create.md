# create 命令

## 命令说明
创建项目

## 语法
```
create <object> [parameters]
```

## 功能
创建指定的对象。

## 选项
- `<object>`：要创建的对象，如 partition、volume 等
- `[parameters]`：创建对象的参数

## 示例
```
# 创建主分区

create partition primary

# 创建扩展分区

create partition extended

# 创建逻辑分区

create partition logical
```

## 注意事项
- 用于创建各种对象
- 支持创建分区、卷等
- 通常与 diskpart 命令配合使用
- 适用于磁盘管理和分区操作