# tar - 归档工具

## 1. 命令简介
tar 命令用于归档文件，是 Linux 系统中常用的压缩解压命令之一。

## 2. 命令语法
```bash
tar [选项] [文件]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -c | 创建归档 |
| -x | 提取归档 |
| -f | 指定归档文件 |
| -v | 显示详细信息 |
| -z | 使用gzip压缩 |
| -j | 使用bzip2压缩 |
| -J | 使用xz压缩 |
| -t | 查看归档内容 |
| --help | 显示帮助信息 |
| --version | 显示版本信息 |

## 4. 实战示例

### 4.1 创建归档
```bash
tar -cf archive.tar file1 file2
```

### 4.2 提取归档
```bash
tar -xf archive.tar
```

### 4.3 创建gzip压缩归档
```bash
tar -czf archive.tar.gz file1 file2
```

### 4.4 查看归档内容
```bash
tar -tf archive.tar
```

## 5. 注意事项
- tar 命令用于归档文件，支持多种压缩格式
- tar 命令是一个常用的文件管理工具，用于文件归档和压缩