# certreq命令

## 命令简介

`certreq`命令是Windows中的一个命令，用于请求、获取和安装证书。

## 语法

```cmd
certreq [选项]
```

## 选项

| 选项 | 描述 |
|------|------|
| `-new` | 创建证书请求 |
| `-submit` | 提交证书请求 |
| `-accept` | 接受和安装证书 |
| `-retrieve` | 检索已颁发的证书 |
| `-delete` | 删除证书请求 |
| `-enum` | 枚举证书请求 |
| `-config` | 指定证书颁发机构配置 |

## 示例

### 创建证书请求

```cmd
# 创建证书请求
certreq -new request.inf request.req

# 创建证书请求并指定配置
certreq -new -config "Server\CA" request.inf request.req
```

### 提交证书请求

```cmd
# 提交证书请求
certreq -submit request.req certificate.cer

# 提交证书请求并指定配置
certreq -submit -config "Server\CA" request.req certificate.cer
```

### 接受和安装证书

```cmd
# 接受和安装证书
certreq -accept certificate.cer

# 接受和安装证书到指定存储
certreq -accept -user certificate.cer
```

### 检索已颁发的证书

```cmd
# 检索已颁发的证书
certreq -retrieve 12345 certificate.cer

# 检索已颁发的证书并指定配置
certreq -retrieve -config "Server\CA" 12345 certificate.cer
```

## 高级用法

### 批量处理证书请求

```cmd
# 创建一个批处理文件
@echo off

# 批量创建证书请求
for %%f in (*.inf) do (
    echo 创建证书请求: %%~nf
    certreq -new %%f %%~nf.req
    certreq -submit %%~nf.req %%~nf.cer
    certreq -accept %%~nf.cer
)

echo 证书处理完成
```

### 证书请求配置文件

```cmd
# 创建证书请求配置文件
[Version]
Signature="$Windows NT$"

[NewRequest]
Subject="CN=example.com"
KeySpec=1
KeyLength=2048
Exportable=true
MachineKeySet=true
SMIME=false
PrivateKeyArchive=false
UserProtected=false
UseExistingKeySet=false
ProviderName="Microsoft RSA SChannel Cryptographic Provider"
ProviderType=12
RequestType=PKCS10
KeyUsage=0xa0

[EnhancedKeyUsageExtension]
OID=1.3.6.1.5.5.7.3.1 ; Server Authentication
```

## 常见问题

### 问题：certreq命令执行失败

**原因**：可能是权限不足，或者证书颁发机构不可用。

**解决方法**：以管理员身份运行命令提示符，确保证书颁发机构可用。

### 问题：证书请求被拒绝

**原因**：可能是证书请求配置不正确，或者证书颁发机构策略不允许。

**解决方法**：检查证书请求配置，确保符合证书颁发机构的要求。

## 命令对比

| 命令 | 功能 | 特点 |
|------|------|------|
| `certreq` | 管理证书请求 | 用于请求、获取和安装证书 |
| `certutil` | 证书工具 | 用于管理证书和证书存储 |
| `certsrv.msc` | 证书颁发机构 | 图形界面的证书管理工具 |

## 注意事项

1. **权限要求**：使用`certreq`命令需要管理员权限。

2. **证书颁发机构**：`certreq`命令需要连接到证书颁发机构。

3. **配置文件**：创建证书请求时需要使用配置文件。

4. **适用场景**：`certreq`命令适用于管理证书请求的场景。