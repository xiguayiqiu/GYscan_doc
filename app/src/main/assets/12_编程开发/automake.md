# automake - Makefile生成器

## 1. 命令简介
automake 是一个用于生成 Makefile.in 文件的工具，它可以根据 `Makefile.am` 文件生成符合 GNU 标准的 Makefile.in 文件，与 autoconf 配合使用。automake 是 GNU 构建系统的重要组件，用于简化 Makefile 的编写和维护。

## 2. 命令语法
```bash
automake [选项] [Makefile]
automake [选项] --add-missing [Makefile]
```

## 3. 常用选项

### 3.1 基本选项
| 选项 | 说明 |
|------|------|
| -h, --help | 显示帮助信息 |
| -V, --version | 显示版本信息 |
| -v, --verbose | 详细输出，显示处理过程 |
| -d, --debug | 调试模式，显示更多调试信息 |
| -f, --force | 强制生成，即使文件未更改 |
| -i, --ignore-deps | 忽略依赖关系 |
| --add-missing | 添加缺失的辅助文件 |
| --copy | 复制文件而不是创建符号链接 |
| --no-force | 不强制生成 |
| --foreign | 使用 foreign 模式，不要求严格遵循 GNU 标准 |
| --gnu | 使用 gnu 模式，严格遵循 GNU 标准 |
| --cygnus | 使用 cygnus 模式，用于 Cygnus 风格的项目 |
| --include-deps | 包含依赖关系 |
| --no-include-deps | 不包含依赖关系 |
| --warn-no-portability | 警告非可移植性问题 |
| --no-warn-no-portability | 不警告非可移植性问题 |

### 3.2 警告选项
| 选项 | 说明 |
|------|------|
| -Wnone | 禁用所有警告 |
| -Wall | 启用所有警告 |
| -Werror | 将警告视为错误 |
| -Wno-error | 不将警告视为错误 |

## 4. 实战示例

### 4.1 基本用法
```bash
# 从默认的 Makefile.am 生成 Makefile.in
automake
```

### 4.2 添加缺失的文件
```bash
# 生成 Makefile.in 并添加缺失的辅助文件
automake --add-missing
```

### 4.3 详细输出
```bash
# 显示详细的处理过程
automake --verbose
```

### 4.4 强制生成
```bash
# 即使文件未更改，也强制重新生成
automake --force
```

### 4.5 使用 foreign 模式
```bash
# 使用 foreign 模式，不要求严格遵循 GNU 标准
automake --foreign
```

### 4.6 完整的构建过程
```bash
# 生成 aclocal.m4
aclocal

# 生成 config.h.in
autoheader

# 生成 configure 脚本
autoconf

# 生成 Makefile.in
automake --add-missing

# 配置
./configure

# 编译
make

# 安装
make install
```

### 4.7 使用 autoreconf 简化过程
```bash
# 自动运行 autoconf、automake 等工具
autoreconf --install

# 配置
./configure

# 编译
make

# 安装
make install
```

## 5. 高级用法

### 5.1 编写 Makefile.am 文件
```bash
# 基本的 Makefile.am 文件示例
cat > Makefile.am << 'EOF'
bin_PROGRAMS = hello
hello_SOURCES = hello.c
EOF
```

### 5.2 定义多个目标
```bash
# 定义多个可执行文件
bin_PROGRAMS = hello world
hello_SOURCES = hello.c
world_SOURCES = world.c

# 定义库文件
lib_LIBRARIES = libhello.a
libhello_a_SOURCES = hello_lib.c
```

### 5.3 设置编译选项
```bash
# 设置编译选项
AM_CFLAGS = -Wall -O2

# 为特定目标设置编译选项
hello_CFLAGS = $(AM_CFLAGS) -DDEBUG
```

### 5.4 处理头文件
```bash
# 安装头文件
include_HEADERS = hello.h

# 头文件搜索路径
AM_CPPFLAGS = -I$(top_srcdir)/include
```

### 5.5 处理依赖关系
```bash
# 依赖关系
hello_DEPENDENCIES = libhello.a

# 链接选项
hello_LDADD = libhello.a
```

### 5.6 安装数据文件
```bash
# 安装数据文件
data_DATA = data.txt

# 安装目录
datadir = $(prefix)/share/myapp
```

## 6. 常见问题与解决方案

### 6.1 问题：automake: command not found
**解决方案**：安装 automake 工具
- Ubuntu/Debian: `apt install automake`
- CentOS/RHEL: `yum install automake`
- macOS: `brew install automake`

### 6.2 问题：error: no Makefile.am found
**解决方案**：创建 Makefile.am 文件，或者使用 `automake --add-missing` 生成默认的 Makefile.am

### 6.3 问题：error: required file 'configure.ac' not found
**解决方案**：确保当前目录存在 configure.ac 文件，或者使用 autoconf 生成

### 6.4 问题：error: AM_INIT_AUTOMAKE was not called
**解决方案**：在 configure.ac 文件中添加 AM_INIT_AUTOMAKE 宏

### 6.5 问题：warning: 'AM_PROG_LIBTOOL' is used, but 'LIBTOOL' is undefined
**解决方案**：安装 libtool 并在 configure.ac 文件中添加 LT_INIT 宏

### 6.6 问题：Makefile.in: error: undefined variable 'top_builddir'
**解决方案**：确保 configure.ac 文件中使用了 AC_CONFIG_FILES 宏正确配置了 Makefile

## 7. 命令对比

| 命令 | 功能 | 适用场景 |
|------|------|----------|
| automake | 生成 Makefile.in | 生成 Makefile 模板 |
| autoconf | 生成 configure 脚本 | 生成自动配置脚本 |
| autoheader | 生成 config.h.in | 生成配置头文件模板 |
| aclocal | 生成 aclocal.m4 | 收集宏定义 |
| autoreconf | 自动运行多个工具 | 简化构建过程 |
| cmake | 跨平台构建系统 | 跨平台项目 |
| meson | 现代构建系统 | 现代项目 |

## 8. 注意事项
- automake 是 GNU 构建系统的重要组件，用于生成 Makefile.in 文件
- automake 根据 Makefile.am 文件生成 Makefile.in 文件，Makefile.in 文件是 configure 脚本的输入之一
- 完整的 GNU 构建过程通常包括：aclocal → autoheader → autoconf → automake → ./configure → make → make install
- 使用 autoreconf 可以简化这个过程，它会自动运行所有必要的工具
- Makefile.am 文件使用一种简化的语法，比直接编写 Makefile 更易于维护
- 常见的 Makefile.am 变量包括 bin_PROGRAMS、SOURCES、LIBRARIES 等
- automake 支持多种模式，包括 gnu、foreign 和 cygnus，其中 foreign 模式对项目结构要求最宽松
- 当使用 --add-missing 选项时，automake 会添加缺失的辅助文件，如 INSTALL、NEWS、README 等
- 对于复杂的项目，可能需要在 Makefile.am 文件中定义多个目标和依赖关系
- 现代项目越来越多地使用 cmake 或 meson 等构建系统，但 automake 仍然被许多传统项目使用