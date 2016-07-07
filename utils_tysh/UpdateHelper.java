package com.wbg.tianyi_sj.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;

import com.wbg.tianyi_sj.bean.VersionBean;
import com.wbg.tianyi_sj.bean.VersionDataBean;
import com.wbg.tianyi_sj.http.URLUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * Created by WBG-016 on 2016/5/25.
 * 校验app版本的工具类,单例模式
 */
public class UpdateHelper {
    private int currentCode;
    private Context context;
    private boolean isValidate = true;

    private static UpdateHelper instance;

    private UpdateHelper() {
    }

    public static UpdateHelper getInstance() {
        if (instance == null) {
            instance = new UpdateHelper();
        }
        return instance;
    }

    /**
     * 弹出对话框 ，提示新版本
     */
    private void updapteDialog(final String url, String descri) {

        new AlertDialog.Builder(context)
                .setTitle("更新")
                .setMessage("有新的版本:\n" + descri)
                .setPositiveButton("更新", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        Uri content_url = Uri.parse(url);
                        intent.setData(content_url);
                        context.startActivity(intent);
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).show();
    }

    /**
     * 验证版本是否是最新的，如果不是，提示用户
     */
    public void validateVersion(Context context) {
        this.context = context;
        if (isValidate) {
            try {
                currentCode = context.getPackageManager()
                        .getPackageInfo(context.getPackageName(), 0)
                        .versionCode;

                LogUtil.i("当前版本号是:" + currentCode);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }

            OkHttpUtils.post().url(URLUtils.VERSION_INFO)
                    .addParams("type", "shop")
                    .build()
                    .execute(new StringCallback() {
                        @Override
                        public void onError(Call call, Exception e) {

                        }

                        @Override
                        public void onResponse(String response) {
                            LogUtil.i("---------版本校验--------------");
                            LogUtil.i(response);
                            try {
                                VersionBean bean = GsonUtil.changeGsonToBean(response, VersionBean.class);
                                if (bean.isState()) {
                                    VersionDataBean data = bean.getData();
                                    int updateCode = Integer.parseInt(data.getVersionCode());
                                    if (updateCode > currentCode) {
                                        isValidate = false;
                                        String descr = data.getDescription();
                                        String updateurl = data.getUrl();
                                        updapteDialog(updateurl, descr);
                                    }
                                }

                            } catch (NumberFormatException e) {
                                e.printStackTrace();
                            }
                        }
                    });
        } else {
            LogUtil.i("已经验证过，不再校验");
        }
    }
}
