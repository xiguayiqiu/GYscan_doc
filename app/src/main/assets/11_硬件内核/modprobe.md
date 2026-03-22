# modprobe - 加载或卸载模块

## 1. 命令简介
modprobe 命令用于加载或卸载内核模块，是 Linux 系统中常用的硬件内核命令之一。

## 2. 命令语法
```bash
modprobe [选项] [模块]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -r | 卸载模块 |
| -v | 显示详细信息 |
| -a | 加载多个模块 |
| -c | 显示配置 |
| -d | 指定模块目录 |
| --help | 显示帮助信息 |
| --version | 显示版本信息 |

## 4. 实战示例

### 4.1 加载模块
```bash
modprobe i915
```

### 4.2 卸载模块
```bash
modprobe -r i915
```

### 4.3 显示详细信息
```bash
modprobe -v i915
```

### 4.4 加载多个模块
```bash
modprobe -a i915 snd_hda_intel
```

## 5. 注意事项
- modprobe 命令用于加载或卸载内核模块
- modprobe 命令会自动处理模块的依赖关系
- modprobe 命令需要 root 权限
- modprobe 命令是一个常用的系统管理工具，用于管理内核模块