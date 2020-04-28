package com.example.annotationdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.annotationdemo.inject.InjectUtils;
import com.example.annotationdemo.inject.InjectView;
import com.example.annotationdemo.starttheactivity.ParamActivity;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    @InjectView(R.id.tv_test)
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InjectUtils.injectView(this);
        mTextView.setText("hhaha");

    }

    public void jump(View view) {
        Intent intent = new Intent(this, ParamActivity.class)
                .putExtra("name", "JiangHao")
                .putExtra("boy", true);//页面跳转携带参数
        startActivity(intent);

    }
}
