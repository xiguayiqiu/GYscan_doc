# pkg_info 命令

## 命令说明

`pkg_info` 是 OpenBSD 和 NetBSD 的包信息查询命令，用于显示已安装软件包的信息。

## 语法

```bash
pkg_info [选项] [软件包]
```

## 常用选项

| 选项 | 描述 |
|------|------|
| `-h` | 显示帮助信息 |
| `-v` | 详细输出 |
| `-a` | 显示所有已安装的软件包 |
| `-e` | 检查软件包是否已安装 |
| `-l` | 列出软件包内容 |
| `-s` | 显示软件包大小 |
| `-d` | 显示软件包描述 |
| `-R` | 显示软件包依赖关系 |

## 示例

### 显示所有已安装的软件包

```bash
pkg_info -a
```

### 显示特定软件包的信息

```bash
pkg_info nginx
```

### 详细显示软件包信息

```bash
pkg_info -v nginx
```

### 检查软件包是否已安装

```bash
pkg_info -e nginx
```

### 列出软件包内容

```bash
pkg_info -l nginx
```

### 显示软件包依赖关系

```bash
pkg_info -R nginx
```

## 注意事项

- `pkg_info` 命令是 OpenBSD 和 NetBSD 特有的包信息查询命令
- 可以使用此命令查看已安装软件包的版本、描述、大小等信息
- 对于未安装的软件包，可以使用 `pkg_add -l` 命令查看其内容
- OpenBSD 和 NetBSD 还提供了 `pkg_add` 和 `pkg_delete` 命令来管理软件包