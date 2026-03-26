package com.gyscan_doc.Security;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import com.gyscan_doc.utils.ScreenUtils;
import com.gyscan_doc.R;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.commonmark.ext.gfm.tables.TablesExtension;

import java.io.IOException;
import java.io.InputStream;

public class AdvancedPenetrationDetailActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_security_basics_detail);
        
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

        setupToolbar();
        loadContent();
    }

    private void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            // 强制设置导航图标为白色
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_white);
        }
        
        // 确保所有按钮（返回按钮和菜单按钮）都是白色的
        ScreenUtils.setupToolbar(toolbar);
    }

    private void loadContent() {
        webView = findViewById(R.id.command_usage);
        
        String topic = getIntent().getStringExtra("topic");
        String title = "网络安全高级技巧";
        
        if (topic != null) {
            switch (topic) {
                case "advanced_reconnaissance":
                    title = "高级信息收集与侦察";
                    loadMarkdownContent("advanced_reconnaissance.md");
                    break;
                case "web_exploitation":
                    title = "Web应用高级漏洞利用";
                    loadMarkdownContent("web_exploitation.md");
                    break;
                case "internal_network":
                    title = "内网渗透与横向移动";
                    loadMarkdownContent("internal_network.md");
                    break;
                case "evasion_techniques":
                    title = "防御绕过技术";
                    loadMarkdownContent("evasion_techniques.md");
                    break;
                case "cloud_native":
                    title = "云原生与容器安全";
                    loadMarkdownContent("cloud_native.md");
                    break;
                case "automation_ai":
                    title = "自动化与AI辅助渗透";
                    loadMarkdownContent("automation_ai.md");
                    break;
                case "physical_social":
                    title = "物理与社会工程学";
                    loadMarkdownContent("physical_social.md");
                    break;
                case "reporting_compliance":
                    title = "报告与合规";
                    loadMarkdownContent("reporting_compliance.md");
                    break;
                default:
                    String defaultContent = "高级渗透分类涵盖了白帽工程师所需的各种高级渗透技巧和方法。本课程将深入探讨信息收集、Web应用漏洞利用、内网渗透、防御绕过、云原生安全等高级渗透技术。";
                    loadHtmlContent(defaultContent);
                    break;
            }
        } else {
            String defaultContent = "高级渗透分类涵盖了白帽工程师所需的各种高级渗透技巧和方法。本课程将深入探讨信息收集、Web应用漏洞利用、内网渗透、防御绕过、云原生安全等高级渗透技术。";
            loadHtmlContent(defaultContent);
        }
        

    }
    
    private void loadMarkdownContent(String fileName) {
        try {
            InputStream inputStream = getAssets().open("advanced_penetration/" + fileName);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            String markdownContent = new String(buffer, "UTF-8");
            String htmlContent = convertMarkdownToHtml(markdownContent);
            loadHtmlContent(htmlContent);
        } catch (IOException e) {
            e.printStackTrace();
            loadHtmlContent("加载内容失败，请检查文件是否存在。");
        }
    }

    private void loadHtmlContent(String htmlContent) {
        if (webView == null) {
            webView = findViewById(R.id.command_usage);
        }
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

    private String convertMarkdownToHtml(String markdown) {
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
        String topic = getIntent().getStringExtra("topic");
        if (topic != null) {
            loadMarkdownContent(topic + ".md");
        } else {
            String defaultContent = "高级渗透分类涵盖了白帽工程师所需的各种高级渗透技巧和方法。本课程将深入探讨信息收集、Web应用漏洞利用、内网渗透、防御绕过、云原生安全等高级渗透技术。";
            loadHtmlContent(defaultContent);
        }
    }
}