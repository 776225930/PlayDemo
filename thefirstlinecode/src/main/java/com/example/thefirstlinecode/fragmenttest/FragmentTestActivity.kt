package com.example.thefirstlinecode.fragmenttest

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.thefirstlinecode.R

/**
 * @date   2020/6/3
 * @author JiangHao
 * @describe
 */
class FragmentTestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_test)
    }
}