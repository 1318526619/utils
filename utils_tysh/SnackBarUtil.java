package com.wbg.tianyi_sj.utils;

import android.content.Context;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.view.View;

/**
 * Created by WBG-016 on 2016/5/16.
 * SnackBar提醒的工具类
 */
public class SnackBarUtil {
    public static void showShort(Context context, String message, View view) {

        Snackbar snackbar = Snackbar.make(view, message, Snackbar.LENGTH_LONG)
                .setAction("知道了", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });

        snackbar.getView().setBackgroundColor(Color.BLUE);
        snackbar.getView().setTop(100);
        snackbar.setActionTextColor(Color.BLUE)
                .show();

    }
}
