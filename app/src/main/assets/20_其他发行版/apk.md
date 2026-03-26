# apk 命令

## 命令说明

`apk` 是 Alpine Linux 的包管理器，用于安装、更新、删除软件包。

## 语法

```bash
apk [选项] 命令 [参数...]
```

## 常用命令

| 命令 | 描述 |
|------|------|
| `add` | 安装软件包 |
| `del` | 删除软件包 |
| `update` | 更新软件包索引 |
| `upgrade` | 升级已安装的软件包 |
| `info` | 显示软件包信息 |
| `search` | 搜索软件包 |
| `list` | 列出软件包 |
| `cache` | 管理缓存 |

## 常用选项

| 选项 | 描述 |
|------|------|
| `-h` | 显示帮助信息 |
| `-v` | 详细输出 |
| `-q` | 安静模式 |
| `--no-cache` | 不使用缓存 |
| `--repository` | 指定仓库 |

## 示例

### 安装软件包

```bash
apk add nginx
```

### 安装多个软件包

```bash
apk add nginx php-fpm mysql
```

### 删除软件包

```bash
apk del nginx
```

### 更新软件包索引

```bash
apk update
```

### 升级已安装的软件包

```bash
apk upgrade
```

### 搜索软件包

```bash
apk search nginx
```

### 显示软件包信息

```bash
apk info nginx
```

### 列出已安装的软件包

```bash
apk list --installed
```

## 注意事项

- `apk` 命令是 Alpine Linux 特有的包管理器
- Alpine Linux 使用 musl libc 而不是 glibc，因此某些软件可能需要特殊处理
- `apk` 命令的缓存位于 `/var/cache/apk/` 目录
- 可以通过修改 `/etc/apk/repositories` 文件来配置软件仓库