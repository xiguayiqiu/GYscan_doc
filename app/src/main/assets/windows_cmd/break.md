# break 命令

## 命令说明
中断

## 语法
```
break [on | off]
```

## 功能
启用或禁用扩展 CTRL+C 检查。

## 选项
- `on`：启用扩展 CTRL+C 检查
- `off`：禁用扩展 CTRL+C 检查

## 示例
```
# 启用扩展 CTRL+C 检查

break on

# 禁用扩展 CTRL+C 检查

break off
```

## 注意事项
- 用于启用或禁用扩展 CTRL+C 检查
- 当启用时，批处理文件中的 CTRL+C 会被检查
- 适用于批处理脚本的控制和调试