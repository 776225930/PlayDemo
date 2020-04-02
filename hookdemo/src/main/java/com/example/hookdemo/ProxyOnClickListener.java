package com.example.hookdemo;

import android.util.Log;
import android.view.View;

/**
 * @author JiangHao
 * @date 2020/4/2
 * @describe 定义“要hook的对象”的代理类，并且创建该类的对象
 */
public class ProxyOnClickListener implements View.OnClickListener {
    private static final String TAG = ProxyOnClickListener.class.getSimpleName();
    /**
     * 原来的OnClickListener
     */
    View.OnClickListener mOnClickListener;

    public ProxyOnClickListener(View.OnClickListener onClickListener) {
        mOnClickListener = onClickListener;
    }

    @Override
    public void onClick(View v) {
        Log.e("HookSetOnClickListener", "点击事件被hook到了!");
        if (mOnClickListener != null) {
            mOnClickListener.onClick(v);
        }
    }
}
