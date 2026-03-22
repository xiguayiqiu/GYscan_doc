# cryptsetup - 加密设置

## 1. 命令简介
cryptsetup 命令用于加密设置，是 Linux 系统中常用的安全加密命令之一。

## 2. 命令语法
```bash
cryptsetup [选项] [命令]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| -v | 显示详细信息 |
| --help | 显示帮助信息 |
| --version | 显示版本信息 |

## 4. 常用命令
| 命令 | 说明 |
|------|------|
| luksFormat | 格式化LUKS设备 |
| open | 打开LUKS设备 |
| close | 关闭LUKS设备 |
| luksAddKey | 添加密钥 |
| luksRemoveKey | 移除密钥 |
| luksChangeKey | 修改密钥 |

## 5. 实战示例

### 5.1 格式化LUKS设备
```bash
cryptsetup luksFormat /dev/sda1
```

### 5.2 打开LUKS设备
```bash
cryptsetup open /dev/sda1 encrypted
```

### 5.3 关闭LUKS设备
```bash
cryptsetup close encrypted
```

### 5.4 添加密钥
```bash
cryptsetup luksAddKey /dev/sda1
```

## 6. 注意事项
- cryptsetup 命令用于加密设置，支持 LUKS (Linux Unified Key Setup) 加密
- cryptsetup 命令需要 root 权限
- cryptsetup 命令是一个常用的安全工具，用于加密存储设备