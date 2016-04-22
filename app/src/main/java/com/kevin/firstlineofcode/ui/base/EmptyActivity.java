package com.kevin.firstlineofcode.ui.base;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.kevin.firstlineofcode.R;
import com.kevin.firstlineofcode.ui.util.Constants;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class EmptyActivity extends BaseDoubleClickActivity implements BaseDoubleClickActivity.MyDoubleClickListener {
    private String flg;
    private ImageView mImg_intent1;
    private ImageView mImg_intent2;
    private Button btn_intent5;//intent返回

    private ImageView img_photo;

    /**
     * 启动裁剪
     */
    public static final int TAKE_PHOTO = 1;
    /**
     * 将裁剪的图片进行展示
     */
    public static final int CROP_PHOTO = 2;
    Uri imageUri;

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
        img_photo = (ImageView) findViewById(R.id.img_photo);
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
        if(null != flg && !flg.isEmpty()){
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
                case "toPhoto":
                //创建File对象，用于存储拍照后的图片
                File outpustImage = new File(Environment.getExternalStorageDirectory(), "tempImage.jpg");
                if(outpustImage.exists()){
                    outpustImage.delete();
                }
                try {
                    outpustImage.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                imageUri = Uri.fromFile(outpustImage);
                Intent intentImg = new Intent("android.media.action.IMAGE_CAPTURE");
                intentImg.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                startActivityForResult(intentImg, TAKE_PHOTO);
                break;
                case "toPhotoAlbum":
                    //创建File对象，用于存储选择的图片
                    File outputImage = new File(Environment.getExternalStorageDirectory(), "output_image.jpg");
                    if(outputImage.exists()){
                        outputImage.delete();
                    }
                    try {
                        outputImage.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    imageUri = Uri.fromFile(outputImage);
                    Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                    intent.setType("image/*");
                    intent.putExtra("crop", true);
                    intent.putExtra("scale", true);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                    startActivityForResult(intent, CROP_PHOTO);
                    break;
            }
        }else{
            showToast("不知道你要干嘛！");
        }
    }

    @Override
    public void onBackPressed() {
        doBeforeResultReturn();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch(requestCode){
            case TAKE_PHOTO :
                if(resultCode == RESULT_OK){
                    Intent intent = new Intent("com.android.camera.action.CROP");
                    intent.setDataAndType(imageUri, "image/*");
                    intent.putExtra("scale", true);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                    startActivityForResult(intent, CROP_PHOTO);//启动裁剪程序
                }
                break;
            case CROP_PHOTO:
                if(resultCode == RESULT_OK){
                    try {
                        /*Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(imageUri));*/
                        Uri data1 = data.getData(); //当imageUri为空时，可以使用Uri data1 = data.getData();获得
                        Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(data1));
                        img_photo.setImageBitmap(bitmap);//将裁剪后的照片显示出来
                        img_photo.setVisibility(View.VISIBLE);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                break;
        }
    }
}
