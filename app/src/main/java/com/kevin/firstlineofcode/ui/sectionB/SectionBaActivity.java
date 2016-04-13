package com.kevin.firstlineofcode.ui.sectionB;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.kevin.firstlineofcode.R;
import com.kevin.firstlineofcode.ui.base.BaseActivity;
import com.kevin.firstlineofcode.ui.util.Constants;

public class SectionBaActivity extends BaseActivity {

    private ImageView mImagView;
    private ViewPager mViewPager;

    private ImageView img_intent_data;//最优跳转

    /**
     * 对外暴露的跳转至本页面的方法
     * @param context
     * @param data1
     * @param data2
     */
    public static void actionStart(Context context, String data1, String data2){
        Intent intent = new Intent(context, SectionBaActivity.class);
        intent.putExtra("param1", data1);
        intent.putExtra("param2", data2);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_section_ba);
        String val = getIntent().getStringExtra(Constants.INTENT_KEY_NAME_ONE);
        if(null == val || val.isEmpty()){
            val = getIntent().getStringExtra("param1");
        }
        initViews(val);

    }

    private void initViews(String val) {
        if (val.equals("saveInstanceState")) {
            mImagView = (ImageView) findViewById(R.id.img_section_ba_1);
            mImagView.setVisibility(View.VISIBLE);
        }
        if (val.equals("lanuchMode")) {
            mViewPager = (ViewPager) findViewById(R.id.vpag_section_ba_1);
            int[] imgIds = new int[]{R.mipmap.lanuch_standard, R.mipmap.lanuch_single_top, R.mipmap.lanuch_single_task, R.mipmap.lanuch_single_instance};
            final ImageView[] mImageViews = new ImageView[imgIds.length];
            for(int i=0; i < imgIds.length; i++){
                ImageView imageView = new ImageView(this);
                imageView.setBackgroundResource(imgIds[i]);
                imageView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                mImageViews[i] = imageView;
            }

            mViewPager.setAdapter(new PagerAdapter() {
                @Override
                public int getCount() {
                    return mImageViews.length;
                }

                @Override
                public boolean isViewFromObject(View view, Object object) {
                    return view == object;
                }

                @Override
                public Object instantiateItem(ViewGroup container, int position) {
                    container.addView(mImageViews[position % mImageViews.length], 0);
                    return mImageViews[position % mImageViews.length];
                }

                @Override
                public void destroyItem(ViewGroup container, int position, Object object) {
                    container.removeView(mImageViews[position % mImageViews.length]);
                }
            });
            mViewPager.setVisibility(View.VISIBLE);
        }

        if (val.equals("actionStart")) {
            img_intent_data = (ImageView) findViewById(R.id.img_section_ba_2);
            img_intent_data.setVisibility(View.VISIBLE);
        }
    }
}
