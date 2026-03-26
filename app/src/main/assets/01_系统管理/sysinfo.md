# sysinfo 命令

## 命令说明

`sysinfo` 命令用于显示系统的详细信息，包括硬件、内存、CPU、网络等信息。

## 语法

```bash
sysinfo
```

## 示例

### 显示系统信息

```bash
sysinfo
# 输出示例：
# System Information:
#   Hostname: hostname
#   OS: Linux 5.4.0-91-generic
#   Kernel: 5.4.0-91-generic
#   Architecture: x86_64
#   CPU: Intel(R) Core(TM) i7-8700K CPU @ 3.70GHz
#   CPU Cores: 12
#   Memory: 16384 MB
#   Disk Space: 500 GB
#   Uptime: 2 days, 14 hours, 30 minutes
#   Load Average: 0.15, 0.20, 0.18
```

## 注意事项

- `sysinfo` 命令在某些 Linux 发行版上可能需要单独安装
- 在 Ubuntu 系统上，可以使用 `apt install sysinfo` 安装
- 对于更详细的系统信息，可以使用以下命令：
  - `lshw`：显示详细的硬件信息
  - `lscpu`：显示CPU信息
  - `free -h`：显示内存使用情况
  - `df -h`：显示磁盘使用情况
  - `uptime`：显示系统运行时间
  - `top`：显示实时系统状态

## 相关命令

- `uname`：显示系统基本信息
- `lsb_release`：显示发行版信息
- `lshw`：显示详细硬件信息
- `lscpu`：显示CPU信息
- `free`：显示内存使用情况
- `df`：显示磁盘使用情况