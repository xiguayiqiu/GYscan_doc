# apt-get - APT包处理工具

## 1. 命令简介
apt-get 命令是 APT 包处理工具，是 Linux 系统中常用的软件包管理命令之一。

## 2. 命令语法
```bash
apt-get [选项] [命令]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -h | 显示帮助信息 |
| -y | 自动回答是 |
| -q | 安静模式 |
| --help | 显示帮助信息 |
| --version | 显示版本信息 |

## 4. 常用命令
| 命令 | 说明 |
|------|------|
| update | 更新软件包列表 |
| upgrade | 升级软件包 |
| install | 安装软件包 |
| remove | 卸载软件包 |
| purge | 卸载软件包及其配置 |
| autoremove | 自动移除不需要的软件包 |
| clean | 清理软件包缓存 |
| autoclean | 清理旧的软件包缓存 |

## 5. 实战示例

### 5.1 更新软件包列表
```bash
apt-get update
```

### 5.2 升级软件包
```bash
apt-get upgrade
```

### 5.3 安装软件包
```bash
apt-get install package
```

### 5.4 卸载软件包
```bash
apt-get remove package
```

## 6. 注意事项
- apt-get 命令是 APT 包处理工具，用于管理 Debian 系 Linux 系统的软件包
- apt-get 命令需要 root 权限
- apt-get 命令是一个常用的系统管理工具，用于软件包管理