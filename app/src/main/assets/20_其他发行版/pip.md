# pip 命令

## 命令说明

`pip` 是 Python 的包管理器，用于安装、更新、删除 Python 包。

## 语法

```bash
pip [命令] [参数...]
```

## 常用命令

| 命令 | 描述 |
|------|------|
| `install` | 安装包 |
| `uninstall` | 卸载包 |
| `list` | 列出已安装的包 |
| `show` | 显示包信息 |
| `freeze` | 输出已安装包的版本信息 |
| `update` | 更新包 |
| `check` | 检查包的依赖关系 |
| `search` | 搜索包 |

## 常用选项

| 选项 | 描述 |
|------|------|
| `-r` | 从文件安装依赖 |
| `-e` | 以可编辑模式安装包 |
| `--upgrade` | 升级包 |
| `--user` | 安装到用户目录 |

## 示例

### 安装包

```bash
pip install requests
```

### 升级包

```bash
pip install --upgrade requests
```

### 从文件安装依赖

```bash
pip install -r requirements.txt
```

### 列出已安装的包

```bash
pip list
```

### 输出已安装包的版本信息

```bash
pip freeze > requirements.txt
```

### 卸载包

```bash
pip uninstall requests
```

## 注意事项

- `pip` 是 Python 生态系统的核心工具
- Python 3.4+ 已经内置了 `pip`
- 可以使用 `pip --version` 查看当前安装的 pip 版本
- 推荐使用虚拟环境来管理 Python 包，避免全局安装导致的依赖冲突