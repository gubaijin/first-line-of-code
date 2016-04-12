package com.kevin.firstlineofcode.ui.base;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;

public abstract class BaseDoubleClickActivity extends BaseActivity implements GestureDetector.OnGestureListener{

    private MyDoubleClickListener myDoubleClickListener;

    private GestureDetector mGestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mGestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener(){
            @Override
            public boolean onDoubleTap(MotionEvent e) {
                myDoubleClickListener.doDouble();
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

    public MyDoubleClickListener getMyDoubleClickListener() {
        return myDoubleClickListener;
    }

    public void setMyDoubleClickListener(MyDoubleClickListener myDoubleClickListener) {
        this.myDoubleClickListener = myDoubleClickListener;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return mGestureDetector.onTouchEvent(event);
    }

    interface MyDoubleClickListener{
        void doDouble();
    }
}
