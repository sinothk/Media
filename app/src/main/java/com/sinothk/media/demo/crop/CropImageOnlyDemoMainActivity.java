package com.sinothk.media.demo.crop;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.sinothk.media.R;
import com.sinothk.media.img.crop.CropImageMainActivity;

public class CropImageOnlyDemoMainActivity extends Activity {

    private final int requestCode = 100;
    private ImageView retImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.cropimage_demo_main);

        findViewById(R.id.btn1).setOnClickListener(listener);
        findViewById(R.id.btn2).setOnClickListener(listener);
        findViewById(R.id.btn3).setOnClickListener(listener);
        findViewById(R.id.btn4).setOnClickListener(listener);

        retImg = (ImageView) findViewById(R.id.retImg);
    }

    private View.OnClickListener listener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            int index = 1;
            switch (v.getId()) {
                case R.id.btn1:
                    index = CropImageMainActivity.STYLE_1;
                    break;

                case R.id.btn2:
                    index = CropImageMainActivity.STYLE_2;
                    break;

                case R.id.btn3:
                    index = CropImageMainActivity.STYLE_3;
                    break;

                case R.id.btn4:
                    index = CropImageMainActivity.STYLE_4;
                    break;
            }

            CropImageMainActivity.start(CropImageOnlyDemoMainActivity.this, "/storage/emulated/0/crop.png", requestCode, index);//
        }
    };

    @Override
    protected void onActivityResult(int _requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == _requestCode && resultCode == RESULT_OK) {
            String path = data.getStringExtra("cropImagePath");
            retImg.setImageDrawable(BitmapDrawable.createFromPath(path));
        }
    }
}
