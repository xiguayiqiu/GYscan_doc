# Shell 管道

## 命令简介

Shell 管道用于将一个命令的输出作为另一个命令的输入，是 Shell 命令中常用的功能。

## 管道符号

| 符号 | 说明 | 示例 |
|------|------|------|
| `|` | 管道：将一个命令的输出作为另一个命令的输入 | `ls -l | grep "txt"` |

## 命令示例

### 查找包含特定文本的文件

```bash
ls -l | grep "txt"
```

### 统计文件数量

```bash
ls -l | wc -l
```

### 排序文件列表

```bash
ls -l | sort
```

### 显示文件内容并过滤

```bash
cat file.txt | grep "keyword"
```

### 组合多个管道

```bash
ls -l | grep "txt" | sort | head -5
```

## 常用组合

### 查找并显示文件内容

```bash
find . -name "*.txt" | xargs cat
```

### 统计特定类型文件的数量

```bash
ls -l | grep "\.txt$" | wc -l
```

### 查找并删除文件

```bash
find . -name "*.tmp" | xargs rm
```

## 相关命令

- `grep`: 搜索文本模式
- `sort`: 排序文本
- `wc`: 统计文件行数、字数、字节数
- `head`: 显示文件开头
- `tail`: 显示文件结尾