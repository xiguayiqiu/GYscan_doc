# dd - 复制和转换文件

## 1. 命令简介
dd 命令用于复制和转换文件，是 Linux 系统中常用的磁盘管理命令之一。

## 2. 命令语法
```bash
dd [选项]
```

## 3. 常用选项
| 选项 | 说明 |
|------|------|
| if=FILE | 输入文件 |
| of=FILE | 输出文件 |
| bs=BYTES | 块大小 |
| count=BLOCKS | 复制的块数 |
| skip=BLOCKS | 跳过输入文件的前BLOCKS个块 |
| seek=BLOCKS | 跳过输出文件的前BLOCKS个块 |
| conv=CONVS | 转换模式 |

## 4. 常用转换模式
| 模式 | 说明 |
|------|------|
| ascii | 转换EBCDIC为ASCII |
| ebcdic | 转换ASCII为EBCDIC |
| ibm | 转换ASCII为替代EBCDIC |
| block | 把每一行转换为长度为cbs的记录，不足部分用空格填充 |
| unblock | 把每一行转换为长度为cbs的记录，不足部分用空格填充 |
| lcase | 把大写字符转换为小写字符 |
| ucase | 把小写字符转换为大写字符 |
| swab | 交换输入的每对字节 |
| noerror | 遇到错误时不停止 |
| notrunc | 不截断输出文件 |
| sync | 把每个输入块填充到ibs个字节，不足部分用空字符填充 |

## 5. 实战示例

### 5.1 复制文件
```bash
dd if=input.txt of=output.txt
```

### 5.2 备份MBR
```bash
sudo dd if=/dev/sda of=mbr.bin bs=512 count=1
```

### 5.3 恢复MBR
```bash
sudo dd if=mbr.bin of=/dev/sda bs=512 count=1
```

### 5.4 创建交换文件
```bash
dd if=/dev/zero of=swapfile bs=1M count=1024
sudo mkswap swapfile
sudo swapon swapfile
```

### 5.5 测试磁盘读写速度
```bash
dd if=/dev/zero of=testfile bs=1M count=1024 conv=fdatasync
sudo rm testfile
```

### 5.6 制作启动盘
```bash
sudo dd if=ubuntu.iso of=/dev/sdb bs=4M status=progress
```

## 6. 注意事项
- dd 命令可以用来复制文件、创建备份、测试磁盘性能等
- 使用 dd 命令时要特别小心，因为它可以直接操作磁盘设备，如果参数设置错误，可能会导致数据丢失
- 使用 bs 参数可以设置块大小，较大的块大小可以提高复制速度
- 使用 count 参数可以限制复制的块数，避免复制过多数据