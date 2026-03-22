package com.gyscan_doc.Linux;

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
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import com.gyscan_doc.R;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.commonmark.ext.gfm.tables.TablesExtension;
import java.util.Collections;

public class CommandDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_command_detail);

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

        setupToolbar();
        loadCommandDetails();
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

    private void loadCommandDetails() {
        Intent intent = getIntent();
        if (intent != null) {
            String commandName = intent.getStringExtra("command_name");
            String description = intent.getStringExtra("command_description");

            WebView usageWebView = findViewById(R.id.command_usage);
            TextView optionsTextView = findViewById(R.id.command_options);

            if (commandName != null) {
                // 加载命令的使用方法和选项说明
                loadCommandUsageAndOptions(commandName, usageWebView, optionsTextView);
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
        // 尝试从不同目录加载Markdown文件
        String[] directories = {"01_文件系统", "02_进程管理", "03_网络工具", "04_系统管理", "05_用户管理", "06_压缩备份", "07_文本处理", "08_磁盘管理", "09_软件管理", "10_网络安全", "11_系统监控", "12_编程开发", "13_时间日期", "14_网络诊断", "15_系统配置", "16_文件传输", "17_系统工具", "18_其他命令"};
        
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}