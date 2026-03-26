# portage 命令

## 命令说明

`portage` 是 Gentoo Linux 的包管理系统，是 `emerge` 命令的底层实现。

## 语法

```bash
portage [选项] [命令]
```

## 常用命令

| 命令 | 描述 |
|------|------|
| `emerge` | 安装、更新、删除软件包 |
| `eix` | 快速搜索软件包 |
| `equery` | 查询软件包信息 |
| `euse` | 管理 USE 标志 |
| `etc-update` | 更新配置文件 |
| `dispatch-conf` | 管理配置文件更新 |

## 示例

### 搜索软件包

```bash
eix firefox
```

### 查询软件包信息

```bash
equery info firefox
```

### 查看软件包依赖

```bash
equery depends firefox
```

### 管理 USE 标志

```bash
euse -a mysql
```

### 更新配置文件

```bash
etc-update
```

## 注意事项

- `portage` 是 Gentoo Linux 的核心包管理系统
- `emerge` 命令是 portage 系统的主要接口
- portage 使用 `/etc/portage/` 目录来存储配置文件
- USE 标志是 portage 系统的一个重要特性，允许用户自定义软件包的功能
- portage 系统通过编译源代码来安装软件，提供了高度的定制性