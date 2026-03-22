# bash - Bourne Again Shell命令解释器

## 1. 命令简介
bash 命令是 Bourne Again Shell 命令解释器，是 Linux 系统中最常用的 shell 之一。

## 2. 命令语法
```bash
bash [选项] [脚本文件]
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
bash script.sh
```

### 4.2 执行指定的命令
```bash
bash -c "echo Hello World"
```

### 4.3 交互式模式
```bash
bash -i
```

### 4.4 登录模式
```bash
bash -l
```

### 4.5 从标准输入读取命令
```bash
echo "echo Hello World" | bash -s
```

### 4.6 显示执行的命令
```bash
bash -x script.sh
```

## 5. 注意事项
- bash 是 Linux 系统中最常用的 shell，大多数 Linux 发行版默认使用 bash
- bash 支持丰富的功能，如命令历史、命令补全、别名等
- bash 脚本是 Linux 系统中自动化任务的重要工具