# alias - 创建命令别名

## 1. 命令简介
alias 命令用于创建命令别名，是 Linux 系统中常用的命令之一。

## 2. 命令语法
```bash
alias [别名=命令]
```

## 3. 实战示例

### 3.1 创建命令别名
```bash
alias ll='ls -la'
```

### 3.2 显示所有别名
```bash
alias
```

### 3.3 移除命令别名
```bash
unalias ll
```

### 3.4 创建带参数的别名
```bash
alias grep='grep --color=auto'
```

## 4. 退出状态
- 0：命令执行成功
- 非0：命令执行失败

## 5. 注意事项
- alias 命令创建的别名只在当前shell会话中有效，需要在 ~/.bashrc 或 ~/.bash_profile 文件中添加才能永久生效
- 别名可以简化常用命令的输入，提高工作效率
- 使用 unalias 命令可以移除已创建的别名