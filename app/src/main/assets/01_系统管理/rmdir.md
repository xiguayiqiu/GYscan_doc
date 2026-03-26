# rmdir - 删除空目录

## 1. 命令简介
rmdir 命令用于删除空目录，是 Linux 系统中常用的文件操作命令之一。它只能删除空目录，不能删除非空目录。

## 2. 命令语法
```bash
rmdir [选项] [目录...]
```

## 3. 常用选项

| 选项 | 说明 |
|------|------|
| -h, --help | 显示帮助信息 |
| --version | 显示版本信息 |
| -p, --parents | 递归删除目录，包括父目录（如果为空） |
| -v, --verbose | 详细显示删除过程 |

## 4. 实战示例

### 4.1 基本用法
```bash
# 删除单个空目录
rmdir dir

# 删除多个空目录
rmdir dir1 dir2 dir3
```

### 4.2 递归删除目录
```bash
rmdir -p dir1/dir2/dir3
```

### 4.3 详细显示删除过程
```bash
rmdir -v dir
```

## 5. 高级用法

### 5.1 组合选项
```bash
# 递归删除目录，详细显示过程
rmdir -pv dir1/dir2/dir3
```

### 5.2 与其他命令结合使用
```bash
# 创建目录后删除
mkdir dir && rmdir dir

# 检查目录是否为空后删除
if [ -z "$(ls -A dir)" ]; then
    rmdir dir
    echo "目录已删除"
else
    echo "目录不为空，无法删除"
fi
```

### 5.3 批量操作
```bash
#!/bin/bash

# 批量删除空目录
dirs=("dir1" "dir2" "dir3" "dir4/dir5")

for dir in "${dirs[@]}"; do
    if [ -d "$dir" ] && [ -z "$(ls -A "$dir")" ]; then
        echo "删除空目录: $dir"
        rmdir -p $dir
    else
        echo "目录 $dir 不存在或不为空"
    fi
done
```

### 5.4 自动化脚本
```bash
#!/bin/bash

# 自动化删除空目录
delete_empty_dir() {
    local dir=$1
    local options=${2:-""}
    
    if [ -d "$dir" ] && [ -z "$(ls -A "$dir")" ]; then
        echo "删除空目录: $dir"
        rmdir $options $dir
        
        if [ $? -eq 0 ]; then
            echo "删除成功"
        else
            echo "删除失败"
        fi
    else
        echo "目录 $dir 不存在或不为空"
    fi
}

# 使用函数
delete_empty_dir "dir1"
delete_empty_dir "dir2/dir3" "-p"
delete_empty_dir "dir4" "-v"
```

## 6. 常见问题与解决方案

### 6.1 问题：rmdir: command not found
**解决方案**：安装 coreutils
- Ubuntu/Debian: `apt install coreutils`
- CentOS/RHEL: `yum install coreutils`

### 6.2 问题：无法删除目录
**解决方案**：确保目录为空且有足够的权限
```bash
# 检查目录是否为空
ls -la dir

# 确保有足够的权限
sudo rmdir dir
```

### 6.3 问题：删除非空目录失败
**解决方案**：使用 rm 命令
```bash
rm -r dir
```

### 6.4 问题：删除嵌套目录失败
**解决方案**：使用 -p 选项
```bash
rmdir -p dir1/dir2/dir3
```

### 6.5 问题：rmdir 命令执行缓慢
**解决方案**：目录层级过多，使用 -p 选项
```bash
rmdir -p dir1/dir2/dir3
```

## 7. 命令对比

| 命令 | 功能 | 适用场景 |
|------|------|----------|
| rmdir | 删除空目录 | 所有 Linux 系统 |
| rm | 删除文件或目录 | 所有 Linux 系统 |
| mkdir | 创建目录 | 所有 Linux 系统 |
| mv | 移动或重命名文件 | 所有 Linux 系统 |

## 8. 注意事项
- rmdir 命令用于删除空目录，是 Linux 系统中常用的文件操作命令之一
- rmdir 命令只能删除空目录，不能删除非空目录
- 常用的操作包括：基本用法、递归删除目录、详细显示删除过程等
- rmdir 命令不需要 root 权限来执行，但删除受保护目录时需要
- rmdir 命令支持多种选项，可以根据需要选择合适的选项
- rmdir 命令是所有 Linux 系统的标准工具，用于删除空目录