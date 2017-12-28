package com.sinothk.media.demo.preview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.sinothk.media.demo.R;
import com.sinothk.media.img.preview.ImgPreviewMainActivity;

import java.util.ArrayList;

/**
 * Created by 梁玉涛 on 2017/12/28.
 */

public class ImgPreviewMainDemoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.preview_activity_main);

        final ArrayList<String> list = new ArrayList<>();
        list.add("http://static.googleadsserving.cn/pagead/imgad?id=CICAgKDr4ayIUBCsAhj6ATIIfXDRUXsqRq4");
        list.add("http://e.hiphotos.baidu.com/image/h%3D300/sign=f54f7558692762d09f3ea2bf90ed0849/5243fbf2b2119313ecdd35cb6f380cd791238d2b.jpg");
        list.add("http://p4.123.sogoucdn.com/imgu/2017/12/20171228093725_953.jpg");
        list.add("http://p0.123.sogoucdn.com/imgu/2017/12/20171228094103_420.jpg");
        list.add("http://c.hiphotos.baidu.com/image/pic/item/e4dde71190ef76c6255831509716fdfaae5167c7.jpg");
        list.add("http://b.hiphotos.baidu.com/image/pic/item/3c6d55fbb2fb43165467bb692aa4462309f7d3ad.jpg");

        Button button2 = (Button) findViewById(R.id.button);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ImgPreviewMainActivity.start(ImgPreviewMainDemoActivity.this, list, 2);
            }
        });
    }
}
