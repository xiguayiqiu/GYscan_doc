package com.gyscan_doc;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;
import com.gyscan_doc.Home.Page;
import com.gyscan_doc.Intro.Intro1;
import com.gyscan_doc.Linux.LinuxCommandsActivity;
import com.gyscan_doc.Security.SecurityBasicsActivity;

public class MainActivity extends AppCompatActivity {

    private static final String PREFS_NAME = "IntroPrefs";
    private static final String KEY_INTRO_SHOWN = "intro_shown";
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private View menuButton;
    private float menuRotation = 0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        setupToolbar();
        setupDrawer();
        setupStartButton();
        
        if (getIntent().getBooleanExtra("open_drawer", false)) {
            drawerLayout.postDelayed(new Runnable() {
                @Override
                public void run() {
                    drawerLayout.openDrawer(GravityCompat.START);
                }
            }, 500);
        }
        
        // 设置back press回调
        getOnBackPressedDispatcher().addCallback(this, new androidx.activity.OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    finish();
                }
            }
        });
    }

    private void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
        
        // 确保菜单按钮是白色的
        for (int i = 0; i < toolbar.getChildCount(); i++) {
            View child = toolbar.getChildAt(i);
            if (child instanceof android.widget.ImageButton) {
                ImageButton menuButton = (ImageButton) child;
                menuButton.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);
                break;
            }
        }
    }

    private void setupDrawer() {
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigationView);

        Toolbar toolbar = findViewById(R.id.toolbar);
        for (int i = 0; i < toolbar.getChildCount(); i++) {
            View child = toolbar.getChildAt(i);
            if (child instanceof android.widget.ImageButton) {
                menuButton = child;
                break;
            }
        }

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        
        drawerLayout.addDrawerListener(new androidx.drawerlayout.widget.DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(android.view.View drawerView, float slideOffset) {
                menuRotation = slideOffset * 90f;
                if (menuButton != null) {
                    menuButton.setRotation(menuRotation);
                }
            }

            @Override
            public void onDrawerOpened(android.view.View drawerView) {
            }

            @Override
            public void onDrawerClosed(android.view.View drawerView) {
                menuRotation = 0f;
                if (menuButton != null) {
                    menuButton.setRotation(menuRotation);
                }
            }

            @Override
            public void onDrawerStateChanged(int newState) {
            }
        });
        
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                // 为菜单项添加点击动画
                View menuItemView = navigationView.findViewById(item.getItemId());
                if (menuItemView != null) {
                    animateMenuItemClick(menuItemView);
                }
                
                handleNavigationItemClick(item);
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }

    private void handleNavigationItemClick(MenuItem item) {
        int itemId = item.getItemId();
        
        if (itemId == R.id.nav_security_basics) {
            Intent intent = new Intent(MainActivity.this, SecurityBasicsActivity.class);
            startActivity(intent);
        } else if (itemId == R.id.nav_linux_commands) {
            Intent intent = new Intent(MainActivity.this, LinuxCommandsActivity.class);
            startActivity(intent);
        } else if (itemId == R.id.nav_about) {
            Intent intent = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(intent);
        } else {
            Intent intent = new Intent(MainActivity.this, Page.class);
            intent.putExtra("menu_item", itemId);
            startActivity(intent);
        }
    }

    private void animateMenuItemClick(View view) {
        // 创建缩放动画
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 0.95f, 1.0f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 0.95f, 1.0f);
        
        // 创建透明度动画
        ObjectAnimator alpha = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.8f, 1.0f);
        
        // 创建动画集
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(scaleX, scaleY, alpha);
        animatorSet.setDuration(300);
        animatorSet.start();
        
        // 移除选中状态
        view.postDelayed(new Runnable() {
            @Override
            public void run() {
                // 清除菜单项的选中状态
                if (navigationView != null) {
                    Menu menu = navigationView.getMenu();
                    if (menu != null) {
                        for (int i = 0; i < menu.size(); i++) {
                            MenuItem menuItem = menu.getItem(i);
                            if (menuItem != null) {
                                menuItem.setChecked(false);
                            }
                        }
                    }
                }
            }
        }, 300);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            drawerLayout.openDrawer(GravityCompat.START);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupStartButton() {
        Button startButton = findViewById(R.id.startButton);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
                boolean introShown = prefs.getBoolean(KEY_INTRO_SHOWN, false);
                
                if (introShown) {
                    drawerLayout.openDrawer(GravityCompat.START);
                } else {
                    Intent intent = new Intent(MainActivity.this, Intro1.class);
                    startActivity(intent);
                }
            }
        });
    }
}