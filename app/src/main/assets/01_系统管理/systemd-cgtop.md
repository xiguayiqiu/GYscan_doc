# systemd-cgtop - 显示控制组资源使用情况

## 1. 命令简介
systemd-cgtop 命令用于显示控制组资源使用情况，是 Linux 系统中常用的系统管理命令之一。

## 2. 命令语法
```bash
systemd-cgtop [选项]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -h | 显示帮助信息 |
| -p | 显示PID |
| -t | 显示CPU时间 |
| --help | 显示帮助信息 |
| --version | 显示版本信息 |

## 4. 实战示例

### 4.1 显示控制组资源使用情况
```bash
systemd-cgtop
```

### 4.2 显示PID
```bash
systemd-cgtop -p
```

### 4.3 显示CPU时间
```bash
systemd-cgtop -t
```

## 5. 注意事项
- systemd-cgtop 命令用于显示控制组资源使用情况，是 systemd 系统的一部分
- systemd-cgtop 命令可以实时显示控制组的CPU、内存和I/O使用情况
- systemd-cgtop 命令是一个常用的系统管理工具，用于资源监控