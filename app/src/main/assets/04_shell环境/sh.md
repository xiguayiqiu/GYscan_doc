# sh - POSIX兼容的Shell

## 1. 命令简介
sh 命令是 POSIX 兼容的 Shell，是 Linux 系统中常用的 shell 环境命令之一。

## 2. 命令语法
```bash
sh [选项] [脚本]
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
sh
```

### 4.2 执行命令
```bash
sh -c "echo Hello, World!"
```

### 4.3 执行脚本
```bash
sh script.sh
```

### 4.4 登录shell
```bash
sh -l
```

## 5. 注意事项
- sh 命令是 POSIX 兼容的 Shell，是一个轻量级的 shell
- sh 命令通常是 bash 或其他 shell 的符号链接
- sh 命令是一个常用的 shell 工具，用于执行命令和脚本