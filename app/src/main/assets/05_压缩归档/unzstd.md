# unzstd - 解压缩zstd文件

## 1. 命令简介
unzstd 命令用于解压缩 zstd 压缩的文件，是 Linux 系统中常用的压缩归档命令之一。

## 2. 命令语法
```bash
unzstd [选项] [文件]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -f | 强制覆盖 |
| -k | 保留原始文件 |
| -v | 显示详细信息 |
| --help | 显示帮助信息 |
| --version | 显示版本信息 |

## 4. 实战示例

### 4.1 解压缩zstd文件
```bash
unzstd file.zst
```

### 4.2 保留原始文件
```bash
unzstd -k file.zst
```

### 4.3 显示详细信息
```bash
unzstd -v file.zst
```

## 5. 注意事项
- unzstd 命令用于解压缩 zstd 压缩的文件
- unzstd 命令会删除原始的压缩文件，使用 -k 选项可以保留
- unzstd 命令是一个常用的压缩工具，用于解压缩 zstd 文件