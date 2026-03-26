# pkgng 命令

## 命令说明

`pkgng` 是 FreeBSD 的新一代包管理器，是传统 `pkg` 命令的改进版本。

## 语法

```bash
pkg [选项] 命令 [参数...]
```

## 常用命令

| 命令 | 描述 |
|------|------|
| `install` | 安装软件包 |
| `remove` | 卸载软件包 |
| `update` | 更新软件包仓库 |
| `upgrade` | 升级已安装的软件包 |
| `info` | 显示软件包信息 |
| `search` | 搜索软件包 |
| `list` | 列出已安装的软件包 |
| `autoremove` | 自动删除不再需要的依赖包 |
| `clean` | 清理缓存 |

## 常用选项

| 选项 | 描述 |
|------|------|
| `-h` | 显示帮助信息 |
| `-v` | 详细输出 |
| `-y` | 自动确认 |
| `-f` | 强制操作 |

## 示例

### 安装软件包

```bash
pkg install firefox
```

### 卸载软件包

```bash
pkg remove firefox
```

### 更新软件包仓库

```bash
pkg update
```

### 升级已安装的软件包

```bash
pkg upgrade
```

### 搜索软件包

```bash
pkg search firefox
```

### 显示软件包信息

```bash
pkg info firefox
```

### 自动删除不再需要的依赖包

```bash
pkg autoremove
```

### 清理缓存

```bash
pkg clean
```

## 注意事项

- `pkgng` 是 FreeBSD 的新一代包管理器
- `pkgng` 取代了传统的 `pkg_*` 命令
- `pkgng` 使用 `pkg.conf` 配置文件，位于 `/usr/local/etc/pkg/` 目录
- `pkgng` 支持仓库管理，可以从多个来源安装软件包
- FreeBSD 10.0+ 默认使用 `pkgng` 作为包管理器