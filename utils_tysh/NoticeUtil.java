package com.wbg.tianyi_sj.utils;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

import com.wbg.tianyi_sj.R;

/**
 * Created by WBG-016 on 2016/5/16.
 */
public class NoticeUtil {
    public static void showHangNotice(Context context) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
//        Intent mIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://blog.csdn.net/itachi85/"));
//        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, mIntent, 0);
//        builder.setContentIntent(pendingIntent);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher));
        builder.setAutoCancel(true);
        builder.setContentTitle("天易商户");
        builder.setContentText("附近有新的单子");
//        设置点击跳转
        PendingIntent hangPendingIntent = PendingIntent.getActivity(context, 0, new Intent(), PendingIntent.FLAG_CANCEL_CURRENT);
        builder.setFullScreenIntent(hangPendingIntent, true);
        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(2, builder.build());
    }
}
