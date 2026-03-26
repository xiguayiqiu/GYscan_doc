# yarn 命令

## 命令说明

`yarn` 是 Node.js 的包管理器，是 npm 的替代品，提供了更快、更可靠的依赖管理。

## 语法

```bash
yarn [命令] [参数...]
```

## 常用命令

| 命令 | 描述 |
|------|------|
| `init` | 初始化新的项目 |
| `add` | 添加依赖 |
| `remove` | 删除依赖 |
| `install` | 安装依赖 |
| `upgrade` | 升级依赖 |
| `run` | 运行脚本 |
| `test` | 运行测试 |
| `publish` | 发布包 |
| `list` | 列出已安装的包 |
| `outdated` | 检查过时的包 |

## 示例

### 初始化新的项目

```bash
yarn init
```

### 添加依赖

```bash
yarn add express
```

### 添加开发依赖

```bash
yarn add --dev jest
```

### 安装依赖

```bash
yarn install
```

### 运行脚本

```bash
yarn start
```

### 检查过时的包

```bash
yarn outdated
```

## 注意事项

- `yarn` 是 Facebook 开发的 Node.js 包管理器
- `yarn` 使用 `yarn.lock` 文件来确保依赖的一致性
- `yarn` 比 npm 更快，因为它会缓存已下载的包
- 可以使用 `yarn --version` 查看当前安装的 yarn 版本