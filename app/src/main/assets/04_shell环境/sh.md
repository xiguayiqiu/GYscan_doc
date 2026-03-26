# sh - POSIX兼容的Shell

## 1. 命令简介
sh 命令是 POSIX 兼容的 Shell，是 Linux 系统中最基本的 shell 环境之一。它是一个轻量级的 shell，提供了 POSIX 标准中定义的基本 shell 功能，通常作为其他 shell 的链接或实现。

## 2. 命令语法
```bash
sh [选项] [脚本文件]
sh [选项] -c "命令"
sh [选项] -s
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -c | 执行指定的命令字符串 |
| -i | 启动交互式 shell |
| -l | 启动登录 shell（读取登录配置文件） |
| -s | 从标准输入读取命令 |
| -n | 检查脚本语法，但不执行 |
| -v | 执行前显示命令 |
| -x | 执行时显示命令及其参数 |
| --help | 显示帮助信息 |
| --version | 显示版本信息 |

## 4. 实战示例

### 4.1 启动交互式shell
```bash
sh
```

### 4.2 执行命令
```bash
sh -c "echo Hello, World!"
```

### 4.3 执行脚本
```bash
sh script.sh
```

### 4.4 登录shell
```bash
sh -l
```

### 4.5 检查脚本语法
```bash
sh -n script.sh
```

### 4.6 调试脚本
```bash
sh -x script.sh
```

### 4.7 从标准输入读取命令
```bash
echo "echo Hello" | sh -s
```

## 5. 高级用法

### 5.1 脚本执行控制
```bash
# 执行脚本并捕获退出状态
sh script.sh
if [ $? -eq 0 ]; then
    echo "脚本执行成功"
else
    echo "脚本执行失败"
fi

# 执行脚本并忽略错误
sh -c "set -e; command1; command2"
```

### 5.2 命令替换
```bash
# 使用命令替换
sh -c "echo Current directory: $(pwd)"

# 使用反引号
sh -c "echo Current directory: `pwd`"
```

### 5.3 管道和重定向
```bash
# 使用管道
sh -c "ls -la | grep .txt"

# 使用重定向
sh -c "echo Hello > output.txt"

sh -c "cat input.txt | grep pattern > output.txt"
```

### 5.4 函数定义和使用
```bash
sh -c 'myfunction() { echo Hello $1; }; myfunction World'
```

## 6. sh 与 bash 的区别

### 6.1 功能差异
| 特性 | sh | bash |
|------|----|------|
| 命令历史 | 基本支持 | 高级支持（搜索、编辑） |
| 命令补全 | 基本支持 | 高级支持（路径、命令） |
| 别名 | 有限支持 | 完全支持 |
| 数组 | 有限支持 | 完全支持 |
| 扩展模式 | 基本模式 | 丰富模式 |
| 内置命令 | 基本命令 | 更多命令 |

### 6.2 适用场景
- **sh**：适用于需要 POSIX 兼容性的脚本，可移植性好，轻量级
- **bash**：适用于需要更多功能的场景，如交互式使用、复杂脚本

### 6.3 脚本兼容性
- 使用 `#!/bin/sh` 作为脚本解释器的脚本应该只使用 POSIX 标准功能
- 使用 `#!/bin/bash` 作为脚本解释器的脚本可以使用 bash 特有的功能

## 7. 配置文件

### 7.1 登录配置文件
- `/etc/profile` - 系统级登录配置
- `~/.profile` - 用户级登录配置

### 7.2 非登录配置文件
- `/etc/profile.d/` - 系统级配置脚本目录

## 8. 常见问题与解决方案

### 8.1 问题：sh 脚本执行权限被拒绝
**解决方案**：添加执行权限，`chmod +x script.sh`

### 8.2 问题：sh 命令找不到
**解决方案**：检查 PATH 环境变量，确保 sh 在 PATH 中

### 8.3 问题：sh 脚本中的变量不生效
**解决方案**：确保变量使用正确的语法，如 `$VAR` 或 `${VAR}`

### 8.4 问题：sh 脚本执行时出现语法错误
**解决方案**：使用 `sh -n` 检查脚本语法，确保只使用 POSIX 标准功能

### 8.5 问题：sh 与 bash 行为不一致
**解决方案**：检查脚本中是否使用了 bash 特有的功能，如需兼容 sh，应修改为 POSIX 标准语法

## 9. 命令对比

| 命令 | 功能 | 适用场景 |
|------|------|----------|
| sh | POSIX 兼容的 Shell | 可移植性要求高的脚本 |
| bash | Bourne Again Shell | 功能丰富的交互式使用和脚本 |
| zsh | Z Shell | 高级功能和主题支持 |
| fish | Friendly Interactive Shell | 交互友好，自动补全强大 |
| csh | C Shell | C 语言风格的 shell |

## 10. 注意事项
- sh 命令是 POSIX 兼容的 Shell，是一个轻量级的 shell
- sh 命令通常是 bash 或其他 shell 的符号链接
- sh 命令是一个常用的 shell 工具，用于执行命令和脚本
- 使用 sh 编写的脚本具有更好的可移植性，因为它们只使用 POSIX 标准功能
- 当编写需要在不同系统上运行的脚本时，建议使用 sh 而不是 bash
- 可以通过 `man sh` 查看完整的 sh 手册
- 在编写 sh 脚本时，要注意只使用 POSIX 标准中定义的功能