# hcitool - 蓝牙诊断工具

## 1. 命令简介
hcitool 是 BlueZ 蓝牙协议栈的诊断工具，用于执行各种蓝牙相关的操作。它提供了丰富的命令来管理和诊断蓝牙设备，包括扫描、查询、连接、认证等功能。

## 2. 命令语法
```bash
hcitool [选项] <命令> [参数...]
hcitool [选项] -i <hciX> <命令> [参数...]
```

## 3. 常用选项

| 选项 | 说明 |
|------|------|
| -h | 显示帮助信息 |
| -i <hciX> | 指定蓝牙接口（如 hci0） |
| -v | 显示版本信息 |

## 4. 常用命令

### 4.1 设备管理命令
| 命令 | 说明 |
|------|------|
| `dev` | 显示本地蓝牙设备 |
| `scan` | 扫描附近的蓝牙设备 |
| `inq` | 搜索附近的蓝牙设备（经典蓝牙） |
| `lescan` | 扫描低功耗蓝牙设备 |
| `info <addr>` | 显示设备详细信息 |
| `name <addr>` | 获取设备名称 |
| `type <addr>` | 获取设备类型 |
| `features <addr>` | 获取设备特性 |
| `spinq` | 启动周期性搜索 |

### 4.2 连接管理命令
| 命令 | 说明 |
|------|------|
| `conninfo` | 显示连接信息 |
| `auth <addr>` | 认证设备 |
| `enc <addr>` | 加密连接 |
| `key <addr>` | 显示链接密钥 |
| `lq <addr>` | 显示链接质量 |
| `tpl <addr>` | 显示传输功率级别 |
| `afh <addr>` | 显示自适应跳频信息 |

### 4.3 高级命令
| 命令 | 说明 |
|------|------|
| `cmd <ogf> <ocf> [parameters]` | 发送 HCI 命令 |
| `raw` | 发送原始 HCI 命令 |
| `up` | 开启蓝牙接口 |
| `down` | 关闭蓝牙接口 |
| `reset` | 重置蓝牙接口 |

## 5. 实战示例

### 5.1 显示本地蓝牙设备
```bash
hcitool dev
```

### 5.2 扫描附近的蓝牙设备
```bash
hcitool scan
```

### 5.3 扫描低功耗蓝牙设备
```bash
hcitool lescan
```

### 5.4 显示设备信息
```bash
hcitool info XX:XX:XX:XX:XX:XX
```

### 5.5 获取设备名称
```bash
hcitool name XX:XX:XX:XX:XX:XX
```

### 5.6 显示设备特性
```bash
hcitool features XX:XX:XX:XX:XX:XX
```

### 5.7 发送 HCI 命令
```bash
hcitool cmd 0x03 0x0001
```

### 5.8 显示连接信息
```bash
hcitool conninfo
```

### 5.9 认证设备
```bash
hcitool auth XX:XX:XX:XX:XX:XX
```

### 5.10 加密连接
```bash
hcitool enc XX:XX:XX:XX:XX:XX
```

## 6. 高级用法

### 6.1 扫描并显示设备信息
```bash
hcitool scan | grep -v "Scanning" | while read addr name; do
echo "Device: $name ($addr)"
hcitool info $addr
done
```

### 6.2 检查蓝牙设备连接状态
```bash
hcitool dev && hcitool conninfo
```

### 6.3 监控蓝牙设备
```bash
# 持续扫描设备
hcitool lescan --duplicates
```

### 6.4 发送自定义 HCI 命令
```bash
# 读取蓝牙设备地址
hcitool cmd 0x03 0x0001

# 设置蓝牙设备名称
hcitool cmd 0x03 0x0013 0x0C 0x4D 0x79 0x20 0x42 0x6C 0x75 0x65 0x74 0x6F 0x6F 0x74 0x68
```

### 6.5 批量设备信息收集
```bash
#!/bin/bash

echo "Scanning for Bluetooth devices..."
devices=$(hcitool scan | grep -v "Scanning")

if [ -z "$devices" ]; then
    echo "No devices found"
    exit 1
fi

echo "\nCollecting device information..."
echo "=================================="

while read addr name; do
    echo "\nDevice: $name"
    echo "Address: $addr"
    echo "----------------------------------"
    hcitool info $addr
    echo "----------------------------------"
done <<< "$devices"
```

## 7. 常见问题与解决方案

### 7.1 问题：hcitool: command not found
**解决方案**：安装 BlueZ 工具包
- Ubuntu/Debian: `apt install bluez`
- CentOS/RHEL: `yum install bluez`
- macOS: `brew install bluez`

### 7.2 问题：No such device
**解决方案**：确保蓝牙适配器已启用
```bash
# 检查蓝牙服务状态
systemctl status bluetooth

# 启动蓝牙服务
systemctl start bluetooth

# 开启蓝牙接口
hciconfig hci0 up
```

### 7.3 问题：Operation not permitted
**解决方案**：使用 root 权限执行命令
```bash
sudo hcitool scan
```

### 7.4 问题：Scanning... Inquiry failed: Input/output error
**解决方案**：
1. 检查蓝牙适配器是否正常
2. 尝试重置蓝牙接口
```bash
hciconfig hci0 down
hciconfig hci0 reset
hciconfig hci0 up
```

### 7.5 问题：Could not create connection: Connection timed out
**解决方案**：
1. 确保设备在范围内且处于可连接状态
2. 检查设备是否已配对
3. 尝试靠近设备以获得更好的信号

### 7.6 问题：Device is not available: No such device
**解决方案**：确保指定的蓝牙设备地址正确，并且设备在范围内

## 8. 命令对比

| 命令 | 功能 | 适用场景 |
|------|------|----------|
| hcitool | 蓝牙诊断工具 | 蓝牙设备诊断和调试 |
| bluetoothctl | 蓝牙控制工具 | 交互式蓝牙管理 |
| btmgmt | 蓝牙管理工具 | 低级蓝牙管理 |
| btmon | 蓝牙监控工具 | 蓝牙通信监控 |
| hciconfig | 蓝牙接口配置工具 | 蓝牙接口配置 |
| hciattach | 蓝牙设备附加工具 | 串口蓝牙设备初始化 |

## 9. 注意事项
- hcitool 是 BlueZ 蓝牙协议栈的诊断工具，用于执行各种蓝牙相关的操作
- 它提供了丰富的命令来管理和诊断蓝牙设备，包括扫描、查询、连接、认证等功能
- 常用的操作包括：扫描设备、显示设备信息、发送 HCI 命令等
- 在使用 hcitool 时，可能需要 root 权限才能执行某些操作
- hcitool 命令已经逐渐被 bluetoothctl 和 btmgmt 命令取代，但在许多系统中仍然可用
- 对于低功耗蓝牙设备，应该使用 `lescan` 命令而不是 `scan` 命令
- 蓝牙设备地址格式为 XX:XX:XX:XX:XX:XX，其中 XX 是十六进制数字
- 发送 HCI 命令需要了解蓝牙 HCI 协议的相关知识
- 对于现代蓝牙设备管理，推荐使用 bluetoothctl 命令
- 在诊断蓝牙问题时，hcitool 仍然是一个非常有用的工具，可以提供详细的设备信息