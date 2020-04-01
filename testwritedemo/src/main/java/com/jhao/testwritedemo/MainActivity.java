package com.jhao.testwritedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "testwritedemo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.activity_main, null);
        setContentView(view);
        checkPermission();
    }

    public void checkPermission() {
        boolean isGranted = true;
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                //如果没有写sd卡权限
                isGranted = false;
            }
            if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                isGranted = false;
            }
            Log.i("cbs", "isGranted == " + isGranted);
            if (!isGranted) {
                requestPermissions(
                        new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission
                                .ACCESS_FINE_LOCATION,
                                Manifest.permission.READ_EXTERNAL_STORAGE,
                                Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        102);
            }
        }

    }

    public void write(View view) {
        String filePath = "/mnt/oem/everobo_v32/test";
        Log.e(TAG, "write  filePath ==  " + filePath);
        File file = new File(filePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("/mnt/oem/everobo_v32/test.txt")));
//            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("/sdcard/test.txt")));
//            bufferedWriter.write("hello !");
//            bufferedWriter.write("hello! ");
//            bufferedWriter.write("hello1! ");
//            bufferedWriter.write("hello2! ");
//            bufferedWriter.write("hello3! ");
            bufferedWriter.append("hello! ");
            bufferedWriter.append("hello1! ");
            bufferedWriter.append("hello2! ");
            bufferedWriter.append(null);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
