package com.example.hookdemo;

import android.content.Context;
import android.util.Log;
import android.view.View;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author JiangHao
 * @date 2020/4/2
 * @describe
 */
public class HookSetOnClickListenerHelper {

    /**
     * hook的核心代码
     * 这个方法的唯一目的：用自己的点击事件，替换掉 View原来的点击事件
     *
     * @param view hook的范围仅限于这个view
     */
    public static void hook(Context context, View view) {
        try {
            //1.通过反射执行View类的getListenerInfo()方法,拿到点击事件mOnClickListener的持有者mListenerInfo
            Method getListenerInfoMethod = View.class.getDeclaredMethod("getListenerInfo");
            getListenerInfoMethod.setAccessible(true);//修改方法访问权限
            Object mListenerInfo = getListenerInfoMethod.invoke(view);//拿到mListenerInfo对象，也就是点击事件的持有者

            //获取当前的点击事件对象,ListenerInfo#mOnClickListener
            Class<?> listenerInfoClazz = Class.forName("android.view.View$ListenerInfo");
            Field mOnClickListenerField = listenerInfoClazz.getDeclaredField("mOnClickListener");
            final View.OnClickListener onClickListener = (View.OnClickListener) mOnClickListenerField.get(mListenerInfo);

            //2.创建自定义的点击事件代理类
            //   方式1：自己创建代理类
            //   ProxyOnClickListener proxyOnClickListener = new ProxyOnClickListener(onClickListenerInstance);
            //   方式2：由于View.OnClickListener是一个接口，所以可以直接用动态代理模式
            // Proxy.newProxyInstance的3个参数依次分别是：
            // 本地的类加载器;
            // 代理类的对象所继承的接口（用Class数组表示，支持多个接口）
            // 代理类的实际逻辑，封装在new出来的InvocationHandler内、
            Object newProxyInstance = Proxy.newProxyInstance(context.getClass().getClassLoader(), new Class[]{View.OnClickListener.class}, new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    Log.e("HookSetOnClickListener", "点击事件被hook到了,do somethiong ...");//加入自己的逻辑
                    return method.invoke(onClickListener, args);
                }
            });
            //3.使用自定义的点击事件代理类,设置到“持有者”中
            mOnClickListenerField.set(mListenerInfo, newProxyInstance);
            //done
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
