# zypper 命令

## 命令说明

`zypper` 是 SUSE Linux 的包管理器，用于安装、更新、删除软件包。

## 语法

```bash
zypper [选项] 命令 [参数...]
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
| `refresh` | 刷新软件仓库 |
| `dist-upgrade` | 发行版升级 |

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
zypper install firefox
```

### 删除软件包

```bash
zypper remove firefox
```

### 更新软件包

```bash
zypper update firefox
```

### 升级系统

```bash
zypper upgrade
```

### 搜索软件包

```bash
zypper search firefox
```

### 显示软件包信息

```bash
zypper info firefox
```

### 清理缓存

```bash
zypper clean
```

### 刷新软件仓库

```bash
zypper refresh
```

## 注意事项

- `zypper` 是 SUSE Linux 的包管理器
- `zypper` 使用 `/etc/zypp/repos.d/` 目录下的配置文件来管理软件仓库
- 可以使用 `zypper --version` 查看当前安装的 zypper 版本
- `zypper` 提供了交互式和非交互式两种操作模式
- `zypper` 会自动处理软件包的依赖关系