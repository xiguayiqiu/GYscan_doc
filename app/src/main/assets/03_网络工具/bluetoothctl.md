# bluetoothctl - 蓝牙控制工具

## 1. 命令简介
bluetoothctl 是 BlueZ 蓝牙协议栈的命令行工具，用于管理蓝牙设备和连接。它提供了交互式界面和命令行参数两种操作方式，可以执行蓝牙设备的扫描、配对、连接、断开等操作。

## 2. 命令语法
```bash
bluetoothctl [选项]
bluetoothctl [命令] [参数...]
```

## 3. 常用选项

| 选项 | 说明 |
|------|------|
| -h, --help | 显示帮助信息 |
| --version | 显示版本信息 |
| -a, --agent | 启动内置代理 |
| -m, --monitor | 监控模式，显示所有事件 |
| -d, --debug | 调试模式，显示详细信息 |
| -E, --experimental | 启用实验性功能 |
| -i, --adapter ADAPTER | 指定蓝牙适配器 |

## 4. 交互式命令

### 4.1 基本命令
| 命令 | 说明 |
|------|------|
| help | 显示帮助信息 |
| list | 列出所有蓝牙控制器 |
| show [ctrl] | 显示控制器信息 |
| scan on/off | 开启/关闭扫描 |
| devices | 列出已发现的设备 |
| devices Paired | 列出已配对的设备 |
| devices Trusted | 列出已信任的设备 |
| info [dev] | 显示设备详细信息 |
| pair [dev] | 配对设备 |
| trust [dev] | 信任设备 |
| untrust [dev] | 取消信任设备 |
| connect [dev] | 连接设备 |
| disconnect [dev] | 断开连接 |
| remove [dev] | 移除设备 |
| power on/off | 开启/关闭蓝牙电源 |
| agent on/off | 开启/关闭代理 |
| default-agent | 设置默认代理 |
| quit | 退出 bluetoothctl |

### 4.2 高级命令
| 命令 | 说明 |
|------|------|
| select [ctrl] | 选择蓝牙控制器 |
| discoverable on/off | 开启/关闭可发现模式 |
| pairable on/off | 开启/关闭可配对模式 |
| name [name] | 设置蓝牙名称 |
| class [class] | 设置设备类 |
| alias [alias] | 设置设备别名 |
| block [dev] | 阻止设备 |
| unblock [dev] | 取消阻止设备 |
| system-alias [alias] | 设置系统别名 |
| pscan on/off | 开启/关闭页面扫描 |
| iscan on/off | 开启/关闭查询扫描 |

## 5. 实战示例

### 5.1 启动 bluetoothctl
```bash
bluetoothctl
```

### 5.2 开启蓝牙扫描
```bash
bluetoothctl scan on
```

### 5.3 配对设备
```bash
bluetoothctl pair XX:XX:XX:XX:XX:XX
```

### 5.4 信任设备
```bash
bluetoothctl trust XX:XX:XX:XX:XX:XX
```

### 5.5 连接设备
```bash
bluetoothctl connect XX:XX:XX:XX:XX:XX
```

### 5.6 断开连接
```bash
bluetoothctl disconnect XX:XX:XX:XX:XX:XX
```

### 5.7 查看蓝牙状态
```bash
bluetoothctl show
```

### 5.8 列出已配对设备
```bash
bluetoothctl devices Paired
```

### 5.9 设置蓝牙名称
```bash
bluetoothctl name "My Bluetooth Device"
```

### 5.10 启用可发现模式
```bash
bluetoothctl discoverable on
```

## 6. 高级用法

### 6.1 完整的设备连接过程
```bash
# 启动 bluetoothctl
bluetoothctl

# 开启蓝牙电源
power on

# 开启可发现模式
discoverable on

# 开启扫描
scan on

# 等待发现设备后，配对设备
pair XX:XX:XX:XX:XX:XX

# 信任设备
trust XX:XX:XX:XX:XX:XX

# 连接设备
connect XX:XX:XX:XX:XX:XX

# 退出
exit
```

### 6.2 批量操作设备
```bash
# 列出所有设备
bluetoothctl devices

# 批量信任设备
for addr in $(bluetoothctl devices | awk '{print $2}'); do
    bluetoothctl trust $addr
done
```

### 6.3 监控蓝牙事件
```bash
# 监控模式启动
bluetoothctl --monitor

# 或者在交互式模式下
bluetoothctl
monitor on
```

### 6.4 蓝牙设备管理脚本
```bash
#!/bin/bash

# 检查蓝牙状态
check_bluetooth_status() {
    bluetoothctl show | grep -q "Powered: yes"
    return $?
}

# 开启蓝牙
enable_bluetooth() {
    bluetoothctl power on
}

# 连接指定设备
connect_device() {
    local device_address=$1
    bluetoothctl connect $device_address
}

# 主函数
main() {
    if ! check_bluetooth_status; then
        echo "蓝牙未开启，正在开启..."
        enable_bluetooth
    fi
    
    echo "正在连接设备..."
    connect_device "XX:XX:XX:XX:XX:XX"
}

main
```

## 7. 常见问题与解决方案

### 7.1 问题：bluetoothctl: command not found
**解决方案**：安装 BlueZ 工具包
- Ubuntu/Debian: `apt install bluez`
- CentOS/RHEL: `yum install bluez`
- macOS: `brew install bluez`

### 7.2 问题：No default controller available
**解决方案**：确保蓝牙适配器已启用
```bash
# 检查蓝牙服务状态
systemctl status bluetooth

# 启动蓝牙服务
systemctl start bluetooth
```

### 7.3 问题：Failed to pair: org.bluez.Error.AuthenticationCanceled
**解决方案**：确保设备处于可配对状态，并且在配对过程中按照设备提示进行操作

### 7.4 问题：Failed to connect: org.bluez.Error.Failed
**解决方案**：
1. 确保设备已配对并被信任
2. 确保设备处于可连接状态
3. 尝试重新配对设备

### 7.5 问题：扫描不到设备
**解决方案**：
1. 确保设备处于可发现模式
2. 确保蓝牙适配器工作正常
3. 尝试重启蓝牙服务

### 7.6 问题：bluetoothctl 命令无响应
**解决方案**：
1. 检查蓝牙服务状态
2. 尝试重启蓝牙服务
3. 检查蓝牙适配器是否被正确识别

## 8. 命令对比

| 命令 | 功能 | 适用场景 |
|------|------|----------|
| bluetoothctl | 蓝牙控制工具 | 交互式蓝牙管理 |
| btmgmt | 蓝牙管理工具 | 低级蓝牙管理 |
| btmon | 蓝牙监控工具 | 蓝牙通信监控 |
| hcitool | 蓝牙诊断工具 | 蓝牙设备诊断 |
| hciconfig | 蓝牙接口配置工具 | 蓝牙接口配置 |
| rfcomm | 蓝牙串口通信工具 | 蓝牙串口连接 |

## 9. 注意事项
- bluetoothctl 是 BlueZ 蓝牙协议栈的命令行工具，用于管理蓝牙设备和连接
- 可以通过交互式命令或命令行参数两种方式操作
- 常用的操作包括：开启/关闭蓝牙、扫描设备、配对设备、连接设备、断开连接等
- 蓝牙设备地址格式为 XX:XX:XX:XX:XX:XX，其中 XX 是十六进制数字
- 在配对设备时，可能需要输入 PIN 码或按照设备提示进行操作
- 信任设备后，设备可以自动连接，无需每次手动配对
- bluetoothctl 支持监控模式，可以实时显示蓝牙事件
- 对于蓝牙问题，可以使用 btmon 工具查看详细的蓝牙通信日志
- 在某些系统上，可能需要 root 权限才能执行某些蓝牙操作
- 蓝牙设备的连接距离有限，通常在 10 米以内