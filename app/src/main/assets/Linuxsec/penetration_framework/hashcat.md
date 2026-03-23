# hashcat 命令

## 命令说明
Hashcat是一款功能强大的密码破解工具，用于破解各种密码哈希。它支持GPU加速，能够以极高的速度破解密码哈希，是目前世界上最快的密码破解工具之一，是安全测试和密码审计的重要工具。

## 语法
```
hashcat [选项] [哈希文件] [字典文件]
```

## 常用选项
- `-m <模式>`：指定哈希类型
- `-a <模式>`：指定攻击模式
- `-o <文件>`：指定输出文件
- `-O`：优化模式
- `-w <级别>`：设置工作负载级别
- `-D <设备>`：指定设备类型（1=CPU, 2=GPU, 3=FPGA, 4=ASIC）
- `-d <设备>`：指定具体设备
- `-b`：基准测试模式
- `-t <线程>`：设置线程数
- `-s <偏移>`：设置起始点
- `-l <长度>`：设置长度限制
- `--help`：显示帮助信息
- `--version`：显示版本信息

## 支持的哈希类型

Hashcat支持多种哈希类型，包括：
- `0`：MD5
- `100`：SHA1
- `1400`：SHA2-256
- `1700`：SHA2-512
- `3000`：LM
- `5500`：NTLM
- `1000`：NTLMv1
- `3200`：BCrypt
- `1500`：descrypt
- `7400`：SHA-3
- `1800`：mysql
- `3300`：Oracle 11g
- `2500`：WPA/WPA2

## 攻击模式

Hashcat支持多种攻击模式：
- `0`：字典攻击
- `1`：组合攻击
- `3`：掩码攻击
- `6`：混合字典+掩码攻击
- `7`：混合掩码+字典攻击
- `9`：剪枝攻击

## 示例

### 基本操作
```bash
# 破解MD5哈希
hashcat -m 0 hash.txt wordlist.txt

# 破解SHA1哈希
hashcat -m 100 hash.txt wordlist.txt

# 破解NTLM哈希
hashcat -m 5500 hash.txt wordlist.txt
```

### 攻击模式
```bash
# 掩码攻击
hashcat -m 0 -a 3 hash.txt ?l?l?l?l?l?l

# 组合攻击
hashcat -m 0 -a 1 hash.txt wordlist1.txt wordlist2.txt

# 混合攻击
hashcat -m 0 -a 6 hash.txt wordlist.txt ?d?d?d

# 剪枝攻击
hashcat -m 0 -a 9 hash.txt wordlist.txt
```

### 高级选项
```bash
# 设置工作负载级别
hashcat -m 0 -w 3 hash.txt wordlist.txt

# 指定输出文件
hashcat -m 0 -o cracked.txt hash.txt wordlist.txt

# 优化模式
hashcat -m 0 -O hash.txt wordlist.txt

# 基准测试
hashcat -m 0 -b
```

### WPA/WPA2破解
```bash
# 破解WPA/WPA2哈希
hashcat -m 2500 -a 0 hash.hccapx wordlist.txt

# 使用掩码攻击破解WPA/WPA2
hashcat -m 2500 -a 3 hash.hccapx ?l?l?l?l?l?l?l?l
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

### 掩码设置
```bash
# 掩码语法
# ?l = 小写字母 (a-z)
# ?u = 大写字母 (A-Z)
# ?d = 数字 (0-9)
# ?s = 特殊字符 (!@#$%^&*)
# ?a = 所有可打印字符

# 8位数字密码
hashcat -m 0 -a 3 hash.txt ?d?d?d?d?d?d?d?d

# 6-8位字母数字密码
hashcat -m 0 -a 3 hash.txt ?a?a?a?a?a?a?a?a --increment --increment-min 6

# 自定义字符集
hashcat -m 0 -a 3 hash.txt -1 ?l?u?d ?1?1?1?1?1?1
```

### 性能优化
- 使用GPU加速
- 选择合适的攻击模式
- 优化字典文件
- 设置合适的工作负载级别
- 使用多GPU并行破解

### 安全注意事项
- 获得授权后再进行密码破解
- 遵守相关法律法规
- 妥善处理破解结果，避免敏感信息泄露
- 仅用于合法的安全测试和密码恢复

## 常见问题解决

- **问题**：破解速度慢
  **解决方法**：使用GPU加速，优化字典文件，选择合适的攻击模式

- **问题**：无法识别哈希格式
  **解决方法**：使用 `-m` 选项指定正确的哈希类型

- **问题**：GPU利用率低
  **解决方法**：调整工作负载级别，确保GPU驱动正确安装

- **问题**：内存不足
  **解决方法**：减少字典文件大小，使用掩码攻击，调整线程数

## 总结
Hashcat是一款功能强大、高速的密码破解工具，提供了丰富的选项和功能，适用于各种密码测试和审计场景。通过掌握Hashcat的使用方法，安全专业人员可以更有效地测试密码强度、评估系统的安全状况、发现潜在的安全问题。

Hashcat的优势在于：
- 极高的破解速度
- 支持多种哈希类型
- 灵活的攻击模式
- GPU加速
- 与其他工具的良好集成

作为密码破解的瑞士军刀，Hashcat是每个安全专业人员必备的工具之一。