# script - 记录终端会话

## 1. 命令简介
script 命令用于记录终端会话，是 Linux 系统中常用的终端控制台命令之一。

## 2. 命令语法
```bash
script [选项] [文件]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -a | 追加模式 |
| -c | 执行命令并退出 |
| -f | 实时刷新 |
| -q | 静默模式 |
| --help | 显示帮助信息 |
| --version | 显示版本信息 |

## 4. 实战示例

### 4.1 记录终端会话
```bash
script session.log
```

### 4.2 追加模式
```bash
script -a session.log
```

### 4.3 执行命令并退出
```bash
script -c "ls -la" session.log
```

### 4.4 实时刷新
```bash
script -f session.log
```

## 5. 注意事项
- script 命令用于记录终端会话，包括所有输入和输出
- script 命令生成的文件可以用 cat 或 less 查看
- 要结束记录，按 Ctrl+D 或输入 exit
- script 命令是一个常用的终端工具，用于记录和分享终端操作