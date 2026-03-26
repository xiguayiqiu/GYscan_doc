# Cargo 命令子命令

## cargo build 命令

### 命令说明

`cargo build` 是 Rust 语言的编译命令，用于构建 Rust 项目。

### 语法

```bash
cargo build [选项]
```

### 常用选项

| 选项 | 描述 |
|------|------|
| `--release` | 构建发布版本 |
| `--debug` | 构建调试版本 |
| `--target` | 指定目标平台 |
| `--features` | 启用特定功能 |
| `--all-features` | 启用所有功能 |

### 示例

```bash
# 构建调试版本
cargo build

# 构建发布版本
cargo build --release

# 指定目标平台
cargo build --target x86_64-unknown-linux-gnu

# 启用特定功能
cargo build --features "serde/json"
```

## cargo check 命令

### 命令说明

`cargo check` 是 Rust 语言的代码检查命令，用于检查 Rust 代码，不生成可执行文件。

### 语法

```bash
cargo check [选项]
```

### 常用选项

| 选项 | 描述 |
|------|------|
| `--release` | 检查发布版本 |
| `--target` | 指定目标平台 |
| `--features` | 启用特定功能 |
| `--all-features` | 启用所有功能 |

### 示例

```bash
# 检查代码
cargo check

# 检查发布版本
cargo check --release

# 启用特定功能检查
cargo check --features "serde/json"
```

## cargo test 命令

### 命令说明

`cargo test` 是 Rust 语言的测试命令，用于运行 Rust 项目的测试。

### 语法

```bash
cargo test [选项] [测试名称]
```

### 常用选项

| 选项 | 描述 |
|------|------|
| `--release` | 运行发布版本的测试 |
| `--target` | 指定目标平台 |
| `--features` | 启用特定功能 |
| `--all-features` | 启用所有功能 |
| `--nocapture` | 显示测试的标准输出 |

### 示例

```bash
# 运行所有测试
cargo test

# 运行特定测试
cargo test test_function

# 运行发布版本的测试
cargo test --release

# 显示测试的标准输出
cargo test --nocapture
```

## cargo run 命令

### 命令说明

`cargo run` 是 Rust 语言的运行命令，用于构建并运行 Rust 项目。

### 语法

```bash
cargo run [选项] [参数...]
```

### 常用选项

| 选项 | 描述 |
|------|------|
| `--release` | 构建并运行发布版本 |
| `--target` | 指定目标平台 |
| `--features` | 启用特定功能 |
| `--all-features` | 启用所有功能 |

### 示例

```bash
# 构建并运行项目
cargo run

# 构建并运行发布版本
cargo run --release

# 传递参数给程序
cargo run -- arg1 arg2

# 启用特定功能运行
cargo run --features "serde/json"
```