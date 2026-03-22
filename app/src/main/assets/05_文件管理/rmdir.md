# rmdir - 删除空目录

## 1. 命令简介
rmdir 命令用于删除空目录，是 Linux 系统中常用的文件管理命令之一。

## 2. 命令语法
```bash
rmdir [选项] [目录]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -p | 递归删除目录 |
| -v | 显示删除过程 |
| --help | 显示帮助信息 |
| --version | 显示版本信息 |

## 4. 实战示例

### 4.1 删除空目录
```bash
rmdir directory
```

### 4.2 递归删除目录
```bash
rmdir -p directory/subdirectory
```

### 4.3 显示删除过程
```bash
rmdir -v directory
```

## 5. 注意事项
- rmdir 命令用于删除空目录，不能删除非空目录
- rmdir 命令的 -p 选项可以递归删除目录，前提是所有目录都是空的
- rmdir 命令是一个常用的文件管理工具，用于删除空目录