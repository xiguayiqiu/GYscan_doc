# useradd - 创建用户

## 1. 命令简介
useradd 命令用于创建用户，是 Linux 系统中常用的用户和组管理命令之一。

## 2. 命令语法
```bash
useradd [选项] [用户名]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -c | 添加注释信息 |
| -d | 指定主目录 |
| -g | 指定初始组 |
| -G | 指定附加组 |
| -m | 创建主目录 |
| -s | 指定登录Shell |
| -u | 指定用户ID |
| --help | 显示帮助信息 |
| --version | 显示版本信息 |

## 4. 实战示例

### 4.1 创建用户
```bash
useradd username
```

### 4.2 创建用户并指定主目录
```bash
useradd -m -d /home/username username
```

### 4.3 创建用户并指定登录Shell
```bash
useradd -s /bin/bash username
```

### 4.4 创建用户并指定用户ID
```bash
useradd -u 1001 username
```

## 5. 注意事项
- useradd 命令用于创建用户
- useradd 命令需要 root 权限
- 创建用户后，需要使用 passwd 命令设置密码
- useradd 命令是一个常用的系统管理工具，用于用户管理