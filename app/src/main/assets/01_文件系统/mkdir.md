# mkdir - 创建目录

## 1. 命令简介
mkdir 命令用于创建目录，是 Linux 系统中最常用的目录操作命令之一。它可以创建单个目录或递归创建多层目录结构。

## 2. 命令语法
```bash
mkdir [选项] 目录...
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -p | 递归创建目录，包括所有必需的父目录 |
| -m | 指定目录权限，以八进制数字表示 |
| -v | 详细模式，显示创建的每个目录 |
| -Z | 设置 SELinux 安全上下文 |
| --context[=CTX] | 类似 -Z，但可以指定具体的安全上下文 |
| --help | 显示帮助信息 |
| --version | 显示版本信息 |

## 4. 实战示例

### 4.1 创建单个目录
```bash
mkdir directory
```

### 4.2 递归创建目录
```bash
mkdir -p parent/child/grandchild
```

### 4.3 指定目录权限
```bash
mkdir -m 755 directory
```

### 4.4 显示创建的目录
```bash
mkdir -v directory
```

### 4.5 递归创建目录并显示
```bash
mkdir -pv parent/child/grandchild
```

### 4.6 创建多个目录
```bash
mkdir dir1 dir2 dir3
```

### 4.7 创建带特殊权限的目录
```bash
# 创建只有所有者可写的目录
mkdir -m 700 private_dir

# 创建可执行的目录
mkdir -m 755 executable_dir
```

### 4.8 创建目录并设置 SELinux 上下文
```bash
mkdir -Z directory
```

## 5. 高级用法

### 5.1 批量创建目录
```bash
# 创建多个目录
mkdir dir1 dir2 dir3

# 创建带编号的目录
mkdir dir{1..5}

# 创建带前缀的目录
mkdir prefix_{a,b,c}

# 创建嵌套目录结构
mkdir -p project/{src,docs,tests,bin}
```

### 5.2 创建临时目录
```bash
# 创建临时目录
mkdir -p /tmp/my_temp_dir

# 使用 mktemp 创建安全的临时目录
TEMP_DIR=$(mktemp -d)
mkdir -p "$TEMP_DIR/subdir"
```

### 5.3 创建目录并设置默认权限
```bash
# 创建目录并设置权限为 755
mkdir -m 755 public_dir

# 创建目录并设置权限为 700
mkdir -m 700 private_dir
```

### 5.4 与其他命令结合使用
```bash
# 创建目录并进入
mkdir -p new_dir && cd new_dir

# 创建目录并复制文件
mkdir -p destination && cp file.txt destination/

# 创建目录结构并设置权限
mkdir -p -m 755 project/{src,docs,tests}
```

## 6. 性能优化

### 6.1 批量创建目录
- 使用单个 mkdir 命令创建多个目录比多次执行 mkdir 命令更快
- 使用 `-p` 选项递归创建目录结构比逐层创建更高效

### 6.2 示例：高效创建目录结构
```bash
# 一次创建多个目录
mkdir dir1 dir2 dir3

# 递归创建复杂目录结构
mkdir -p project/{src/{main,test},docs/{api,user},bin,lib}
```

### 6.3 避免创建重复目录
```bash
# 检查目录是否存在，不存在则创建
if [ ! -d "directory" ]; then
    mkdir -p directory
fi

# 或者使用 || 操作符
mkdir -p directory || true
```

## 7. 常见问题与解决方案

### 7.1 问题：无法创建目录，权限被拒绝
**解决方案**：确保有足够的权限，或使用`sudo`命令

### 7.2 问题：创建目录时出现"File exists"错误
**解决方案**：使用`-p`选项，它会忽略已存在的目录

### 7.3 问题：创建嵌套目录结构失败
**解决方案**：使用`-p`选项递归创建所有必需的父目录

### 7.4 问题：创建的目录权限不正确
**解决方案**：使用`-m`选项指定正确的权限

### 7.5 问题：目录名称包含空格
**解决方案**：使用引号包围目录名称，如`mkdir "my directory"`

## 8. 命令对比

| 命令 | 功能 | 适用场景 |
|------|------|----------|
| mkdir | 创建目录 | 基本目录创建操作 |
| rmdir | 删除空目录 | 仅删除空目录 |
| touch | 创建空文件 | 创建文件 |
| mktemp | 创建临时文件或目录 | 创建安全的临时文件/目录 |

## 9. 注意事项
- 默认情况下，mkdir 只能创建一级目录，需要使用 -p 选项来创建多级目录
- 使用 -m 选项可以指定目录的权限，默认权限是 755（受 umask 影响）
- 目录名称不能包含特殊字符，如 / 等，但可以包含空格（需要用引号包围）
- 使用 -p 选项时，如果目录已存在，mkdir 不会报错
- 创建目录时，需要确保父目录存在（或使用 -p 选项）
- 对于系统目录，需要 root 权限才能创建
- 目录名称应该简洁明了，避免使用特殊字符和空格