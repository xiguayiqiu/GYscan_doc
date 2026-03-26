package com.gyscan_doc.Linux;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.gyscan_doc.utils.ScreenUtils;
import com.gyscan_doc.R;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.commonmark.ext.gfm.tables.TablesExtension;
import java.io.IOException;
import java.io.InputStream;

public class CommandDetailActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private WebView webView;
    private String currentCommandName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_command_detail);
        
        ScreenUtils.setupScreen(this);
        
        sharedPreferences = getSharedPreferences("theme_prefs", MODE_PRIVATE);

        setupToolbar();
        loadCommandDetails();
    }

    private void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_white);
        }
        
        ScreenUtils.setupToolbar(toolbar);
    }

    private void loadCommandDetails() {
        Intent intent = getIntent();
        if (intent != null) {
            String commandName = intent.getStringExtra("command_name");
            String description = intent.getStringExtra("command_description");
            
            // 保存当前命令名称
            currentCommandName = commandName;

            webView = findViewById(R.id.command_usage);
            TextView optionsTextView = findViewById(R.id.command_options);

            if (commandName != null) {
                // 加载命令的使用方法和选项说明
                loadCommandUsageAndOptions(commandName, webView, optionsTextView);
                

            }
        }
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
                "html, body { width: 100% !important; margin: 0 !important; padding: 0 !important; background-color: inherit; } " +
                "#write { width: 100% !important; margin: 0 !important; padding: 24px !important; box-sizing: border-box !important; } " +
                "</style>" +
                "</head>" +
                "<body>" +
                "<div id=\"write\">" +
                htmlContent +
                "</div>" +
                "</body>" +
                "</html>";
        
        // 根据主题设置WebView背景色
        if (themeName.equals("dark") || themeName.equals("github-dark") || themeName.startsWith("bit-clean-dark") || themeName.contains("dark")) {
            webView.setBackgroundColor(0xFF2D2D2D);
        } else {
            webView.setBackgroundColor(0xFFFFFFFF);
        }
        
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
        // 符号命令映射
        String mappedCommandName = commandName;
        if (commandName.equals("*") || commandName.equals("?") || commandName.equals("[]") || commandName.equals("[!]") || commandName.equals("[a-z]") || commandName.equals("[0-9]") || commandName.equals("{a,b,c}") || commandName.equals("{1..10}")) {
            mappedCommandName = "wildcard";
        } else if (commandName.equals(">") || commandName.equals(">>") || commandName.equals("<") || commandName.equals("2>") || commandName.equals("2>>") || commandName.equals("&>")) {
            mappedCommandName = "redirection";
        } else if (commandName.equals("|")) {
            mappedCommandName = "pipe";
        } else if (commandName.equals(";")) {
            mappedCommandName = "operators";
        } else if (commandName.equals("&&") || commandName.equals("||") || commandName.equals("!")) {
            mappedCommandName = "operators";
        } else if (commandName.equals("&")) {
            mappedCommandName = "background";
        } else if (commandName.equals("$") || commandName.equals("${}") || commandName.equals("$()") || commandName.equals("`") || commandName.equals("$?") || commandName.equals("$$") || commandName.equals("$!") || commandName.equals("$0") || commandName.equals("$1-$9") || commandName.equals("$#") || commandName.equals("$@") || commandName.equals("$*")) {
            mappedCommandName = "variables";
        } else if (commandName.equals("~") || commandName.equals("-") || commandName.equals("..") || commandName.equals(".") || commandName.equals("/")) {
            mappedCommandName = "directories";
        } else if (commandName.equals("\\") || commandName.equals("'") || commandName.equals("\"") || commandName.equals("\\\\") || commandName.equals("#")) {
            mappedCommandName = "quotes";
        } else if (commandName.equals("!") || commandName.equals("!!") || commandName.equals("!n") || commandName.equals("!string") || commandName.equals("^")) {
            mappedCommandName = "history";
        } else if (commandName.equals("go build") || commandName.equals("go vet") || commandName.equals("go mod") || commandName.equals("go get")) {
            mappedCommandName = "go_commands";
        } else if (commandName.equals("cargo build") || commandName.equals("cargo check") || commandName.equals("cargo test") || commandName.equals("cargo run")) {
            mappedCommandName = "cargo_commands";
        }
        
        // 尝试从不同目录加载Markdown文件
        String[] directories = {"01_文件系统", "01_系统管理", "02_软件包管理", "02_进程管理", "03_网络工具", "04_shell环境", "04_系统管理", "05_压缩归档", "05_文件管理", "05_用户管理", "06_压缩备份", "06_用户和组", "07_文本处理", "08_存储管理", "08_磁盘管理", "09_搜索过滤", "09_软件管理", "10_网络安全", "10_进程管理", "11_安全相关", "11_硬件内核", "11_系统监控", "12_编程开发", "12_安全加密", "12_压缩解压", "13_时间日期", "14_符号命令", "14_网络诊断", "15_系统配置", "16_终端控制台", "16_文件传输", "17_系统工具", "18_其他命令", "19_Arch工具", "20_其他发行版", "advanced_penetration"};
        
        for (String directory : directories) {
            String filePath = directory + "/" + mappedCommandName + ".md";
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
        } else if (id == R.id.theme_dark) {
            saveThemePreference("dark");
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
        } else if (id == R.id.theme_bit_clean_dark) {
            saveThemePreference("bit-clean-dark");
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
        } else if (id == R.id.theme_phycat_dark) {
            saveThemePreference("phycat/phycat/phycat.dark");
            reloadContent();
            return true;
        } else if (id == R.id.theme_github_dark) {
            saveThemePreference("github-dark");
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
            loadCommandDetails();
        }
    }
}