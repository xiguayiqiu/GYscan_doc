# loginctl - 控制登录会话

## 1. 命令简介
loginctl 命令用于控制登录会话，是 Linux 系统中常用的系统管理命令之一。它是 systemd 系统的一部分，用于管理用户登录会话、 seats 和用户。

## 2. 命令语法
```bash
loginctl [选项] [命令] [参数...]
```

## 3. 常用选项

| 选项 | 说明 |
|------|------|
| -h, --help | 显示帮助信息 |
| --version | 显示版本信息 |
| --no-pager | 不使用分页器 |
| --no-legend | 不显示图例 |

## 4. 常用命令

| 命令 | 说明 |
|------|------|
| list-sessions | 显示所有会话 |
| list-users | 显示所有用户 |
| list-seats | 显示所有 seats |
| session-status | 显示会话状态 |
| user-status | 显示用户状态 |
| seat-status | 显示 seat 状态 |
| unlock-session | 解锁会话 |
| lock-session | 锁定会话 |
| terminate-session | 终止会话 |
| terminate-user | 终止用户的所有会话 |
| enable-linger | 启用用户的 linger 模式 |
| disable-linger | 禁用用户的 linger 模式 |

## 5. 实战示例

### 5.1 查看会话信息
```bash
# 显示所有会话
loginctl list-sessions

# 显示会话状态
loginctl session-status

# 显示指定会话的状态
loginctl session-status <会话ID>
```

### 5.2 查看用户信息
```bash
# 显示所有用户
loginctl list-users

# 显示用户状态
loginctl user-status

# 显示指定用户的状态
loginctl user-status <用户ID或名称>
```

### 5.3 查看 seat 信息
```bash
# 显示所有 seats
loginctl list-seats

# 显示 seat 状态
loginctl seat-status

# 显示指定 seat 的状态
loginctl seat-status <seat名称>
```

### 5.4 管理会话
```bash
# 锁定会话
loginctl lock-session

# 锁定指定会话
loginctl lock-session <会话ID>

# 解锁会话
loginctl unlock-session

# 解锁指定会话
loginctl unlock-session <会话ID>

# 终止会话
loginctl terminate-session <会话ID>

# 终止用户的所有会话
loginctl terminate-user <用户ID或名称>
```

### 5.5 管理用户 linger 模式
```bash
# 启用用户的 linger 模式
loginctl enable-linger <用户ID或名称>

# 禁用用户的 linger 模式
loginctl disable-linger <用户ID或名称>
```

## 6. 高级用法

### 6.1 监控会话状态
```bash
# 监控会话状态变化
loginctl list-sessions --no-pager | watch -n 1

# 监控用户状态变化
loginctl list-users --no-pager | watch -n 1
```

### 6.2 与其他命令结合使用
```bash
# 查看当前登录用户的会话信息
who | awk '{print $1}' | xargs loginctl user-status

# 查看所有活跃会话的详细信息
loginctl list-sessions | grep -v "SESSION" | awk '{print $1}' | xargs loginctl session-status
```

### 6.3 批量管理会话
```bash
# 终止所有非活跃会话
loginctl list-sessions | grep -v "SESSION" | awk '{if ($3 == "inactive") print $1}' | xargs loginctl terminate-session

# 锁定所有活跃会话
loginctl list-sessions | grep -v "SESSION" | awk '{if ($3 == "active") print $1}' | xargs loginctl lock-session
```

### 6.4 查看登录历史
```bash
# 查看登录历史
last

# 查看指定用户的登录历史
last <用户名>

# 查看登录失败的记录
lastb
```

## 7. 常见问题与解决方案

### 7.1 问题：loginctl: command not found
**解决方案**：安装 systemd-logind
- Ubuntu/Debian: `apt install systemd-logind`
- CentOS/RHEL: `yum install systemd-logind`

### 7.2 问题：无法管理会话
**解决方案**：确保有足够的权限
```bash
sudo loginctl terminate-session <会话ID>
```

### 7.3 问题：无法启用 linger 模式
**解决方案**：确保用户存在
```bash
sudo loginctl enable-linger <用户ID或名称>
```

### 7.4 问题：loginctl 命令执行缓慢
**解决方案**：检查系统负载和服务状态

### 7.5 问题：无法查看会话信息
**解决方案**：确保 systemd-logind 服务正在运行
```bash
systemctl status systemd-logind
```

## 8. 命令对比

| 命令 | 功能 | 适用场景 |
|------|------|----------|
| loginctl | 控制登录会话 | systemd 系统 |
| who | 显示当前登录用户 | 所有 Linux 系统 |
| w | 显示当前登录用户及其活动 | 所有 Linux 系统 |
| last | 显示登录历史 | 所有 Linux 系统 |
| lastb | 显示登录失败的记录 | 所有 Linux 系统 |

## 9. 注意事项
- loginctl 命令用于控制登录会话，是 Linux 系统中常用的系统管理命令之一
- loginctl 命令是 systemd 系统的一部分，用于管理用户登录会话、 seats 和用户
- 常用的操作包括：查看会话信息、查看用户信息、查看 seat 信息、管理会话等
- loginctl 命令需要 root 权限来执行大部分操作
- loginctl 命令支持多种子命令，可以根据需要选择合适的命令
- loginctl 命令是现代 Linux 系统的标准工具，替代了传统的登录管理命令