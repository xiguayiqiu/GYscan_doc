# systemctl - 控制系统和服务

## 1. 命令简介
systemctl 命令用于控制系统和服务，是 Linux 系统中最常用的系统管理命令之一。

## 2. 命令语法
```bash
systemctl [选项] [命令] [服务]
```

## 3. 常用命令
| 命令 | 说明 |
|------|------|
| start | 启动服务 |
| stop | 停止服务 |
| restart | 重启服务 |
| reload | 重新加载服务配置 |
| status | 显示服务状态 |
| enable | 启用服务（开机自启） |
| disable | 禁用服务（开机不自启） |
| is-enabled | 检查服务是否启用 |
| is-active | 检查服务是否活跃 |
| list-units | 显示所有单元 |
| list-services | 显示所有服务 |
| list-unit-files | 显示所有单元文件 |

## 4. 实战示例

### 4.1 启动服务
```bash
sudo systemctl start nginx
```

### 4.2 停止服务
```bash
sudo systemctl stop nginx
```

### 4.3 重启服务
```bash
sudo systemctl restart nginx
```

### 4.4 重新加载服务配置
```bash
sudo systemctl reload nginx
```

### 4.5 显示服务状态
```bash
systemctl status nginx
```

### 4.6 启用服务
```bash
sudo systemctl enable nginx
```

### 4.7 禁用服务
```bash
sudo systemctl disable nginx
```

### 4.8 显示所有服务
```bash
systemctl list-services
```

## 5. 注意事项
- systemctl 命令需要 root 权限才能管理服务
- systemctl 是 systemd 系统的一部分，用于管理系统服务和其他系统资源
- 使用 enable 和 disable 命令可以控制服务是否在系统启动时自动启动