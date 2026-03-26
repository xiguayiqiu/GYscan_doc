# findfs 命令

## 命令说明

`findfs` 是 Linux 系统中用于根据标签或 UUID 查找文件系统的命令。

## 语法

```bash
findfs LABEL=标签
findfs UUID=uuid
```

## 示例

### 根据标签查找文件系统

```bash
findfs LABEL=root
```

### 根据 UUID 查找文件系统

```bash
findfs UUID=12345678-1234-1234-1234-1234567890ab
```

## 注意事项

- `findfs` 命令需要 root 权限
- 可以使用 `blkid` 命令获取文件系统的标签和 UUID
- `findfs` 命令返回文件系统的设备路径
- 常用于脚本中根据标签或 UUID 查找设备