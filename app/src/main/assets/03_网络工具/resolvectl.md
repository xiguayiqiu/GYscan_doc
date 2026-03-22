# resolvectl - 解析器控制

## 1. 命令简介
resolvectl 命令用于解析器控制，是 Linux 系统中常用的网络工具命令之一。

## 2. 命令语法
```bash
resolvectl [选项] [命令]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -h | 显示帮助信息 |
| --help | 显示帮助信息 |
| --version | 显示版本信息 |

## 4. 常用命令
| 命令 | 说明 |
|------|------|
| status | 显示当前状态 |
| query | 查询DNS记录 |
| flush-caches | 刷新缓存 |
| statistics | 显示统计信息 |
| reset-server-features | 重置服务器功能 |

## 5. 实战示例

### 5.1 显示当前状态
```bash
resolvectl status
```

### 5.2 查询DNS记录
```bash
resolvectl query google.com
```

### 5.3 刷新缓存
```bash
resolvectl flush-caches
```

### 5.4 显示统计信息
```bash
resolvectl statistics
```

## 6. 注意事项
- resolvectl 命令用于解析器控制，管理DNS解析
- resolvectl 命令是 systemd 系统的一部分
- resolvectl 命令是一个常用的网络工具，用于管理DNS解析