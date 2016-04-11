package com.kevin.firstlineofcode.ui.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Kevin on 2016/4/9.
 */
public class BaseActivity extends Activity {

    public void showToast(String content){
        Toast.makeText(this, content, Toast.LENGTH_SHORT).show();
    }

    public void openActivity(Context context, Class<?> clz){
        Intent intent = new Intent();
        intent.setClass(context,clz );
        startActivity(intent);
    }
}
