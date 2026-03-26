# hciconfig - 蓝牙接口配置工具

## 1. 命令简介
hciconfig 是 BlueZ 蓝牙协议栈的工具，用于配置蓝牙接口。它可以显示和修改蓝牙设备的各种参数，如设备名称、可发现性、电源状态等。

## 2. 命令语法
```bash
hciconfig [选项] [hciX] [命令]
hciconfig [hciX] [命令] [参数...]
```

## 3. 常用选项

| 选项 | 说明 |
|------|------|
| -a | 显示详细信息 |
| -h | 显示帮助信息 |
| -i <hciX> | 指定蓝牙接口 |

## 4. 命令参数

| 参数 | 说明 |
|------|------|
| `hciX` | 蓝牙接口名称（如 hci0、hci1 等） |
| `command` | 要执行的命令 |

## 5. 常用命令

### 5.1 基本命令
| 命令 | 说明 |
|------|------|
| `up` | 开启蓝牙接口 |
| `down` | 关闭蓝牙接口 |
| `reset` | 重置蓝牙接口 |
| `inquiry` | 搜索附近的蓝牙设备 |
| `piscan` | 启用可发现和可配对模式 |
| `noscan` | 禁用扫描模式 |
| `name <name>` | 设置蓝牙设备名称 |
| `class <class>` | 设置蓝牙设备类 |
| `revision` | 显示蓝牙设备修订版本 |

### 5.2 高级命令
| 命令 | 说明 |
|------|------|
| `sspmode <mode>` | 设置安全简单配对模式（0-禁用，1-启用） |
| `auth` | 启用认证 |
| `noauth` | 禁用认证 |
| `encrypt` | 启用加密 |
| `noencrypt` | 禁用加密 |
| `security` | 启用安全模式 |
| `nosecurity` | 禁用安全模式 |
| `iscan` | 启用查询扫描（可被发现） |
| `pscan` | 启用页面扫描（可被连接） |
| `pausefilter` | 启用暂停过滤器 |
| `nopause` | 禁用暂停过滤器 |

## 6. 实战示例

### 6.1 显示所有蓝牙接口
```bash
hciconfig
```

### 6.2 显示详细信息
```bash
hciconfig -a
```

### 6.3 开启蓝牙接口
```bash
hciconfig hci0 up
```

### 6.4 关闭蓝牙接口
```bash
hciconfig hci0 down
```

### 6.5 重置蓝牙接口
```bash
hciconfig hci0 reset
```

### 6.6 搜索附近的蓝牙设备
```bash
hciconfig hci0 inquiry
```

### 6.7 设置蓝牙设备名称
```bash
hciconfig hci0 name "My Bluetooth Device"
```

### 6.8 设置蓝牙设备类
```bash
hciconfig hci0 class 0x00200000
```

### 6.9 启用可发现和可配对模式
```bash
hciconfig hci0 piscan
```

### 6.10 禁用扫描模式
```bash
hciconfig hci0 noscan
```

## 7. 高级用法

### 7.1 配置蓝牙设备
```bash
# 开启蓝牙接口
hciconfig hci0 up

# 设置设备名称
hciconfig hci0 name "My Bluetooth Device"

# 设置设备类
hciconfig hci0 class 0x00200000

# 启用可发现和可配对模式
hciconfig hci0 piscan

# 启用安全模式
hciconfig hci0 security
```

### 7.2 重置蓝牙设备
```bash
# 关闭蓝牙接口
hciconfig hci0 down

# 重置蓝牙接口
hciconfig hci0 reset

# 开启蓝牙接口
hciconfig hci0 up

# 启用可发现模式
hciconfig hci0 piscan
```

### 7.3 管理多个蓝牙接口
```bash
# 显示所有蓝牙接口
hciconfig

# 配置第一个蓝牙接口
hciconfig hci0 up

# 配置第二个蓝牙接口
hciconfig hci1 up

# 分别设置名称
hciconfig hci0 name "Device 1"
hciconfig hci1 name "Device 2"
```

### 7.4 安全设置
```bash
# 启用认证
hciconfig hci0 auth

# 启用加密
hciconfig hci0 encrypt

# 启用安全模式
hciconfig hci0 security

# 启用安全简单配对
hciconfig hci0 sspmode 1
```

## 8. 常见问题与解决方案

### 8.1 问题：hciconfig: command not found
**解决方案**：安装 BlueZ 工具包
- Ubuntu/Debian: `apt install bluez`
- CentOS/RHEL: `yum install bluez`
- macOS: `brew install bluez`

### 8.2 问题：Can't get device info: No such device
**解决方案**：确保蓝牙适配器已正确安装和识别
```bash
# 检查蓝牙设备
hciconfig -a

# 如果没有设备，检查蓝牙服务状态
systemctl status bluetooth
```

### 8.3 问题：Operation not permitted
**解决方案**：使用 root 权限执行命令
```bash
sudo hciconfig hci0 up
```

### 8.4 问题：Device or resource busy
**解决方案**：确保蓝牙设备未被其他进程占用
```bash
# 检查蓝牙服务状态
systemctl status bluetooth

# 重启蓝牙服务
systemctl restart bluetooth
```

### 8.5 问题：Failed to set scan parameters: Input/output error
**解决方案**：
1. 检查蓝牙适配器是否正常
2. 尝试重置蓝牙接口
```bash
hciconfig hci0 down
hciconfig hci0 reset
hciconfig hci0 up
```

### 8.6 问题：Inquiry failed: Input/output error
**解决方案**：
1. 确保蓝牙接口已开启
2. 检查蓝牙适配器硬件是否正常
3. 尝试重置蓝牙接口

## 9. 命令对比

| 命令 | 功能 | 适用场景 |
|------|------|----------|
| hciconfig | 蓝牙接口配置工具 | 蓝牙接口参数配置 |
| bluetoothctl | 蓝牙控制工具 | 交互式蓝牙管理 |
| btmgmt | 蓝牙管理工具 | 低级蓝牙管理 |
| btmon | 蓝牙监控工具 | 蓝牙通信监控 |
| hcitool | 蓝牙诊断工具 | 蓝牙设备诊断 |
| hciattach | 蓝牙设备附加工具 | 串口蓝牙设备初始化 |

## 10. 注意事项
- hciconfig 是 BlueZ 蓝牙协议栈的工具，用于配置蓝牙接口
- 它可以显示和修改蓝牙设备的各种参数，如设备名称、可发现性、电源状态等
- 常用的操作包括：开启/关闭蓝牙接口、重置蓝牙接口、搜索设备、设置设备名称等
- 在使用 hciconfig 时，可能需要 root 权限才能执行某些操作
- 蓝牙设备类（class）是一个 24 位的数字，用于标识设备的类型和功能
- 可发现模式（piscan）允许其他设备发现和连接当前设备
- 蓝牙接口名称通常为 hci0、hci1 等，其中 hci0 是默认接口
- hciconfig 命令已经逐渐被 bluetoothctl 和 btmgmt 命令取代，但在许多系统中仍然可用
- 对于现代蓝牙设备管理，推荐使用 bluetoothctl 命令
- 在配置蓝牙设备时，应该注意不要同时使用多个蓝牙管理工具，以免产生冲突