# find - 搜索文件

## 1. 命令简介
find 命令用于搜索文件，是 Linux 系统中常用的搜索过滤命令之一。

## 2. 命令语法
```bash
find [路径] [选项] [表达式]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -name | 按文件名搜索 |
| -type | 按文件类型搜索 |
| -size | 按文件大小搜索 |
| -mtime | 按修改时间搜索 |
| -user | 按用户搜索 |
| -group | 按组搜索 |
| -perm | 按权限搜索 |
| -exec | 执行命令 |
| --help | 显示帮助信息 |
| --version | 显示版本信息 |

## 4. 实战示例

### 4.1 按文件名搜索
```bash
find /path -name "*.txt"
```

### 4.2 按文件类型搜索
```bash
find /path -type f
```

### 4.3 按文件大小搜索
```bash
find /path -size +1M
```

### 4.4 执行命令
```bash
find /path -name "*.txt" -exec ls -l {} \;
```

## 5. 注意事项
- find 命令用于搜索文件，支持多种搜索条件
- find 命令是一个常用的文件搜索工具，用于查找文件系统中的文件