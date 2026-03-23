# airtun-ng 命令

## 命令说明
airtun-ng是Aircrack-ng套件中的一个工具，用于创建无线隧道，在无线和有线网络之间建立连接。它可以用于扩展网络覆盖范围，或者在无线环境中创建安全的通信通道。

## 语法
```
airtun-ng [选项] <接口>
```

## 常用选项
- `-a <BSSID>`：指定AP的BSSID
- `-h <MAC>`：指定源MAC地址
- `-w <密钥>`：指定WEP密钥
- `-p <端口>`：指定UDP端口
- `-t <类型>`：指定隧道类型
- `-v`：详细模式
- `-h`：显示帮助信息

## 核心功能

airtun-ng提供了以下核心功能：
- **创建无线隧道**：在无线和有线网络之间建立隧道
- **扩展网络覆盖**：扩展无线网络的覆盖范围
- **安全通信**：在无线环境中创建安全的通信通道
- **网络桥接**：桥接无线和有线网络

## 技术原理

airtun-ng通过以下步骤工作：

1. 创建一个虚拟网络接口
2. 通过无线接口发送和接收数据包
3. 在无线和有线网络之间转发数据包
4. 提供安全的通信通道

airtun-ng使用隧道技术，在无线和有线网络之间建立连接。

## 示例

### 基本操作
```bash
# 创建无线隧道
airtun-ng -a <AP MAC> -h <客户端MAC> -w <WEP密钥> wlan0mon

# 指定UDP端口
airtun-ng -a <AP MAC> -h <客户端MAC> -w <WEP密钥> -p 8080 wlan0mon

# 指定隧道类型
airtun-ng -a <AP MAC> -h <客户端MAC> -w <WEP密钥> -t 1 wlan0mon

# 详细模式
airtun-ng -v -a <AP MAC> -h <客户端MAC> -w <WEP密钥> wlan0mon
```

### 高级选项
```bash
# 配置网络接口
airtun-ng -a <AP MAC> -h <客户端MAC> -w <WEP密钥> wlan0mon
ifconfig at0 up
ifconfig at0 192.168.1.100 netmask 255.255.255.0
route add default gw 192.168.1.1

# 结合其他工具使用
airtun-ng -a <AP MAC> -h <客户端MAC> -w <WEP密钥> wlan0mon
# 然后使用iptables设置转发规则
```

### 实际应用
```bash
# 创建无线隧道并配置网络
# 1. 创建隧道
airtun-ng -a <AP MAC> -h <客户端MAC> -w <WEP密钥> wlan0mon

# 2. 配置网络接口
ifconfig at0 up
ifconfig at0 192.168.1.100 netmask 255.255.255.0
route add default gw 192.168.1.1

# 3. 设置IP转发
echo 1 > /proc/sys/net/ipv4/ip_forward

# 4. 配置iptables
iptables -t nat -A POSTROUTING -o at0 -j MASQUERADE

# 5. 测试连接
ping 192.168.1.1
```

## 适用场景

### 无线渗透测试
- 扩展网络覆盖范围
- 创建安全的通信通道
- 测试无线网络的安全性
- 评估网络防御能力

### 网络安全审计
- 评估无线网络的安全性
- 测试网络隔离措施
- 检测网络漏洞
- 提供安全加固建议

### 网络扩展
- 扩展无线网络的覆盖范围
- 连接不同的网络段
- 提供临时网络连接
- 建立远程访问通道

### 教育和研究
- 学习网络隧道技术
- 研究无线安全
- 开发网络安全工具
- 测试网络防御措施

## 高级技巧

### 与其他工具结合
```bash
# 结合airodump-ng使用
aio dump-ng --bssid <AP MAC> --channel <频道> -w capture wlan0mon
airtun-ng -a <AP MAC> -h <客户端MAC> -w <WEP密钥> wlan0mon

# 结合aircrack-ng使用
aio dump-ng --bssid <AP MAC> --channel <频道> -w capture wlan0mon
aircrack-ng -w wordlist.txt capture-01.cap
# 破解成功后
airtun-ng -a <AP MAC> -h <客户端MAC> -w <WEP密钥> wlan0mon

# 结合Wireshark使用
airtun-ng -a <AP MAC> -h <客户端MAC> -w <WEP密钥> wlan0mon
wireshark -i at0
```

### 性能优化
- 使用高性能无线网卡
- 确保无线网卡驱动支持注入
- 选择合适的频道
- 合理设置隧道参数

### 安全注意事项
- 获得授权后再进行测试
- 避免攻击他人的无线网络
- 遵守相关法律法规
- 确保隧道的安全性

## 常见问题解决

- **问题**：无法创建隧道
  **解决方法**：检查AP的BSSID和客户端MAC地址是否正确，确保WEP密钥正确，尝试使用不同的隧道类型

- **问题**：隧道连接不稳定
  **解决方法**：确保无线信号强度良好，尝试使用不同的频道，优化隧道参数

- **问题**：网络接口配置失败
  **解决方法**：确保airtun-ng成功创建隧道，检查网络接口是否存在，尝试重新配置

- **问题**：性能问题
  **解决方法**：优化系统资源，使用高性能无线网卡，减少网络负载

## 总结
airtun-ng是一款功能强大、灵活的无线隧道工具，是Aircrack-ng套件中的重要组成部分。通过掌握airtun-ng的使用方法，安全专业人员可以更有效地创建无线隧道、扩展网络覆盖范围、建立安全的通信通道和进行无线渗透测试。

airtun-ng的优势在于：
- 功能全面
- 操作灵活
- 与其他Aircrack-ng工具的良好集成
- 开源免费

作为无线渗透测试的重要工具，airtun-ng是每个安全专业人员必备的工具之一。