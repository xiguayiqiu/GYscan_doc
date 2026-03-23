# crackmapexec 命令

## 命令说明
CrackMapExec (CME)是一款功能强大的网络渗透测试工具，专为Windows和Active Directory环境设计。它集成了多种功能，包括密码破解、横向移动、权限提升、信息收集等，是Windows环境渗透测试的重要工具。

## 语法
```
crackmapexec <协议> <目标> [选项]
```

## 常用选项
- `-u <用户>`：指定用户名
- `-p <密码>`：指定密码
- `-U <文件>`：指定用户名字典文件
- `-P <文件>`：指定密码字典文件
- `-d <域>`：指定域名
- `--local-auth`：使用本地认证
- `--domain-auth`：使用域认证
- `-x <命令>`：执行命令
- `-X <文件>`：执行脚本文件
- `--exec-method <方法>`：执行方法（wmiexec, psexec, smbexec, atexec）
- `--pass-pol`：获取密码策略
- `--sam`：导出SAM哈希
- `--lsa`：导出LSA密钥
- `--ntds`：导出NTDS.dit
- `--disks`：列出磁盘
- `--sessions`：列出会话
- `--users`：列出用户
- `--groups`：列出组
- `--shares`：列出共享
- `--loggedon-users`：列出登录用户
- `--verbose`：详细模式
- `-h`：显示帮助信息

## 支持的协议

CrackMapExec支持以下协议：
- `smb`：SMB协议（默认）
- `mssql`：MSSQL协议
- `winrm`：WinRM协议
- `ldap`：LDAP协议
- `ssh`：SSH协议
- `ftp`：FTP协议
- `http`：HTTP协议

## 示例

### 基本操作
```bash
# 扫描网络
crackmapexec smb 192.168.1.0/24

# 测试凭据
crackmapexec smb 192.168.1.1 -u admin -p password

# 批量测试凭据
crackmapexec smb 192.168.1.0/24 -u admin -p password

# 使用用户名字典和密码字典
crackmapexec smb 192.168.1.0/24 -U users.txt -P passwords.txt
```

### 高级选项
```bash
# 执行命令
crackmapexec smb 192.168.1.1 -u admin -p password -x "whoami"

# 执行PowerShell命令
crackmapexec smb 192.168.1.1 -u admin -p password -x "powershell -c Get-Process"

# 获取密码策略
crackmapexec smb 192.168.1.1 -u admin -p password --pass-pol

# 导出SAM哈希
crackmapexec smb 192.168.1.1 -u admin -p password --sam

# 列出共享
crackmapexec smb 192.168.1.1 -u admin -p password --shares
```

### 域环境操作
```bash
# 域认证
crackmapexec smb 192.168.1.0/24 -u admin -p password -d domain

# 列出域用户
crackmapexec smb 192.168.1.1 -u admin -p password -d domain --users

# 列出域组
crackmapexec smb 192.168.1.1 -u admin -p password -d domain --groups

# 横向移动
crackmapexec smb 192.168.1.0/24 -u admin -p password -d domain -x "net user"
```

### 其他协议
```bash
# 使用MSSQL协议
crackmapexec mssql 192.168.1.0/24 -u sa -p password

# 使用WinRM协议
crackmapexec winrm 192.168.1.0/24 -u admin -p password

# 使用LDAP协议
crackmapexec ldap 192.168.1.1 -u admin -p password -d domain

# 使用SSH协议
crackmapexec ssh 192.168.1.0/24 -u root -p password
```

## 适用场景

### 网络渗透测试
- 测试Windows网络的安全性
- 发现弱密码和默认密码
- 评估域环境的安全状况
- 识别潜在的攻击向量

### 横向移动
- 在网络中横向移动
- 获取更多系统的访问权限
- 测试网络分段的有效性
- 评估网络的整体安全状况

### 权限提升
- 测试权限提升漏洞
- 评估用户权限的配置
- 发现权限配置错误
- 提供权限管理建议

### 信息收集
- 收集网络中的系统信息
- 识别网络中的共享资源
- 收集用户和组信息
- 评估网络的可见性

### 事件响应
- 分析安全事件中的攻击路径
- 识别受影响的系统
- 评估攻击的影响范围
- 提供事件响应建议

## 高级技巧

### 与其他工具结合
```bash
# 结合nmap进行端口扫描
nmap -p 445 192.168.1.0/24 | grep "open" | cut -d " " -f 5 | xargs -I {} crackmapexec smb {} -u admin -p password

# 结合metasploit进行渗透测试
# 1. 使用CME发现可利用的系统
# 2. 使用Metasploit利用漏洞

# 结合BloodHound进行域分析
crackmapexec smb 192.168.1.1 -u admin -p password -d domain --users > users.txt
python bloodhound.py -u admin -p password -d domain -c all
```

### 自定义模块
```bash
# 创建自定义模块
cat > custom_module.py << 'EOF'
from crackmapexec.modules import CMEModule

class CustomModule(CMEModule):
    name = "custom"
    description = "Custom module"
    supported_protocols = ["smb"]
    opsec_safe = True
    multiple_hosts = True
    
    def run(self):
        self.logger.info(f"Running custom module on {self.target}")
        # 自定义逻辑
EOF

# 加载自定义模块
crackmapexec smb 192.168.1.1 -u admin -p password --module custom
```

### 性能优化
- 使用多线程提高扫描速度
- 使用合理的字典文件减少测试时间
- 针对特定协议使用合适的选项
- 调整超时时间以适应网络环境

### 安全注意事项
- 获得授权后再进行测试
- 避免在生产环境中进行高强度测试
- 妥善处理测试结果，避免敏感信息泄露
- 遵守相关法律法规

## 常见问题解决

- **问题**：扫描速度慢
  **解决方法**：增加线程数，使用更小的字典文件，优化网络环境

- **问题**：无法连接到目标
  **解决方法**：检查网络连接，确保目标可达，验证服务是否运行

- **问题**：测试失败
  **解决方法**：检查凭据是否正确，调整测试参数，验证目标系统是否支持

- **问题**：模块执行失败
  **解决方法**：检查模块是否支持目标系统，验证权限是否足够

## 总结
CrackMapExec是一款功能强大、灵活的网络渗透测试工具，提供了丰富的选项和功能，适用于各种Windows和Active Directory环境的安全测试场景。通过掌握CrackMapExec的使用方法，安全专业人员可以更有效地测试网络的安全性、发现弱密码、执行横向移动、收集信息和评估权限配置。

CrackMapExec的优势在于：
- 支持多种协议
- 集成了多种功能
- 灵活的配置选项
- 与其他工具的良好集成
- 开源免费

作为Windows环境渗透测试的重要工具，CrackMapExec是每个安全专业人员必备的工具之一。