# Go 命令子命令

## go build 命令

### 命令说明

`go build` 是 Go 语言的编译命令，用于编译 Go 程序。

### 语法

```bash
go build [选项] [包]
```

### 常用选项

| 选项 | 描述 |
|------|------|
| `-o` | 指定输出文件 |
| `-a` | 强制重新编译 |
| `-race` | 启用竞态检测 |
| `-buildvcs` | 包含版本控制系统信息 |
| `-ldflags` | 传递给链接器的标志 |

### 示例

```bash
# 编译当前目录的包
go build

# 编译指定包
go build github.com/example/myapp

# 指定输出文件
go build -o myapp

# 启用竞态检测
go build -race
```

## go vet 命令

### 命令说明

`go vet` 是 Go 语言的代码检查命令，用于检查 Go 代码中的潜在问题。

### 语法

```bash
go vet [选项] [包]
```

### 常用选项

| 选项 | 描述 |
|------|------|
| `-v` | 详细输出 |
| `-all` | 检查所有包 |
| `-shadow` | 检查变量遮蔽 |

### 示例

```bash
# 检查当前目录的包
go vet

# 检查指定包
go vet github.com/example/myapp

# 详细输出
go vet -v
```

## go mod 命令

### 命令说明

`go mod` 是 Go 语言的模块管理命令，用于管理 Go 模块和依赖。

### 语法

```bash
go mod [子命令] [参数...]
```

### 常用子命令

| 子命令 | 描述 |
|--------|------|
| `init` | 初始化新的模块 |
| `tidy` | 添加缺失的依赖，移除不需要的依赖 |
| `download` | 下载依赖 |
| `vendor` | 将依赖复制到 vendor 目录 |
| `verify` | 验证依赖的校验和 |

### 示例

```bash
# 初始化新的模块
go mod init example.com/myapp

# 添加缺失的依赖，移除不需要的依赖
go mod tidy

# 下载依赖
go mod download

# 将依赖复制到 vendor 目录
go mod vendor
```

## go get 命令

### 命令说明

`go get` 是 Go 语言的依赖获取命令，用于获取和安装依赖包。

### 语法

```bash
go get [选项] [包]
```

### 常用选项

| 选项 | 描述 |
|------|------|
| `-u` | 更新依赖 |
| `-v` | 详细输出 |
| `-d` | 只下载依赖，不安装 |
| `-t` | 同时下载测试依赖 |

### 示例

```bash
# 获取依赖
go get github.com/gin-gonic/gin

# 更新依赖
go get -u github.com/gin-gonic/gin

# 只下载依赖，不安装
go get -d github.com/gin-gonic/gin

# 同时下载测试依赖
go get -t github.com/gin-gonic/gin
```