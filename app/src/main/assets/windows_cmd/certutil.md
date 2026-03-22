# certutil 命令

## 命令说明
证书工具

## 语法
```
certutil [options] [command]
```

## 功能
管理证书和证书存储。

## 选项
- `-dump`：转储证书信息
- `-addstore`：添加证书到存储
- `-delstore`：从存储中删除证书
- `-verifystore`：验证存储中的证书
- `-importpfx`：导入 PFX 文件
- `-exportpfx`：导出 PFX 文件
- `-repairstore`：修复存储中的证书

## 示例
```
# 转储证书信息

certutil -dump certificate.cer

# 添加证书到存储

certutil -addstore my certificate.cer

# 从存储中删除证书

certutil -delstore my certificate.cer
```

## 注意事项
- 用于管理证书和证书存储
- 可以添加、删除、验证和修复证书
- 支持导入和导出 PFX 文件
- 适用于企业网络和安全环境
- 需要适当的权限才能使用