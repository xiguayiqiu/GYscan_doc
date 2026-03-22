# tracepath - 跟踪网络路径

## 1. 命令简介
tracepath 命令用于跟踪数据包从本地到目标主机的网络路径，是 Linux 系统中常用的网络诊断工具之一。

## 2. 命令语法
```bash
tracepath [选项] 目标主机
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -n | 使用IP地址而不是主机名 |
| -b | 显示主机名和IP地址 |
| -l | 指定数据包大小 |
| -m | 指定最大跳数 |

## 4. 实战示例

### 4.1 跟踪网络路径
```bash
tracepath google.com
```

### 4.2 使用IP地址而不是主机名
```bash
tracepath -n google.com
```

### 4.3 显示主机名和IP地址
```bash
tracepath -b google.com
```

### 4.4 指定数据包大小
```bash
tracepath -l 1000 google.com
```

### 4.5 指定最大跳数
```bash
tracepath -m 20 google.com
```

## 5. 注意事项
- tracepath 命令不需要 root 权限，普通用户也可以执行
- tracepath 是 traceroute 命令的替代品，使用更加简单
- tracepath 通过发送UDP数据包来跟踪网络路径