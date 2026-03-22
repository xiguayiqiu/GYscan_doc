# apt-cache - APT缓存查询工具

## 1. 命令简介
apt-cache 命令是 APT 缓存查询工具，是 Linux 系统中常用的软件包管理命令之一。

## 2. 命令语法
```bash
apt-cache [选项] [命令]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -h | 显示帮助信息 |
| --help | 显示帮助信息 |
| --version | 显示版本信息 |

## 4. 常用命令
| 命令 | 说明 |
|------|------|
| show | 显示软件包信息 |
| search | 搜索软件包 |
| depends | 显示软件包依赖 |
| rdepends | 显示反向依赖 |
| pkgnames | 显示所有软件包名称 |
| stats | 显示缓存统计信息 |

## 5. 实战示例

### 5.1 搜索软件包
```bash
apt-cache search package
```

### 5.2 显示软件包信息
```bash
apt-cache show package
```

### 5.3 显示软件包依赖
```bash
apt-cache depends package
```

### 5.4 显示反向依赖
```bash
apt-cache rdepends package
```

## 6. 注意事项
- apt-cache 命令是 APT 缓存查询工具，用于查询软件包信息
- apt-cache 命令不需要 root 权限
- apt-cache 命令是一个常用的系统管理工具，用于软件包信息查询