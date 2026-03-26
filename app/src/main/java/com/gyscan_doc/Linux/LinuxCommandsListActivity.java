package com.gyscan_doc.Linux;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.gyscan_doc.utils.ScreenUtils;
import com.gyscan_doc.R;
import java.util.ArrayList;
import java.util.List;

public class LinuxCommandsListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PackageAdapter adapter;
    private EditText searchEditText;
    private ImageButton clearButton;
    private List<CommandPackage> allPackages;
    private List<CommandPackage> filteredPackages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linux_commands_list);

        ScreenUtils.setupScreen(this);

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
        adapter = new PackageAdapter(filteredPackages, this::onPackageClick);
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
            for (CommandPackage pkg : allPackages) {
                if (pkg.getTitle().toLowerCase().contains(lowerQuery) ||
                    pkg.getDescription().toLowerCase().contains(lowerQuery)) {
                    filteredPackages.add(pkg);
                }
            }
        }
        
        adapter.notifyDataSetChanged();
    }

    private void onPackageClick(CommandPackage pkg) {
        Intent intent = new Intent(this, PackageCommandsActivity.class);
        intent.putExtra("package_name", pkg.getName());
        intent.putExtra("package_title", pkg.getTitle());
        intent.putExtra("package_description", pkg.getDescription());
        startActivity(intent);
    }

    private List<CommandPackage> createPackages() {
        List<CommandPackage> packages = new ArrayList<>();
        
        CommandPackage systemService = new CommandPackage();
        systemService.setName("system_service");
        systemService.setTitle("系统核心与服务管理");
        systemService.setDescription("System & Service");
        systemService.setIcon("system");
        packages.add(systemService);
        
        CommandPackage fileDirectory = new CommandPackage();
        fileDirectory.setName("file_directory");
        fileDirectory.setTitle("文件与目录操作");
        fileDirectory.setDescription("File & Directory");
        fileDirectory.setIcon("file");
        packages.add(fileDirectory);
        
        CommandPackage permissionAttribute = new CommandPackage();
        permissionAttribute.setName("permission_attribute");
        permissionAttribute.setTitle("文件权限与属性");
        permissionAttribute.setDescription("Permission & Attribute");
        permissionAttribute.setIcon("permission");
        packages.add(permissionAttribute);
        
        CommandPackage diskFilesystem = new CommandPackage();
        diskFilesystem.setName("disk_filesystem");
        diskFilesystem.setTitle("磁盘管理与文件系统");
        diskFilesystem.setDescription("Disk & Filesystem");
        diskFilesystem.setIcon("disk");
        packages.add(diskFilesystem);
        
        CommandPackage processSystem = new CommandPackage();
        processSystem.setName("process_system");
        processSystem.setTitle("进程与系统状态");
        processSystem.setDescription("Process & System Status");
        processSystem.setIcon("process");
        packages.add(processSystem);
        
        CommandPackage network = new CommandPackage();
        network.setName("network");
        network.setTitle("网络管理");
        network.setDescription("Network");
        network.setIcon("network");
        packages.add(network);
        
        CommandPackage userGroup = new CommandPackage();
        userGroup.setName("user_group");
        userGroup.setTitle("用户与组管理");
        userGroup.setDescription("User & Group");
        userGroup.setIcon("user");
        packages.add(userGroup);
        
        CommandPackage textProcessing = new CommandPackage();
        textProcessing.setName("text_processing");
        textProcessing.setTitle("文本处理工具");
        textProcessing.setDescription("Text Processing");
        textProcessing.setIcon("text");
        packages.add(textProcessing);
        
        CommandPackage searchFilter = new CommandPackage();
        searchFilter.setName("search_filter");
        searchFilter.setTitle("搜索与过滤");
        searchFilter.setDescription("Search & Filter");
        searchFilter.setIcon("search");
        packages.add(searchFilter);
        
        CommandPackage compressArchive = new CommandPackage();
        compressArchive.setName("compress_archive");
        compressArchive.setTitle("压缩与归档");
        compressArchive.setDescription("Compress & Archive");
        compressArchive.setIcon("compress");
        packages.add(compressArchive);
        
        CommandPackage shellEnvironment = new CommandPackage();
        shellEnvironment.setName("shell_environment");
        shellEnvironment.setTitle("Shell 基础与环境");
        shellEnvironment.setDescription("Shell & Environment");
        shellEnvironment.setIcon("shell");
        packages.add(shellEnvironment);
        
        CommandPackage hardwareKernel = new CommandPackage();
        hardwareKernel.setName("hardware_kernel");
        hardwareKernel.setTitle("硬件与内核管理");
        hardwareKernel.setDescription("Hardware & Kernel");
        hardwareKernel.setIcon("hardware");
        packages.add(hardwareKernel);
        
        CommandPackage timeTimezone = new CommandPackage();
        timeTimezone.setName("time_timezone");
        timeTimezone.setTitle("时间与时区");
        timeTimezone.setDescription("Time & Timezone");
        timeTimezone.setIcon("time");
        packages.add(timeTimezone);
        
        CommandPackage securityEncryption = new CommandPackage();
        securityEncryption.setName("security_encryption");
        securityEncryption.setTitle("安全与加密");
        securityEncryption.setDescription("Security & Encryption");
        securityEncryption.setIcon("security");
        packages.add(securityEncryption);
        
        CommandPackage archTools = new CommandPackage();
        archTools.setName("arch_tools");
        archTools.setTitle("Arch 系统工具");
        archTools.setDescription("Arch Linux Tools");
        archTools.setIcon("arch");
        packages.add(archTools);
        
        CommandPackage bootInit = new CommandPackage();
        bootInit.setName("boot_init");
        bootInit.setTitle("系统初始化与引导");
        bootInit.setDescription("Boot & Init");
        bootInit.setIcon("boot");
        packages.add(bootInit);
        
        CommandPackage terminalConsole = new CommandPackage();
        terminalConsole.setName("terminal_console");
        terminalConsole.setTitle("终端与控制台");
        terminalConsole.setDescription("Terminal & Console");
        terminalConsole.setIcon("terminal");
        packages.add(terminalConsole);
        
        CommandPackage systemInfo = new CommandPackage();
        systemInfo.setName("system_info");
        systemInfo.setTitle("系统信息查询");
        systemInfo.setDescription("System Info");
        systemInfo.setIcon("info");
        packages.add(systemInfo);
        
        CommandPackage symbols = new CommandPackage();
        symbols.setName("symbols");
        symbols.setTitle("Shell 符号命令");
        symbols.setDescription("Shell Symbols");
        symbols.setIcon("symbol");
        packages.add(symbols);
        
        CommandPackage otherDistros = new CommandPackage();
        otherDistros.setName("other_distros");
        otherDistros.setTitle("其他发行版与编程管理器命令");
        otherDistros.setDescription("Other Distros & Programming Managers");
        otherDistros.setIcon("distro");
        packages.add(otherDistros);
        
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