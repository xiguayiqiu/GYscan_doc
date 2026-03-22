# groupadd - 创建组

## 1. 命令简介
groupadd 命令用于创建组，是 Linux 系统中常用的用户和组管理命令之一。

## 2. 命令语法
```bash
groupadd [选项] [组名]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -g | 指定组ID |
| -r | 创建系统组 |
| --help | 显示帮助信息 |
| --version | 显示版本信息 |

## 4. 实战示例

### 4.1 创建组
```bash
groupadd groupname
```

### 4.2 创建组并指定组ID
```bash
groupadd -g 1001 groupname
```

### 4.3 创建系统组
```bash
groupadd -r systemgroup
```

## 5. 注意事项
- groupadd 命令用于创建组
- groupadd 命令需要 root 权限
- groupadd 命令是一个常用的系统管理工具，用于组管理