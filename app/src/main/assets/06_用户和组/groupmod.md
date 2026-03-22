# groupmod - 修改组

## 1. 命令简介
groupmod 命令用于修改组属性，是 Linux 系统中常用的用户和组管理命令之一。

## 2. 命令语法
```bash
groupmod [选项] [组名]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -g | 修改组ID |
| -n | 修改组名 |
| --help | 显示帮助信息 |
| --version | 显示版本信息 |

## 4. 实战示例

### 4.1 修改组ID
```bash
groupmod -g 1001 groupname
```

### 4.2 修改组名
```bash
groupmod -n newgroupname oldgroupname
```

## 5. 注意事项
- groupmod 命令用于修改组属性
- groupmod 命令需要 root 权限
- groupmod 命令是一个常用的系统管理工具，用于组管理