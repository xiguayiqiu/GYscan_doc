# mkdir - 创建目录

## 1. 命令简介
mkdir 命令用于创建目录，是 Linux 系统中常用的文件操作命令之一。它可以创建一个或多个目录，支持多种选项来控制创建行为。

## 2. 命令语法
```bash
mkdir [选项] [目录...]
```

## 3. 常用选项

| 选项 | 说明 |
|------|------|
| -h, --help | 显示帮助信息 |
| --version | 显示版本信息 |
| -p, --parents | 递归创建目录，包括父目录 |
| -m, --mode | 设置目录权限 |
| -v, --verbose | 详细显示创建过程 |

## 4. 实战示例

### 4.1 基本用法
```bash
# 创建单个目录
mkdir dir

# 创建多个目录
mkdir dir1 dir2 dir3
```

### 4.2 递归创建目录
```bash
mkdir -p dir1/dir2/dir3
```

### 4.3 设置目录权限
```bash
mkdir -m 755 dir
```

### 4.4 详细显示创建过程
```bash
mkdir -v dir
```

## 5. 高级用法

### 5.1 组合选项
```bash
# 递归创建目录，设置权限，详细显示过程
mkdir -pvm 755 dir1/dir2/dir3
```

### 5.2 与其他命令结合使用
```bash
# 创建目录并进入
mkdir dir && cd dir

# 创建带日期的目录
mkdir $(date +%Y-%m-%d)

# 创建多个嵌套目录
mkdir -p project/{src,doc,bin}
```

### 5.3 批量操作
```bash
#!/bin/bash

# 批量创建目录
dirs=("dir1" "dir2" "dir3" "dir4/dir5")

for dir in "${dirs[@]}"; do
    echo "创建目录: $dir"
    mkdir -p $dir
done
```

### 5.4 自动化脚本
```bash
#!/bin/bash

# 自动化创建目录
create_dir() {
    local dir=$1
    local options=${2:-"-p"}
    
    echo "创建目录: $dir"
    mkdir $options $dir
    
    if [ $? -eq 0 ]; then
        echo "创建成功"
    else
        echo "创建失败"
    fi
}

# 使用函数
create_dir "dir1"
create_dir "dir2/dir3"
create_dir "dir4" "-pv"
```

## 6. 常见问题与解决方案

### 6.1 问题：mkdir: command not found
**解决方案**：安装 coreutils
- Ubuntu/Debian: `apt install coreutils`
- CentOS/RHEL: `yum install coreutils`

### 6.2 问题：无法创建目录
**解决方案**：确保有足够的权限
```bash
sudo mkdir /root/dir
```

### 6.3 问题：创建嵌套目录失败
**解决方案**：使用 -p 选项
```bash
mkdir -p dir1/dir2/dir3
```

### 6.4 问题：目录权限不正确
**解决方案**：使用 -m 选项设置权限
```bash
mkdir -m 755 dir
```

### 6.5 问题：mkdir 命令执行缓慢
**解决方案**：目录层级过多，使用 -p 选项
```bash
mkdir -p dir1/dir2/dir3
```

## 7. 命令对比

| 命令 | 功能 | 适用场景 |
|------|------|----------|
| mkdir | 创建目录 | 所有 Linux 系统 |
| rmdir | 删除空目录 | 所有 Linux 系统 |
| rm | 删除文件或目录 | 所有 Linux 系统 |
| touch | 创建空文件或更新时间戳 | 所有 Linux 系统 |

## 8. 注意事项
- mkdir 命令用于创建目录，是 Linux 系统中常用的文件操作命令之一
- mkdir 命令可以创建一个或多个目录，支持多种选项来控制创建行为
- 常用的操作包括：基本用法、递归创建目录、设置目录权限、详细显示创建过程等
- mkdir 命令不需要 root 权限来执行，但创建到受保护目录时需要
- mkdir 命令支持多种选项，可以根据需要选择合适的选项
- mkdir 命令是所有 Linux 系统的标准工具，用于创建目录