# false - 返回假

## 1. 命令简介
false 命令用于返回假，是 Linux 系统中常用的 shell 环境命令之一。

## 2. 命令语法
```bash
false
```

## 3. 实战示例

### 3.1 返回假
```bash
false
```

### 3.2 在条件中使用
```bash
if false; then
  echo "Command succeeded"
else
  echo "Command failed"
fi
```

## 4. 退出状态
- 1：命令执行失败（返回假）

## 5. 注意事项
- false 命令用于返回假，退出状态为1
- false 命令在 shell 脚本中常用于条件测试或占位符
- false 命令是一个常用的 shell 工具，用于返回失败状态