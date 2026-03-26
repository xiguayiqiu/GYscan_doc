# pkg_delete 命令

## 命令说明

`pkg_delete` 是 OpenBSD 和 NetBSD 的包删除命令，用于删除已安装的软件包。

## 语法

```bash
pkg_delete [选项] 软件包
```

## 常用选项

| 选项 | 描述 |
|------|------|
| `-h` | 显示帮助信息 |
| `-v` | 详细输出 |
| `-f` | 强制删除 |
| `-I` | 交互式模式 |
| `-r` | 递归删除依赖包 |
| `-a` | 删除所有已安装的软件包 |

## 示例

### 删除软件包

```bash
pkg_delete nginx
```

### 详细模式删除软件包

```bash
pkg_delete -v nginx
```

### 递归删除依赖包

```bash
pkg_delete -r nginx
```

### 删除所有已安装的软件包

```bash
pkg_delete -a
```

## 注意事项

- `pkg_delete` 命令是 OpenBSD 和 NetBSD 特有的包删除命令
- 在删除软件包时，系统会自动检查并提示是否删除相关的依赖包
- 可以使用 `pkg_info` 命令查看已安装的软件包列表
- 删除软件包后，配置文件可能会被保留，需要手动删除