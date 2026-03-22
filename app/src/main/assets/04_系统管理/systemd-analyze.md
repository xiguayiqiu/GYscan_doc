# systemd-analyze - 分析系统启动时间

## 1. 命令简介
systemd-analyze 命令用于分析系统启动时间，是 Linux 系统中常用的系统管理命令之一。

## 2. 命令语法
```bash
systemd-analyze [选项] [命令]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -h | 显示帮助信息 |
| --version | 显示版本信息 |

## 4. 常用命令
| 命令 | 说明 |
|------|------|
| time | 显示启动时间 |
| blame | 显示每个服务的启动时间 |
| critical-chain | 显示关键启动链 |
| plot | 生成启动时间图表 |

## 5. 实战示例

### 5.1 显示启动时间
```bash
systemd-analyze time
```

### 5.2 显示每个服务的启动时间
```bash
systemd-analyze blame
```

### 5.3 显示关键启动链
```bash
systemd-analyze critical-chain
```

### 5.4 生成启动时间图表
```bash
systemd-analyze plot > boot.svg
```

## 6. 注意事项
- systemd-analyze 命令用于分析系统启动时间
- systemd-analyze 命令是 systemd 系统的一部分
- systemd-analyze 命令可以帮助识别启动过程中的瓶颈
- systemd-analyze 命令是一个常用的系统管理工具，用于优化系统启动时间