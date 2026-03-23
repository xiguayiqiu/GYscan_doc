# gophish 命令

## 命令说明
Gophish是一款功能强大的钓鱼邮件测试工具，用于测试组织的钓鱼邮件防御能力。它可以创建和发送钓鱼邮件，跟踪邮件的打开率、点击率和提交率，是社会工程学测试的重要工具。

## 语法
```
gophish [选项]
```

## 常用选项
- `-h`：显示帮助信息
- `-v`：显示版本信息
- `-host <主机>`：指定主机
- `-port <端口>`：指定端口
- `-config <文件>`：指定配置文件
- `-migrate`：执行数据库迁移

## 核心功能

Gophish提供了多种核心功能：
- **钓鱼邮件创建**：创建自定义的钓鱼邮件
- **邮件模板管理**：管理邮件模板
- **目标管理**：管理目标邮箱列表
- **钓鱼活动跟踪**：跟踪钓鱼邮件的打开率、点击率和提交率
- **报告生成**：生成详细的钓鱼测试报告
- **钓鱼网站管理**：管理钓鱼网站

## 技术原理

Gophish通过以下步骤工作：

1. 启动Gophish服务器
2. 创建钓鱼邮件模板
3. 导入目标邮箱列表
4. 创建钓鱼活动
5. 发送钓鱼邮件
6. 跟踪和分析结果
7. 生成报告

Gophish使用Web界面，提供了直观的用户界面，使得钓鱼邮件测试更加简单和高效。

## 示例

### 基本操作
```bash
# 启动Gophish服务器
gophish

# 启动Gophish服务器并指定主机
gophish -host 0.0.0.0

# 启动Gophish服务器并指定端口
gophish -port 3333

# 访问Gophish Web界面
# 打开浏览器，访问 http://localhost:3333
```

### 高级选项
```bash
# 使用自定义配置文件
gophish -config config.json

# 执行数据库迁移
gophish -migrate

# 后台运行Gophish
gophish &

# 停止Gophish服务器
kill $(ps aux | grep gophish | grep -v grep | awk '{print $2}')
```

### 实际应用
```bash
# 创建钓鱼邮件活动
# 1. 启动Gophish服务器
gophish

# 2. 访问Web界面
# 打开浏览器，访问 http://localhost:3333

# 3. 登录Gophish
# 默认用户名：admin
# 默认密码：gophish

# 4. 创建邮件模板
# 点击 "Email Templates" -> "New Template"

# 5. 导入目标邮箱列表
# 点击 "Groups" -> "New Group"

# 6. 创建钓鱼网站
# 点击 "Landing Pages" -> "New Page"

# 7. 创建钓鱼活动
# 点击 "Campaigns" -> "New Campaign"

# 8. 启动钓鱼活动
# 点击 "Launch Campaign"

# 9. 查看活动结果
# 点击 "Campaigns" -> 选择活动 -> "Results"
```

## 适用场景

### 安全意识培训
- 测试员工的钓鱼邮件识别能力
- 评估组织的钓鱼邮件防御能力
- 提高员工的安全意识
- 发现组织的安全漏洞

### 渗透测试
- 作为渗透测试的一部分
- 测试组织的钓鱼邮件防御能力
- 获取初始访问权限
- 评估组织的安全状况

### 安全审计
- 评估组织的钓鱼邮件防御能力
- 发现钓鱼邮件防御漏洞
- 提供安全加固建议
- 验证安全控制措施的有效性

### 教育和研究
- 学习钓鱼邮件攻击技术
- 研究钓鱼邮件防御方法
- 开发钓鱼邮件检测工具
- 测试钓鱼邮件防御措施

### 事件响应
- 分析安全事件中的钓鱼邮件攻击
- 评估攻击的影响范围
- 提供事件响应建议
- 加强钓鱼邮件防御

## 高级技巧

### 与其他工具结合
```bash
# 结合SET使用
setoolkit
# 创建钓鱼邮件模板

gophish
# 导入模板并发送钓鱼邮件

# 结合BeEF使用
beef -x
# 在钓鱼网站中注入BeEF hook代码

gophish
# 创建包含BeEF hook的钓鱼网站

# 结合Metasploit使用
msfconsole
# 生成payload

gophish
# 在钓鱼邮件中添加payload

# 结合Empire使用
empire
# 生成payload

gophish
# 在钓鱼邮件中添加payload
```

### 自定义模板
```bash
# 创建自定义邮件模板
cat > phishing_email.html << 'EOF'
<!DOCTYPE html>
<html>
<head>
    <title>Password Reset</title>
</head>
<body>
    <h1>Password Reset Required</h1>
    <p>Dear User,</p>
    <p>We have detected unusual activity on your account. Please reset your password immediately by clicking the link below:</p>
    <p><a href="{{.URL}}">Reset Password</a></p>
    <p>Thank you,</p>
    <p>IT Support Team</p>
</body>
</html>
EOF

# 在Gophish中导入模板
# 点击 "Email Templates" -> "Import Template"
```

### 性能优化
- 使用专用的服务器运行Gophish
- 优化邮件发送配置
- 合理设置钓鱼活动参数
- 定期清理旧活动数据

### 安全注意事项
- 获得授权后再进行测试
- 避免攻击他人的系统
- 遵守相关法律法规
- 妥善处理收集的信息

## 常见问题解决

- **问题**：Gophish无法启动
  **解决方法**：检查端口是否被占用，确保配置文件正确，验证数据库连接

- **问题**：邮件发送失败
  **解决方法**：检查SMTP服务器配置，确保SMTP服务器可用，验证发件人邮箱设置

- **问题**：钓鱼网站无法访问
  **解决方法**：检查网络连接，确保防火墙允许访问，验证钓鱼网站配置

- **问题**：活动结果不准确
  **解决方法**：检查跟踪设置，确保钓鱼网站配置正确，验证邮件模板设置

## 总结
Gophish是一款功能强大、直观的钓鱼邮件测试工具，提供了丰富的功能和选项，适用于各种社会工程学测试和安全意识培训场景。通过掌握Gophish的使用方法，安全专业人员可以更有效地测试组织的钓鱼邮件防御能力、提高员工的安全意识、发现钓鱼邮件防御漏洞和评估组织的安全状况。

Gophish的优势在于：
- 图形化用户界面
- 强大的跟踪能力
- 灵活的配置选项
- 与其他工具的良好集成
- 开源免费

作为钓鱼邮件测试的重要工具，Gophish是每个安全专业人员必备的工具之一。