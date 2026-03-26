# zig 命令

## 命令说明

`zig` 是 Zig 语言的命令行工具，用于编译、测试和运行 Zig 程序。

## 语法

```bash
zig [命令] [参数...]
```

## 常用命令

| 命令 | 描述 |
|------|------|
| `build` | 构建项目 |
| `run` | 运行程序 |
| `test` | 运行测试 |
| `fmt` | 格式化代码 |
| `init` | 初始化项目 |
| `version` | 显示版本信息 |

## 示例

### 编译并运行 Zig 程序

```bash
zig run hello.zig
```

### 构建项目

```bash
zig build
```

### 运行测试

```bash
zig test
```

### 格式化代码

```bash
zig fmt hello.zig
```

### 初始化项目

```bash
zig init-exe
```

## 注意事项

- `zig` 是 Zig 语言的命令行工具
- Zig 是一种系统编程语言，注重安全性、性能和可维护性
- 可以使用 `zig version` 查看当前安装的 zig 版本
- Zig 支持交叉编译，可以为不同平台生成可执行文件
- Zig 的构建系统使用 `build.zig` 文件来定义构建过程