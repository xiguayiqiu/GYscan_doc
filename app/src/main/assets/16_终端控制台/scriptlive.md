# scriptlive - 实时记录终端会话

## 1. 命令简介
scriptlive 命令用于实时记录终端会话，是 Linux 系统中常用的终端控制台命令之一。

## 2. 命令语法
```bash
scriptlive [选项] [文件]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -t | 时间延迟 |
| -d | 显示持续时间 |
| --help | 显示帮助信息 |
| --version | 显示版本信息 |

## 4. 实战示例

### 4.1 实时记录终端会话
```bash
scriptlive session.log
```

### 4.2 设置时间延迟
```bash
scriptlive -t 1 session.log
```

### 4.3 显示持续时间
```bash
scriptlive -d session.log
```

## 5. 注意事项
- scriptlive 命令用于实时记录终端会话，包括所有输入和输出
- scriptlive 命令可以设置时间延迟，使回放更加自然
- scriptlive 命令是一个常用的终端工具，用于记录和分享终端操作