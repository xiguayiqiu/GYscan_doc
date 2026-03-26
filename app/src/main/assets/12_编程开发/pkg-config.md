# pkg-config - 编译和链接配置工具

## 1. 命令简介
pkg-config 是一个用于查询已安装库的编译选项和链接选项的工具，它可以帮助开发者在编译时正确设置包含路径、库路径和链接标志。它通过读取库的 .pc 文件来获取这些信息，简化了编译命令的编写。

## 2. 命令语法
```bash
pkg-config [选项] [包名...]
pkg-config [选项] --print-errors [包名...]
```

## 3. 常用选项

### 3.1 基本选项
| 选项 | 说明 |
|------|------|
| --cflags | 输出编译标志，包括包含路径 |
| --libs | 输出链接标志，包括库路径和库名 |
| --libs-only-L | 只输出库路径（-L 选项） |
| --libs-only-l | 只输出库名（-l 选项） |
| --libs-only-other | 只输出其他链接选项 |
| --cflags-only-I | 只输出包含路径（-I 选项） |
| --cflags-only-other | 只输出其他编译选项 |
| --version | 显示 pkg-config 版本信息 |
| --help | 显示帮助信息 |

### 3.2 查询选项
| 选项 | 说明 |
|------|------|
| --exists | 检查指定的包是否存在 |
| --atleast-version=VERSION | 检查包版本是否至少为指定版本 |
| --exact-version=VERSION | 检查包版本是否与指定版本完全匹配 |
| --max-version=VERSION | 检查包版本是否不超过指定版本 |
| --print-errors | 打印错误信息 |
| --silence-errors | 不打印错误信息 |

### 3.3 信息选项
| 选项 | 说明 |
|------|------|
| --modversion | 显示包的版本信息 |
| --describe | 显示包的描述信息 |
| --list-all | 列出所有可用的包 |
| --print-variables | 显示包的所有变量 |
| --variable=VAR | 显示包的指定变量值 |
| --define-variable=VAR=VALUE | 定义或覆盖变量值 |

### 3.4 路径选项
| 选项 | 说明 |
|------|------|
| --prefix=DIR | 设置前缀目录 |
| --exec-prefix=DIR | 设置可执行文件前缀目录 |
| --debug | 显示调试信息 |
| --keep-system-libs | 保留系统库路径 |
| --static | 输出静态链接的标志 |

## 4. 实战示例

### 4.1 获取编译标志
```bash
pkg-config --cflags glib-2.0
```

### 4.2 获取链接标志
```bash
pkg-config --libs glib-2.0
```

### 4.3 同时获取编译和链接标志
```bash
pkg-config --cflags --libs glib-2.0
```

### 4.4 检查包是否存在
```bash
pkg-config --exists glib-2.0 && echo "glib-2.0 is installed"
```

### 4.5 检查包版本
```bash
pkg-config --atleast-version=2.0 glib-2.0 && echo "glib-2.0 version is at least 2.0"
```

### 4.6 获取包的版本信息
```bash
pkg-config --modversion glib-2.0
```

### 4.7 列出所有可用的包
```bash
pkg-config --list-all
```

### 4.8 获取包的描述信息
```bash
pkg-config --describe glib-2.0
```

### 4.9 在编译命令中使用
```bash
gcc -o program program.c $(pkg-config --cflags --libs glib-2.0)
```

### 4.10 在Makefile中使用
```Makefile
CFLAGS += $(shell pkg-config --cflags glib-2.0)
LDFLAGS += $(shell pkg-config --libs glib-2.0)

program: program.c
	$(CC) $(CFLAGS) $(LDFLAGS) -o $@ $^
```

### 4.11 多个包的使用
```bash
pkg-config --cflags --libs gtk+-3.0 glib-2.0
```

### 4.12 静态链接
```bash
pkg-config --static --libs glib-2.0
```

## 5. 高级用法

### 5.1 自定义 pkg-config 路径
```bash
# 设置 PKG_CONFIG_PATH 环境变量
export PKG_CONFIG_PATH=/usr/local/lib/pkgconfig:/usr/lib/pkgconfig

# 然后使用 pkg-config
pkg-config --cflags --libs glib-2.0
```

### 5.2 检查多个包的版本
```bash
# 检查多个包是否存在且版本满足要求
if pkg-config --exists "glib-2.0 >= 2.40" "gtk+-3.0 >= 3.10"; then
    echo "All dependencies are satisfied"
else
    echo "Some dependencies are missing or outdated"
fi
```

### 5.3 在 shell 脚本中使用
```bash
#!/bin/bash

# 检查必要的包
required_packages=("glib-2.0" "gtk+-3.0" "libxml-2.0")

for pkg in "${required_packages[@]}"; do
    if ! pkg-config --exists "$pkg"; then
        echo "Error: $pkg is not installed"
        exit 1
    fi
    echo "Found $pkg version $(pkg-config --modversion "$pkg")"
done

# 编译程序
gcc -o myapp main.c $(pkg-config --cflags --libs "${required_packages[@]}")
```

### 5.4 创建自定义 .pc 文件
```
# 创建一个名为 mylib.pc 的文件
prefix=/usr/local
exec_prefix=${prefix}
libdir=${exec_prefix}/lib
includedir=${prefix}/include

Name: My Library
Description: A sample library
Version: 1.0.0
Libs: -L${libdir} -lmylib
Cflags: -I${includedir}
```

### 5.5 使用变量
```bash
# 获取包的前缀目录
prefix=$(pkg-config --variable=prefix glib-2.0)
echo "GLib prefix: $prefix"

# 获取包的包含目录
includedir=$(pkg-config --variable=includedir glib-2.0)
echo "GLib include directory: $includedir"
```

## 6. 常见问题与解决方案

### 6.1 问题：pkg-config: command not found
**解决方案**：安装 pkg-config 工具
- Ubuntu/Debian: `apt install pkg-config`
- CentOS/RHEL: `yum install pkgconfig`
- macOS: `brew install pkg-config`

### 6.2 问题：Package 'xxx' not found
**解决方案**：
1. 确保该包已安装
2. 检查 PKG_CONFIG_PATH 环境变量是否正确设置
3. 对于自定义安装的库，确保 .pc 文件在 pkg-config 的搜索路径中

### 6.3 问题：No package 'xxx' found
**解决方案**：
1. 安装相应的开发包，通常包名以 -dev 或 -devel 结尾
2. 例如：`apt install libglib2.0-dev`

### 6.4 问题：pkg-config 找不到已安装的库
**解决方案**：
1. 检查库的 .pc 文件是否存在
2. 确保 PKG_CONFIG_PATH 包含 .pc 文件所在的目录
3. 运行 `pkg-config --debug --libs xxx` 查看详细信息

### 6.5 问题：编译时出现链接错误
**解决方案**：
1. 确保使用了正确的 pkg-config 命令获取链接标志
2. 检查库是否正确安装
3. 尝试使用 `--static` 选项获取静态链接标志

## 7. 命令对比

| 命令 | 功能 | 适用场景 |
|------|------|----------|
| pkg-config | 查询库的编译和链接选项 | 标准工具，广泛使用 |
| pkgconf | pkg-config 的替代实现 | 更轻量，性能更好 |
| pkg-config-wrapper | 包装器脚本 | 处理特殊情况 |
| cmake | 跨平台构建系统 | 大型项目，跨平台开发 |
| autoconf | 自动配置脚本生成器 | 传统 Unix 项目 |

## 8. 注意事项
- pkg-config 通过读取 .pc 文件来获取库的信息，这些文件通常位于 /usr/lib/pkgconfig、/usr/local/lib/pkgconfig 等目录
- 可以通过设置 PKG_CONFIG_PATH 环境变量来自定义搜索路径
- 对于多个包，可以在一个命令中指定所有包名，pkg-config 会自动处理依赖关系
- 使用 `--static` 选项可以获取静态链接的标志，这在需要静态编译时非常有用
- 在 Makefile 中使用时，需要使用 `$(shell pkg-config ...)` 来执行 pkg-config 命令
- 一些库可能提供多个版本的 .pc 文件，如 gtk+-2.0 和 gtk+-3.0，需要根据需要选择正确的版本
- 对于自定义安装的库，需要确保 .pc 文件被正确安装到 pkg-config 的搜索路径中
- pkg-config 是构建系统的重要组成部分，许多开源项目都依赖它来处理依赖关系
- 在交叉编译时，需要使用相应的 pkg-config 工具链或设置 PKG_CONFIG_LIBDIR 环境变量