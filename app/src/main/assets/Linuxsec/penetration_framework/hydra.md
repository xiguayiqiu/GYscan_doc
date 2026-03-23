# hydra 命令

## 命令说明
密码破解工具，用于暴力破解各种服务的密码。

## 语法
```
hydra [选项] 目标 服务
```

## 常用选项
- `-l`：指定用户名
- `-P`：指定密码文件
- `-p`：指定密码
- `-t`：指定线程数
- `-vV`：详细输出

## 示例
```bash
# 破解SSH密码
hydra -l admin -P passwords.txt 192.168.1.1 ssh

# 破解FTP密码
hydra -l user -P passwords.txt ftp://192.168.1.1

# 破解HTTP表单
hydra -l admin -P passwords.txt 192.168.1.1 http-post-form "/login.php:user=^USER^&pass=^PASS^:Invalid credentials"
```

## 适用场景
- 密码强度测试
- 安全评估
- 渗透测试
- 账户安全审计