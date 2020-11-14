package com.jhao.playdemo.toucheventdispatch;

import android.content.Context;
import android.graphics.LinearGradient;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

/**
 * @author JiangHao
 * @date 2020/11/15
 * @describe
 */
public class MyLinearLayout extends LinearLayout {
    public final String TAG = this.getClass().getSimpleName();

    public MyLinearLayout(Context context) {
        super(context);
    }

    public MyLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyLinearLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.w(TAG, "dispatchTouchEvent: " + MotionEvent.actionToString(ev.getAction()));
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.w(TAG, "onInterceptTouchEvent: " + MotionEvent.actionToString(ev.getAction()));
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.w(TAG, "onTouchEvent: " + MotionEvent.actionToString(event.getAction()));
//        return super.onTouchEvent(event);
        if (event.getAction()==MotionEvent.ACTION_MOVE||event.getAction()==MotionEvent.ACTION_MOVE){
            return true;
        }
        return super.onTouchEvent(event);
    }
}
