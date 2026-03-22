# tee - 读取标准输入并写入文件和标准输出

## 1. 命令简介
tee 命令用于读取标准输入并同时写入文件和标准输出，是 Linux 系统中常用的其他命令之一。

## 2. 命令语法
```bash
tee [选项] [文件]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -a | 追加模式，不覆盖文件 |
| -i | 忽略中断信号 |
| --help | 显示帮助信息 |
| --version | 显示版本信息 |

## 4. 实战示例

### 4.1 读取标准输入并写入文件和标准输出
```bash
echo "Hello World" | tee file.txt
```

### 4.2 追加模式
```bash
echo "Hello World" | tee -a file.txt
```

### 4.3 写入多个文件
```bash
echo "Hello World" | tee file1.txt file2.txt
```

### 4.4 与管道结合使用
```bash
ls -la | tee file.txt | grep "txt"
```

## 5. 注意事项
- tee 命令用于读取标准输入并同时写入文件和标准输出
- 使用 -a 选项可以追加模式写入文件，不覆盖原有内容
- tee 命令是一个常用的管道工具，用于在管道中同时输出到文件和标准输出