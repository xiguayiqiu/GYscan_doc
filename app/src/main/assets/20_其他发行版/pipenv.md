# pipenv 命令

## 命令说明

`pipenv` 是 Python 的虚拟环境和依赖管理工具，结合了 pip 和 virtualenv 的功能。

## 语法

```bash
pipenv [命令] [参数...]
```

## 常用命令

| 命令 | 描述 |
|------|------|
| `install` | 安装依赖 |
| `uninstall` | 卸载依赖 |
| `update` | 更新依赖 |
| `run` | 在虚拟环境中运行命令 |
| `shell` | 激活虚拟环境 |
| `lock` | 生成锁定文件 |
| `sync` | 同步依赖 |
| `check` | 检查安全漏洞 |
| `graph` | 显示依赖图 |
| `--python` | 指定 Python 版本 |

## 示例

### 安装依赖

```bash
pipenv install requests
```

### 安装开发依赖

```bash
pipenv install --dev pytest
```

### 在虚拟环境中运行命令

```bash
pipenv run python main.py
```

### 激活虚拟环境

```bash
pipenv shell
```

### 生成锁定文件

```bash
pipenv lock
```

### 检查安全漏洞

```bash
pipenv check
```

## 注意事项

- `pipenv` 是一个 Python 虚拟环境和依赖管理工具
- `pipenv` 使用 `Pipfile` 和 `Pipfile.lock` 文件来管理依赖
- `pipenv` 会自动创建和管理虚拟环境
- 可以使用 `pipenv --version` 查看当前安装的 pipenv 版本
- `pipenv` 提供了更简洁的虚拟环境管理体验，避免了手动创建和激活虚拟环境的麻烦