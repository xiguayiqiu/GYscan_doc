# systemd-run - 运行命令

## 1. 命令简介
systemd-run 命令用于运行命令，是 Linux 系统中常用的系统管理命令之一。

## 2. 命令语法
```bash
systemd-run [选项] [命令]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| --unit | 指定单元名称 |
| --user | 在用户模式下运行 |
| --system | 在系统模式下运行 |
| --scope | 创建作用域单元 |
| --service | 创建服务单元 |
| --slice | 指定切片 |
| --property | 设置单元属性 |
| --timer | 创建定时器单元 |
| --on-active | 指定定时器触发时间 |
| --on-boot | 指定启动后触发时间 |
| --on-startup | 指定系统启动后触发时间 |
| --help | 显示帮助信息 |

## 4. 实战示例

### 4.1 运行命令
```bash
systemd-run --user command
```

### 4.2 创建作用域单元
```bash
systemd-run --scope command
```

### 4.3 创建服务单元
```bash
systemd-run --service command
```

### 4.4 设置单元属性
```bash
systemd-run --property=CPUQuota=50% command
```

### 4.5 创建定时器单元
```bash
systemd-run --timer --on-active=10s command
```

## 5. 注意事项
- systemd-run 命令是 systemd 系统的一部分，用于运行命令
- 使用 --user 选项可以在用户模式下运行命令
- 使用 --system 选项可以在系统模式下运行命令
- 使用 --scope 选项可以创建作用域单元，用于管理一组进程
- 使用 --service 选项可以创建服务单元，用于管理长时间运行的进程
- 使用 --timer 选项可以创建定时器单元，用于在指定时间运行命令