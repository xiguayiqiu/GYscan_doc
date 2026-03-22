# true - 返回真

## 1. 命令简介
true 命令用于返回真，是 Linux 系统中常用的 shell 环境命令之一。

## 2. 命令语法
```bash
true
```

## 3. 实战示例

### 3.1 返回真
```bash
true
```

### 3.2 在条件中使用
```bash
if true; then
  echo "Command succeeded"
fi
```

## 4. 退出状态
- 0：命令执行成功（返回真）

## 5. 注意事项
- true 命令用于返回真，退出状态为0
- true 命令在 shell 脚本中常用于条件测试或占位符
- true 命令是一个常用的 shell 工具，用于返回成功状态