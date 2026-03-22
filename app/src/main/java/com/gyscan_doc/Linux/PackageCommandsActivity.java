package com.gyscan_doc.Linux;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.gyscan_doc.R;
import java.util.ArrayList;
import java.util.List;

public class PackageCommandsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CommandListAdapter adapter;
    private String packageName;
    private EditText searchEditText;
    private ImageButton clearButton;
    private List<CommandItem> allCommands;
    private List<CommandItem> filteredCommands;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package_commands);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            // 清除透明状态栏标志，确保状态栏显示
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            // 添加绘制系统栏背景的标志
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            // 根据当前主题使用合适的状态栏背景色
            int statusBarColor;
            int currentNightMode = getResources().getConfiguration().uiMode & android.content.res.Configuration.UI_MODE_NIGHT_MASK;
            if (currentNightMode == android.content.res.Configuration.UI_MODE_NIGHT_YES) {
                // 暗色模式
                statusBarColor = ContextCompat.getColor(this, R.color.dark_theme_dark_blue);
            } else {
                // 亮色模式
                statusBarColor = ContextCompat.getColor(this, R.color.theme_dark_blue);
            }
            window.setStatusBarColor(statusBarColor);
            // 确保状态栏文字为白色
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                // 清除SYSTEM_UI_FLAG_LIGHT_STATUS_BAR标志，确保状态栏文字为白色
                int flags = window.getDecorView().getSystemUiVisibility();
                flags &= ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
                window.getDecorView().setSystemUiVisibility(flags);
            } else {
                // 对于Android 6.0以下的设备，使用更简单的方法确保状态栏文字可见
                window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
            }
        }

        // 适配刘海屏、挖孔屏、水滴屏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            Window window = getWindow();
            WindowManager.LayoutParams layoutParams = window.getAttributes();
            layoutParams.layoutInDisplayCutoutMode = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES;
            window.setAttributes(layoutParams);
        }

        packageName = getIntent().getStringExtra("package_name");
        String packageTitle = getIntent().getStringExtra("package_title");
        String packageDescription = getIntent().getStringExtra("package_description");

        setupToolbar(packageTitle);
        setupRecyclerView(packageName);
    }

    private void setupToolbar(String title) {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(title);
        }
        
        for (int i = 0; i < toolbar.getChildCount(); i++) {
            View child = toolbar.getChildAt(i);
            if (child instanceof ImageButton) {
                ImageButton menuButton = (ImageButton) child;
                menuButton.setColorFilter(android.graphics.Color.WHITE, android.graphics.PorterDuff.Mode.SRC_ATOP);
                break;
            }
        }
    }

    private void setupRecyclerView(String packageName) {
        recyclerView = findViewById(R.id.commandsRecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        
        allCommands = getCommandsForPackage(packageName);
        filteredCommands = new ArrayList<>(allCommands);
        adapter = new CommandListAdapter(filteredCommands, this::onCommandClick);
        recyclerView.setAdapter(adapter);
        
        setupSearchView();
    }

    private void setupSearchView() {
        searchEditText = findViewById(R.id.searchEditText);
        clearButton = findViewById(R.id.clearButton);
        
        // 设置文本变化监听器
        searchEditText.addTextChangedListener(new android.text.TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filterCommands(s.toString());
                // 显示或隐藏清除按钮
                clearButton.setVisibility(s.length() > 0 ? View.VISIBLE : View.GONE);
            }
            
            @Override
            public void afterTextChanged(android.text.Editable s) {}
        });
        
        // 设置清除按钮点击事件
        clearButton.setOnClickListener(v -> {
            searchEditText.setText("");
        });
    }

    private void filterCommands(String query) {
        filteredCommands.clear();
        
        if (query == null || query.trim().isEmpty()) {
            filteredCommands.addAll(allCommands);
        } else {
            String lowerQuery = query.toLowerCase().trim();
            for (CommandItem cmd : allCommands) {
                if (cmd.getName().toLowerCase().contains(lowerQuery) ||
                    cmd.getDescription().toLowerCase().contains(lowerQuery)) {
                    filteredCommands.add(cmd);
                }
            }
        }
        
        adapter.notifyDataSetChanged();
    }

    private void onCommandClick(CommandItem command) {
        Intent intent = new Intent(this, CommandDetailActivity.class);
        intent.putExtra("command_name", command.getName());
        intent.putExtra("command_description", command.getDescription());
        startActivity(intent);
    }

    private List<CommandItem> getCommandsForPackage(String packageName) {
        List<CommandItem> commands = new ArrayList<>();
        
        switch (packageName) {
            case "system_service":
                commands.addAll(createSystemServiceCommands());
                break;
            case "file_directory":
                commands.addAll(createFileDirectoryCommands());
                break;
            case "permission_attribute":
                commands.addAll(createPermissionAttributeCommands());
                break;
            case "disk_filesystem":
                commands.addAll(createDiskFilesystemCommands());
                break;
            case "process_system":
                commands.addAll(createProcessSystemCommands());
                break;
            case "network":
                commands.addAll(createNetworkCommands());
                break;
            case "user_group":
                commands.addAll(createUserGroupCommands());
                break;
            case "text_processing":
                commands.addAll(createTextProcessingCommands());
                break;
            case "search_filter":
                commands.addAll(createSearchFilterCommands());
                break;
            case "compress_archive":
                commands.addAll(createCompressArchiveCommands());
                break;
            case "shell_environment":
                commands.addAll(createShellEnvironmentCommands());
                break;
            case "hardware_kernel":
                commands.addAll(createHardwareKernelCommands());
                break;
            case "time_timezone":
                commands.addAll(createTimeTimezoneCommands());
                break;
            case "security_encryption":
                commands.addAll(createSecurityEncryptionCommands());
                break;
            case "arch_tools":
                commands.addAll(createArchToolsCommands());
                break;
            case "boot_init":
                commands.addAll(createBootInitCommands());
                break;
            case "terminal_console":
                commands.addAll(createTerminalConsoleCommands());
                break;
            case "system_info":
                commands.addAll(createSystemInfoCommands());
                break;
        }
        
        return commands;
    }

    private List<CommandItem> createBaseCommands() {
        List<CommandItem> commands = new ArrayList<>();
        commands.add(new CommandItem("bash", "Bourne Again Shell命令解释器"));
        commands.add(new CommandItem("sh", "POSIX兼容的Shell"));
        commands.add(new CommandItem("ls", "列出目录内容"));
        commands.add(new CommandItem("cp", "复制文件或目录"));
        commands.add(new CommandItem("mv", "移动或重命名文件"));
        commands.add(new CommandItem("rm", "删除文件或目录"));
        commands.add(new CommandItem("mkdir", "创建目录"));
        commands.add(new CommandItem("rmdir", "删除空目录"));
        commands.add(new CommandItem("touch", "创建空文件或更新时间戳"));
        commands.add(new CommandItem("chmod", "修改文件权限"));
        commands.add(new CommandItem("chown", "修改文件所有者"));
        commands.add(new CommandItem("ln", "创建链接"));
        commands.add(new CommandItem("link", "创建硬链接"));
        commands.add(new CommandItem("unlink", "删除文件链接"));
        commands.add(new CommandItem("cat", "连接并显示文件内容"));
        commands.add(new CommandItem("echo", "显示文本或变量值"));
        commands.add(new CommandItem("printf", "格式化输出"));
        commands.add(new CommandItem("test", "测试文件类型和值"));
        commands.add(new CommandItem("pwd", "显示当前工作目录"));
        commands.add(new CommandItem("whoami", "显示当前用户名"));
        commands.add(new CommandItem("id", "显示用户和组信息"));
        commands.add(new CommandItem("groups", "显示用户所属的组"));
        commands.add(new CommandItem("env", "显示环境变量"));
        commands.add(new CommandItem("grep", "搜索文本模式"));
        commands.add(new CommandItem("egrep", "扩展正则表达式搜索"));
        commands.add(new CommandItem("fgrep", "固定字符串搜索"));
        commands.add(new CommandItem("sed", "流编辑器"));
        commands.add(new CommandItem("awk", "文本处理工具"));
        commands.add(new CommandItem("gawk", "GNU awk文本处理工具"));
        commands.add(new CommandItem("find", "搜索文件"));
        commands.add(new CommandItem("xargs", "构建和执行命令行"));
        commands.add(new CommandItem("ps", "显示进程状态"));
        commands.add(new CommandItem("top", "实时显示系统进程"));
        commands.add(new CommandItem("free", "显示内存使用情况"));
        commands.add(new CommandItem("uptime", "显示系统运行时间"));
        commands.add(new CommandItem("kill", "终止进程"));
        commands.add(new CommandItem("pkill", "按名称终止进程"));
        commands.add(new CommandItem("pgrep", "按名称查找进程"));
        commands.add(new CommandItem("skill", "发送信号给进程"));
        commands.add(new CommandItem("snice", "调整进程优先级"));
        commands.add(new CommandItem("mount", "挂载文件系统"));
        commands.add(new CommandItem("umount", "卸载文件系统"));
        commands.add(new CommandItem("swapon", "启用交换分区"));
        commands.add(new CommandItem("swapoff", "禁用交换分区"));
        commands.add(new CommandItem("dd", "复制和转换文件"));
        commands.add(new CommandItem("fdisk", "磁盘分区工具"));
        commands.add(new CommandItem("sfdisk", "脚本化磁盘分区工具"));
        commands.add(new CommandItem("cfdisk", "交互式磁盘分区工具"));
        commands.add(new CommandItem("lsblk", "列出块设备"));
        commands.add(new CommandItem("blkid", "显示块设备属性"));
        commands.add(new CommandItem("findmnt", "查找挂载点"));
        commands.add(new CommandItem("dmesg", "显示内核消息"));
        commands.add(new CommandItem("ip", "显示和配置网络"));
        commands.add(new CommandItem("ifconfig", "配置网络接口"));
        commands.add(new CommandItem("iwconfig", "配置无线网络接口"));
        commands.add(new CommandItem("arp", "显示和修改ARP缓存"));
        commands.add(new CommandItem("netstat", "显示网络状态"));
        commands.add(new CommandItem("route", "显示和修改路由表"));
        commands.add(new CommandItem("ss", "显示套接字统计"));
        commands.add(new CommandItem("tc", "流量控制工具"));
        commands.add(new CommandItem("ping", "测试网络连接"));
        commands.add(new CommandItem("ping6", "IPv6网络测试"));
        commands.add(new CommandItem("arping", "发送ARP请求"));
        commands.add(new CommandItem("traceroute", "跟踪网络路径"));
        commands.add(new CommandItem("tracepath", "跟踪网络路径"));
        commands.add(new CommandItem("systemctl", "控制系统和服务"));
        commands.add(new CommandItem("journalctl", "查询系统日志"));
        commands.add(new CommandItem("timedatectl", "控制系统时间和日期"));
        commands.add(new CommandItem("hostnamectl", "控制系统主机名"));
        commands.add(new CommandItem("loginctl", "控制登录会话"));
        commands.add(new CommandItem("useradd", "创建用户"));
        commands.add(new CommandItem("userdel", "删除用户"));
        commands.add(new CommandItem("usermod", "修改用户"));
        commands.add(new CommandItem("groupadd", "创建组"));
        commands.add(new CommandItem("groupdel", "删除组"));
        commands.add(new CommandItem("passwd", "修改用户密码"));
        commands.add(new CommandItem("chpasswd", "批量修改密码"));
        commands.add(new CommandItem("chsh", "修改用户Shell"));
        commands.add(new CommandItem("tar", "打包和解包文件"));
        commands.add(new CommandItem("gzip", "压缩文件"));
        commands.add(new CommandItem("bzip2", "使用bzip2压缩"));
        commands.add(new CommandItem("xz", "使用xz压缩"));
        commands.add(new CommandItem("less", "分页显示文件内容"));
        commands.add(new CommandItem("lspci", "列出PCI设备"));
        commands.add(new CommandItem("lsusb", "列出USB设备"));
        commands.add(new CommandItem("file", "识别文件类型"));
        commands.add(new CommandItem("hexdump", "十六进制转储"));
        commands.add(new CommandItem("od", "八进制转储"));
        commands.add(new CommandItem("sync", "同步文件系统缓存"));
        commands.add(new CommandItem("shutdown", "关闭系统"));
        commands.add(new CommandItem("reboot", "重启系统"));
        commands.add(new CommandItem("halt", "停止系统"));
        commands.add(new CommandItem("poweroff", "关闭电源"));
        return commands;
    }

    private List<CommandItem> createBaseDevelCommands() {
        List<CommandItem> commands = new ArrayList<>();
        commands.add(new CommandItem("make", "自动化构建工具"));
        commands.add(new CommandItem("gcc", "GNU C编译器"));
        commands.add(new CommandItem("g++", "GNU C++编译器"));
        commands.add(new CommandItem("gcov", "代码覆盖率工具"));
        commands.add(new CommandItem("gcc-ar", "GCC归档工具"));
        commands.add(new CommandItem("gcc-nm", "GCC符号列表工具"));
        commands.add(new CommandItem("gcc-ranlib", "GCC归档索引工具"));
        commands.add(new CommandItem("clang", "LLVM C编译器"));
        commands.add(new CommandItem("clang++", "LLVM C++编译器"));
        commands.add(new CommandItem("pkg-config", "编译和链接配置工具"));
        commands.add(new CommandItem("autoconf", "自动配置脚本生成器"));
        commands.add(new CommandItem("automake", "Makefile生成器"));
        commands.add(new CommandItem("libtool", "通用库支持脚本"));
        commands.add(new CommandItem("m4", "宏处理器"));
        commands.add(new CommandItem("bison", "语法分析器生成器"));
        commands.add(new CommandItem("flex", "词法分析器生成器"));
        commands.add(new CommandItem("patch", "应用补丁文件"));
        commands.add(new CommandItem("diff", "比较文件差异"));
        commands.add(new CommandItem("cmp", "逐字节比较文件"));
        commands.add(new CommandItem("sdiff", "并排比较文件"));
        commands.add(new CommandItem("strip", "剥离符号表"));
        commands.add(new CommandItem("objdump", "显示目标文件信息"));
        commands.add(new CommandItem("nm", "显示符号表"));
        commands.add(new CommandItem("ar", "创建和修改归档文件"));
        commands.add(new CommandItem("ranlib", "生成归档索引"));
        commands.add(new CommandItem("readelf", "显示ELF文件信息"));
        commands.add(new CommandItem("gdb", "GNU调试器"));
        commands.add(new CommandItem("fakeroot", "模拟root权限"));
        commands.add(new CommandItem("sudo", "以超级用户身份执行命令"));
        return commands;
    }

    private List<CommandItem> createNetworkManagerCommands() {
        List<CommandItem> commands = new ArrayList<>();
        commands.add(new CommandItem("nmcli", "NetworkManager命令行工具"));
        commands.add(new CommandItem("nmtui", "NetworkManager文本用户界面"));
        commands.add(new CommandItem("nm-online", "检查网络连接状态"));
        commands.add(new CommandItem("nm-connection-editor", "网络连接编辑器"));
        return commands;
    }

    private List<CommandItem> createBluezCommands() {
        List<CommandItem> commands = new ArrayList<>();
        commands.add(new CommandItem("bluetoothctl", "蓝牙控制工具"));
        commands.add(new CommandItem("btmgmt", "蓝牙管理工具"));
        commands.add(new CommandItem("btmon", "蓝牙监控工具"));
        commands.add(new CommandItem("hciattach", "蓝牙设备附加工具"));
        commands.add(new CommandItem("hciconfig", "蓝牙接口配置工具"));
        commands.add(new CommandItem("hcitool", "蓝牙诊断工具"));
        commands.add(new CommandItem("l2ping", "L2CAP ping工具"));
        commands.add(new CommandItem("rfcomm", "蓝牙串口通信工具"));
        return commands;
    }

    private List<CommandItem> createGrubCommands() {
        List<CommandItem> commands = new ArrayList<>();
        commands.add(new CommandItem("grub-install", "安装GRUB引导加载器"));
        commands.add(new CommandItem("grub-mkconfig", "生成GRUB配置文件"));
        commands.add(new CommandItem("grub-mkrescue", "创建GRUB救援镜像"));
        commands.add(new CommandItem("grub-probe", "探测设备信息"));
        commands.add(new CommandItem("grub-script-check", "检查GRUB脚本"));
        commands.add(new CommandItem("grub-editenv", "编辑GRUB环境变量"));
        commands.add(new CommandItem("update-grub", "更新GRUB配置"));
        return commands;
    }

    private List<CommandItem> createOtherCommands() {
        List<CommandItem> commands = new ArrayList<>();
        commands.add(new CommandItem("man", "显示命令手册"));
        commands.add(new CommandItem("vi", "Vi文本编辑器"));
        commands.add(new CommandItem("vim", "Vim文本编辑器"));
        commands.add(new CommandItem("nano", "Nano文本编辑器"));
        commands.add(new CommandItem("which", "查找命令路径"));
        commands.add(new CommandItem("whereis", "查找命令路径"));
        commands.add(new CommandItem("type", "显示命令类型"));
        commands.add(new CommandItem("alias", "创建命令别名"));
        commands.add(new CommandItem("history", "显示命令历史"));
        commands.add(new CommandItem("clear", "清屏"));
        commands.add(new CommandItem("exit", "退出Shell"));
        commands.add(new CommandItem("logout", "退出登录"));
        commands.add(new CommandItem("date", "显示日期时间"));
        commands.add(new CommandItem("cal", "显示日历"));
        commands.add(new CommandItem("uname", "显示系统信息"));
        commands.add(new CommandItem("df", "显示磁盘使用情况"));
        commands.add(new CommandItem("du", "显示目录大小"));
        commands.add(new CommandItem("head", "显示文件开头"));
        commands.add(new CommandItem("tail", "显示文件结尾"));
        commands.add(new CommandItem("wc", "统计文件行数、字数、字节数"));
        commands.add(new CommandItem("sort", "排序文本"));
        commands.add(new CommandItem("uniq", "去除重复行"));
        commands.add(new CommandItem("tee", "读取标准输入并写入文件和标准输出"));
        commands.add(new CommandItem("tr", "转换或删除字符"));
        commands.add(new CommandItem("cut", "剪切文本"));
        commands.add(new CommandItem("paste", "合并文本行"));
        commands.add(new CommandItem("watch", "定期执行命令"));
        commands.add(new CommandItem("sleep", "暂停执行"));
        commands.add(new CommandItem("yes", "重复输出字符串"));
        commands.add(new CommandItem("time", "测量命令执行时间"));
        commands.add(new CommandItem("timeout", "设置命令超时"));
        commands.add(new CommandItem("nice", "调整进程优先级"));
        commands.add(new CommandItem("renice", "调整运行进程的优先级"));
        commands.add(new CommandItem("nohup", "忽略挂起信号运行命令"));
        commands.add(new CommandItem("disown", "从作业表中移除作业"));
        commands.add(new CommandItem("jobs", "显示后台作业"));
        commands.add(new CommandItem("bg", "将作业放到后台"));
        commands.add(new CommandItem("fg", "将作业放到前台"));
        commands.add(new CommandItem("wait", "等待进程完成"));
        commands.add(new CommandItem("trap", "捕获信号"));
        commands.add(new CommandItem("killall", "按名称终止进程"));
        return commands;
    }

    private List<CommandItem> createSymbolsCommands() {
        List<CommandItem> commands = new ArrayList<>();
        commands.add(new CommandItem("*", "通配符：匹配任意字符（包括零个）"));
        commands.add(new CommandItem("?", "通配符：匹配单个字符"));
        commands.add(new CommandItem("[]", "字符集：匹配方括号内的任意一个字符"));
        commands.add(new CommandItem("[!]", "否定字符集：匹配不在方括号内的任意一个字符"));
        commands.add(new CommandItem("[a-z]", "字符范围：匹配a到z之间的任意字符"));
        commands.add(new CommandItem("[0-9]", "数字范围：匹配0到9之间的任意数字"));
        commands.add(new CommandItem("{a,b,c}", "扩展通配符：匹配a、b或c"));
        commands.add(new CommandItem("{1..10}", "数字序列：生成1到10的数字序列"));
        commands.add(new CommandItem(">", "重定向：将输出重定向到文件（覆盖）"));
        commands.add(new CommandItem(">>", "重定向：将输出追加到文件"));
        commands.add(new CommandItem("<", "重定向：从文件读取输入"));
        commands.add(new CommandItem("2>", "错误重定向：将错误输出重定向到文件"));
        commands.add(new CommandItem("2>>", "错误重定向：将错误输出追加到文件"));
        commands.add(new CommandItem("&>", "重定向：将标准输出和错误输出重定向到文件"));
        commands.add(new CommandItem("|", "管道：将一个命令的输出作为另一个命令的输入"));
        commands.add(new CommandItem(";", "命令分隔符：顺序执行多个命令"));
        commands.add(new CommandItem("&&", "逻辑与：前一个命令成功时才执行后一个命令"));
        commands.add(new CommandItem("||", "逻辑或：前一个命令失败时才执行后一个命令"));
        commands.add(new CommandItem("!", "逻辑非：否定条件或执行历史命令"));
        commands.add(new CommandItem("&", "后台运行：在后台执行命令"));
        commands.add(new CommandItem("$", "变量：引用变量或命令替换"));
        commands.add(new CommandItem("${}", "变量：更安全的变量引用方式"));
        commands.add(new CommandItem("$()", "命令替换：执行命令并替换为输出结果"));
        commands.add(new CommandItem("`", "命令替换：执行命令并替换为输出结果（旧式）"));
        commands.add(new CommandItem("$?", "退出状态：上一个命令的退出状态码"));
        commands.add(new CommandItem("$$", "进程ID：当前Shell的进程ID"));
        commands.add(new CommandItem("$!", "后台进程ID：最后一个后台进程的进程ID"));
        commands.add(new CommandItem("$0", "脚本名称：当前执行的脚本名称"));
        commands.add(new CommandItem("$1-$9", "位置参数：脚本或函数的参数"));
        commands.add(new CommandItem("$#", "参数个数：传递给脚本的参数个数"));
        commands.add(new CommandItem("$@", "所有参数：所有位置参数作为独立字符串"));
        commands.add(new CommandItem("$*", "所有参数：所有位置参数作为单个字符串"));
        commands.add(new CommandItem("~", "用户主目录：当前用户的主目录路径"));
        commands.add(new CommandItem("-", "上一个工作目录：切换到上一个工作目录"));
        commands.add(new CommandItem("..", "上级目录：当前目录的父目录"));
        commands.add(new CommandItem(".", "当前目录：当前工作目录"));
        commands.add(new CommandItem("/", "根目录：文件系统的根目录"));
        commands.add(new CommandItem("\\", "转义字符：转义下一个字符的特殊含义"));
        commands.add(new CommandItem("'", "单引号：完全引用，所有字符按字面意思解释"));
        commands.add(new CommandItem("\"", "双引号：部分引用，保留变量和命令替换"));
        commands.add(new CommandItem("\\\\", "反斜杠：转义字符或续行"));
        commands.add(new CommandItem("#", "注释：Shell忽略#之后的内容"));
        commands.add(new CommandItem("!", "历史命令：执行历史命令中的命令"));
        commands.add(new CommandItem("!!", "上一条命令：执行上一条命令"));
        commands.add(new CommandItem("!n", "历史命令：执行历史记录中第n条命令"));
        commands.add(new CommandItem("!string", "历史命令：执行最近以string开头的命令"));
        commands.add(new CommandItem("^", "替换：替换上一条命令中的字符串"));
        return commands;
    }

    private List<CommandItem> createSystemServiceCommands() {
        List<CommandItem> commands = new ArrayList<>();
        commands.add(new CommandItem("systemctl", "控制系统和服务"));
        commands.add(new CommandItem("journalctl", "查询系统日志"));
        commands.add(new CommandItem("loginctl", "控制登录会话"));
        commands.add(new CommandItem("machinectl", "控制系统机器"));
        commands.add(new CommandItem("bootctl", "控制启动加载器"));
        commands.add(new CommandItem("systemd-analyze", "分析系统启动时间"));
        commands.add(new CommandItem("systemd-cgtop", "显示控制组资源使用情况"));
        commands.add(new CommandItem("systemd-delta", "显示配置文件差异"));
        commands.add(new CommandItem("systemd-escape", "转义字符串"));
        commands.add(new CommandItem("systemd-hwdb", "硬件数据库管理"));
        commands.add(new CommandItem("systemd-inhibit", "禁止系统操作"));
        commands.add(new CommandItem("systemd-machine-id-setup", "设置机器ID"));
        commands.add(new CommandItem("systemd-mount", "挂载文件系统"));
        commands.add(new CommandItem("systemd-notify", "向systemd发送通知"));
        commands.add(new CommandItem("systemd-path", "查询系统路径"));
        commands.add(new CommandItem("systemd-run", "运行命令"));
        commands.add(new CommandItem("systemd-sleep", "系统睡眠管理"));
        commands.add(new CommandItem("systemd-tmpfiles", "管理临时文件"));
        commands.add(new CommandItem("systemd-umount", "卸载文件系统"));
        commands.add(new CommandItem("reboot", "重启系统"));
        commands.add(new CommandItem("poweroff", "关闭电源"));
        commands.add(new CommandItem("halt", "停止系统"));
        commands.add(new CommandItem("shutdown", "关闭系统"));
        commands.add(new CommandItem("telinit", "切换运行级别"));
        commands.add(new CommandItem("init", "系统初始化"));
        commands.add(new CommandItem("sulogin", "单用户模式登录"));
        return commands;
    }

    private List<CommandItem> createFileDirectoryCommands() {
        List<CommandItem> commands = new ArrayList<>();
        commands.add(new CommandItem("ls", "列出目录内容"));
        commands.add(new CommandItem("cp", "复制文件或目录"));
        commands.add(new CommandItem("mv", "移动或重命名文件"));
        commands.add(new CommandItem("rm", "删除文件或目录"));
        commands.add(new CommandItem("mkdir", "创建目录"));
        commands.add(new CommandItem("rmdir", "删除空目录"));
        commands.add(new CommandItem("touch", "创建空文件或更新时间戳"));
        commands.add(new CommandItem("ln", "创建链接"));
        commands.add(new CommandItem("cat", "连接并显示文件内容"));
        commands.add(new CommandItem("tac", "反向显示文件内容"));
        commands.add(new CommandItem("more", "分页显示文件内容"));
        commands.add(new CommandItem("less", "分页显示文件内容"));
        commands.add(new CommandItem("head", "显示文件开头"));
        commands.add(new CommandItem("tail", "显示文件结尾"));
        commands.add(new CommandItem("find", "搜索文件"));
        commands.add(new CommandItem("dd", "复制和转换文件"));
        commands.add(new CommandItem("df", "显示磁盘使用情况"));
        commands.add(new CommandItem("du", "显示目录大小"));
        commands.add(new CommandItem("sync", "同步文件系统缓存"));
        commands.add(new CommandItem("truncate", "截断文件"));
        commands.add(new CommandItem("basename", "获取文件名"));
        commands.add(new CommandItem("dirname", "获取目录名"));
        commands.add(new CommandItem("realpath", "获取真实路径"));
        commands.add(new CommandItem("readlink", "读取链接"));
        commands.add(new CommandItem("install", "安装文件"));
        commands.add(new CommandItem("mknod", "创建特殊文件"));
        commands.add(new CommandItem("mkfifo", "创建命名管道"));
        commands.add(new CommandItem("tee", "读取标准输入并写入文件和标准输出"));
        commands.add(new CommandItem("split", "分割文件"));
        commands.add(new CommandItem("paste", "合并文本行"));
        commands.add(new CommandItem("comm", "比较两个排序文件"));
        return commands;
    }

    private List<CommandItem> createPermissionAttributeCommands() {
        List<CommandItem> commands = new ArrayList<>();
        commands.add(new CommandItem("chmod", "修改文件权限"));
        commands.add(new CommandItem("chown", "修改文件所有者"));
        commands.add(new CommandItem("chgrp", "修改文件所属组"));
        commands.add(new CommandItem("chattr", "修改文件属性"));
        commands.add(new CommandItem("lsattr", "显示文件属性"));
        commands.add(new CommandItem("chroot", "改变根目录"));
        commands.add(new CommandItem("setfacl", "设置文件访问控制列表"));
        commands.add(new CommandItem("getfacl", "获取文件访问控制列表"));
        commands.add(new CommandItem("chcon", "修改文件安全上下文"));
        commands.add(new CommandItem("runcon", "在特定安全上下文中运行命令"));
        return commands;
    }

    private List<CommandItem> createDiskFilesystemCommands() {
        List<CommandItem> commands = new ArrayList<>();
        commands.add(new CommandItem("fdisk", "磁盘分区工具"));
        commands.add(new CommandItem("cfdisk", "交互式磁盘分区工具"));
        commands.add(new CommandItem("sfdisk", "脚本化磁盘分区工具"));
        commands.add(new CommandItem("blkid", "显示块设备属性"));
        commands.add(new CommandItem("lsblk", "列出块设备"));
        commands.add(new CommandItem("blkdiscard", "丢弃块设备数据"));
        commands.add(new CommandItem("mount", "挂载文件系统"));
        commands.add(new CommandItem("umount", "卸载文件系统"));
        commands.add(new CommandItem("losetup", "设置循环设备"));
        commands.add(new CommandItem("fsck", "检查和修复文件系统"));
        commands.add(new CommandItem("e2fsck", "检查和修复ext2/ext3/ext4文件系统"));
        commands.add(new CommandItem("mkfs", "创建文件系统"));
        commands.add(new CommandItem("mke2fs", "创建ext2/ext3/ext4文件系统"));
        commands.add(new CommandItem("tune2fs", "调整ext2/ext3/ext4文件系统参数"));
        commands.add(new CommandItem("dumpe2fs", "显示ext2/ext3/ext4文件系统信息"));
        commands.add(new CommandItem("blockdev", "块设备操作"));
        commands.add(new CommandItem("swapon", "启用交换分区"));
        commands.add(new CommandItem("swapoff", "禁用交换分区"));
        commands.add(new CommandItem("mkswap", "创建交换分区"));
        commands.add(new CommandItem("partprobe", "通知内核分区表变化"));
        commands.add(new CommandItem("partx", "管理分区"));
        commands.add(new CommandItem("findfs", "查找文件系统"));
        return commands;
    }

    private List<CommandItem> createProcessSystemCommands() {
        List<CommandItem> commands = new ArrayList<>();
        commands.add(new CommandItem("ps", "显示进程状态"));
        commands.add(new CommandItem("top", "实时显示系统进程"));
        commands.add(new CommandItem("kill", "终止进程"));
        commands.add(new CommandItem("pkill", "按名称终止进程"));
        commands.add(new CommandItem("pgrep", "按名称查找进程"));
        commands.add(new CommandItem("nice", "调整进程优先级"));
        commands.add(new CommandItem("renice", "调整运行进程的优先级"));
        commands.add(new CommandItem("ionice", "调整进程I/O优先级"));
        commands.add(new CommandItem("nohup", "忽略挂起信号运行命令"));
        commands.add(new CommandItem("uptime", "显示系统运行时间"));
        commands.add(new CommandItem("w", "显示登录用户信息"));
        commands.add(new CommandItem("who", "显示登录用户"));
        commands.add(new CommandItem("whoami", "显示当前用户名"));
        commands.add(new CommandItem("users", "显示登录用户"));
        commands.add(new CommandItem("last", "显示登录历史"));
        commands.add(new CommandItem("lastlog", "显示用户最后登录信息"));
        commands.add(new CommandItem("free", "显示内存使用情况"));
        commands.add(new CommandItem("sysctl", "控制系统参数"));
        commands.add(new CommandItem("prlimit", "管理进程资源限制"));
        commands.add(new CommandItem("setsid", "创建新会话"));
        commands.add(new CommandItem("taskset", "设置进程CPU亲和性"));
        commands.add(new CommandItem("pidof", "查找进程ID"));
        commands.add(new CommandItem("pstree", "显示进程树"));
        commands.add(new CommandItem("vmstat", "显示虚拟内存状态"));
        commands.add(new CommandItem("iostat", "显示I/O统计"));
        commands.add(new CommandItem("mpstat", "显示CPU统计"));
        return commands;
    }

    private List<CommandItem> createNetworkCommands() {
        List<CommandItem> commands = new ArrayList<>();
        commands.add(new CommandItem("ip", "显示和配置网络"));
        commands.add(new CommandItem("ss", "显示套接字统计"));
        commands.add(new CommandItem("ping", "测试网络连接"));
        commands.add(new CommandItem("ping6", "IPv6网络测试"));
        commands.add(new CommandItem("traceroute", "跟踪网络路径"));
        commands.add(new CommandItem("tracepath", "跟踪网络路径"));
        commands.add(new CommandItem("hostname", "显示或设置主机名"));
        commands.add(new CommandItem("hostnamectl", "控制系统主机名"));
        commands.add(new CommandItem("resolvectl", "解析器控制"));
        commands.add(new CommandItem("ethtool", "以太网工具"));
        commands.add(new CommandItem("arp", "显示和修改ARP缓存"));
        commands.add(new CommandItem("nstat", "显示网络统计"));
        commands.add(new CommandItem("ctstat", "显示连接跟踪统计"));
        commands.add(new CommandItem("rtacct", "显示路由统计"));
        return commands;
    }

    private List<CommandItem> createUserGroupCommands() {
        List<CommandItem> commands = new ArrayList<>();
        commands.add(new CommandItem("useradd", "创建用户"));
        commands.add(new CommandItem("userdel", "删除用户"));
        commands.add(new CommandItem("usermod", "修改用户"));
        commands.add(new CommandItem("groupadd", "创建组"));
        commands.add(new CommandItem("groupdel", "删除组"));
        commands.add(new CommandItem("groupmod", "修改组"));
        commands.add(new CommandItem("passwd", "修改用户密码"));
        commands.add(new CommandItem("chage", "修改用户密码过期信息"));
        commands.add(new CommandItem("id", "显示用户和组信息"));
        commands.add(new CommandItem("getent", "获取系统数据库条目"));
        commands.add(new CommandItem("pwck", "检查密码文件"));
        commands.add(new CommandItem("grpck", "检查组文件"));
        commands.add(new CommandItem("newgrp", "切换有效组"));
        commands.add(new CommandItem("su", "切换用户"));
        commands.add(new CommandItem("runuser", "以另一个用户身份运行命令"));
        return commands;
    }

    private List<CommandItem> createTextProcessingCommands() {
        List<CommandItem> commands = new ArrayList<>();
        commands.add(new CommandItem("sed", "流编辑器"));
        commands.add(new CommandItem("awk", "文本处理工具"));
        commands.add(new CommandItem("gawk", "GNU awk文本处理工具"));
        commands.add(new CommandItem("tr", "转换或删除字符"));
        commands.add(new CommandItem("diff", "比较文件差异"));
        commands.add(new CommandItem("patch", "应用补丁文件"));
        commands.add(new CommandItem("cmp", "逐字节比较文件"));
        commands.add(new CommandItem("printf", "格式化输出"));
        commands.add(new CommandItem("echo", "显示文本或变量值"));
        commands.add(new CommandItem("yes", "重复输出字符串"));
        commands.add(new CommandItem("nl", "添加行号"));
        commands.add(new CommandItem("fold", "折叠文本"));
        commands.add(new CommandItem("fmt", "格式化文本"));
        commands.add(new CommandItem("pr", "格式化打印"));
        commands.add(new CommandItem("iconv", "字符编码转换"));
        commands.add(new CommandItem("uconv", "Unicode转换"));
        commands.add(new CommandItem("base64", "Base64编码"));
        commands.add(new CommandItem("base32", "Base32编码"));
        commands.add(new CommandItem("basenc", "多种编码"));
        commands.add(new CommandItem("hexdump", "十六进制转储"));
        commands.add(new CommandItem("xxd", "十六进制转储"));
        return commands;
    }

    private List<CommandItem> createSearchFilterCommands() {
        List<CommandItem> commands = new ArrayList<>();
        commands.add(new CommandItem("grep", "搜索文本模式"));
        commands.add(new CommandItem("fgrep", "固定字符串搜索"));
        commands.add(new CommandItem("egrep", "扩展正则表达式搜索"));
        commands.add(new CommandItem("sort", "排序文本"));
        commands.add(new CommandItem("uniq", "去除重复行"));
        commands.add(new CommandItem("cut", "剪切文本"));
        commands.add(new CommandItem("find", "搜索文件"));
        commands.add(new CommandItem("locate", "查找文件"));
        commands.add(new CommandItem("updatedb", "更新文件数据库"));
        commands.add(new CommandItem("which", "查找命令路径"));
        return commands;
    }

    private List<CommandItem> createCompressArchiveCommands() {
        List<CommandItem> commands = new ArrayList<>();
        commands.add(new CommandItem("tar", "打包和解包文件"));
        commands.add(new CommandItem("gzip", "压缩文件"));
        commands.add(new CommandItem("gunzip", "解压缩gzip文件"));
        commands.add(new CommandItem("zcat", "显示gzip压缩文件内容"));
        commands.add(new CommandItem("bzip2", "使用bzip2压缩"));
        commands.add(new CommandItem("bunzip2", "解压缩bzip2文件"));
        commands.add(new CommandItem("bzcat", "显示bzip2压缩文件内容"));
        commands.add(new CommandItem("xz", "使用xz压缩"));
        commands.add(new CommandItem("unxz", "解压缩xz文件"));
        commands.add(new CommandItem("xzcat", "显示xz压缩文件内容"));
        commands.add(new CommandItem("cpio", "复制文件到归档"));
        commands.add(new CommandItem("bsdtar", "BSD tar"));
        commands.add(new CommandItem("zstd", "使用zstd压缩"));
        commands.add(new CommandItem("unzstd", "解压缩zstd文件"));
        return commands;
    }

    private List<CommandItem> createShellEnvironmentCommands() {
        List<CommandItem> commands = new ArrayList<>();
        commands.add(new CommandItem("bash", "Bourne Again Shell命令解释器"));
        commands.add(new CommandItem("sh", "POSIX兼容的Shell"));
        commands.add(new CommandItem("env", "显示环境变量"));
        commands.add(new CommandItem("set", "设置Shell变量"));
        commands.add(new CommandItem("unset", "取消设置Shell变量"));
        commands.add(new CommandItem("test", "测试文件类型和值"));
        commands.add(new CommandItem("[", "测试文件类型和值"));
        commands.add(new CommandItem("expr", "表达式求值"));
        commands.add(new CommandItem("true", "返回真"));
        commands.add(new CommandItem("false", "返回假"));
        commands.add(new CommandItem("whereis", "查找命令路径"));
        commands.add(new CommandItem("man", "显示命令手册"));
        commands.add(new CommandItem("locale", "显示区域设置"));
        commands.add(new CommandItem("localectl", "控制系统区域设置"));
        commands.add(new CommandItem("tty", "显示终端设备"));
        commands.add(new CommandItem("stty", "设置终端属性"));
        commands.add(new CommandItem("clear", "清屏"));
        commands.add(new CommandItem("dircolors", "设置目录颜色"));
        commands.add(new CommandItem("getopt", "解析命令行选项"));
        commands.add(new CommandItem("setterm", "设置终端属性"));
        return commands;
    }

    private List<CommandItem> createHardwareKernelCommands() {
        List<CommandItem> commands = new ArrayList<>();
        commands.add(new CommandItem("lsmod", "列出加载的模块"));
        commands.add(new CommandItem("modinfo", "显示模块信息"));
        commands.add(new CommandItem("modprobe", "加载或卸载模块"));
        commands.add(new CommandItem("rmmod", "卸载模块"));
        commands.add(new CommandItem("insmod", "加载模块"));
        commands.add(new CommandItem("udevadm", "udev管理"));
        commands.add(new CommandItem("hwclock", "硬件时钟管理"));
        commands.add(new CommandItem("dmidecode", "显示硬件信息"));
        commands.add(new CommandItem("dmesg", "显示内核消息"));
        commands.add(new CommandItem("setleds", "设置LED"));
        commands.add(new CommandItem("kmod", "内核模块工具"));
        return commands;
    }

    private List<CommandItem> createTimeTimezoneCommands() {
        List<CommandItem> commands = new ArrayList<>();
        commands.add(new CommandItem("timedatectl", "控制系统时间和日期"));
        commands.add(new CommandItem("tzselect", "选择时区"));
        commands.add(new CommandItem("hwclock", "硬件时钟管理"));
        commands.add(new CommandItem("date", "显示日期时间"));
        commands.add(new CommandItem("clock", "系统时钟管理"));
        return commands;
    }

    private List<CommandItem> createSecurityEncryptionCommands() {
        List<CommandItem> commands = new ArrayList<>();
        commands.add(new CommandItem("openssl", "OpenSSL工具"));
        commands.add(new CommandItem("cryptsetup", "加密设置"));
        commands.add(new CommandItem("veritysetup", "验证设置"));
        commands.add(new CommandItem("integritysetup", "完整性设置"));
        commands.add(new CommandItem("sha1sum", "SHA1校验和"));
        commands.add(new CommandItem("sha256sum", "SHA256校验和"));
        commands.add(new CommandItem("sha512sum", "SHA512校验和"));
        commands.add(new CommandItem("md5sum", "MD5校验和"));
        commands.add(new CommandItem("sum", "校验和"));
        return commands;
    }

    private List<CommandItem> createArchToolsCommands() {
        List<CommandItem> commands = new ArrayList<>();
        commands.add(new CommandItem("pacman", "Arch Linux包管理器"));
        commands.add(new CommandItem("pacman-key", "Pacman密钥管理"));
        commands.add(new CommandItem("pacstrap", "安装基本系统"));
        commands.add(new CommandItem("arch-chroot", "Arch chroot"));
        commands.add(new CommandItem("genfstab", "生成fstab"));
        commands.add(new CommandItem("mkinitcpio", "创建initramfs"));
        commands.add(new CommandItem("pacdiff", "比较包文件"));
        commands.add(new CommandItem("paccache", "Pacman缓存管理"));
        commands.add(new CommandItem("pacsort", "Pacman包排序"));
        commands.add(new CommandItem("pkgconf", "包配置"));
        commands.add(new CommandItem("makepkg", "构建Arch包"));
        return commands;
    }

    private List<CommandItem> createBootInitCommands() {
        List<CommandItem> commands = new ArrayList<>();
        commands.add(new CommandItem("dracut", "创建initramfs"));
        commands.add(new CommandItem("update-triggers", "更新触发器"));
        return commands;
    }

    private List<CommandItem> createTerminalConsoleCommands() {
        List<CommandItem> commands = new ArrayList<>();
        commands.add(new CommandItem("resize", "调整终端大小"));
        commands.add(new CommandItem("script", "记录终端会话"));
        commands.add(new CommandItem("scriptlive", "实时记录终端会话"));
        commands.add(new CommandItem("readelf", "显示ELF文件信息"));
        return commands;
    }

    private List<CommandItem> createSystemInfoCommands() {
        List<CommandItem> commands = new ArrayList<>();
        commands.add(new CommandItem("uname", "显示系统信息"));
        commands.add(new CommandItem("arch", "显示系统架构"));
        commands.add(new CommandItem("os-release", "显示操作系统信息"));
        commands.add(new CommandItem("sysinfo", "显示系统信息"));
        return commands;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}