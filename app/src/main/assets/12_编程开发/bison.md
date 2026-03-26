# bison 命令

## 命令简介

`bison` 是一个语法分析器生成器，它可以根据语法规则生成 C 语言的语法分析器，是 yacc 的 GNU 版本。

## 命令语法

```bash
bison [options] [file]
```

## 命令选项

| 选项 | 说明 |
|------|------|
| `-h`, `--help` | 显示帮助信息 |
| `-V`, `--version` | 显示版本信息 |
| `-v`, `--verbose` | 生成详细的输出文件 |
| `-d`, `--defines` | 生成头文件 |
| `-y`, `--yacc` | 兼容 yacc 模式 |
| `-o FILE`, `--output=FILE` | 指定输出文件 |
| `-t`, `--debug` | 生成调试信息 |
| `-S FILE`, `--skeleton=FILE` | 使用指定的骨架文件 |

## 命令示例

### 生成语法分析器

```bash
bison grammar.y
```

### 生成头文件

```bash
bison -d grammar.y
```

### 生成详细输出

```bash
bison -v grammar.y
```

### 指定输出文件

```bash
bison -o parser.c grammar.y
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

### 调试语法分析器

```bash
bison -t -v grammar.y
cc -o parser lex.yy.c grammar.tab.c -DYYDEBUG=1
```

## 相关命令

- `flex`: 词法分析器生成器
- `yacc`: 语法分析器生成器
- `gcc`: GNU C 编译器