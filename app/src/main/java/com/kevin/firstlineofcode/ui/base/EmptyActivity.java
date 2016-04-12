package com.kevin.firstlineofcode.ui.base;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.kevin.firstlineofcode.R;
import com.kevin.firstlineofcode.ui.util.Constants;

public class EmptyActivity extends BaseDoubleClickActivity implements BaseDoubleClickActivity.MyDoubleClickListener {
    private String flg;
    private ImageView mImg_intent1;
    private ImageView mImg_intent2;
    private Button btn_intent5;//intent返回

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty);
        flg = getIntent().getStringExtra(Constants.INTENT_KEY_NAME_ONE);
        initViews();
    }

    private void initViews() {
        mImg_intent1 = (ImageView) findViewById(R.id.img_intent_1);
        mImg_intent2 = (ImageView) findViewById(R.id.img_intent_2);
        btn_intent5 = (Button) findViewById(R.id.btn_intent_5);
        if("intent5".equals(flg)){
            btn_intent5.setVisibility(View.VISIBLE);
            btn_intent5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    doBeforeResultReturn();
                }
            });
        }
        setMyDoubleClickListener(this);
    }

    /**
     * intent5：返回所需执行的逻辑
     */
    private void doBeforeResultReturn() {
        Intent intent = new Intent();
        intent.putExtra("data_return", "Hello world！");
        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    public void doDouble() {
        switch (flg) {
            case "intent1" ://隐式intent1
                if(mImg_intent1.getVisibility() == View.VISIBLE){
                    mImg_intent1.setVisibility(View.INVISIBLE);
                }else if(mImg_intent1.getVisibility() == View.INVISIBLE){
                    mImg_intent1.setVisibility(View.VISIBLE);
                }
            break;
            case "intent2" ://隐式intent2
                if(mImg_intent2.getVisibility() == View.VISIBLE){
                    mImg_intent2.setVisibility(View.INVISIBLE);
                }else if(mImg_intent2.getVisibility() == View.INVISIBLE){
                    mImg_intent2.setVisibility(View.VISIBLE);
                }
                break;
        }
    }

    @Override
    public void onBackPressed() {
        doBeforeResultReturn();
    }
}
