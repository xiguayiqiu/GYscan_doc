# killall - 按名称终止进程

## 1. 命令简介
killall 命令用于按名称终止进程，是 Linux 系统中常用的其他命令之一。

## 2. 命令语法
```bash
killall [选项] [进程名称]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -e | 精确匹配进程名称 |
| -i | 交互式操作 |
| -l | 显示信号列表 |
| -q | 静默模式 |
| -r | 使用正则表达式匹配进程名称 |
| -s | 指定信号 |
| -u | 只终止指定用户的进程 |
| -v | 显示详细信息 |

## 4. 实战示例

### 4.1 终止指定名称的进程
```bash
killall process_name
```

### 4.2 交互式操作
```bash
killall -i process_name
```

### 4.3 指定信号
```bash
killall -s SIGTERM process_name
```

### 4.4 只终止指定用户的进程
```bash
killall -u user process_name
```

## 5. 注意事项
- killall 命令用于按名称终止进程
- killall 命令会终止所有匹配名称的进程
- 使用 -i 选项可以交互式地确认终止操作
- killall 命令是一个常用的系统工具，用于终止进程