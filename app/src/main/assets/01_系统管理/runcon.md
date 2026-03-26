# runcon - 在特定安全上下文中运行命令

## 1. 命令简介
runcon 命令用于在特定安全上下文中运行命令，是 Linux 系统中常用的 SELinux 管理命令之一。它可以在指定的 SELinux 安全上下文中执行命令。

## 2. 命令语法
```bash
runcon [选项] [安全上下文] [命令]
```

## 3. 常用选项

| 选项 | 说明 |
|------|------|
| -h, --help | 显示帮助信息 |
| --version | 显示版本信息 |
| -u, --user=<用户> | 设置安全上下文的用户 |
| -r, --role=<角色> | 设置安全上下文的角色 |
| -t, --type=<类型> | 设置安全上下文的类型 |
| -l, --range=<范围> | 设置安全上下文的范围 |

## 4. 实战示例

### 4.1 基本用法
```bash
# 在特定安全上下文中运行命令
runcon system_u:object_r:httpd_sys_script_t:s0 bash

# 在特定安全上下文中运行指定命令
runcon system_u:object_r:httpd_sys_script_t:s0 ls -la
```

### 4.2 单独设置安全上下文的各个部分
```bash
# 设置安全上下文的类型并运行命令
runcon -t httpd_sys_script_t bash

# 设置安全上下文的用户并运行命令
runcon -u system_u bash

# 设置安全上下文的角色并运行命令
runcon -r object_r bash
```

## 5. 高级用法

### 5.1 组合选项
```bash
# 设置安全上下文的用户、角色和类型并运行命令
runcon -u system_u -r object_r -t httpd_sys_script_t bash

# 设置安全上下文的类型并运行脚本
runcon -t httpd_sys_script_t /path/to/script.sh
```

### 5.2 与其他命令结合使用
```bash
# 在特定安全上下文中执行多个命令
runcon -t httpd_sys_script_t bash -c "ls -la && pwd"

# 检查安全上下文后运行命令
id -Z && runcon -t httpd_sys_script_t id -Z
```

### 5.3 批量操作
```bash
#!/bin/bash

# 批量在特定安全上下文中运行命令
tasks=(
    "ls -la"
    "pwd"
    "id -Z"
)

for task in "${tasks[@]}"; do
    echo "在 httpd_sys_script_t 上下文中执行: $task"
    runcon -t httpd_sys_script_t $task
done
```

### 5.4 自动化脚本
```bash
#!/bin/bash

# 自动化在特定安全上下文中运行命令
run_in_context() {
    local context=${1:-"httpd_sys_script_t"}
    local command=${2:-"bash"}
    local options=${3:-"-t"}
    
    echo "在 $context 上下文中执行: $command"
    runcon $options $context $command
    
    if [ $? -eq 0 ]; then
        echo "执行成功"
    else
        echo "执行失败"
    fi
}

# 使用函数
run_in_context
run_in_context "httpd_sys_content_t" "ls -la"
run_in_context "httpd_sys_script_t" "id -Z"
```

## 6. 常见问题与解决方案

### 6.1 问题：runcon: command not found
**解决方案**：安装 policycoreutils
- Ubuntu/Debian: `apt install policycoreutils`
- CentOS/RHEL: `yum install policycoreutils`

### 6.2 问题：无法在特定安全上下文中运行命令
**解决方案**：确保 SELinux 已启用
```bash
getenforce
```

### 6.3 问题：命令执行失败
**解决方案**：确保安全上下文正确
```bash
runcon -t httpd_sys_script_t id -Z
```

### 6.4 问题：runcon 命令执行缓慢
**解决方案**：系统正在设置安全上下文，这是正常现象

### 6.5 问题：无法设置安全上下文的各个部分
**解决方案**：使用正确的选项
```bash
runcon -u system_u -r object_r -t httpd_sys_script_t bash
```

## 7. 命令对比

| 命令 | 功能 | 适用场景 |
|------|------|----------|
| runcon | 在特定安全上下文中运行命令 | SELinux 系统 |
| chcon | 修改文件安全上下文 | SELinux 系统 |
| semanage | SELinux 策略管理 | SELinux 系统 |
| restorecon | 恢复文件安全上下文 | SELinux 系统 |

## 8. 注意事项
- runcon 命令用于在特定安全上下文中运行命令，是 Linux 系统中常用的 SELinux 管理命令之一
- runcon 命令可以在指定的 SELinux 安全上下文中执行命令
- 常用的操作包括：基本用法、单独设置安全上下文的各个部分等
- runcon 命令需要 root 权限来执行
- runcon 命令支持多种选项，可以根据需要选择合适的选项
- runcon 命令是 SELinux 系统的标准工具，用于在特定安全上下文中运行命令