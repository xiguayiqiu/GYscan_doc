# flex 命令

## 命令简介

`flex` 是一个词法分析器生成器，它可以根据词法规则生成 C 语言的词法分析器，是 lex 的 GNU 版本。

## 命令语法

```bash
flex [options] [file]
```

## 命令选项

| 选项 | 说明 |
|------|------|
| `-h`, `--help` | 显示帮助信息 |
| `-V`, `--version` | 显示版本信息 |
| `-o FILE`, `--outfile=FILE` | 指定输出文件 |
| `-d`, `--debug` | 生成调试信息 |
| `-t`, `--stdout` | 输出到标准输出 |
| `-i`, `--case-insensitive` | 忽略大小写 |
| `-n`, `--noline` | 不生成行号 |
| `-s`, `--nodefault` | 不生成默认规则 |

## 命令示例

### 生成词法分析器

```bash
flex lexer.l
```

### 指定输出文件

```bash
flex -o lexer.c lexer.l
```

### 生成调试信息

```bash
flex -d lexer.l
```

### 输出到标准输出

```bash
flex -t lexer.l
```

## 常用组合

### 完整的词法和语法分析器生成

```bash
# 生成词法分析器
flex lexer.l

# 生成语法分析器
bison -d grammar.y

# 编译
cc -o parser lex.yy.c grammar.tab.c
```

### 调试词法分析器

```bash
flex -d lexer.l
bison -t grammar.y
cc -o parser lex.yy.c grammar.tab.c -DYYDEBUG=1
```

## 相关命令

- `bison`: 语法分析器生成器
- `lex`: 词法分析器生成器
- `gcc`: GNU C 编译器