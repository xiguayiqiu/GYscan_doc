# libtool - 通用库支持脚本

## 1. 命令简介
libtool 是一个用于创建和管理共享库的工具，它可以在不同的系统上提供一致的库管理接口，简化了库的编译和链接过程。libtool 可以处理不同平台的库格式差异，使开发者能够以统一的方式构建和安装库。

## 2. 命令语法
```bash
libtool [选项] [命令] [参数...]
libtool --mode=模式 [选项] [命令] [参数...]
```

## 3. 常用选项

### 3.1 基本选项
| 选项 | 说明 |
|------|------|
| -h, --help | 显示帮助信息 |
| -V, --version | 显示版本信息 |
| -v, --verbose | 详细输出，显示执行过程 |
| -n, --dry-run | 模拟运行，不实际执行命令 |
| --mode=MODE | 指定操作模式 |
| --config | 显示 libtool 的配置信息 |
| --debug | 启用调试模式 |
| --features | 显示 libtool 支持的特性 |

## 4. 命令模式

| 模式 | 说明 |
|------|------|
| compile | 编译源文件，生成 .lo 文件 |
| link | 链接目标文件，生成库文件 |
| install | 安装库到指定位置 |
| uninstall | 从指定位置卸载库 |
| clean | 清理生成的文件 |
| finish | 完成库的安装，更新库缓存 |
| execute | 执行程序，处理库路径 |
| static | 创建静态库 |
| shared | 创建共享库 |

## 5. 实战示例

### 5.1 编译源文件
```bash
# 编译单个源文件
libtool --mode=compile gcc -c file.c

# 编译多个源文件
libtool --mode=compile gcc -c file1.c file2.c

# 带编译选项编译
libtool --mode=compile gcc -Wall -O2 -c file.c
```

### 5.2 链接共享库
```bash
# 链接共享库
libtool --mode=link gcc -o libfoo.la file.lo -rpath /usr/local/lib

# 链接多个目标文件
libtool --mode=link gcc -o libfoo.la file1.lo file2.lo -rpath /usr/local/lib

# 链接时指定其他库
libtool --mode=link gcc -o libfoo.la file.lo -lm -rpath /usr/local/lib
```

### 5.3 安装库
```bash
# 安装库
libtool --mode=install install -c libfoo.la /usr/local/lib/libfoo.la

# 带权限安装
libtool --mode=install install -m 755 -c libfoo.la /usr/local/lib/libfoo.la
```

### 5.4 卸载库
```bash
# 卸载库
libtool --mode=uninstall rm -f /usr/local/lib/libfoo.la
```

### 5.5 清理文件
```bash
# 清理文件
libtool --mode=clean rm -f file.lo libfoo.la

# 清理多个文件
libtool --mode=clean rm -f file1.lo file2.lo libfoo.la
```

### 5.6 完成安装
```bash
# 完成库的安装
libtool --mode=finish /usr/local/lib
```

### 5.7 完整的库构建过程
```bash
# 编译源文件
libtool --mode=compile gcc -c file1.c file2.c

# 链接共享库
libtool --mode=link gcc -o libfoo.la file1.lo file2.lo -rpath /usr/local/lib

# 安装库
libtool --mode=install install -c libfoo.la /usr/local/lib/libfoo.la

# 完成安装
libtool --mode=finish /usr/local/lib
```

### 5.8 在 Makefile 中使用
```Makefile
LIBTOOL = libtool

libfoo.la: file1.lo file2.lo
	$(LIBTOOL) --mode=link gcc -o $@ $^ -rpath /usr/local/lib

file1.lo: file1.c
	$(LIBTOOL) --mode=compile gcc -c $<

file2.lo: file2.c
	$(LIBTOOL) --mode=compile gcc -c $<

install: libfoo.la
	$(LIBTOOL) --mode=install install -c $< /usr/local/lib/$<
	$(LIBTOOL) --mode=finish /usr/local/lib

clean:
	$(LIBTOOL) --mode=clean rm -f file1.lo file2.lo libfoo.la
```

## 6. 高级用法

### 6.1 创建静态库
```bash
# 创建静态库
libtool --mode=link gcc -static -o libfoo.la file1.lo file2.lo

# 或者在链接时指定 -static 选项
libtool --mode=link gcc -o libfoo.la file1.lo file2.lo -static
```

### 6.2 控制库版本
```bash
# 指定库版本
libtool --mode=link gcc -o libfoo.la file.lo -version-info 1:0:0 -rpath /usr/local/lib

# 版本号格式：current:revision:age
# current: 主版本号
# revision: 修订号
# age: 向后兼容的版本数
```

### 6.3 使用 Libtool 宏
```bash
# 在 configure.ac 中使用 Libtool 宏
AC_PROG_LIBTOOL

# 或者使用 LT_INIT
LT_INIT
```

### 6.4 处理依赖库
```bash
# 链接时指定依赖库
libtool --mode=link gcc -o libfoo.la file.lo -lbar -lz -rpath /usr/local/lib

# 链接系统库
libtool --mode=link gcc -o libfoo.la file.lo -lm -lpthread -rpath /usr/local/lib
```

### 6.5 交叉编译
```bash
# 设置交叉编译工具链
export CC=arm-linux-gnueabihf-gcc
export CXX=arm-linux-gnueabihf-g++

# 运行 configure
./configure --host=arm-linux-gnueabihf

# 使用 libtool 编译
libtool --mode=compile $CC -c file.c
libtool --mode=link $CC -o libfoo.la file.lo -rpath /usr/local/lib
```

## 7. 常见问题与解决方案

### 7.1 问题：libtool: command not found
**解决方案**：安装 libtool 工具
- Ubuntu/Debian: `apt install libtool`
- CentOS/RHEL: `yum install libtool`
- macOS: `brew install libtool`

### 7.2 问题：libtool: error: cannot find the library `libfoo.la'
**解决方案**：确保库文件存在，或者正确指定库文件路径

### 7.3 问题：libtool: error: relink `libfoo.la' with the above command before installing it
**解决方案**：重新链接库文件，确保所有依赖都正确

### 7.4 问题：libtool: warning: library `libfoo.la' was moved.
**解决方案**：更新库的路径信息，或者重新安装库

### 7.5 问题：libtool: error: cannot install `libfoo.la' to a directory not ending with /usr/local/lib
**解决方案**：确保安装目录正确，或者使用 -rpath 选项指定正确的安装路径

### 7.6 问题：undefined reference to symbol
**解决方案**：确保链接了所有必要的库，检查库的链接顺序

## 8. 命令对比

| 命令 | 功能 | 适用场景 |
|------|------|----------|
| libtool | 通用库支持脚本 | 跨平台库构建 |
| ar | 创建和修改归档文件 | 静态库管理 |
| ranlib | 生成归档索引 | 静态库索引 |
| ld | 链接器 | 直接链接操作 |
| gcc | GNU C 编译器 | 编译和链接 |
| cmake | 跨平台构建系统 | 现代项目构建 |

## 9. 注意事项
- libtool 是一个用于创建和管理共享库的工具，它可以在不同的系统上提供一致的库管理接口
- libtool 生成的 .lo 文件是对 .o 文件的包装，包含了库的元信息
- libtool 生成的 .la 文件是库的描述文件，包含了库的依赖关系和安装信息
- 使用 libtool 构建的库可以在不同平台上以相同的方式安装和使用
- 完整的 libtool 构建过程通常包括：compile → link → install → finish
- 在使用 libtool 时，应该注意库的版本控制，使用 -version-info 选项指定版本号
- libtool 与 autoconf 和 automake 配合使用，可以构建完整的 GNU 风格项目
- 对于简单的项目，可能不需要使用 libtool，直接使用 gcc 和 ar 即可
- 现代项目越来越多地使用 cmake 或 meson 等构建系统，但 libtool 仍然被许多传统项目使用
- 在交叉编译时，需要正确设置 CC、CXX 等环境变量，确保使用正确的工具链