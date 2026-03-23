# medusa 命令

## 命令说明
Medusa是一款功能强大的并行密码破解工具，用于测试网络服务的认证机制。它支持多种协议，包括SSH、FTP、HTTP、SMTP、POP3等，是网络安全测试和密码审计的重要工具。

## 语法
```
medusa [选项]
```

## 常用选项
- `-h <主机>`：指定目标主机
- `-u <用户>`：指定用户名
- `-U <文件>`：指定用户名字典文件
- `-p <密码>`：指定密码
- `-P <文件>`：指定密码字典文件
- `-M <模块>`：指定要使用的模块（如ssh、ftp、http等）
- `-n <端口>`：指定端口
- `-t <线程>`：指定线程数
- `-T <时间>`：指定超时时间
- `-f`：找到第一个有效凭据后停止
- `-F`：强制继续，即使模块初始化失败
- `-v <级别>`：详细程度（0-6）
- `-d`：调试模式
- `-V`：显示版本信息
- `-h`：显示帮助信息

## 支持的模块

Medusa支持以下模块：
- `ssh`：SSH协议
- `ftp`：FTP协议
- `http`：HTTP协议
- `smtp`：SMTP协议
- `pop3`：POP3协议
- `imap`：IMAP协议
- `telnet`：Telnet协议
- `mssql`：MSSQL协议
- `mysql`：MySQL协议
- `postgres`：PostgreSQL协议
- `rdp`：RDP协议
- `vnc`：VNC协议

## 示例

### 基本操作
```bash
# 破解SSH密码
medusa -h 192.168.1.1 -u root -P passwords.txt -M ssh

# 破解FTP密码
medusa -h 192.168.1.1 -u admin -P passwords.txt -M ftp

# 破解HTTP密码
medusa -h 192.168.1.1 -u admin -P passwords.txt -M http -m DIR:/admin

# 破解MySQL密码
medusa -h 192.168.1.1 -u root -P passwords.txt -M mysql
```

### 高级选项
```bash
# 使用多线程
medusa -h 192.168.1.1 -u root -P passwords.txt -M ssh -t 10

# 使用用户名字典
medusa -h 192.168.1.1 -U users.txt -P passwords.txt -M ssh

# 找到第一个有效凭据后停止
medusa -h 192.168.1.1 -u root -P passwords.txt -M ssh -f

# 指定端口
medusa -h 192.168.1.1 -u root -P passwords.txt -M ssh -n 2222

# 详细模式
medusa -h 192.168.1.1 -u root -P passwords.txt -M ssh -v 6
```

### 批量破解
```bash
# 破解多个主机
for host in $(cat hosts.txt); do
  echo "=== Cracking $host ==="
  medusa -h $host -u root -P passwords.txt -M ssh
  echo
done

# 破解多个用户
for user in admin root test; do
  echo "=== Cracking $user ==="
  medusa -h 192.168.1.1 -u $user -P passwords.txt -M ssh
  echo
done
```

## 适用场景

### 安全测试
- 测试网络服务的认证机制
- 评估密码强度
- 发现弱密码
- 验证认证系统的安全性

### 渗透测试
- 作为渗透测试的一部分
- 尝试获取系统访问权限
- 评估网络的安全状况
- 提供渗透测试的重点方向

### 安全审计
- 定期检查网络服务的密码强度
- 识别弱密码和默认密码
- 评估认证系统的有效性
- 提供安全加固建议

### 网络管理
- 测试网络设备的密码强度
- 发现默认密码和弱密码
- 确保网络设备的安全
- 提高网络的整体安全水平

### 事件响应
- 分析安全事件中的密码使用情况
- 识别可能的密码泄露
- 评估攻击的影响范围
- 提供事件响应建议

## 高级技巧

### 与其他工具结合
```bash
# 结合nmap进行端口扫描
nmap -p 22,21,80,3306 192.168.1.0/24 | grep "open" | cut -d "/" -f 1 | xargs -I {} medusa -h 192.168.1.1 -u root -P passwords.txt -M ssh -n {}

# 结合hydra进行对比测试
medusa -h 192.168.1.1 -u root -P passwords.txt -M ssh
 hydra -l root -P passwords.txt ssh://192.168.1.1

# 结合john进行密码分析
john --wordlist=rockyou.txt --rules | head -100 > top100.txt
medusa -h 192.168.1.1 -u root -P top100.txt -M ssh
```

### 自定义字典
```bash
# 使用crunch生成自定义字典
crunch 8 12 -f charset.lst mixalpha-numeric-all-space -o custom_wordlist.txt

# 使用cewl从网站生成字典
cewl https://example.com -w website_wordlist.txt

# 合并多个字典文件
cat wordlist1.txt wordlist2.txt > combined_wordlist.txt

# 排序并去重字典文件
sort combined_wordlist.txt | uniq > unique_wordlist.txt
```

### 性能优化
- 使用多线程提高破解速度
- 使用合理的字典文件减少破解时间
- 针对特定服务使用合适的模块
- 调整超时时间以适应网络环境

### 安全注意事项
- 获得授权后再进行测试
- 避免在生产环境中进行高强度测试
- 妥善处理测试结果，避免敏感信息泄露
- 遵守相关法律法规

## 常见问题解决

- **问题**：破解速度慢
  **解决方法**：增加线程数，使用更小的字典文件，优化网络环境

- **问题**：无法连接到目标
  **解决方法**：检查网络连接，确保目标可达，验证服务是否运行

- **问题**：破解失败
  **解决方法**：检查字典文件，确保包含正确的密码，调整破解参数

- **问题**：模块初始化失败
  **解决方法**：检查模块是否支持目标服务，验证服务版本

## 总结
Medusa是一款功能强大、灵活的密码破解工具，提供了丰富的选项和模块，适用于各种网络服务的认证测试场景。通过掌握Medusa的使用方法，安全专业人员可以更有效地测试网络服务的认证机制、评估密码强度、发现弱密码和验证认证系统的安全性。

Medusa的优势在于：
- 支持多种协议
- 并行破解能力
- 灵活的配置选项
- 与其他工具的良好集成
- 开源免费

作为密码破解的重要工具，Medusa是每个安全专业人员必备的工具之一。