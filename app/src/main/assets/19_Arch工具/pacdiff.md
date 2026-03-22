# pacdiff - 比较包文件

## 1. 命令简介
pacdiff 命令用于比较包文件，是 Linux 系统中常用的 Arch 工具命令之一。

## 2. 命令语法
```bash
pacdiff [选项]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -l | 列出差异文件 |
| -o | 显示旧文件 |
| -n | 显示新文件 |
| -s | 使用sudo |
| --help | 显示帮助信息 |
| --version | 显示版本信息 |

## 4. 实战示例

### 4.1 比较包文件
```bash
pacdiff
```

### 4.2 列出差异文件
```bash
pacdiff -l
```

### 4.3 使用sudo
```bash
pacdiff -s
```

## 5. 注意事项
- pacdiff 命令用于比较包文件，找出配置文件的差异
- pacdiff 命令是 Arch Linux 系统中常用的工具
- pacdiff 命令需要 root 权限