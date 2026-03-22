# loginctl - 控制登录会话

## 1. 命令简介
loginctl 命令用于控制登录会话，是 Linux 系统中常用的系统管理命令之一。

## 2. 命令语法
```bash
loginctl [选项] [命令]
```

## 3. 常用命令
| 命令 | 说明 |
|------|------|
| list-sessions | 显示所有会话 |
| session-status | 显示会话状态 |
| list-users | 显示所有用户 |
| user-status | 显示用户状态 |
| list-seats | 显示所有座位 |
| seat-status | 显示座位状态 |
| terminate-session | 终止会话 |
| terminate-user | 终止用户的所有会话 |
| unlock-session | 解锁会话 |
| lock-session | 锁定会话 |

## 4. 实战示例

### 4.1 显示所有会话
```bash
loginctl list-sessions
```

### 4.2 显示会话状态
```bash
loginctl session-status
```

### 4.3 显示所有用户
```bash
loginctl list-users
```

### 4.4 显示用户状态
```bash
loginctl user-status
```

### 4.5 终止会话
```bash
sudo loginctl terminate-session SESSION_ID
```

### 4.6 终止用户的所有会话
```bash
sudo loginctl terminate-user USERNAME
```

## 5. 注意事项
- loginctl 命令需要 root 权限才能执行某些操作
- loginctl 是 systemd 系统的一部分，用于管理登录会话
- 使用 list-sessions 命令可以查看所有当前活动的会话