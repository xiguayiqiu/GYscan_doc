# groupadd - 创建组

## 1. 命令简介
groupadd 命令用于创建组，是 Linux 系统中常用的用户管理命令之一。

## 2. 命令语法
```bash
groupadd [选项] [组名]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -g | 指定组ID |
| -r | 创建系统组 |
| -f | 强制创建组，即使组ID已存在 |

## 4. 实战示例

### 4.1 创建组
```bash
sudo groupadd group1
```

### 4.2 创建组并指定组ID
```bash
sudo groupadd -g 1001 group1
```

### 4.3 创建系统组
```bash
sudo groupadd -r group1
```

### 4.4 强制创建组
```bash
sudo groupadd -f group1
```

## 5. 注意事项
- groupadd 命令需要 root 权限，使用 sudo 执行
- 使用 -g 选项可以指定组ID，默认为系统自动分配
- 使用 -r 选项可以创建系统组，系统组的ID范围通常小于1000
- 使用 -f 选项可以强制创建组，即使组ID已存在