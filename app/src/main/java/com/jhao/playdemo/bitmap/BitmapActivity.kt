package com.jhao.playdemo.bitmap

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.jhao.playdemo.R
import kotlinx.android.synthetic.main.activity_bitmap.*

class BitmapActivity : AppCompatActivity() {
    lateinit var bitmap: Bitmap;

    companion object {
        val TAG = BitmapActivity::class.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bitmap)
        //2560x1600
//        bitmap = BitmapUtils.decodeSampledBitmapFromResource(resources, R.drawable.bitmap_t1, 256, 160)
//        imageView.setImageBitmap(bitmap)
        imageView.setImageResource(R.drawable.bitmap_t1)

    }

    override fun onDestroy() {
        super.onDestroy()
//        bitmap.recycle()
    }


}