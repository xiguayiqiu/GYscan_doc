# slackpkg 命令

## 命令说明

`slackpkg` 是 Slackware Linux 的包管理器，用于安装、更新、删除软件包。

## 语法

```bash
slackpkg [选项] 命令 [参数...]
```

## 常用命令

| 命令 | 描述 |
|------|------|
| `update` | 更新软件包列表 |
| `install` | 安装软件包 |
| `remove` | 删除软件包 |
| `upgrade` | 升级软件包 |
| `upgrade-all` | 升级所有软件包 |
| `clean-system` | 清理不需要的软件包 |
| `search` | 搜索软件包 |
| `file-search` | 搜索包含特定文件的软件包 |

## 常用选项

| 选项 | 描述 |
|------|------|
| `-h` | 显示帮助信息 |
| `-v` | 详细输出 |
| `-dialog` | 使用对话框界面 |
| `-batch` | 批处理模式 |

## 示例

### 更新软件包列表

```bash
slackpkg update
```

### 安装软件包

```bash
slackpkg install firefox
```

### 删除软件包

```bash
slackpkg remove firefox
```

### 升级所有软件包

```bash
slackpkg upgrade-all
```

### 清理不需要的软件包

```bash
slackpkg clean-system
```

### 搜索软件包

```bash
slackpkg search firefox
```

## 注意事项

- `slackpkg` 命令是 Slackware Linux 特有的包管理器
- Slackware 使用 `.tgz` 格式的软件包
- `slackpkg` 命令的配置文件位于 `/etc/slackpkg/` 目录
- 可以使用 `slackpkg help` 查看更多命令和选项
- Slackware 还提供了 `installpkg`、`removepkg` 和 `upgradepkg` 等基础包管理命令