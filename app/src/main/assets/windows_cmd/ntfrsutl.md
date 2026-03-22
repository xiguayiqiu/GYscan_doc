# ntfrsutl 命令

## 命令说明
NT文件复制服务工具

## 语法
```
ntfrsutl [选项]
```

## 功能
管理和诊断NT文件复制服务（NtFrs）。

## 选项
- `dsa`：显示目录服务代理信息
- `ds`：显示目录服务信息
- `inlog`：显示入站日志
- `outlog`：显示出站日志
- `version`：显示版本信息

## 示例
```
ntfrsutl dsa
ntfrsutl inlog
ntfrsutl version
```

## 注意事项
- 用于管理和诊断NT文件复制服务
- 可以显示服务状态、日志信息等
- 在现代Windows系统中已被DFS复制服务替代