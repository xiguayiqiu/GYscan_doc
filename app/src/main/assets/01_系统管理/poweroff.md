# poweroff - 关闭系统

## 1. 命令简介
poweroff 命令用于关闭系统，是 Linux 系统中常用的系统管理命令之一。

## 2. 命令语法
```bash
poweroff [选项]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -f | 强制关闭 |
| -i | 关闭所有网络接口后关闭 |
| -n | 不执行 sync 操作 |
| --help | 显示帮助信息 |
| --version | 显示版本信息 |

## 4. 实战示例

### 4.1 关闭系统
```bash
poweroff
```

### 4.2 强制关闭
```bash
poweroff -f
```

### 4.3 关闭所有网络接口后关闭
```bash
poweroff -i
```

## 5. 注意事项
- poweroff 命令用于关闭系统
- poweroff 命令需要 root 权限
- poweroff 命令是一个常用的系统管理工具，用于系统关闭