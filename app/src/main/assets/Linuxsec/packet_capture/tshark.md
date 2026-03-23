# tshark 命令

## 命令说明
命令行网络协议分析器，Wireshark的命令行版本。

## 语法
```
tshark [选项] [过滤器]
```

## 常用选项
- `-i`：指定网络接口
- `-w`：将捕获的数据包写入文件
- `-r`：从文件读取数据包
- `-n`：不解析主机名
- `-T`：指定输出格式
- `-Y`：应用显示过滤器

## 示例
```bash
# 捕获所有数据包
tshark -i eth0

# 捕获指定端口的数据包
tshark -i eth0 -f "port 80"

# 捕获并保存到文件
tshark -i eth0 -w capture.pcap

# 从文件读取并分析
tshark -r capture.pcap

# 应用显示过滤器
tshark -r capture.pcap -Y "http.request"
```

## 适用场景
- 命令行环境下的网络分析
- 自动化网络监控
- 脚本集成
- 大规模数据包分析