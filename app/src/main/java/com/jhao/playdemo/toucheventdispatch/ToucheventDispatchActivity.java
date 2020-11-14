package com.jhao.playdemo.toucheventdispatch;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;

import androidx.appcompat.app.AppCompatActivity;

import com.jhao.playdemo.R;

/**
 * @author JiangHao
 * @date 2020/11/15
 * @describe  1.重写Activity的dispatchTouchEvent不返回super.dispatchTouchEvent(ev)则所有事件到此结束
 */
public class ToucheventDispatchActivity extends AppCompatActivity {
    public   final String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dispatch);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e(TAG, "==> dispatchTouchEvent: " + MotionEvent.actionToString(ev.getAction()));
        return super.dispatchTouchEvent(ev);
        //1.不返回super.dispatchTouchEvent(ev)则所有事件到此结束
//        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e(TAG, "==> onTouchEvent: " + MotionEvent.actionToString(event.getAction()));
        return super.onTouchEvent(event);
    }
}
