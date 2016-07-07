package com.wbg.tianyi_sj.utils;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;

/**
 * Created by WBG-016 on 2016/5/16.
 */
public class PermissionUtil {
    /**
     * 定位请求
     */
    public static final int LOCATION_REQUEST_CODE = 1;
    public static final int STORAGE_REQUEST_CODE = 2;
    private static final int CAMERA_REQUEST_CODE = 3;
    private static final int READ_PHONE_STATE_CODE = 4;

    /**
     * 申请定位权限
     *
     * @param activity
     */
    public static boolean acquireLocatePermission(Activity activity) {
        if (ContextCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ToastUtil.showLong("需要定位权限，请选择允许，或者在“设置”>“应用”里配置权限");
            ActivityCompat.requestPermissions(activity,
                    new String[]{Manifest.permission.ACCESS_COARSE_LOCATION,
                            Manifest.permission.ACCESS_FINE_LOCATION},
                    LOCATION_REQUEST_CODE);
            return false;
        }
        return true;
    }

    /**
     * 申请存储权限
     *
     * @param activity
     * @return true：已经有了该权限，false:暂时没有该权限
     */
    public static boolean acquireStoragePermission(final Activity activity) {
        if (ContextCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ToastUtil.showLong("存储权限不足，请选择允许，或者在“设置”>“应用”里配置权限");
            if (ActivityCompat.shouldShowRequestPermissionRationale(activity,
                    Manifest.permission.CAMERA)) {
                //需要向用户解释
                new AlertDialog.Builder(activity)
                        .setTitle("权限")
                        .setMessage("该功能需要访问存储卡")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                ActivityCompat.requestPermissions(activity,
                                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, STORAGE_REQUEST_CODE);
                            }
                        }).show();

            } else {
                ActivityCompat.requestPermissions(activity,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, STORAGE_REQUEST_CODE);
            }

            return false;
        }
        return true;
    }

    /**
     * 读取phone状态信息
     *
     * @param activity
     */
    public static void acquirePhoneState(Activity activity) {
        if (ContextCompat.checkSelfPermission(activity, Manifest.permission.READ_PHONE_STATE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity,
                    new String[]{Manifest.permission.READ_PHONE_STATE}, READ_PHONE_STATE_CODE);
        }
    }

    /**
     * 获取相机权限
     *
     * @param activity
     */
    public static boolean acquireCameraPermission(Activity activity) {
        if (ContextCompat.checkSelfPermission(activity, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            ToastUtil.showLong("相机权限不足，请选择允许，或者在“设置”>“应用”里配置权限");
            ActivityCompat.requestPermissions(activity,
                    new String[]{Manifest.permission.CAMERA}, CAMERA_REQUEST_CODE);
            return false;
        }
        return true;
    }

    /**
     * @param activity
     * @return
     */
    public static boolean hasStoragePermission(Activity activity) {
        if (ContextCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                == PackageManager.PERMISSION_GRANTED) {
            return true;
        }
        return false;
    }

}
