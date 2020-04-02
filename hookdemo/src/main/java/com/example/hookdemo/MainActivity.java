package com.example.hookdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button mHookButton;
    private Button mNotHookButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mHookButton = findViewById(R.id.btn_hook);
        mNotHookButton = findViewById(R.id.btn_nothook);
        mHookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("HookSetOnClickListener", "onClick: I had Hook");
                Toast.makeText(MainActivity.this, "click click... ", Toast.LENGTH_SHORT).show();
            }
        });
        HookSetOnClickListenerHelper.hook(this, mHookButton);
        mNotHookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("HookSetOnClickListener", "onClick: Im not Hook");
            }
        });
    }

    /**
     * 当我们要创建的代理类，是被接口所约束的时候,
     * 比如创建ProxyOnClickListener implements View.OnClickListener,
     * 只实现了一个接口,则可以使用JDK提供的Proxy类来创建代理对象
     */
//    Object proxyOnclickListener = Proxy.newProxyInstance(getClassLoader(), new Class[]{View.OnClickListener.class}, new InvocationHandler() {
//        @Override
//        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//            Log.d("HookSetOnClickListener", "点击事件被hook到了");//加入自己的逻辑
//            return method.invoke(proxy, args);
//
//        }
//    });
}
