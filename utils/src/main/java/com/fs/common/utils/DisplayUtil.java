package com.fs.common.utils;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;

/**
 * 显示相关的工具
 */
public class DisplayUtil {
    /**
     * 获取屏幕的宽高
     *
     * @return
     */
    public static int[] getScreenByDisplayMetrics() {
        int[] ints = new int[2];
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ints[0] = displayMetrics.widthPixels;
        ints[1] = displayMetrics.heightPixels;
        return ints;
    }

    /**
     * 获取屏幕的宽高
     *
     * @param context
     * @return
     */
    public static int[] getScreenByResources(Context context) {
        int[] ints = new int[2];
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        ints[0] = displayMetrics.widthPixels;
        ints[1] = displayMetrics.heightPixels;
        return ints;
    }

    /**
     * 获取屏幕的宽高
     *
     * @param activity
     * @return
     */
    public static int[] getScreenByWindowManager(Activity activity) {
        int[] ints = new int[2];
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        ints[0] = defaultDisplay.getWidth();
        ints[1] = defaultDisplay.getHeight();
        return ints;
    }

    /**
     * 获取屏幕的宽高
     *
     * @param activity
     * @return
     */
    public static int[] getScreenByMetrics(Activity activity) {
        int[] ints = new int[2];
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        ints[0] = displayMetrics.widthPixels;
        ints[1] = displayMetrics.heightPixels;
        return ints;
    }

    /**
     * 根据手机的分辨率从 dip 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }


}
