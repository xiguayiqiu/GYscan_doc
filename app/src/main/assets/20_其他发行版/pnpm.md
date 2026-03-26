# pnpm 命令

## 命令说明

`pnpm` 是 Node.js 的包管理器，以空间效率和速度著称，使用硬链接和符号链接来减少磁盘空间使用。

## 语法

```bash
pnpm [命令] [参数...]
```

## 常用命令

| 命令 | 描述 |
|------|------|
| `init` | 初始化新的项目 |
| `add` | 添加依赖 |
| `remove` | 删除依赖 |
| `install` | 安装依赖 |
| `update` | 更新依赖 |
| `run` | 运行脚本 |
| `test` | 运行测试 |
| `publish` | 发布包 |
| `list` | 列出已安装的包 |
| `outdated` | 检查过时的包 |

## 示例

### 初始化新的项目

```bash
pnpm init
```

### 添加依赖

```bash
pnpm add express
```

### 添加开发依赖

```bash
pnpm add -D jest
```

### 安装依赖

```bash
pnpm install
```

### 运行脚本

```bash
pnpm start
```

### 检查过时的包

```bash
pnpm outdated
```

## 注意事项

- `pnpm` 是一个高效的 Node.js 包管理器
- `pnpm` 使用硬链接和符号链接来减少磁盘空间使用
- `pnpm` 使用 `pnpm-lock.yaml` 文件来确保依赖的一致性
- 可以使用 `pnpm --version` 查看当前安装的 pnpm 版本
- `pnpm` 支持工作区（workspaces）功能，适合管理多包项目