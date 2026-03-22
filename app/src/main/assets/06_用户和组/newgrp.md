# newgrp - 切换有效组

## 1. 命令简介
newgrp 命令用于切换有效组，是 Linux 系统中常用的用户和组管理命令之一。

## 2. 命令语法
```bash
newgrp [选项] [组名]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| - | 登录shell |
| --help | 显示帮助信息 |
| --version | 显示版本信息 |

## 4. 实战示例

### 4.1 切换有效组
```bash
newgrp groupname
```

### 4.2 登录shell
```bash
newgrp -
```

## 5. 注意事项
- newgrp 命令用于切换有效组，临时改变用户的主要组
- newgrp 命令会启动一个新的shell
- newgrp 命令是一个常用的系统管理工具，用于组管理