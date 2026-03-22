# append 命令

## 命令说明
追加文本到文件

## 语法
```
append [源文件] [目标文件]
```

## 功能
将一个文件的内容追加到另一个文件的末尾。

## 示例
```
append file1.txt file2.txt
```

## 注意事项
- 此命令在现代 Windows 系统中已被其他方法替代
- 可以使用 `type` 命令和重定向操作符 `>>` 实现类似功能
- 例如：`type file1.txt >> file2.txt`