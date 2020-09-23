package com.example.greendaodemo;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.example.greendaodemo.db.DaoMaster;
import com.example.greendaodemo.db.DaoSession;

/**
 * @author JiangHao
 * @date 2020/9/24
 * @describe
 */
public class MyApplication extends Application {

    private DaoSession mDaoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        initGreenDao();
    }

    private void initGreenDao() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, "user_test.db");
        SQLiteDatabase writableDatabase = devOpenHelper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(writableDatabase);
        mDaoSession = daoMaster.newSession();
    }

    public DaoSession getDaoSession() {
        return mDaoSession;
    }
}
