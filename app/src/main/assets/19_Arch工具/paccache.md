# paccache - Pacman缓存管理

## 1. 命令简介
paccache 命令用于 Pacman 缓存管理，是 Linux 系统中常用的 Arch 工具命令之一。

## 2. 命令语法
```bash
paccache [选项]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -d | 删除缓存 |
| -m | 保留最近的包 |
| -k | 保留指定数量的包 |
| -r | 递归删除 |
| -v | 显示详细信息 |
| --help | 显示帮助信息 |
| --version | 显示版本信息 |

## 4. 实战示例

### 4.1 显示缓存信息
```bash
paccache
```

### 4.2 保留最近的包
```bash
paccache -m
```

### 4.3 保留指定数量的包
```bash
paccache -k 2
```

### 4.4 删除缓存
```bash
paccache -d
```

## 5. 注意事项
- paccache 命令用于 Pacman 缓存管理，清理和管理软件包缓存
- paccache 命令是 Arch Linux 系统中常用的工具
- paccache 命令需要 root 权限