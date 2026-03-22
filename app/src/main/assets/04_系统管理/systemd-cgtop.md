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
| -p | 显示百分比 |
| -t | 显示线程 |
| -c | 显示CPU使用率 |
| -m | 显示内存使用率 |
| -i | 显示IO使用率 |
| -b | 批处理模式 |
| -d | 指定刷新间隔（秒） |

## 4. 实战示例

### 4.1 显示控制组资源使用情况
```bash
systemd-cgtop
```

### 4.2 显示百分比
```bash
systemd-cgtop -p
```

### 4.3 显示线程
```bash
systemd-cgtop -t
```

### 4.4 批处理模式
```bash
systemd-cgtop -b
```

### 4.5 指定刷新间隔
```bash
systemd-cgtop -d 1
```

## 5. 注意事项
- systemd-cgtop 命令是 systemd 系统的一部分，用于显示控制组资源使用情况
- 使用 -p 选项可以显示百分比，使输出更加易读
- 使用 -d 选项可以指定刷新间隔，默认为1秒