# trap - 捕获信号

## 1. 命令简介
trap 命令用于捕获信号并执行指定的命令，是 Linux 系统中常用的其他命令之一。

## 2. 命令语法
```bash
trap [选项] [命令] [信号]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -l | 显示信号列表 |

## 4. 常用信号
| 信号 | 编号 | 说明 |
|------|------|------|
| SIGINT | 2 | 中断信号（Ctrl+C） |
| SIGTERM | 15 | 终止信号 |
| SIGKILL | 9 | 强制终止信号 |
| SIGTSTP | 20 | 暂停信号（Ctrl+Z） |

## 5. 实战示例

### 5.1 捕获中断信号
```bash
trap "echo 'Ctrl+C pressed'" SIGINT
```

### 5.2 捕获多个信号
```bash
trap "echo 'Signal received'" SIGINT SIGTERM
```

### 5.3 显示信号列表
```bash
trap -l
```

## 6. 注意事项
- trap 命令用于捕获信号并执行指定的命令
- trap 命令通常在脚本中使用，用于处理信号
- SIGKILL 信号不能被捕获
- trap 命令是一个Shell内置命令，用于信号处理