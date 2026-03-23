package com.gyscan_doc.CyberSecurity;

import android.content.Intent;
import android.graphics.Color;
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

public class CyberSecurityListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SecurityPackageAdapter adapter;
    private EditText searchEditText;
    private ImageButton clearButton;
    private List<SecurityPackage> allPackages;
    private List<SecurityPackage> filteredPackages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linux_commands_list);

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
        adapter = new SecurityPackageAdapter(filteredPackages, this::onPackageClick);
        recyclerView.setAdapter(adapter);
    }

    private void setupSearchView() {
        searchEditText = findViewById(R.id.searchEditText);
        clearButton = findViewById(R.id.clearButton);
        
        searchEditText.addTextChangedListener(new android.text.TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filterPackages(s.toString());
                clearButton.setVisibility(s.length() > 0 ? View.VISIBLE : View.GONE);
            }
            
            @Override
            public void afterTextChanged(android.text.Editable s) {}
        });
        
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
            for (SecurityPackage pkg : allPackages) {
                if (pkg.getTitle().toLowerCase().contains(lowerQuery) ||
                    pkg.getDescription().toLowerCase().contains(lowerQuery)) {
                    filteredPackages.add(pkg);
                }
            }
        }
        
        adapter.notifyDataSetChanged();
    }

    private void onPackageClick(SecurityPackage pkg) {
        Intent intent = new Intent(this, SecurityPackageCommandsActivity.class);
        intent.putExtra("package_name", pkg.getName());
        intent.putExtra("package_title", pkg.getTitle());
        intent.putExtra("package_description", pkg.getDescription());
        startActivity(intent);
    }

    private List<SecurityPackage> createPackages() {
        List<SecurityPackage> packages = new ArrayList<>();
        
        SecurityPackage reverseEngineering = new SecurityPackage();
        reverseEngineering.setName("reverse_engineering");
        reverseEngineering.setTitle("逆向分析工具");
        reverseEngineering.setDescription("Reverse Engineering");
        reverseEngineering.setIcon("reverse");
        packages.add(reverseEngineering);
        
        SecurityPackage networkScanning = new SecurityPackage();
        networkScanning.setName("network_scanning");
        networkScanning.setTitle("网络扫描工具");
        networkScanning.setDescription("Network Scanning");
        networkScanning.setIcon("scanning");
        packages.add(networkScanning);
        
        SecurityPackage packetCapture = new SecurityPackage();
        packetCapture.setName("packet_capture");
        packetCapture.setTitle("网络抓包工具");
        packetCapture.setDescription("Packet Capture");
        packetCapture.setIcon("capture");
        packages.add(packetCapture);
        
        SecurityPackage penetrationFramework = new SecurityPackage();
        penetrationFramework.setName("penetration_framework");
        penetrationFramework.setTitle("渗透测试框架");
        penetrationFramework.setDescription("Penetration Framework");
        penetrationFramework.setIcon("penetration");
        packages.add(penetrationFramework);
        
        SecurityPackage logAnalysis = new SecurityPackage();
        logAnalysis.setName("log_analysis");
        logAnalysis.setTitle("日志分析工具");
        logAnalysis.setDescription("Log Analysis");
        logAnalysis.setIcon("log");
        packages.add(logAnalysis);
        
        SecurityPackage vulnerabilityAnalysis = new SecurityPackage();
        vulnerabilityAnalysis.setName("vulnerability_analysis");
        vulnerabilityAnalysis.setTitle("漏洞分析工具");
        vulnerabilityAnalysis.setDescription("Vulnerability Analysis");
        vulnerabilityAnalysis.setIcon("vulnerability");
        packages.add(vulnerabilityAnalysis);
        
        SecurityPackage databaseAnalysis = new SecurityPackage();
        databaseAnalysis.setName("database_analysis");
        databaseAnalysis.setTitle("数据库分析工具");
        databaseAnalysis.setDescription("Database Analysis");
        databaseAnalysis.setIcon("database");
        packages.add(databaseAnalysis);
        
        SecurityPackage passwordAttack = new SecurityPackage();
        passwordAttack.setName("password_attack");
        passwordAttack.setTitle("密码攻击工具");
        passwordAttack.setDescription("Password Attack");
        passwordAttack.setIcon("password");
        packages.add(passwordAttack);
        
        SecurityPackage wirelessAttack = new SecurityPackage();
        wirelessAttack.setName("wireless_attack");
        wirelessAttack.setTitle("无线攻击工具");
        wirelessAttack.setDescription("Wireless Attack");
        wirelessAttack.setIcon("wireless");
        packages.add(wirelessAttack);
        
        SecurityPackage exploitation = new SecurityPackage();
        exploitation.setName("exploitation");
        exploitation.setTitle("漏洞利用工具");
        exploitation.setDescription("Exploitation");
        exploitation.setIcon("exploitation");
        packages.add(exploitation);
        
        SecurityPackage forensics = new SecurityPackage();
        forensics.setName("forensics");
        forensics.setTitle("取证验证工具");
        forensics.setDescription("Forensics");
        forensics.setIcon("forensics");
        packages.add(forensics);
        
        SecurityPackage reportingTools = new SecurityPackage();
        reportingTools.setName("reporting_tools");
        reportingTools.setTitle("报告工具");
        reportingTools.setDescription("Reporting Tools");
        reportingTools.setIcon("report");
        packages.add(reportingTools);
        
        SecurityPackage socialEngineering = new SecurityPackage();
        socialEngineering.setName("social_engineering");
        socialEngineering.setTitle("社会工程学工具");
        socialEngineering.setDescription("Social Engineering");
        socialEngineering.setIcon("social");
        packages.add(socialEngineering);
        
        SecurityPackage passwordGeneration = new SecurityPackage();
        passwordGeneration.setName("password_generation");
        passwordGeneration.setTitle("密码生成工具");
        passwordGeneration.setDescription("Password Generation");
        passwordGeneration.setIcon("password");
        packages.add(passwordGeneration);
        
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