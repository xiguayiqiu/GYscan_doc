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

public class AdvancedPenetrationListActivity extends AppCompatActivity {

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
        setupAdvancedPenetrationList();
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

    private void setupAdvancedPenetrationList() {
        LinearLayout container = findViewById(R.id.security_basics_container);
        LayoutInflater inflater = LayoutInflater.from(this);

        // 高级信息收集与侦察
        View reconView = inflater.inflate(R.layout.item_security_basics, container, false);
        TextView title1 = reconView.findViewById(R.id.item_title);
        TextView description1 = reconView.findViewById(R.id.item_description);
        title1.setText("高级信息收集与侦察");
        description1.setText("深度资产测绘、指纹识别与架构分析、云环境专项侦察");
        reconView.setOnClickListener(v -> {
            Intent intent = new Intent(AdvancedPenetrationListActivity.this, AdvancedPenetrationDetailActivity.class);
            intent.putExtra("topic", "advanced_reconnaissance");
            startActivity(intent);
        });
        container.addView(reconView);

        // Web应用高级漏洞利用
        View webExploitationView = inflater.inflate(R.layout.item_security_basics, container, false);
        TextView title2 = webExploitationView.findViewById(R.id.item_title);
        TextView description2 = webExploitationView.findViewById(R.id.item_description);
        title2.setText("Web应用高级漏洞利用");
        description2.setText("复杂逻辑漏洞、高级代码执行与注入、新型架构攻击面、AI与大模型安全");
        webExploitationView.setOnClickListener(v -> {
            Intent intent = new Intent(AdvancedPenetrationListActivity.this, AdvancedPenetrationDetailActivity.class);
            intent.putExtra("topic", "web_exploitation");
            startActivity(intent);
        });
        container.addView(webExploitationView);

        // 内网渗透与横向移动
        View internalNetworkView = inflater.inflate(R.layout.item_security_basics, container, false);
        TextView title3 = internalNetworkView.findViewById(R.id.item_title);
        TextView description3 = internalNetworkView.findViewById(R.id.item_description);
        title3.setText("内网渗透与横向移动");
        description3.setText("域环境高级攻击、凭证窃取与传递、隐蔽通道与隧道、无文件攻击");
        internalNetworkView.setOnClickListener(v -> {
            Intent intent = new Intent(AdvancedPenetrationListActivity.this, AdvancedPenetrationDetailActivity.class);
            intent.putExtra("topic", "internal_network");
            startActivity(intent);
        });
        container.addView(internalNetworkView);

        // 防御绕过技术
        View evasionView = inflater.inflate(R.layout.item_security_basics, container, false);
        TextView title4 = evasionView.findViewById(R.id.item_title);
        TextView description4 = evasionView.findViewById(R.id.item_description);
        title4.setText("防御绕过技术");
        description4.setText("WAF绕过、EDR/XDR绕过");
        evasionView.setOnClickListener(v -> {
            Intent intent = new Intent(AdvancedPenetrationListActivity.this, AdvancedPenetrationDetailActivity.class);
            intent.putExtra("topic", "evasion_techniques");
            startActivity(intent);
        });
        container.addView(evasionView);

        // 云原生与容器安全
        View cloudNativeView = inflater.inflate(R.layout.item_security_basics, container, false);
        TextView title5 = cloudNativeView.findViewById(R.id.item_title);
        TextView description5 = cloudNativeView.findViewById(R.id.item_description);
        title5.setText("云原生与容器安全");
        description5.setText("容器逃逸、Kubernetes集群渗透、DevSecOps流水线攻击");
        cloudNativeView.setOnClickListener(v -> {
            Intent intent = new Intent(AdvancedPenetrationListActivity.this, AdvancedPenetrationDetailActivity.class);
            intent.putExtra("topic", "cloud_native");
            startActivity(intent);
        });
        container.addView(cloudNativeView);

        // 自动化与AI辅助渗透
        View automationView = inflater.inflate(R.layout.item_security_basics, container, false);
        TextView title6 = automationView.findViewById(R.id.item_title);
        TextView description6 = automationView.findViewById(R.id.item_description);
        title6.setText("自动化与AI辅助渗透");
        description6.setText("定制化武器开发、AI驱动的攻击");
        automationView.setOnClickListener(v -> {
            Intent intent = new Intent(AdvancedPenetrationListActivity.this, AdvancedPenetrationDetailActivity.class);
            intent.putExtra("topic", "automation_ai");
            startActivity(intent);
        });
        container.addView(automationView);

        // 物理与社会工程学
        View physicalSocialView = inflater.inflate(R.layout.item_security_basics, container, false);
        TextView title7 = physicalSocialView.findViewById(R.id.item_title);
        TextView description7 = physicalSocialView.findViewById(R.id.item_description);
        title7.setText("物理与社会工程学");
        description7.setText("高级钓鱼攻击、物理入侵");
        physicalSocialView.setOnClickListener(v -> {
            Intent intent = new Intent(AdvancedPenetrationListActivity.this, AdvancedPenetrationDetailActivity.class);
            intent.putExtra("topic", "physical_social");
            startActivity(intent);
        });
        container.addView(physicalSocialView);

        // 报告与合规
        View reportingView = inflater.inflate(R.layout.item_security_basics, container, false);
        TextView title8 = reportingView.findViewById(R.id.item_title);
        TextView description8 = reportingView.findViewById(R.id.item_description);
        title8.setText("报告与合规");
        description8.setText("高质量报告撰写、法律与道德");
        reportingView.setOnClickListener(v -> {
            Intent intent = new Intent(AdvancedPenetrationListActivity.this, AdvancedPenetrationDetailActivity.class);
            intent.putExtra("topic", "reporting_compliance");
            startActivity(intent);
        });
        container.addView(reportingView);
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