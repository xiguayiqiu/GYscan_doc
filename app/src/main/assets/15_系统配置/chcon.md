# chcon - 修改文件安全上下文

## 1. 命令简介
chcon 命令用于修改文件的安全上下文，是 Linux 系统中常用的系统配置命令之一。

## 2. 命令语法
```bash
chcon [选项] [安全上下文] [文件]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -h | 只修改符号链接的安全上下文 |
| -R | 递归修改目录及其内容的安全上下文 |
| -t | 指定类型 |
| -u | 指定用户 |
| -r | 指定角色 |
| --help | 显示帮助信息 |
| --version | 显示版本信息 |

## 4. 实战示例

### 4.1 修改文件的安全上下文
```bash
chcon system_u:object_r:httpd_sys_content_t:s0 file.txt
```

### 4.2 递归修改目录及其内容的安全上下文
```bash
chcon -R system_u:object_r:httpd_sys_content_t:s0 directory
```

### 4.3 只修改符号链接的安全上下文
```bash
chcon -h system_u:object_r:httpd_sys_content_t:s0 link.txt
```

## 5. 注意事项
- chcon 命令用于修改文件的安全上下文，适用于 SELinux 系统
- 安全上下文包括用户、角色、类型和级别
- 修改安全上下文需要 root 权限
- chcon 命令是一个常用的系统配置工具，用于管理 SELinux 安全上下文