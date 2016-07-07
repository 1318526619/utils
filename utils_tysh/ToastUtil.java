package com.wbg.tianyi_sj.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by WBG-016 on 2016/5/4.
 * Toast工具类
 */
public class ToastUtil {
    private static Context mContext;

    private ToastUtil() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    public static boolean isShow = true;

    public static void init(Context context) {
        mContext = context;
    }

    public static void showShort(CharSequence message) {
        if (isShow)
            Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
    }

    /**
     * 短时间显示Toast
     * @param message 资源文件id
     */
    public static void showShort(int message) {
        if (isShow)
            Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
    }

    public static void showLong(CharSequence message) {
        if (isShow)
            Toast.makeText(mContext, message, Toast.LENGTH_LONG).show();
    }

    public static void show(CharSequence message, int duration) {
        if (isShow)
            Toast.makeText(mContext, message, duration).show();
    }

    /**
     * 短时间显示Toast
     *
     * @param context
     * @param message
     */
    public static void showShort(Context context, CharSequence message) {
        if (isShow)
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    /**
     * 短时间显示Toast
     *
     * @param context
     * @param message
     */
    public static void showShort(Context context, int message) {
        if (isShow)
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    /**
     * 长时间显示Toast
     *
     * @param context
     * @param message
     */
    public static void showLong(Context context, CharSequence message) {
        if (isShow)
            Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

    /**
     * 长时间显示Toast
     *
     * @param context
     * @param message
     */
    public static void showLong(Context context, int message) {
        if (isShow)
            Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

    /**
     * 自定义显示Toast时间
     *
     * @param context
     * @param message
     * @param duration
     */
    public static void show(Context context, CharSequence message, int duration) {
        if (isShow)
            Toast.makeText(context, message, duration).show();
    }

    /**
     * 自定义显示Toast时间
     *
     * @param context
     * @param message
     * @param duration
     */
    public static void show(Context context, int message, int duration) {
        if (isShow)
            Toast.makeText(context, message, duration).show();
    }

}
