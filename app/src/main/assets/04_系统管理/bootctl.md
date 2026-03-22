# bootctl - 控制启动加载器

## 1. 命令简介
bootctl 命令用于控制启动加载器，是 Linux 系统中常用的系统管理命令之一。

## 2. 命令语法
```bash
bootctl [选项] [命令]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -h | 显示帮助信息 |
| --version | 显示版本信息 |

## 4. 常用命令
| 命令 | 说明 |
|------|------|
| status | 显示启动加载器状态 |
| install | 安装启动加载器 |
| update | 更新启动加载器 |
| remove | 移除启动加载器 |
| random-seed | 管理随机种子 |
| list | 列出启动项 |

## 5. 实战示例

### 5.1 显示启动加载器状态
```bash
bootctl status
```

### 5.2 安装启动加载器
```bash
bootctl install
```

### 5.3 更新启动加载器
```bash
bootctl update
```

### 5.4 列出启动项
```bash
bootctl list
```

## 6. 注意事项
- bootctl 命令用于控制启动加载器，如 systemd-boot
- bootctl 命令是 systemd 系统的一部分
- bootctl 命令需要 root 权限
- bootctl 命令是一个常用的系统管理工具，用于管理启动加载器