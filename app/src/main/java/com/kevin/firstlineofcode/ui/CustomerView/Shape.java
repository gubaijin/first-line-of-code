package com.kevin.firstlineofcode.ui.CustomerView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Kevin on 2016/4/17.
 */
public class Shape extends View{
    private Round mRound;
    private Triangle mTriangle;

    private float circleX = 40;
    private float circleY = 50;
    private float circleR = 15;
    public Shape(Context context) {
        super(context);
    }

    public Shape(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Shape(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        mRound = new Round(getContext());
        mTriangle = new Triangle(getContext());
        //创建画笔
        Paint paint = new Paint();
//		设置画笔颜色
        paint.setColor(Color.RED);
//		画出小球
        canvas.drawCircle(circleX, circleY, circleR, paint);
        for(int i=0; i < 100; i++){
            canvas.drawCircle(circleX + 5, circleY+5, circleR+5, paint);
        }
    }

    public float getCircleX() {
        return circleX;
    }

    public void setCircleX(float circleX) {
        this.circleX = circleX;
    }

    public float getCircleY() {
        return circleY;
    }

    public void setCircleY(float circleY) {
        this.circleY = circleY;
    }

    public float getCircleR() {
        return circleR;
    }

    public void setCircleR(float circleR) {
        this.circleR = circleR;
    }

    public Round getmRound() {
        return mRound;
    }

    public void setmRound(Round mRound) {
        this.mRound = mRound;
    }

    public Triangle getmTriangle() {
        return mTriangle;
    }

    public void setmTriangle(Triangle mTriangle) {
        this.mTriangle = mTriangle;
    }
}
