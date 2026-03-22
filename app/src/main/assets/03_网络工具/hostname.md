# hostname - 显示或设置主机名

## 1. 命令简介
hostname 命令用于显示或设置主机名，是 Linux 系统中常用的网络工具命令之一。

## 2. 命令语法
```bash
hostname [选项] [主机名]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -a | 显示别名 |
| -d | 显示域名 |
| -f | 显示完全限定域名 |
| -i | 显示IP地址 |
| -s | 显示短主机名 |
| --help | 显示帮助信息 |
| --version | 显示版本信息 |

## 4. 实战示例

### 4.1 显示主机名
```bash
hostname
```

### 4.2 显示完全限定域名
```bash
hostname -f
```

### 4.3 显示IP地址
```bash
hostname -i
```

### 4.4 设置主机名
```bash
hostname new-hostname
```

## 5. 注意事项
- hostname 命令用于显示或设置主机名
- 设置主机名需要 root 权限
- 临时设置的主机名在系统重启后会恢复默认值
- 永久修改主机名需要编辑 /etc/hostname 文件