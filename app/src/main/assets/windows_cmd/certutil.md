# certutil命令

## 命令简介

`certutil`命令是Windows中的一个命令，用于管理证书和证书存储。

## 语法

```cmd
certutil [选项]
```

## 选项

| 选项 | 描述 |
|------|------|
| `-dump` | 显示证书内容 |
| `-verify` | 验证证书 |
| `-addstore` | 添加证书到存储 |
| `-delstore` | 从存储中删除证书 |
| `-viewstore` | 查看存储中的证书 |
| `-exportPFX` | 导出PFX证书 |
| `-importPFX` | 导入PFX证书 |
| `-crl` | 管理证书吊销列表 |
| `-encode` | 编码证书 |
| `-decode` | 解码证书 |

## 示例

### 查看证书内容

```cmd
# 查看证书内容
certutil -dump certificate.cer

# 查看证书存储中的证书
certutil -viewstore My
```

### 验证证书

```cmd
# 验证证书
certutil -verify certificate.cer

# 验证证书链
certutil -verify -urlfetch certificate.cer
```

### 管理证书存储

```cmd
# 添加证书到存储
certutil -addstore My certificate.cer

# 从存储中删除证书
certutil -delstore My "CN=example.com"
```

### 导出和导入证书

```cmd
# 导出PFX证书
certutil -exportPFX -p password My "CN=example.com" certificate.pfx

# 导入PFX证书
certutil -importPFX -p password My certificate.pfx
```

## 高级用法

### 管理证书吊销列表

```cmd
# 下载证书吊销列表
certutil -urlfetch -crl http://example.com/crl.crl

# 查看证书吊销列表
certutil -dump crl.crl
```

### 编码和解码证书

```cmd
# 编码证书
certutil -encode certificate.cer certificate.base64

# 解码证书
certutil -decode certificate.base64 certificate.cer
```

## 常见问题

### 问题：certutil命令执行失败

**原因**：可能是权限不足，或者证书不存在。

**解决方法**：以管理员身份运行命令提示符，确保证书存在。

### 问题：证书验证失败

**原因**：可能是证书已过期，或者证书链不完整。

**解决方法**：检查证书有效期，确保证书链完整。

## 命令对比

| 命令 | 功能 | 特点 |
|------|------|------|
| `certutil` | 管理证书 | 用于管理证书和证书存储 |
| `certreq` | 管理证书请求 | 用于请求、获取和安装证书 |
| `certsrv.msc` | 证书颁发机构 | 图形界面的证书管理工具 |

## 注意事项

1. **权限要求**：使用`certutil`命令需要管理员权限。

2. **证书存储**：`certutil`命令可以管理不同的证书存储。

3. **适用场景**：`certutil`命令适用于管理证书和证书存储的场景。