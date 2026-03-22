# ifconfig - 配置网络接口

## 1. 命令简介
ifconfig 命令用于配置网络接口，是 Linux 系统中常用的网络工具命令之一。

## 2. 命令语法
```bash
ifconfig [接口] [选项] [地址]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| up | 启用接口 |
| down | 禁用接口 |
| netmask | 设置子网掩码 |
| broadcast | 设置广播地址 |
| hw | 设置硬件地址 |
| mtu | 设置MTU值 |
| --help | 显示帮助信息 |
| --version | 显示版本信息 |

## 4. 实战示例

### 4.1 显示所有网络接口
```bash
ifconfig
```

### 4.2 启用网络接口
```bash
ifconfig eth0 up
```

### 4.3 禁用网络接口
```bash
ifconfig eth0 down
```

### 4.4 设置IP地址
```bash
ifconfig eth0 192.168.1.100 netmask 255.255.255.0
```

## 5. 注意事项
- ifconfig 命令用于配置网络接口，包括IP地址、子网掩码等
- ifconfig 命令在现代 Linux 系统中已被 ip 命令替代，但仍然被广泛使用
- ifconfig 命令需要 root 权限
- ifconfig 命令是一个常用的网络工具，用于网络配置