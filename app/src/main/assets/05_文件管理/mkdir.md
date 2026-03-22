# mkdir - 创建目录

## 1. 命令简介
mkdir 命令用于创建目录，是 Linux 系统中常用的文件管理命令之一。

## 2. 命令语法
```bash
mkdir [选项] [目录]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -p | 递归创建目录 |
| -m | 设置目录权限 |
| -v | 显示创建过程 |
| --help | 显示帮助信息 |
| --version | 显示版本信息 |

## 4. 实战示例

### 4.1 创建目录
```bash
mkdir directory
```

### 4.2 递归创建目录
```bash
mkdir -p directory/subdirectory
```

### 4.3 设置目录权限
```bash
mkdir -m 755 directory
```

### 4.4 显示创建过程
```bash
mkdir -v directory
```

## 5. 注意事项
- mkdir 命令用于创建目录
- mkdir 命令需要指定目录名
- mkdir 命令是一个常用的文件管理工具，用于创建目录结构