# hostnamectl - 控制系统主机名

## 1. 命令简介
hostnamectl 命令用于控制系统的主机名，是 Linux 系统中最常用的主机名管理工具之一。

## 2. 命令语法
```bash
hostnamectl [选项] [命令]
```

## 3. 常用命令
| 命令 | 说明 |
|------|------|
| status | 显示主机名状态 |
| set-hostname | 设置主机名 |
| set-icon-name | 设置图标名称 |
| set-chassis | 设置机箱类型 |
| set-deployment | 设置部署环境 |
| set-location | 设置位置 |

## 4. 实战示例

### 4.1 显示主机名状态
```bash
hostnamectl status
```

### 4.2 设置主机名
```bash
sudo hostnamectl set-hostname new-hostname
```

### 4.3 设置图标名称
```bash
sudo hostnamectl set-icon-name computer
```

### 4.4 设置机箱类型
```bash
sudo hostnamectl set-chassis laptop
```

### 4.5 设置部署环境
```bash
sudo hostnamectl set-deployment production
```

### 4.6 设置位置
```bash
sudo hostnamectl set-location "Data Center"
```

## 5. 注意事项
- hostnamectl 命令需要 root 权限，使用 sudo 执行
- 设置主机名后，系统会自动更新 /etc/hostname 文件
- 有些系统可能需要重启才能完全应用新的主机名