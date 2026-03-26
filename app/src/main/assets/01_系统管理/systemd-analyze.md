# systemd-analyze - 分析系统启动时间

## 1. 命令简介
systemd-analyze 命令用于分析系统启动时间，是 Linux 系统中常用的系统管理命令之一。它是 systemd 系统的一部分，用于分析系统启动过程中的各个服务的启动时间。

## 2. 命令语法
```bash
systemd-analyze [选项] [命令]
```

## 3. 常用选项

| 选项 | 说明 |
|------|------|
| -h, --help | 显示帮助信息 |
| --version | 显示版本信息 |
| --no-pager | 不使用分页器 |

## 4. 常用命令

| 命令 | 说明 |
|------|------|
| time | 显示系统启动总时间 |
| blame | 显示每个服务的启动时间 |
| critical-chain | 显示启动关键链 |
| plot | 生成启动时间图表 |
| dot | 生成启动时间 DOT 图 |
| security | 显示安全评估 |

## 5. 实战示例

### 5.1 显示系统启动总时间
```bash
systemd-analyze time
```

### 5.2 显示每个服务的启动时间
```bash
systemd-analyze blame
```

### 5.3 显示启动关键链
```bash
systemd-analyze critical-chain
```

### 5.4 生成启动时间图表
```bash
systemd-analyze plot > boot.svg
```

### 5.5 生成启动时间 DOT 图
```bash
systemd-analyze dot > boot.dot
```

### 5.6 显示安全评估
```bash
systemd-analyze security
```

## 6. 高级用法

### 6.1 分析启动性能
```bash
# 查看启动时间最长的服务
systemd-analyze blame | head -n 10

# 查看启动关键链的详细信息
systemd-analyze critical-chain --no-pager
```

### 6.2 优化启动时间
```bash
# 禁用不必要的服务
sudo systemctl disable <服务名称>

# 查看服务的依赖关系
systemctl list-dependencies <服务名称>
```

### 6.3 与其他命令结合使用
```bash
# 分析启动时间并保存结果
systemd-analyze time > boot-time.log
systemd-analyze blame > boot-blame.log

# 查看系统启动时间趋势
for i in {1..5}; do
    systemd-analyze time >> boot-time-trend.log
    sleep 1
done
```

### 6.4 监控启动时间
```bash
# 监控启动时间变化
systemd-analyze time --no-pager | watch -n 60
```

## 7. 常见问题与解决方案

### 7.1 问题：systemd-analyze: command not found
**解决方案**：安装 systemd
- Ubuntu/Debian: `apt install systemd`
- CentOS/RHEL: `yum install systemd`

### 7.2 问题：无法分析启动时间
**解决方案**：确保 systemd 服务正在运行
```bash
systemctl status systemd
```

### 7.3 问题：启动时间过长
**解决方案**：分析启动时间并优化
```bash
systemd-analyze blame
```

### 7.4 问题：无法生成图表
**解决方案**：安装必要的工具
```bash
sudo apt install graphviz
```

### 7.5 问题：systemd-analyze 命令执行缓慢
**解决方案**：检查系统负载和服务状态

## 8. 命令对比

| 命令 | 功能 | 适用场景 |
|------|------|----------|
| systemd-analyze | 分析系统启动时间 | systemd 系统 |
| systemctl | 控制系统和服务 | systemd 系统 |
| journalctl | 查询系统日志 | systemd 系统 |
| uptime | 显示系统运行时间 | 所有 Linux 系统 |

## 9. 注意事项
- systemd-analyze 命令用于分析系统启动时间，是 Linux 系统中常用的系统管理命令之一
- systemd-analyze 命令是 systemd 系统的一部分，用于分析系统启动过程中的各个服务的启动时间
- 常用的操作包括：显示系统启动总时间、显示每个服务的启动时间、显示启动关键链等
- systemd-analyze 命令不需要 root 权限来执行大部分操作
- systemd-analyze 命令支持多种子命令，可以根据需要选择合适的命令
- systemd-analyze 命令可以生成启动时间图表，帮助用户更直观地分析启动过程
- systemd-analyze 命令是现代 Linux 系统的标准工具，用于分析和优化系统启动时间