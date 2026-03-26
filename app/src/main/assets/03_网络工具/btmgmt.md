# btmgmt - 蓝牙管理工具

## 1. 命令简介
btmgmt 是 BlueZ 蓝牙协议栈的管理工具，用于管理蓝牙控制器和设备。它提供了低级别的蓝牙管理功能，可以配置蓝牙控制器的各种参数和状态。

## 2. 命令语法
```bash
btmgmt [选项] [命令] [参数...]
btmgmt [选项] -i <索引> [命令] [参数...]
```

## 3. 常用选项

| 选项 | 说明 |
|------|------|
| -h, --help | 显示帮助信息 |
| -i, --index <index> | 指定控制器索引 |
| -a, --adapter <addr> | 指定控制器地址 |
| -t, --timeout <timeout> | 设置超时时间（毫秒） |
| -d, --debug | 调试模式，显示详细信息 |
| -v, --version | 显示版本信息 |

## 4. 常用命令

### 4.1 控制器管理命令
| 命令 | 说明 |
|------|------|
| info | 显示控制器信息 |
| power on/off | 开启/关闭蓝牙电源 |
| discoverable on/off | 开启/关闭可发现模式 |
| pairable on/off | 开启/关闭可配对模式 |
| bondable on/off | 开启/关闭可绑定模式 |
| le on/off | 开启/关闭低功耗模式 |
| name <name> | 设置蓝牙名称 |
| class <class> | 设置设备类 |
| alias <alias> | 设置设备别名 |
| reset | 重置控制器 |
| factory-reset | 恢复出厂设置 |

### 4.2 设备管理命令
| 命令 | 说明 |
|------|------|
| find | 搜索设备 |
| connect <addr> | 连接设备 |
| disconnect <addr> | 断开连接 |
| pair <addr> | 配对设备 |
| remove <addr> | 移除设备 |
| block <addr> | 阻止设备 |
| unblock <addr> | 取消阻止设备 |
| info <addr> | 显示设备信息 |

### 4.3 高级命令
| 命令 | 说明 |
|------|------|
| security on/off | 开启/关闭安全模式 |
| ssp on/off | 开启/关闭安全简单配对 |
| bredr on/off | 开启/关闭经典蓝牙 |
| privacy on/off | 开启/关闭隐私模式 |
| scan on/off | 开启/关闭扫描 |
| connectable on/off | 开启/关闭可连接模式 |
| advertising on/off | 开启/关闭广播 |

## 5. 实战示例

### 5.1 显示所有蓝牙控制器
```bash
btmgmt info
```

### 5.2 开启蓝牙电源
```bash
btmgmt power on
```

### 5.3 关闭蓝牙电源
```bash
btmgmt power off
```

### 5.4 开启可发现模式
```bash
btmgmt discoverable on
```

### 5.5 关闭可发现模式
```bash
btmgmt discoverable off
```

### 5.6 开启可配对模式
```bash
btmgmt pairable on
```

### 5.7 关闭可配对模式
```bash
btmgmt pairable off
```

### 5.8 搜索设备
```bash
btmgmt find
```

### 5.9 设置蓝牙名称
```bash
btmgmt name "My Bluetooth Device"
```

### 5.10 重置蓝牙控制器
```bash
btmgmt reset
```

## 6. 高级用法

### 6.1 配置蓝牙控制器
```bash
# 开启蓝牙电源
btmgmt power on

# 开启可发现模式
btmgmt discoverable on

# 开启可配对模式
btmgmt pairable on

# 开启低功耗模式
btmgmt le on

# 设置蓝牙名称
btmgmt name "My Bluetooth Device"
```

### 6.2 设备管理
```bash
# 搜索设备
btmgmt find

# 配对设备
btmgmt pair XX:XX:XX:XX:XX:XX

# 连接设备
btmgmt connect XX:XX:XX:XX:XX:XX

# 断开连接
btmgmt disconnect XX:XX:XX:XX:XX:XX

# 移除设备
btmgmt remove XX:XX:XX:XX:XX:XX
```

### 6.3 高级配置
```bash
# 开启安全模式
btmgmt security on

# 开启安全简单配对
btmgmt ssp on

# 开启隐私模式
btmgmt privacy on

# 开启广播
btmgmt advertising on
```

### 6.4 蓝牙控制器诊断
```bash
# 显示控制器详细信息
btmgmt info -i 0

# 重置控制器
btmgmt reset -i 0

# 恢复出厂设置
btmgmt factory-reset -i 0
```

## 7. 常见问题与解决方案

### 7.1 问题：btmgmt: command not found
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

### 7.3 问题：Failed to set power on: Input/output error
**解决方案**：
1. 检查蓝牙适配器是否被正确识别
2. 尝试重启蓝牙服务
3. 检查蓝牙适配器硬件是否正常

### 7.4 问题：Failed to find device
**解决方案**：
1. 确保设备处于可发现模式
2. 确保蓝牙适配器工作正常
3. 尝试靠近设备以获得更好的信号

### 7.5 问题：Permission denied
**解决方案**：使用 root 权限执行命令
```bash
sudo btmgmt power on
```

## 8. 命令对比

| 命令 | 功能 | 适用场景 |
|------|------|----------|
| btmgmt | 蓝牙管理工具 | 低级蓝牙管理 |
| bluetoothctl | 蓝牙控制工具 | 交互式蓝牙管理 |
| btmon | 蓝牙监控工具 | 蓝牙通信监控 |
| hcitool | 蓝牙诊断工具 | 蓝牙设备诊断 |
| hciconfig | 蓝牙接口配置工具 | 蓝牙接口配置 |
| rfcomm | 蓝牙串口通信工具 | 蓝牙串口连接 |

## 9. 注意事项
- btmgmt 是 BlueZ 蓝牙协议栈的管理工具，用于管理蓝牙控制器和设备
- 它提供了低级别的蓝牙管理功能，可以配置蓝牙控制器的各种参数和状态
- 常用的操作包括：开启/关闭蓝牙、配置可发现模式、配置可配对模式、搜索设备、连接设备等
- 蓝牙设备地址格式为 XX:XX:XX:XX:XX:XX，其中 XX 是十六进制数字
- 在使用 btmgmt 时，可能需要 root 权限才能执行某些操作
- 对于蓝牙问题，可以使用 btmon 工具查看详细的蓝牙通信日志
- btmgmt 命令可以通过 -i 选项指定控制器索引，适用于多蓝牙适配器的场景
- 蓝牙设备的连接距离有限，通常在 10 米以内
- 在配置蓝牙控制器时，应该注意不要同时使用多个蓝牙管理工具，以免产生冲突