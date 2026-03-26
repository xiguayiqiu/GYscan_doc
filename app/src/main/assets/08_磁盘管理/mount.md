# mount 命令

## 命令说明

`mount` 是 Linux 系统中用于挂载文件系统的命令，它将设备或远程文件系统挂载到指定的挂载点。

## 语法

```bash
mount [选项] 设备 挂载点
```

## 常用选项

| 选项 | 描述 |
|------|------|
| `-t` | 指定文件系统类型 |
| `-o` | 指定挂载选项 |
| `-r` | 以只读方式挂载 |
| `-w` | 以读写方式挂载 |
| `-a` | 挂载 /etc/fstab 中所有未挂载的文件系统 |
| `-l` | 显示挂载信息，包括标签 |

## 常用挂载选项

| 选项 | 描述 |
|------|------|
| `defaults` | 使用默认选项（rw, suid, dev, exec, auto, nouser, async） |
| `rw` | 读写模式 |
| `ro` | 只读模式 |
| `noexec` | 不允许执行文件 |
| `nodev` | 不允许设备文件 |
| `nosuid` | 不允许 suid 权限 |
| `noatime` | 不更新访问时间 |
| `nodiratime` | 不更新目录访问时间 |
| `sync` | 同步写入 |
| `async` | 异步写入 |

## 示例

### 挂载设备到指定目录

```bash
mount /dev/sda1 /mnt
```

### 以只读方式挂载设备

```bash
mount -r /dev/sda1 /mnt
```

### 指定文件系统类型挂载

```bash
mount -t ext4 /dev/sda1 /mnt
```

### 使用挂载选项

```bash
mount -o noatime,nosuid /dev/sda1 /mnt
```

### 挂载所有 /etc/fstab 中的文件系统

```bash
mount -a
```

## 注意事项

- `mount` 命令需要 root 权限
- 挂载点必须是一个存在的目录
- 挂载前需要确保文件系统没有损坏
- 可以使用 `umount` 命令卸载已挂载的文件系统