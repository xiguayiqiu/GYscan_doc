# poetry 命令

## 命令说明

`poetry` 是 Python 的依赖管理和打包工具，提供了更现代的依赖管理方式。

## 语法

```bash
poetry [命令] [参数...]
```

## 常用命令

| 命令 | 描述 |
|------|------|
| `new` | 创建新的项目 |
| `init` | 初始化项目 |
| `add` | 添加依赖 |
| `remove` | 删除依赖 |
| `install` | 安装依赖 |
| `update` | 更新依赖 |
| `run` | 运行脚本 |
| `build` | 构建项目 |
| `publish` | 发布包 |
| `shell` | 激活虚拟环境 |

## 示例

### 创建新的项目

```bash
poetry new myproject
```

### 初始化项目

```bash
poetry init
```

### 添加依赖

```bash
poetry add requests
```

### 添加开发依赖

```bash
poetry add --dev pytest
```

### 安装依赖

```bash
poetry install
```

### 运行脚本

```bash
poetry run python main.py
```

### 激活虚拟环境

```bash
poetry shell
```

## 注意事项

- `poetry` 是一个现代的 Python 依赖管理工具
- `poetry` 使用 `pyproject.toml` 文件来管理项目配置和依赖
- `poetry` 会自动创建和管理虚拟环境
- 可以使用 `poetry --version` 查看当前安装的 poetry 版本
- `poetry` 提供了更简洁的依赖管理体验，避免了手动管理虚拟环境的麻烦