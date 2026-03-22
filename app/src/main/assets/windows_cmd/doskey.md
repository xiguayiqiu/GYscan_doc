# doskey 命令

## 命令说明
命令历史

## 语法
```
doskey [选项]
doskey [宏名]=[命令]
```

## 功能
管理命令历史记录和创建命令宏。

## 选项
- `/history`：显示命令历史
- `/listsize=size`：设置历史记录大小
- `/reinstall`：重新安装 Doskey
- `/macrofile=file`：从文件加载宏

## 示例
```
doskey /history
doskey ls=dir /w
doskey /macrofile=C:\macros.txt
```

## 注意事项
- 用于管理命令提示符的历史记录
- 可以创建命令宏来简化常用命令
- 历史记录会在命令提示符会话之间保存