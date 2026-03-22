# makepkg - 构建Arch包

## 1. 命令简介
makepkg 命令用于构建 Arch 包，是 Linux 系统中常用的 Arch 工具命令之一。

## 2. 命令语法
```bash
makepkg [选项]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -c | 清理构建文件 |
| -d | 跳过依赖检查 |
| -f | 强制构建 |
| -i | 构建并安装 |
| -s | 安装依赖 |
| -r | 移除构建依赖 |
| --help | 显示帮助信息 |
| --version | 显示版本信息 |

## 4. 实战示例

### 4.1 构建包
```bash
makepkg
```

### 4.2 构建并安装
```bash
makepkg -i
```

### 4.3 安装依赖
```bash
makepkg -s
```

### 4.4 清理构建文件
```bash
makepkg -c
```

## 5. 注意事项
- makepkg 命令用于构建 Arch 包，从 PKGBUILD 文件生成软件包
- makepkg 命令是 Arch Linux 系统中常用的工具
- makepkg 命令需要在包含 PKGBUILD 文件的目录中执行