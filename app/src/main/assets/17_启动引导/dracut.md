# dracut - 创建initramfs

## 1. 命令简介
dracut 命令用于创建 initramfs，是 Linux 系统中常用的启动引导命令之一。

## 2. 命令语法
```bash
dracut [选项] [initramfs文件] [内核版本]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -f | 强制覆盖 |
| -v | 显示详细信息 |
| -l | 列出包含的模块 |
| -m | 指定包含的模块 |
| -o | 指定排除的模块 |
| --help | 显示帮助信息 |
| --version | 显示版本信息 |

## 4. 实战示例

### 4.1 创建initramfs
```bash
dracut
```

### 4.2 强制覆盖
```bash
dracut -f
```

### 4.3 显示详细信息
```bash
dracut -v
```

### 4.4 指定包含的模块
```bash
dracut -m "base,udev"
```

## 5. 注意事项
- dracut 命令用于创建 initramfs，是 Linux 启动过程中的重要组成部分
- dracut 命令可以定制 initramfs 包含的模块
- dracut 命令是一个常用的启动引导工具，用于生成 initramfs