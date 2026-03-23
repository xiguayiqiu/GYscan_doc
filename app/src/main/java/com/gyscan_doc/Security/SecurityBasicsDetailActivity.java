package com.gyscan_doc.Security;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import com.gyscan_doc.R;
import java.io.IOException;
import java.io.InputStream;

public class SecurityBasicsDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_security_basics_detail);

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
        }
        
        for (int i = 0; i < toolbar.getChildCount(); i++) {
            View child = toolbar.getChildAt(i);
            if (child instanceof ImageButton) {
                ImageButton menuButton = (ImageButton) child;
                menuButton.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);
                break;
            }
        }
    }

    private void loadContent() {
        TextView titleText = findViewById(R.id.contentTitle);
        WebView contentWebView = findViewById(R.id.contentWebView);
        
        String topic = getIntent().getStringExtra("topic");
        
        if (topic != null) {
            switch (topic) {
                case "basic_concepts":
                    titleText.setText("网络安全基本概念");
                    loadMarkdownContent(contentWebView, "basic_concepts.md");
                    break;
                case "common_threats":
                    titleText.setText("常见网络威胁");
                    loadMarkdownContent(contentWebView, "common_threats.md");
                    break;
                case "protection_measures":
                    titleText.setText("网络安全防护措施");
                    loadMarkdownContent(contentWebView, "protection_measures.md");
                    break;
                case "laws_regulations":
                    titleText.setText("网络安全法律法规");
                    loadMarkdownContent(contentWebView, "laws_regulations.md");
                    break;
                case "security_awareness":
                    titleText.setText("安全意识培养");
                    loadMarkdownContent(contentWebView, "security_awareness.md");
                    break;
                default:
                    titleText.setText("网络安全基础");
                    String defaultContent = "网络安全是保护计算机网络和系统免受未经授权的访问、使用、披露、破坏、修改或中断的实践。随着互联网的普及和技术的发展，网络安全变得越来越重要。本课程将帮助您了解网络安全的基本概念、常见威胁和防护措施。";
                    loadHtmlContent(contentWebView, defaultContent);
                    break;
            }
        } else {
            titleText.setText("网络安全基础");
            String defaultContent = "网络安全是保护计算机网络和系统免受未经授权的访问、使用、披露、破坏、修改或中断的实践。随着互联网的普及和技术的发展，网络安全变得越来越重要。本课程将帮助您了解网络安全的基本概念、常见威胁和防护措施。";
            loadHtmlContent(contentWebView, defaultContent);
        }
    }

    private void loadMarkdownContent(WebView webView, String fileName) {
        try {
            InputStream inputStream = getAssets().open("security_basics/" + fileName);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            String markdownContent = new String(buffer, "UTF-8");
            String htmlContent = convertMarkdownToHtml(markdownContent);
            loadHtmlContent(webView, htmlContent);
        } catch (IOException e) {
            e.printStackTrace();
            loadHtmlContent(webView, "加载内容失败，请检查文件是否存在。");
        }
    }

    private void loadHtmlContent(WebView webView, String htmlContent) {
        // 启用JavaScript以支持一些Markdown功能
        webView.getSettings().setJavaScriptEnabled(true);
        // 启用缩放
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setBuiltInZoomControls(true);
        // 设置WebView背景为透明，以适应卡片背景
        webView.setBackgroundColor(0x00000000);
        // 加载HTML内容
        webView.loadDataWithBaseURL(null, htmlContent, "text/html", "UTF-8", null);
    }

    private String convertMarkdownToHtml(String markdown) {
        // 简单的Markdown到HTML转换
        // 处理标题
        markdown = java.util.regex.Pattern.compile("^# (.*?)$", java.util.regex.Pattern.MULTILINE).matcher(markdown).replaceAll("<h1>$1</h1>");
        markdown = java.util.regex.Pattern.compile("^## (.*?)$", java.util.regex.Pattern.MULTILINE).matcher(markdown).replaceAll("<h2>$1</h2>");
        markdown = java.util.regex.Pattern.compile("^### (.*?)$", java.util.regex.Pattern.MULTILINE).matcher(markdown).replaceAll("<h3>$1</h3>");
        // 处理列表
        markdown = java.util.regex.Pattern.compile("^• (.*?)$", java.util.regex.Pattern.MULTILINE).matcher(markdown).replaceAll("<li>$1</li>");
        markdown = java.util.regex.Pattern.compile("(<li>.*?</li>)", java.util.regex.Pattern.DOTALL).matcher(markdown).replaceAll("<ul>$1</ul>");
        // 处理段落
        markdown = java.util.regex.Pattern.compile("^(?!<h|</h|</?ul|</?li|^•)(.*?)$", java.util.regex.Pattern.MULTILINE).matcher(markdown).replaceAll("<p>$1</p>");
        // 处理换行
        markdown = markdown.replaceAll("\\n", "<br>");
        
        // 根据当前主题模式生成不同的CSS样式
        int currentNightMode = getResources().getConfiguration().uiMode & android.content.res.Configuration.UI_MODE_NIGHT_MASK;
        String css;
        if (currentNightMode == android.content.res.Configuration.UI_MODE_NIGHT_YES) {
            // 暗色模式样式
            css = "<style>"
                    + "body { font-family: sans-serif; line-height: 1.6; color: #e0e0e0; background-color: transparent; }"
                    + "h1 { font-size: 24px; font-weight: bold; margin-top: 0; margin-bottom: 16px; color: #90caf9; }"
                    + "h2 { font-size: 20px; font-weight: bold; margin-top: 24px; margin-bottom: 12px; color: #64b5f6; }"
                    + "h3 { font-size: 18px; font-weight: bold; margin-top: 20px; margin-bottom: 10px; color: #42a5f5; }"
                    + "p { margin-bottom: 12px; }"
                    + "ul { margin-bottom: 16px; padding-left: 24px; }"
                    + "li { margin-bottom: 8px; }"
                    + "</style>";
        } else {
            // 亮色模式样式
            css = "<style>"
                    + "body { font-family: sans-serif; line-height: 1.6; color: #333; background-color: transparent; }"
                    + "h1 { font-size: 24px; font-weight: bold; margin-top: 0; margin-bottom: 16px; color: #1565C0; }"
                    + "h2 { font-size: 20px; font-weight: bold; margin-top: 24px; margin-bottom: 12px; color: #1976D2; }"
                    + "h3 { font-size: 18px; font-weight: bold; margin-top: 20px; margin-bottom: 10px; color: #1E88E5; }"
                    + "p { margin-bottom: 12px; }"
                    + "ul { margin-bottom: 16px; padding-left: 24px; }"
                    + "li { margin-bottom: 8px; }"
                    + "</style>";
        }
        
        return "<!DOCTYPE html><html><head>" + css + "</head><body>" + markdown + "</body></html>";
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