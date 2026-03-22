# rmdir - 删除空目录

## 1. 命令简介
rmdir 命令用于删除空目录，是 Linux 系统中最常用的目录操作命令之一。

## 2. 命令语法
```bash
rmdir [选项] 目录
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -p | 递归删除目录，包括父目录（如果为空） |
| -v | 详细模式，显示删除的目录 |

## 4. 实战示例

### 4.1 删除空目录
```bash
rmdir directory
```

### 4.2 递归删除目录
```bash
rmdir -p parent/child/grandchild
```

### 4.3 显示删除的目录
```bash
rmdir -v directory
```

### 4.4 递归删除目录并显示
```bash
rmdir -pv parent/child/grandchild
```

## 5. 注意事项
- rmdir 只能删除空目录，如果目录不为空，需要先删除目录中的文件
- 使用 -p 选项可以递归删除目录，包括父目录（如果为空）
- 与 rm 命令不同，rmdir 不会删除文件，只会删除空目录