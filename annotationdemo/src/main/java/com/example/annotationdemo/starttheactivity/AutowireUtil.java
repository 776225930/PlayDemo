package com.example.annotationdemo.starttheactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/**
 * @author JiangHao
 * @date 2020/4/27
 * @describe
 */
public class AutowireUtil {

    private static final String TAG = AutowireUtil.class.getSimpleName();

    public static void autoWired(Activity activity) {
        Class<? extends Activity> activityClass = activity.getClass();
        Log.e(TAG, "autoWired activityClass == " + activityClass);
        /**
         *  public Intent getIntent() {
         *         return mIntent;
         *     }
         */
        try {
            //拿到Activity的mIntent Field
//            Field mIntentField = activityClass.getDeclaredField("mIntent");
//            Method getIntent = activityClass.getDeclaredMethod("getIntent");
//            getIntent.setAccessible(true);
            //拿到Intent对象
            Intent mIntent = activity.getIntent();
            Log.e(TAG, "autoWired: mIntent == " + mIntent);
            if (mIntent != null) {
                Field[] declaredFields = activityClass.getDeclaredFields();
                for (Field field : declaredFields) {
                    field.setAccessible(true);
                    if (field.isAnnotationPresent(Autowired.class)) {
                        Autowired annotation = field.getAnnotation(Autowired.class);
                        String value = annotation.value();
                        Class<?> type = field.getType();
                        Log.e(TAG, "autoWired: " + type.getName());
                        Bundle extras = mIntent.getExtras();
                        Object fieldValue = extras.get(value);
                        Log.e(TAG, "autoWired: fieldValue == " + fieldValue + " ; " + fieldValue.getClass() + " ; " + type.isArray());
                        if (type.isArray()) {
                            Object[] objects = (Object[]) fieldValue;//反序列化生产的object[]
//                            Class<?> componentType = field.getClass().getComponentType();//错误,返回null,应该使用getType()
                            Class<?> componentType = field.getType().getComponentType();//获得数组的成员类型
                            Log.e(TAG, "autoWired: componentType == " + componentType);
                            //Array.newInstance(clazz,length) 相当于 Clazz[] array = new Clazz[length];
                            //但是clazz未知时候，无法用后者
                            Object newArr = Array.newInstance(componentType, objects.length);
                            for (int i = 0; i < objects.length; i++) {
                                Array.set(newArr, i, objects[i]);
                            }
                            field.set(activity, newArr);
                        } else {
                            field.set(activity, fieldValue);
                        }
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
