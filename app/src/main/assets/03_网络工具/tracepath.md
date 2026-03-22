# tracepath - 跟踪网络路径

## 1. 命令简介
tracepath 命令用于跟踪网络路径，是 Linux 系统中常用的网络工具命令之一。

## 2. 命令语法
```bash
tracepath [选项] [目标]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -n | 使用数字地址 |
| -m | 设置最大跳数 |
| -p | 指定端口 |
| --help | 显示帮助信息 |
| --version | 显示版本信息 |

## 4. 实战示例

### 4.1 跟踪网络路径
```bash
tracepath google.com
```

### 4.2 使用数字地址
```bash
tracepath -n google.com
```

### 4.3 设置最大跳数
```bash
tracepath -m 20 google.com
```

### 4.4 指定端口
```bash
tracepath -p 80 google.com
```

## 5. 注意事项
- tracepath 命令用于跟踪网络路径，显示数据包从源到目标的路径
- tracepath 命令与 traceroute 命令类似，但不需要 root 权限
- tracepath 命令是一个常用的网络工具，用于网络故障排查