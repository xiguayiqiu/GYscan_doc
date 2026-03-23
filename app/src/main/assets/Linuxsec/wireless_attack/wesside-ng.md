# wesside-ng 命令

## 命令说明
wesside-ng是Aircrack-ng套件中的一个工具，用于自动破解WPA/WPA2加密的无线网络。它可以自动捕获握手包，使用字典攻击破解密码，并建立与AP的连接。

## 语法
```
wesside-ng [选项] <接口>
```

## 常用选项
- `-a <BSSID>`：指定AP的BSSID
- `-e <ESSID>`：指定ESSID
- `-c <频道>`：指定频道
- `-w <文件>`：指定字典文件
- `-i <文件>`：指定输入文件
- `-o <文件>`：指定输出文件
- `-v`：详细模式
- `-h`：显示帮助信息

## 核心功能

wesside-ng提供了以下核心功能：
- **自动破解WPA/WPA2**：自动捕获握手包，使用字典攻击破解密码
- **建立网络连接**：破解密码后，自动建立与AP的连接
- **自动扫描**：自动扫描周围的AP
- **实时监控**：实时监控破解进度

## 技术原理

wesside-ng通过以下步骤工作：

1. 扫描周围的AP
2. 选择目标AP
3. 捕获握手包
4. 使用字典攻击破解密码
5. 建立与AP的连接

wesside-ng使用WPA/WPA2破解技术，自动完成整个破解过程。

## 示例

### 基本操作
```bash
# 自动扫描并破解nwesside-ng wlan0mon

# 指定APnwesside-ng -a <AP MAC> -e <ESSID> -c <频道> wlan0mon

# 使用指定的字典文件nwesside-ng -w wordlist.txt -a <AP MAC> -e <ESSID> -c <频道> wlan0mon

# 详细模式nwesside-ng -v -a <AP MAC> -e <ESSID> -c <频道> wlan0mon
```

### 高级选项
```bash
# 指定输入文件nwesside-ng -i capture.cap -w wordlist.txt wlan0mon

# 指定输出文件nwesside-ng -o result.txt -a <AP MAC> -e <ESSID> -c <频道> wlan0mon

# 批量破解
for ap in $(airodump-ng wlan0mon | grep "WPA" | cut -d " " -f 1); do wesside-ng -a $ap wlan0mon; done
```

### 实际应用
```bash
# 自动破解WPA/WPA2网络
# 1. 启动wesside-ngnwesside-ng wlan0mon

# 2. 选择目标AP
# wesside-ng会自动扫描并显示AP列表，选择要破解的AP

# 3. 等待破解完成
# wesside-ng会自动捕获握手包并破解密码

# 4. 建立连接
# 破解成功后，wesside-ng会自动建立与AP的连接

# 5. 测试连接
ping 192.168.1.1
```

## 适用场景

### 无线渗透测试
- 测试WPA/WPA2加密的安全性
- 自动破解WPA/WPA2密码
- 获取网络访问权限
- 评估无线防御能力

### 网络安全审计
- 评估无线网络的安全性
- 检测WPA/WPA2漏洞
- 测试密码强度
- 提供安全加固建议

### 教育和研究
- 学习WPA/WPA2破解技术
- 研究无线安全
- 开发无线安全工具
- 测试无线防御措施

### 安全意识培训
- 演示弱密码的风险
- 教育用户使用强密码
- 提高用户的安全意识
- 推广安全最佳实践

## 高级技巧

### 与其他工具结合
```bash
# 结合airodump-ng使用
aio dump-ng --bssid <AP MAC> --channel <频道> -w capture wlan0monnwesside-ng -i capture-01.cap -w wordlist.txt wlan0mon

# 结合aircrack-ng使用
aio dump-ng --bssid <AP MAC> --channel <频道> -w capture wlan0mon
aircrack-ng -w wordlist.txt capture-01.cap
# 破解成功后nwesside-ng -a <AP MAC> -e <ESSID> -c <频道> wlan0mon

# 结合aireplay-ng使用
aio dump-ng --bssid <AP MAC> --channel <频道> -w capture wlan0mon
aireplay-ng --deauth 10 -a <AP MAC> wlan0monnwesside-ng -i capture-01.cap -w wordlist.txt wlan0mon
```

### 性能优化
- 使用高性能无线网卡
- 确保无线网卡驱动支持注入
- 使用高效的字典文件
- 选择信号强度好的AP

### 安全注意事项
- 获得授权后再进行测试
- 避免攻击他人的无线网络
- 遵守相关法律法规
- 控制攻击强度，避免网络中断

## 常见问题解决

- **问题**：无法捕获握手包
  **解决方法**：尝试使用aireplay-ng发送解除认证帧，强制客户端重连，确保客户端正在使用网络

- **问题**：破解失败
  **解决方法**：使用更大的字典文件，尝试使用不同的字典，确保密码在字典中

- **问题**：无法建立连接
  **解决方法**：确保密码正确，验证AP是否正常工作，尝试重新连接

- **问题**：性能问题
  **解决方法**：优化系统资源，使用高性能计算机，减少同时破解的AP数量

## 总结
wesside-ng是一款功能强大、自动化的WPA/WPA2破解工具，是Aircrack-ng套件中的重要组成部分。通过掌握wesside-ng的使用方法，安全专业人员可以更有效地测试WPA/WPA2加密的安全性、自动破解WPA/WPA2密码、获取网络访问权限和进行无线渗透测试。

wesside-ng的优势在于：
- 自动化破解过程
- 自动建立连接
- 操作简单
- 与其他Aircrack-ng工具的良好集成
- 开源免费

作为无线渗透测试的重要工具，wesside-ng是每个安全专业人员必备的工具之一。