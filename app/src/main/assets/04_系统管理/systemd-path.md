# systemd-path - 查询系统路径

## 1. 命令简介
systemd-path 命令用于查询系统路径，是 Linux 系统中常用的系统管理命令之一。

## 2. 命令语法
```bash
systemd-path [选项] [路径类型]
```

## 3. 常用路径类型
| 路径类型 | 说明 |
|---------|------|
| user-binaries | 用户二进制文件目录 |
| system-binaries | 系统二进制文件目录 |
| user-config | 用户配置目录 |
| system-config | 系统配置目录 |
| user-data | 用户数据目录 |
| system-data | 系统数据目录 |
| user-runtime | 用户运行时目录 |
| system-runtime | 系统运行时目录 |
| user-tmp | 用户临时目录 |
| system-tmp | 系统临时目录 |

## 4. 实战示例

### 4.1 查询用户二进制文件目录
```bash
systemd-path user-binaries
```

### 4.2 查询系统配置目录
```bash
systemd-path system-config
```

### 4.3 查询用户数据目录
```bash
systemd-path user-data
```

### 4.4 查询系统运行时目录
```bash
systemd-path system-runtime
```

## 5. 注意事项
- systemd-path 命令是 systemd 系统的一部分，用于查询系统路径
- 使用不同的路径类型参数可以查询不同类型的系统路径
- 命令会输出指定类型的路径，这些路径通常是符合 XDG 规范的