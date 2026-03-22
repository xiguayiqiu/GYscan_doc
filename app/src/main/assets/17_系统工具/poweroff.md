# poweroff - 关闭电源

## 1. 命令简介
poweroff 命令用于关闭系统并关闭电源，是 Linux 系统中常用的系统管理命令之一。

## 2. 命令语法
```bash
poweroff [选项]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -f | 强制关闭电源，不调用 shutdown 命令 |
| -i | 在关闭电源前关闭所有网络接口 |
| --help | 显示帮助信息 |

## 4. 实战示例

### 4.1 关闭电源
```bash
sudo poweroff
```

### 4.2 强制关闭电源
```bash
sudo poweroff -f
```

## 5. 注意事项
- poweroff 命令需要 root 权限，使用 sudo 执行
- poweroff 命令会关闭系统并关闭电源
- 在现代 Linux 系统中，poweroff 命令通常是 systemctl 命令的别名