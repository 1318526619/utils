package com.wbg.tianyi_sj.utils;

import android.os.Environment;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by WBG-016 on 2016/2/26.
 */
public class FileUtil {
    public static final String ROOT = Environment.getExternalStorageDirectory().getPath() + "/nicehair";
    public static final String CAMERA = Environment.getExternalStorageDirectory().getPath() + "/DCIM/Camera/";
    public static final String CACHE_IMG = "/chche/images/";

    /**
     * 应用日志目录文件
     */
    public static String APP_LOG_PATH = ROOT + "log/";

    /**
     * 日志文件路径
     */
    public static String LOGFILE = APP_LOG_PATH + "log.txt";

    /**
     * 读取输入流数据
     *
     * @param inStream
     * @return
     */
    public static byte[] read(InputStream inStream) throws Exception {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, len);
        }
        inStream.close();
        return outStream.toByteArray();
    }

    /**
     * 判断SD是否可以
     */
    public static boolean isSdcardExit() {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            return true;
        }
        return false;
    }

    /**
     * 创建根目录
     *
     * @param path
     */
    public static void createDirFile(String path) {
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdirs();
        }
    }

    /**
     * 创建文件
     *
     * @param path
     * @return 创建的文件
     */
    public static File createNewFile(String path) {
        File file = new File(path);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                return null;
            }
        }
        return file;
    }
}
