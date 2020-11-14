package com.jhao.playdemo.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;

import com.jhao.playdemo.R;
import com.jhao.playdemo.applications.AppListActivity;
import com.jhao.playdemo.bitmap.BitmapActivity;
import com.jhao.playdemo.databinding.ActivityMainBinding;
import com.jhao.playdemo.toucheventdispatch.ToucheventDispatchActivity;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainAdapter.OnItemClickedListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    ActivityMainBinding mBinding;
    private List<String> labels;
    private MainAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initRecyclerView();
    }

    private void initRecyclerView() {
        String[] labelsArr = getResources().getStringArray(R.array.labels);
        labels = Arrays.asList(labelsArr);
        mAdapter = new MainAdapter(this, labels);
        mAdapter.setOnItemClickedListener(this);
        mBinding.btnList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mBinding.btnList.setAdapter(mAdapter);

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume: ");
        System.gc();
    }

    @Override
    public void onItemClick(View view, int pos) {
        Log.e(TAG, "onItemClick: " + pos);
        switch (pos) {
            case 0:
                startActivity(new Intent(this, AppListActivity.class));
                break;
            case 1:
                startActivity(new Intent(this, BitmapActivity.class));
                break;
            case 2:
                startActivity(new Intent(this, ToucheventDispatchActivity.class));
                break;
            default:
                break;
        }
    }
}
