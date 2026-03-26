# pkg 命令

## 命令说明

`pkg` 是 FreeBSD 的包管理器，用于安装、更新、删除软件包。

## 语法

```bash
pkg [选项] 命令 [参数...]
```

## 常用命令

| 命令 | 描述 |
|------|------|
| `add` | 安装本地软件包 |
| `install` | 安装软件包 |
| `remove` | 删除软件包 |
| `delete` | 删除软件包（同 remove） |
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
pkg install nginx
```

### 安装多个软件包

```bash
pkg install nginx php-fpm mysql57-server
```

### 删除软件包

```bash
pkg remove nginx
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
pkg search nginx
```

### 显示软件包信息

```bash
pkg info nginx
```

### 列出已安装的软件包

```bash
pkg list
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

- `pkg` 命令是 FreeBSD 特有的包管理器
- FreeBSD 还提供了 Ports 系统作为另一种软件安装方式
- `pkg` 命令的配置文件位于 `/usr/local/etc/pkg/` 目录
- 可以通过修改 `/usr/local/etc/pkg/repos/` 目录下的文件来配置软件仓库