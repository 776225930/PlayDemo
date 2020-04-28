package com.jhao.playdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AppAdapter mAppAdapter;
    private RecyclerView mRecyclerView;
    private PackageManager mPackageManager;
    private DBUtils mDBUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDBUtils = new DBUtils(this);
        initRecyclerView();
    }

    private void initRecyclerView() {
        mPackageManager = getPackageManager();
        List<PackageInfo> installedPackages = mPackageManager.getInstalledPackages(0);
        ArrayList<HashMap<String, Object>> listItems = new ArrayList<HashMap<String, Object>>();
        final ArrayList<AppInfo> list = new ArrayList<AppInfo>();
        for (PackageInfo packageInfo : installedPackages) {
            AppInfo info = new AppInfo();
            String packageName = packageInfo.packageName;  // 包名
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;  // 应用信息
            String name = applicationInfo.loadLabel(mPackageManager).toString();  // 应用名称
            Drawable icon = applicationInfo.loadIcon(mPackageManager);  // 应用图标
            System.out.println("name==========" + name);
            System.out.println("packageName==========" + packageName);
            info.name = name;
            info.packageName = packageName;
            info.icon = icon;
            // 状态机,通过01状态来表示是否具备某些属性和功能
            int flags = applicationInfo.flags;  // 获取应用标记
            if ((flags & ApplicationInfo.FLAG_EXTERNAL_STORAGE) == ApplicationInfo
                    .FLAG_EXTERNAL_STORAGE) {
                //安装在sdcard
                info.isRom = false;

            } else {
                //安装在手机
                info.isRom = true;
            }

            if ((flags & ApplicationInfo.FLAG_SYSTEM) == ApplicationInfo
                    .FLAG_SYSTEM) {
                //系统应用
                info.isUser = false;

            } else {
                //用户应用
                info.isUser = true;
            }

            if (info.isUser) {
                HashMap<String, Object> map = new HashMap<String, Object>();
                map.put("ItemTitle", name);    //文字
                map.put("ItemImage", icon);   //图片
                listItems.add(map);
            }
            list.add(info);

        }

        System.out.println("listItems==========" + listItems.size());

        mAppAdapter = new AppAdapter(this, list);
        mDBUtils.insertMultStudent(list);
        mAppAdapter.setOnItemClickListener(new AppAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int postation) {
                startApkByPackName(list.get(postation).packageName);
                List<AppInfo> appInfos = mDBUtils.queryAll();
                int i = 0;
                for (AppInfo appInfo : appInfos) {
                    Log.e("AppList", (i++) + " " + appInfo.name);
                }
            }
        });
        mRecyclerView = findViewById(R.id.applist);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(mAppAdapter);
    }

    public void startApkByPackName(String packname) {
        try {
            startActivity(mPackageManager.getLaunchIntentForPackage(packname));
        } catch (Exception e) {
            Toast.makeText(this, "No application. Please contact the administrator.", Toast.LENGTH_SHORT).show();
        }

    }

}
