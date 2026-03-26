# setfacl - 设置文件访问控制列表

## 1. 命令简介
setfacl 命令用于设置文件访问控制列表（ACL），是 Linux 系统中常用的权限管理命令之一。它可以为文件或目录设置更细粒度的权限控制。

## 2. 命令语法
```bash
setfacl [选项] [文件或目录...]
```

## 3. 常用选项

| 选项 | 说明 |
|------|------|
| -h, --help | 显示帮助信息 |
| --version | 显示版本信息 |
| -m, --modify=<ACL> | 修改 ACL |
| -x, --remove=<ACL> | 删除 ACL |
| -b, --remove-all | 删除所有 ACL |
| -k, --remove-default | 删除默认 ACL |
| -d, --default | 设置默认 ACL |
| -R, --recursive | 递归设置 ACL |
| -v, --verbose | 详细显示设置过程 |
| -n, --no-mask | 不重新计算掩码 |
| --mask | 重新计算掩码 |

## 4. ACL 格式

| 格式 | 说明 |
|------|------|
| u:<用户>:<权限> | 设置用户权限 |
| g:<组>:<权限> | 设置组权限 |
| o:<权限> | 设置其他用户权限 |
| m:<权限> | 设置掩码 |
| d:u:<用户>:<权限> | 设置默认用户权限 |
| d:g:<组>:<权限> | 设置默认组权限 |
| d:o:<权限> | 设置默认其他用户权限 |
| d:m:<权限> | 设置默认掩码 |

## 5. 实战示例

### 5.1 基本用法
```bash
# 设置用户权限
setfacl -m u:user:rwx file.txt

# 设置组权限
setfacl -m g:group:rx file.txt

# 设置其他用户权限
setfacl -m o:r file.txt
```

### 5.2 递归设置 ACL
```bash
# 递归设置目录及其内容的 ACL
setfacl -R -m u:user:rwx dir
```

### 5.3 设置默认 ACL
```bash
# 设置目录的默认 ACL
setfacl -d -m u:user:rwx dir
```

### 5.4 删除 ACL
```bash
# 删除用户权限
setfacl -x u:user file.txt

# 删除所有 ACL
setfacl -b file.txt
```

## 6. 高级用法

### 6.1 组合选项
```bash
# 递归设置目录及其内容的 ACL，详细显示设置过程
setfacl -Rv -m u:user:rwx dir

# 递归设置目录及其内容的默认 ACL
setfacl -Rd -m u:user:rwx dir
```

### 6.2 与其他命令结合使用
```bash
# 批量设置文件 ACL
find . -name "*.txt" -exec setfacl -m u:user:rwx {} \;

# 检查 ACL 后修改
getfacl file.txt && setfacl -m u:user:rwx file.txt && getfacl file.txt
```

### 6.3 批量操作
```bash
#!/bin/bash

# 批量设置文件 ACL
files=("file1.txt" "file2.txt" "file3.txt")

for file in "${files[@]}"; do
    echo "设置 $file 的 ACL 为 u:user:rwx"
    setfacl -m u:user:rwx $file
done
```

### 6.4 自动化脚本
```bash
#!/bin/bash

# 自动化设置文件 ACL
set_acl() {
    local file=$1
    local acl=${2:-"u:user:rwx"}
    local options=${3:-""}
    
    echo "设置 $file 的 ACL 为 $acl"
    setfacl $options -m $acl $file
    
    if [ $? -eq 0 ]; then
        echo "设置成功"
    else
        echo "设置失败"
    fi
}

# 使用函数
set_acl "file1.txt"
set_acl "file2.txt" "g:group:rx"
set_acl "dir" "u:user:rwx" "-R"
```

## 7. 常见问题与解决方案

### 7.1 问题：setfacl: command not found
**解决方案**：安装 acl
- Ubuntu/Debian: `apt install acl`
- CentOS/RHEL: `yum install acl`

### 7.2 问题：无法设置 ACL
**解决方案**：确保文件系统支持 ACL
```bash
mount -o remount,acl /
```

### 7.3 问题：ACL 设置失败
**解决方案**：确保有足够的权限
```bash
sudo setfacl -m u:user:rwx file.txt
```

### 7.4 问题：setfacl 命令执行缓慢
**解决方案**：目录层级过多，使用 -R 选项时需要时间

### 7.5 问题：无法递归设置 ACL
**解决方案**：使用 -R 选项
```bash
setfacl -R -m u:user:rwx dir
```

## 8. 命令对比

| 命令 | 功能 | 适用场景 |
|------|------|----------|
| setfacl | 设置文件访问控制列表 | 所有 Linux 系统 |
| getfacl | 获取文件访问控制列表 | 所有 Linux 系统 |
| chmod | 修改文件权限 | 所有 Linux 系统 |
| chown | 修改文件所有者 | 所有 Linux 系统 |
| chgrp | 修改文件所属组 | 所有 Linux 系统 |

## 9. 注意事项
- setfacl 命令用于设置文件访问控制列表（ACL），是 Linux 系统中常用的权限管理命令之一
- setfacl 命令可以为文件或目录设置更细粒度的权限控制
- 常用的操作包括：基本用法、递归设置 ACL、设置默认 ACL、删除 ACL 等
- setfacl 命令需要 root 权限来执行
- setfacl 命令支持多种选项，可以根据需要选择合适的选项
- setfacl 命令是所有 Linux 系统的标准工具，用于设置文件访问控制列表