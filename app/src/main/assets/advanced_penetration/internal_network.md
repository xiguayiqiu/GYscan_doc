# 内网渗透与横向移动 (Internal Network & Lateral Movement)

## 3.1 域环境高级攻击 (Active Directory)

### Kerberos 协议攻击
- **黄金/白银票据 (Golden/Silver Ticket)**
  - 获取域控制器的 KRBTGT 账户哈希
  - 生成黄金票据，绕过身份验证
  - 利用白银票据访问特定服务

- **AS-REP Roasting**
  - 识别配置了 "Do not require Kerberos preauthentication" 的用户
  - 请求 AS-REP 消息，获取加密的 TGT
  - 破解加密的 TGT，获取用户密码

- **Kerberoasting 优化版**
  - 识别具有 SPN 的服务账户
  - 请求服务票据，获取加密的服务票据
  - 使用 GPU 加速破解，提高效率

### AD CS (证书服务) 滥用
- **ESC1-ESC8 漏洞利用链**
  - 分析 AD CS 配置，识别漏洞
  - 利用 ESC1-ESC8 漏洞获取域权限
  - 构造恶意证书，实现权限提升

- **证书模板配置错误提权**
  - 识别配置错误的证书模板
  - 利用低权限用户请求高权限证书
  - 实现从普通用户到域管理员的提权

### 组策略 (GPO) 攻击
- **GPO 权限配置错误利用**
  - 分析 GPO 权限，识别可修改的策略
  - 修改 GPO，添加恶意脚本或配置
  - 实现域内持久化和权限提升

- **恶意GPO下发执行**
  - 构造恶意 GPO，包含启动脚本或计划任务
  - 利用 GPO 下发机制，在目标计算机上执行恶意代码
  - 测试 GPO 执行的防御机制

## 3.2 凭证窃取与传递

### 高级凭证获取
- **LSASS 内存转储绕过 (BYOVD)**
  - 使用 BYOVD (Bring Your Own Vulnerable Driver) 技术
  - 绕过 EDR 防护，获取 LSASS 内存
  - 提取内存中的凭证信息

- **浏览器缓存凭证提取**
  - 分析浏览器缓存和存储
  - 提取保存的密码和会话信息
  - 测试浏览器的安全存储机制

- **SSH 密钥/云Token 窃取**
  - 搜索服务器上的 SSH 密钥文件
  - 提取云服务的访问令牌
  - 利用窃取的凭证访问其他系统

### 传递攻击
- **Pass-the-Hash (PtH)**
  - 利用 NTLM 哈希值，绕过密码验证
  - 使用 Mimikatz 等工具执行 PtH 攻击
  - 测试网络中的哈希传递防御

- **Pass-the-Ticket (PtT)**
  - 窃取 Kerberos 票据，重用于身份验证
  - 利用票据传递，访问目标系统
  - 测试票据传递的检测和防御

- **Overpass-the-Hash**
  - 利用哈希值获取 Kerberos TGT
  - 避免直接传递哈希，减少被检测的风险
  - 结合 PtT 技术，实现更隐蔽的攻击

## 3.3 隐蔽通道与隧道

### 流量隐藏技术
- **DNS 隧道 (ICMP/TXT 记录)**
  - 利用 DNS 协议建立隐蔽通道
  - 通过 TXT 记录或 ICMP 数据包传输数据
  - 测试 DNS 流量的监控和检测

- **HTTPS/SSL 加密隧道 (C2 over TLS)**
  - 使用 SSL/TLS 加密通信，绕过流量检测
  - 模拟合法 HTTPS 流量，避免被识别
  - 测试 SSL 流量的深度检测

- **前端代理 (ReGeorg/NeoReGeorg)**
  - 利用 Web 应用作为代理，建立隧道
  - 绕过防火墙和网络隔离
  - 测试 Web 应用的代理检测

### 多级跳板构建
- **SSH Dynamic Forwarding**
  - 使用 SSH 动态端口转发，建立 socks 代理
  - 通过多级跳板，隐藏真实攻击源
  - 测试 SSH 流量的监控和检测

- **Proxychains/Frps 高级配置**
  - 配置 Proxychains，实现多级代理
  - 使用 Frps 建立反向代理，穿透 NAT
  - 测试代理链的检测和防御

- **基于Websocket的隐蔽C2**
  - 利用 WebSocket 协议建立 C2 通道
  - 模拟合法 Web 流量，避免被识别
  - 测试 WebSocket 流量的监控和检测

## 3.4 无文件攻击 (Fileless)

### 内存加载技术
- **PowerShell Empired/Invoke-ReflectivePEInjection**
  - 使用 PowerShell 执行内存中的代码
  - 利用反射注入技术，加载 PE 文件到内存
  - 避免文件系统操作，减少被检测的风险

- **WMI 持久化**
  - 利用 WMI 事件订阅实现持久化
  - 配置 WMI 触发器，在特定条件下执行代码
  - 测试 WMI 事件的检测和防御

- **LOLBins (Living Off The Land Binaries) 滥用**
  - **Certutil, Mshta, Regsvr32 等系统自带工具**
    - 利用系统自带工具执行恶意代码
    - 避免使用可疑的第三方工具，减少被检测的风险
    - 测试系统工具的使用监控和检测