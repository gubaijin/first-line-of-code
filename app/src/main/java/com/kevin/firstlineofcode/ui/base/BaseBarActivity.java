package com.kevin.firstlineofcode.ui.base;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.kevin.firstlineofcode.R;

/**
 * Created by Kevin on 2016/4/9.
 */
public class BaseBarActivity extends ActionBarActivity {

    public void showToast(String content){
        Toast.makeText(this, content, Toast.LENGTH_SHORT).show();
    }

    public void openActivity(Context context, Class<?> clz){
        Intent intent = new Intent();
        intent.setClass(context,clz );
        startActivity(intent);
    }

    /**
     * Per the navigation drawer design guidelines, updates the action bar to show the global app
     * 'context', rather than just what's in the current screen.
     * 顶部bar修改
     */
    public void showGlobalContextActionBar(String title) {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setCustomView(R.layout.custom_top_bar);
        TextView titleTv = (TextView) actionBar.getCustomView().findViewById(R.id.custom_top_bar_id);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        if(!title.isEmpty()){
            titleTv.setText(title);
        }else{
            titleTv.setText(R.string.app_name);
        }
    }

}
