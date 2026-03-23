# john 命令

## 命令说明
John the Ripper（简称john）是一款功能强大的密码破解工具，用于破解各种加密的密码哈希。它支持多种密码哈希格式，包括Unix系统密码、Windows LM哈希、MD5、SHA等，是安全测试和密码审计的重要工具。

## 语法
```
john [选项] [文件]
```

## 常用选项
- `-wordlist=<文件>`：指定字典文件
- `-rules`：启用规则-based密码破解
- `-incremental`：使用增量模式破解
- `-single`：使用单模式破解
- `-external=<模式>`：使用外部模式破解
- `-format=<格式>`：指定哈希格式
- `-session=<名称>`：创建会话文件
- `-restore`：恢复之前的会话
- `-show`：显示已破解的密码
- `-test`：测试破解性能
- `-users=<用户>`：指定要破解的用户
- `-groups=<组>`：指定要破解的组
- `-salts=<数量>`：指定盐值数量
- `-min-length=<长度>`：设置最小密码长度
- `-max-length=<长度>`：设置最大密码长度
- `--help`：显示帮助信息
- `--version`：显示版本信息

## 支持的哈希格式

john支持多种哈希格式，包括：
- `descrypt`：传统的Unix密码哈希
- `md5crypt`：MD5-based Unix密码哈希
- `bcrypt`：bcrypt密码哈希
- `sha512crypt`：SHA-512-based Unix密码哈希
- `lm`：Windows LM哈希
- `nt`：Windows NT哈希
- `md5`：MD5哈希
- `sha1`：SHA-1哈希
- `mysql`：MySQL密码哈希
- `postgresql`：PostgreSQL密码哈希
- `oracle`：Oracle密码哈希

## 示例

### 基本操作
```bash
# 破解密码文件
john password_file

# 使用字典文件破解
john --wordlist=wordlist.txt password_file

# 启用规则-based破解
john --wordlist=wordlist.txt --rules password_file

# 使用增量模式破解
john --incremental password_file
```

### 哈希格式指定
```bash
# 指定哈希格式为MD5
john --format=md5 --wordlist=wordlist.txt password_file

# 指定哈希格式为Windows LM
john --format=lm --wordlist=wordlist.txt password_file

# 指定哈希格式为SHA-512
john --format=sha512crypt --wordlist=wordlist.txt password_file
```

### 会话管理
```bash
# 创建会话文件
john --session=session1 --wordlist=wordlist.txt password_file

# 恢复之前的会话
john --restore=session1

# 显示已破解的密码
john --show password_file
```

### 高级选项
```bash
# 测试破解性能
john --test

# 指定要破解的用户
john --users=user1,user2 password_file

# 设置最小密码长度
john --min-length=8 --wordlist=wordlist.txt password_file

# 设置最大密码长度
john --max-length=12 --wordlist=wordlist.txt password_file
```

## 适用场景

### 安全测试
- 测试密码强度
- 评估系统的密码策略
- 发现弱密码
- 验证密码哈希的安全性

### 渗透测试
- 破解获取的密码哈希
- 提权后获取系统密码
- 测试认证系统的安全性
- 评估网络设备的密码强度

### 安全审计
- 定期检查系统密码强度
- 识别弱密码和重复密码
- 评估密码策略的有效性
- 提供密码安全建议

### 事件响应
- 分析安全事件中的密码哈希
- 识别可能的密码泄露
- 评估攻击的影响范围
- 提供事件响应建议

### 密码恢复
- 恢复忘记的密码
- 重置丢失的密码
- 访问加密的文件和系统

## 高级技巧

### 字典文件准备
```bash
# 使用crunch生成自定义字典
crunch 8 12 -f charset.lst mixalpha-numeric-all-space -o custom_wordlist.txt

# 使用cewl从网站生成字典
cewl https://example.com -w website_wordlist.txt

# 合并多个字典文件
cat wordlist1.txt wordlist2.txt > combined_wordlist.txt

# 排序并去重字典文件
sort combined_wordlist.txt | uniq > unique_wordlist.txt
```

### 规则配置
```bash
# 编辑规则文件
vi /etc/john/john.conf

# 添加自定义规则
[List.Rules:Custom]
Az"[0-9]"
Az"[0-9][0-9]"

# 使用自定义规则
john --wordlist=wordlist.txt --rules=Custom password_file
```

### 性能优化
- 使用GPU加速（如果支持）
- 选择合适的破解模式
- 优化字典文件
- 使用多线程破解
- 合理设置破解参数

### 安全注意事项
- 获得授权后再进行密码破解
- 遵守相关法律法规
- 妥善处理破解结果，避免敏感信息泄露
- 仅用于合法的安全测试和密码恢复

## 常见问题解决

- **问题**：破解速度慢
  **解决方法**：使用更强大的硬件，优化字典文件，选择合适的破解模式

- **问题**：无法识别哈希格式
  **解决方法**：使用 `--format` 选项指定正确的哈希格式

- **问题**：字典文件过大
  **解决方法**：使用更小的字典文件，或使用增量模式

- **问题**：内存不足
  **解决方法**：减少并行破解的数量，使用更小的字典文件

## 总结
John the Ripper是一款功能强大、灵活的密码破解工具，提供了丰富的选项和功能，适用于各种密码测试和审计场景。通过掌握john的使用方法，安全专业人员可以更有效地测试密码强度、评估系统的安全状况、发现潜在的安全问题。

john的优势在于：
- 支持多种哈希格式
- 灵活的破解模式
- 强大的规则系统
- 与其他工具的良好集成
- 开源免费

作为密码破解的瑞士军刀，John the Ripper是每个安全专业人员必备的工具之一。