# cargo 命令

## 命令说明

`cargo` 是 Rust 语言的包管理器和构建工具，用于创建、构建、测试和发布 Rust 项目。

## 语法

```bash
cargo [命令] [参数...]
```

## 常用命令

| 命令 | 描述 |
|------|------|
| `new` | 创建新的 Rust 项目 |
| `build` | 构建 Rust 项目 |
| `check` | 检查 Rust 代码，不生成可执行文件 |
| `run` | 构建并运行 Rust 项目 |
| `test` | 运行测试 |
| `doc` | 生成文档 |
| `publish` | 发布包到 crates.io |
| `add` | 添加依赖 |
| `remove` | 删除依赖 |
| `update` | 更新依赖 |

## 示例

### 创建新的 Rust 项目

```bash
cargo new myproject
```

### 构建 Rust 项目

```bash
cargo build
```

### 检查 Rust 代码

```bash
cargo check
```

### 运行 Rust 项目

```bash
cargo run
```

### 运行测试

```bash
cargo test
```

### 添加依赖

```bash
cargo add serde
```

## 注意事项

- `cargo` 是 Rust 生态系统的核心工具
- `cargo check` 比 `cargo build` 更快，因为它只检查代码而不生成可执行文件
- `cargo` 使用 `Cargo.toml` 文件来管理项目配置和依赖
- 可以使用 `cargo --version` 查看当前安装的 Cargo 版本