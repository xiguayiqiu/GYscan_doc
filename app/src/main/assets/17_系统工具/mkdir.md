# mkdir - 创建目录

## 1. 命令简介
mkdir 命令用于创建目录，是 Linux 系统中最常用的命令之一。

## 2. 命令语法
```bash
mkdir [选项] 目录
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -p | 递归创建目录 |
| -m | 设置目录权限 |
| -v | 显示创建的目录 |

## 4. 实战示例

### 4.1 创建单个目录
```bash
mkdir directory
```

### 4.2 递归创建目录
```bash
mkdir -p directory1/directory2/directory3
```

### 4.3 设置目录权限
```bash
mkdir -m 755 directory
```

### 4.4 显示创建的目录
```bash
mkdir -v directory
```

### 4.5 创建多个目录
```bash
mkdir directory1 directory2 directory3
```

## 5. 注意事项
- mkdir 命令默认只能创建单个目录，使用 -p 选项可以递归创建目录
- 使用 -m 选项可以设置目录的权限，默认权限是 755
- 目录名称不能包含空格或特殊字符，如有需要可以使用引号括起