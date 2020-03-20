package com.jhao.iconifydemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.joanzapata.iconify.IconDrawable;
import com.joanzapata.iconify.fonts.FontAwesomeIcons;
import com.joanzapata.iconify.widget.IconButton;
import com.joanzapata.iconify.widget.IconTextView;

public class MainActivity extends AppCompatActivity {

    private IconButton mIconButton;
    private IconDrawable mIconDrawable;
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mIconButton = findViewById(R.id.btn_iconify);
        mImageView = findViewById(R.id.image);
        mIconButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIconButton.setText(" {fa-code} ");
                startActivity(new Intent(MainActivity.this, DisplayActivity.class));
            }
        });

        mIconDrawable = new IconDrawable(this, IconFonts.weixinzhifu)
                .colorRes(R.color.colorGreen)
                .actionBarSize();
        mImageView.setImageDrawable(mIconDrawable);


    }
}
