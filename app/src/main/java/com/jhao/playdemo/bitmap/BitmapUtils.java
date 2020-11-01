package com.jhao.playdemo.bitmap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.jhao.playdemo.R;

/**
 * @author JiangHao
 * @date 2020/11/1
 * @describe
 */
public class BitmapUtils {


    private static final String TAG = BitmapUtils.class.getSimpleName();

    public static Bitmap decodeSampledBitmapFromResource(Resources resources, int resId, int requestWidth, int requestHeight) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(resources, R.drawable.bitmap_t1, options);
        Log.e(TAG, "decodeSampleedBitmapFromResource: outWidth == " + options.outWidth + ", outHeight == " + options.outHeight);
        //计算合适的采样率
        options.inSampleSize = calculateInSampleSize(options, requestWidth, requestHeight);
        Log.e(TAG, "decodeSampleedBitmapFromResource: opted  outWidth == " + options.outWidth + ", outHeight == " + options.outHeight);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(resources, R.drawable.bitmap_t1, options);
    }

    private static int calculateInSampleSize(BitmapFactory.Options options, int requestWidth, int requestHeight) {
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;
        if (height > requestHeight || width > requestWidth) {
            final int halfHeight = height / 2;
            final int halfWidth = width / 2;
            while ((halfHeight / inSampleSize) >= requestHeight &&
                    (halfWidth / inSampleSize) >= requestWidth) {
                inSampleSize *= 2;
            }
        }
        return inSampleSize;
    }

}
