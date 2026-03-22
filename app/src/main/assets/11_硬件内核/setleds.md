# setleds - 设置LED

## 1. 命令简介
setleds 命令用于设置终端LED指示灯，是 Linux 系统中常用的硬件内核命令之一。

## 2. 命令语法
```bash
setleds [选项]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -D | 关闭所有LED |
| -L | 关闭锁定LED |
| -C | 关闭大写锁定LED |
| -S | 关闭滚动锁定LED |
| +L | 打开锁定LED |
| +C | 打开大写锁定LED |
| +S | 打开滚动锁定LED |
| --help | 显示帮助信息 |
| --version | 显示版本信息 |

## 4. 实战示例

### 4.1 关闭所有LED
```bash
setleds -D
```

### 4.2 打开大写锁定LED
```bash
setleds +C
```

### 4.3 打开滚动锁定LED
```bash
setleds +S
```

## 5. 注意事项
- setleds 命令用于设置终端LED指示灯，如大写锁定、滚动锁定等
- setleds 命令是一个常用的终端工具，用于控制LED指示灯