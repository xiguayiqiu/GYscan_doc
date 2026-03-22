# msinfo32 命令

## 命令说明
系统信息

## 语法
```
msinfo32 [选项]
```

## 功能
显示系统信息，包括硬件、软件和系统组件的详细信息。

## 选项
- `/computer`：指定远程计算机
- `/nfo`：导出系统信息到NFO文件
- `/report`：导出系统信息到文本文件

## 示例
```
msinfo32
msinfo32 /computer:remotePC
msinfo32 /report C:\systeminfo.txt
```

## 注意事项
- 用于查看系统的详细信息
- 可以导出系统信息到文件
- 可以查看远程计算机的系统信息
- 显示的信息包括硬件、操作系统、软件环境等