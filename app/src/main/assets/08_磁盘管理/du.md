# du - 显示目录大小

## 1. 命令简介
du 命令用于显示目录或文件的磁盘使用情况，是 Linux 系统中最常用的磁盘管理命令之一。它可以显示目录及其子目录的大小，帮助用户了解磁盘空间的使用情况。

## 2. 命令语法
```bash
du [选项] [文件或目录]
du [选项] --max-depth=<深度> [目录]
```

## 3. 常用选项

| 选项 | 说明 |
|------|------|
| -h, --human-readable | 以人类可读的格式显示 |
| -s, --summarize | 显示总大小，不显示子目录 |
| -c, --total | 显示总计 |
| -a, --all | 显示所有文件和目录 |
| -k | 以KB为单位显示 |
| -m | 以MB为单位显示 |
| -g | 以GB为单位显示 |
| -d, --max-depth=<深度> | 指定深度 |
| --time | 显示最后修改时间 |
| --time=atime | 显示最后访问时间 |
| --time=ctime | 显示最后状态改变时间 |
| --exclude=<模式> | 排除指定模式的文件 |
| --include=<模式> | 只包含指定模式的文件 |
| --help | 显示帮助信息 |
| --version | 显示版本信息 |

## 4. 实战示例

### 4.1 显示目录大小
```bash
du -h directory/
```

### 4.2 显示目录总大小
```bash
du -sh directory/
```

### 4.3 显示所有文件和目录大小
```bash
du -ah directory/
```

### 4.4 显示指定深度的目录大小
```bash
du -h --max-depth=2 directory/
```

### 4.5 显示总计
```bash
du -ch directory/
```

### 4.6 以MB为单位显示
```bash
du -m directory/
```

### 4.7 显示带时间信息
```bash
du -h --time directory/
```

### 4.8 排除指定文件
```bash
du -h --exclude="*.tmp" directory/
```

### 4.9 只包含指定文件
```bash
du -h --include="*.txt" --exclude="*" directory/
```

## 5. 高级用法

### 5.1 在脚本中使用du
```bash
#!/bin/bash

# 检查目录大小
echo "目录大小:"
du -sh /home

# 检查子目录大小
echo "\n子目录大小:"
du -h --max-depth=1 /home

# 查找最大的目录
largest_dir=$(du -h --max-depth=1 /home | sort -hr | head -1)
echo "\n最大的目录: $largest_dir"

# 检查临时文件大小
temp_size=$(du -sh /tmp)
echo "\n临时文件大小: $temp_size"
```

### 5.2 结合其他命令使用
```bash
# 查找最大的前10个文件或目录
du -ah /home | sort -hr | head -10

# 查找最近修改的大文件
du -ah --time /home | sort -hr | head -10

# 检查特定类型文件的大小
du -h --include="*.mp4" --include="*.avi" --exclude="*" /home
```

### 5.3 批量检查多个目录
```bash
#!/bin/bash

# 批量检查多个目录
directories=(/home /var /tmp /opt)

for dir in "${directories[@]}"; do
    echo "=== $dir ==="
    du -sh $dir
    echo
done
```

### 5.4 监控目录大小变化
```bash
#!/bin/bash

# 监控目录大小变化
dir="/home"
prev_size=$(du -s $dir)

echo "开始监控 $dir 目录大小变化"
echo "初始大小: $prev_size"

while true; do
    sleep 60
    curr_size=$(du -s $dir)
    if [ "$curr_size" != "$prev_size" ]; then
        echo "目录大小变化: $prev_size -> $curr_size"
        prev_size=$curr_size
    fi
done
```

## 6. 常见问题与解决方案

### 6.1 问题：du: command not found
**解决方案**：安装 du 工具
- Ubuntu/Debian: `apt install coreutils`
- CentOS/RHEL: `yum install coreutils`

### 6.2 问题：du 命令执行缓慢
**解决方案**：限制深度或使用 -s 选项只显示总大小
```bash
du -sh directory/
du -h --max-depth=1 directory/
```

### 6.3 问题：du 显示的大小与 df 不一致
**解决方案**：这是正常现象，du 显示的是文件实际使用的空间，df 显示的是文件系统的使用情况

### 6.4 问题：du 无法访问某些目录
**解决方案**：使用 sudo 或以 root 用户执行命令
```bash
sudo du -h /root
```

### 6.5 问题：du 显示的大小比实际文件大小大
**解决方案**：这是因为 du 显示的是文件占用的磁盘空间，而不是文件的实际大小

### 6.6 问题：du 不显示隐藏文件
**解决方案**：使用 -a 选项显示所有文件，包括隐藏文件
```bash
du -ah directory/
```

## 7. 命令对比

| 命令 | 功能 | 适用场景 |
|------|------|----------|
| du | 显示目录或文件的磁盘使用情况 | 查看具体目录或文件的大小 |
| df | 显示文件系统的磁盘空间使用情况 | 查看整体磁盘空间使用 |
| ls | 显示文件和目录信息 | 查看文件和目录的基本信息 |
| find | 查找文件和目录 | 查找特定文件或目录 |
| ncdu | 交互式磁盘使用分析工具 | 交互式查看磁盘使用情况 |

## 8. 注意事项
- du 命令用于显示目录或文件的磁盘使用情况，是 Linux 系统中最常用的磁盘管理命令之一
- du 命令可以显示目录及其子目录的大小，帮助用户了解磁盘空间的使用情况
- 常用的操作包括：显示目录大小、显示目录总大小、显示所有文件和目录大小等
- du 命令是 coreutils 包的一部分，几乎所有 Linux 系统都默认安装
- 使用 -h 选项可以使输出更加易读，显示为人类可读的格式
- 使用 -s 选项可以只显示总大小，不显示子目录
- 使用 --max-depth 选项可以控制显示的深度
- du 命令显示的是文件占用的磁盘空间，而不是文件的实际大小
- 对于大型目录，du 命令可能会执行较慢
- 定期检查目录大小可以帮助预防磁盘空间不足的问题