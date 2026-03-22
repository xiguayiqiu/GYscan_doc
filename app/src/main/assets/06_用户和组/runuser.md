# runuser - 以另一个用户身份运行命令

## 1. 命令简介
runuser 命令用于以另一个用户身份运行命令，是 Linux 系统中常用的用户和组管理命令之一。

## 2. 命令语法
```bash
runuser [选项] [用户名] [命令]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -l | 登录shell |
| -c | 执行命令 |
| --help | 显示帮助信息 |
| --version | 显示版本信息 |

## 4. 实战示例

### 4.1 以另一个用户身份运行命令
```bash
runuser -l username -c "command"
```

### 4.2 执行命令
```bash
runuser username -c "command"
```

## 5. 注意事项
- runuser 命令用于以另一个用户身份运行命令
- runuser 命令需要 root 权限
- runuser 命令是一个常用的系统管理工具，用于用户切换