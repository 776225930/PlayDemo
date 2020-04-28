package com.example.hookdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.NotificationManager;
import android.content.ClipboardManager;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

/**
 * @author JiangHao
 * @date 2020/4/2
 * @describe HooK Notification
 */
public class HookNotifitionActivity extends AppCompatActivity {
    private NotificationManager mNotificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hook_notifition);
        mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//        ClipboardManager

    }
}
