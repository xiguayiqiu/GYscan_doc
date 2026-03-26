# tftp命令

## 命令简介

`tftp`命令是Windows中的一个命令，用于简单文件传输协议。

## 语法

```cmd
tftp [选项] [主机] [命令]
```

## 命令

| 命令 | 描述 |
|------|------|
| `get` | 下载文件 |
| `put` | 上传文件 |
| `quit` | 退出tftp |
| `verbose` | 启用详细输出 |
| `trace` | 启用跟踪 |
| `status` | 显示状态 |
| `binary` | 二进制模式 |
| `ascii` | ASCII模式 |
| `rexmt` | 设置重传超时 |
| `timeout` | 设置超时 |
| `help` | 显示帮助 |

## 示例

### 简单文件传输

```cmd
# 连接到TFTP服务器
tftp server

# 下载文件
tftp> get file.txt

# 上传文件
tftp> put file.txt

# 二进制模式
tftp> binary

# ASCII模式
tftp> ascii

# 退出tftp
tftp> quit

# 直接执行命令
tftp -i server get file.txt
```

## 高级用法

### 批量文件传输

```cmd
# 创建一个批处理文件
@echo off

# 批量文件传输
echo 下载文件
tftp -i server get file1.txt
tftp -i server get file2.txt

echo 上传文件
tftp -i server put file3.txt
tftp -i server put file4.txt

echo 操作完成
```

## 常见问题

### 问题：tftp命令执行失败

**原因**：可能是权限不足，或者服务器不可用。

**解决方法**：确保服务器可用，以管理员身份运行命令提示符。

### 问题：文件传输失败

**原因**：可能是网络连接问题，或者服务器未启用TFTP服务。

**解决方法**：确保网络连接正常，确保服务器已启用TFTP服务。

## 命令对比

| 命令 | 功能 | 特点 |
|------|------|------|
| `tftp` | 简单文件传输协议 | 用于简单文件传输 |
| `ftp` | 文件传输协议 | 用于文件传输 |
| `scp` | 安全复制 | 用于安全文件传输（需要安装） |

## 注意事项

1. **权限要求**：使用`tftp`命令需要管理员权限。

2. **网络连接**：需要确保网络连接正常。

3. **适用场景**：`tftp`命令适用于简单文件传输的场景。