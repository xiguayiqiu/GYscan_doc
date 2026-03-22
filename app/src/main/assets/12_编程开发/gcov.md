# gcov - 代码覆盖率工具

## 1. 命令简介
gcov 命令用于生成代码覆盖率报告，是 Linux 系统中常用的编程开发命令之一。

## 2. 命令语法
```bash
gcov [选项] [文件]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -b | 显示分支覆盖率 |
| -c | 显示条件覆盖率 |
| -d | 指定输出目录 |
| -f | 显示函数覆盖率 |
| -i | 忽略代码行 |
| -l | 显示行覆盖率 |
| -n | 不创建输出文件 |
| -o | 指定目标文件 |
| -s | 指定源文件目录 |
| -u | 显示未执行的代码 |

## 4. 实战示例

### 4.1 生成代码覆盖率报告
```bash
gcc -fprofile-arcs -ftest-coverage hello.c -o hello
./hello
gcov hello.c
```

### 4.2 显示分支覆盖率
```bash
gcov -b hello.c
```

### 4.3 显示函数覆盖率
```bash
gcov -f hello.c
```

### 4.4 指定输出目录
```bash
gcov -d coverage hello.c
```

## 5. 注意事项
- gcov 命令用于生成代码覆盖率报告，需要与 gcc 编译器配合使用
- 使用 gcc 编译时需要添加 -fprofile-arcs -ftest-coverage 选项
- 运行程序后，会生成 .gcno 和 .gcda 文件
- gcov 命令根据这些文件生成覆盖率报告
- 覆盖率报告显示了代码的执行情况，包括行覆盖率、分支覆盖率和函数覆盖率