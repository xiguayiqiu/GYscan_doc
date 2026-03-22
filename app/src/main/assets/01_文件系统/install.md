# install - 安装文件

## 1. 命令简介
install 命令用于安装文件，是 Linux 系统中常用的文件系统命令之一。

## 2. 命令语法
```bash
install [选项] [源文件] [目标文件]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -d | 创建目录 |
| -m | 设置文件权限 |
| -o | 设置文件所有者 |
| -g | 设置文件所属组 |
| -t | 指定目标目录 |
| --help | 显示帮助信息 |
| --version | 显示版本信息 |

## 4. 实战示例

### 4.1 安装文件
```bash
install file.txt /path/to/destination
```

### 4.2 设置文件权限
```bash
install -m 755 file.txt /path/to/destination
```

### 4.3 创建目录
```bash
install -d /path/to/directory
```

### 4.4 安装多个文件到指定目录
```bash
install -t /path/to/directory file1.txt file2.txt
```

## 5. 注意事项
- install 命令用于安装文件，与 cp 命令类似，但提供了更多的选项
- install 命令可以设置文件权限、所有者和所属组
- install 命令可以创建目录
- install 命令是一个常用的文件安装工具