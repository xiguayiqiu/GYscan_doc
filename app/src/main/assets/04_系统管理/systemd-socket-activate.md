# systemd-socket-activate - 套接字激活

## 1. 命令简介
systemd-socket-activate 命令用于套接字激活，是 Linux 系统中常用的系统管理命令之一。

## 2. 命令语法
```bash
systemd-socket-activate [选项] [命令]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| --socket | 指定套接字 |
| --inetd | 模拟inetd模式 |
| --epoll | 使用epoll |
| --help | 显示帮助信息 |

## 4. 实战示例

### 4.1 套接字激活
```bash
systemd-socket-activate --socket=8080 command
```

### 4.2 模拟inetd模式
```bash
systemd-socket-activate --inetd command
```

### 4.3 使用epoll
```bash
systemd-socket-activate --epoll command
```

## 5. 注意事项
- systemd-socket-activate 命令是 systemd 系统的一部分，用于套接字激活
- 套接字激活是一种按需启动服务的机制，当有连接请求时才启动服务
- 使用 --socket 选项可以指定要监听的套接字
- 使用 --inetd 选项可以模拟inetd模式，即每个连接创建一个新的进程