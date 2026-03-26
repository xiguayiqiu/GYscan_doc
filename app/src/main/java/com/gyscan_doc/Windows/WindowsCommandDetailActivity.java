package com.gyscan_doc.Windows;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import com.gyscan_doc.utils.ScreenUtils;
import com.gyscan_doc.R;
import java.io.IOException;
import java.io.InputStream;

public class WindowsCommandDetailActivity extends AppCompatActivity {

    private WebView webView;
    private SharedPreferences sharedPreferences;
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
        String commandTitle = getIntent().getStringExtra("command_title");
        
        // 保存当前命令名称
        currentCommandName = commandName;

        setupToolbar(commandTitle);
        setupWebView(commandName);
        

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

    private void setupWebView(String commandName) {
        webView = findViewById(R.id.command_usage);
        TextView optionsTextView = findViewById(R.id.command_options);
        // 清理WebView缓存
        webView.clearCache(true);
        webView.clearHistory();
        webView.clearFormData();
        
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setDefaultTextEncodingName("UTF-8");
        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);

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
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setDefaultTextEncodingName("UTF-8");
        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        
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
        return "body { font-family: sans-serif; line-height: 1.6; padding: 16px; background-color: #f5f5f5; color: #333333; font-size: 18px; }" +
                "h1 { color: #333; font-size: 24px; margin-bottom: 16px; }" +
                "h2 { color: #555; font-size: 20px; margin-top: 20px; margin-bottom: 14px; }" +
                "h3 { color: #777; font-size: 18px; margin-top: 16px; margin-bottom: 10px; }" +
                "p { margin-bottom: 14px; }" +
                "pre { background-color: #f8f9fa; padding: 16px; border-radius: 8px; overflow-x: auto; margin-bottom: 18px; font-size: 16px; border: 1px solid #e9ecef; box-shadow: 0 2px 4px rgba(0,0,0,0.05); }" +
                "code { font-family: 'Monaco', 'Menlo', 'Ubuntu Mono', monospace; font-size: 15px; color: #333; line-height: 1.6; }" +
                "pre code { background-color: transparent; padding: 0; border-radius: 0; border: none; box-shadow: none; }" +
                "ul { margin-bottom: 14px; padding-left: 28px; }" +
                "ol { margin-bottom: 14px; padding-left: 28px; }" +
                "li { margin-bottom: 8px; }" +
                "hr { margin: 24px 0; border: 0; border-top: 1px solid #eee; }" +
                "strong { font-weight: bold; }" +
                "em { font-style: italic; }" +
                "a { color: #1976D2; text-decoration: none; }" +
                "a:hover { text-decoration: underline; }";
    }

    private String loadMarkdownFromAssets(String commandName) {
        try {
            // 尝试加载Windows命令的Markdown文件
            String filePath = "windows_cmd/" + commandName + ".md";
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
            // 文件不存在，返回null
            return null;
        }
    }

    private String convertMarkdownToHtml(String markdown) {
        // 使用commonmark-java将Markdown转换为HTML，添加对GFM表格的支持
        java.util.List<org.commonmark.Extension> extensions = java.util.Collections.singletonList(org.commonmark.ext.gfm.tables.TablesExtension.create());
        org.commonmark.parser.Parser parser = org.commonmark.parser.Parser.builder()
                .extensions(extensions)
                .build();
        org.commonmark.node.Node document = parser.parse(markdown);
        org.commonmark.renderer.html.HtmlRenderer renderer = org.commonmark.renderer.html.HtmlRenderer.builder()
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
            setupWebView(currentCommandName);
        }
    }

    @Override
    public void onConfigurationChanged(android.content.res.Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // 当系统主题变化时，重新设置状态栏颜色
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            int statusBarColor;
            int currentNightMode = newConfig.uiMode & android.content.res.Configuration.UI_MODE_NIGHT_MASK;
            if (currentNightMode == android.content.res.Configuration.UI_MODE_NIGHT_YES) {
                statusBarColor = ContextCompat.getColor(this, R.color.dark_theme_dark_blue);
            } else {
                statusBarColor = ContextCompat.getColor(this, R.color.theme_dark_blue);
            }
            window.setStatusBarColor(statusBarColor);
        }
        // 重新加载WebView内容，确保Markdown渲染适应新主题
        String commandName = getIntent().getStringExtra("command_name");
        if (commandName != null) {
            setupWebView(commandName);
        }
    }
}