# msdt 命令

## 命令说明
微软诊断工具

## 语法
```
msdt [选项]
```

## 功能
启动微软支持诊断工具，用于诊断和解决系统问题。

## 选项
- `/id`：指定诊断工具ID
- `/skip`：跳过收集数据的步骤
- `/param`：传递参数给诊断工具

## 示例
```
msdt /id WindowsUpdateDiagnostic
msdt /id NetworkDiagnostic
msdt /id SystemMaintenanceDiagnostic
```

## 注意事项
- 用于启动各种系统诊断工具
- 可以诊断网络、Windows Update、系统维护等问题
- 生成的诊断报告可用于故障排除