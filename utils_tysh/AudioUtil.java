package com.wbg.tianyi_sj.utils;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.util.Log;

import java.io.IOException;

/**
 * Created by WBG-016 on 2016/5/16.
 * 音效提醒的工具类
 */
public class AudioUtil {

    private static final String TAG = LogUtil.TAG;

    /**
     * 有新的订单提醒
     * @param context
     */
    public static void playAlert(Context context){
        MediaPlayer player = new MediaPlayer();
        AssetManager am = context.getAssets();//获得该应用的AssetManager
        try {
            AssetFileDescriptor afd = am.openFd("test.mp3");
            player = new MediaPlayer();
            player.setDataSource(afd.getFileDescriptor());
            Log.i(TAG, "文件大小：" + afd.getDeclaredLength());
            player.prepare();
            player.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
