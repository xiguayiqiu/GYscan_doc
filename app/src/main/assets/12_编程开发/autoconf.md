# autoconf - 自动配置脚本生成器

## 1. 命令简介
autoconf 是一个用于生成自动配置脚本的工具，它可以根据 `configure.ac` 文件生成 `configure` 脚本，用于在不同的系统上自动配置软件包。autoconf 是 GNU 构建系统的核心组件之一，广泛用于开源软件的构建过程。

## 2. 命令语法
```bash
autoconf [选项] [模板文件]
autoconf [选项] -o 输出文件 模板文件
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
| -i, --include=DIR | 添加宏文件的包含目录 |
| -o, --output=FILE | 指定输出文件 |
| -W, --warnings=类别 | 控制警告信息 |

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
# 从默认的 configure.ac 生成 configure 脚本
autoconf
```

### 4.2 指定模板文件
```bash
# 从指定的模板文件生成 configure 脚本
autoconf myconfigure.ac -o configure
```

### 4.3 详细输出
```bash
# 显示详细的处理过程
autoconf --verbose
```

### 4.4 强制生成
```bash
# 即使文件未更改，也强制重新生成
autoconf --force
```

### 4.5 指定包含目录
```bash
# 添加自定义宏文件目录
autoconf --include=/usr/local/share/aclocal
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

### 5.1 编写 configure.ac 文件
```bash
# 基本的 configure.ac 文件示例
cat > configure.ac << 'EOF'
AC_INIT([myproject], [1.0.0], [bug-report@example.com])
AM_INIT_AUTOMAKE([-Wall -Werror foreign])
AC_PROG_CC
AC_OUTPUT([Makefile])
EOF
```

### 5.2 检查编译器特性
```bash
# 检查 C 编译器
AC_PROG_CC

# 检查 C++ 编译器
AC_PROG_CXX

# 检查特定的编译器选项
AC_CHECK_CFLAGS([-Wall], [], [])
```

### 5.3 检查库和头文件
```bash
# 检查头文件
AC_CHECK_HEADERS([stdio.h stdlib.h])

# 检查库
AC_CHECK_LIB([m], [sqrt])

# 检查函数
AC_CHECK_FUNCS([strdup])
```

### 5.4 处理条件编译
```bash
# 定义条件
AC_ARG_ENABLE([debug],
    [AS_HELP_STRING([--enable-debug], [Enable debug mode])],
    [debug=$enableval],
    [debug=no]
)

# 根据条件设置编译选项
if test "x$debug" = "xyes"; then
    CFLAGS="$CFLAGS -g"
fi
```

### 5.5 生成配置头文件
```bash
# 在 configure.ac 中添加
AC_CONFIG_HEADERS([config.h])

# 运行 autoheader 生成 config.h.in
autoheader
```

## 6. 常见问题与解决方案

### 6.1 问题：autoconf: command not found
**解决方案**：安装 autoconf 工具
- Ubuntu/Debian: `apt install autoconf`
- CentOS/RHEL: `yum install autoconf`
- macOS: `brew install autoconf`

### 6.2 问题：error: possibly undefined macro: AM_INIT_AUTOMAKE
**解决方案**：运行 aclocal 生成 aclocal.m4 文件
```bash
aclocal
```

### 6.3 问题：error: cannot find input file: `configure.ac'
**解决方案**：确保当前目录存在 configure.ac 文件，或者指定正确的模板文件路径

### 6.4 问题：warning: AC_SUBST called with invalid shell variable name
**解决方案**：确保 AC_SUBST 的参数是有效的 shell 变量名

### 6.5 问题：configure: error: C compiler cannot create executables
**解决方案**：确保 C 编译器已正确安装，并且可以正常工作

### 6.6 问题：automake: error: no Makefile.am found
**解决方案**：创建 Makefile.am 文件，或者使用 `automake --add-missing` 生成默认的 Makefile.am

## 7. 命令对比

| 命令 | 功能 | 适用场景 |
|------|------|----------|
| autoconf | 生成 configure 脚本 | 生成自动配置脚本 |
| automake | 生成 Makefile.in | 生成 Makefile 模板 |
| autoheader | 生成 config.h.in | 生成配置头文件模板 |
| aclocal | 生成 aclocal.m4 | 收集宏定义 |
| autoreconf | 自动运行多个工具 | 简化构建过程 |
| cmake | 跨平台构建系统 | 跨平台项目 |
| meson | 现代构建系统 | 现代项目 |

## 8. 注意事项
- autoconf 是 GNU 构建系统的核心组件之一，用于生成自动配置脚本
- autoconf 根据 configure.ac 文件生成 configure 脚本，configure 脚本用于在不同系统上自动配置软件包
- 完整的 GNU 构建过程通常包括：aclocal → autoheader → autoconf → automake → ./configure → make → make install
- 使用 autoreconf 可以简化这个过程，它会自动运行所有必要的工具
- configure.ac 文件使用 M4 宏语言编写，包含各种检查和配置指令
- 常见的宏包括 AC_INIT、AM_INIT_AUTOMAKE、AC_PROG_CC、AC_OUTPUT 等
- autoconf 生成的 configure 脚本是一个 shell 脚本，它会检查系统环境、编译器、库等，并生成适合当前系统的 Makefile
- 对于跨平台项目，autoconf 可以帮助处理不同系统之间的差异
- 现代项目越来越多地使用 cmake 或 meson 等构建系统，但 autoconf 仍然被许多传统项目使用
- 在使用 autoconf 时，应该注意保持 configure.ac 文件的清晰和可维护性