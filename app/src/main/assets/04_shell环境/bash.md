# bash - Bourne Again Shell命令解释器

## 1. 命令简介
bash 命令是 Bourne Again Shell 命令解释器，是 Linux 系统中最常用的 shell 环境之一。它是 Bourne Shell (sh) 的增强版本，提供了更多功能和特性，是大多数 Linux 发行版的默认 shell。

## 2. 命令语法
```bash
bash [选项] [脚本文件]
bash [选项] -c "命令"
bash [选项] -s
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -c | 执行指定的命令字符串 |
| -i | 启动交互式 shell |
| -l | 启动登录 shell（读取登录配置文件） |
| -s | 从标准输入读取命令 |
| -r | 启动受限 shell（限制某些命令的执行） |
| -n | 检查脚本语法，但不执行 |
| -v | 执行前显示命令 |
| -x | 执行时显示命令及其参数 |
| --help | 显示帮助信息 |
| --version | 显示版本信息 |

## 4. 实战示例

### 4.1 启动交互式shell
```bash
bash
```

### 4.2 执行命令
```bash
bash -c "echo Hello, World!"
```

### 4.3 执行脚本
```bash
bash script.sh
```

### 4.4 登录shell
```bash
bash -l
```

### 4.5 检查脚本语法
```bash
bash -n script.sh
```

### 4.6 调试脚本
```bash
bash -x script.sh
```

### 4.7 从标准输入读取命令
```bash
echo "echo Hello" | bash -s
```

### 4.8 启动受限shell
```bash
bash -r
```

## 5. 高级用法

### 5.1 环境变量设置
```bash
# 设置环境变量并执行命令
bash -c "export PATH=$PATH:/usr/local/bin && command"

# 在脚本中设置环境变量
bash -c 'VAR=value; echo $VAR'
```

### 5.2 脚本执行控制
```bash
# 执行脚本并捕获退出状态
bash script.sh
if [ $? -eq 0 ]; then
    echo "脚本执行成功"
else
    echo "脚本执行失败"
fi

# 执行脚本并忽略错误
bash -c "set -e; command1; command2"
```

### 5.3 命令替换
```bash
# 使用命令替换
bash -c "echo Current directory: $(pwd)"

# 使用反引号
bash -c "echo Current directory: `pwd`"
```

### 5.4 管道和重定向
```bash
# 使用管道
bash -c "ls -la | grep .txt"

# 使用重定向
bash -c "echo Hello > output.txt"

bash -c "cat input.txt | grep pattern > output.txt"
```

### 5.5 函数定义和使用
```bash
bash -c 'myfunction() { echo Hello $1; }; myfunction World'
```

## 6. bash 特性

### 6.1 命令历史
- 使用上下箭头键浏览历史命令
- 使用 `history` 命令查看历史记录
- 使用 `!n` 执行第 n 条历史命令
- 使用 `!!` 执行上一条命令
- 使用 `!string` 执行最近以 string 开头的命令

### 6.2 命令补全
- 按 Tab 键补全命令、文件名和目录名
- 按两次 Tab 键显示所有可能的补全选项

### 6.3 别名
- 使用 `alias` 命令创建命令别名
- 例如：`alias ll='ls -la'`
- 在 `.bashrc` 文件中定义永久别名

### 6.4 通配符
- `*` 匹配任意字符
- `?` 匹配单个字符
- `[abc]` 匹配方括号中的任意一个字符
- `[!abc]` 匹配不在方括号中的任意字符

### 6.5 重定向
- `>` 输出重定向（覆盖）
- `>>` 输出重定向（追加）
- `<` 输入重定向
- `2>` 错误输出重定向
- `&>` 同时重定向标准输出和错误输出

## 7. 配置文件

### 7.1 登录配置文件
- `/etc/profile` - 系统级登录配置
- `~/.bash_profile` - 用户级登录配置
- `~/.bash_login` - 备选登录配置
- `~/.profile` - 备选登录配置

### 7.2 非登录配置文件
- `/etc/bash.bashrc` - 系统级非登录配置
- `~/.bashrc` - 用户级非登录配置

### 7.3 注销配置文件
- `~/.bash_logout` - 用户注销时执行

## 8. 常见问题与解决方案

### 8.1 问题：bash 脚本执行权限被拒绝
**解决方案**：添加执行权限，`chmod +x script.sh`

### 8.2 问题：bash 命令找不到
**解决方案**：检查 PATH 环境变量，确保 bash 在 PATH 中

### 8.3 问题：bash 脚本中的变量不生效
**解决方案**：确保变量使用正确的语法，如 `$VAR` 或 `${VAR}`

### 8.4 问题：bash 脚本执行时出现语法错误
**解决方案**：使用 `bash -n` 检查脚本语法

### 8.5 问题：bash 历史命令不保存
**解决方案**：检查 `HISTFILE` 环境变量，确保历史文件存在

## 9. 命令对比

| 命令 | 功能 | 适用场景 |
|------|------|----------|
| bash | Bourne Again Shell | 大多数 Linux 系统的默认 shell |
| sh | Bourne Shell | 基本 shell，兼容性好 |
| zsh | Z Shell | 功能丰富，支持主题和插件 |
| fish | Friendly Interactive Shell | 交互友好，自动补全强大 |
| csh | C Shell | C 语言风格的 shell |

## 10. 注意事项
- bash 命令是 Bourne Again Shell 命令解释器，是大多数 Linux 系统的默认 shell
- bash 命令支持丰富的功能，如命令历史、别名、管道等
- bash 命令是一个常用的 shell 工具，用于执行命令和脚本
- bash 脚本是一种强大的自动化工具，可以编写复杂的脚本任务
- 学习 bash 对于 Linux 系统管理和开发非常重要
- 可以通过 `man bash` 查看完整的 bash 手册
- 在编写 bash 脚本时，要注意语法正确性和安全性