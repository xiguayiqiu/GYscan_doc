# rfcomm - 蓝牙串口通信工具

## 1. 命令简介
rfcomm 是 BlueZ 蓝牙协议栈的工具，用于管理蓝牙串口通信。它可以将蓝牙设备绑定到串口设备，实现通过串口接口与蓝牙设备的通信。

## 2. 命令语法
```bash
rfcomm [选项] <命令> [参数...]
rfcomm [选项] -i <hciX> <命令> [参数...]
```

## 3. 常用选项

| 选项 | 说明 |
|------|------|
| -h, --help | 显示帮助信息 |
| -i <hciX> | 指定蓝牙接口（如 hci0） |
| -r | 原始模式，不进行流量控制 |
| -A | 绑定所有设备 |
| -a | 显示所有设备 |
| -l | 显示已绑定的设备 |
| -v | 显示详细信息 |
| -f <file> | 从文件中读取配置 |

## 4. 常用命令

| 命令 | 说明 |
|------|------|
| `bind <dev> <bdaddr>` | 绑定蓝牙设备到串口 |
| `release <dev>` | 释放绑定的设备 |
| `connect <dev> <bdaddr>` | 连接到蓝牙设备 |
| `listen <dev> [channel]` | 监听蓝牙连接 |
| `show <dev>` | 显示设备信息 |

## 5. 实战示例

### 5.1 绑定蓝牙设备到串口
```bash
rfcomm bind /dev/rfcomm0 XX:XX:XX:XX:XX:XX
```

### 5.2 释放绑定的设备
```bash
rfcomm release /dev/rfcomm0
```

### 5.3 连接到蓝牙设备
```bash
rfcomm connect /dev/rfcomm0 XX:XX:XX:XX:XX:XX
```

### 5.4 监听蓝牙连接
```bash
rfcomm listen /dev/rfcomm0
```

### 5.5 显示已绑定的设备
```bash
rfcomm -l
```

### 5.6 显示所有设备
```bash
rfcomm -a
```

### 5.7 使用原始模式连接
```bash
rfcomm -r connect /dev/rfcomm0 XX:XX:XX:XX:XX:XX
```

## 6. 高级用法

### 6.1 建立蓝牙串口连接
```bash
# 绑定蓝牙设备
rfcomm bind /dev/rfcomm0 XX:XX:XX:XX:XX:XX

# 使用串口通信
cat /dev/rfcomm0

# 释放绑定的设备
rfcomm release /dev/rfcomm0
```

### 6.2 自动连接蓝牙设备
```bash
#!/bin/bash
# 绑定蓝牙设备
rfcomm bind /dev/rfcomm0 XX:XX:XX:XX:XX:XX

# 检查连接状态
if [ $? -eq 0 ]; then
    echo "蓝牙设备已绑定到 /dev/rfcomm0"
else
    echo "绑定失败"
fi
```

### 6.3 监听特定通道
```bash
# 监听通道 1
rfcomm listen /dev/rfcomm0 1
```

### 6.4 多设备管理
```bash
# 绑定多个设备
rfcomm bind /dev/rfcomm0 XX:XX:XX:XX:XX:XX
rfcomm bind /dev/rfcomm1 YY:YY:YY:YY:YY:YY

# 显示所有绑定的设备
rfcomm -l

# 释放所有设备
rfcomm release /dev/rfcomm0
rfcomm release /dev/rfcomm1
```

### 6.5 蓝牙串口通信脚本
```bash
#!/bin/bash

# 蓝牙设备地址
BLUETOOTH_ADDR="XX:XX:XX:XX:XX:XX"
# 串口设备
SERIAL_DEV="/dev/rfcomm0"

# 绑定设备
echo "正在绑定蓝牙设备 $BLUETOOTH_ADDR 到 $SERIAL_DEV..."
rfcomm bind $SERIAL_DEV $BLUETOOTH_ADDR

if [ $? -eq 0 ]; then
    echo "绑定成功！"
    echo "可以通过 $SERIAL_DEV 与蓝牙设备通信"
    echo "按 Ctrl+C 退出..."
    
    # 读取串口数据
    cat $SERIAL_DEV
else
    echo "绑定失败，请检查设备是否可达"
    exit 1
fi

# 清理
function cleanup() {
    echo "\n正在释放绑定的设备..."
    rfcomm release $SERIAL_DEV
    echo "设备已释放"
}

# 捕获信号
trap cleanup SIGINT SIGTERM
```

## 7. 常见问题与解决方案

### 7.1 问题：rfcomm: command not found
**解决方案**：安装 BlueZ 工具包
- Ubuntu/Debian: `apt install bluez`
- CentOS/RHEL: `yum install bluez`
- macOS: `brew install bluez`

### 7.2 问题：Can't create RFCOMM TTY: Address already in use
**解决方案**：
1. 检查是否有其他进程占用了该串口
2. 释放已绑定的设备
```bash
rfcomm release /dev/rfcomm0
```

### 7.3 问题：Can't connect: Host is down
**解决方案**：
1. 确保蓝牙设备在范围内且处于开启状态
2. 确保设备已配对
3. 检查蓝牙适配器是否正常工作

### 7.4 问题：Operation not permitted
**解决方案**：使用 root 权限执行命令
```bash
sudo rfcomm bind /dev/rfcomm0 XX:XX:XX:XX:XX:XX
```

### 7.5 问题：No such device
**解决方案**：确保蓝牙适配器已启用
```bash
# 检查蓝牙服务状态
systemctl status bluetooth

# 启动蓝牙服务
systemctl start bluetooth

# 开启蓝牙接口
hciconfig hci0 up
```

### 7.6 问题：Connection refused
**解决方案**：
1. 确保设备已配对
2. 确保设备支持 RFCOMM 协议
3. 检查设备是否处于可连接状态

## 8. 命令对比

| 命令 | 功能 | 适用场景 |
|------|------|----------|
| rfcomm | 蓝牙串口通信工具 | 蓝牙串口连接 |
| bluetoothctl | 蓝牙控制工具 | 交互式蓝牙管理 |
| btmgmt | 蓝牙管理工具 | 低级蓝牙管理 |
| btmon | 蓝牙监控工具 | 蓝牙通信监控 |
| hcitool | 蓝牙诊断工具 | 蓝牙设备诊断 |
| minicom | 串口通信工具 | 串口终端通信 |

## 9. 注意事项
- rfcomm 是 BlueZ 蓝牙协议栈的工具，用于管理蓝牙串口通信
- 它可以将蓝牙设备绑定到串口设备，实现通过串口接口与蓝牙设备的通信
- 常用的操作包括：绑定设备、释放设备、连接设备、监听连接等
- 在使用 rfcomm 时，可能需要 root 权限才能执行某些操作
- 蓝牙设备地址格式为 XX:XX:XX:XX:XX:XX，其中 XX 是十六进制数字
- 绑定的串口设备通常为 /dev/rfcomm0、/dev/rfcomm1 等
- 绑定成功后，可以像使用普通串口一样使用 /dev/rfcommX 设备
- 对于需要持续通信的场景，可以使用脚本自动处理连接和重连
- 在使用蓝牙串口通信时，应该注意蓝牙设备的电量和连接距离
- 蓝牙串口通信的速率通常低于物理串口，这是正常的
- 对于蓝牙连接问题，可以结合 btmon 工具查看详细的蓝牙通信日志