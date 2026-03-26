# btmon - 蓝牙监控工具

## 1. 命令简介
btmon 是 BlueZ 蓝牙协议栈的监控工具，用于监控蓝牙设备的通信和事件。它可以实时显示蓝牙控制器的所有活动，包括 HCI 命令、事件、数据传输等，是调试蓝牙问题的重要工具。

## 2. 命令语法
```bash
btmon [选项]
btmon [选项] -i <索引>
btmon [选项] -a <地址>
```

## 3. 常用选项

| 选项 | 说明 |
|------|------|
| -h, --help | 显示帮助信息 |
| -i, --index <index> | 指定控制器索引 |
| -a, --adapter <addr> | 指定控制器地址 |
| -t, --time | 显示时间戳 |
| -w, --write <file> | 写入到文件 |
| -r, --read <file> | 从文件读取 |
| -s, --sco | 显示 SCO 包 |
| -H, --no-hci | 不显示 HCI 事件 |
| -P, --no-poll | 不显示轮询事件 |
| -S, --no-sco | 不显示 SCO 包 |
| -C, --no-ctrl | 不显示控制包 |
| -A, --no-acl | 不显示 ACL 包 |
| -l, --level <level> | 设置日志级别（0-4） |
| -v, --version | 显示版本信息 |

## 4. 实战示例

### 4.1 监控蓝牙活动
```bash
btmon
```

### 4.2 显示时间戳
```bash
btmon --time
```

### 4.3 写入到文件
```bash
btmon --write bluetooth.log
```

### 4.4 从文件读取
```bash
btmon --read bluetooth.log
```

### 4.5 监控特定控制器
```bash
btmon --index 0
```

### 4.6 监控特定控制器（按地址）
```bash
btmon --adapter XX:XX:XX:XX:XX:XX
```

### 4.7 只显示错误信息
```bash
btmon --time | grep "Error"
```

### 4.8 监控并保存到文件
```bash
btmon --time --write bluetooth-debug.log
```

## 5. 高级用法

### 5.1 过滤特定事件
```bash
# 过滤 HCI 命令
btmon | grep "HCI Command"

# 过滤连接事件
btmon | grep "Connect"

# 过滤错误事件
btmon | grep "Error"
```

### 5.2 分析蓝牙连接问题
```bash
# 监控连接过程并保存
btmon --time --write connection.log

# 分析连接日志
btmon --read connection.log | grep -A 5 -B 5 "Connect"
```

### 5.3 监控低功耗蓝牙
```bash
# 监控低功耗蓝牙事件
btmon | grep "LE"
```

### 5.4 实时监控与分析
```bash
# 实时监控并显示时间戳
btmon --time | tee bluetooth.log

# 同时分析错误
btmon --time | tee bluetooth.log | grep "Error"
```

### 5.5 批量分析日志
```bash
# 分析保存的日志文件
btmon --read bluetooth.log | grep "Error" > error.log

# 统计错误类型
cat error.log | sort | uniq -c
```

## 6. 输出解读

### 6.1 输出格式
btmon 的输出包含以下信息：
- **时间戳**：事件发生的时间
- **控制器**：事件来自哪个蓝牙控制器
- **事件类型**：如 HCI 命令、事件、ACL 数据等
- **详细信息**：事件的具体内容

### 6.2 常见事件类型
| 事件类型 | 说明 |
|----------|------|
| HCI Command | 主机发送给控制器的命令 |
| HCI Event | 控制器发送给主机的事件 |
| ACL Data | 异步无连接数据 |
| SCO Data | 同步连接导向数据 |
| LE Event | 低功耗蓝牙事件 |

### 6.3 示例输出
```
> HCI Event: Command Complete (0x0e) plen 10
    Write Local Name (0x03|0x0013) ncmd 1
    Status: Success (0x00)

> HCI Event: Command Complete (0x0e) plen 4
    Set Discoverable (0x03|0x001a) ncmd 1
    Status: Success (0x00)

> HCI Event: LE Meta Event (0x3e) plen 12
    LE Advertising Report (0x02)
    Num reports: 1
    Event type: Scan response (0x04)
    Address type: Public (0x00)
    Address: XX:XX:XX:XX:XX:XX
    Data length: 7
    Flags: 0x06
    Name (complete): Device Name
```

## 7. 常见问题与解决方案

### 7.1 问题：btmon: command not found
**解决方案**：安装 BlueZ 工具包
- Ubuntu/Debian: `apt install bluez`
- CentOS/RHEL: `yum install bluez`
- macOS: `brew install bluez`

### 7.2 问题：No controller available
**解决方案**：确保蓝牙适配器已启用
```bash
# 检查蓝牙服务状态
systemctl status bluetooth

# 启动蓝牙服务
systemctl start bluetooth
```

### 7.3 问题：Permission denied
**解决方案**：使用 root 权限执行命令
```bash
sudo btmon
```

### 7.4 问题：日志文件过大
**解决方案**：限制日志大小或使用过滤
```bash
# 只记录错误信息
btmon --time | grep "Error" > error.log

# 使用旋转日志
btmon --time | logrotate -f /etc/logrotate.d/btmon
```

### 7.5 问题：无法识别蓝牙设备
**解决方案**：
1. 检查蓝牙适配器是否正常
2. 确保设备处于可发现模式
3. 使用 btmon 监控扫描过程，查看是否有设备响应

## 8. 命令对比

| 命令 | 功能 | 适用场景 |
|------|------|----------|
| btmon | 蓝牙监控工具 | 蓝牙通信监控和调试 |
| bluetoothctl | 蓝牙控制工具 | 交互式蓝牙管理 |
| btmgmt | 蓝牙管理工具 | 低级蓝牙管理 |
| hcitool | 蓝牙诊断工具 | 蓝牙设备诊断 |
| hciconfig | 蓝牙接口配置工具 | 蓝牙接口配置 |
| rfcomm | 蓝牙串口通信工具 | 蓝牙串口连接 |

## 9. 注意事项
- btmon 是 BlueZ 蓝牙协议栈的监控工具，用于监控蓝牙设备的通信和事件
- 它可以实时显示蓝牙控制器的所有活动，包括 HCI 命令、事件、数据传输等
- 常用的操作包括：实时监控、保存日志、分析问题等
- 在使用 btmon 时，可能需要 root 权限才能访问蓝牙设备
- 对于蓝牙问题，btmon 是最强大的调试工具之一，可以帮助定位各种蓝牙通信问题
- btmon 的输出可能会非常详细，建议使用过滤功能来关注特定的事件
- 可以将 btmon 的输出保存到文件中，以便后续分析
- 对于低功耗蓝牙问题，可以使用 btmon 监控 LE 事件
- 蓝牙设备的通信是实时的，btmon 可以捕获所有的蓝牙数据包
- 在分析蓝牙问题时，建议同时使用 bluetoothctl 进行操作，使用 btmon 进行监控