package com.kevin.firstlineofcode.ui.CustomerView;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import com.kevin.firstlineofcode.R;
import com.kevin.firstlineofcode.ui.base.BaseActivity;

public class Main2Activity extends BaseActivity {
    private Shape mShape;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mShape = (Shape) findViewById(R.id.gbj);
        mShape.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View arg0, MotionEvent event) {
//				获取坐标并改变小球的坐标
                mShape.setCircleX(event.getX());
                mShape.setCircleY(event.getY());
//				通知draw组件重绘
                mShape.invalidate();
//				返回true表明被执行
                return true;
            }
        });
    }

}
