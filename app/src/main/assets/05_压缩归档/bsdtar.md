# bsdtar - BSD tar

## 1. 命令简介
bsdtar 命令是 BSD 版本的 tar 命令，用于创建和提取归档文件，是 Linux 系统中常用的压缩归档命令之一。

## 2. 命令语法
```bash
bsdtar [选项] [操作] [文件]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -c | 创建归档 |
| -x | 提取归档 |
| -t | 列出归档内容 |
| -f | 指定归档文件 |
| -v | 显示详细信息 |
| -z | 使用 gzip 压缩 |
| -j | 使用 bzip2 压缩 |
| -J | 使用 xz 压缩 |
| -C | 指定提取目录 |

## 4. 常用操作
| 操作 | 说明 |
|------|------|
| -c | 创建归档 |
| -x | 提取归档 |
| -t | 列出归档内容 |

## 5. 实战示例

### 5.1 创建归档
```bash
bsdtar -cf archive.tar file1.txt file2.txt
```

### 5.2 创建压缩归档
```bash
bsdtar -czf archive.tar.gz file1.txt file2.txt
```

### 5.3 提取归档
```bash
bsdtar -xf archive.tar
```

### 5.4 列出归档内容
```bash
bsdtar -tf archive.tar
```

## 6. 注意事项
- bsdtar 命令是 BSD 版本的 tar 命令，提供了更多功能
- bsdtar 命令支持多种压缩格式，如 gzip、bzip2 和 xz
- bsdtar 命令是一个常用的归档工具，用于创建和提取归档