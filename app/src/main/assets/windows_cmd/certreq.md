# certreq 命令

## 命令说明
证书请求

## 语法
```
certreq [options] [requestfile] [cerfile] [pfxfile]
```

## 功能
创建和提交证书请求。

## 选项
- `-new`：创建新的证书请求
- `-submit`：提交证书请求
- `-accept`：接受证书
- `-retrieve`：检索证书
- `-in`：输入文件
- `-out`：输出文件

## 示例
```
# 创建新的证书请求

certreq -new request.inf request.req

# 提交证书请求

certreq -submit request.req certificate.cer

# 接受证书

certreq -accept certificate.cer
```

## 注意事项
- 用于创建和管理证书请求
- 可以提交请求、接受和检索证书
- 适用于企业网络和安全环境
- 需要适当的权限才能使用