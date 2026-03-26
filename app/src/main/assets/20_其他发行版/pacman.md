# pacman 命令

## 命令说明

`pacman` 是 Arch Linux 的包管理器，用于安装、更新、删除软件包。

## 语法

```bash
pacman [选项] 命令 [参数...]
```

## 常用命令

| 命令 | 描述 |
|------|------|
| `-S` | 安装软件包 |
| `-R` | 删除软件包 |
| `-Syu` | 更新系统 |
| `-Ss` | 搜索软件包 |
| `-Si` | 显示软件包信息 |
| `-Q` | 列出已安装的软件包 |
| `-Ql` | 列出软件包内容 |
| `-Qe` | 列出显式安装的软件包 |
| `-Qd` | 列出作为依赖安装的软件包 |

## 常用选项

| 选项 | 描述 |
|------|------|
| `-h` | 显示帮助信息 |
| `-v` | 详细输出 |
| `-y` | 刷新软件包数据库 |
| `-u` | 升级软件包 |
| `-c` | 清理缓存 |
| `-f` | 强制操作 |

## 示例

### 安装软件包

```bash
pacman -S nginx
```

### 安装多个软件包

```bash
pacman -S nginx php-fpm mariadb
```

### 删除软件包

```bash
pacman -R nginx
```

### 删除软件包及其依赖

```bash
pacman -Rs nginx
```

### 更新系统

```bash
pacman -Syu
```

### 搜索软件包

```bash
pacman -Ss nginx
```

### 显示软件包信息

```bash
pacman -Si nginx
```

### 列出已安装的软件包

```bash
pacman -Q
```

### 清理缓存

```bash
pacman -Sc
```

## 注意事项

- `pacman` 命令是 Arch Linux 特有的包管理器
- Arch Linux 采用滚动更新模式，因此经常使用 `pacman -Syu` 来保持系统最新
- `pacman` 命令的配置文件位于 `/etc/pacman.conf`
- 可以通过修改 `/etc/pacman.d/` 目录下的文件来配置软件仓库
- Arch Linux 还提供了 AUR (Arch User Repository) 作为社区维护的软件源