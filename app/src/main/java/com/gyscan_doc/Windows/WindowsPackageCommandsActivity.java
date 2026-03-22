package com.gyscan_doc.Windows;

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

public class WindowsPackageCommandsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private WindowsCommandListAdapter adapter;
    private String packageName;
    private EditText searchEditText;
    private ImageButton clearButton;
    private List<WindowsCommandItem> allCommands;
    private List<WindowsCommandItem> filteredCommands;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_windows_package_commands);

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

        setupToolbar(packageTitle);
        setupRecyclerView(packageName);
        setupSearchView();
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
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        
        allCommands = createCommands(packageName);
        filteredCommands = new ArrayList<>(allCommands);
        adapter = new WindowsCommandListAdapter(filteredCommands, this::onCommandClick);
        recyclerView.setAdapter(adapter);
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
            for (WindowsCommandItem command : allCommands) {
                if (command.getName().toLowerCase().contains(lowerQuery) ||
                    command.getDescription().toLowerCase().contains(lowerQuery)) {
                    filteredCommands.add(command);
                }
            }
        }
        
        adapter.notifyDataSetChanged();
    }

    private void onCommandClick(WindowsCommandItem command) {
        android.content.Intent intent = new android.content.Intent(this, WindowsCommandDetailActivity.class);
        intent.putExtra("command_name", command.getName());
        intent.putExtra("command_title", command.getDescription());
        startActivity(intent);
    }

    private List<WindowsCommandItem> createCommands(String packageName) {
        List<WindowsCommandItem> commands = new ArrayList<>();
        
        switch (packageName) {
            case "file_directory":
                commands.add(new WindowsCommandItem("active", "激活分区"));
                commands.add(new WindowsCommandItem("add", "添加项目"));
                commands.add(new WindowsCommandItem("append", "追加文本到文件"));
                commands.add(new WindowsCommandItem("assign", "分配驱动器号"));
                commands.add(new WindowsCommandItem("assoc", "关联文件扩展名"));
                commands.add(new WindowsCommandItem("attrib", "查看或修改文件属性"));
                commands.add(new WindowsCommandItem("attributes", "查看或修改属性"));
                commands.add(new WindowsCommandItem("cd", "切换目录"));
                commands.add(new WindowsCommandItem("chdir", "切换目录"));
                commands.add(new WindowsCommandItem("copy", "复制文件"));
                commands.add(new WindowsCommandItem("create", "创建项目"));
                commands.add(new WindowsCommandItem("del", "删除文件"));
                commands.add(new WindowsCommandItem("delete", "删除项目"));
                commands.add(new WindowsCommandItem("detach vdisk", "分离虚拟磁盘"));
                commands.add(new WindowsCommandItem("dir", "显示目录内容"));
                commands.add(new WindowsCommandItem("edit", "编辑文件"));
                commands.add(new WindowsCommandItem("erase", "删除文件"));
                commands.add(new WindowsCommandItem("expand", "展开文件"));
                commands.add(new WindowsCommandItem("extract", "提取文件"));
                commands.add(new WindowsCommandItem("format", "格式化磁盘"));
                commands.add(new WindowsCommandItem("mkdir", "创建目录"));
                commands.add(new WindowsCommandItem("md", "创建目录"));
                commands.add(new WindowsCommandItem("move", "移动文件"));
                commands.add(new WindowsCommandItem("more", "分页显示文件内容"));
                commands.add(new WindowsCommandItem("ren", "重命名文件"));
                commands.add(new WindowsCommandItem("rename", "重命名文件"));
                commands.add(new WindowsCommandItem("rmdir", "删除目录"));
                commands.add(new WindowsCommandItem("rd", "删除目录"));
                commands.add(new WindowsCommandItem("replace", "替换文件"));
                commands.add(new WindowsCommandItem("robocopy", "高级文件复制"));
                commands.add(new WindowsCommandItem("type", "显示文件内容"));
                commands.add(new WindowsCommandItem("tree", "显示目录树"));
                commands.add(new WindowsCommandItem("xcopy", "复制文件和目录"));
                break;
            case "system_management":
                commands.add(new WindowsCommandItem("at", "计划任务"));
                commands.add(new WindowsCommandItem("atmadm", "ATM管理"));
                commands.add(new WindowsCommandItem("bcdboot", "启动配置数据引导"));
                commands.add(new WindowsCommandItem("bcdedit", "启动配置数据编辑"));
                commands.add(new WindowsCommandItem("begin", "开始"));
                commands.add(new WindowsCommandItem("bitsadmin", "后台智能传输服务管理"));
                commands.add(new WindowsCommandItem("bootcfg", "启动配置"));
                commands.add(new WindowsCommandItem("break", "中断"));
                commands.add(new WindowsCommandItem("cprofile", "配置文件管理"));
                commands.add(new WindowsCommandItem("certreq", "证书请求"));
                commands.add(new WindowsCommandItem("certutil", "证书工具"));
                commands.add(new WindowsCommandItem("change", "更改"));
                commands.add(new WindowsCommandItem("dcgpofix", "域控制器组策略修复"));
                commands.add(new WindowsCommandItem("dfsdiag", "DFS诊断"));
                commands.add(new WindowsCommandItem("dfsrmig", "DFS复制迁移"));
                commands.add(new WindowsCommandItem("dispdiag", "显示诊断"));
                commands.add(new WindowsCommandItem("doskey", "命令历史"));
                commands.add(new WindowsCommandItem("driverquery", "驱动程序查询"));
                commands.add(new WindowsCommandItem("end", "结束"));
                commands.add(new WindowsCommandItem("endlocal", "结束本地化"));
                commands.add(new WindowsCommandItem("eventcreate", "创建事件"));
                commands.add(new WindowsCommandItem("eventquery", "查询事件"));
                commands.add(new WindowsCommandItem("eventtriggers", "事件触发器"));
                commands.add(new WindowsCommandItem("Evntcmd", "事件命令"));
                commands.add(new WindowsCommandItem("exec", "执行命令"));
                commands.add(new WindowsCommandItem("exit", "退出命令"));
                commands.add(new WindowsCommandItem("finger", "查询用户信息"));
                commands.add(new WindowsCommandItem("flattemp", "临时文件夹管理"));
                commands.add(new WindowsCommandItem("fondue", "功能启用"));
                commands.add(new WindowsCommandItem("for", "循环命令"));
                commands.add(new WindowsCommandItem("forfiles", "文件循环"));
                commands.add(new WindowsCommandItem("goto", "跳转到标签"));
                commands.add(new WindowsCommandItem("logoff", "注销当前用户"));
                commands.add(new WindowsCommandItem("mapadmin", "映射管理"));
                commands.add(new WindowsCommandItem("merge", "合并"));
                commands.add(new WindowsCommandItem("mmc", "微软管理控制台"));
                commands.add(new WindowsCommandItem("msg", "发送消息"));
                commands.add(new WindowsCommandItem("msdt", "微软诊断工具"));
                commands.add(new WindowsCommandItem("msiexec", "Windows安装程序"));
                commands.add(new WindowsCommandItem("msinfo32", "系统信息"));
                commands.add(new WindowsCommandItem("mstsc", "远程桌面连接"));
                commands.add(new WindowsCommandItem("nlbmgr", "网络负载平衡管理器"));
                commands.add(new WindowsCommandItem("ntbackup", "NT备份"));
                commands.add(new WindowsCommandItem("ntcmdprompt", "NT命令提示符"));
                commands.add(new WindowsCommandItem("ntfrsutl", "NT文件复制服务工具"));
                commands.add(new WindowsCommandItem("pagefileconfig", "页面文件配置"));
                commands.add(new WindowsCommandItem("pause", "暂停命令"));
                commands.add(new WindowsCommandItem("pbadmin", "Phone Book管理"));
                commands.add(new WindowsCommandItem("pentnt", "Pentium NT工具"));
                commands.add(new WindowsCommandItem("perfmon", "性能监视器"));
                commands.add(new WindowsCommandItem("pnpunattend", "即插即用无人值守"));
                commands.add(new WindowsCommandItem("pnputil", "即插即用工具"));
                commands.add(new WindowsCommandItem("popd", "弹出目录"));
                commands.add(new WindowsCommandItem("powershell", "PowerShell"));
                commands.add(new WindowsCommandItem("powershell ise", "PowerShell ISE"));
                commands.add(new WindowsCommandItem("print", "打印文件"));
                commands.add(new WindowsCommandItem("prncnfg", "打印机配置"));
                commands.add(new WindowsCommandItem("prndrvr", "打印机驱动程序"));
                commands.add(new WindowsCommandItem("prnjobs", "打印作业"));
                commands.add(new WindowsCommandItem("prnmngr", "打印机管理器"));
                commands.add(new WindowsCommandItem("prnport", "打印机端口"));
                commands.add(new WindowsCommandItem("prnqctl", "打印队列控制"));
                commands.add(new WindowsCommandItem("prompt", "设置命令提示符"));
                commands.add(new WindowsCommandItem("pubprn", "发布打印机"));
                commands.add(new WindowsCommandItem("pushd", "推送目录"));
                commands.add(new WindowsCommandItem("pushprinterconnections", "推送打印机连接"));
                commands.add(new WindowsCommandItem("pwlauncher", "密码启动器"));
                commands.add(new WindowsCommandItem("pwsh", "PowerShell Core"));
                commands.add(new WindowsCommandItem("qappsrv", "查询终端服务器"));
                commands.add(new WindowsCommandItem("qprocess", "查询进程"));
                commands.add(new WindowsCommandItem("query", "查询"));
                commands.add(new WindowsCommandItem("quser", "查询用户"));
                commands.add(new WindowsCommandItem("qwinsta", "查询终端服务状态"));
                commands.add(new WindowsCommandItem("rcp", "远程复制"));
                commands.add(new WindowsCommandItem("rdpsign", "RDP签名"));
                commands.add(new WindowsCommandItem("recover", "恢复文件"));
                commands.add(new WindowsCommandItem("refsutil", "ReFS实用工具"));
                commands.add(new WindowsCommandItem("rem", "注释"));
                commands.add(new WindowsCommandItem("repadmin", "复制管理"));
                commands.add(new WindowsCommandItem("repair", "修复"));
                commands.add(new WindowsCommandItem("rescan", "重新扫描"));
                commands.add(new WindowsCommandItem("reset", "重置"));
                commands.add(new WindowsCommandItem("retain", "保留"));
                commands.add(new WindowsCommandItem("revert", "还原"));
                commands.add(new WindowsCommandItem("rexec", "远程执行"));
                commands.add(new WindowsCommandItem("risetup", "远程安装服务设置"));
                commands.add(new WindowsCommandItem("rpcinfo", "RPC信息"));
                commands.add(new WindowsCommandItem("rpcping", "RPC Ping"));
                commands.add(new WindowsCommandItem("rsh", "远程shell"));
                commands.add(new WindowsCommandItem("rundll32", "运行DLL"));
                commands.add(new WindowsCommandItem("rwinsta", "重置终端服务会话"));
                commands.add(new WindowsCommandItem("san", "存储区域网络"));
                commands.add(new WindowsCommandItem("sc", "服务控制"));
                commands.add(new WindowsCommandItem("schtasks", "计划任务"));
                commands.add(new WindowsCommandItem("scwcmd", "安全配置向导命令"));
                commands.add(new WindowsCommandItem("select", "选择"));
                commands.add(new WindowsCommandItem("serverceipoptin", "服务器CEIP选择"));
                commands.add(new WindowsCommandItem("servermanagercmd", "服务器管理器命令"));
                commands.add(new WindowsCommandItem("serverweroptin", "服务器错误报告选择"));
                commands.add(new WindowsCommandItem("set", "设置环境变量"));
                commands.add(new WindowsCommandItem("setlocal", "设置本地"));
                commands.add(new WindowsCommandItem("setx", "设置环境变量"));
                commands.add(new WindowsCommandItem("shift", "移位参数"));
                commands.add(new WindowsCommandItem("shutdown", "关闭或重启计算机"));
                commands.add(new WindowsCommandItem("simulate", "模拟"));
                commands.add(new WindowsCommandItem("sort", "排序"));
                commands.add(new WindowsCommandItem("start", "启动"));
                commands.add(new WindowsCommandItem("subcommand", "子命令"));
                commands.add(new WindowsCommandItem("sxstrace", "Side-by-Side跟踪"));
                commands.add(new WindowsCommandItem("sysocmgr", "系统可选组件管理器"));
                commands.add(new WindowsCommandItem("systeminfo", "系统信息"));
                commands.add(new WindowsCommandItem("takeown", "获取文件所有权"));
                commands.add(new WindowsCommandItem("tapicfg", "TAPI配置"));
                commands.add(new WindowsCommandItem("taskkill", "终止进程"));
                commands.add(new WindowsCommandItem("tasklist", "进程列表"));
                commands.add(new WindowsCommandItem("tcmsetup", "电话会议设置"));
                commands.add(new WindowsCommandItem("tpmtool", "TPM工具"));
                commands.add(new WindowsCommandItem("tpmvscmgr", "TPM虚拟智能卡管理器"));
                commands.add(new WindowsCommandItem("tracerpt", "跟踪提取"));
                commands.add(new WindowsCommandItem("tscon", "连接到远程桌面会话"));
                commands.add(new WindowsCommandItem("tsdiscon", "断开远程桌面会话"));
                commands.add(new WindowsCommandItem("tsecimp", "安全导入"));
                commands.add(new WindowsCommandItem("tskill", "终止终端服务进程"));
                commands.add(new WindowsCommandItem("tsprof", "终端服务配置文件"));
                commands.add(new WindowsCommandItem("typeperf", "类型性能"));
                commands.add(new WindowsCommandItem("tzutil", "时区工具"));
                commands.add(new WindowsCommandItem("unlodctr", "卸载计数器"));
                commands.add(new WindowsCommandItem("verifier", "驱动程序验证器"));
                commands.add(new WindowsCommandItem("waitfor", "等待信号"));
                commands.add(new WindowsCommandItem("wbadmin", "Windows备份管理"));
                commands.add(new WindowsCommandItem("wdsutil", "Windows部署服务工具"));
                commands.add(new WindowsCommandItem("wecutil", "Windows事件收集器工具"));
                commands.add(new WindowsCommandItem("wevtutil", "Windows事件工具"));
                commands.add(new WindowsCommandItem("winnt", "Windows NT安装"));
                commands.add(new WindowsCommandItem("winnt32", "Windows NT 32位安装"));
                commands.add(new WindowsCommandItem("winpop", "Windows弹出"));
                commands.add(new WindowsCommandItem("winrs", "Windows远程Shell"));
                commands.add(new WindowsCommandItem("winsat", "Windows系统评估工具"));
                commands.add(new WindowsCommandItem("wmic", "Windows管理规范命令"));
                commands.add(new WindowsCommandItem("writer", "卷影副本写入器"));
                break;
            case "disk_management":
                commands.add(new WindowsCommandItem("attach-vdisk", "附加虚拟磁盘"));
                commands.add(new WindowsCommandItem("autochk", "自动检查"));
                commands.add(new WindowsCommandItem("autoconv", "自动转换"));
                commands.add(new WindowsCommandItem("autofmt", "自动格式化"));
                commands.add(new WindowsCommandItem("automount", "自动挂载"));
                commands.add(new WindowsCommandItem("bdehdcfg", "BitLocker驱动器配置"));
                commands.add(new WindowsCommandItem("chkdsk", "检查磁盘错误"));
                commands.add(new WindowsCommandItem("chkntfs", "检查NTFS"));
                commands.add(new WindowsCommandItem("clean", "清理磁盘"));
                commands.add(new WindowsCommandItem("cleanmgr", "磁盘清理"));
                commands.add(new WindowsCommandItem("convert", "转换文件系统"));
                commands.add(new WindowsCommandItem("defrag", "磁盘碎片整理"));
                commands.add(new WindowsCommandItem("detail", "详细信息"));
                commands.add(new WindowsCommandItem("diskcomp", "磁盘比较"));
                commands.add(new WindowsCommandItem("diskcopy", "磁盘复制"));
                commands.add(new WindowsCommandItem("diskpart", "磁盘分区管理"));
                commands.add(new WindowsCommandItem("diskperf", "磁盘性能"));
                commands.add(new WindowsCommandItem("diskraid", "磁盘RAID"));
                commands.add(new WindowsCommandItem("diskshadow", "磁盘卷影"));
                commands.add(new WindowsCommandItem("expose", "暴露"));
                commands.add(new WindowsCommandItem("extend", "扩展分区"));
                commands.add(new WindowsCommandItem("filesystems", "文件系统"));
                commands.add(new WindowsCommandItem("freedisk", "可用磁盘空间"));
                commands.add(new WindowsCommandItem("fsutil", "文件系统工具"));
                commands.add(new WindowsCommandItem("label", "卷标"));
                commands.add(new WindowsCommandItem("mount", "挂载"));
                commands.add(new WindowsCommandItem("mountvol", "挂载卷"));
                commands.add(new WindowsCommandItem("mklink", "创建符号链接"));
                commands.add(new WindowsCommandItem("offline", "离线"));
                commands.add(new WindowsCommandItem("online", "在线"));
                commands.add(new WindowsCommandItem("select", "选择"));
                commands.add(new WindowsCommandItem("shrink", "收缩分区"));
                commands.add(new WindowsCommandItem("subst", "将路径与驱动器号关联"));
                commands.add(new WindowsCommandItem("unexpose", "取消暴露"));
                commands.add(new WindowsCommandItem("uniqueid", "唯一ID"));
                commands.add(new WindowsCommandItem("verify", "验证"));
                commands.add(new WindowsCommandItem("vol", "显示卷标"));
                commands.add(new WindowsCommandItem("vssadmin", "卷影副本服务管理"));
                break;
            case "network_management":
                commands.add(new WindowsCommandItem("arp", "显示和修改ARP缓存"));
                commands.add(new WindowsCommandItem("dnscmd", "DNS命令"));
                commands.add(new WindowsCommandItem("ftp", "文件传输协议"));
                commands.add(new WindowsCommandItem("getmac", "获取MAC地址"));
                commands.add(new WindowsCommandItem("lpq", "打印队列"));
                commands.add(new WindowsCommandItem("lpr", "行式打印机"));
                commands.add(new WindowsCommandItem("nbtstat", "NetBIOS统计信息"));
                commands.add(new WindowsCommandItem("netcfg", "网络配置"));
                commands.add(new WindowsCommandItem("netdom", "网络域"));
                commands.add(new WindowsCommandItem("net print", "网络打印"));
                commands.add(new WindowsCommandItem("netsh", "网络配置命令"));
                commands.add(new WindowsCommandItem("netstat", "网络状态"));
                commands.add(new WindowsCommandItem("nfsstat", "NFS统计信息"));
                commands.add(new WindowsCommandItem("nltest", "NT测试"));
                commands.add(new WindowsCommandItem("nslookup", "DNS查询"));
                commands.add(new WindowsCommandItem("openfiles", "打开文件"));
                commands.add(new WindowsCommandItem("pathping", "路径ping"));
                commands.add(new WindowsCommandItem("ping", "网络连接测试"));
                commands.add(new WindowsCommandItem("pktmon", "数据包监视器"));
                commands.add(new WindowsCommandItem("route", "路由"));
                commands.add(new WindowsCommandItem("showmount", "显示挂载"));
                commands.add(new WindowsCommandItem("tracert", "路由跟踪"));
                commands.add(new WindowsCommandItem("telnet", "远程登录"));
                commands.add(new WindowsCommandItem("tftp", "简单文件传输协议"));
                break;
            case "registry":
                commands.add(new WindowsCommandItem("reg", "注册表操作"));
                commands.add(new WindowsCommandItem("regedit", "注册表编辑器"));
                commands.add(new WindowsCommandItem("regini", "注册表初始化"));
                commands.add(new WindowsCommandItem("regsvr32", "注册DLL"));
                break;
            case "security":
                commands.add(new WindowsCommandItem("auditpol", "审核策略"));
                commands.add(new WindowsCommandItem("cacls", "显示或修改文件访问控制列表"));
                commands.add(new WindowsCommandItem("cipher", "加密文件"));
                commands.add(new WindowsCommandItem("icacls", "显示或修改文件访问控制列表"));
                commands.add(new WindowsCommandItem("secedit", "安全配置和分析"));
                commands.add(new WindowsCommandItem("sfc", "系统文件检查器"));
                commands.add(new WindowsCommandItem("tlntadmn", "Telnet管理"));
                break;
            case "batch_script":
                commands.add(new WindowsCommandItem("call", "调用批处理文件"));
                commands.add(new WindowsCommandItem("choice", "选择命令"));
                commands.add(new WindowsCommandItem("echo", "显示文本"));
                commands.add(new WindowsCommandItem("for", "循环命令"));
                commands.add(new WindowsCommandItem("if", "条件命令"));
                commands.add(new WindowsCommandItem("goto", "跳转到标签"));
                commands.add(new WindowsCommandItem("pause", "暂停命令"));
                commands.add(new WindowsCommandItem("set", "设置环境变量"));
                commands.add(new WindowsCommandItem("setx", "设置环境变量"));
                commands.add(new WindowsCommandItem("timeout", "延时命令"));
                commands.add(new WindowsCommandItem("exit", "退出命令"));
                commands.add(new WindowsCommandItem("cscript", "命令脚本宿主"));
                commands.add(new WindowsCommandItem("wscript", "Windows脚本宿主"));
                break;
            case "other_tools":
                commands.add(new WindowsCommandItem("call", "调用批处理文件"));
                commands.add(new WindowsCommandItem("cd", "切换目录"));
                commands.add(new WindowsCommandItem("chcp", "更改代码页"));
                commands.add(new WindowsCommandItem("chglogon", "更改登录"));
                commands.add(new WindowsCommandItem("chgport", "更改端口"));
                commands.add(new WindowsCommandItem("chgusr", "更改用户"));
                commands.add(new WindowsCommandItem("clip", "剪贴板"));
                commands.add(new WindowsCommandItem("cls", "清屏"));
                commands.add(new WindowsCommandItem("cmd", "命令提示符"));
                commands.add(new WindowsCommandItem("cmdkey", "凭据管理器"));
                commands.add(new WindowsCommandItem("cmstp", "连接管理器配置文件安装"));
                commands.add(new WindowsCommandItem("color", "设置命令窗口颜色"));
                commands.add(new WindowsCommandItem("comp", "比较文件"));
                commands.add(new WindowsCommandItem("compact", "压缩文件"));
                commands.add(new WindowsCommandItem("date", "显示或设置日期"));
                commands.add(new WindowsCommandItem("diantz", "压缩"));
                commands.add(new WindowsCommandItem("find", "查找文本"));
                commands.add(new WindowsCommandItem("findstr", "查找字符串"));
                commands.add(new WindowsCommandItem("gettype", "获取类型"));
                commands.add(new WindowsCommandItem("gpfixup", "组策略修复"));
                commands.add(new WindowsCommandItem("gpresult", "组策略结果"));
                commands.add(new WindowsCommandItem("gpt", "GUID分区表"));
                commands.add(new WindowsCommandItem("graftabl", " graftabl"));
                commands.add(new WindowsCommandItem("help", "显示帮助"));
                commands.add(new WindowsCommandItem("label", "卷标"));
                commands.add(new WindowsCommandItem("macfile", "Mac文件"));
                commands.add(new WindowsCommandItem("mode", "模式"));
                commands.add(new WindowsCommandItem("mqbkup", "消息队列备份"));
                commands.add(new WindowsCommandItem("mqsvc", "消息队列服务"));
                commands.add(new WindowsCommandItem("mqtgsvc", "消息队列触发器服务"));
                commands.add(new WindowsCommandItem("path", "路径"));
                commands.add(new WindowsCommandItem("prompt", "设置命令提示符"));
                commands.add(new WindowsCommandItem("relog", "重新记录"));
                commands.add(new WindowsCommandItem("shadow", "卷影"));
                commands.add(new WindowsCommandItem("title", "设置命令窗口标题"));
                commands.add(new WindowsCommandItem("time", "显示或设置时间"));
                commands.add(new WindowsCommandItem("ver", "显示Windows版本"));
                commands.add(new WindowsCommandItem("where", "查找文件"));
                commands.add(new WindowsCommandItem("whoami", "显示当前用户"));
                commands.add(new WindowsCommandItem("ftype", "文件类型"));
                commands.add(new WindowsCommandItem("fveupdate", "BitLocker更新"));
                break;
        }
        
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