package com.gyscan_doc;

import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.media3.common.MediaItem;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.ui.PlayerView;
import androidx.media3.ui.AspectRatioFrameLayout;

public class EasterEggActivity extends AppCompatActivity {

    private ExoPlayer player;
    private PlayerView playerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easter_egg);

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
        setupPlayer();
    }

    private void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("彩蛋");
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
    }

    private void setupPlayer() {
        playerView = findViewById(R.id.playerView);
        
        try {
            // 创建ExoPlayer实例
            player = new ExoPlayer.Builder(this).build();
            playerView.setPlayer(player);
            
            // 准备播放raw资源
            String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.age;
            MediaItem mediaItem = MediaItem.fromUri(videoPath);
            player.setMediaItem(mediaItem);
            
            // 设置循环播放
            player.setRepeatMode(ExoPlayer.REPEAT_MODE_ALL);
            
            // 准备并开始播放
            player.prepare();
            player.play();
            
            // 确保音量最大
            player.setVolume(1.0f);
            
            // 显示成功提示
            android.widget.Toast.makeText(this, "视频准备完成，开始播放", android.widget.Toast.LENGTH_SHORT).show();
            
        } catch (Exception e) {
            e.printStackTrace();
            android.widget.Toast.makeText(this, "加载视频失败: " + e.getMessage(), android.widget.Toast.LENGTH_LONG).show();
            // 尝试备选方案：显示错误信息
            android.widget.TextView tipTextView = findViewById(R.id.tipTextView);
            tipTextView.setText("加载视频失败: " + e.getMessage());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 释放播放器资源
        if (player != null) {
            player.release();
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