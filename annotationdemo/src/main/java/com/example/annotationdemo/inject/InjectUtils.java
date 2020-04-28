package com.example.annotationdemo.inject;

import android.app.Activity;
import android.view.View;

import java.lang.reflect.Field;

/**
 * @author JiangHao
 * @date 2020/4/27
 * @describe
 */
public class InjectUtils {

    public static void injectView(Activity activity) {
        Class<? extends Activity> activityClass = activity.getClass();
        //获取累的所有成员
        Field[] declaredFields = activityClass.getDeclaredFields();
        //判断属性是否被InjectView注解声明
        for (Field field : declaredFields) {
            if (field.isAnnotationPresent(InjectView.class)) {
                //获取注解
                InjectView injectView = field.getAnnotation(InjectView.class);
                //获取注解中的值
                int resId = injectView.value();
                View view = activity.findViewById(resId);
                //修改访问权限
                field.setAccessible(true);
                //使用反射设置field的值view,允许操作private的属性
                try {
                    field.set(activity, view);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
