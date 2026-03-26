# systemd-notify - 向systemd发送通知

## 1. 命令简介
systemd-notify 命令用于向 systemd 发送通知，是 Linux 系统中常用的系统管理命令之一。它是 systemd 系统的一部分，用于通知 systemd 服务的状态变化。

## 2. 命令语法
```bash
systemd-notify [选项]
```

## 3. 常用选项

| 选项 | 说明 |
|------|------|
| -h, --help | 显示帮助信息 |
| --version | 显示版本信息 |
| --ready | 通知服务已准备就绪 |
| --reloading | 通知服务正在重新加载 |
| --stopping | 通知服务正在停止 |
| --status=<状态> | 通知服务状态 |
| --pid=<PID> | 指定进程 ID |

## 4. 实战示例

### 4.1 通知服务已准备就绪
```bash
systemd-notify --ready
```

### 4.2 通知服务正在重新加载
```bash
systemd-notify --reloading
```

### 4.3 通知服务正在停止
```bash
systemd-notify --stopping
```

### 4.4 通知服务状态
```bash
systemd-notify --status="服务正在运行中"
```

### 4.5 指定进程 ID
```bash
systemd-notify --ready --pid=1234
```

## 5. 高级用法

### 5.1 在服务脚本中使用
```bash
#!/bin/bash

# 通知服务已启动
systemd-notify --ready

# 执行服务逻辑
while true; do
    # 通知服务状态
    systemd-notify --status="正在处理请求"
    sleep 10
done

# 通知服务正在停止
systemd-notify --stopping
```

### 5.2 与其他命令结合使用
```bash
# 启动服务并通知就绪
./start-service.sh && systemd-notify --ready

# 重新加载服务并通知
./reload-service.sh && systemd-notify --reloading
```

### 5.3 批量通知
```bash
#!/bin/bash

# 批量通知服务状态
services=("service1" "service2" "service3")

for service in "${services[@]}"; do
    echo "通知 $service 服务已就绪"
    systemd-notify --ready --pid=$(pgrep $service)
done
```

### 5.4 自动化通知
```bash
#!/bin/bash

# 自动化通知
automate_notification() {
    local action=$1
    local status=$2
    local pid=$3
    
    case $action in
        "ready")
            systemd-notify --ready --status="$status" --pid=$pid
            ;;
        "reloading")
            systemd-notify --reloading --status="$status" --pid=$pid
            ;;
        "stopping")
            systemd-notify --stopping --status="$status" --pid=$pid
            ;;
        *)
            echo "未知操作"
            ;;
    esac
}

# 使用函数
automate_notification "ready" "服务已就绪" 1234
automate_notification "reloading" "服务正在重新加载" 1234
automate_notification "stopping" "服务正在停止" 1234
```

## 6. 常见问题与解决方案

### 6.1 问题：systemd-notify: command not found
**解决方案**：安装 systemd
- Ubuntu/Debian: `apt install systemd`
- CentOS/RHEL: `yum install systemd`

### 6.2 问题：无法发送通知
**解决方案**：确保服务由 systemd 管理

### 6.3 问题：通知失败
**解决方案**：确保进程 ID 正确
```bash
systemd-notify --ready --pid=$(pgrep service)
```

### 6.4 问题：systemd-notify 命令执行缓慢
**解决方案**：检查系统负载和服务状态

### 6.5 问题：无法指定状态
**解决方案**：使用 --status 选项
```bash
systemd-notify --status="服务状态"
```

## 7. 命令对比

| 命令 | 功能 | 适用场景 |
|------|------|----------|
| systemd-notify | 向 systemd 发送通知 | systemd 系统 |
| systemctl | 控制系统和服务 | systemd 系统 |
| journalctl | 查询系统日志 | systemd 系统 |
| service | 控制系统服务 | 传统 SysV 系统 |

## 8. 注意事项
- systemd-notify 命令用于向 systemd 发送通知，是 Linux 系统中常用的系统管理命令之一
- systemd-notify 命令是 systemd 系统的一部分，用于通知 systemd 服务的状态变化
- 常用的操作包括：通知服务已准备就绪、通知服务正在重新加载、通知服务正在停止等
- systemd-notify 命令不需要 root 权限来执行
- systemd-notify 命令支持多种选项，可以根据需要选择合适的选项
- systemd-notify 命令是现代 Linux 系统的标准工具，用于向 systemd 发送服务状态通知