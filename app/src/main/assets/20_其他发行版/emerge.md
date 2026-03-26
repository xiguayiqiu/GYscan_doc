# emerge 命令

## 命令说明

`emerge` 是 Gentoo Linux 的包管理器，用于安装、更新、删除软件包。

## 语法

```bash
emerge [选项] [软件包]
```

## 常用命令

| 命令 | 描述 |
|------|------|
| `emerge <软件包>` | 安装软件包 |
| `emerge -C <软件包>` | 删除软件包 |
| `emerge --update <软件包>` | 更新软件包 |
| `emerge --sync` | 同步软件包仓库 |
| `emerge --update world` | 更新系统 |
| `emerge --depclean` | 清理不需要的依赖 |

## 常用选项

| 选项 | 描述 |
|------|------|
| `-a` | 询问确认 |
| `-v` | 详细输出 |
| `-q` | 安静模式 |
| `-j` | 并行编译 |
| `--with-bdeps=y` | 安装构建依赖 |
| `--newuse` | 重新编译以应用新的USE标志 |

## 示例

### 安装软件包

```bash
emerge firefox
```

### 询问确认安装

```bash
emerge -a firefox
```

### 删除软件包

```bash
emerge -C firefox
```

### 同步软件包仓库

```bash
emerge --sync
```

### 更新系统

```bash
emerge --update world
```

### 清理不需要的依赖

```bash
emerge --depclean
```

## 注意事项

- `emerge` 命令是 Gentoo Linux 特有的包管理器
- Gentoo 使用 Portage 系统，通过编译源代码来安装软件
- `emerge` 命令的配置文件位于 `/etc/portage/` 目录
- 可以使用 `emerge --help` 查看更多选项
- Gentoo 的 USE 标志系统允许用户自定义软件包的功能