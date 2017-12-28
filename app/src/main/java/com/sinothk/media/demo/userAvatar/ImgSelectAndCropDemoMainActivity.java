package com.sinothk.media.demo.userAvatar;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.Toast;

import com.sinothk.media.demo.R;
import com.sinothk.media.img.crop.CropImageMainActivity;
import com.sinothk.media.img.multiImageSelector.MultiImageSelector;
import com.sinothk.media.img.multiImageSelector.MultiImageSelectorActivity;

import java.util.ArrayList;

public class ImgSelectAndCropDemoMainActivity extends Activity {

    private final int CROP_IMG_CODE = 100;
    int IMAGE_FROM_PHOTOS = 2;// 从相册选择

    private ImageView retImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.user_avatar_select_crop_demo_main);

        findViewById(R.id.button).setOnClickListener(listener);

        retImg = (ImageView) findViewById(R.id.retImg);
    }

    private View.OnClickListener listener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            MultiImageSelector.create().showCamera(true).single().start(ImgSelectAndCropDemoMainActivity.this, IMAGE_FROM_PHOTOS);
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (requestCode == IMAGE_FROM_PHOTOS) {
            try {// 选择照片返回
                if (data != null) {
                    ArrayList<String> pathList = data.getStringArrayListExtra(MultiImageSelectorActivity.EXTRA_RESULT);
                    String path = pathList.get(0);

                    // 选完后，去剪切
                    CropImageMainActivity.start(ImgSelectAndCropDemoMainActivity.this, path, CROP_IMG_CODE);
                }
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(this, "选择照片返回出错了", Toast.LENGTH_SHORT).show();
            }

        } else if (requestCode == CROP_IMG_CODE && resultCode == RESULT_OK) {
            try {// 剪切后
                String path = data.getStringExtra("cropImagePath");
                retImg.setImageDrawable(BitmapDrawable.createFromPath(path));
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(this, "剪切后返回出错了", Toast.LENGTH_SHORT).show();
            }

        }
    }
}
