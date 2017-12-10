package com.sinothk.media.img.compress;

import android.graphics.Bitmap;
import android.util.Log;

import com.sinothk.media.image.tiny.Tiny;
import com.sinothk.media.image.tiny.callback.FileBatchCallback;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 梁玉涛 on 2017/12/10.
 * 功能：
 */

public class CompressUtil {

    public static void compressPhotos(ArrayList<String> pathList, final CompressBack compressCallback) {
        String[] pathString = pathList.toArray(new String[pathList.size()]);
        compress(pathString, new CompressCallback() {
            @Override
            public void compressed(final Object obj) {
                if (obj == null) {
                    Log.e("a", "a=" + "compress bitmap failed!");
                } else {
                    final String[] ps = ((String[]) obj);
                    String content = "";

                    List<String> tempImgPathList = new ArrayList<>();

                    for (int i = 0; i < ps.length; i++) {
                        content = content + ps[i] + ", ";
                        tempImgPathList.add(ps[i]);
                    }

                    Log.e("压缩结果：", "path = " + content);
                    compressCallback.onCompressed(tempImgPathList);
                }
            }
        });
    }

    public static void compress(final String[] pathArray, final CompressCallback callback) {
        Tiny.FileCompressOptions compressOptions = new Tiny.FileCompressOptions();
        compressOptions.config = Bitmap.Config.ARGB_8888;// Bitmap.Config.RGB_565

        Tiny.getInstance().source(pathArray).batchAsFile().withOptions(compressOptions).batchCompress(new FileBatchCallback() {
            @Override
            public void callback(boolean isSuccess, String[] outfile) {
                if (!isSuccess) {
                    callback.compressed(null);
                    return;
                }
                callback.compressed(outfile);
            }
        });
    }


    // 定义回调接口
    public interface CompressCallback {
        void compressed(Object obj);
    }

    public interface CompressBack {
        public void onCompressed(List<String> imgPathList);
    }
}
