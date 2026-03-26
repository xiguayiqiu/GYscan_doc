# npm 命令

## 命令说明

`npm` 是 Node.js 的包管理器，用于安装、更新、删除 Node.js 包。

## 语法

```bash
npm [命令] [参数...]
```

## 常用命令

| 命令 | 描述 |
|------|------|
| `init` | 初始化新的 npm 项目 |
| `install` | 安装包 |
| `uninstall` | 卸载包 |
| `update` | 更新包 |
| `list` | 列出已安装的包 |
| `outdated` | 检查过时的包 |
| `run` | 运行脚本 |
| `test` | 运行测试 |
| `publish` | 发布包到 npm  registry |
| `search` | 搜索包 |

## 常用选项

| 选项 | 描述 |
|------|------|
| `-g` | 全局安装 |
| `--save` | 保存为依赖 |
| `--save-dev` | 保存为开发依赖 |
| `--save-optional` | 保存为可选依赖 |

## 示例

### 初始化新的 npm 项目

```bash
npm init
```

### 安装包

```bash
npm install express
```

### 全局安装包

```bash
npm install -g nodemon
```

### 安装开发依赖

```bash
npm install --save-dev jest
```

### 运行脚本

```bash
npm run start
```

### 检查过时的包

```bash
npm outdated
```

## 注意事项

- `npm` 是 Node.js 生态系统的核心工具
- `npm` 使用 `package.json` 文件来管理项目配置和依赖
- 可以使用 `npm --version` 查看当前安装的 npm 版本
- 推荐使用 `npm ci` 来安装依赖，特别是在 CI/CD 环境中