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
import androidx.core.content.ContextCompat;

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
    }

    private void setupSystemInfo() {
        // 获取设备制造商
        String manufacturer = android.os.Build.MANUFACTURER;
        // 获取设备型号
        String model = android.os.Build.MODEL;
        // 获取屏幕分辨率
        android.util.DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;
        String resolution = width + "x" + height;
        
        // 查找对应的TextView并设置文本
        // 注意：这里需要根据布局文件中的实际ID来设置
        // 由于布局文件中没有为系统信息部分的TextView设置ID，我们需要遍历查找
        // 或者修改布局文件添加ID
        // 这里我们采用遍历LinearLayout的方式来查找
        LinearLayout systemInfoLayout = findViewById(R.id.systemInfoLayout);
        if (systemInfoLayout != null) {
            for (int i = 0; i < systemInfoLayout.getChildCount(); i++) {
                View child = systemInfoLayout.getChildAt(i);
                if (child instanceof LinearLayout) {
                    LinearLayout row = (LinearLayout) child;
                    if (row.getChildCount() == 2) {
                        TextView label = (TextView) row.getChildAt(0);
                        TextView value = (TextView) row.getChildAt(1);
                        if (label != null && value != null) {
                            if (label.getText().toString().contains("设备制造商")) {
                                value.setText(manufacturer);
                            } else if (label.getText().toString().contains("设备型号")) {
                                value.setText(model);
                            } else if (label.getText().toString().contains("屏幕分辨率")) {
                                value.setText(resolution);
                            }
                        }
                    }
                }
            }
        }
        
        // 检测Root状态
        checkRootStatus();
        
        // 检测内核版本
        checkKernelVersion();
        
        // 检测ABI类型
        checkAbiType();
        
        // 检测SELinux状态
        checkSelinuxStatus();
        
        // 检测Android版本
        checkAndroidVersion();
    }

    private void checkKernelVersion() {
        TextView kernelVersionTextView = findViewById(R.id.kernelVersion);
        if (kernelVersionTextView != null) {
            String kernelVersion = System.getProperty("os.version");
            kernelVersionTextView.setText(kernelVersion);
        }
    }

    private void checkAbiType() {
        TextView abiTypeTextView = findViewById(R.id.abiType);
        if (abiTypeTextView != null) {
            String abiType = android.os.Build.CPU_ABI;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                String[] abis = android.os.Build.SUPPORTED_ABIS;
                if (abis != null && abis.length > 0) {
                    StringBuilder abiBuilder = new StringBuilder();
                    for (int i = 0; i < abis.length; i++) {
                        abiBuilder.append(abis[i]);
                        if (i < abis.length - 1) {
                            abiBuilder.append(", ");
                        }
                    }
                    abiType = abiBuilder.toString();
                }
            }
            abiTypeTextView.setText(abiType);
        }
    }

    private void checkSelinuxStatus() {
        TextView selinuxStatusTextView = findViewById(R.id.selinuxStatus);
        if (selinuxStatusTextView != null) {
            String selinuxStatus = "未知";
            
            // 尝试方法1：执行getenforce命令
            try {
                java.lang.Process process = Runtime.getRuntime().exec("getenforce");
                java.io.BufferedReader reader = new java.io.BufferedReader(
                        new java.io.InputStreamReader(process.getInputStream()));
                selinuxStatus = reader.readLine();
                reader.close();
                process.waitFor();
                
                // 检查是否获取到了有效结果
                if (selinuxStatus != null && !selinuxStatus.trim().isEmpty()) {
                    selinuxStatusTextView.setText(selinuxStatus);
                    return;
                }
            } catch (Exception e) {
                // 方法1失败，继续尝试其他方法
            }
            
            // 尝试方法2：读取系统文件 /sys/fs/selinux/enforce
            try {
                java.io.File file = new java.io.File("/sys/fs/selinux/enforce");
                if (file.exists()) {
                    java.io.BufferedReader reader = new java.io.BufferedReader(
                            new java.io.FileReader(file));
                    String enforce = reader.readLine();
                    reader.close();
                    if ("0".equals(enforce)) {
                        selinuxStatus = "Permissive";
                    } else if ("1".equals(enforce)) {
                        selinuxStatus = "Enforcing";
                    }
                    selinuxStatusTextView.setText(selinuxStatus);
                    return;
                }
            } catch (Exception e) {
                // 方法2失败，继续尝试其他方法
            }
            
            // 尝试方法3：读取系统文件 /proc/self/attr/current
            try {
                java.io.File file = new java.io.File("/proc/self/attr/current");
                if (file.exists()) {
                    java.io.BufferedReader reader = new java.io.BufferedReader(
                            new java.io.FileReader(file));
                    String context = reader.readLine();
                    reader.close();
                    if (context != null && !context.trim().isEmpty()) {
                        selinuxStatus = "已启用";
                        selinuxStatusTextView.setText(selinuxStatus);
                        return;
                    }
                }
            } catch (Exception e) {
                // 方法3失败，继续尝试其他方法
            }
            
            // 尝试方法4：检查SELinux目录是否存在
            try {
                java.io.File selinuxDir = new java.io.File("/sys/fs/selinux");
                if (selinuxDir.exists() && selinuxDir.isDirectory()) {
                    selinuxStatus = "已启用";
                    selinuxStatusTextView.setText(selinuxStatus);
                    return;
                }
            } catch (Exception e) {
                // 方法4失败，保持默认值
            }
            
            // 所有方法都失败，显示"未知"
            selinuxStatusTextView.setText(selinuxStatus);
        }
    }

    private void checkAndroidVersion() {
        // 获取当前Android版本
        int currentVersion = android.os.Build.VERSION.SDK_INT;
        String versionName = android.os.Build.VERSION.RELEASE;
        String androidVersion = versionName + " (API " + currentVersion + ")";
        
        // 最低Android版本要求
        int minVersion = 21; // Android 5.0
        boolean isSufficient = currentVersion >= minVersion;
        String versionStatus = isSufficient ? "满足最低要求" : "不满足最低要求";
        
        // 查找对应的TextView并设置文本
        // 查找软件信息部分的LinearLayout
        LinearLayout softwareInfoLayout = null;
        ViewGroup rootView = (ViewGroup) findViewById(android.R.id.content);
        if (rootView != null) {
            softwareInfoLayout = findSoftwareInfoLayout(rootView);
        }
        
        if (softwareInfoLayout != null) {
            for (int i = 0; i < softwareInfoLayout.getChildCount(); i++) {
                View child = softwareInfoLayout.getChildAt(i);
                if (child instanceof LinearLayout) {
                    LinearLayout row = (LinearLayout) child;
                    if (row.getChildCount() == 2) {
                        TextView label = (TextView) row.getChildAt(0);
                        TextView value = (TextView) row.getChildAt(1);
                        if (label != null && value != null) {
                            if (label.getText().toString().contains("Android版本")) {
                                value.setText(androidVersion);
                            } else if (label.getText().toString().contains("系统要求")) {
                                value.setText(versionStatus);
                                if (isSufficient) {
                                    value.setTextColor(getResources().getColor(R.color.green));
                                } else {
                                    value.setTextColor(getResources().getColor(R.color.red));
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private LinearLayout findSoftwareInfoLayout(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View child = viewGroup.getChildAt(i);
            if (child instanceof LinearLayout) {
                LinearLayout linearLayout = (LinearLayout) child;
                // 检查是否包含软件标题
                for (int j = 0; j < linearLayout.getChildCount(); j++) {
                    View grandChild = linearLayout.getChildAt(j);
                    if (grandChild instanceof TextView) {
                        TextView textView = (TextView) grandChild;
                        if (textView.getText().toString().contains("软件")) {
                            // 找到软件信息部分，返回其下的LinearLayout
                            for (int k = 0; k < linearLayout.getChildCount(); k++) {
                                View greatGrandChild = linearLayout.getChildAt(k);
                                if (greatGrandChild instanceof LinearLayout) {
                                    return (LinearLayout) greatGrandChild;
                                }
                            }
                        }
                    }
                }
                // 递归查找
                LinearLayout result = findSoftwareInfoLayout(linearLayout);
                if (result != null) {
                    return result;
                }
            } else if (child instanceof ViewGroup) {
                // 递归查找
                LinearLayout result = findSoftwareInfoLayout((ViewGroup) child);
                if (result != null) {
                    return result;
                }
            }
        }
        return null;
    }

    private void checkRootStatus() {
        TextView rootStatusTextView = findViewById(R.id.rootStatus);
        if (rootStatusTextView != null) {
            boolean isRooted = isDeviceRooted();
            if (isRooted) {
                rootStatusTextView.setText("已Root");
                rootStatusTextView.setTextColor(getResources().getColor(R.color.red));
            } else {
                rootStatusTextView.setText("未Root");
                rootStatusTextView.setTextColor(getResources().getColor(R.color.green));
            }
        }
    }

    private boolean isDeviceRooted() {
        // 方法1：检查su可执行文件
        String[] paths = {
            "/system/bin/su",
            "/system/xbin/su",
            "/sbin/su",
            "/system/su",
            "/system/bin/.ext/su",
            "/system/usr/sbin/su",
            "/system/app/Superuser.apk"
        };
        
        for (String path : paths) {
            if (new java.io.File(path).exists()) {
                return true;
            }
        }
        
        // 方法2：检查系统属性
        try {
            String buildTags = android.os.Build.TAGS;
            if (buildTags != null && buildTags.contains("test-keys")) {
                return true;
            }
        } catch (Exception e) {
            // 忽略异常
        }
        
        // 方法3：尝试执行su命令
        try {
            Process process = Runtime.getRuntime().exec("su");
            process.destroy();
            return true;
        } catch (Exception e) {
            // 忽略异常
        }
        
        return false;
    }

    private void openUrl(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
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