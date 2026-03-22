# aptitude - 交互式包管理器

## 1. 命令简介
aptitude 命令是交互式包管理器，是 Linux 系统中常用的软件包管理命令之一。

## 2. 命令语法
```bash
aptitude [选项] [命令]
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
| search | 搜索软件包 |
| show | 显示软件包信息 |

## 5. 实战示例

### 5.1 启动交互式界面
```bash
aptitude
```

### 5.2 安装软件包
```bash
aptitude install package
```

### 5.3 搜索软件包
```bash
aptitude search package
```

### 5.4 升级软件包
```bash
aptitude upgrade
```

## 6. 注意事项
- aptitude 命令是交互式包管理器，提供了更友好的界面和更强大的功能
- aptitude 命令需要 root 权限
- aptitude 命令是一个常用的系统管理工具，用于软件包管理