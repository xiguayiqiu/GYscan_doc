# rmdir - 删除目录

## 1. 命令简介
rmdir 命令用于删除空目录，是 Linux 系统中常用的命令之一。

## 2. 命令语法
```bash
rmdir [选项] 目录
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -p | 递归删除目录 |
| -v | 显示删除的目录 |

## 4. 实战示例

### 4.1 删除空目录
```bash
rmdir directory
```

### 4.2 递归删除目录
```bash
rmdir -p directory1/directory2/directory3
```

### 4.3 显示删除的目录
```bash
rmdir -v directory
```

### 4.4 删除多个目录
```bash
rmdir directory1 directory2 directory3
```

## 5. 注意事项
- rmdir 命令只能删除空目录，不能删除非空目录
- 使用 -p 选项可以递归删除目录，删除父目录时会先删除子目录
- 要删除非空目录，应该使用 rm -r 命令