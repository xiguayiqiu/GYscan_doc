package com.gyscan_doc.Windows;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.gyscan_doc.R;
import java.util.ArrayList;
import java.util.List;

public class WindowsCommandsListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private WindowsPackageAdapter adapter;
    private EditText searchEditText;
    private ImageButton clearButton;
    private List<WindowsCommandPackage> allPackages;
    private List<WindowsCommandPackage> filteredPackages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_windows_commands_list);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            // 清除透明状态栏标志，确保状态栏显示
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            // 添加绘制系统栏背景的标志
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            // 根据当前主题使用合适的状态栏背景色
            int statusBarColor;
            int currentNightMode = getResources().getConfiguration().uiMode & android.content.res.Configuration.UI_MODE_NIGHT_MASK;
            if (currentNightMode == android.content.res.Configuration.UI_MODE_NIGHT_YES) {
                // 暗色模式
                statusBarColor = ContextCompat.getColor(this, R.color.dark_theme_dark_blue);
            } else {
                // 亮色模式
                statusBarColor = ContextCompat.getColor(this, R.color.theme_dark_blue);
            }
            window.setStatusBarColor(statusBarColor);
            // 确保状态栏文字为白色
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                // 清除SYSTEM_UI_FLAG_LIGHT_STATUS_BAR标志，确保状态栏文字为白色
                int flags = window.getDecorView().getSystemUiVisibility();
                flags &= ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
                window.getDecorView().setSystemUiVisibility(flags);
            } else {
                // 对于Android 6.0以下的设备，使用更简单的方法确保状态栏文字可见
                window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
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
        setupRecyclerView();
        setupSearchView();
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
                menuButton.setColorFilter(android.graphics.Color.WHITE, android.graphics.PorterDuff.Mode.SRC_ATOP);
                break;
            }
        }
    }

    private void setupRecyclerView() {
        recyclerView = findViewById(R.id.commandsRecyclerView);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        
        allPackages = createPackages();
        filteredPackages = new ArrayList<>(allPackages);
        adapter = new WindowsPackageAdapter(filteredPackages, this::onPackageClick);
        recyclerView.setAdapter(adapter);
    }

    private void setupSearchView() {
        searchEditText = findViewById(R.id.searchEditText);
        clearButton = findViewById(R.id.clearButton);
        
        // 设置文本变化监听器
        searchEditText.addTextChangedListener(new android.text.TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filterPackages(s.toString());
                // 显示或隐藏清除按钮
                clearButton.setVisibility(s.length() > 0 ? View.VISIBLE : View.GONE);
            }
            
            @Override
            public void afterTextChanged(android.text.Editable s) {}
        });
        
        // 设置清除按钮点击事件
        clearButton.setOnClickListener(v -> {
            searchEditText.setText("");
        });
    }

    private void filterPackages(String query) {
        filteredPackages.clear();
        
        if (query == null || query.trim().isEmpty()) {
            filteredPackages.addAll(allPackages);
        } else {
            String lowerQuery = query.toLowerCase().trim();
            for (WindowsCommandPackage pkg : allPackages) {
                if (pkg.getTitle().toLowerCase().contains(lowerQuery) ||
                    pkg.getDescription().toLowerCase().contains(lowerQuery)) {
                    filteredPackages.add(pkg);
                }
            }
        }
        
        adapter.notifyDataSetChanged();
    }

    private void onPackageClick(WindowsCommandPackage pkg) {
        // 这里可以根据不同的分类跳转到不同的命令列表页面
        // 暂时先跳转到一个简单的页面，后续可以根据需要扩展
        Intent intent = new Intent(this, WindowsPackageCommandsActivity.class);
        intent.putExtra("package_name", pkg.getName());
        intent.putExtra("package_title", pkg.getTitle());
        intent.putExtra("package_description", pkg.getDescription());
        startActivity(intent);
    }

    private List<WindowsCommandPackage> createPackages() {
        List<WindowsCommandPackage> packages = new ArrayList<>();
        
        WindowsCommandPackage fileDirectory = new WindowsCommandPackage();
        fileDirectory.setName("file_directory");
        fileDirectory.setTitle("文件与目录操作");
        fileDirectory.setDescription("File & Directory");
        fileDirectory.setIcon("file");
        packages.add(fileDirectory);
        
        WindowsCommandPackage systemManagement = new WindowsCommandPackage();
        systemManagement.setName("system_management");
        systemManagement.setTitle("系统管理");
        systemManagement.setDescription("System Management");
        systemManagement.setIcon("system");
        packages.add(systemManagement);
        
        WindowsCommandPackage diskManagement = new WindowsCommandPackage();
        diskManagement.setName("disk_management");
        diskManagement.setTitle("磁盘管理");
        diskManagement.setDescription("Disk Management");
        diskManagement.setIcon("disk");
        packages.add(diskManagement);
        
        WindowsCommandPackage networkManagement = new WindowsCommandPackage();
        networkManagement.setName("network_management");
        networkManagement.setTitle("网络管理");
        networkManagement.setDescription("Network Management");
        networkManagement.setIcon("network");
        packages.add(networkManagement);
        
        WindowsCommandPackage registry = new WindowsCommandPackage();
        registry.setName("registry");
        registry.setTitle("注册表");
        registry.setDescription("Registry");
        registry.setIcon("registry");
        packages.add(registry);
        
        WindowsCommandPackage security = new WindowsCommandPackage();
        security.setName("security");
        security.setTitle("安全");
        security.setDescription("Security");
        security.setIcon("security");
        packages.add(security);
        
        WindowsCommandPackage batchScript = new WindowsCommandPackage();
        batchScript.setName("batch_script");
        batchScript.setTitle("批处理脚本");
        batchScript.setDescription("Batch Script");
        batchScript.setIcon("batch");
        packages.add(batchScript);
        
        WindowsCommandPackage otherTools = new WindowsCommandPackage();
        otherTools.setName("other_tools");
        otherTools.setTitle("其他工具");
        otherTools.setDescription("Other Tools");
        otherTools.setIcon("tools");
        packages.add(otherTools);
        
        return packages;
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