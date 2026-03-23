# wireshark 命令

## 命令说明
图形化网络协议分析器，用于捕获和分析网络数据包。

## 语法
```
wireshark [选项]
```

## 常用选项
- `-i`：指定网络接口
- `-k`：启动后立即开始捕获
- `-r`：打开捕获文件
- `-w`：将捕获的数据包写入文件

## 示例
```bash
# 启动Wireshark
wireshark

# 指定接口并立即开始捕获
wireshark -i eth0 -k

# 打开捕获文件
wireshark -r capture.pcap

# 捕获并保存到文件
wireshark -i eth0 -w capture.pcap
```

## 适用场景
- 网络故障排查
- 网络安全分析
- 协议分析
- 流量监控
- 应用程序调试