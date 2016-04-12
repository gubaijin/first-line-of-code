package com.kevin.firstlineofcode.ui.sectionA;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.kevin.firstlineofcode.R;
import com.kevin.firstlineofcode.ui.base.BaseBarActivity;

public class SectionAaActivity extends BaseBarActivity implements GestureDetector.OnGestureListener{

    private TextView tv_1;
    private ImageView img_1;
    private GestureDetector gestureScanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_aa);
        initViews();
    }

    private void initViews() {
        tv_1 = (TextView) findViewById(R.id.activity_section_aa_tv_1);
        img_1 = (ImageView) findViewById(R.id.activity_section_aa_img_1);
        tv_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(SectionAbActivity.class);
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
        /*gestureScanner.setOnDoubleTapListener(new GestureDetector.OnDoubleTapListener() {
            @Override
            public boolean onSingleTapConfirmed(MotionEvent e) {
                //短快的点击算一次单击
                return false;
            }

            @Override
            public boolean onDoubleTap(MotionEvent e) {
                //双击产生一次效果
                tv_2.setText("protected void onCreate(Bundle savedInstanceState) {\n" +
                        "super.onCreate(savedInstanceState);\n" +
                        "requestWindowFeature(Window.FEATURE_NO_TITLE);\n" +
                        "setContentView(R.layout.first_layout);\n" +
                        "}");
                return false;
            }

            @Override
            public boolean onDoubleTapEvent(MotionEvent e) {
                //双击产生两次效果
                return false;
            }
        });*/
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
