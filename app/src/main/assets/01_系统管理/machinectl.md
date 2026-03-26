# machinectl - 控制系统机器

## 1. 命令简介
machinectl 命令用于控制系统机器，是 Linux 系统中常用的系统管理命令之一。它是 systemd 系统的一部分，用于管理本地和远程的 systemd 机器。

## 2. 命令语法
```bash
machinectl [选项] [命令] [参数...]
```

## 3. 常用选项

| 选项 | 说明 |
|------|------|
| -h, --help | 显示帮助信息 |
| --version | 显示版本信息 |
| --no-pager | 不使用分页器 |
| --no-legend | 不显示图例 |

## 4. 常用命令

| 命令 | 说明 |
|------|------|
| list | 显示所有机器 |
| status | 显示机器状态 |
| start | 启动机器 |
| stop | 停止机器 |
| restart | 重启机器 |
| terminate | 终止机器 |
| login | 登录机器 |
| copy-to | 复制文件到机器 |
| copy-from | 从机器复制文件 |
| enable | 启用机器 |
| disable | 禁用机器 |
| poweroff | 关闭机器 |
| reboot | 重启机器 |
| shell | 在机器中打开 shell |

## 5. 实战示例

### 5.1 查看机器信息
```bash
# 显示所有机器
machinectl list

# 显示机器状态
machinectl status

# 显示指定机器的状态
machinectl status <机器名称>
```

### 5.2 管理机器
```bash
# 启动机器
machinectl start <机器名称>

# 停止机器
machinectl stop <机器名称>

# 重启机器
machinectl restart <机器名称>

# 终止机器
machinectl terminate <机器名称>

# 启用机器
machinectl enable <机器名称>

# 禁用机器
machinectl disable <机器名称>

# 关闭机器
machinectl poweroff <机器名称>

# 重启机器
machinectl reboot <机器名称>
```

### 5.3 与机器交互
```bash
# 登录机器
machinectl login <机器名称>

# 在机器中打开 shell
machinectl shell <机器名称>

# 复制文件到机器
machinectl copy-to <本地文件> <机器名称>:<目标路径>

# 从机器复制文件
machinectl copy-from <机器名称>:<源路径> <本地文件>
```

## 6. 高级用法

### 6.1 监控机器状态
```bash
# 监控机器状态变化
machinectl list --no-pager | watch -n 1

# 监控指定机器的状态
machinectl status <机器名称> --no-pager | watch -n 1
```

### 6.2 与其他命令结合使用
```bash
# 查看机器的详细信息
machinectl status <机器名称> | grep -E "State|Address|OS"

# 批量管理机器
for machine in machine1 machine2 machine3; do
    machinectl start $machine
done
```

### 6.3 管理远程机器
```bash
# 连接远程机器
machinectl login <远程机器名称>

# 管理远程机器
machinectl start <远程机器名称>
machinectl stop <远程机器名称>
```

### 6.4 查看机器日志
```bash
# 查看机器日志
journalctl -M <机器名称>

# 实时跟踪机器日志
journalctl -M <机器名称> -f
```

## 7. 常见问题与解决方案

### 7.1 问题：machinectl: command not found
**解决方案**：安装 systemd-container
- Ubuntu/Debian: `apt install systemd-container`
- CentOS/RHEL: `yum install systemd-container`

### 7.2 问题：无法管理机器
**解决方案**：确保有足够的权限
```bash
sudo machinectl start <机器名称>
```

### 7.3 问题：无法连接远程机器
**解决方案**：确保网络连接正常，并且远程机器运行 systemd

### 7.4 问题：machinectl 命令执行缓慢
**解决方案**：检查系统负载和网络连接

### 7.5 问题：无法查看机器状态
**解决方案**：确保机器存在并且正在运行

## 8. 命令对比

| 命令 | 功能 | 适用场景 |
|------|------|----------|
| machinectl | 控制系统机器 | systemd 系统 |
| virsh | 管理虚拟机 | KVM 虚拟化 |
| lxc | 管理 LXC 容器 | LXC 容器 |
| docker | 管理 Docker 容器 | Docker 容器 |
| ssh | 远程登录 | 所有 Linux 系统 |

## 9. 注意事项
- machinectl 命令用于控制系统机器，是 Linux 系统中常用的系统管理命令之一
- machinectl 命令是 systemd 系统的一部分，用于管理本地和远程的 systemd 机器
- 常用的操作包括：查看机器信息、管理机器、与机器交互等
- machinectl 命令需要 root 权限来执行大部分操作
- machinectl 命令支持多种子命令，可以根据需要选择合适的命令
- machinectl 命令可以管理本地机器和远程机器
- machinectl 命令是现代 Linux 系统的标准工具，用于管理 systemd 机器