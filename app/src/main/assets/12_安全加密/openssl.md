# openssl - OpenSSL工具

## 1. 命令简介
openssl 命令是 OpenSSL 工具，用于加密、解密、签名等操作，是 Linux 系统中常用的安全加密命令之一。

## 2. 命令语法
```bash
openssl [命令] [选项]
```

## 3. 常用命令
| 命令 | 说明 |
|------|------|
| genrsa | 生成RSA密钥 |
| req | 生成证书请求 |
| x509 | 处理X.509证书 |
| enc | 加密/解密数据 |
| dgst | 计算哈希值 |
| s_client | SSL/TLS客户端 |
| s_server | SSL/TLS服务器 |

## 4. 实战示例

### 4.1 生成RSA密钥
```bash
openssl genrsa -out private.key 2048
```

### 4.2 生成证书请求
```bash
openssl req -new -key private.key -out csr.csr
```

### 4.3 自签名证书
```bash
openssl x509 -req -days 365 -in csr.csr -signkey private.key -out certificate.crt
```

### 4.4 计算文件哈希值
```bash
openssl dgst -sha256 file.txt
```

## 5. 注意事项
- openssl 命令是一个强大的加密工具，用于各种加密和安全操作
- openssl 命令支持多种加密算法和协议
- openssl 命令是一个常用的安全工具，用于生成密钥、证书和进行加密操作