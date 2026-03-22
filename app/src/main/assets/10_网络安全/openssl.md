# openssl - OpenSSL工具

## 1. 命令简介
openssl 是一个开源的加密工具包，用于生成密钥、证书、加密和解密数据等，是 Linux 系统中最常用的安全工具之一。

## 2. 命令语法
```bash
openssl [命令] [选项]
```

## 3. 常用命令
| 命令 | 说明 |
|------|------|
| genrsa | 生成RSA私钥 |
| rsa | 处理RSA密钥 |
| req | 生成证书请求 |
| x509 | 处理X.509证书 |
| enc | 加密/解密数据 |
| dgst | 计算消息摘要 |
| s_client | SSL/TLS客户端 |
| s_server | SSL/TLS服务器 |

## 4. 实战示例

### 4.1 生成RSA私钥
```bash
openssl genrsa -out private.key 2048
```

### 4.2 生成证书请求
```bash
openssl req -new -key private.key -out certificate.csr
```

### 4.3 自签名证书
```bash
openssl x509 -req -days 365 -in certificate.csr -signkey private.key -out certificate.crt
```

### 4.4 计算文件的MD5哈希值
```bash
openssl dgst -md5 file.txt
```

### 4.5 加密文件
```bash
openssl enc -aes-256-cbc -salt -in plaintext.txt -out encrypted.txt
```

### 4.6 解密文件
```bash
openssl enc -d -aes-256-cbc -in encrypted.txt -out decrypted.txt
```

## 5. 注意事项
- openssl 命令功能强大，参数众多，需要根据具体需求选择合适的命令和选项
- 生成的私钥文件需要妥善保管，避免泄露
- 自签名证书在生产环境中可能不被信任，需要使用受信任的证书颁发机构