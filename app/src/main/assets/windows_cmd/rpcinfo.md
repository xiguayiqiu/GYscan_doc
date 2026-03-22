# rpcinfo 命令

## 命令说明
RPC信息

## 语法
```
rpcinfo [选项]
```

## 功能
显示RPC（远程过程调用）信息。

## 选项
- `-p`：显示所有RPC服务
- `-t`：显示指定传输协议的RPC服务
- `-u`：显示指定主机的RPC服务

## 示例
```
rpcinfo -p
rpcinfo -p localhost
rpcinfo -t tcp localhost 100000
```

## 注意事项
- 用于显示RPC服务信息
- 可以查看系统上运行的RPC服务
- 适用于网络故障排除
- 可以帮助诊断RPC相关问题