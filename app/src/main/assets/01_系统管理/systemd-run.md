# systemd-run - 运行命令

## 1. 命令简介
systemd-run 命令用于运行命令，是 Linux 系统中常用的系统管理命令之一。它是 systemd 系统的一部分，用于在 systemd 环境中运行命令，并创建相应的 systemd 单元。

## 2. 命令语法
```bash
systemd-run [选项] [命令]
```

## 3. 常用选项

| 选项 | 说明 |
|------|------|
| -h, --help | 显示帮助信息 |
| --version | 显示版本信息 |
| --unit=<名称> | 指定单元名称 |
| --scope | 创建作用域单元 |
| --service | 创建服务单元 |
| --timer | 创建定时器单元 |
| --on-active=<时间> | 激活后运行 |
| --on-boot=<时间> | 启动后运行 |
| --on-startup=<时间> | 启动时运行 |
| --on-calendar=<日历> | 按日历运行 |
| --user | 操作用户单元 |
| --system | 操作系统单元 |

## 4. 实战示例

### 4.1 基本用法
```bash
systemd-run --unit=mycommand command
```

### 4.2 创建作用域单元
```bash
systemd-run --scope command
```

### 4.3 创建服务单元
```bash
systemd-run --service command
```

### 4.4 创建定时器单元
```bash
systemd-run --timer --on-active=10s command
```

### 4.5 按日历运行
```bash
systemd-run --timer --on-calendar="*:0/5" command
```

## 5. 高级用法

### 5.1 管理运行的命令
```bash
# 查看运行的命令
systemctl status mycommand

# 停止运行的命令
systemctl stop mycommand

# 查看命令输出
journalctl -u mycommand
```

### 5.2 与其他命令结合使用
```bash
# 运行长时间命令
systemd-run --unit=backup --scope rsync -av /source /destination

# 运行定时命令
systemd-run --timer --on-active=5m --unit=cleanup /usr/local/bin/cleanup.sh
```

### 5.3 批量运行命令
```bash
#!/bin/bash

# 批量运行命令
commands=(
    "rsync -av /source1 /destination1"
    "rsync -av /source2 /destination2"
    "rsync -av /source3 /destination3"
)

for i in "${!commands[@]}"; do
    echo "运行命令 $i: ${commands[$i]}"
    systemd-run --unit=command$i --scope ${commands[$i]}
done
```

### 5.4 自动化运行命令
```bash
#!/bin/bash

# 自动化运行命令
automate_command() {
    local command=$1
    local unit_name=$2
    local options=${3:-}
    
    echo "运行命令: $command"
    echo "单元名称: $unit_name"
    echo "选项: $options"
    
    systemd-run $options --unit=$unit_name $command
}

# 使用函数
automate_command "rsync -av /source /destination" "backup"
automate_command "apt update && apt upgrade -y" "update" "--scope"
automate_command "/usr/local/bin/cleanup.sh" "cleanup" "--timer --on-active=3600s"
```

## 6. 常见问题与解决方案

### 6.1 问题：systemd-run: command not found
**解决方案**：安装 systemd
- Ubuntu/Debian: `apt install systemd`
- CentOS/RHEL: `yum install systemd`

### 6.2 问题：无法运行命令
**解决方案**：确保命令存在
```bash
systemd-run --unit=mycommand ls -la
```

### 6.3 问题：命令运行失败
**解决方案**：检查命令语法
```bash
systemd-run --unit=mycommand "echo hello"
```

### 6.4 问题：systemd-run 命令执行缓慢
**解决方案**：检查系统负载和服务状态

### 6.5 问题：无法创建定时器单元
**解决方案**：确保时间格式正确
```bash
systemd-run --timer --on-active=10s command
```

## 7. 命令对比

| 命令 | 功能 | 适用场景 |
|------|------|----------|
| systemd-run | 运行命令 | systemd 系统 |
| nohup | 忽略挂起信号运行命令 | 所有 Linux 系统 |
| & | 后台运行命令 | 所有 Linux 系统 |
| at | 定时运行命令 | 所有 Linux 系统 |
| cron | 定时运行命令 | 所有 Linux 系统 |

## 8. 注意事项
- systemd-run 命令用于运行命令，是 Linux 系统中常用的系统管理命令之一
- systemd-run 命令是 systemd 系统的一部分，用于在 systemd 环境中运行命令，并创建相应的 systemd 单元
- 常用的操作包括：基本用法、创建作用域单元、创建服务单元、创建定时器单元等
- systemd-run 命令不需要 root 权限来执行
- systemd-run 命令支持多种选项，可以根据需要选择合适的选项
- systemd-run 命令是现代 Linux 系统的标准工具，用于在 systemd 环境中运行命令