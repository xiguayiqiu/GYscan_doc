# bash - Bourne Again Shell命令解释器

## 1. 命令简介
bash 命令是 Bourne Again Shell 命令解释器，是 Linux 系统中常用的 shell 环境命令之一。

## 2. 命令语法
```bash
bash [选项] [脚本]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -c | 执行命令 |
| -i | 交互式shell |
| -l | 登录shell |
| -s | 从标准输入读取命令 |
| --help | 显示帮助信息 |
| --version | 显示版本信息 |

## 4. 实战示例

### 4.1 启动交互式shell
```bash
bash
```

### 4.2 执行命令
```bash
bash -c "echo Hello, World!"
```

### 4.3 执行脚本
```bash
bash script.sh
```

### 4.4 登录shell
```bash
bash -l
```

## 5. 注意事项
- bash 命令是 Bourne Again Shell 命令解释器，是大多数 Linux 系统的默认 shell
- bash 命令支持丰富的功能，如命令历史、别名、管道等
- bash 命令是一个常用的 shell 工具，用于执行命令和脚本