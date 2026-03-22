# pacman - Arch Linux包管理器

## 1. 命令简介
pacman 是 Arch Linux 及其衍生发行版的包管理器，用于安装、更新、删除和管理软件包，是 Arch Linux 系统中最核心的工具之一。

## 2. 命令语法
```bash
pacman [选项] 命令 [包名]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -S | 安装软件包 |
| -R | 删除软件包 |
| -Q | 查询已安装的软件包 |
| -U | 安装本地软件包 |
| -Syu | 同步并更新系统 |
| -Ss | 搜索软件包 |
| -Si | 显示软件包信息 |
| -Sc | 清理缓存 |
| -Rns | 删除软件包及其依赖和配置文件 |

## 4. 实战示例

### 4.1 安装软件包
```bash
sudo pacman -S package_name
```

### 4.2 同步并更新系统
```bash
sudo pacman -Syu
```

### 4.3 删除软件包
```bash
sudo pacman -R package_name
```

### 4.4 删除软件包及其依赖和配置文件
```bash
sudo pacman -Rns package_name
```

### 4.5 搜索软件包
```bash
pacman -Ss search_term
```

### 4.6 显示软件包信息
```bash
pacman -Si package_name
```

## 5. 注意事项
- pacman 命令需要 root 权限，使用 sudo 执行
- -Syu 选项会同步所有软件库并更新系统，是最常用的更新命令
- 定期使用 -Sc 选项清理缓存可以节省磁盘空间