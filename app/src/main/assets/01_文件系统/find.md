# find - 查找文件

## 1. 命令简介
find 命令用于在指定目录中查找文件，是 Linux 系统中最常用的文件查找命令之一。

## 2. 命令语法
```bash
find [目录] [选项] [表达式]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -name | 按文件名查找 |
| -type | 按文件类型查找 |
| -size | 按文件大小查找 |
| -mtime | 按修改时间查找 |
| -atime | 按访问时间查找 |
| -ctime | 按创建时间查找 |
| -user | 按所有者查找 |
| -group | 按所属组查找 |
| -perm | 按权限查找 |
| -exec | 对找到的文件执行命令 |
| -delete | 删除找到的文件 |

## 4. 常用文件类型
| 类型 | 说明 |
|------|------|
| f | 普通文件 |
| d | 目录 |
| l | 符号链接 |
| b | 块设备 |
| c | 字符设备 |
| p | 管道 |
| s | 套接字 |

## 5. 实战示例

### 5.1 按文件名查找
```bash
find /home -name "*.txt"
```

### 5.2 按文件类型查找
```bash
find /home -type f
find /home -type d
```

### 5.3 按文件大小查找
```bash
find /home -size +10M  # 大于10MB的文件
find /home -size -100k  # 小于100KB的文件
find /home -size 100k   # 等于100KB的文件
```

### 5.4 按修改时间查找
```bash
find /home -mtime -7  # 7天内修改的文件
find /home -mtime +30  # 30天前修改的文件
```

### 5.5 按所有者查找
```bash
find /home -user user
```

### 5.6 对找到的文件执行命令
```bash
find /home -name "*.txt" -exec ls -l {} \;
find /home -name "*.txt" -exec rm {} \;
```

## 6. 注意事项
- find 命令默认在当前目录中查找文件
- 使用 -name 选项时，可以使用通配符，如 * 匹配任意字符，? 匹配单个字符
- 使用 -exec 选项时，{} 表示找到的文件，\; 表示命令结束
- find 命令可以组合多个条件，使用 -a（与）、-o（或）、!（非）逻辑操作符