# g++ - GNU C++编译器

## 1. 命令简介
g++ 是 GNU 编译器集合（GCC）中的 C++ 编译器，用于编译 C++ 语言程序。它是 Linux 系统中最常用的 C++ 编译器之一，支持多种 C++ 标准，并提供丰富的编译选项。

## 2. 命令语法
```bash
g++ [选项] 文件...
g++ [选项] -o 输出文件 源文件...
```

## 3. 常用选项

### 3.1 基本编译选项
| 选项 | 说明 |
|------|------|
| -o FILE | 指定输出文件 |
| -c | 编译但不链接，生成目标文件（.o） |
| -g | 生成调试信息，供调试器使用 |
| -O[0-3] | 优化级别，0表示无优化，3表示最高优化 |
| -Wall | 显示所有警告信息 |
| -Werror | 将警告视为错误 |
| -std=标准 | 指定C++标准，如c++11、c++14、c++17、c++20等 |
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
| -Wnon-virtual-dtor | 警告非虚析构函数 |
| -Woverloaded-virtual | 警告重载虚函数问题 |

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

### 3.5 C++ 特定选项
| 选项 | 说明 |
|------|------|
| -fno-exceptions | 禁用异常处理 |
| -fno-rtti | 禁用运行时类型信息 |
| -fvisibility=hidden | 设置默认符号可见性为隐藏 |
| -std=c++11 | 使用 C++11 标准 |
| -std=c++14 | 使用 C++14 标准 |
| -std=c++17 | 使用 C++17 标准 |
| -std=c++20 | 使用 C++20 标准 |

## 4. 实战示例

### 4.1 编译单个C++文件
```bash
g++ hello.cpp -o hello
```

### 4.2 编译多个C++文件
```bash
g++ file1.cpp file2.cpp -o program
```

### 4.3 只编译不链接
```bash
g++ -c hello.cpp
```

### 4.4 生成调试信息
```bash
g++ -g hello.cpp -o hello
```

### 4.5 优化编译
```bash
g++ -O2 hello.cpp -o hello
```

### 4.6 显示所有警告
```bash
g++ -Wall -Wextra hello.cpp -o hello
```

### 4.7 链接库文件
```bash
g++ hello.cpp -lm -o hello
```

### 4.8 指定C++标准
```bash
g++ -std=c++17 hello.cpp -o hello
```

### 4.9 指定头文件和库文件目录
```bash
g++ -I/include -L/lib -lm hello.cpp -o hello
```

### 4.10 编译为目标文件并链接
```bash
g++ -c file1.cpp
g++ -c file2.cpp
g++ file1.o file2.o -o program
```

## 5. 高级用法

### 5.1 交叉编译
```bash
# 为 ARM 架构编译
g++ -march=armv7-a -mtune=cortex-a9 hello.cpp -o hello

# 使用交叉编译器
aarch64-linux-gnu-g++ hello.cpp -o hello
```

### 5.2 生成汇编代码
```bash
# 生成汇编代码
g++ -S hello.cpp

# 查看汇编代码
cat hello.s
```

### 5.3 预处理、编译、汇编、链接分步操作
```bash
# 预处理
g++ -E hello.cpp -o hello.i

# 编译
g++ -S hello.i -o hello.s

# 汇编
g++ -c hello.s -o hello.o

# 链接
g++ hello.o -o hello
```

### 5.4 检查编译过程
```bash
# 显示编译过程
g++ -v hello.cpp -o hello

# 显示预处理后的代码
g++ -E hello.cpp
```

### 5.5 生成静态库和动态库
```bash
# 生成静态库
g++ -c lib.cpp
ar rcs lib.a lib.o

# 链接静态库
g++ hello.cpp -L. -llib -o hello

# 生成动态库
g++ -shared -fPIC lib.cpp -o lib.so

# 链接动态库
g++ hello.cpp -L. -llib -o hello
```

### 5.6 使用STL和标准库
```bash
# 编译使用STL的程序
g++ -std=c++17 stl_example.cpp -o stl_example

# 链接线程库
g++ thread_example.cpp -pthread -o thread_example
```

## 6. 常见问题与解决方案

### 6.1 问题：undefined reference to `std::cout'
**解决方案**：确保使用g++而不是gcc编译C++程序，g++会自动链接C++标准库

### 6.2 问题：fatal error: iostream: No such file or directory
**解决方案**：确保使用g++编译C++程序，或在gcc中添加-std=c++11等选项

### 6.3 问题：error: 'nullptr' was not declared in this scope
**解决方案**：使用-std=c++11或更高标准

### 6.4 问题：error: 'auto' not allowed in function prototype
**解决方案**：使用-std=c++11或更高标准

### 6.5 问题：error: expected ';' before '}' token
**解决方案**：检查代码中的语法错误，确保所有语句都以分号结尾

### 6.6 问题：error: no matching function for call to 'function'
**解决方案**：检查函数调用的参数类型和数量是否正确

## 7. 命令对比

| 命令 | 功能 | 适用场景 |
|------|------|----------|
| g++ | GNU C++ 编译器 | C++ 语言程序编译 |
| gcc | GNU C 编译器 | C 语言程序编译 |
| clang++ | LLVM C++ 编译器 | 现代 C++ 编译，错误信息更友好 |
| icc | Intel 编译器 | Intel 平台优化 |
| MSVC | Microsoft Visual C++ | Windows 平台编译 |

## 8. 注意事项
- g++ 是 GNU C++ 编译器，用于编译 C++ 语言程序
- 使用 -o 选项可以指定输出文件名
- 使用 -g 选项可以生成调试信息，用于 gdb 调试
- 使用 -O 选项可以优化编译，提高程序运行速度
- g++ 会自动链接 C++ 标准库，而 gcc 需要手动指定
- 可以使用 -std 选项指定 C++ 标准，如 c++11、c++14、c++17、c++20 等
- 使用 -Wall 和 -Wextra 选项可以获得更多警告信息，有助于发现潜在问题
- 优化级别越高，编译时间越长，但生成的代码性能可能更好
- 对于需要调试的程序，应使用 -g 选项生成调试信息
- 交叉编译时需要指定目标架构和相应的工具链
- 链接库文件时，应注意库的搜索路径和链接顺序
- 对于大型项目，通常使用 Makefile 或其他构建系统来管理编译过程