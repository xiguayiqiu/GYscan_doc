# attributes 命令

## 命令说明
查看或修改属性

## 语法
```
attributes [disk|partition|volume] [set|clear] [属性]
```

## 功能
查看或修改磁盘、分区或卷的属性。

## 示例
```
attributes disk
attributes volume set readonly
attributes partition clear hidden
```

## 注意事项
- 此命令只能在 diskpart 命令行中使用
- 具体语法和功能取决于操作的对象类型
- 可以设置或清除的属性包括只读、隐藏、系统等