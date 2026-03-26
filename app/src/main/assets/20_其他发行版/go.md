# go 命令

## 命令说明

`go` 是 Go 语言的命令行工具，用于编译、测试、运行 Go 程序，以及管理 Go 模块和依赖。

## 语法

```bash
go [命令] [参数...]
```

## 常用命令

| 命令 | 描述 |
|------|------|
| `build` | 编译 Go 程序 |
| `vet` | 检查 Go 代码中的潜在问题 |
| `run` | 编译并运行 Go 程序 |
| `test` | 运行测试 |
| `mod` | 管理 Go 模块 |
| `get` | 获取依赖包 |
| `install` | 安装 Go 程序 |
| `fmt` | 格式化 Go 代码 |
| `doc` | 显示文档 |
| `version` | 显示 Go 版本 |

## 示例

### 编译 Go 程序

```bash
go build main.go
```

### 检查 Go 代码

```bash
go vet main.go
```

### 运行 Go 程序

```bash
go run main.go
```

### 管理 Go 模块

```bash
go mod init example.com/myapp
go mod tidy
```

### 获取依赖包

```bash
go get github.com/gin-gonic/gin
```

## 注意事项

- `go` 命令是 Go 语言开发的核心工具
- Go 1.11+ 引入了模块系统，推荐使用 `go mod` 来管理依赖
- `go vet` 可以帮助发现代码中的潜在问题，但不会捕获所有错误
- `go fmt` 可以自动格式化代码，保持代码风格一致