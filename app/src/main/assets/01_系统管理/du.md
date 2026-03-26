# du - 显示目录大小

## 1. 命令简介
du 命令用于显示目录大小，是 Linux 系统中常用的系统管理命令之一。它可以显示目录或文件的磁盘使用情况，包括目录的总大小和每个文件的大小。

## 2. 命令语法
```bash
du [选项] [文件或目录...]
```

## 3. 常用选项

| 选项 | 说明 |
|------|------|
| -h, --help | 显示帮助信息 |
| --version | 显示版本信息 |
| -h, --human-readable | 以人类可读的格式显示大小 |
| -a, --all | 显示所有文件和目录的大小 |
| -s, --summarize | 只显示总计 |
| -c, --total | 显示总计 |
| -d, --max-depth=<深度> | 显示指定深度的目录 |
| -x, --one-file-system | 只计算同一文件系统的文件 |
| --exclude=<模式> | 排除指定模式的文件 |

## 4. 实战示例

### 4.1 基本用法
```bash
# 显示目录大小
du /home/user

# 显示当前目录大小
du .
```

### 4.2 以人类可读的格式显示
```bash
du -h /home/user
```

### 4.3 显示所有文件和目录的大小
```bash
du -a /home/user
```

### 4.4 只显示总计
```bash
du -s /home/user
```

### 4.5 显示指定深度的目录
```bash
# 显示深度为 2 的目录
du -d 2 /home/user
```

### 4.6 排除指定模式的文件
```bash
du --exclude="*.tmp" /home/user
```

## 5. 高级用法

### 5.1 组合选项
```bash
# 以人类可读的格式显示深度为 2 的目录
du -hd 2 /home/user

# 显示所有文件和目录的大小，以人类可读的格式显示
du -ah /home/user
```

### 5.2 与其他命令结合使用
```bash
# 显示目录大小并排序
du -h /home/user | sort -k 1 -h

# 显示目录大小并只显示大于 100MB 的目录
du -h /home/user | awk '{if ($1 ~ /[0-9]+M/ && $1+0 > 100) print $0}'

# 监控目录大小
watch -n 1 du -s /home/user
```

### 5.3 批量操作
```bash
#!/bin/bash

# 批量检查目录大小
dirs=("/home" "/etc" "/var")

echo "检查目录大小:"
for dir in "${dirs[@]}"; do
    echo "\n=== $dir ==="
    du -h $dir
done
```

### 5.4 自动化脚本
```bash
#!/bin/bash

# 自动化检查目录大小
check_dir_size() {
    local dir=${1:-.}
    local options=${2:-"-h"}
    
    echo "检查 $dir 的大小:"
    du $options $dir
}

# 使用函数
check_dir_size
check_dir_size "/home" "-hd 2"
check_dir_size "/var" "-s"
```

## 6. 常见问题与解决方案

### 6.1 问题：du: command not found
**解决方案**：安装 coreutils
- Ubuntu/Debian: `apt install coreutils`
- CentOS/RHEL: `yum install coreutils`

### 6.2 问题：无法显示目录大小
**解决方案**：确保有足够的权限
```bash
sudo du /root
```

### 6.3 问题：目录大小显示错误
**解决方案**：检查文件系统
```bash
sudo fsck /dev/sda1
```

### 6.4 问题：du 命令执行缓慢
**解决方案**：目录过大，使用适当的选项
```bash
du -s /home/user
```

### 6.5 问题：无法显示指定深度的目录
**解决方案**：使用 -d 选项
```bash
du -d 2 /home/user
```

## 7. 命令对比

| 命令 | 功能 | 适用场景 |
|------|------|----------|
| du | 显示目录大小 | 所有 Linux 系统 |
| df | 显示磁盘使用情况 | 所有 Linux 系统 |
| ls | 列出目录内容 | 所有 Linux 系统 |
| find | 搜索文件 | 所有 Linux 系统 |

## 8. 注意事项
- du 命令用于显示目录大小，是 Linux 系统中常用的系统管理命令之一
- du 命令可以显示目录或文件的磁盘使用情况，包括目录的总大小和每个文件的大小
- 常用的操作包括：基本用法、以人类可读的格式显示、显示所有文件和目录的大小、只显示总计等
- du 命令不需要 root 权限来执行，但显示受保护目录时需要
- du 命令支持多种选项，可以根据需要选择合适的选项
- du 命令是所有 Linux 系统的标准工具，用于显示目录大小