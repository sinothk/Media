package com.sinothk.media.img.preview;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sinothk.media.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tijn on 2016/6/17.
 */
public class GalleryPagerAdapter extends PagerAdapter {
    protected final List<String> mResources;
    protected final Context mContext;
    protected LayoutInflater inflater;
    protected List<String> mIsoffinephoto;
//    private PhotoViewAttacher.OnPhotoTapListener onClickListener;

    public GalleryPagerAdapter(Context context, List<String> resources, List<String> imgs) {
        this.mResources = resources;
        if (resources == null) {
            resources = new ArrayList<String>();
        }
        this.mIsoffinephoto = imgs;

        this.mContext = context;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mResources.size();
    }

    @Override
    public Object instantiateItem(ViewGroup collection, final int position) {
        GalleryImageViewRL iv = (GalleryImageViewRL) inflater.inflate(R.layout.preview_img_item, null);

        String imageUrl = mResources.get(position);

//        imageView


//        if (!CollectionUtil.isEmpty(mIsoffinephoto)) {
//            int isoffinephoto = mIsoffinephoto.get(position).getIsoffinephoto();
//            if (isoffinephoto == 1) {
//                iv.setUrls(imageUrl, onClickListener);
//            } else {
        iv.setUrl(imageUrl);
//            }
//        }else {
//            iv.setUrl(imageUrl, onClickListener);
//        }

        collection.addView(iv, 0);
        return iv;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

//    public void setOnClickListener(PhotoViewAttacher.OnPhotoTapListener onClickListener) {
//        this.onClickListener = onClickListener;
//    }
}
