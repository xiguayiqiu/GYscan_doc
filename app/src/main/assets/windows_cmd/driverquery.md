# driverquery命令

## 命令简介

`driverquery`命令是Windows中的一个命令，用于查询系统中安装的驱动程序。

## 语法

```cmd
driverquery [选项]
```

## 选项

| 选项 | 描述 |
|------|------|
| `/s <计算机>` | 指定远程计算机 |
| `/u <用户>` | 指定用户 |
| `/p <密码>` | 指定密码 |
| `/fo <格式>` | 指定输出格式（TABLE、LIST、CSV） |
| `/nh` | 不显示列标题 |
| `/si` | 显示签名信息 |
| `/v` | 显示详细信息 |

## 示例

### 查询驱动程序

```cmd
# 查询所有驱动程序
driverquery

# 查询驱动程序并显示签名信息
driverquery /si

# 查询驱动程序并显示详细信息
driverquery /v
```

### 指定输出格式

```cmd
# 以列表格式显示驱动程序
driverquery /fo LIST

# 以CSV格式显示驱动程序
driverquery /fo CSV

# 以表格格式显示驱动程序（默认）
driverquery /fo TABLE
```

### 查询远程计算机的驱动程序

```cmd
# 查询远程计算机的驱动程序
driverquery /s remotecomputer

# 使用指定用户查询远程计算机的驱动程序
driverquery /s remotecomputer /u username /p password
```

## 高级用法

### 导出驱动程序列表

```cmd
# 导出驱动程序列表到CSV文件
driverquery /fo CSV /nh > drivers.csv

# 导出驱动程序列表到文本文件
driverquery /fo LIST > drivers.txt
```

## 常见问题

### 问题：driverquery命令执行失败

**原因**：可能是权限不足，或者远程计算机不可用。

**解决方法**：以管理员身份运行命令提示符，确保远程计算机可用。

### 问题：输出信息过多

**原因**：可能是系统中安装了大量驱动程序。

**解决方法**：使用适当的输出格式，或者将输出重定向到文件。

## 命令对比

| 命令 | 功能 | 特点 |
|------|------|------|
| `driverquery` | 查询驱动程序 | 用于查询系统中安装的驱动程序 |
| `devcon` | 设备控制台 | 用于管理设备和驱动程序 |
| `pnputil` | 即插即用工具 | 用于管理驱动程序包 |

## 注意事项

1. **权限要求**：使用`driverquery`命令需要管理员权限。

2. **远程查询**：可以使用`/s`选项查询远程计算机的驱动程序。

3. **输出格式**：可以使用`/fo`选项指定不同的输出格式。

4. **适用场景**：`driverquery`命令适用于查询系统中安装的驱动程序的场景。