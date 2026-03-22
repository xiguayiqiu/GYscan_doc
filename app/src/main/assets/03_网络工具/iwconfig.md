# iwconfig - 配置无线网络接口

## 1. 命令简介
iwconfig 命令用于配置无线网络接口，是 Linux 系统中常用的网络工具命令之一。

## 2. 命令语法
```bash
iwconfig [接口] [选项] [参数]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| essid | 设置ESSID（网络名称） |
| mode | 设置模式（Managed、Ad-Hoc、Master、Repeater、Secondary、Monitor） |
| channel | 设置信道 |
| freq | 设置频率 |
| rate | 设置传输速率 |
| power | 设置电源管理 |
| txpower | 设置传输功率 |
| enc | 设置加密密钥 |
| nick | 设置昵称 |
| ap | 设置接入点 |
| retry | 设置重试次数 |
| rts | 设置RTS/CTS阈值 |
| frag | 设置分片阈值 |

## 4. 实战示例

### 4.1 显示无线网络接口信息
```bash
iwconfig
```

### 4.2 设置ESSID
```bash
sudo iwconfig wlan0 essid "MyNetwork"
```

### 4.3 设置模式
```bash
sudo iwconfig wlan0 mode Managed
```

### 4.4 设置信道
```bash
sudo iwconfig wlan0 channel 6
```

### 4.5 设置传输速率
```bash
sudo iwconfig wlan0 rate 54M
```

### 4.6 设置加密密钥
```bash
sudo iwconfig wlan0 enc s:password
```

## 5. 注意事项
- iwconfig 命令需要 root 权限才能执行某些操作
- iwconfig 命令用于配置无线网络接口，对于有线网络接口，使用 ifconfig 命令
- iwconfig 命令的输出结果显示了无线网络接口的详细信息，包括ESSID、模式、信道、频率等