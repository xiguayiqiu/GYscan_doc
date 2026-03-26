package com.gyscan_doc.Security;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import com.gyscan_doc.R;
import android.widget.TextView;

public class SecuritySummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_security_summary);

        // 设置状态栏颜色
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            int statusBarColor;
            int currentNightMode = getResources().getConfiguration().uiMode & android.content.res.Configuration.UI_MODE_NIGHT_MASK;
            if (currentNightMode == android.content.res.Configuration.UI_MODE_NIGHT_YES) {
                statusBarColor = ContextCompat.getColor(this, R.color.dark_theme_dark_blue);
            } else {
                statusBarColor = ContextCompat.getColor(this, R.color.theme_blue);
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

        // 适配水滴屏、刘海屏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            Window window = getWindow();
            WindowManager.LayoutParams layoutParams = window.getAttributes();
            layoutParams.layoutInDisplayCutoutMode = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES;
            window.setAttributes(layoutParams);
        }

        setupToolbar();
        loadContent();
        setupButtons();
    }

    private void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
        
        // 确保返回按钮是白色的
        for (int i = 0; i < toolbar.getChildCount(); i++) {
            View child = toolbar.getChildAt(i);
            if (child instanceof android.widget.ImageButton) {
                android.widget.ImageButton button = (android.widget.ImageButton) child;
                button.setColorFilter(Color.WHITE, android.graphics.PorterDuff.Mode.SRC_ATOP);
            } else if (child instanceof androidx.appcompat.widget.AppCompatImageButton) {
                androidx.appcompat.widget.AppCompatImageButton button = (androidx.appcompat.widget.AppCompatImageButton) child;
                button.setColorFilter(Color.WHITE, android.graphics.PorterDuff.Mode.SRC_ATOP);
            }
        }
    }

    private void loadContent() {
        TextView titleText = findViewById(R.id.summaryTitle);
        TextView descriptionText = findViewById(R.id.summaryDescription);
        TextView pointsText = findViewById(R.id.summaryPoints);
        
        titleText.setText("白帽网络安全工程师基本技能");
        descriptionText.setText("白帽网络安全工程师是网络安全领域的守护者，负责识别和修复系统漏洞，保护网络安全。本概要提供了白帽安全工程师所需的核心技能和学习路径，帮助您成为一名合格的网络安全守护者。");
        pointsText.setText("• 网络安全基础理论知识\n• 漏洞扫描与分析技能\n• 渗透测试技术与工具\n• 安全代码审计能力\n• 网络安全防御策略\n• 安全事件响应与处理\n• 法律法规与伦理规范");
    }

    private void setupButtons() {
        Button startButton = findViewById(R.id.startLearningButton);
        startButton.setOnClickListener(v -> {
            Intent intent = new Intent(SecuritySummaryActivity.this, SecurityEngineerListActivity.class);
            startActivity(intent);
        });
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