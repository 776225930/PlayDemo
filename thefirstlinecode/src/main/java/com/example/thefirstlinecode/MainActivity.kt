package com.example.thefirstlinecode

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn: Button = Button(this)
        btn.setOnClickListener {}
    }

    fun jump(view: View) {
        val intent: Intent = Intent(this, SecondActivity::class.java).apply {
            putExtra("param1", "data1")
            putExtra("param2", "data2")
        }

    }
}
