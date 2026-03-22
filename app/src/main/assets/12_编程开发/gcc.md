# gcc - GNU C编译器

## 1. 命令简介
gcc 命令是 GNU C 编译器，是 Linux 系统中常用的编程开发命令之一。

## 2. 命令语法
```bash
gcc [选项] [文件]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -o | 指定输出文件名 |
| -c | 只编译不链接 |
| -g | 生成调试信息 |
| -O | 优化级别 |
| -Wall | 显示所有警告 |
| -Werror | 将警告视为错误 |
| -I | 指定头文件搜索路径 |
| -L | 指定库文件搜索路径 |
| -l | 链接指定的库 |
| -std | 指定C标准 |

## 4. 实战示例

### 4.1 编译C文件
```bash
gcc hello.c -o hello
```

### 4.2 只编译不链接
```bash
gcc -c hello.c
```

### 4.3 生成调试信息
```bash
gcc -g hello.c -o hello
```

### 4.4 优化编译
```bash
gcc -O2 hello.c -o hello
```

### 4.5 显示所有警告
```bash
gcc -Wall hello.c -o hello
```

### 4.6 链接库文件
```bash
gcc hello.c -lm -o hello
```

## 5. 注意事项
- gcc 命令是 GNU C 编译器，用于编译 C 语言程序
- 使用 -o 选项可以指定输出文件名
- 使用 -g 选项可以生成调试信息，用于 gdb 调试
- 使用 -O 选项可以优化编译，提高程序运行速度