# runcon 命令

## 命令说明

`runcon` 是 Linux 系统中用于在特定安全上下文中运行命令的命令，主要用于 SELinux 系统。

## 语法

```bash
runcon [选项] 安全上下文 命令 [参数...]
```

## 常用选项

| 选项 | 描述 |
|------|------|
| `-c` | 运行命令后更改为指定的安全上下文 |
| `-u` | 指定用户上下文 |
| `-r` | 指定角色上下文 |
| `-t` | 指定类型上下文 |
| `-l` | 指定级别上下文 |

## 示例

### 在特定安全上下文中运行命令

```bash
runcon user_u:object_r:httpd_sys_script_t:s0 ls -la
```

### 指定类型上下文运行命令

```bash
runcon -t httpd_sys_script_t ls -la
```

### 指定用户和角色上下文运行命令

```bash
runcon -u user_u -r object_r ls -la
```

## 注意事项

- `runcon` 命令用于在特定安全上下文中运行命令
- 安全上下文是 SELinux 系统中的一个重要概念，用于控制进程对文件的访问
- 安全上下文的格式通常为：`用户:角色:类型:级别`
- 只有 root 用户可以使用 `runcon` 命令以不同的安全上下文运行命令
- `runcon` 命令可以帮助测试 SELinux 策略的有效性