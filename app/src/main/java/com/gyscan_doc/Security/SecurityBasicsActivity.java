package com.gyscan_doc.Security;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import com.gyscan_doc.R;
import android.widget.TextView;

public class SecurityBasicsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_security_basics);

        // 设置状态栏颜色
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.theme_blue));
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
        
        // 确保菜单按钮是白色的
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
        TextView descriptionText = findViewById(R.id.contentDescription);
        TextView pointsText = findViewById(R.id.contentPoints);
        
        titleText.setText("网络安全基础");
        descriptionText.setText("网络安全基础是学习网络安全的第一步。本课程将介绍网络安全的基本概念、威胁类型、防护措施以及相关的法律法规。通过学习本课程，您将建立起对网络安全的整体认识，为后续深入学习打下坚实基础。");
        pointsText.setText("• 网络安全基本概念\n• 常见网络威胁类型\n• 基本防护措施\n• 相关法律法规\n• 安全意识培养");
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