# rpcping 命令

## 命令说明
RPC Ping

## 语法
```
rpcping [选项]
```

## 功能
测试RPC（远程过程调用）连接。

## 选项
- `-s`：指定服务器
- `-e`：指定端点
- `-t`：指定传输协议
- `-u`：指定用户

## 示例
```
rpcping -s server1
rpcping -s server1 -e 135
rpcping -s server1 -t ncacn_ip_tcp
```

## 注意事项
- 用于测试RPC连接
- 可以诊断RPC相关问题
- 适用于网络故障排除
- 可以验证RPC服务是否正常运行