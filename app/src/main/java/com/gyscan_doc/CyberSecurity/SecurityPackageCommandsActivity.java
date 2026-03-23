package com.gyscan_doc.CyberSecurity;

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

public class SecurityPackageCommandsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SecurityCommandListAdapter adapter;
    private String packageName;
    private EditText searchEditText;
    private ImageButton clearButton;
    private List<SecurityCommandItem> allCommands;
    private List<SecurityCommandItem> filteredCommands;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package_commands);

        // 设置状态栏颜色适配深色/浅色模式
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            int statusBarColor;
            int currentNightMode = getResources().getConfiguration().uiMode & android.content.res.Configuration.UI_MODE_NIGHT_MASK;
            if (currentNightMode == android.content.res.Configuration.UI_MODE_NIGHT_YES) {
                statusBarColor = ContextCompat.getColor(this, R.color.dark_theme_dark_blue);
            } else {
                statusBarColor = ContextCompat.getColor(this, R.color.theme_dark_blue);
            }
            window.setStatusBarColor(statusBarColor);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                int flags = window.getDecorView().getSystemUiVisibility();
                flags &= ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
                window.getDecorView().setSystemUiVisibility(flags);
            } else {
                window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
            }
        }

        // 适配刘海屏
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
        setupSearchView();
    }

    private void setupToolbar(String title) {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(title);
        }

        // 强制设置返回按钮颜色为白色
        for (int i = 0; i < toolbar.getChildCount(); i++) {
            View child = toolbar.getChildAt(i);
            if (child instanceof ImageButton) {
                ImageButton menuButton = (ImageButton) child;
                menuButton.setColorFilter(Color.WHITE, android.graphics.PorterDuff.Mode.SRC_ATOP);
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
        adapter = new SecurityCommandListAdapter(filteredCommands, this::onCommandClick);
        recyclerView.setAdapter(adapter);
    }

    private void setupSearchView() {
        searchEditText = findViewById(R.id.searchEditText);
        clearButton = findViewById(R.id.clearButton);

        searchEditText.addTextChangedListener(new android.text.TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filterCommands(s.toString());
                clearButton.setVisibility(s.length() > 0 ? View.VISIBLE : View.GONE);
            }

            @Override
            public void afterTextChanged(android.text.Editable s) {}
        });

        clearButton.setOnClickListener(v -> searchEditText.setText(""));
    }

    private void filterCommands(String query) {
        filteredCommands.clear();

        if (query == null || query.trim().isEmpty()) {
            filteredCommands.addAll(allCommands);
        } else {
            String lowerQuery = query.toLowerCase().trim();
            for (SecurityCommandItem command : allCommands) {
                if (command.getName().toLowerCase().contains(lowerQuery) ||
                        command.getDescription().toLowerCase().contains(lowerQuery)) {
                    filteredCommands.add(command);
                }
            }
        }

        adapter.notifyDataSetChanged();
    }

    private void onCommandClick(SecurityCommandItem command) {
        Intent intent = new Intent(this, SecurityCommandDetailActivity.class);
        intent.putExtra("command_name", command.getName());
        intent.putExtra("command_description", command.getDescription());
        startActivity(intent);
    }

    private List<SecurityCommandItem> getCommandsForPackage(String packageName) {
        List<SecurityCommandItem> commands = new ArrayList<>();

        switch (packageName) {
            case "reverse_engineering":
                commands.addAll(createReverseEngineeringCommands());
                break;
            case "network_scanning":
                commands.addAll(createNetworkScanningCommands());
                break;
            case "packet_capture":
                commands.addAll(createPacketCaptureCommands());
                break;
            case "penetration_framework":
                commands.addAll(createPenetrationFrameworkCommands());
                break;
            case "log_analysis":
                commands.addAll(createLogAnalysisCommands());
                break;
            case "vulnerability_analysis":
                commands.addAll(createVulnerabilityAnalysisCommands());
                break;
            case "database_analysis":
                commands.addAll(createDatabaseAnalysisCommands());
                break;
            case "password_attack":
                commands.addAll(createPasswordAttackCommands());
                break;
            case "wireless_attack":
                commands.addAll(createWirelessAttackCommands());
                break;
            case "exploitation":
                commands.addAll(createExploitationCommands());
                break;
            case "forensics":
                commands.addAll(createForensicsCommands());
                break;
            case "reporting_tools":
                commands.addAll(createReportingToolsCommands());
                break;
            case "social_engineering":
                commands.addAll(createSocialEngineeringCommands());
                break;
            case "password_generation":
                commands.addAll(createPasswordGenerationCommands());
                break;
        }

        return commands;
    }

    private List<SecurityCommandItem> createReverseEngineeringCommands() {
        List<SecurityCommandItem> commands = new ArrayList<>();
        commands.add(new SecurityCommandItem("objdump", "目标文件反汇编工具"));
        commands.add(new SecurityCommandItem("readelf", "ELF文件信息查看工具"));
        commands.add(new SecurityCommandItem("strings", "提取可执行文件中的可读字符串"));
        commands.add(new SecurityCommandItem("ltrace", "库函数调用跟踪工具"));
        commands.add(new SecurityCommandItem("strace", "系统调用跟踪工具"));
        commands.add(new SecurityCommandItem("gdb", "GNU调试器"));
        commands.add(new SecurityCommandItem("radare2", "逆向工程框架"));
        commands.add(new SecurityCommandItem("objcopy", "目标文件复制与转换工具"));
        commands.add(new SecurityCommandItem("nm", "列出目标文件中的符号"));
        commands.add(new SecurityCommandItem("addr2line", "将地址转换为文件名和行号"));
        return commands;
    }

    private List<SecurityCommandItem> createNetworkScanningCommands() {
        List<SecurityCommandItem> commands = new ArrayList<>();
        commands.add(new SecurityCommandItem("nmap", "网络探测和安全扫描工具"));
        commands.add(new SecurityCommandItem("netdiscover", "ARP网络发现工具"));
        commands.add(new SecurityCommandItem("arp-scan", "本地网络ARP扫描工具"));
        commands.add(new SecurityCommandItem("masscan", "高速端口扫描器"));
        commands.add(new SecurityCommandItem("hping3", "TCP/IP数据包组装和分析工具"));
        commands.add(new SecurityCommandItem("zmap", "高速网络扫描器"));
        commands.add(new SecurityCommandItem("unicornscan", "异步网络扫描器"));
        commands.add(new SecurityCommandItem("amap", "应用协议映射工具"));
        return commands;
    }

    private List<SecurityCommandItem> createPacketCaptureCommands() {
        List<SecurityCommandItem> commands = new ArrayList<>();
        commands.add(new SecurityCommandItem("tcpdump", "命令行网络数据包分析器"));
        commands.add(new SecurityCommandItem("wireshark", "图形化网络协议分析器"));
        commands.add(new SecurityCommandItem("tshark", "Wireshark的命令行版本"));
        commands.add(new SecurityCommandItem("ngrep", "网络grep工具，匹配数据包内容"));
        commands.add(new SecurityCommandItem("ettercap", "局域网嗅探和中间人攻击工具"));
        commands.add(new SecurityCommandItem("tcpflow", "TCP数据流记录和分析工具"));
        commands.add(new SecurityCommandItem("dumpcap", "轻量级数据包捕获工具"));
        return commands;
    }

    private List<SecurityCommandItem> createPenetrationFrameworkCommands() {
        List<SecurityCommandItem> commands = new ArrayList<>();
        commands.add(new SecurityCommandItem("metasploit", "渗透测试框架"));
        commands.add(new SecurityCommandItem("sqlmap", "自动化SQL注入工具"));
        commands.add(new SecurityCommandItem("hydra", "网络登录暴力破解工具"));
        commands.add(new SecurityCommandItem("john", "John the Ripper密码破解工具"));
        commands.add(new SecurityCommandItem("aircrack-ng", "无线网络评估工具套件"));
        commands.add(new SecurityCommandItem("burpsuite", "Web应用安全测试平台"));
        commands.add(new SecurityCommandItem("ncat", "功能强大的网络连接器"));
        commands.add(new SecurityCommandItem("openssl", "加密工具包"));
        commands.add(new SecurityCommandItem("hashcat", "高性能密码哈希恢复工具"));
        return commands;
    }

    private List<SecurityCommandItem> createLogAnalysisCommands() {
        List<SecurityCommandItem> commands = new ArrayList<>();
        commands.add(new SecurityCommandItem("grep", "文本搜索工具"));
        commands.add(new SecurityCommandItem("awk", "文本处理和数据分析语言"));
        commands.add(new SecurityCommandItem("tail", "查看文件末尾内容"));
        commands.add(new SecurityCommandItem("head", "查看文件开头内容"));
        commands.add(new SecurityCommandItem("less", "分页文件查看器"));
        commands.add(new SecurityCommandItem("more", "分页文件查看器"));
        commands.add(new SecurityCommandItem("journalctl", "systemd日志查询工具"));
        commands.add(new SecurityCommandItem("logwatch", "日志分析和报告工具"));
        commands.add(new SecurityCommandItem("logrotate", "日志轮转管理工具"));
        return commands;
    }

    private List<SecurityCommandItem> createVulnerabilityAnalysisCommands() {
        List<SecurityCommandItem> commands = new ArrayList<>();
        commands.add(new SecurityCommandItem("nmap", "网络扫描与漏洞探测"));
        commands.add(new SecurityCommandItem("openvas", "全功能漏洞扫描器"));
        commands.add(new SecurityCommandItem("nikto", "Web服务器漏洞扫描工具"));
        commands.add(new SecurityCommandItem("owasp-zap", "Web应用安全扫描器"));
        commands.add(new SecurityCommandItem("golismero", "安全测试框架"));
        return commands;
    }

    private List<SecurityCommandItem> createDatabaseAnalysisCommands() {
        List<SecurityCommandItem> commands = new ArrayList<>();
        commands.add(new SecurityCommandItem("sqlmap", "数据库注入自动化工具"));
        commands.add(new SecurityCommandItem("jsql-injection", "图形化SQL注入工具"));
        commands.add(new SecurityCommandItem("sqlninja", "SQL Server渗透测试工具"));
        commands.add(new SecurityCommandItem("commix", "命令注入自动化测试工具"));
        commands.add(new SecurityCommandItem("mysqldump", "MySQL数据库备份工具"));
        commands.add(new SecurityCommandItem("pg_dump", "PostgreSQL数据库备份工具"));
        commands.add(new SecurityCommandItem("oracle-db-tools", "Oracle数据库工具集"));
        commands.add(new SecurityCommandItem("nosqlmap", "NoSQL数据库注入工具"));
        return commands;
    }

    private List<SecurityCommandItem> createPasswordAttackCommands() {
        List<SecurityCommandItem> commands = new ArrayList<>();
        commands.add(new SecurityCommandItem("john", "John the Ripper密码破解工具"));
        commands.add(new SecurityCommandItem("hashcat", "GPU加速密码哈希破解工具"));
        commands.add(new SecurityCommandItem("hydra", "在线网络服务暴力破解工具"));
        commands.add(new SecurityCommandItem("medusa", "并行远程暴力破解工具"));
        commands.add(new SecurityCommandItem("crackmapexec", "内网渗透测试自动化神器"));
        return commands;
    }

    private List<SecurityCommandItem> createWirelessAttackCommands() {
        List<SecurityCommandItem> commands = new ArrayList<>();
        commands.add(new SecurityCommandItem("airmon-ng", "无线网卡模式管理工具"));
        commands.add(new SecurityCommandItem("airodump-ng", "无线数据包捕获工具"));
        commands.add(new SecurityCommandItem("aireplay-ng", "无线数据包注入工具"));
        commands.add(new SecurityCommandItem("aircrack-ng", "WiFi密钥破解套件"));
        commands.add(new SecurityCommandItem("airdecap-ng", "无线数据包解密工具"));
        commands.add(new SecurityCommandItem("airbase-ng", "无线接入点模拟工具"));
        commands.add(new SecurityCommandItem("airolib-ng", "无线密码库管理工具"));
        commands.add(new SecurityCommandItem("packetforge-ng", "无线数据包伪造工具"));
        commands.add(new SecurityCommandItem("buddy-ng", "无线客户端模拟工具"));
        commands.add(new SecurityCommandItem("airdecloak-ng", "无线数据包去重工具"));
        commands.add(new SecurityCommandItem("tkiptun-ng", "TKIP破解工具"));
        commands.add(new SecurityCommandItem("easside-ng", "无线客户端攻击工具"));
        commands.add(new SecurityCommandItem("wesside-ng", "WPA破解工具"));
        commands.add(new SecurityCommandItem("airtun-ng", "无线隧道工具"));
        commands.add(new SecurityCommandItem("airngress-ng", "无线入侵检测工具"));
        commands.add(new SecurityCommandItem("kismet", "无线网络探测器和嗅探器"));
        commands.add(new SecurityCommandItem("reaver", "WPS PIN码暴力破解工具"));
        commands.add(new SecurityCommandItem("fern-wifi-cracker", "WiFi自动攻击工具"));
        commands.add(new SecurityCommandItem("wifi-pumpkin", "WiFi恶意热点框架"));
        return commands;
    }

    private List<SecurityCommandItem> createExploitationCommands() {
        List<SecurityCommandItem> commands = new ArrayList<>();
        commands.add(new SecurityCommandItem("metasploit", "综合渗透测试框架"));
        commands.add(new SecurityCommandItem("msfconsole", "Metasploit控制台接口"));
        commands.add(new SecurityCommandItem("exploitdb", "公开漏洞利用代码库"));
        commands.add(new SecurityCommandItem("searchsploit", "ExploitDB离线搜索工具"));
        commands.add(new SecurityCommandItem("beef", "浏览器端攻击框架"));
        return commands;
    }

    private List<SecurityCommandItem> createForensicsCommands() {
        List<SecurityCommandItem> commands = new ArrayList<>();
        commands.add(new SecurityCommandItem("autopsy", "数字取证分析平台"));
        commands.add(new SecurityCommandItem("sleuthkit", "数字取证工具库"));
        commands.add(new SecurityCommandItem("foremost", "文件恢复工具"));
        commands.add(new SecurityCommandItem("scalpel", "高效文件恢复工具"));
        commands.add(new SecurityCommandItem("volatility", "内存取证分析框架"));
        return commands;
    }

    private List<SecurityCommandItem> createReportingToolsCommands() {
        List<SecurityCommandItem> commands = new ArrayList<>();
        commands.add(new SecurityCommandItem("dradis", "协作与报告框架"));
        commands.add(new SecurityCommandItem("faraday", "协同渗透测试平台"));
        commands.add(new SecurityCommandItem("burpsuite", "Web安全测试与报告"));
        commands.add(new SecurityCommandItem("nikto", "Web扫描报告生成"));
        commands.add(new SecurityCommandItem("openvas", "漏洞扫描报告工具"));
        return commands;
    }

    private List<SecurityCommandItem> createSocialEngineeringCommands() {
        List<SecurityCommandItem> commands = new ArrayList<>();
        commands.add(new SecurityCommandItem("setoolkit", "社会工程学攻击工具箱"));
        commands.add(new SecurityCommandItem("gophish", "钓鱼邮件模拟平台"));
        commands.add(new SecurityCommandItem("beef", "浏览器端社会工程学利用"));
        commands.add(new SecurityCommandItem("metasploit", "社工模块集成框架"));
        commands.add(new SecurityCommandItem("responder", "LLMNR/NBT-NS毒化与凭证窃取"));
        return commands;
    }

    private List<SecurityCommandItem> createPasswordGenerationCommands() {
        List<SecurityCommandItem> commands = new ArrayList<>();
        commands.add(new SecurityCommandItem("pwgen", "随机密码生成工具"));
        commands.add(new SecurityCommandItem("openssl", "加密及密码生成工具"));
        commands.add(new SecurityCommandItem("mkpasswd", "密码及哈希生成工具"));
        commands.add(new SecurityCommandItem("cupp", "基于用户信息的字典生成工具"));
        commands.add(new SecurityCommandItem("crunch", "密码字典生成工具"));
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