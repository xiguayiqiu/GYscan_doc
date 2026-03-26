package com.gyscan_doc.Security;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import com.gyscan_doc.R;

public class SecurityEngineerListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_security_engineer_list);

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
        setupSecurityEngineerList();
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

    private void setupSecurityEngineerList() {
        LinearLayout container = findViewById(R.id.security_engineer_container);
        LayoutInflater inflater = LayoutInflater.from(this);

        // 网络安全基础理论知识
        View basicTheoryView = inflater.inflate(R.layout.item_security_basics, container, false);
        TextView title1 = basicTheoryView.findViewById(R.id.item_title);
        TextView description1 = basicTheoryView.findViewById(R.id.item_description);
        title1.setText("网络安全基础理论知识");
        description1.setText("掌握网络安全的基本概念、原理和术语");
        basicTheoryView.setOnClickListener(v -> {
            Intent intent = new Intent(SecurityEngineerListActivity.this, SecurityBasicsDetailActivity.class);
            intent.putExtra("topic", "basic_theory");
            startActivity(intent);
        });
        container.addView(basicTheoryView);

        // 漏洞扫描与分析技能
        View vulnerabilityScanView = inflater.inflate(R.layout.item_security_basics, container, false);
        TextView title2 = vulnerabilityScanView.findViewById(R.id.item_title);
        TextView description2 = vulnerabilityScanView.findViewById(R.id.item_description);
        title2.setText("漏洞扫描与分析技能");
        description2.setText("学习如何使用工具扫描和分析系统漏洞");
        vulnerabilityScanView.setOnClickListener(v -> {
            Intent intent = new Intent(SecurityEngineerListActivity.this, SecurityBasicsDetailActivity.class);
            intent.putExtra("topic", "vulnerability_scan");
            startActivity(intent);
        });
        container.addView(vulnerabilityScanView);

        // 渗透测试技术与工具
        View penetrationTestView = inflater.inflate(R.layout.item_security_basics, container, false);
        TextView title3 = penetrationTestView.findViewById(R.id.item_title);
        TextView description3 = penetrationTestView.findViewById(R.id.item_description);
        title3.setText("渗透测试技术与工具");
        description3.setText("掌握渗透测试的方法和常用工具");
        penetrationTestView.setOnClickListener(v -> {
            Intent intent = new Intent(SecurityEngineerListActivity.this, SecurityBasicsDetailActivity.class);
            intent.putExtra("topic", "penetration_test");
            startActivity(intent);
        });
        container.addView(penetrationTestView);

        // 安全代码审计能力
        View codeAuditView = inflater.inflate(R.layout.item_security_basics, container, false);
        TextView title4 = codeAuditView.findViewById(R.id.item_title);
        TextView description4 = codeAuditView.findViewById(R.id.item_description);
        title4.setText("安全代码审计能力");
        description4.setText("学习如何审计代码中的安全漏洞");
        codeAuditView.setOnClickListener(v -> {
            Intent intent = new Intent(SecurityEngineerListActivity.this, SecurityBasicsDetailActivity.class);
            intent.putExtra("topic", "code_audit");
            startActivity(intent);
        });
        container.addView(codeAuditView);

        // 网络安全防御策略
        View defenseStrategyView = inflater.inflate(R.layout.item_security_basics, container, false);
        TextView title5 = defenseStrategyView.findViewById(R.id.item_title);
        TextView description5 = defenseStrategyView.findViewById(R.id.item_description);
        title5.setText("网络安全防御策略");
        description5.setText("制定和实施有效的网络安全防御策略");
        defenseStrategyView.setOnClickListener(v -> {
            Intent intent = new Intent(SecurityEngineerListActivity.this, SecurityBasicsDetailActivity.class);
            intent.putExtra("topic", "defense_strategy");
            startActivity(intent);
        });
        container.addView(defenseStrategyView);

        // 安全事件响应与处理
        View incidentResponseView = inflater.inflate(R.layout.item_security_basics, container, false);
        TextView title6 = incidentResponseView.findViewById(R.id.item_title);
        TextView description6 = incidentResponseView.findViewById(R.id.item_description);
        title6.setText("安全事件响应与处理");
        description6.setText("学习如何应对和处理安全事件");
        incidentResponseView.setOnClickListener(v -> {
            Intent intent = new Intent(SecurityEngineerListActivity.this, SecurityBasicsDetailActivity.class);
            intent.putExtra("topic", "incident_response");
            startActivity(intent);
        });
        container.addView(incidentResponseView);

        // 法律法规与伦理规范
        View lawsEthicsView = inflater.inflate(R.layout.item_security_basics, container, false);
        TextView title7 = lawsEthicsView.findViewById(R.id.item_title);
        TextView description7 = lawsEthicsView.findViewById(R.id.item_description);
        title7.setText("法律法规与伦理规范");
        description7.setText("了解网络安全相关的法律法规和伦理规范");
        lawsEthicsView.setOnClickListener(v -> {
            Intent intent = new Intent(SecurityEngineerListActivity.this, SecurityBasicsDetailActivity.class);
            intent.putExtra("topic", "laws_ethics");
            startActivity(intent);
        });
        container.addView(lawsEthicsView);

        // 高级渗透分类
        View advancedPenetrationView = inflater.inflate(R.layout.item_security_basics, container, false);
        TextView title8 = advancedPenetrationView.findViewById(R.id.item_title);
        TextView description8 = advancedPenetrationView.findViewById(R.id.item_description);
        title8.setText("高级渗透分类");
        description8.setText("深入学习高级渗透技巧和方法");
        advancedPenetrationView.setOnClickListener(v -> {
            Intent intent = new Intent(SecurityEngineerListActivity.this, AdvancedPenetrationListActivity.class);
            startActivity(intent);
        });
        container.addView(advancedPenetrationView);
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