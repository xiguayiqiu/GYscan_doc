# bitsadmin命令

## 命令简介

`bitsadmin`命令是Windows中的一个命令，用于管理后台智能传输服务（BITS），用于在后台传输文件。

## 语法

```cmd
bitsadmin [子命令] [选项]
```

## 选项

| 选项 | 描述 |
|------|------|
| `/transfer` | 创建并启动一个传输作业 |
| `/create` | 创建一个传输作业 |
| `/addfile` | 向作业添加文件 |
| `/resume` | 恢复作业 |
| `/suspend` | 暂停作业 |
| `/cancel` | 取消作业 |
| `/complete` | 完成作业 |
| `/list` | 列出作业 |
| `/info` | 显示作业信息 |
| `/getstate` | 获取作业状态 |
| `/setpriority` | 设置作业优先级 |

## 示例

### 创建和启动传输作业

```cmd
# 创建并启动一个传输作业
bitsadmin /transfer myjob /download /priority normal "http://example.com/file.zip" "C:\Downloads\file.zip"

# 创建一个传输作业
bitsadmin /create myjob

# 向作业添加文件
bitsadmin /addfile myjob "http://example.com/file1.zip" "C:\Downloads\file1.zip"
bitsadmin /addfile myjob "http://example.com/file2.zip" "C:\Downloads\file2.zip"

# 启动作业
bitsadmin /resume myjob
```

### 管理作业

```cmd
# 暂停作业
bitsadmin /suspend myjob

# 恢复作业
bitsadmin /resume myjob

# 取消作业
bitsadmin /cancel myjob

# 完成作业
bitsadmin /complete myjob
```

### 查看作业信息

```cmd
# 列出所有作业
bitsadmin /list

# 显示作业信息
bitsadmin /info myjob

# 获取作业状态
bitsadmin /getstate myjob

# 设置作业优先级
bitsadmin /setpriority myjob high
```

## 高级用法

### 批量传输文件

```cmd
# 创建一个批处理文件
@echo off

# 批量传输文件
bitsadmin /create downloadjob
bitsadmin /addfile downloadjob "http://example.com/file1.zip" "C:\Downloads\file1.zip"
bitsadmin /addfile downloadjob "http://example.com/file2.zip" "C:\Downloads\file2.zip"
bitsadmin /addfile downloadjob "http://example.com/file3.zip" "C:\Downloads\file3.zip"
bitsadmin /resume downloadjob

# 等待作业完成
:check
bitsadmin /getstate downloadjob | find "TRANSFERRED" > nul
if errorlevel 1 goto check

bitsadmin /complete downloadjob
echo 文件传输完成
```

### 上传文件

```cmd
# 上传文件
bitsadmin /transfer uploadjob /upload /priority normal "C:\Uploads\file.zip" "http://example.com/upload.php"
```

## 常见问题

### 问题：bitsadmin命令执行失败

**原因**：可能是权限不足，或者BITS服务未运行。

**解决方法**：以管理员身份运行命令提示符，确保BITS服务已启动。

### 问题：文件传输失败

**原因**：可能是网络连接问题，或者目标路径不存在。

**解决方法**：检查网络连接，确保目标路径存在。

## 命令对比

| 命令 | 功能 | 特点 |
|------|------|------|
| `bitsadmin` | 管理BITS传输 | 用于在后台传输文件 |
| `curl` | 下载文件 | 用于从网络下载文件 |
| `wget` | 下载文件 | 用于从网络下载文件 |

## 注意事项

1. **权限要求**：使用`bitsadmin`命令需要管理员权限。

2. **BITS服务**：`bitsadmin`命令依赖于后台智能传输服务（BITS）。

3. **适用场景**：`bitsadmin`命令适用于在后台传输文件的场景，特别是大文件的传输。