# useradd - 创建用户

## 1. 命令简介
useradd 命令用于创建用户，是 Linux 系统中常用的用户管理命令之一。

## 2. 命令语法
```bash
useradd [选项] [用户名]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -c | 添加注释信息 |
| -d | 指定用户主目录 |
| -e | 指定账户过期日期 |
| -g | 指定用户所属的主组 |
| -G | 指定用户所属的附加组 |
| -m | 自动创建用户主目录 |
| -M | 不创建用户主目录 |
| -p | 指定用户密码 |
| -s | 指定用户登录shell |
| -u | 指定用户ID |

## 4. 实战示例

### 4.1 创建用户
```bash
sudo useradd user1
```

### 4.2 创建用户并指定主目录
```bash
sudo useradd -d /home/user1 -m user1
```

### 4.3 创建用户并指定所属组
```bash
sudo useradd -g group1 user1
```

### 4.4 创建用户并指定附加组
```bash
sudo useradd -G group1,group2 user1
```

### 4.5 创建用户并指定登录shell
```bash
sudo useradd -s /bin/bash user1
```

### 4.6 创建用户并添加注释信息
```bash
sudo useradd -c "Test User" user1
```

## 5. 注意事项
- useradd 命令需要 root 权限，使用 sudo 执行
- useradd 命令创建用户后，需要使用 passwd 命令设置密码
- 使用 -m 选项可以自动创建用户主目录
- 使用 -s 选项可以指定用户登录shell，默认为 /bin/sh