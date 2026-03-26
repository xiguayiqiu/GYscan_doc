# chcon 命令

## 命令说明

`chcon` 是 Linux 系统中用于修改文件或目录安全上下文的命令，主要用于 SELinux 系统。

## 语法

```bash
chcon [选项] 安全上下文 文件...
```

## 常用选项

| 选项 | 描述 |
|------|------|
| `-R` | 递归修改目录及其内容的安全上下文 |
| `-h` | 修改符号链接本身的安全上下文，而不是链接指向的文件 |
| `--reference=参考文件` | 使用参考文件的安全上下文 |

## 示例

### 修改文件的安全上下文

```bash
chcon user_u:object_r:httpd_sys_content_t:s0 file.txt
```

### 递归修改目录及其内容的安全上下文

```bash
chcon -R user_u:object_r:httpd_sys_content_t:s0 directory/
```

### 使用参考文件的安全上下文

```bash
chcon --reference=ref_file file.txt
```

## 注意事项

- `chcon` 命令用于修改文件或目录的安全上下文
- 安全上下文是 SELinux 系统中的一个重要概念，用于控制进程对文件的访问
- 安全上下文的格式通常为：`用户:角色:类型:级别`
- 只有 root 用户可以修改文件的安全上下文
- 使用 `ls -Z` 命令可以查看文件的安全上下文