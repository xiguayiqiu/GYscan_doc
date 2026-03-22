package com.gyscan_doc.Windows;

import android.os.Build;
import android.os.Bundle;
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
import com.gyscan_doc.R;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;

public class WindowsCommandDetailActivity extends AppCompatActivity {

    private WebView webView;

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
        String commandTitle = getIntent().getStringExtra("command_title");

        setupToolbar(commandTitle);
        setupWebView(commandName);
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
            if (child instanceof android.widget.ImageButton) {
                android.widget.ImageButton menuButton = (android.widget.ImageButton) child;
                menuButton.setColorFilter(android.graphics.Color.WHITE, android.graphics.PorterDuff.Mode.SRC_ATOP);
                break;
            }
        }
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
                
                // 构建完整的HTML页面
                String fullHtml = "<!DOCTYPE html>" +
                        "<html>" +
                        "<head>" +
                        "<meta charset=\"UTF-8\">" +
                        "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\">" +
                        "<style>" +
                        "body { font-family: sans-serif; line-height: 1.6; padding: 16px; background-color: #f5f5f5; color: #333333; font-size: 18px; }" +
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
                        "} " +
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
                    "} " +
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
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
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