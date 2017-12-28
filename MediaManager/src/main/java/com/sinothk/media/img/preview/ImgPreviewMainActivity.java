package com.sinothk.media.img.preview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;


import com.sinothk.media.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/2/12.
 */

public class ImgPreviewMainActivity extends AppCompatActivity {

    private static String IMAGE_LIST;
    private List<String> imageList;
    private static int position;

    HackyViewPager shareGalleryViewpager;
    TextView tipTv;

    int currPosition = 0;

    private GalleryPagerAdapter pagerAdapter;

    public static boolean isShowTipDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initData();
        initView();
    }

    public static void start(Activity currActivity, ArrayList<String> imgList, int position) {
        Bundle bundle = new Bundle();
        bundle.putInt("position", position);
        bundle.putSerializable(ImgPreviewMainActivity.IMAGE_LIST, imgList);
        Intent intent = new Intent(currActivity, ImgPreviewMainActivity.class);
        intent.putExtras(bundle);
        currActivity.startActivity(intent);
    }

    public int getLayoutId() {
        return R.layout.preview_img_main_activity;
    }

    public void initData() {
        imageList = (List<String>) getIntent().getSerializableExtra(ImgPreviewMainActivity.IMAGE_LIST);
        position = getIntent().getIntExtra("position", 0);
        currPosition = position;

//        if (!TextUtils.isEmpty(image) && imageList != null) {
//
//            int count = imageList.size();
//            for (int i = 0; i < count; i++) {
//                if (imageList.get(i) != null && image.equals(imageList.get(i))) {
//                    shareGalleryViewpager.setCurrentItem(i);
//                }
//            }
//
//        }
    }

    public void initView() {
        shareGalleryViewpager = (HackyViewPager) this.findViewById(R.id.share_gallery_viewpager);
        tipTv = (TextView) this.findViewById(R.id.tipTv);

        pagerAdapter = new GalleryPagerAdapter(this, imageList, imageList);
        shareGalleryViewpager.setOffscreenPageLimit(3);
        shareGalleryViewpager.setAdapter(pagerAdapter);
        shareGalleryViewpager.setCurrentItem(position);
        // 文本提示
        setCountPage(currPosition + 1);


//        pagerAdapter.setOnClickListener(new PhotoViewAttacher.OnPhotoTapListener() {
//            @Override
//            public void onPhotoTap(View view, float x, float y) {
//                finish();
//            }
//
//            @Override
//            public void onOutsidePhotoTap() {
//                finish();
//            }
//        });


        shareGalleryViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                currPosition = position;
                setCountPage(position + 1);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void setCountPage(int position) {
        if (imageList == null || imageList.size() < 2) {
            tipTv.setVisibility(View.GONE);
        } else {
            tipTv.setVisibility(View.VISIBLE);
            tipTv.setText(position + " / " + imageList.size());
        }
    }


//    HttpHandler handler;

//    private void saveImage(String url, ImageBean imageBean) {
//
//        if (imageBean.getIsoffinephoto() == 1) {
//            Bitmap bitmap = BitmapFactory.decodeFile(url);
//            String filepath = FileUtils.getInnerStorageDirectory();
//            String fileName = new Date().getTime() + "jpg";
//            File file = new File(filepath, fileName);
//            try {
//                FileOutputStream fos = new FileOutputStream(file);
//                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
//                fos.flush();
//                fos.close();
//                UIUtils.showToast("图片已保存");
//            } catch (FileNotFoundException e) {
//                UIUtils.showToast("请检查网络");
//                e.printStackTrace();
//            } catch (IOException e) {
//                UIUtils.showToast("保存出错了");
//                e.printStackTrace();
//            } catch (Exception e) {
//                UIUtils.showToast("保存出错了");
//                e.printStackTrace();
//            }
//        } else {
//            String imgBaseHost = MiscConfigCache.getInstance().getImageHost();
//            if (!TextUtils.isEmpty(url) && !TextUtils.isEmpty(imgBaseHost) && !url.contains(imgBaseHost)) {
//                url = new StringBuilder().append(imgBaseHost).append(url).toString();
//            }
//
//            final String fileDir = FileUtils.getInnerStorageDirectory() + File.separator + "hxyc" + File.separator + "photos" + File.separator;
//            String filepath = fileDir + "hxyc_" + new Date().getTime() + url.substring(url.lastIndexOf("."));
////            String filepath = fileDir + "hxyc_" + new Date().getTime() + url.substring(url.lastIndexOf("."));
//
////        LogUtils.i("文件下载路径：" + url);
////        LogUtils.i("文件保存目录：" + filepath);
//            HttpUtils http = new HttpUtils();
//            handler = http.download(url, filepath,
//                    true,
//                    true, // 如果从请求返回信息中获取到文件名，下载完成后自动重命名。
//                    new RequestCallBack<File>() {
//                        @Override
//                        public void onSuccess(ResponseInfo<File> responseInfo) {
//                            UIUtils.showToast("图片已保存到：" + responseInfo.result.getPath());
//                            sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.parse("file://" + responseInfo.result.getAbsoluteFile())));
//                        }
//
//                        @Override
//                        public void onFailure(HttpException e, String s, ResponseInfo<File> responseInfo) {
//                            UIUtils.showToast("图片保存失败");
//                        }
//                    });
//
//        }
//    }

//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        if (handler != null) {
//            handler.cancel();
//        }
//    }
}
