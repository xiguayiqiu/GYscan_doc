# systemd-delta - 显示配置文件差异

## 1. 命令简介
systemd-delta 命令用于显示配置文件差异，是 Linux 系统中常用的系统管理命令之一。

## 2. 命令语法
```bash
systemd-delta [选项] [路径]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -t | 按类型排序 |
| -v | 显示详细信息 |
| -h | 显示帮助信息 |

## 4. 配置文件类型
| 类型 | 说明 |
|------|------|
| unchanged | 未更改的文件 |
| overridden | 被覆盖的文件 |
| extended | 被扩展的文件 |
| masked | 被屏蔽的文件 |
| linked | 被链接的文件 |
| shadowed | 被阴影的文件 |
| missing | 缺失的文件 |

## 5. 实战示例

### 5.1 显示配置文件差异
```bash
systemd-delta
```

### 5.2 按类型排序
```bash
systemd-delta -t
```

### 5.3 显示详细信息
```bash
systemd-delta -v
```

### 5.4 显示指定路径的配置文件差异
```bash
systemd-delta /etc/systemd/system
```

## 6. 注意事项
- systemd-delta 命令是 systemd 系统的一部分，用于显示配置文件差异
- 使用 -t 选项可以按类型排序，使输出更加清晰
- 使用 -v 选项可以显示详细信息，包括文件路径和差异内容