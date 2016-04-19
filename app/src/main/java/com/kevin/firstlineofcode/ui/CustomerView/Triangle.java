package com.kevin.firstlineofcode.ui.CustomerView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Kevin on 2016/4/17.
 */
public class Triangle extends View{
    public Triangle(Context context) {
        super(context);
    }

    public Triangle(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Triangle(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // 创建画笔
        Paint p = new Paint();
        p.setColor(Color.RED);// 设置红色
        p.setAntiAlias(true);// 设置画笔的锯齿效果。 true是去除，大家一看效果就明白了
        // 绘制这个三角形,你可以绘制任意多边形
        Path path = new Path();
        path.moveTo(80, 200);// 此点为多边形的起点
        path.lineTo(120, 250);
        path.lineTo(80, 250);
        path.close(); // 使这些点构成封闭的多边形
        canvas.drawPath(path, p);
    }
}
