# shutdown - 关闭系统

## 1. 命令简介
shutdown 命令用于关闭系统，是 Linux 系统中常用的系统管理命令之一。

## 2. 命令语法
```bash
shutdown [选项] [时间] [消息]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -h | 关闭系统 |
| -r | 重启系统 |
| -c | 取消关闭 |
| -k | 发送警告消息 |
| --help | 显示帮助信息 |
| --version | 显示版本信息 |

## 4. 实战示例

### 4.1 立即关闭系统
```bash
shutdown -h now
```

### 4.2 定时关闭系统
```bash
shutdown -h +10
```

### 4.3 重启系统
```bash
shutdown -r now
```

### 4.4 取消关闭
```bash
shutdown -c
```

## 5. 注意事项
- shutdown 命令用于关闭或重启系统
- shutdown 命令需要 root 权限
- shutdown 命令是一个常用的系统管理工具，用于系统关闭和重启