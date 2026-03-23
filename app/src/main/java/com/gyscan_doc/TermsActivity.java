package com.gyscan_doc;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class TermsActivity extends AppCompatActivity {

    private static final String PREFS_NAME = "IntroPrefs";
    private static final String KEY_TERMS_ACCEPTED = "terms_accepted";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
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
        
        setContentView(R.layout.dialog_terms);

        Button btnReject = findViewById(R.id.btnReject);
        final Button btnAccept = findViewById(R.id.btnAccept);

        // 初始时设置同意按钮为不可点击状态，并显示为灰色
        btnAccept.setEnabled(false);
        btnAccept.setBackgroundTintList(getResources().getColorStateList(R.color.hint_text));
        
        // 实现倒计时功能
        final int countdownTime = 10; // 倒计时10秒
        btnAccept.setText("同意 (" + countdownTime + ")");
        
        // 使用Handler实现倒计时，确保在UI线程中更新
        final android.os.Handler handler = new android.os.Handler();
        final int[] remainingTime = {countdownTime};
        
        final Runnable countdownRunnable = new Runnable() {
            @Override
            public void run() {
                remainingTime[0]--;
                if (remainingTime[0] > 0) {
                    btnAccept.setText("同意 (" + remainingTime[0] + ")");
                    handler.postDelayed(this, 1000);
                } else {
                    btnAccept.setEnabled(true);
                    btnAccept.setText("同意");
                    // 恢复按钮的原始颜色
                    btnAccept.setBackgroundTintList(getResources().getColorStateList(R.color.theme_blue));
                }
            }
        };
        
        handler.postDelayed(countdownRunnable, 1000);

        btnReject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putBoolean(KEY_TERMS_ACCEPTED, true);
                editor.apply();

                // 启动主Activity
                Intent intent = new Intent(TermsActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}