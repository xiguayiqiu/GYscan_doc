# os-release 信息

## 说明

`os-release` 是一个包含操作系统标识信息的文件，通常位于 `/etc/os-release` 或 `/usr/lib/os-release`。它包含了操作系统的名称、版本、ID等信息。

## 查看方法

### 直接查看文件内容

```bash
cat /etc/os-release
# 输出示例：
# NAME="Ubuntu"
# VERSION="20.04.3 LTS (Focal Fossa)"
# ID=ubuntu
# ID_LIKE=debian
# PRETTY_NAME="Ubuntu 20.04.3 LTS"
# VERSION_ID="20.04"
# HOME_URL="https://www.ubuntu.com/"
# SUPPORT_URL="https://help.ubuntu.com/community/"
# BUG_REPORT_URL="https://bugs.launchpad.net/ubuntu/"
# PRIVACY_POLICY_URL="https://www.ubuntu.com/legal/terms-and-policies/privacy-policy"
# VERSION_CODENAME=focal
# UBUNTU_CODENAME=focal
```

### 使用 lsb_release 命令

在某些系统上，可以使用 `lsb_release` 命令来显示类似信息：

```bash
lsb_release -a
# 输出示例：
# Distributor ID: Ubuntu
# Description:    Ubuntu 20.04.3 LTS
# Release:        20.04
# Codename:       focal
```

## 字段说明

| 字段 | 描述 |
|------|------|
| NAME | 操作系统的名称 |
| VERSION | 操作系统的版本 |
| ID | 操作系统的标识符 |
| ID_LIKE | 操作系统的类型 |
| PRETTY_NAME | 操作系统的友好名称 |
| VERSION_ID | 操作系统的版本标识符 |
| HOME_URL | 操作系统的官方网站 |
| SUPPORT_URL | 操作系统的支持网站 |
| BUG_REPORT_URL | 操作系统的bug报告网站 |
| PRIVACY_POLICY_URL | 操作系统的隐私政策网站 |
| VERSION_CODENAME | 操作系统的版本代号 |
| UBUNTU_CODENAME | Ubuntu特定的版本代号（仅Ubuntu系统） |

## 注意事项

- `os-release` 文件是一个标准的配置文件，用于识别操作系统
- 不同的操作系统可能有不同的字段和值
- 对于脚本编写，可以通过读取此文件来确定系统类型和版本