# dispdiag 命令

## 命令说明
显示诊断

## 语法
```
dispdiag [选项]
```

## 功能
收集显示相关的诊断信息。

## 选项
- `/d`：指定诊断信息的保存位置
- `/l`：显示详细信息

## 示例
```
dispdiag
dispdiag /d C:\diagnostics\display.log
dispdiag /l
```

## 注意事项
- 用于收集显示适配器和显示器的诊断信息
- 生成的日志文件可用于故障排除
- 支持多种显示相关的诊断功能