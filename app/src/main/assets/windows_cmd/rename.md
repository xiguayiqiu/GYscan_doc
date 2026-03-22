# rename 命令

## 命令说明
重命名文件

## 语法
```
rename [旧文件名] [新文件名]
```

## 功能
重命名文件或目录，与 `ren` 命令功能相同。

## 示例
```
rename oldfile.txt newfile.txt
rename *.txt *.bak
```

## 注意事项
- 可以使用通配符（如 `*.txt`）来重命名多个文件
- 可以使用相对路径或绝对路径
- 是 `ren` 命令的别名