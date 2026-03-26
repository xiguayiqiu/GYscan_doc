# init - 系统初始化

## 1. 命令简介
init 命令用于系统初始化，是 Linux 系统中常用的系统管理命令之一。它是系统启动的第一个进程，负责初始化系统并启动其他进程。

## 2. 命令语法
```bash
init [选项] [运行级别]
```

## 3. 运行级别

| 运行级别 | 说明 |
|---------|------|
| 0 | 关机 |
| 1 | 单用户模式 |
| 2 | 多用户模式（无网络） |
| 3 | 多用户模式（有网络） |
| 4 | 未使用 |
| 5 | 图形界面模式 |
| 6 | 重启 |

## 4. 常用选项

| 选项 | 说明 |
|------|------|
| -h, --help | 显示帮助信息 |
| --version | 显示版本信息 |
| -q, --quiet | 安静模式 |
| -v, --verbose | 详细模式 |
| -s, --single | 单用户模式 |

## 5. 实战示例

### 5.1 切换到单用户模式
```bash
sudo init 1
```

### 5.2 切换到多用户模式（有网络）
```bash
sudo init 3
```

### 5.3 切换到图形界面模式
```bash
sudo init 5
```

### 5.4 关机
```bash
sudo init 0
```

### 5.5 重启
```bash
sudo init 6
```

## 6. 高级用法

### 6.1 与其他命令结合使用
```bash
# 切换到单用户模式并执行命令
sudo init 1 && echo "已切换到单用户模式"

# 检查当前运行级别
runlevel
```

### 6.2 自动化初始化
```bash
#!/bin/bash

# 自动化初始化
echo "系统初始化"
echo "当前运行级别: $(runlevel)"

# 切换到多用户模式
sudo init 3
echo "已切换到多用户模式"
```

### 6.3 监控系统初始化
```bash
#!/bin/bash

# 监控系统初始化
echo "监控系统初始化，按 Ctrl+C 退出"

while true; do
    echo "\n$(date)"
    runlevel
    ps aux | grep init
    sleep 60
done
```

## 7. 常见问题与解决方案

### 7.1 问题：init: command not found
**解决方案**：安装 sysvinit-core
- Ubuntu/Debian: `apt install sysvinit-core`
- CentOS/RHEL: `yum install sysvinit-tools`

### 7.2 问题：无法切换运行级别
**解决方案**：确保有足够的权限
```bash
sudo init 3
```

### 7.3 问题：初始化失败
**解决方案**：检查系统状态和配置

### 7.4 问题：init 命令执行缓慢
**解决方案**：系统正在初始化，这是正常现象

### 7.5 问题：无法切换到图形界面模式
**解决方案**：确保已安装图形界面
```bash
sudo apt install ubuntu-desktop  # Ubuntu
```

## 8. 命令对比

| 命令 | 功能 | 适用场景 |
|------|------|----------|
| init | 系统初始化 | 传统 SysV 系统 |
| runlevel | 显示当前运行级别 | 传统 SysV 系统 |
| systemctl | 控制系统和服务 | systemd 系统 |
| shutdown | 关闭系统 | 所有 Linux 系统 |
| reboot | 重启系统 | 所有 Linux 系统 |

## 9. 注意事项
- init 命令用于系统初始化，是 Linux 系统中常用的系统管理命令之一
- init 命令是系统启动的第一个进程，负责初始化系统并启动其他进程
- 常用的操作包括：切换到单用户模式、切换到多用户模式、切换到图形界面模式等
- init 命令需要 root 权限来执行
- init 命令支持多种选项，可以根据需要选择合适的选项
- init 命令是传统 Linux 系统的标准工具，用于系统初始化