# gcc - GNU C编译器

## 1. 命令简介
gcc 是 GNU 编译器集合（GCC）中的 C 编译器，用于编译 C、C++、Objective-C 等语言的程序。它是 Linux 系统中最常用的编译器之一，广泛应用于各种项目的开发。

## 2. 命令语法
```bash
gcc [选项] 文件...
gcc [选项] -o 输出文件 源文件...
```

## 3. 常用选项

### 3.1 基本编译选项
| 选项 | 说明 |
|------|------|
| -c | 编译但不链接，生成目标文件（.o） |
| -o FILE | 指定输出文件 |
| -g | 生成调试信息，供调试器使用 |
| -O[0-3] | 优化级别，0表示无优化，3表示最高优化 |
| -Wall | 显示所有警告信息 |
| -Werror | 将警告视为错误 |
| -std=标准 | 指定语言标准，如c99、c11、c17等 |
| -I DIR | 指定头文件搜索目录 |
| -L DIR | 指定库文件搜索目录 |
| -l LIB | 链接指定的库文件 |

### 3.2 警告选项
| 选项 | 说明 |
|------|------|
| -Wextra | 显示额外的警告信息 |
| -Wpedantic | 显示严格符合标准的警告 |
| -Wshadow | 警告变量 shadowing 问题 |
| -Wpointer-arith | 警告指针算术运算问题 |
| -Wcast-align | 警告指针对齐问题 |
| -Wconversion | 警告类型转换问题 |

### 3.3 调试选项
| 选项 | 说明 |
|------|------|
| -g | 生成调试信息 |
| -ggdb | 生成适合 GDB 的调试信息 |
| -gdwarf-4 | 指定调试信息格式 |

### 3.4 优化选项
| 选项 | 说明 |
|------|------|
| -O0 | 无优化 |
| -O1 | 基本优化 |
| -O2 | 更多优化 |
| -O3 | 最高优化 |
| -Os | 优化代码大小 |
| -Ofast | 快速优化，可能违反标准 |

## 4. 实战示例

### 4.1 编译单个C文件
```bash
gcc hello.c -o hello
```

### 4.2 编译多个C文件
```bash
gcc file1.c file2.c -o program
```

### 4.3 带调试信息编译
```bash
gcc -g hello.c -o hello
```

### 4.4 优化编译
```bash
gcc -O2 hello.c -o hello
```

### 4.5 指定语言标准
```bash
gcc -std=c11 hello.c -o hello
```

### 4.6 链接库文件
```bash
gcc hello.c -lm -o hello
```

### 4.7 编译为目标文件
```bash
gcc -c hello.c
```

### 4.8 链接目标文件
```bash
gcc hello.o -o hello
```

### 4.9 指定头文件和库文件目录
```bash
gcc -I/include -L/lib -lm hello.c -o hello
```

### 4.10 显示所有警告
```bash
gcc -Wall -Wextra hello.c -o hello
```

## 5. 高级用法

### 5.1 交叉编译
```bash
# 为 ARM 架构编译
gcc -march=armv7-a -mtune=cortex-a9 hello.c -o hello

# 使用交叉编译器
aarch64-linux-gnu-gcc hello.c -o hello
```

### 5.2 生成汇编代码
```bash
# 生成汇编代码
gcc -S hello.c

# 查看汇编代码
cat hello.s
```

### 5.3 预处理、编译、汇编、链接分步操作
```bash
# 预处理
gcc -E hello.c -o hello.i

# 编译
gcc -S hello.i -o hello.s

# 汇编
gcc -c hello.s -o hello.o

# 链接
gcc hello.o -o hello
```

### 5.4 检查编译过程
```bash
# 显示编译过程
gcc -v hello.c -o hello

# 显示预处理后的代码
gcc -E hello.c
```

### 5.5 生成静态库和动态库
```bash
# 生成静态库
gcc -c lib.cnar rcs lib.a lib.o

# 链接静态库
gcc hello.c -L. -llib -o hello

# 生成动态库
gcc -shared -fPIC lib.c -o lib.so

# 链接动态库
gcc hello.c -L. -llib -o hello
```

## 6. 常见问题与解决方案

### 6.1 问题：undefined reference to `function'
**解决方案**：确保函数已定义，或链接了包含该函数的库文件

### 6.2 问题：fatal error: header.h: No such file or directory
**解决方案**：使用 -I 选项指定头文件目录，确保头文件存在

### 6.3 问题：warning: implicit declaration of function
**解决方案**：添加函数声明，或包含相应的头文件

### 6.4 问题：error: incompatible types
**解决方案**：检查变量类型，确保类型匹配

### 6.5 问题：error: division by zero
**解决方案**：检查代码中的除法操作，避免除以零

### 6.6 问题：编译速度慢
**解决方案**：使用并行编译，或减少优化级别

## 7. 命令对比

| 命令 | 功能 | 适用场景 |
|------|------|----------|
| gcc | GNU C 编译器 | C 语言程序编译 |
| g++ | GNU C++ 编译器 | C++ 语言程序编译 |
| clang | LLVM 编译器 | 现代 C/C++ 编译，错误信息更友好 |
| icc | Intel 编译器 | Intel 平台优化 |
| tcc | Tiny C 编译器 | 快速编译，适合小型程序 |

## 8. 注意事项
- gcc 是 GNU 编译器集合的一部分，支持多种编程语言
- 对于 C++ 程序，通常使用 g++ 命令，它会自动链接 C++ 标准库
- 可以使用 `gcc --version` 查看当前安装的 gcc 版本
- gcc 支持多种语言标准，可以通过 `-std` 选项指定，如 c99、c11、c17 等
- 编译大型项目时，通常使用 Makefile 来管理编译过程
- 使用 `-Wall` 和 `-Wextra` 选项可以获得更多警告信息，有助于发现潜在问题
- 优化级别越高，编译时间越长，但生成的代码性能可能更好
- 对于需要调试的程序，应使用 `-g` 选项生成调试信息
- 交叉编译时需要指定目标架构和相应的工具链
- 链接库文件时，应注意库的搜索路径和链接顺序