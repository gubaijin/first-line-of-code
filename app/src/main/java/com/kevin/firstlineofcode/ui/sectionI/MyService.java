package com.kevin.firstlineofcode.ui.sectionI;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;

import com.kevin.firstlineofcode.R;
import com.kevin.firstlineofcode.ui.base.EmptyActivity;

/**
 * Created by Kevin on 2016/4/22.
 */
public class MyService extends Service{
    private NotificationManager notificationManager;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        Notification.Builder ncb = new Notification.Builder(getApplicationContext());
        ncb.setTicker("测试前台服务");
        ncb.setContentTitle("拉开后的title");
        ncb.setContentText("我们正在进行前台服务测试。");
        ncb.setSmallIcon(R.mipmap.ic_launcher);
        Intent intent = new Intent(getApplicationContext(), EmptyActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        /*ncb.setDeleteIntent(pendingIntent);*/
        ncb.setContentIntent(pendingIntent);
        /*ncb.setFullScreenIntent(pendingIntent,true);*/
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            startForeground(1, ncb.build());
        }else{
            startForeground(1, ncb.getNotification());
        }
    }
}
