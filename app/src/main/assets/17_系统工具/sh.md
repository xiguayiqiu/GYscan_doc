# sh - POSIX兼容的Shell

## 1. 命令简介
sh 命令是 POSIX 兼容的 Shell，是 Linux 系统中最基本的 shell 之一。

## 2. 命令语法
```bash
sh [选项] [脚本文件]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -c | 执行指定的命令 |
| -i | 交互式模式 |
| -l | 登录模式 |
| -s | 从标准输入读取命令 |
| -r | 受限模式 |
| -v | 显示输入的命令 |
| -x | 显示执行的命令 |

## 4. 实战示例

### 4.1 执行脚本文件
```bash
sh script.sh
```

### 4.2 执行指定的命令
```bash
sh -c "echo Hello World"
```

### 4.3 交互式模式
```bash
sh -i
```

### 4.4 登录模式
```bash
sh -l
```

### 4.5 从标准输入读取命令
```bash
echo "echo Hello World" | sh -s
```

### 4.6 显示执行的命令
```bash
sh -x script.sh
```

## 5. 注意事项
- sh 是 POSIX 兼容的 Shell，是 Linux 系统中最基本的 shell 之一
- 在大多数 Linux 系统中，sh 通常是 bash 的符号链接
- sh 脚本比 bash 脚本更具可移植性，因为它只使用 POSIX 标准定义的功能