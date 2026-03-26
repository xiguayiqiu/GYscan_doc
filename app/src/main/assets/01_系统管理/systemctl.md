# systemctl - 控制系统和服务

## 1. 命令简介
systemctl 命令用于控制系统和服务，是 Linux 系统中常用的系统管理命令之一。它是 systemd 系统的核心工具，用于管理系统服务、挂载点、设备等。

## 2. 命令语法
```bash
systemctl [选项] [命令] [服务]
```

## 3. 常用选项

| 选项 | 说明 |
|------|------|
| -h, --help | 显示帮助信息 |
| --version | 显示版本信息 |
| --system | 操作系统服务 |
| --user | 操作用户服务 |
| -t, --type=<类型> | 限制单元类型 |
| -p, --property=<属性> | 显示指定属性 |
| --no-pager | 不使用分页器 |
| --no-legend | 不显示图例 |

## 4. 常用命令

| 命令 | 说明 |
|------|------|
| start | 启动服务 |
| stop | 停止服务 |
| restart | 重启服务 |
| reload | 重新加载服务配置 |
| status | 显示服务状态 |
| enable | 启用服务（开机自启） |
| disable | 禁用服务（禁止开机自启） |
| is-active | 检查服务是否激活 |
| is-enabled | 检查服务是否启用 |
| list-units | 显示所有单元 |
| list-services | 显示所有服务 |
| list-timers | 显示所有定时器 |
| daemon-reload | 重新加载 systemd 配置 |
| isolate | 切换到指定的目标 |
| poweroff | 关闭系统 |
| reboot | 重启系统 |
| halt | 停止系统 |
| suspend | 挂起系统 |
| hibernate | 休眠系统 |

## 5. 实战示例

### 5.1 服务管理
```bash
# 启动服务
systemctl start nginx

# 停止服务
systemctl stop nginx

# 重启服务
systemctl restart nginx

# 重新加载服务配置
systemctl reload nginx

# 显示服务状态
systemctl status nginx

# 启用服务（开机自启）
systemctl enable nginx

# 禁用服务（禁止开机自启）
systemctl disable nginx

# 检查服务是否激活
systemctl is-active nginx

# 检查服务是否启用
systemctl is-enabled nginx
```

### 5.2 系统状态
```bash
# 显示所有活动的服务
systemctl list-units --type=service

# 显示所有服务（包括非活动的）
systemctl list-units --type=service --all

# 显示所有定时器
systemctl list-timers

# 显示系统状态
systemctl status

# 重新加载 systemd 配置
systemctl daemon-reload
```

### 5.3 系统操作
```bash
# 关闭系统
systemctl poweroff

# 重启系统
systemctl reboot

# 停止系统
systemctl halt

# 挂起系统
systemctl suspend

# 休眠系统
systemctl hibernate

# 混合睡眠（休眠+挂起）
systemctl hybrid-sleep
```

### 5.4 目标管理
```bash
# 切换到多用户模式
systemctl isolate multi-user.target

# 切换到图形界面模式
systemctl isolate graphical.target

# 查看当前目标
systemctl get-default

# 设置默认目标
systemctl set-default multi-user.target
```

## 6. 高级用法

### 6.1 服务依赖管理
```bash
# 查看服务依赖
systemctl list-dependencies nginx

# 查看反向依赖
systemctl list-dependencies --reverse nginx
```

### 6.2 服务配置管理
```bash
# 查看服务配置文件
systemctl cat nginx

# 编辑服务配置
systemctl edit nginx

# 查看服务环境变量
systemctl show-environment

# 设置服务环境变量
systemctl set-environment VAR=value
```

### 6.3 监控服务状态
```bash
# 监控服务状态变化
systemctl status --follow nginx

# 查看服务日志
systemctl status nginx | journalctl -u nginx
```

### 6.4 批量管理服务
```bash
# 批量启动服务
systemctl start nginx mysql php-fpm

# 批量停止服务
systemctl stop nginx mysql php-fpm

# 批量重启服务
systemctl restart nginx mysql php-fpm
```

## 7. 常见问题与解决方案

### 7.1 问题：systemctl: command not found
**解决方案**：安装 systemd
- Ubuntu/Debian: `apt install systemd`
- CentOS/RHEL: `yum install systemd`

### 7.2 问题：服务启动失败
**解决方案**：查看服务状态和日志
```bash
systemctl status nginx
journalctl -u nginx
```

### 7.3 问题：服务无法启用
**解决方案**：检查服务文件是否存在
```bash
systemctl cat nginx
```

### 7.4 问题：systemctl 命令执行缓慢
**解决方案**：检查系统负载和服务状态

### 7.5 问题：无法使用 systemctl 命令
**解决方案**：确保有 root 权限
```bash
sudo systemctl start nginx
```

## 8. 命令对比

| 命令 | 功能 | 适用场景 |
|------|------|----------|
| systemctl | 控制系统和服务 | systemd 系统 |
| service | 控制系统服务 | 传统 SysV 系统 |
| chkconfig | 管理服务启动项 | 传统 SysV 系统 |
| init | 系统初始化 | 传统 SysV 系统 |

## 9. 注意事项
- systemctl 命令是 systemd 系统的核心工具，用于管理系统服务、挂载点、设备等
- systemctl 命令需要 root 权限来执行大部分操作
- 常用的操作包括：启动/停止/重启服务、启用/禁用服务、查看服务状态等
- systemctl 命令支持多种单元类型，包括服务、挂载点、设备等
- systemctl 命令可以用于控制系统的电源状态，如关机、重启、挂起等
- systemctl 命令是现代 Linux 系统的标准工具，替代了传统的 service 和 chkconfig 命令