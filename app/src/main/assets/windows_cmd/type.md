# type 命令

## 命令说明
显示文件内容

## 语法
```
type [文件]
```

## 功能
显示指定文件的内容。

## 示例
```
type file.txt
type C:\Windows\system32\drivers\etc\hosts
```

## 注意事项
- 可以使用相对路径或绝对路径
- 可以与重定向操作符一起使用，例如 `type file1.txt >> file2.txt`
- 对于二进制文件，会显示乱码