package com.gyscan_doc;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class AboutActivity extends AppCompatActivity {

    private int clickCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        // 设置状态栏颜色
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                window.setStatusBarColor(getColor(R.color.theme_blue));
                // 确保状态栏文字为白色（默认）
                window.getDecorView().setSystemUiVisibility(0);
            } else {
                window.setStatusBarColor(getResources().getColor(R.color.theme_blue));
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
        setupLinks();
        setupSystemInfo();
        setupAppLogoClick();
    }

    private void setupAppLogoClick() {
        ImageView appLogo = findViewById(R.id.appLogo);
        appLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCount++;
                if (clickCount == 3) {
                    Toast.makeText(AboutActivity.this, "你在干嘛～哎哟～～", Toast.LENGTH_SHORT).show();
                } else if (clickCount == 7) {
                    Intent intent = new Intent(AboutActivity.this, EasterEggActivity.class);
                    startActivity(intent);
                    clickCount = 0; // 重置计数
                }
            }
        });
    }

    private void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("关于");
        }
        
        // 确保返回按钮是白色的
        for (int i = 0; i < toolbar.getChildCount(); i++) {
            View child = toolbar.getChildAt(i);
            if (child instanceof android.widget.ImageButton) {
                android.widget.ImageButton backButton = (android.widget.ImageButton) child;
                backButton.setColorFilter(android.graphics.Color.WHITE, android.graphics.PorterDuff.Mode.SRC_ATOP);
                break;
            }
        }
        
        // 设置版本号
        TextView appVersion = findViewById(R.id.appVersion);
        if (appVersion != null) {
            String version = getString(R.string.app_version);
            String versionText = getString(R.string.app_version_text, version);
            appVersion.setText(versionText);
        }
    }

    private void setupLinks() {
        TextView githubLink = findViewById(R.id.githubLink);
        TextView giteeLink = findViewById(R.id.giteeLink);
        TextView websiteLink = findViewById(R.id.websiteLink);
        
        githubLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUrl("https://github.com/xiguayiqiu/GYscan");
            }
        });
        
        giteeLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUrl("https://gitee.com/bzhanyiqiua/GYscan");
            }
        });
        
        websiteLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUrl("https://gyscan.space");
            }
        });
    }

    private void setupSystemInfo() {
    }

    private void checkKernelVersion() {
        TextView kernelVersionTextView = findViewById(R.id.kernelVersion);
        if (kernelVersionTextView != null) {
            kernelVersionTextView.setText("未知");
        }
    }

    private void checkAbiType() {
        TextView abiTypeTextView = findViewById(R.id.abiType);
        if (abiTypeTextView != null) {
            abiTypeTextView.setText("未知");
        }
    }

    private void checkSelinuxStatus() {
        TextView selinuxStatusTextView = findViewById(R.id.selinuxStatus);
        if (selinuxStatusTextView != null) {
            selinuxStatusTextView.setText("未知");
        }
    }

    private void checkRootStatus() {
        TextView rootStatusTextView = findViewById(R.id.rootStatus);
        if (rootStatusTextView != null) {
            rootStatusTextView.setText("未知");
        }
    }

    private boolean isDeviceRooted() {
        return false;
    }

    private void openUrl(String url) {
        try {
            Uri uri = Uri.parse(url);
            if (uri != null) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(uri);
                // 确保有应用可以处理该Intent
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "无法打开链接", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "链接格式不正确", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            Toast.makeText(this, "打开链接失败", Toast.LENGTH_SHORT).show();
        }
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