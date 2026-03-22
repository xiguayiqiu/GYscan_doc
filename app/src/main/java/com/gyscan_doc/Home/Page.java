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
        } else {
            loadWindowsCommands(titleText, descriptionText, pointsText);
        }
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