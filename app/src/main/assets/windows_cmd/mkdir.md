# mkdir 命令

## 命令说明
创建目录

## 语法
```
mkdir [目录路径]
mkdir [选项] [目录路径]
```

## 功能
创建一个或多个目录。

## 选项
- `/p`：创建父目录（如果不存在）

## 示例
```
mkdir newfolder
mkdir C:\Users\User\Documents\Projects
mkdir /p parent\child\grandchild
```

## 注意事项
- 可以使用相对路径或绝对路径
- 使用 `/p` 选项可以创建多级目录结构
- 是 `md` 命令的别名