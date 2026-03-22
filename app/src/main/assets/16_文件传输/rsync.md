# rsync - 远程同步工具

## 1. 命令简介
rsync 命令用于远程同步文件和目录，是 Linux 系统中最常用的文件传输工具之一。

## 2. 命令语法
```bash
rsync [选项] 源 目标
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -a | 归档模式，保留文件的所有属性 |
| -v | 详细模式，显示同步的文件 |
| -z | 启用压缩 |
| -h | 以人类可读的格式显示 |
| -r | 递归同步目录 |
| -u | 仅同步源文件比目标文件新的文件 |
| -delete | 删除目标目录中不存在于源目录的文件 |
| -e | 指定远程shell |

## 4. 实战示例

### 4.1 同步本地目录
```bash
rsync -av /source/directory/ /destination/directory/
```

### 4.2 同步到远程服务器
```bash
rsync -av /source/directory/ user@remote:/destination/directory/
```

### 4.3 从远程服务器同步
```bash
rsync -av user@remote:/source/directory/ /destination/directory/
```

### 4.4 启用压缩
```bash
rsync -avz /source/directory/ user@remote:/destination/directory/
```

### 4.5 删除目标目录中不存在的文件
```bash
rsync -av --delete /source/directory/ /destination/directory/
```

### 4.6 指定端口号
```bash
rsync -av -e "ssh -p 2222" /source/directory/ user@remote:/destination/directory/
```

## 5. 注意事项
- rsync 命令基于 SSH 协议，需要远程服务器运行 SSH 服务
- 使用 -a 选项可以保留文件的所有属性，相当于 -rlptgoD
- rsync 只同步文件的差异部分，传输效率很高