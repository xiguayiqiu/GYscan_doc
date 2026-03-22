# userdel - 删除用户

## 1. 命令简介
userdel 命令用于删除用户，是 Linux 系统中常用的用户和组管理命令之一。

## 2. 命令语法
```bash
userdel [选项] [用户名]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -f | 强制删除 |
| -r | 删除用户的主目录和邮件文件 |
| --help | 显示帮助信息 |
| --version | 显示版本信息 |

## 4. 实战示例

### 4.1 删除用户
```bash
userdel username
```

### 4.2 删除用户并删除主目录
```bash
userdel -r username
```

### 4.3 强制删除用户
```bash
userdel -f username
```

## 5. 注意事项
- userdel 命令用于删除用户
- userdel 命令需要 root 权限
- 删除用户时，需要确保用户没有正在运行的进程
- userdel 命令是一个常用的系统管理工具，用于用户管理