package com.wbg.tianyi_sj.utils;

import android.util.Log;

/**
 * Created by WBG-016 on 2016/5/3.
 * 声明日志标签
 */
public class LogUtil {
    public static final String TAG = "wubaigang";
    public static final boolean enable = true;

    public static void i(String mes) {
        if (enable) {
            Log.i(TAG, mes);
        }
    }

    public static void e(String mes) {
        if (enable) {
            Log.i(TAG, mes);
        }
    }
}
