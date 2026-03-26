# schtasks命令

## 命令简介

`schtasks`命令是Windows中的一个命令，用于管理计划任务。

## 语法

```cmd
schtasks [选项] [命令]
```

## 选项

| 选项 | 描述 |
|------|------|
| `/create` | 创建计划任务 |
| `/delete` | 删除计划任务 |
| `/query` | 查询计划任务 |
| `/run` | 运行计划任务 |
| `/end` | 结束计划任务 |
| `/change` | 修改计划任务 |

## 示例

### 管理计划任务

```cmd
# 创建计划任务
schtasks /create /tn "MyTask" /tr "C:\MyTask.exe" /sc daily /st 10:00

# 删除计划任务
schtasks /delete /tn "MyTask"

# 查询计划任务
schtasks /query /tn "MyTask"

# 运行计划任务
schtasks /run /tn "MyTask"

# 结束计划任务
schtasks /end /tn "MyTask"

# 修改计划任务
schtasks /change /tn "MyTask" /st 11:00
```

## 高级用法

### 批量管理计划任务

```cmd
# 创建一个批处理文件
@echo off

# 批量管理计划任务
echo 创建任务1
schtasks /create /tn "Task1" /tr "C:\Task1.exe" /sc daily /st 10:00

echo 创建任务2
schtasks /create /tn "Task2" /tr "C:\Task2.exe" /sc daily /st 11:00

echo 操作完成
```

## 常见问题

### 问题：schtasks命令执行失败

**原因**：可能是权限不足，或者任务不存在。

**解决方法**：以管理员身份运行命令提示符，确保任务存在。

### 问题：任务创建失败

**原因**：可能是路径不正确，或者权限不足。

**解决方法**：确保路径正确，以管理员身份运行命令提示符。

## 命令对比

| 命令 | 功能 | 特点 |
|------|------|------|
| `schtasks` | 管理计划任务 | 用于管理Windows计划任务 |
| `at` | 计划任务 | 用于创建计划任务（已过时） |
| `taskschd.msc` | 任务计划程序 | 图形界面的任务计划程序 |

## 注意事项

1. **权限要求**：使用`schtasks`命令需要管理员权限。

2. **任务名称**：需要指定有效的任务名称。

3. **适用场景**：`schtasks`命令适用于管理Windows计划任务的场景。