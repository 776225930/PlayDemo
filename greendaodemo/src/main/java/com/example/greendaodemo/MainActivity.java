package com.example.greendaodemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.greendaodemo.db.DaoSession;
import com.example.greendaodemo.db.UserDao;
import com.example.greendaodemo.model.User;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private DaoSession daoSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        daoSession = ((MyApplication) getApplication()).getDaoSession();
    }

    public void insertUser(View view) {

        daoSession.getUserDao().insertOrReplace(new User(14, "Jerry", 18));
        daoSession.getUserDao().insertOrReplace(new User(15, "Tom", 16));
        daoSession.getUserDao().insertOrReplace(new User(16, "Jerry1", 18));
        daoSession.getUserDao().insertOrReplace(new User(17, "Jerry2", 19));
        daoSession.getUserDao().insertOrReplace(new User(18, "Jerry3", 20));
    }

    public void queryUser(View view) {
        User user = daoSession.getUserDao().load(16L);
        Log.e(TAG, "queryUser: " + user);
    }

    public void queryUser2(View view) {
        List<User> tom = daoSession.queryBuilder(User.class)
                .where(UserDao.Properties.Name.like("Jerry0")).list();
        Log.e(TAG, "queryUser2: " + tom);
    }
}
