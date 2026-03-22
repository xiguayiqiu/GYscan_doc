# usermod - 修改用户

## 1. 命令简介
usermod 命令用于修改用户，是 Linux 系统中常用的用户管理命令之一。

## 2. 命令语法
```bash
usermod [选项] [用户名]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -c | 修改注释信息 |
| -d | 修改用户主目录 |
| -e | 修改账户过期日期 |
| -g | 修改用户所属的主组 |
| -G | 修改用户所属的附加组 |
| -l | 修改用户名 |
| -s | 修改用户登录shell |
| -u | 修改用户ID |
| -L | 锁定用户账户 |
| -U | 解锁用户账户 |

## 4. 实战示例

### 4.1 修改用户注释信息
```bash
sudo usermod -c "Modified User" user1
```

### 4.2 修改用户主目录
```bash
sudo usermod -d /home/newuser user1
```

### 4.3 修改用户所属的主组
```bash
sudo usermod -g group2 user1
```

### 4.4 修改用户所属的附加组
```bash
sudo usermod -G group2,group3 user1
```

### 4.5 修改用户登录shell
```bash
sudo usermod -s /bin/bash user1
```

### 4.6 修改用户名
```bash
sudo usermod -l newuser user1
```

### 4.7 锁定用户账户
```bash
sudo usermod -L user1
```

### 4.8 解锁用户账户
```bash
sudo usermod -U user1
```

## 5. 注意事项
- usermod 命令需要 root 权限，使用 sudo 执行
- 使用 -d 选项修改用户主目录时，需要手动移动用户数据
- 使用 -l 选项修改用户名时，会自动更新用户主目录的名称
- 使用 -L 选项可以锁定用户账户，使用 -U 选项可以解锁用户账户