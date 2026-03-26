# Shell 历史命令

## 命令简介

Shell 历史命令用于执行历史记录中的命令，是 Shell 命令中常用的功能。

## 历史命令符号

| 符号 | 说明 | 示例 |
|------|------|------|
| `!` | 历史命令：执行历史命令中的命令 | `!ls` |
| `!!` | 上一条命令：执行上一条命令 | `!!` |
| `!n` | 历史命令：执行历史记录中第n条命令 | `!10` |
| `!string` | 历史命令：执行最近以string开头的命令 | `!echo` |
| `^` | 替换：替换上一条命令中的字符串 | `^old^new` |

## 命令示例

### 执行最近以 ls 开头的命令

```bash
!ls
```

### 执行上一条命令

```bash
!!
```

### 执行历史记录中第 10 条命令

```bash
!10
```

### 执行最近以 echo 开头的命令

```bash
!echo
```

### 替换上一条命令中的字符串

```bash
# 假设上一条命令是：echo "Hello World"
^World^Universe  # 执行 echo "Hello Universe"
```

## 常用组合

### 查看历史命令

```bash
history
```

### 搜索历史命令

```bash
history | grep "ls"
```

### 清除历史命令

```bash
history -c
```

### 执行历史命令并修改

```bash
# 执行最近以 git 开头的命令，并将 commit 改为 push
git commit -m "Initial commit"
!git:s/commit/push/
```

## 相关命令

- `history`: 显示命令历史
- `fc`: 编辑并执行历史命令
- `grep`: 搜索文本模式