package com.gyscan_doc.Intro;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.model.KeyPath;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import com.gyscan_doc.MainActivity;
import com.gyscan_doc.R;

public class Intro3 extends AppCompatActivity {

    private GestureDetector gestureDetector;
    private static final int SWIPE_THRESHOLD = 100;
    private static final int SWIPE_VELOCITY_THRESHOLD = 100;
    private static final String PREFS_NAME = "IntroPrefs";
    private static final String KEY_INTRO_SHOWN = "intro_shown";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro3);

        // 设置状态栏颜色
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.theme_blue));
        }

        setupAnimations();
        setupGestureDetector();
        setupStartButton();
        setupVersionText();
    }

    private void setupAnimations() {
        LottieAnimationView icon = findViewById(R.id.introIcon3);
        try {
            icon.setAnimation("animations/3.json");
            // 设置动画颜色为白色
            icon.addValueCallback(
                new KeyPath("**", "Color"),
                LottieProperty.COLOR,
                frameInfo -> Color.WHITE
            );
            icon.playAnimation();
            icon.setRepeatCount(-1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        TextView title = findViewById(R.id.introTitle3);
        TextView desc = findViewById(R.id.introDesc3);
        Button startButton = findViewById(R.id.startButton3);

        View circleTopLeft = findViewById(R.id.circleTopLeft3);
        View circleBottomRight = findViewById(R.id.circleBottomRight3);
        View circleCenter = findViewById(R.id.circleCenter3);
        View line1 = findViewById(R.id.decorativeLine1_3);
        View line2 = findViewById(R.id.decorativeLine2_3);

        long delay = 0;

        // 启用icon动画
        ObjectAnimator iconScaleX = ObjectAnimator.ofFloat(icon, "scaleX", 0f, 1f);
        ObjectAnimator iconScaleY = ObjectAnimator.ofFloat(icon, "scaleY", 0f, 1f);
        ObjectAnimator iconAlpha = ObjectAnimator.ofFloat(icon, "alpha", 0f, 1f);

        AnimatorSet iconAnim = new AnimatorSet();
        iconAnim.playTogether(iconScaleX, iconScaleY, iconAlpha);
        iconAnim.setDuration(800);
        iconAnim.setStartDelay(delay);
        iconAnim.start();

        delay += 200;

        ObjectAnimator titleAlpha = ObjectAnimator.ofFloat(title, "alpha", 0f, 1f);
        ObjectAnimator titleTranslation = ObjectAnimator.ofFloat(title, "translationY", 50f, 0f);

        AnimatorSet titleAnim = new AnimatorSet();
        titleAnim.playTogether(titleAlpha, titleTranslation);
        titleAnim.setDuration(600);
        titleAnim.setStartDelay(delay);
        titleAnim.start();

        delay += 150;

        ObjectAnimator descAlpha = ObjectAnimator.ofFloat(desc, "alpha", 0f, 1f);
        ObjectAnimator descTranslation = ObjectAnimator.ofFloat(desc, "translationY", 50f, 0f);

        AnimatorSet descAnim = new AnimatorSet();
        descAnim.playTogether(descAlpha, descTranslation);
        descAnim.setDuration(600);
        descAnim.setStartDelay(delay);
        descAnim.start();

        delay += 150;

        ObjectAnimator buttonAlpha = ObjectAnimator.ofFloat(startButton, "alpha", 0f, 1f);
        ObjectAnimator buttonScaleX = ObjectAnimator.ofFloat(startButton, "scaleX", 0.8f, 1f);
        ObjectAnimator buttonScaleY = ObjectAnimator.ofFloat(startButton, "scaleY", 0.8f, 1f);

        AnimatorSet buttonAnim = new AnimatorSet();
        buttonAnim.playTogether(buttonAlpha, buttonScaleX, buttonScaleY);
        buttonAnim.setDuration(500);
        buttonAnim.setStartDelay(delay);
        buttonAnim.start();

        ObjectAnimator circleTopLeftAnim = ObjectAnimator.ofFloat(circleTopLeft, "alpha", 0f, 0.15f);
        circleTopLeftAnim.setDuration(1000);
        circleTopLeftAnim.setStartDelay(100);
        circleTopLeftAnim.start();

        ObjectAnimator circleBottomRightAnim = ObjectAnimator.ofFloat(circleBottomRight, "alpha", 0f, 0.15f);
        circleBottomRightAnim.setDuration(1000);
        circleBottomRightAnim.setStartDelay(200);
        circleBottomRightAnim.start();

        ObjectAnimator circleCenterAnim = ObjectAnimator.ofFloat(circleCenter, "alpha", 0f, 0.08f);
        circleCenterAnim.setDuration(1000);
        circleCenterAnim.setStartDelay(300);
        circleCenterAnim.start();

        ObjectAnimator line1Anim = ObjectAnimator.ofFloat(line1, "alpha", 0f, 0.3f);
        line1Anim.setDuration(800);
        line1Anim.setStartDelay(400);
        line1Anim.start();

        ObjectAnimator line2Anim = ObjectAnimator.ofFloat(line2, "alpha", 0f, 0.2f);
        line2Anim.setDuration(800);
        line2Anim.setStartDelay(500);
        line2Anim.start();
    }

    private void setupGestureDetector() {
        gestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                float diffX = e2.getX() - e1.getX();
                if (Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                    if (diffX > 0) {
                        swipeRight();
                        return true;
                    }
                }
                return false;
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event) || super.onTouchEvent(event);
    }

    private void swipeRight() {
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        Intent intent = new Intent(Intro3.this, Intro2.class);
        startActivity(intent);
        finish();
    }

    private void setupStartButton() {
        Button startButton = findViewById(R.id.startButton3);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                markIntroAsShown();
                startMainActivity();
            }
        });
    }
    
    private void setupVersionText() {
        TextView versionText = findViewById(R.id.versionText3);
        if (versionText != null) {
            String version = getString(R.string.app_version);
            String versionTextStr = getString(R.string.app_version_text, version);
            versionText.setText(versionTextStr);
        }
    }



    private void startMainActivity() {
        Intent intent = new Intent(Intro3.this, MainActivity.class);
        intent.putExtra("open_drawer", true);
        startActivity(intent);
        finish();
    }

    private void markIntroAsShown() {
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean(KEY_INTRO_SHOWN, true);
        editor.commit();
    }
}