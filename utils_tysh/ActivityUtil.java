package com.wbg.tianyi_sj.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;

import com.wbg.tianyi_sj.R;
import com.wbg.tianyi_sj.activity.LoginActivity;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Activity的工具类
 * Created by WBG-016 on 2016/2/29.
 */
public class ActivityUtil {
    private static final String TAG = "ActivityUtil";

    /**
     * 延迟去往新的Activity
     *
     * @param context
     * @param cls
     * @param delay
     */
    public static void delayToActivity(final Context context, final Class<?> cls, long delay) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                context.startActivity(new Intent(context, cls));
            }
        }, delay);
    }

    /**
     * 跳转到另一个Activity，不携带数据，不设置flag
     *
     * @param context
     * @param cls
     */
    public static void goToActivity(Context context, Class<?> cls) {
        Intent intent = new Intent();
        intent.setClass(context, cls);
        context.startActivity(intent);
    }

    /**
     * go to activity, use animation
     *
     * @param context
     * @param cls
     * @param enterAnim
     * @param exitAnim
     */
    public static void goToActivity(Context context, Class<?> cls, int enterAnim, int exitAnim, Bundle bundle) {
        Activity activity = (Activity) context;
        Intent intent = new Intent();
        intent.setClass(activity, cls);
        intent.putExtras(bundle);
        activity.startActivity(intent);
        activity.overridePendingTransition(enterAnim, exitAnim);
    }

    /**
     * to new activity, use animation from right to left
     *
     * @param context
     * @param cls
     */
    public static void goToActivityFromRight2Left(Context context, Class<?> cls) {
        Activity activity = (Activity) context;
        Intent intent = new Intent();
        intent.setClass(activity, cls);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.in_from_right, R.anim.out_to_right);
    }

    /**
     * to new activity, use animation from right to left carry data
     *
     * @param context
     * @param cls
     */
    public static void goToActivityFromRight2Left(Context context, Class<?> cls, Bundle bundle) {
        Activity activity = (Activity) context;
        Intent intent = new Intent();
        intent.setClass(activity, cls);
        intent.putExtras(bundle);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.in_from_right, R.anim.out_to_right);
    }

    /**
     * to new activity, use animation from left to right
     *
     * @param context
     * @param cls
     */
    public static void goToActivityFromLeft2Right(Context context, Class<?> cls) {
        Activity activity = (Activity) context;
        Intent intent = new Intent();
        intent.setClass(activity, cls);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.in_from_left, R.anim.out_to_left);
    }

    /**
     * to new activity,use animation from left to right carry data
     *
     * @param context
     * @param cls
     */
    public static void goToActivityFromLeft2Right(Context context, Class<?> cls, Bundle bundle) {
        Activity activity = (Activity) context;
        Intent intent = new Intent();
        intent.setClass(activity, cls);
        intent.putExtras(bundle);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.in_from_left, R.anim.out_to_left);
    }

    /**
     * to new activity,use animation from bottom to top
     *
     * @param context
     * @param cls
     */
    public static void goToActivityFromBottom2Top(Context context, Class<?> cls) {
        Activity activity = (Activity) context;
        Intent intent = new Intent();
        intent.setClass(activity, cls);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.in_from_bottom, R.anim.out_to_top);
    }

    /**
     * to new activity,use animation from bottom to top carry data
     *
     * @param context
     * @param cls
     * @param bundle
     */
    public static void goToActivityFromBottom2Top(Context context, Class<?> cls, Bundle bundle) {
        Activity activity = (Activity) context;
        Intent intent = new Intent();
        intent.setClass(activity, cls);
        intent.putExtras(bundle);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.in_from_bottom, R.anim.out_to_top);
    }

    /**
     * to new activity,use animation form top to bottom
     *
     * @param context
     * @param cls
     */
    public static void goToActivityFromTop2Bottom(Context context, Class<?> cls) {
        Activity activity = (Activity) context;
        Intent intent = new Intent();
        intent.setClass(activity, cls);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.in_from_top, R.anim.out_to_bottom);
    }

    /**
     * to new activity,use animation from top to bottom carry data
     *
     * @param context
     * @param cls
     * @param bundle
     */
    public static void goToActivityFromTop2Bottom(Context context, Class<?> cls, Bundle bundle) {
        Activity activity = (Activity) context;
        Intent intent = new Intent();
        intent.setClass(activity, cls);
        intent.putExtras(bundle);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.in_from_top, R.anim.out_to_bottom);
    }

    /**
     * 跳转到另一个Activity，携带数据
     *
     * @param context
     * @param cls
     */
    public static void goToActivity(Context context, Class<?> cls, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(context, cls);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    /**
     * token过期返回到登录界面
     */
    public static void backToLoginActivity(Activity activity) {
        /**
         * token过期返回到登录界面
         */

        //改为未登陆状态
        SpfUtil spf = new SpfUtil(activity,KeyUtil.SPF);
        spf.setLogin(false);

        Intent intent = new Intent(activity, LoginActivity.class);
        activity.finish();
        activity.startActivity(intent);
    }
}
