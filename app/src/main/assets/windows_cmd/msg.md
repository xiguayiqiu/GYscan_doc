# msg 命令

## 命令说明
发送消息

## 语法
```
msg [用户名|会话ID|*] [消息]
```

## 功能
向用户或会话发送消息。

## 示例
```
msg user Hello, this is a message
msg * System will restart in 5 minutes
msg 1 Please log off
```

## 注意事项
- 用于向本地或远程用户发送消息
- 使用 `*` 可以向所有用户发送消息
- 可以使用 `quser` 命令查看当前用户和会话ID
- 消息会在用户的桌面上显示