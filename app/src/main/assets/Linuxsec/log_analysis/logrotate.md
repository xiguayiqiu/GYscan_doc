# logrotate 命令

## 命令说明
logrotate是一款用于管理系统日志文件的工具，用于自动旋转、压缩和删除过期的日志文件。它可以帮助系统管理员避免日志文件过大，节省磁盘空间，是系统维护的重要工具。

## 语法
```
logrotate [选项] [配置文件]
```

## 常用选项
- `-f`：强制旋转日志文件
- `-v`：详细模式
- `-d`：调试模式，不实际执行操作
- `-s <状态文件>`：指定状态文件
- `-l <日志文件>`：指定日志文件
- `--help`：显示帮助信息
- `--version`：显示版本信息

## 配置文件

logrotate的配置文件通常位于以下位置：
- `/etc/logrotate.conf`：主配置文件
- `/etc/logrotate.d/`：配置文件目录

### 配置文件语法

```
/path/to/logfile {
    daily              # 每天旋转
    weekly             # 每周旋转
    monthly            # 每月旋转
    rotate 5           # 保留5个旧日志文件
    compress           # 压缩旧日志文件
    delaycompress      # 延迟压缩
    missingok          # 日志文件不存在时不报错
    notifempty         # 日志文件为空时不旋转
    create 644 root root  # 创建新日志文件的权限和所有者
    postrotate         # 旋转后执行的命令
        command
    endscript
}
```

## 示例

### 基本配置
```bash
# 编辑主配置文件
vi /etc/logrotate.conf

# 编辑特定服务的配置文件
vi /etc/logrotate.d/nginx
```

### 常用配置示例

#### Nginx日志配置
```
/var/log/nginx/*.log {
    daily
    missingok
    rotate 52
    compress
    delaycompress
    notifempty
    create 0640 www-data www-data
    postrotate
        if [ -f /var/run/nginx.pid ]; then
            kill -USR1 `cat /var/run/nginx.pid`
        fi
    endscript
}
```

#### Apache日志配置
```
/var/log/apache2/*.log {
    weekly
    missingok
    rotate 4
    compress
    delaycompress
    notifempty
    create 640 www-data www-data
    postrotate
        if [ -f /var/run/apache2.pid ]; then
            /etc/init.d/apache2 reload > /dev/null
        fi
    endscript
}
```

#### 系统日志配置
```
/var/log/syslog {
    daily
    missingok
    rotate 7
    compress
    delaycompress
    notifempty
    postrotate
        invoke-rc.d rsyslog rotate > /dev/null
    endscript
}
```

### 命令行操作
```bash
# 强制旋转所有日志
logrotate -f /etc/logrotate.conf

# 详细模式旋转日志
logrotate -v /etc/logrotate.conf

# 调试模式
logrotate -d /etc/logrotate.conf

# 旋转特定配置
logrotate -f /etc/logrotate.d/nginx
```

## 适用场景

### 系统维护
- 管理系统日志文件
- 避免日志文件过大
- 节省磁盘空间
- 保持日志文件的可管理性

### 日志管理
- 定期备份日志文件
- 压缩旧日志文件
- 删除过期日志文件
- 确保日志文件的连续性

### 安全审计
- 保持完整的日志记录
- 防止日志文件被篡改
- 确保日志文件的安全性
- 便于日志分析和审计

### 性能优化
- 减少日志文件的大小
- 提高日志文件的读写性能
- 优化磁盘空间使用
- 减少系统资源占用

### 故障排查
- 保持日志文件的可访问性
- 便于查找历史日志
- 确保日志文件的完整性
- 便于分析系统问题

## 高级技巧

### 自定义配置
```bash
# 创建自定义logrotate配置
cat > /etc/logrotate.d/myapp << 'EOF'
/var/log/myapp/*.log {
    daily
    missingok
    rotate 30
    compress
    delaycompress
    notifempty
    create 0644 myapp myapp
    postrotate
        if [ -f /var/run/myapp.pid ]; then
            kill -USR1 `cat /var/run/myapp.pid`
        fi
    endscript
}
EOF
```

### 批量管理
```bash
# 为多个服务创建logrotate配置
for service in nginx apache2 mysql postgresql; do
    cat > /etc/logrotate.d/$service << EOF
/var/log/$service/*.log {
    daily
    missingok
    rotate 7
    compress
    delaycompress
    notifempty
    create 0644 $service $service
    postrotate
        if [ -f /var/run/$service.pid ]; then
            kill -USR1 `cat /var/run/$service.pid`
        fi
    endscript
}
EOF
done
```

### 自动化管理
```bash
# 创建logrotate cron任务
cat > /etc/cron.daily/logrotate << 'EOF'
#!/bin/sh

/usr/sbin/logrotate /etc/logrotate.conf
EXITVALUE=$?
if [ $EXITVALUE != 0 ]; then
    /usr/bin/logger -t logrotate "ALERT: logrotate exited with error $EXITVALUE"
fi
exit $EXITVALUE
EOF

# 使脚本可执行
chmod +x /etc/cron.daily/logrotate
```

### 性能优化
- 对于大日志文件，使用 `delaycompress` 选项减少I/O操作
- 对于频繁旋转的日志，使用 `notifempty` 选项避免空文件旋转
- 对于重要的日志，设置合理的 `rotate` 值确保足够的历史记录
- 对于存储空间有限的系统，使用 `compress` 选项节省磁盘空间

### 安全注意事项
- 确保日志文件的权限设置正确，防止未授权访问
- 定期检查logrotate的运行状态，确保日志正常旋转
- 注意日志文件的备份，防止日志丢失
- 遵守相关法律法规，确保日志的合规性

## 常见问题解决

- **问题**：日志文件没有被旋转
  **解决方法**：检查logrotate配置文件，确保配置正确，运行 `logrotate -f` 强制旋转

- **问题**：日志文件旋转后服务没有重新打开日志
  **解决方法**：检查 `postrotate` 脚本，确保正确发送信号给服务

- **问题**：旋转后的日志文件没有被压缩
  **解决方法**：检查配置文件中是否包含 `compress` 选项，确保gzip已安装

- **问题**：日志文件占用空间过大
  **解决方法**：调整 `rotate` 值，减少保留的旧日志文件数量，使用 `compress` 选项

## 总结
logrotate是一款功能强大的日志管理工具，提供了丰富的选项和配置，适用于各种系统日志管理场景。通过掌握logrotate的使用方法，系统管理员可以更有效地管理日志文件、节省磁盘空间、保持日志的可管理性和确保系统的正常运行。

logrotate的优势在于：
- 灵活的配置选项
- 自动化的日志管理
- 支持压缩和删除过期日志
- 与系统服务的良好集成
- 轻量级设计

作为日志管理的重要工具，logrotate是每个系统管理员必备的工具之一。