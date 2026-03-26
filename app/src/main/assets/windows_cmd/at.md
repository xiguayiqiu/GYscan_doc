# at命令

## 命令简介

`at`命令是Windows中的一个命令，用于计划在指定时间执行任务。

## 语法

```cmd
at [时间] [/interactive] [/every:日期] [/next:日期] 命令
```

## 选项

| 选项 | 描述 |
|------|------|
| `/interactive` | 允许任务与用户桌面交互 |
| `/every:日期` | 在指定日期（1-31）执行任务 |
| `/next:日期` | 在下次指定日期执行任务 |
| `/delete` | 删除计划任务 |
| `/delete /yes` | 无提示删除所有计划任务 |

## 示例

### 计划任务

```cmd
# 在指定时间执行命令
at 14:30 notepad.exe

# 在指定时间执行批处理文件
at 22:00 c:\scripts\backup.bat

# 允许任务与用户桌面交互
at 10:00 /interactive notepad.exe
```

### 定期执行任务

```cmd
# 每天执行任务
at 00:00 /every:1,2,3,4,5,6,7 c:\scripts\daily.bat

# 每周执行任务
at 00:00 /every:1 c:\scripts\weekly.bat

# 每月执行任务
at 00:00 /every:1 c:\scripts\monthly.bat
```

### 查看和删除任务

```cmd
# 查看计划任务
at

# 删除指定任务
at 1 /delete

# 删除所有任务
at /delete /yes
```

## 高级用法

### 计划复杂任务

```cmd
# 计划多个命令
at 12:00 cmd /c "echo Hello && pause"

# 计划带有参数的命令
at 13:00 c:\scripts\backup.bat /full
```

### 系统启动时执行任务

```cmd
# 系统启动时执行任务
at system startup c:\scripts\startup.bat
```

## 常见问题

### 问题：at命令不可用

**原因**：在较新的Windows版本中，at命令已被schtasks命令取代。

**解决方法**：使用schtasks命令代替at命令。

### 问题：任务未执行

**原因**：可能是任务计划服务未运行，或者权限不足。

**解决方法**：确保任务计划服务已启动，以管理员身份运行命令提示符。

## 命令对比

| 命令 | 功能 | 特点 |
|------|------|------|
| `at` | 计划任务 | 传统的任务计划命令，已被schtasks取代 |
| `schtasks` | 计划任务 | 更强大的任务计划命令 |
| `taskschd.msc` | 任务计划程序 | 图形界面的任务计划工具 |

## 注意事项

1. **命令可用性**：在较新的Windows版本中，`at`命令已被`schtasks`命令取代。

2. **权限要求**：使用`at`命令需要管理员权限。

3. **任务计划服务**：`at`命令依赖于任务计划服务（Task Scheduler）。

4. **适用场景**：`at`命令适用于计划在指定时间执行任务的场景，但在较新的Windows版本中建议使用`schtasks`命令。