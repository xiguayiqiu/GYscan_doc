# bunzip2 - 解压缩bzip2文件

## 1. 命令简介
bunzip2 命令用于解压缩 bzip2 压缩的文件，是 Linux 系统中常用的压缩归档命令之一。

## 2. 命令语法
```bash
bunzip2 [选项] [文件]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -f | 强制覆盖 |
| -k | 保留原始文件 |
| -s | 显示压缩率 |
| -v | 显示详细信息 |
| --help | 显示帮助信息 |
| --version | 显示版本信息 |

## 4. 实战示例

### 4.1 解压缩bzip2文件
```bash
bunzip2 file.bz2
```

### 4.2 保留原始文件
```bash
bunzip2 -k file.bz2
```

### 4.3 显示详细信息
```bash
bunzip2 -v file.bz2
```

## 5. 注意事项
- bunzip2 命令用于解压缩 bzip2 压缩的文件
- bunzip2 命令会删除原始的压缩文件，使用 -k 选项可以保留
- bunzip2 命令是一个常用的压缩工具，用于解压缩 bzip2 文件