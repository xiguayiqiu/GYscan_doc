# tc - 流量控制工具

## 1. 命令简介
tc 命令用于流量控制，是 Linux 系统中常用的网络工具命令之一。

## 2. 命令语法
```bash
tc [选项] [命令]
```

## 3. 常用命令
| 命令 | 说明 |
|------|------|
| qdisc | 管理队列规则 |
| class | 管理分类 |
| filter | 管理过滤器 |
| action | 管理动作 |
| monitor | 监控流量 |

## 4. 常用队列规则
| 规则 | 说明 |
|------|------|
| pfifo_fast | 先进先出队列 |
| tbf | 令牌桶过滤器 |
| htb | 层次化令牌桶 |
| sfq | 随机公平队列 |
| cbq | 基于类的队列 |

## 5. 实战示例

### 5.1 显示队列规则
```bash
tc qdisc show dev eth0
```

### 5.2 添加令牌桶过滤器
```bash
sudo tc qdisc add dev eth0 root tbf rate 1mbit burst 32kbit latency 400ms
```

### 5.3 删除队列规则
```bash
sudo tc qdisc del dev eth0 root
```

### 5.4 添加层次化令牌桶
```bash
sudo tc qdisc add dev eth0 root handle 1: htb default 10
sudo tc class add dev eth0 parent 1: classid 1:1 htb rate 1mbit
sudo tc class add dev eth0 parent 1:1 classid 1:10 htb rate 512kbit
sudo tc class add dev eth0 parent 1:1 classid 1:20 htb rate 256kbit
```

## 6. 注意事项
- tc 命令需要 root 权限才能执行
- tc 命令用于流量控制，可以限制网络带宽、延迟等
- tc 命令的语法比较复杂，需要一定的网络知识
- 常用的队列规则有 tbf（令牌桶过滤器）、htb（层次化令牌桶）等