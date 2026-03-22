# insmod - 加载模块

## 1. 命令简介
insmod 命令用于加载内核模块，是 Linux 系统中常用的硬件内核命令之一。

## 2. 命令语法
```bash
insmod [选项] [模块文件]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -f | 强制加载 |
| -v | 显示详细信息 |
| --help | 显示帮助信息 |
| --version | 显示版本信息 |

## 4. 实战示例

### 4.1 加载模块
```bash
insmod /lib/modules/$(uname -r)/kernel/drivers/gpu/drm/i915/i915.ko
```

### 4.2 显示详细信息
```bash
insmod -v /lib/modules/$(uname -r)/kernel/drivers/gpu/drm/i915/i915.ko
```

## 5. 注意事项
- insmod 命令用于加载内核模块
- insmod 命令不会自动处理模块的依赖关系
- insmod 命令需要 root 权限
- insmod 命令是一个常用的系统管理工具，用于管理内核模块