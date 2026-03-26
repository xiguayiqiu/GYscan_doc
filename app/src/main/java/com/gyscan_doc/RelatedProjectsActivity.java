package com.gyscan_doc;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

public class RelatedProjectsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_related_projects);

        // 设置状态栏颜色
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.theme_blue));
            // 确保状态栏文字为白色（默认）
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                window.getDecorView().setSystemUiVisibility(0);
            }
        }

        // 适配刘海屏、挖孔屏、水滴屏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            Window window = getWindow();
            WindowManager.LayoutParams layoutParams = window.getAttributes();
            layoutParams.layoutInDisplayCutoutMode = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES;
            window.setAttributes(layoutParams);
        }

        // 设置Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // 设置返回按钮
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("相关项目");
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

        // 设置项目点击事件
        setupProjectClickListeners();
    }

    private void setupProjectClickListeners() {
        // 项目1：LinuxCmd
        LinearLayout project1 = findViewById(R.id.project1);
        if (project1 != null) {
            project1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openProjectLink("https://github.com/Ernest-su/LinuxCmd");
                }
            });
        }

        // 项目2：Termux
        LinearLayout project2 = findViewById(R.id.project2);
        if (project2 != null) {
            project2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openProjectLink("https://termux.dev/en/");
                }
            });
        }

        // 项目3：ZeroTermux
        LinearLayout project3 = findViewById(R.id.project3);
        if (project3 != null) {
            project3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openProjectLink("https://github.com/hanxinhao000/ZeroTermux");
                }
            });
        }

        // 项目4：AnLinux-App
        LinearLayout project4 = findViewById(R.id.project4);
        if (project4 != null) {
            project4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openProjectLink("https://github.com/EXALAB/AnLinux-App");
                }
            });
        }

        // 项目5：Vectras-VM-Android
        LinearLayout project5 = findViewById(R.id.project5);
        if (project5 != null) {
            project5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openProjectLink("https://github.com/xoureldeen/Vectras-VM-Android");
                }
            });
        }
    }

    private void openProjectLink(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}