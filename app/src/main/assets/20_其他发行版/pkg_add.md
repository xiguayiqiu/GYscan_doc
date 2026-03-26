# pkg_add 命令

## 命令说明

`pkg_add` 是 OpenBSD 和 NetBSD 的包安装命令，用于安装软件包。

## 语法

```bash
pkg_add [选项] 软件包
```

## 常用选项

| 选项 | 描述 |
|------|------|
| `-h` | 显示帮助信息 |
| `-v` | 详细输出 |
| `-f` | 强制安装 |
| `-I` | 交互式模式 |
| `-l` | 列出软件包内容 |
| `-p` | 指定安装路径 |
| `-r` | 从远程仓库安装 |

## 示例

### 安装本地软件包

```bash
pkg_add nginx-1.20.0.tgz
```

### 从远程仓库安装软件包

```bash
pkg_add -r nginx
```

### 详细模式安装软件包

```bash
pkg_add -v nginx
```

### 列出软件包内容

```bash
pkg_add -l nginx-1.20.0.tgz
```

## 注意事项

- `pkg_add` 命令是 OpenBSD 和 NetBSD 特有的包安装命令
- 在 OpenBSD 中，软件包通常以 `.tgz` 格式分发
- 在 NetBSD 中，软件包通常以 `.tgz` 或 `.pkg` 格式分发
- 可以通过修改 `/etc/pkg.conf` 文件来配置软件仓库
- OpenBSD 还提供了 `pkg_info` 和 `pkg_delete` 命令来管理软件包