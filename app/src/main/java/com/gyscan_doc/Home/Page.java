package com.gyscan_doc.Home;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Build;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import com.gyscan_doc.R;

public class Page extends AppCompatActivity {

    private static final int MENU_SECURITY_BASICS = R.id.nav_security_basics;
    private static final int MENU_SECURITY_OVERVIEW = R.id.nav_security_overview;
    private static final int MENU_SECURITY_ADVANCED = R.id.nav_security_advanced;
    private static final int MENU_WINDOWS_COMMANDS = R.id.nav_windows_commands;
    private static final int MENU_LINUX_TOOLS = R.id.nav_linux_tools;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page);

        // 设置状态栏颜色
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.theme_blue));
        }

        // 适配刘海屏、水滴屏、挖孔屏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            Window window = getWindow();
            WindowManager.LayoutParams params = window.getAttributes();
            params.layoutInDisplayCutoutMode = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES;
            window.setAttributes(params);
        }

        setupToolbar();
        loadContent();
        setupStartButton();
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
        int menuItemId = getIntent().getIntExtra("menu_item", MENU_WINDOWS_COMMANDS);
        
        TextView titleText = findViewById(R.id.contentTitle);
        TextView descriptionText = findViewById(R.id.contentDescription);
        TextView pointsText = findViewById(R.id.contentPoints);
        
        if (menuItemId == MENU_WINDOWS_COMMANDS) {
            loadWindowsCommands(titleText, descriptionText, pointsText);
        } else if (menuItemId == MENU_LINUX_TOOLS) {
            loadLinuxTools(titleText, descriptionText, pointsText);
        } else if (menuItemId == MENU_SECURITY_ADVANCED) {
            loadSecurityAdvanced(titleText, descriptionText, pointsText);
        } else {
            // 默认保持原样，不加载Windows命令内容
            titleText.setText("未知页面");
            descriptionText.setText("该页面尚未实现");
            pointsText.setText("");
        }
    }

    private void loadSecurityAdvanced(TextView title, TextView description, TextView points) {
        title.setText("网络安全高级技巧");
        description.setText("高级渗透分类涵盖了白帽工程师所需的各种高级渗透技巧和方法。本课程将深入探讨信息收集、Web应用漏洞利用、内网渗透、防御绕过、云原生安全等高级渗透技术。");
        points.setText("• 高级信息收集与侦察\n• Web应用高级漏洞利用\n• 内网渗透与横向移动\n• 防御绕过技术\n• 云原生与容器安全\n• 自动化与AI辅助渗透\n• 物理与社会工程学\n• 报告与合规");
    }

    private void loadWindowsCommands(TextView title, TextView description, TextView points) {
        title.setText(R.string.windows_commands_title);
        description.setText(R.string.windows_commands_description);
        points.setText(R.string.windows_commands_points);
    }

    private void loadLinuxTools(TextView title, TextView description, TextView points) {
        title.setText(R.string.linux_tools_title);
        description.setText(R.string.linux_tools_description);
        points.setText(R.string.linux_tools_points);
    }

    private void setupStartButton() {
        Button startButton = findViewById(R.id.startLearningButton);
        startButton.setOnClickListener(v -> {
            int menuItemId = getIntent().getIntExtra("menu_item", MENU_WINDOWS_COMMANDS);
            if (menuItemId == MENU_WINDOWS_COMMANDS) {
                startActivity(new Intent(this, com.gyscan_doc.Windows.WindowsCommandsListActivity.class));
            } else if (menuItemId == MENU_LINUX_TOOLS) {
                startActivity(new Intent(this, com.gyscan_doc.Linux.LinuxCommandsActivity.class));
            }
            // 其他菜单项不执行任何操作
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