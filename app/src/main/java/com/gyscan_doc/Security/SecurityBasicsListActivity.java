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
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import com.gyscan_doc.R;

public class SecurityBasicsListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_security_basics_list);

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
        setupSecurityBasicsList();
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
                menuButton.setColorFilter(Color.WHITE, android.graphics.PorterDuff.Mode.SRC_ATOP);
                break;
            }
        }
    }

    private void setupSecurityBasicsList() {
        LinearLayout container = findViewById(R.id.security_basics_container);
        LayoutInflater inflater = LayoutInflater.from(this);

        // 网络安全基本概念
        View basicConceptsView = inflater.inflate(R.layout.item_security_basics, container, false);
        TextView title1 = basicConceptsView.findViewById(R.id.item_title);
        TextView description1 = basicConceptsView.findViewById(R.id.item_description);
        title1.setText("网络安全基本概念");
        description1.setText("了解网络安全的定义、重要性和基本术语");
        basicConceptsView.setOnClickListener(v -> {
            Intent intent = new Intent(SecurityBasicsListActivity.this, SecurityBasicsDetailActivity.class);
            intent.putExtra("topic", "basic_concepts");
            startActivity(intent);
        });
        container.addView(basicConceptsView);

        // 常见网络威胁
        View commonThreatsView = inflater.inflate(R.layout.item_security_basics, container, false);
        TextView title2 = commonThreatsView.findViewById(R.id.item_title);
        TextView description2 = commonThreatsView.findViewById(R.id.item_description);
        title2.setText("常见网络威胁");
        description2.setText("学习常见的网络攻击类型和防御方法");
        commonThreatsView.setOnClickListener(v -> {
            Intent intent = new Intent(SecurityBasicsListActivity.this, SecurityBasicsDetailActivity.class);
            intent.putExtra("topic", "common_threats");
            startActivity(intent);
        });
        container.addView(commonThreatsView);

        // 网络安全防护措施
        View protectionMeasuresView = inflater.inflate(R.layout.item_security_basics, container, false);
        TextView title3 = protectionMeasuresView.findViewById(R.id.item_title);
        TextView description3 = protectionMeasuresView.findViewById(R.id.item_description);
        title3.setText("网络安全防护措施");
        description3.setText("掌握基本的网络安全防护策略和技术");
        protectionMeasuresView.setOnClickListener(v -> {
            Intent intent = new Intent(SecurityBasicsListActivity.this, SecurityBasicsDetailActivity.class);
            intent.putExtra("topic", "protection_measures");
            startActivity(intent);
        });
        container.addView(protectionMeasuresView);

        // 网络安全法律法规
        View lawsRegulationsView = inflater.inflate(R.layout.item_security_basics, container, false);
        TextView title4 = lawsRegulationsView.findViewById(R.id.item_title);
        TextView description4 = lawsRegulationsView.findViewById(R.id.item_description);
        title4.setText("网络安全法律法规");
        description4.setText("了解网络安全相关的法律法规和合规要求");
        lawsRegulationsView.setOnClickListener(v -> {
            Intent intent = new Intent(SecurityBasicsListActivity.this, SecurityBasicsDetailActivity.class);
            intent.putExtra("topic", "laws_regulations");
            startActivity(intent);
        });
        container.addView(lawsRegulationsView);

        // 安全意识培养
        View securityAwarenessView = inflater.inflate(R.layout.item_security_basics, container, false);
        TextView title5 = securityAwarenessView.findViewById(R.id.item_title);
        TextView description5 = securityAwarenessView.findViewById(R.id.item_description);
        title5.setText("安全意识培养");
        description5.setText("培养良好的网络安全习惯和意识");
        securityAwarenessView.setOnClickListener(v -> {
            Intent intent = new Intent(SecurityBasicsListActivity.this, SecurityBasicsDetailActivity.class);
            intent.putExtra("topic", "security_awareness");
            startActivity(intent);
        });
        container.addView(securityAwarenessView);
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