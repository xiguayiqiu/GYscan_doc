# hostnamectl - 控制系统主机名

## 1. 命令简介
hostnamectl 命令用于控制系统主机名，是 Linux 系统中常用的系统管理命令之一。

## 2. 命令语法
```bash
hostnamectl [选项] [命令]
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
| status | 显示当前主机名状态 |
| set-hostname | 设置主机名 |
| set-icon-name | 设置图标名称 |
| set-chassis | 设置机箱类型 |
| set-deployment | 设置部署环境 |
| set-location | 设置位置 |

## 5. 实战示例

### 5.1 显示当前主机名状态
```bash
hostnamectl status
```

### 5.2 设置主机名
```bash
hostnamectl set-hostname new-hostname
```

### 5.3 设置图标名称
```bash
hostnamectl set-icon-name computer
```

### 5.4 设置机箱类型
```bash
hostnamectl set-chassis laptop
```

## 6. 注意事项
- hostnamectl 命令用于控制系统主机名，是 systemd 系统的一部分
- hostnamectl 命令需要 root 权限
- hostnamectl 命令会永久修改主机名，不需要编辑配置文件