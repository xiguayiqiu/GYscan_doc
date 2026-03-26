# exit - 退出Shell

## 1. 命令简介
exit 命令用于退出当前的 shell 会话，是 Linux 系统中常用的 shell 环境命令之一。它可以指定退出状态码，用于向父进程传递退出状态。

## 2. 命令语法
```bash
exit [状态码]
```

## 3. 状态码

| 状态码 | 含义 |
|--------|------|
| 0 | 成功 |
| 1-125 | 错误 |
| 126 | 命令不可执行 |
| 127 | 命令未找到 |
| 128+n | 信号 n 导致退出 |

## 4. 实战示例

### 4.1 退出 shell
```bash
exit
```

### 4.2 指定退出状态码
```bash
exit 0  # 成功退出
exit 1  # 错误退出
```

### 4.3 在脚本中使用 exit
```bash
#!/bin/bash

# 检查参数
if [ $# -ne 1 ]; then
    echo "用法: $0 <参数>"
    exit 1
fi

# 执行操作
echo "处理参数: $1"

# 成功退出
exit 0
```

### 4.4 在函数中使用 exit
```bash
#!/bin/bash

# 定义函数
check_file() {
    if [ ! -f "$1" ]; then
        echo "文件 $1 不存在"
        return 1  # 在函数中使用 return 而不是 exit
    fi
    echo "文件 $1 存在"
    return 0
}

# 调用函数
check_file "test.txt"

# 检查函数返回值
if [ $? -eq 0 ]; then
    echo "函数执行成功"
else
    echo "函数执行失败"
    exit 1
fi
```

## 5. 高级用法

### 5.1 在脚本中使用 exit 控制流程
```bash
#!/bin/bash

# 检查命令是否存在
if ! command -v git > /dev/null 2>&1; then
    echo "错误: git 命令未安装"
    exit 1
fi

# 检查目录是否存在
if [ ! -d ".git" ]; then
    echo "错误: 当前目录不是 git 仓库"
    exit 1
fi

# 执行 git 操作
git status
git add .
git commit -m "更新文件"
git push

# 成功退出
exit 0
```

### 5.2 使用 exit 传递状态码
```bash
#!/bin/bash

# 执行命令并检查状态码
ls -la
if [ $? -eq 0 ]; then
    echo "ls 命令执行成功"
else
    echo "ls 命令执行失败"
    exit 1
fi

# 成功退出
exit 0
```

### 5.3 在管道中使用 exit
```bash
#!/bin/bash

# 执行管道命令并检查状态码
ls -la | grep "test" | wc -l

# 检查管道中最后一个命令的状态码
if [ $? -eq 0 ]; then
    echo "管道命令执行成功"
else
    echo "管道命令执行失败"
    exit 1
fi
```

### 5.4 捕获信号并退出
```bash
#!/bin/bash

# 捕获 SIGINT 信号（Ctrl+C）
trap "echo '收到中断信号，正在退出...'; exit 1" SIGINT

# 执行长时间操作
echo "开始执行长时间操作..."
sleep 10
echo "操作完成"

# 成功退出
exit 0
```

## 6. 常见问题与解决方案

### 6.1 问题：exit: command not found
**解决方案**：exit 是 shell 的内置命令，应该在所有 shell 中可用

### 6.2 问题：exit 命令不退出 shell
**解决方案**：检查是否在子 shell 中执行 exit，子 shell 中的 exit 只会退出子 shell

### 6.3 问题：退出状态码被忽略
**解决方案**：确保在脚本中正确检查退出状态码
```bash
command
if [ $? -ne 0 ]; then
    echo "命令执行失败"
    exit 1
fi
```

### 6.4 问题：在函数中使用 exit 导致脚本退出
**解决方案**：在函数中使用 return 而不是 exit，return 只会退出函数，不会退出整个脚本

### 6.5 问题：exit 命令没有执行
**解决方案**：检查脚本是否有语法错误，或是否在条件语句中被跳过

### 6.6 问题：退出状态码超出范围
**解决方案**：退出状态码应该在 0-255 之间，超出范围会被取模

## 7. 命令对比

| 命令 | 功能 | 适用场景 |
|------|------|----------|
| exit | 退出 shell | 结束当前 shell 会话 |
| logout | 退出登录 | 结束当前登录会话 |
| Ctrl+D | 退出 shell | 快速退出 shell |
| return | 退出函数 | 从函数返回 |

## 8. 注意事项
- exit 命令用于退出当前的 shell 会话，是 shell 的内置命令
- exit 命令可以指定退出状态码，用于向父进程传递退出状态
- 常用的操作包括：退出 shell、在脚本中控制流程、传递状态码等
- exit 命令是 shell 的内置命令，不需要单独安装
- 退出状态码 0 表示成功，非 0 表示失败
- 在函数中应该使用 return 而不是 exit，以避免意外退出整个脚本
- exit 命令可以在 trap 中使用，用于捕获信号并优雅退出
- 退出状态码会被父进程捕获，可以用于判断命令或脚本的执行结果
- 在终端中执行 exit 会关闭当前终端窗口
- 在 SSH 会话中执行 exit 会断开 SSH 连接