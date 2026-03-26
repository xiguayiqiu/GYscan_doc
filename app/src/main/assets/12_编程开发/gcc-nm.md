# gcc-nm - GCC符号列表工具

## 1. 命令简介
gcc-nm 是 GCC 编译器集合提供的符号列表工具，用于显示目标文件、可执行文件或静态库中的符号信息。它是 nm 命令的 GCC 包装版本，与 GCC 编译器集成更紧密，确保正确处理 GCC 生成的文件格式。

## 2. 命令语法
```bash
gcc-nm [选项] [文件...]
gcc-nm [选项] --defined-only [文件...]
gcc-nm [选项] --undefined-only [文件...]
```

## 3. 常用选项

### 3.1 基本选项
| 选项 | 说明 |
|------|------|
| -A, --print-file-name | 在每个符号前显示文件名 |
| -a, --debug-syms | 显示调试符号 |
| -B | 与 --format=bsd 相同 |
| -C, --demangle[=风格] | 对 C++ 符号进行解混淆 |
| -D, --dynamic | 显示动态符号 |
| -f, --format=格式 | 指定输出格式（bsd、sysv、posix） |
| -g, --extern-only | 只显示外部符号 |
| -h, --help | 显示帮助信息 |
| -l, --line-numbers | 显示符号的行号信息 |
| -n, --numeric-sort | 按符号值排序 |
| -p, --no-sort | 不排序，按符号在文件中出现的顺序显示 |
| -P, --portability | 与 --format=posix 相同 |
| -r, --reverse-sort | 反向排序 |
| -S, --print-size | 显示符号大小 |
| -s, --print-armap | 显示静态库的索引 |
| -t, --radix=基数 | 指定符号值的基数（d、o、x） |
| -u, --undefined-only | 只显示未定义符号 |
| -V, --version | 显示版本信息 |
| --defined-only | 只显示已定义符号 |
| --no-demangle | 不进行符号解混淆 |
| --plugin=名称 | 加载指定的插件 |
| --special-syms | 显示特殊符号 |
| --synthetic | 显示合成符号 |

## 4. 实战示例

### 4.1 显示目标文件中的符号
```bash
gcc-nm hello.o
```

### 4.2 显示静态库中的符号
```bash
gcc-nm libhello.a
```

### 4.3 显示可执行文件中的符号
```bash
gcc-nm a.out
```

### 4.4 按符号值排序显示
```bash
gcc-nm -n hello.o
```

### 4.5 只显示外部符号
```bash
gcc-nm -g hello.o
```

### 4.6 只显示未定义符号
```bash
gcc-nm -u hello.o
```

### 4.7 显示符号的行号信息
```bash
gcc-nm -l hello.o
```

### 4.8 显示符号大小
```bash
gcc-nm -S hello.o
```

### 4.9 对 C++ 符号进行解混淆
```bash
gcc-nm -C hello.o
```

### 4.10 在每个符号前显示文件名
```bash
gcc-nm -A hello.o world.o
```

## 5. 高级用法

### 5.1 分析静态库中的符号
```bash
# 显示静态库中的所有符号
gcc-nm libhello.a

# 只显示静态库中的外部符号
gcc-nm -g libhello.a

# 显示静态库的索引
gcc-nm -s libhello.a
```

### 5.2 比较不同版本的符号
```bash
# 保存旧版本的符号列表
gcc-nm -C old_lib.a > old_symbols.txt

# 保存新版本的符号列表
gcc-nm -C new_lib.a > new_symbols.txt

# 比较符号差异
diff old_symbols.txt new_symbols.txt
```

### 5.3 查找未定义符号
```bash
# 查找可执行文件中的未定义符号
gcc-nm -u a.out

# 查找静态库中的未定义符号
gcc-nm -u libhello.a
```

### 5.4 分析动态库中的符号
```bash
# 显示动态库中的动态符号
gcc-nm -D libhello.so

# 只显示动态库中的未定义符号
gcc-nm -Du libhello.so
```

### 5.5 结合 grep 使用
```bash
# 查找包含特定字符串的符号
gcc-nm hello.o | grep "main"

# 查找函数符号
gcc-nm hello.o | grep " T "

# 查找全局变量
gcc-nm hello.o | grep " D "
```

## 6. 符号类型说明

| 符号类型 | 含义 |
|----------|------|
| A | 绝对符号 |
| B | BSS 段中的符号（未初始化数据） |
| C | 公共符号（未初始化数据） |
| D | 数据段中的符号（已初始化数据） |
| G | 小数据段中的符号（已初始化数据） |
| I | 间接引用其他符号 |
| N | 调试符号 |
| R | 只读数据段中的符号 |
| S | 小数据段中的符号（未初始化数据） |
| T | 文本段中的符号（代码） |
| U | 未定义符号 |
| V | 弱对象符号 |
| W | 弱符号 |
| - | 符号类型未知 |

## 7. 常见问题与解决方案

### 7.1 问题：gcc-nm: command not found
**解决方案**：确保安装了 GCC 开发工具包
- Ubuntu/Debian: `apt install build-essential`
- CentOS/RHEL: `yum install gcc`

### 7.2 问题：gcc-nm: hello.o: No such file or directory
**解决方案**：确保文件存在且路径正确

### 7.3 问题：符号名称难以理解（C++ 符号）
**解决方案**：使用 -C 选项进行符号解混淆

### 7.4 问题：找不到某个符号
**解决方案**：
1. 确保符号已定义
2. 检查链接顺序
3. 使用 -u 选项查找未定义符号

### 7.5 问题：静态库中符号重复
**解决方案**：
1. 检查源文件中是否有重复定义
2. 使用 `ar -d` 从静态库中删除重复的目标文件

## 8. 命令对比

| 命令 | 功能 | 适用场景 |
|------|------|----------|
| gcc-nm | GCC 符号列表工具 | 与 GCC 编译器配合使用 |
| nm | 标准符号列表工具 | 通用符号查看 |
| objdump | 显示目标文件信息 | 更详细的目标文件分析 |
| readelf | 显示 ELF 文件信息 | ELF 文件格式分析 |
| addr2line | 将地址转换为文件名和行号 | 调试时定位源代码位置 |

## 9. 注意事项
- gcc-nm 是 GCC 提供的符号列表工具，用于显示目标文件、可执行文件或静态库中的符号信息
- gcc-nm 命令与 nm 命令功能类似，但与 GCC 编译器集成更紧密
- 使用 gcc-nm 命令可以查看符号的类型、值和名称
- 符号类型中的 T 表示代码段中的符号（函数），D 表示数据段中的符号（变量）
- 使用 -C 选项可以对 C++ 符号进行解混淆，使其更易读
- 使用 -u 选项可以查找未定义符号，这对于解决链接错误很有帮助
- 使用 -g 选项可以只显示外部符号，减少输出信息量
- 静态库是目标文件的集合，gcc-nm 会显示静态库中所有目标文件的符号
- 动态库中的符号可以使用 -D 选项查看
- gcc-nm 是调试和分析程序的重要工具，特别是在解决链接错误和符号冲突时