# yum 命令

## 命令说明

`yum` 是 Red Hat/CentOS 系统的包管理器，用于安装、更新、删除软件包。

## 语法

```bash
yum [选项] 命令 [参数...]
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
yum install firefox
```

### 删除软件包

```bash
yum remove firefox
```

### 更新软件包

```bash
yum update firefox
```

### 升级系统

```bash
yum upgrade
```

### 搜索软件包

```bash
yum search firefox
```

### 显示软件包信息

```bash
yum info firefox
```

### 清理缓存

```bash
yum clean all
```

## 注意事项

- `yum` 是 Red Hat/CentOS 系统的包管理器
- 在 CentOS 8+ 中，`yum` 已经被 `dnf` 取代，但仍然作为 `dnf` 的别名存在
- `yum` 使用 `/etc/yum.repos.d/` 目录下的配置文件来管理软件仓库
- 可以使用 `yum --version` 查看当前安装的 yum 版本
- `yum` 会自动处理软件包的依赖关系