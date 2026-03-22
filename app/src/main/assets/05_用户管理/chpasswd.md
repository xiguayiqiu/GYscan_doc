# chpasswd - 批量修改密码

## 1. 命令简介
chpasswd 命令用于批量修改用户密码，是 Linux 系统中常用的用户管理命令之一。

## 2. 命令语法
```bash
chpasswd [选项]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -c | 使用CRYPT加密算法 |
| -e | 输入的密码已经是加密过的 |
| -m | 使用MD5加密算法 |
| -s | 使用SHA加密算法 |

## 4. 实战示例

### 4.1 批量修改密码
```bash
echo "user1:password1\nuser2:password2" | sudo chpasswd
```

### 4.2 从文件中读取用户和密码
```bash
sudo chpasswd < passwords.txt
```

### 4.3 使用加密密码
```bash
echo "user1:$6$rounds=4096$saltsalt$hashhash" | sudo chpasswd -e
```

## 5. 注意事项
- chpasswd 命令需要 root 权限，使用 sudo 执行
- chpasswd 命令从标准输入或文件中读取用户和密码，格式为 "用户名:密码"
- 使用 -e 选项可以输入已经加密过的密码
- chpasswd 命令是批量修改密码的有效工具，适合在脚本中使用