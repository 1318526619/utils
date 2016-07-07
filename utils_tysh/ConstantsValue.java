package com.wbg.tianyi_sj.utils;

import android.os.Environment;

/**
 * 常量值
 * Created by WBG-016 on 2016/2/26.
 */
public class ConstantsValue {
    public static final boolean DEBUG = true;
    private static final String IMAGE_APP_PATH_DIR = "/.dafengge/app_img/";
    public static final String IMAGE_APP_PATH = Environment.getExternalStorageDirectory() + IMAGE_APP_PATH_DIR;
}
