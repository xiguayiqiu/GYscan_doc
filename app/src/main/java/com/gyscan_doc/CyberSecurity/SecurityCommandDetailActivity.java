package com.gyscan_doc.CyberSecurity;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.webkit.WebView;
import com.gyscan_doc.utils.ScreenUtils;
import com.gyscan_doc.R;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.commonmark.ext.gfm.tables.TablesExtension;
import java.io.IOException;
import java.io.InputStream;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

public class SecurityCommandDetailActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private WebView webView;
    private String currentCommandName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_command_detail);
        
        // 初始化SharedPreferences
        sharedPreferences = getSharedPreferences("theme_prefs", MODE_PRIVATE);

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

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            Window window = getWindow();
            WindowManager.LayoutParams layoutParams = window.getAttributes();
            layoutParams.layoutInDisplayCutoutMode = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES;
            window.setAttributes(layoutParams);
        }

        String commandName = getIntent().getStringExtra("command_name");
        String commandDescription = getIntent().getStringExtra("command_description");
        
        // 检查commandName是否为null
        if (commandName == null) {
            // 如果commandName为null，设置默认值
            commandName = "未知命令";
        }
        
        // 保存当前命令名称
        currentCommandName = commandName;

        setupToolbar(commandName);
        displayCommandDetails(commandName, commandDescription);
        

    }

    private void setupToolbar(String title) {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(title);
            // 强制设置导航图标为白色
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_white);
        }
        
        // 确保所有按钮（返回按钮和菜单按钮）都是白色的
        ScreenUtils.setupToolbar(toolbar);
    }

    private void displayCommandDetails(String commandName, String commandDescription) {
        webView = findViewById(R.id.command_usage);
        TextView optionsTextView = findViewById(R.id.command_options);

        // 加载命令的使用方法和选项说明
        loadCommandUsageAndOptions(commandName, webView, optionsTextView);
    }

    private void loadCommandUsageAndOptions(String commandName, WebView usageWebView, TextView optionsTextView) {
        // 从assets目录加载Markdown文件
        String markdownContent = loadMarkdownFromAssets(commandName);
        
        // 如果找到Markdown文件，转换为HTML并显示
        if (markdownContent != null) {
            try {
                String htmlContent = convertMarkdownToHtml(markdownContent);
                loadHtmlContent(usageWebView, htmlContent);
            } catch (Exception e) {
                // 如果Markdown解析失败，显示错误信息
                loadHtmlContent(usageWebView, "<p>命令说明信息解析失败</p>");
            }
        } else {
            // 如果没有找到Markdown文件，显示默认信息
            loadHtmlContent(usageWebView, "<p>暂无命令说明信息</p>");
        }
        
        // 清空optionsTextView，因为所有信息都在usageWebView中显示
        optionsTextView.setText("");
    }
    
    private void loadHtmlContent(WebView webView, String htmlContent) {
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        
        // 从SharedPreferences获取用户设置的主题，默认使用light主题
        String themeName = sharedPreferences.getString("theme", "light");
        String css = loadThemeCss(themeName);
        
        // 确定基础URL，用于加载字体文件
        String baseUrl = "file:///android_asset/";
        
        // 处理phycat主题的特殊路径
        if (themeName.startsWith("phycat/")) {
            // 提取phycat主题的路径部分
            int lastSlashIndex = themeName.lastIndexOf("/");
            if (lastSlashIndex != -1) {
                String phycatPath = themeName.substring(0, lastSlashIndex + 1);
                baseUrl = "file:///android_asset/themes/" + phycatPath;
            }
        }
        
        String fullHtml = "<!DOCTYPE html>" +
                "<html>" +
                "<head>" +
                "<meta charset=\"UTF-8\">" +
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\">" +
                "<style>" +
                css +
                "html, body { width: 100% !important; margin: 0 !important; padding: 0 !important; background-color: inherit; color: inherit; } " +
                "#write { width: 100% !important; margin: 0 !important; padding: 24px !important; box-sizing: border-box !important; } " +
                "* { color: inherit !important; } " +
                "</style>" +
                "</head>" +
                "<body>" +
                "<div id=\"write\">" +
                htmlContent +
                "</div>" +
                "</body>" +
                "</html>";
        
        // 设置WebView背景色为白色
        webView.setBackgroundColor(0xFFFFFFFF);
        
        webView.loadDataWithBaseURL(baseUrl, fullHtml, "text/html", "UTF-8", null);
    }
    
    private String loadThemeCss(String themeName) {
        try {
            // 检查themeName是否已经包含.css后缀
            String cssPath;
            if (themeName.endsWith(".css")) {
                cssPath = "themes/" + themeName;
            } else {
                cssPath = "themes/" + themeName + ".css";
            }
            InputStream inputStream = getAssets().open(cssPath);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            return new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            // 返回默认CSS
            return getDefaultCss();
        }
    }
    
    private String getDefaultCss() {
        return "body { font-family: sans-serif; line-height: 1.4; padding: 12px; background-color: #f5f5f5; color: #333333; font-size: 14px; }" +
                "h1 { color: #333; font-size: 18px; margin-bottom: 12px; }" +
                "h2 { color: #555; font-size: 16px; margin-top: 16px; margin-bottom: 12px; }" +
                "h3 { color: #777; font-size: 14px; margin-top: 12px; margin-bottom: 8px; }" +
                "p { margin-bottom: 12px; }" +
                "pre { background-color: #f8f9fa; padding: 16px; border-radius: 8px; overflow-x: auto; margin-bottom: 18px; font-size: 16px; border: 1px solid #e9ecef; box-shadow: 0 2px 4px rgba(0,0,0,0.05); }" +
                "code { font-family: 'Monaco', 'Menlo', 'Ubuntu Mono', monospace; font-size: 15px; color: #333; line-height: 1.6; }" +
                "pre code { background-color: transparent; padding: 0; border-radius: 0; border: none; box-shadow: none; }" +
                "ul { margin-bottom: 12px; padding-left: 24px; }" +
                "ol { margin-bottom: 12px; padding-left: 24px; }" +
                "li { margin-bottom: 6px; }" +
                "hr { margin: 20px 0; border: 0; border-top: 1px solid #eee; }" +
                "strong { font-weight: bold; }" +
                "em { font-style: italic; }" +
                "a { color: #1976D2; text-decoration: none; }" +
                "a:hover { text-decoration: underline; }";
    }
    
    private String loadMarkdownFromAssets(String commandName) {
        // 检查commandName是否为null
        if (commandName == null) {
            return null;
        }
        
        // 尝试从不同目录加载Markdown文件
        String[] directories = {"Linuxsec/reverse_engineering", "Linuxsec/network_scanning", "Linuxsec/packet_capture", "Linuxsec/penetration_framework", "Linuxsec/log_analysis", "Linuxsec/vulnerability_analysis", "Linuxsec/database_analysis", "Linuxsec/password_attack", "Linuxsec/wireless_attack", "Linuxsec/exploitation", "Linuxsec/forensics", "Linuxsec/reporting_tools", "Linuxsec/social_engineering", "Linuxsec/password_generation"};
        
        for (String directory : directories) {
            String filePath = directory + "/" + commandName + ".md";
            try {
                // 打开assets文件输入流
                java.io.InputStream inputStream = getAssets().open(filePath);
                // 读取文件内容
                java.io.BufferedReader reader = new java.io.BufferedReader(
                        new java.io.InputStreamReader(inputStream, "UTF-8"));
                StringBuilder content = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    content.append(line).append("\n");
                }
                reader.close();
                inputStream.close();
                return content.toString();
            } catch (Exception e) {
                // 文件不存在，继续尝试其他目录
            }
        }
        return null;
    }
    
    private String convertMarkdownToHtml(String markdown) {
        // 使用commonmark-java将Markdown转换为HTML，添加对GFM表格的支持
        java.util.List<org.commonmark.Extension> extensions = java.util.Collections.singletonList(TablesExtension.create());
        Parser parser = Parser.builder()
                .extensions(extensions)
                .build();
        Node document = parser.parse(markdown);
        HtmlRenderer renderer = HtmlRenderer.builder()
                .extensions(extensions)
                .build();
        return renderer.render(document);
    }

    private String getCommandSyntax(String commandName) {
        switch (commandName) {
            case "nmap":
                return "nmap [options] target";
            case "tcpdump":
                return "tcpdump [options] [filter]";
            case "metasploit":
                return "msfconsole";
            case "grep":
                return "grep [options] pattern [file...]";
            case "objdump":
                return "objdump [options] file";
            case "readelf":
                return "readelf [options] file";
            case "strings":
                return "strings [options] file";
            case "ltrace":
                return "ltrace [options] command";
            case "strace":
                return "strace [options] command";
            case "gdb":
                return "gdb [options] executable";
            case "radare2":
                return "r2 [options] file";
            case "netdiscover":
                return "netdiscover [options]";
            case "arp-scan":
                return "arp-scan [options] network";
            case "masscan":
                return "masscan [options] target";
            case "hping3":
                return "hping3 [options] target";
            case "wireshark":
                return "wireshark [options]";
            case "tshark":
                return "tshark [options] [filter]";
            case "ngrep":
                return "ngrep [options] pattern [interface]";
            case "ettercap":
                return "ettercap [options]";
            case "sqlmap":
                return "sqlmap [options]";
            case "hydra":
                return "hydra [options] target service";
            case "john":
                return "john [options] file";
            case "aircrack-ng":
                return "aircrack-ng [options] file";
            case "openssl":
                return "openssl command [options]";
            case "hashcat":
                return "hashcat [options] hash file";
            case "awk":
                return "awk [options] 'program' file";
            case "sed":
                return "sed [options] 'command' file";
            case "tail":
                return "tail [options] file";
            case "head":
                return "head [options] file";
            case "journalctl":
                return "journalctl [options]";
            default:
                return commandName + " [options]";
        }
    }

    private String getCommandExample(String commandName) {
        switch (commandName) {
            case "nmap":
                return "nmap -sV 192.168.1.1\nnmap -A -T4 192.168.1.0/24";
            case "tcpdump":
                return "tcpdump -i eth0 port 80\ntcpdump -w capture.pcap host 192.168.1.1";
            case "metasploit":
                return "msfconsole\nuse exploit/multi/handler\nset payload windows/meterpreter/reverse_tcp";
            case "grep":
                return "grep 'error' /var/log/syslog\ngrep -r 'password' /etc";
            case "objdump":
                return "objdump -d /bin/ls\nobjdump -t /bin/ls";
            case "readelf":
                return "readelf -a /bin/ls\nreadelf -l /bin/ls";
            case "strings":
                return "strings /bin/ls\nstrings -n 8 /bin/ls";
            case "ltrace":
                return "ltrace ls\nltrace -f ls";
            case "strace":
                return "strace ls\nstrace -f -e open ls";
            case "gdb":
                return "gdb /bin/ls\ngdb -p 1234";
            case "radare2":
                return "r2 /bin/ls\nr2 -A /bin/ls";
            case "netdiscover":
                return "netdiscover -r 192.168.1.0/24";
            case "arp-scan":
                return "arp-scan 192.168.1.0/24";
            case "masscan":
                return "masscan 192.168.1.0/24 -p 1-65535";
            case "hping3":
                return "hping3 -S 192.168.1.1 -p 80";
            case "wireshark":
                return "wireshark\nwireshark -i eth0";
            case "tshark":
                return "tshark -i eth0 -f 'port 80'";
            case "ngrep":
                return "ngrep 'GET' port 80";
            case "ettercap":
                return "ettercap -Tq -i eth0";
            case "sqlmap":
                return "sqlmap -u 'http://example.com/page.php?id=1'\nsqlmap -u 'http://example.com/page.php?id=1' --dbs";
            case "hydra":
                return "hydra -l admin -P passwords.txt 192.168.1.1 ssh";
            case "john":
                return "john password_hash.txt\njohn --wordlist=rockyou.txt password_hash.txt";
            case "aircrack-ng":
                return "aircrack-ng capture.cap -w wordlist.txt";
            case "openssl":
                return "openssl genrsa -out private.key 2048\nopenssl req -new -key private.key -out certificate.csr";
            case "hashcat":
                return "hashcat -m 0 -a 0 hash.txt wordlist.txt";
            case "awk":
                return "awk '{print $1}' file.txt\nawk '/error/ {print $0}' /var/log/syslog";
            case "sed":
                return "sed 's/old/new/g' file.txt\nsed '/^#/d' file.txt";
            case "tail":
                return "tail -f /var/log/syslog\ntail -n 100 /var/log/syslog";
            case "head":
                return "head -n 10 file.txt";
            case "journalctl":
                return "journalctl -u ssh\njournalctl --since '1 hour ago'";
            default:
                return commandName + " [example usage]";
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.theme_menu, menu);
        
        // 确保菜单按钮是白色的（使用post确保按钮已添加到视图中）
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.post(new Runnable() {
            @Override
            public void run() {
                ScreenUtils.setupToolbar(toolbar);
            }
        });
        
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        
        if (id == android.R.id.home) {
            finish();
            return true;
        } else if (id == R.id.theme_light) {
            saveThemePreference("light");
            reloadContent();
            return true;
        } else if (id == R.id.theme_github) {
            saveThemePreference("github");
            reloadContent();
            return true;
        } else if (id == R.id.theme_manifest) {
            saveThemePreference("manifest");
            reloadContent();
            return true;
        } else if (id == R.id.theme_bit_clean_light) {
            saveThemePreference("bit-clean-light");
            reloadContent();
            return true;
        } else if (id == R.id.theme_rose) {
            saveThemePreference("rose");
            reloadContent();
            return true;
        } else if (id == R.id.theme_phycat_light) {
            saveThemePreference("phycat/phycat/phycat.light");
            reloadContent();
            return true;
        }
        
        return super.onOptionsItemSelected(item);
    }
    
    private void saveThemePreference(String themeName) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("theme", themeName);
        editor.apply();
    }
    
    private void reloadContent() {
        // 重新加载当前内容以应用新主题
        if (currentCommandName != null) {
            displayCommandDetails(currentCommandName, "");
        }
    }
}