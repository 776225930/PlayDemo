package com.example.annotationdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.annotationdemo.inject.InjectUtils;
import com.example.annotationdemo.inject.InjectView;

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
}
