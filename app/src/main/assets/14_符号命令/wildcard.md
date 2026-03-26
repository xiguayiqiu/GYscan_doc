# Shell 通配符

## 命令简介

Shell 通配符用于匹配文件和目录名称，是 Shell 命令中常用的功能。

## 通配符类型

| 通配符 | 说明 | 示例 |
|--------|------|------|
| `*` | 匹配任意字符（包括零个） | `*.txt` 匹配所有 .txt 文件 |
| `?` | 匹配单个字符 | `file?.txt` 匹配 file1.txt、file2.txt 等 |
| `[]` | 匹配方括号内的任意一个字符 | `file[123].txt` 匹配 file1.txt、file2.txt、file3.txt |
| `[!]` | 匹配不在方括号内的任意一个字符 | `file[!123].txt` 匹配除了 file1.txt、file2.txt、file3.txt 之外的文件 |
| `[a-z]` | 匹配 a 到 z 之间的任意字符 | `file[a-z].txt` 匹配 filea.txt、fileb.txt 等 |
| `[0-9]` | 匹配 0 到 9 之间的任意数字 | `file[0-9].txt` 匹配 file0.txt、file1.txt 等 |
| `{a,b,c}` | 扩展通配符：匹配 a、b 或 c | `file{a,b,c}.txt` 匹配 filea.txt、fileb.txt、filec.txt |
| `{1..10}` | 数字序列：生成 1 到 10 的数字序列 | `file{1..3}.txt` 匹配 file1.txt、file2.txt、file3.txt |

## 命令示例

### 匹配所有 .txt 文件

```bash
ls *.txt
```

### 匹配以 file 开头，后跟一个字符，以 .txt 结尾的文件

```bash
ls file?.txt
```

### 匹配以 file 开头，后跟 1、2 或 3，以 .txt 结尾的文件

```bash
ls file[123].txt
```

### 匹配以 file 开头，后跟非 1、2 或 3 的字符，以 .txt 结尾的文件

```bash
ls file[!123].txt
```

### 匹配以 file 开头，后跟 a 到 z 之间的字符，以 .txt 结尾的文件

```bash
ls file[a-z].txt
```

### 匹配以 file 开头，后跟 0 到 9 之间的数字，以 .txt 结尾的文件

```bash
ls file[0-9].txt
```

### 匹配 filea.txt、fileb.txt、filec.txt

```bash
ls file{a,b,c}.txt
```

### 匹配 file1.txt、file2.txt、file3.txt

```bash
ls file{1..3}.txt
```

## 常用组合

### 组合多个通配符

```bash
ls file[0-9]*.txt
```

### 递归匹配

```bash
find . -name "*.txt"
```

## 相关命令

- `ls`: 列出目录内容
- `find`: 搜索文件
- `grep`: 搜索文本模式