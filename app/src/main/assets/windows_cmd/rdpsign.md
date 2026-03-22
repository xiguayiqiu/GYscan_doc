# rdpsign 命令

## 命令说明
RDP签名

## 语法
```
rdpsign [options] <file>
```

## 功能
签名远程桌面协议（RDP）文件。

## 选项
- `/sha1 <hash>`：指定证书的 SHA1 哈希
- `/q`：安静模式
- `/v`：详细模式
- `/l`：列出证书

## 示例
```
# 签名 RDP 文件

rdpsign /sha1 <certificate_hash> file.rdp

# 列出可用证书

rdpsign /l

# 安静模式签名

rdpsign /q /sha1 <certificate_hash> file.rdp
```

## 注意事项
- 用于签名远程桌面协议（RDP）文件
- 可以指定证书的 SHA1 哈希
- 支持安静模式和详细模式
- 适用于远程桌面连接的安全管理