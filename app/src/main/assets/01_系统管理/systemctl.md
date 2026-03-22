# systemctl - 控制系统服务

## 1. 命令简介
systemctl 命令用于控制系统服务，是 Linux 系统中常用的系统管理命令之一。

## 2. 命令语法
```bash
systemctl [选项] [命令] [服务]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -h | 显示帮助信息 |
| --help | 显示帮助信息 |
| --version | 显示版本信息 |

## 4. 常用命令
| 命令 | 说明 |
|------|------|
| start | 启动服务 |
| stop | 停止服务 |
| restart | 重启服务 |
| reload | 重新加载服务 |
| status | 显示服务状态 |
| enable | 启用服务 |
| disable | 禁用服务 |
| list-units | 显示所有单元 |
| list-services | 显示所有服务 |

## 5. 实战示例

### 5.1 启动服务
```bash
systemctl start service
```

### 5.2 停止服务
```bash
systemctl stop service
```

### 5.3 显示服务状态
```bash
systemctl status service
```

### 5.4 启用服务
```bash
systemctl enable service
```

## 6. 注意事项
- systemctl 命令用于控制系统服务，是 systemd 系统的一部分
- systemctl 命令需要 root 权限
- systemctl 命令是一个常用的系统管理工具，用于管理系统服务