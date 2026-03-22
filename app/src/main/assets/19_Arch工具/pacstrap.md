# pacstrap - 安装基本系统

## 1. 命令简介
pacstrap 命令用于安装基本系统，是 Linux 系统中常用的 Arch 工具命令之一。

## 2. 命令语法
```bash
pacstrap [选项] [挂载点] [软件包]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -i | 交互式模式 |
| -c | 使用缓存 |
| -d | 跳过依赖检查 |
| -G | 不安装基本组 |
| -M | 不创建主目录 |
| --help | 显示帮助信息 |
| --version | 显示版本信息 |

## 4. 实战示例

### 4.1 安装基本系统
```bash
pacstrap /mnt base base-devel
```

### 4.2 交互式模式
```bash
pacstrap -i /mnt base base-devel
```

### 4.3 使用缓存
```bash
pacstrap -c /mnt base base-devel
```

## 5. 注意事项
- pacstrap 命令用于在新挂载的文件系统上安装基本系统
- pacstrap 命令是 Arch Linux 安装过程中的重要工具
- pacstrap 命令需要 root 权限