package com.kevin.firstlineofcode.ui.sectionA;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.kevin.firstlineofcode.R;
import com.kevin.firstlineofcode.ui.base.BaseActivity;

public class SectionAbActivity extends BaseActivity implements GestureDetector.OnGestureListener{

    private TextView tv_1;
    private ImageView img_1;
    private GestureDetector gestureScanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); // 隐藏标题栏
        setContentView(R.layout.activity_section_ab);
        initViews();
    }

    private void initViews() {
        tv_1 = (TextView) findViewById(R.id.activity_section_ab_tv_1);
        img_1 = (ImageView) findViewById(R.id.activity_section_ab_img_1);
        tv_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(getApplicationContext(), SectionAaActivity.class);
            }
        });

        gestureScanner = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener(){
            @Override
            public boolean onDoubleTap(MotionEvent e) {
                if(img_1.getVisibility() == View.VISIBLE){
                    img_1.setVisibility(View.INVISIBLE);
                }else if(img_1.getVisibility() == View.INVISIBLE){
                    img_1.setVisibility(View.VISIBLE);
                }
                return super.onDoubleTap(e);
            }
        });
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureScanner.onTouchEvent(event);
    }
}
