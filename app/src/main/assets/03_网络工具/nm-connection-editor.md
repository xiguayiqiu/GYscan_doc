# nm-connection-editor 命令

## 命令说明

`nm-connection-editor` 是 NetworkManager 的图形界面工具，用于创建、编辑和删除网络连接。它提供了一个直观的图形界面，使用户可以方便地配置各种类型的网络连接。

## 语法

```bash
nm-connection-editor [选项]
```

## 常用选项

| 选项 | 描述 |
|------|------|
| `-a` | 直接打开添加新连接的对话框 |
| `-e` | 编辑指定名称的连接 |
| `-s` | 显示系统托盘图标，便于快速访问 |
| `-h` | 显示帮助信息 |
| `--new-connection` | 同 `-a`，打开添加新连接的对话框 |
| `--edit` | 同 `-e`，编辑指定的连接 |
| `--system-tray` | 同 `-s`，显示系统托盘图标 |
| `--version` | 显示版本信息 |

## 支持的连接类型

`nm-connection-editor` 支持创建和管理以下类型的网络连接：

| 连接类型 | 描述 |
|----------|------|
| 以太网 | 有线网络连接 |
| Wi-Fi | 无线网络连接 |
| 移动宽带 | 移动数据网络连接（如4G/5G） |
| VPN | 虚拟私人网络连接 |
| 桥接 | 网络桥接连接 |
| 团队 | 网络团队连接（链路聚合） |
| VLAN | 虚拟局域网连接 |
| 通用设备 | 通用网络设备连接 |
| InfiniBand | InfiniBand网络连接 |

## 操作方法详解

### 1. 打开网络连接编辑器

运行 `nm-connection-editor` 命令，会打开网络连接编辑器主窗口。在主窗口中，你可以看到已有的网络连接列表，并进行添加、编辑或删除操作。

### 2. 创建新连接

1. 点击 "添加" 按钮，会弹出连接类型选择对话框
2. 选择你需要创建的连接类型，如 "以太网"、"Wi-Fi" 等
3. 点击 "创建" 按钮，进入连接配置界面
4. 根据需要配置连接参数：
   - **常规**：连接名称、自动连接设置等
   - **IPv4设置**：IP地址、子网掩码、网关、DNS等
   - **IPv6设置**：IPv6地址、前缀长度、网关、DNS等
   - **安全**：Wi-Fi密码、VPN认证信息等
   - **代理**：代理服务器设置
5. 点击 "保存" 按钮保存连接设置

### 3. 编辑现有连接

1. 在连接列表中选择需要编辑的连接
2. 点击 "编辑" 按钮，进入连接配置界面
3. 修改需要更改的参数
4. 点击 "保存" 按钮保存更改

### 4. 删除连接

1. 在连接列表中选择需要删除的连接
2. 点击 "删除" 按钮
3. 在弹出的确认对话框中点击 "删除" 按钮

### 5. 连接激活与停用

虽然 `nm-connection-editor` 主要用于配置连接，但你可以通过以下方式激活或停用连接：

1. 在连接列表中选择需要操作的连接
2. 如果连接未激活，点击 "激活" 按钮
3. 如果连接已激活，点击 "停用" 按钮

## 高级配置选项

### 以太网连接高级选项

- **硬件地址**：指定网卡的MAC地址
- **MTU**：设置最大传输单元大小
- **自动协商**：启用或禁用自动协商
- **速度和双工**：手动设置网络速度和双工模式

### Wi-Fi连接高级选项

- **模式**：基础架构、临时、Ad-Hoc等
- **通道**：指定Wi-Fi通道
- **BSSID**：指定特定的接入点
- **MAC地址克隆**：设置克隆的MAC地址

### IPv4设置选项

- **方法**：自动（DHCP）、手动、链接本地、共享到其他计算机等
- **DNS服务器**：指定DNS服务器地址
- **路由**：添加静态路由

### IPv6设置选项

- **方法**：自动、手动、忽略等
- **DNS服务器**：指定IPv6 DNS服务器地址
- **路由**：添加IPv6静态路由

## 示例

### 示例1：打开网络连接编辑器

```bash
nm-connection-editor
```

### 示例2：直接添加新连接

```bash
nm-connection-editor -a
```

### 示例3：编辑指定的连接

```bash
nm-connection-editor -e "Wired Connection"
```

### 示例4：显示系统托盘图标

```bash
nm-connection-editor -s
```

### 示例5：查看帮助信息

```bash
nm-connection-editor -h
```

## 常见问题及解决方法

### 问题1：无法打开 nm-connection-editor

**原因**：可能是缺少图形环境或 NetworkManager 未安装

**解决方法**：
- 确保系统安装了图形环境（如 GNOME、KDE 等）
- 确保安装了 NetworkManager 及其图形界面组件：
  ```bash
  # Debian/Ubuntu
  sudo apt install network-manager-gnome
  
  # RHEL/CentOS
  sudo yum install NetworkManager-gnome
  
  # Fedora
  sudo dnf install NetworkManager-gnome
  ```

### 问题2：无法保存连接设置

**原因**：可能是权限不足或 NetworkManager 服务未运行

**解决方法**：
- 确保 NetworkManager 服务正在运行：
  ```bash
  sudo systemctl status NetworkManager
  ```
- 如果服务未运行，启动它：
  ```bash
  sudo systemctl start NetworkManager
  ```
- 确保你有足够的权限修改网络设置

### 问题3：连接创建后无法激活

**原因**：可能是网络设备未识别或驱动问题

**解决方法**：
- 检查网络设备是否被正确识别：
  ```bash
  nmcli device
  ```
- 确保网络设备驱动已正确安装
- 检查网络设备是否启用：
  ```bash
  nmcli device status
  ```

## 注意事项

- `nm-connection-editor` 是 NetworkManager 的图形界面工具，需要在有图形环境的系统中运行
- 适合需要可视化配置网络连接的场景，特别适合不熟悉命令行的用户
- 操作完成后，NetworkManager 会自动应用更改，无需手动重启服务
- 某些操作（如修改系统级网络设置）可能需要输入管理员密码进行授权
- 与 `nmcli`（命令行工具）和 `nmtui`（文本界面工具）相比，`nm-connection-editor` 提供了更直观的图形界面操作方式
- 所有通过 `nm-connection-editor` 创建的连接都会被保存在 `/etc/NetworkManager/system-connections/` 目录中
- 可以通过编辑 `/etc/NetworkManager/system-connections/` 目录中的配置文件来手动修改连接设置，但不建议这样做，因为可能会导致配置错误

## 相关命令

- `nmcli`：NetworkManager 的命令行工具
- `nmtui`：NetworkManager 的文本用户界面工具
- `nm-online`：检查网络连接状态的工具
- `NetworkManager`：网络管理服务本身