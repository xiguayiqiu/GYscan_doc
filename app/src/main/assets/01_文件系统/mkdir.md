# mkdir - 创建目录

## 1. 命令简介
mkdir 命令用于创建目录，是 Linux 系统中最常用的目录操作命令之一。

## 2. 命令语法
```bash
mkdir [选项] 目录
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -p | 递归创建目录，包括父目录 |
| -m | 指定目录权限 |
| -v | 详细模式，显示创建的目录 |

## 4. 实战示例

### 4.1 创建目录
```bash
mkdir directory
```

### 4.2 递归创建目录
```bash
mkdir -p parent/child/grandchild
```

### 4.3 指定目录权限
```bash
mkdir -m 755 directory
```

### 4.4 显示创建的目录
```bash
mkdir -v directory
```

### 4.5 递归创建目录并显示
```bash
mkdir -pv parent/child/grandchild
```

## 5. 注意事项
- 默认情况下，mkdir 只能创建一级目录，需要使用 -p 选项来创建多级目录
- 使用 -m 选项可以指定目录的权限，默认权限是 755
- 目录名称不能包含特殊字符，如空格、/ 等