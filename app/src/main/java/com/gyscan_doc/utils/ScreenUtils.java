package com.gyscan_doc.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.graphics.Color;
import android.graphics.PorterDuff;
import androidx.core.content.ContextCompat;
import androidx.appcompat.widget.Toolbar;

public class ScreenUtils {

    public static void setupScreen(Activity activity) {
        setupStatusBar(activity);
        setupDisplayCutout(activity);
        setupImmersiveMode(activity);
    }

    public static void setupStatusBar(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = activity.getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            
            int statusBarColor;
            int currentNightMode = activity.getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
            if (currentNightMode == Configuration.UI_MODE_NIGHT_YES) {
                statusBarColor = ContextCompat.getColor(activity, com.gyscan_doc.R.color.dark_theme_dark_blue);
            } else {
                statusBarColor = ContextCompat.getColor(activity, com.gyscan_doc.R.color.theme_dark_blue);
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
    }

    public static void setupDisplayCutout(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            Window window = activity.getWindow();
            WindowManager.LayoutParams layoutParams = window.getAttributes();
            layoutParams.layoutInDisplayCutoutMode = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES;
            window.setAttributes(layoutParams);
        }
    }

    public static void setupImmersiveMode(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            activity.getWindow().setDecorFitsSystemWindows(false);
        }
    }

    public static void setupToolbar(Toolbar toolbar) {
        if (toolbar != null) {
            for (int i = 0; i < toolbar.getChildCount(); i++) {
                View child = toolbar.getChildAt(i);
                if (child instanceof android.widget.ImageButton) {
                    android.widget.ImageButton button = (android.widget.ImageButton) child;
                    button.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);
                    button.setImageTintList(null);
                } else if (child instanceof androidx.appcompat.widget.AppCompatImageButton) {
                    androidx.appcompat.widget.AppCompatImageButton button = (androidx.appcompat.widget.AppCompatImageButton) child;
                    button.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);
                    button.setImageTintList(null);
                } else if (child instanceof android.view.ViewGroup) {
                    setupToolbarButtons((android.view.ViewGroup) child);
                }
            }
        }
    }

    private static void setupToolbarButtons(android.view.ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View child = viewGroup.getChildAt(i);
            if (child instanceof android.widget.ImageButton) {
                android.widget.ImageButton button = (android.widget.ImageButton) child;
                button.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);
                button.setImageTintList(null);
            } else if (child instanceof androidx.appcompat.widget.AppCompatImageButton) {
                androidx.appcompat.widget.AppCompatImageButton button = (androidx.appcompat.widget.AppCompatImageButton) child;
                button.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);
                button.setImageTintList(null);
            } else if (child instanceof android.widget.ImageView) {
                android.widget.ImageView imageView = (android.widget.ImageView) child;
                imageView.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);
                imageView.setImageTintList(null);
            } else if (child instanceof android.view.ViewGroup) {
                setupToolbarButtons((android.view.ViewGroup) child);
            }
        }
    }

    public static boolean isTablet(Context context) {
        return (context.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) >= Configuration.SCREENLAYOUT_SIZE_LARGE;
    }

    public static boolean isLandscape(Context context) {
        return context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
    }

    public static int getScreenWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static float getScreenDensity(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    public static int dpToPx(Context context, float dp) {
        return (int) (dp * getScreenDensity(context) + 0.5f);
    }

    public static int pxToDp(Context context, float px) {
        return (int) (px / getScreenDensity(context) + 0.5f);
    }

    public static void enableEdgeToEdge(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            activity.getWindow().setDecorFitsSystemWindows(false);
        }
    }

    public static void setNavigationBarColor(Activity activity, int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            activity.getWindow().setNavigationBarColor(color);
        }
    }

    public static void setLightNavigationBar(Activity activity, boolean light) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            int flags = activity.getWindow().getDecorView().getSystemUiVisibility();
            if (light) {
                flags |= View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR;
            } else {
                flags &= ~View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR;
            }
            activity.getWindow().getDecorView().setSystemUiVisibility(flags);
        }
    }
}