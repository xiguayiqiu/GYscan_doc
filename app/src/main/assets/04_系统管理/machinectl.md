# machinectl - 控制系统机器

## 1. 命令简介
machinectl 命令用于控制系统机器，是 Linux 系统中常用的系统管理命令之一。

## 2. 命令语法
```bash
machinectl [选项] [命令]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -h | 显示帮助信息 |
| --version | 显示版本信息 |

## 4. 常用命令
| 命令 | 说明 |
|------|------|
| list | 列出所有机器 |
| status | 显示机器状态 |
| start | 启动机器 |
| stop | 停止机器 |
| restart | 重启机器 |
| terminate | 终止机器 |
| login | 登录到机器 |
| shell | 在机器中运行Shell |

## 5. 实战示例

### 5.1 列出所有机器
```bash
machinectl list
```

### 5.2 显示机器状态
```bash
machinectl status machine_name
```

### 5.3 启动机器
```bash
machinectl start machine_name
```

### 5.4 停止机器
```bash
machinectl stop machine_name
```

## 6. 注意事项
- machinectl 命令用于控制系统机器，如虚拟机、容器等
- machinectl 命令是 systemd 系统的一部分
- machinectl 命令需要 root 权限
- machinectl 命令是一个常用的系统管理工具，用于管理机器