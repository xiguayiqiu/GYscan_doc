# chsh - 修改用户Shell

## 1. 命令简介
chsh 命令用于修改用户的登录Shell，是 Linux 系统中常用的用户管理命令之一。

## 2. 命令语法
```bash
chsh [选项] [用户名]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -s | 指定新的登录Shell |

## 4. 实战示例

### 4.1 修改当前用户的登录Shell
```bash
chsh -s /bin/bash
```

### 4.2 修改指定用户的登录Shell
```bash
sudo chsh -s /bin/bash user1
```

## 5. 注意事项
- chsh 命令修改当前用户的登录Shell时不需要 root 权限，但修改其他用户的登录Shell时需要
- 使用 -s 选项可以指定新的登录Shell
- 可用的Shell列表通常在 /etc/shells 文件中定义