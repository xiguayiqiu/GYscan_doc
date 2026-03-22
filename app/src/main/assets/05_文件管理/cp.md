# cp - 复制文件

## 1. 命令简介
cp 命令用于复制文件，是 Linux 系统中常用的文件管理命令之一。

## 2. 命令语法
```bash
cp [选项] [源文件] [目标文件]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -f | 强制复制 |
| -i | 交互式复制 |
| -r | 递归复制 |
| -v | 显示复制过程 |
| -p | 保留文件属性 |
| --help | 显示帮助信息 |
| --version | 显示版本信息 |

## 4. 实战示例

### 4.1 复制文件
```bash
cp file.txt newfile.txt
```

### 4.2 复制目录
```bash
cp -r directory/ newdirectory/
```

### 4.3 保留文件属性
```bash
cp -p file.txt newfile.txt
```

### 4.4 交互式复制
```bash
cp -i file.txt newfile.txt
```

## 5. 注意事项
- cp 命令用于复制文件或目录
- cp 命令的 -r 选项用于复制目录及其内容
- cp 命令是一个常用的文件管理工具，用于复制文件和目录