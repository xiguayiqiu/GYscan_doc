# pubprn 命令

## 命令说明
发布打印机

## 语法
```
pubprn [选项]
```

## 功能
发布打印机到Active Directory。

## 选项
- `-p`：指定打印机名称
- `-s`：指定服务器名称
- `-u`：指定用户名
- `-w`：指定密码

## 示例
```
pubprn -p "HP LaserJet" -s server
pubprn -p "Canon Printer" -s server -u admin -w password
```

## 注意事项
- 用于将打印机发布到Active Directory
- 发布后，用户可以在Active Directory中找到并连接到打印机
- 需要适当的权限才能发布打印机
- 适用于域环境中的打印机管理