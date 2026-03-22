# usermod - 修改用户

## 1. 命令简介
usermod 命令用于修改用户属性，是 Linux 系统中常用的用户和组管理命令之一。

## 2. 命令语法
```bash
usermod [选项] [用户名]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -c | 修改注释信息 |
| -d | 修改主目录 |
| -g | 修改初始组 |
| -G | 修改附加组 |
| -s | 修改登录Shell |
| -u | 修改用户ID |
| -l | 修改用户名 |
| --help | 显示帮助信息 |
| --version | 显示版本信息 |

## 4. 实战示例

### 4.1 修改用户的主目录
```bash
usermod -d /home/newhome username
```

### 4.2 修改用户的登录Shell
```bash
usermod -s /bin/zsh username
```

### 4.3 修改用户的附加组
```bash
usermod -G wheel,users username
```

### 4.4 修改用户名
```bash
usermod -l newusername oldusername
```

## 5. 注意事项
- usermod 命令用于修改用户属性
- usermod 命令需要 root 权限
- 修改用户属性时，需要确保用户没有正在运行的进程
- usermod 命令是一个常用的系统管理工具，用于用户管理