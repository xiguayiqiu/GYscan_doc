# localectl - 控制系统区域设置

## 1. 命令简介
localectl 命令用于控制系统的区域设置，是 Linux 系统中最常用的区域设置管理工具之一。

## 2. 命令语法
```bash
localectl [选项] [命令]
```

## 3. 常用命令
| 命令 | 说明 |
|------|------|
| status | 显示区域设置状态 |
| set-locale | 设置区域设置 |
| set-keymap | 设置键盘映射 |
| set-x11-keymap | 设置X11键盘映射 |

## 4. 实战示例

### 4.1 显示区域设置状态
```bash
localectl status
```

### 4.2 设置区域设置
```bash
sudo localectl set-locale LANG=en_US.UTF-8
```

### 4.3 设置键盘映射
```bash
sudo localectl set-keymap us
```

### 4.4 设置X11键盘映射
```bash
sudo localectl set-x11-keymap us
```

### 4.5 列出可用的区域设置
```bash
localectl list-locales
```

### 4.6 列出可用的键盘映射
```bash
localectl list-keymaps
```

## 5. 注意事项
- localectl 命令需要 root 权限，使用 sudo 执行
- 设置区域设置后，系统会自动更新相关配置文件
- 有些系统可能需要重启才能完全应用新的区域设置