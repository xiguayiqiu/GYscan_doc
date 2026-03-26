package com.gyscan_doc;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.gyscan_doc.adapter.DrawerAdapter;
import com.gyscan_doc.model.DrawerItem;
import com.gyscan_doc.utils.ScreenUtils;
import com.gyscan_doc.Home.Page;
import com.gyscan_doc.Intro.Intro1;
import com.gyscan_doc.Linux.LinuxCommandsActivity;
import com.gyscan_doc.Windows.WindowsCommandsActivity;
import com.gyscan_doc.Security.SecurityBasicsActivity;
import com.gyscan_doc.Security.SecuritySummaryActivity;
import com.gyscan_doc.CyberSecurity.CyberSecurityActivity;

public class MainActivity extends AppCompatActivity {

    private static final String PREFS_NAME = "IntroPrefs";
    private static final String KEY_INTRO_SHOWN = "intro_shown";
    private static final String KEY_TERMS_ACCEPTED = "terms_accepted";
    private DrawerLayout drawerLayout;
    private LinearLayout navigationView;
    private RecyclerView drawerRecyclerView;
    private DrawerAdapter drawerAdapter;
    private View menuButton;
    private float menuRotation = 0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // 检查用户是否已经接受了协议
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        boolean termsAccepted = prefs.getBoolean(KEY_TERMS_ACCEPTED, false);
        
        if (!termsAccepted) {
            // 如果没有接受协议，启动TermsActivity
            Intent intent = new Intent(MainActivity.this, TermsActivity.class);
            startActivity(intent);
            finish();
            return;
        }
        
        setContentView(R.layout.activity_main);

        setupScreen();
        setupToolbar();
        setupDrawer();
        setupStartButton();
        setupVersionText();
        
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

    private void setupScreen() {
        ScreenUtils.setupScreen(this);
    }

    private void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
        
        ScreenUtils.setupToolbar(toolbar);
    }

    private void setupDrawer() {
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigationView);
        drawerRecyclerView = findViewById(R.id.drawerRecyclerView);

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

        // 初始化RecyclerView
        drawerRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        // 启用默认的动画效果，设置更长的动画持续时间以获得更平滑的效果
        androidx.recyclerview.widget.DefaultItemAnimator itemAnimator = new androidx.recyclerview.widget.DefaultItemAnimator();
        itemAnimator.setAddDuration(300);
        itemAnimator.setRemoveDuration(300);
        itemAnimator.setMoveDuration(300);
        itemAnimator.setChangeDuration(300);
        drawerRecyclerView.setItemAnimator(itemAnimator);
        
        // 构建菜单项
        final java.util.List<DrawerItem> drawerItems = DrawerAdapter.buildDrawerItems();
        java.util.List<DrawerItem> flattenedItems = DrawerAdapter.getFlattenedItems(drawerItems);
        
        // 设置适配器
        drawerAdapter = new DrawerAdapter(this, flattenedItems, new DrawerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int itemId) {
                // 处理菜单项点击
                handleMenuItemClick(itemId);
                drawerLayout.closeDrawer(GravityCompat.START);
            }
        });
        drawerRecyclerView.setAdapter(drawerAdapter);
    }

    private void handleMenuItemClick(int itemId) {
        Intent intent = null;
        
        if (itemId == R.id.nav_security_basics) {
            intent = new Intent(MainActivity.this, SecurityBasicsActivity.class);
        } else if (itemId == R.id.nav_security_overview) {
            intent = new Intent(MainActivity.this, SecuritySummaryActivity.class);
        } else if (itemId == R.id.nav_security_advanced) {
            intent = new Intent(MainActivity.this, com.gyscan_doc.Security.AdvancedPenetrationListActivity.class);
        } else if (itemId == R.id.nav_linux_commands) {
            intent = new Intent(MainActivity.this, LinuxCommandsActivity.class);
        } else if (itemId == R.id.nav_windows_commands) {
            intent = new Intent(MainActivity.this, WindowsCommandsActivity.class);
        } else if (itemId == R.id.nav_linux_tools) {
            intent = new Intent(MainActivity.this, CyberSecurityActivity.class);
        } else if (itemId == R.id.nav_related_projects) {
            intent = new Intent(MainActivity.this, RelatedProjectsActivity.class);
        } else if (itemId == R.id.nav_about) {
            intent = new Intent(MainActivity.this, AboutActivity.class);
        } else {
            intent = new Intent(MainActivity.this, Page.class);
            intent.putExtra("menu_item", itemId);
        }
        
        if (intent != null) {
            startActivity(intent);
        }
    }

    private void handleNavigationItemClick(MenuItem item) {
        int itemId = item.getItemId();
        
        if (itemId == R.id.nav_security_basics) {
            Intent intent = new Intent(MainActivity.this, SecurityBasicsActivity.class);
            startActivity(intent);
        } else if (itemId == R.id.nav_security_overview) {
            Intent intent = new Intent(MainActivity.this, SecuritySummaryActivity.class);
            startActivity(intent);
        } else if (itemId == R.id.nav_security_advanced) {
            Intent intent = new Intent(MainActivity.this, com.gyscan_doc.Security.AdvancedPenetrationListActivity.class);
            startActivity(intent);
        } else if (itemId == R.id.nav_linux_commands) {
            Intent intent = new Intent(MainActivity.this, LinuxCommandsActivity.class);
            startActivity(intent);
        } else if (itemId == R.id.nav_windows_commands) {
            Intent intent = new Intent(MainActivity.this, WindowsCommandsActivity.class);
            startActivity(intent);
        } else if (itemId == R.id.nav_linux_tools) {
            Intent intent = new Intent(MainActivity.this, CyberSecurityActivity.class);
            startActivity(intent);

        } else if (itemId == R.id.nav_related_projects) {
            Intent intent = new Intent(MainActivity.this, RelatedProjectsActivity.class);
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
        Button startButton = findViewById(R.id.startLearningButton);
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
    
    private void setupVersionText() {
        TextView versionText = findViewById(R.id.versionText);
        if (versionText != null) {
            String version = getString(R.string.app_version);
            String versionTextStr = getString(R.string.app_version_text, version);
            versionText.setText(versionTextStr);
        }
    }
}