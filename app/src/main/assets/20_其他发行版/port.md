# port 命令

## 命令说明

`port` 是 FreeBSD Ports 系统的命令行工具，用于管理 FreeBSD 软件包。

## 语法

```bash
port [选项] 命令 [参数...]
```

## 常用命令

| 命令 | 描述 |
|------|------|
| `install` | 安装软件包 |
| `upgrade` | 升级软件包 |
| `deinstall` | 卸载软件包 |
| `search` | 搜索软件包 |
| `info` | 显示软件包信息 |
| `list` | 列出软件包 |
| `clean` | 清理工作目录 |
| `config` | 配置软件包 |

## 常用选项

| 选项 | 描述 |
|------|------|
| `-h` | 显示帮助信息 |
| `-v` | 详细输出 |
| `-f` | 强制操作 |
| `-y` | 自动确认 |

## 示例

### 安装软件包

```bash
port install firefox
```

### 升级软件包

```bash
port upgrade firefox
```

### 卸载软件包

```bash
port deinstall firefox
```

### 搜索软件包

```bash
port search firefox
```

### 显示软件包信息

```bash
port info firefox
```

### 清理工作目录

```bash
port clean firefox
```

## 注意事项

- `port` 命令是 FreeBSD Ports 系统的命令行工具
- FreeBSD Ports 系统是一个基于源代码的软件包管理系统
- Ports 系统的软件包位于 `/usr/ports/` 目录
- 可以使用 `pkg` 命令来管理二进制软件包
- FreeBSD 还提供了 `portmaster` 等第三方工具来简化 Ports 系统的使用