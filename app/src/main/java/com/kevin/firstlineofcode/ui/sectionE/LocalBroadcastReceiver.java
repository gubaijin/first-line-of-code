package com.kevin.firstlineofcode.ui.sectionE;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.kevin.firstlineofcode.ui.base.BaseActivity;

/**
 * Created by Kevin on 2016/4/20.
 */
public class LocalBroadcastReceiver extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {
        BaseActivity.showToast(context, "接收到了一条本地广播！");
    }
}
