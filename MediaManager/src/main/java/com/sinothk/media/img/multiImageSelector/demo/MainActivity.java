package com.sinothk.media.img.multiImageSelector.demo;

//import android.content.Intent;
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.view.View;
//import android.widget.Button;
//import android.widget.TextView;
//
//import com.sinothk.media.img.multiImageSelector.MultiImageSelector;
//import com.sinothk.media.img.multiImageSelector.MultiImageSelectorActivity;
//
//import java.util.ArrayList;
//
//public class MainActivity extends AppCompatActivity {
//
//    int IMAGE_FROM_PHOTOS = 2;// 从相册选择
//
//    TextView textView;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        textView = (TextView) findViewById(R.id.textView);
//        Button button2 = (Button) findViewById(R.id.button2);
//        button2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
////                MultiImageSelector.create().single().showCamera(true).start(MainActivity.this, IMAGE_FROM_PHOTOS);
//                MultiImageSelector.create().showCamera(true).start(MainActivity.this, IMAGE_FROM_PHOTOS);
//            }
//        });
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        // 选择照片返回
//        try {
//            if (data != null) {
//                ArrayList<String> path = data.getStringArrayListExtra(MultiImageSelectorActivity.EXTRA_RESULT);
//
//                String s = "";
//                for (int i = 0; i < path.size(); i++) {
//                    s += path.get(i);
//                }
//                textView.setText(s);
////                imageProcessor!!.compressPhoto(2, path, imageCompressCallback)
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//
//}
