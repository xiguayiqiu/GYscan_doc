# arch 命令

## 命令说明

`arch` 命令用于显示系统的硬件架构信息。

## 语法

```bash
arch
```

## 示例

### 显示系统架构

```bash
arch
# 输出示例：
# x86_64
```

## 注意事项

- `arch` 命令是 `uname -m` 的一个简单包装，功能相同
- 在不同的架构上，输出会有所不同，例如：
  - `x86_64`：64位x86架构
  - `i386`：32位x86架构
  - `armv7l`：32位ARM架构
  - `aarch64`：64位ARM架构
  - `mips`：MIPS架构
  - `powerpc`：PowerPC架构

## 相关命令

- `uname -m`：与 `arch` 命令功能相同
- `lscpu`：显示更详细的CPU信息
- `uname -a`：显示完整的系统信息