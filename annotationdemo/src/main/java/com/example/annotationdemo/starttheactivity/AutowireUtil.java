package com.example.annotationdemo.starttheactivity;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;

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
                        String typeName = field.getType().getName();
                        Log.e(TAG, "autoWired: " + typeName);
                        if ("boolean".equals(typeName.toString())) {
                            boolean booleanExtra = mIntent.getBooleanExtra(value, false);
                            field.set(activity, booleanExtra);
                        } else if ("java.lang.String".equals(typeName.toString())) {
                            String stringExtra = mIntent.getStringExtra(value);
                            field.set(activity, stringExtra);
                        }
//                        if ("name".equals(annotation.value())) {
//                            field.set(activity, mIntent.getStringExtra("name"));
//                        } else if ("name".equals(annotation.value())) {
//                            field.set(activity, mIntent.getBooleanExtra("isBoy", false));
//                        }
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
