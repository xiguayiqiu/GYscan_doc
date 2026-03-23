package com.gyscan_doc.CyberSecurity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;
import android.webkit.WebView;
import androidx.appcompat.app.AppCompatActivity;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.commonmark.ext.gfm.tables.TablesExtension;
import java.util.Collections;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import com.gyscan_doc.R;

public class SecurityCommandDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_command_detail);

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

        setupToolbar(commandName);
        displayCommandDetails(commandName, commandDescription);
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

    private void displayCommandDetails(String commandName, String commandDescription) {
        WebView webView = findViewById(R.id.command_usage);
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
                
                // 构建完整的HTML页面
                String fullHtml = "<!DOCTYPE html>" +
                        "<html>" +
                        "<head>" +
                        "<meta charset=\"UTF-8\">" +
                        "<style>" +
                        "body { font-family: sans-serif; line-height: 1.4; padding: 12px; background-color: #f5f5f5; color: #333333; font-size: 14px; }" +
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
                        "a:hover { text-decoration: underline; }" +
                        "@media (prefers-color-scheme: dark) {" +
                        "  body { background-color: #2D2D2D; color: #e0e0e0; }" +
                        "  h1 { color: #fff; }" +
                        "  h2 { color: #ddd; }" +
                        "  h3 { color: #ccc; }" +
                        "  pre { background-color: #2D2D2D; padding: 16px; border-radius: 8px; overflow-x: auto; margin-bottom: 18px; font-size: 16px; border: 1px solid #3e4451; box-shadow: 0 2px 8px rgba(0,0,0,0.3); }" +
                        "  code { font-family: 'Monaco', 'Menlo', 'Ubuntu Mono', monospace; font-size: 15px; color: #abb2bf; line-height: 1.6; }" +
                        "  pre code { background-color: transparent; padding: 0; border-radius: 0; border: none; box-shadow: none; }" +
                        "  hr { border-top-color: #333; }" +
                        "  a { color: #42a5f5; }" +
                        "}" +
                        "</style>" +
                        "</head>" +
                        "<body>" +
                        htmlContent +
                        "</body>" +
                        "</html>";
                
                // 显示HTML内容
                usageWebView.loadDataWithBaseURL(null, fullHtml, "text/html", "UTF-8", null);
            } catch (Exception e) {
                // 如果Markdown解析失败，显示错误信息
                String errorHtml = "<!DOCTYPE html>" +
                        "<html>" +
                        "<head>" +
                        "<meta charset=\"UTF-8\">" +
                        "<style>" +
                        "body { font-family: sans-serif; line-height: 1.6; padding: 20px; background-color: #ffffff; color: #333333; }" +
                        "@media (prefers-color-scheme: dark) {" +
                        "  body { background-color: #121212; color: #e0e0e0; }" +
                        "}" +
                        "</style>" +
                        "</head>" +
                        "<body>" +
                        "<p>命令说明信息解析失败</p>" +
                        "</body>" +
                        "</html>";
                usageWebView.loadDataWithBaseURL(null, errorHtml, "text/html", "UTF-8", null);
            }
        } else {
            // 如果没有找到Markdown文件，显示默认信息
            String defaultHtml = "<!DOCTYPE html>" +
                    "<html>" +
                    "<head>" +
                    "<meta charset=\"UTF-8\">" +
                    "<style>" +
                     "body { font-family: sans-serif; line-height: 1.6; padding: 20px; background-color: #ffffff; color: #333333; }" +
                    "@media (prefers-color-scheme: dark) {" +
                    "  body { background-color: #121212; color: #e0e0e0; }" +
                    "}" +
                    "</style>" +
                    "</head>" +
                    "<body>" +
                    "<p>暂无命令说明信息</p>" +
                    "</body>" +
                    "</html>";
            usageWebView.loadDataWithBaseURL(null, defaultHtml, "text/html", "UTF-8", null);
        }
        
        // 清空optionsTextView，因为所有信息都在usageWebView中显示
        optionsTextView.setText("");
    }
    
    private String loadMarkdownFromAssets(String commandName) {
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
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}