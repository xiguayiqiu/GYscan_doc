# hostname命令

## 命令简介

`hostname`命令用于显示或设置系统的主机名，它可以查看当前系统的主机名，也可以临时修改系统的主机名。

## 语法

```bash
hostname [选项] [主机名]
```

## 选项

| 选项 | 描述 |
|------|------|
| `-a` | 显示主机的别名 |
| `-d` | 显示主机的域名 |
| `-f` | 显示主机的完全限定域名（FQDN） |
| `-i` | 显示主机的IP地址 |
| `-I` | 显示主机的所有IPv4地址 |
| `-s` | 显示主机的短名称（不包含域名部分） |
| `-y` | 显示主机的NIS域名 |
| `-h`, `--help` | 显示帮助信息 |
| `-V`, `--version` | 显示版本信息 |

## 示例

### 显示当前主机名

```bash
hostname
```

### 显示主机的完全限定域名

```bash
hostname -f
```

### 显示主机的IP地址

```bash
hostname -i
```

### 显示主机的所有IPv4地址

```bash
hostname -I
```

### 显示主机的短名称

```bash
hostname -s
```

### 设置临时主机名

```bash
hostname new-hostname
```

## 高级用法

### 永久修改主机名

```bash
# 在Ubuntu/Debian系统中
# 编辑/etc/hostname文件
sudo nano /etc/hostname

# 编辑/etc/hosts文件
sudo nano /etc/hosts

# 重启系统或执行
sudo systemctl restart hostname

# 在CentOS/RHEL系统中
sudo hostnamectl set-hostname new-hostname
```

### 结合其他命令使用

```bash
# 显示主机名和IP地址
echo "Hostname: $(hostname)"
echo "IP Address: $(hostname -I)"

# 在脚本中使用主机名
HOST=$(hostname)
echo "Running on host: $HOST"
```

## 常见问题

### 问题：设置主机名后重启失效

**原因**：使用hostname命令设置的主机名是临时的，系统重启后会恢复默认值。

**解决方法**：编辑主机名配置文件，或使用hostnamectl命令（在systemd系统中）永久修改主机名。

### 问题：hostname -i显示127.0.0.1

**原因**：主机名在/etc/hosts文件中被映射到127.0.0.1。

**解决方法**：编辑/etc/hosts文件，将主机名映射到正确的IP地址。

## 命令对比

| 命令 | 功能 | 特点 |
|------|------|------|
| `hostname` | 显示或设置主机名 | 传统的主机名管理工具 |
| `hostnamectl` | 控制系统主机名 | 现代的主机名管理工具，支持更多功能 |
| `uname -n` | 显示主机名 | 显示系统的主机名 |

## 注意事项

1. **权限要求**：设置主机名需要root权限。

2. **临时与永久**：使用hostname命令设置的主机名是临时的，重启后会失效；永久修改需要编辑配置文件。

3. **主机名格式**：主机名应该由字母、数字和连字符组成，不能包含空格和特殊字符。

4. **网络配置**：修改主机名后，可能需要更新相关的网络配置和服务。

5. **适用场景**：hostname命令适用于查看和临时修改系统主机名的场景。