# chown - 修改文件所有者

## 1. 命令简介
chown 命令用于修改文件或目录的所有者和所属组，是 Linux 系统中最常用的文件权限管理命令之一。

## 2. 命令语法
```bash
chown [选项] 所有者[:组] 文件
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -R | 递归修改目录及其内容的所有者 |
| -v | 显示修改的所有者 |
| -c | 只显示修改的所有者 |

## 4. 实战示例

### 4.1 修改文件的所有者
```bash
sudo chown user file.txt
```

### 4.2 修改文件的所有者和所属组
```bash
sudo chown user:group file.txt
```

### 4.3 递归修改目录及其内容的所有者
```bash
sudo chown -R user directory
```

### 4.4 只修改文件的所属组
```bash
sudo chown :group file.txt
```

### 4.5 显示修改的所有者
```bash
sudo chown -v user file.txt
```

## 5. 注意事项
- chown 命令需要 root 权限才能修改文件的所有者
- 使用 -R 选项可以递归修改目录及其内容的所有者
- 可以同时修改文件的所有者和所属组，中间用冒号分隔