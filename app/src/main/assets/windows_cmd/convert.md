# convert 命令

## 命令说明
转换文件系统

## 语法
```
convert [驱动器:] /fs:NTFS [选项]
```

## 功能
将文件系统转换为NTFS格式。

## 选项
- `/fs:NTFS`：指定转换为NTFS文件系统
- `/v`：详细模式
- `/nosecurity`：忽略安全设置
- `/x`：强制卸载卷

## 示例
```
convert C: /fs:NTFS
convert D: /fs:NTFS /v
convert E: /fs:NTFS /x
```

## 注意事项
- 用于将FAT或FAT32文件系统转换为NTFS
- 转换过程不可逆
- 转换前建议备份重要数据
- 适用于需要NTFS特性的场景