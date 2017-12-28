/*
 Copyright (c) 2012 Roman Truba

 Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 documentation files (the "Software"), to deal in the Software without restriction, including without limitation
 the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to
 permit persons to whom the Software is furnished to do so, subject to the following conditions:

 The above copyright notice and this permission notice shall be included in all copies or substantial
 portions of the Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED
 TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH
 THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package com.sinothk.media.img.preview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.sinothk.media.R;
import com.squareup.picasso.Picasso;

public class GalleryImageViewRL extends RelativeLayout {
//    protected Loading loading;
//    protected PhotoView mImageView;

    protected ImageView imageView;

    protected Context mContext;

    public GalleryImageViewRL(Context ctx) {
        super(ctx);
        mContext = ctx;
    }

    public GalleryImageViewRL(Context ctx, AttributeSet attrs) {
        super(ctx, attrs);
        mContext = ctx;
    }

//    public PhotoView getImageView() {
//        return mImageView;
//    }

    @SuppressWarnings("deprecation")
    protected void init() {
//        mImageView = (PhotoView) findViewById(R.id.touchImageView);
//        loading = (Loading) findViewById(R.id.loading);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        imageView = (ImageView) findViewById(R.id.imageView);
        init();
    }

    /**
     * 显示网络图片
     *
     * @param imageUrl
     */
    public void setUrl(final String imageUrl) {//, final PhotoViewAttacher.OnPhotoTapListener onPhotoTapListener
        Picasso.with(mContext)
                .load(imageUrl)
                .placeholder(R.drawable.preview_img_default)
                .error(R.drawable.preview_img_default)
                .into(imageView);

//        Glide.with(mContext).load(imageUrl).placeholder(R.mipmap.img_preview_default)
//                .error(R.mipmap.img_preview_default)
//                .into(imageView);
    }

//    /**
//     * 显示网络图片
//     *
//     * @param imageUrl
//     * @param onPhotoTapListener
//     */
//    public void setUrl(final String imageUrl, final PhotoViewAttacher.OnPhotoTapListener onPhotoTapListener) {
//        StringBuilder urlB;
//        String url = null;
//        if (imageUrl.startsWith("http")) {
//            url = imageUrl;
//        } else {
//            if (!TextUtils.isEmpty(MiscConfigCache.getInstance().getImageHost())) {
//                urlB = new StringBuilder();
//                url = urlB.append(MiscConfigCache.getInstance().getImageHost()).append(imageUrl).append(ImageLoaderUtils.IMAGE_LEVEL_ORG).toString();
//            }
//        }
//
//        RequestListener<String, GlideDrawable> listener = new RequestListener<String, GlideDrawable>() {
//            @Override
//            public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
//                loading.stop();
//                loading.setVisibility(View.GONE);
//
//                if (!ShareGalleryActivity.isShowTipDialog) {
//                    TipDialog.show(getContext(), R.mipmap.warning, "图片加载失败", "重新加载", new OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            TipDialog.dismissDialog();
//
//                            ShareGalleryActivity.isShowTipDialog = false;
//                            setUrl(imageUrl, onPhotoTapListener);
//                        }
//                    });
//
//                    ShareGalleryActivity.isShowTipDialog = true;
//                }
//
//                return false;
//            }
//
//            @Override
//            public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
//                loading.stop();
//                loading.setVisibility(View.GONE);
//                return false;
//            }
//        };
//
//        //placeholder默认error 出错
//        Glide.with(getContext())
//                .load(url)
//                .listener(listener)
//                .error(R.mipmap.ic_default)
//                .into(mImageView);
//
//        mImageView.setOnPhotoTapListener(onPhotoTapListener);
//    }
//
//    /**
//     * 显示本地图片
//     *
//     * @param imageUrl
//     * @param onPhotoTapListener
//     */
//    public void setUrls(final String imageUrl, final PhotoViewAttacher.OnPhotoTapListener onPhotoTapListener) {
//
//        RequestListener<File, GlideDrawable> requestListener = new RequestListener<File, GlideDrawable>() {
//            @Override
//            public boolean onException(Exception e, File model, Target<GlideDrawable> target, boolean isFirstResource) {
//                loading.stop();
//                loading.setVisibility(View.GONE);
//
//                if (!ShareGalleryActivity.isShowTipDialog) {
//                    TipDialog.show(getContext(), R.mipmap.warning, "图片加载失败", "重新加载", new OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            TipDialog.dismissDialog();
//
//                            ShareGalleryActivity.isShowTipDialog = false;
//                            setUrl(imageUrl, onPhotoTapListener);
//                        }
//                    });
//
//                    ShareGalleryActivity.isShowTipDialog = true;
//                }
//
//                return false;
//            }
//
//            @Override
//            public boolean onResourceReady(GlideDrawable resource, File model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
//                loading.stop();
//                loading.setVisibility(View.GONE);
//                return false;
//            }
//        };
//        Glide.with(getContext())
//                .load(new File(imageUrl))
//                .listener(requestListener)
//                .error(R.mipmap.ic_default)
//                .into(mImageView);
//
//        mImageView.setOnPhotoTapListener(onPhotoTapListener);
//    }


}
