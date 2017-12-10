package com.sinothk.media.img.compress;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 梁玉涛 on 2017/12/10.
 * 功能：
 */

public class CompressUtil {

    public static void compressPhotos(ArrayList<String> pathList, CompressCallback compressCallback) {

    }

    public interface CompressCallback {
        void onCompressed(List<String> imgPathList);
    }
}
