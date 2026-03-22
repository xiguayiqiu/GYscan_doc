# sysctl - 控制系统参数

## 1. 命令简介
sysctl 命令用于控制系统内核参数，是 Linux 系统中最常用的系统配置工具之一。

## 2. 命令语法
```bash
sysctl [选项] [参数]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -a | 显示所有系统参数 |
| -w | 设置系统参数 |
| -p | 从配置文件加载参数 |
| -n | 仅显示参数值，不显示参数名 |

## 4. 实战示例

### 4.1 显示所有系统参数
```bash
sysctl -a
```

### 4.2 显示指定参数
```bash
sysctl net.ipv4.ip_forward
```

### 4.3 设置系统参数
```bash
sudo sysctl -w net.ipv4.ip_forward=1
```

### 4.4 从配置文件加载参数
```bash
sudo sysctl -p
```

### 4.5 仅显示参数值
```bash
sysctl -n net.ipv4.ip_forward
```

## 5. 注意事项
- 修改系统参数需要 root 权限，使用 sudo 执行
- 系统参数通常存储在 /etc/sysctl.conf 文件中
- 有些参数修改后需要重启系统才能生效