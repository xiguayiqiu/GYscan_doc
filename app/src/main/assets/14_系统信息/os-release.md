# os-release - 显示操作系统信息

## 1. 命令简介
os-release 命令用于显示操作系统信息，是 Linux 系统中常用的系统信息命令之一。

## 2. 命令语法
```bash
cat /etc/os-release
```

## 3. 实战示例

### 3.1 显示操作系统信息
```bash
cat /etc/os-release
```

## 4. 退出状态
- 0：命令执行成功
- 非0：命令执行失败

## 5. 注意事项
- os-release 命令实际上是通过读取 /etc/os-release 文件来显示操作系统信息
- /etc/os-release 文件包含了操作系统的名称、版本、ID等信息
- os-release 命令是一个常用的系统信息工具，用于获取操作系统信息