# dnf 命令

## 命令说明

`dnf` 是 Red Hat/CentOS 系统的新一代包管理器，是 `yum` 的替代品，提供了更快、更可靠的依赖管理。

## 语法

```bash
dnf [选项] 命令 [参数...]
```

## 常用命令

| 命令 | 描述 |
|------|------|
| `install` | 安装软件包 |
| `remove` | 删除软件包 |
| `update` | 更新软件包 |
| `upgrade` | 升级软件包 |
| `list` | 列出软件包 |
| `info` | 显示软件包信息 |
| `search` | 搜索软件包 |
| `clean` | 清理缓存 |
| `makecache` | 生成缓存 |
| `autoremove` | 自动删除不再需要的依赖包 |

## 常用选项

| 选项 | 描述 |
|------|------|
| `-h` | 显示帮助信息 |
| `-v` | 详细输出 |
| `-y` | 自动确认 |
| `-q` | 安静模式 |

## 示例

### 安装软件包

```bash
dnf install firefox
```

### 删除软件包

```bash
dnf remove firefox
```

### 更新软件包

```bash
dnf update firefox
```

### 升级系统

```bash
dnf upgrade
```

### 搜索软件包

```bash
dnf search firefox
```

### 显示软件包信息

```bash
dnf info firefox
```

### 清理缓存

```bash
dnf clean all
```

### 自动删除不再需要的依赖包

```bash
dnf autoremove
```

## 注意事项

- `dnf` 是 Red Hat/CentOS 系统的新一代包管理器
- 在 CentOS 8+ 中，`dnf` 已经取代了 `yum`
- `dnf` 使用 `/etc/yum.repos.d/` 目录下的配置文件来管理软件仓库
- 可以使用 `dnf --version` 查看当前安装的 dnf 版本
- `dnf` 提供了更快的性能和更好的依赖解析能力