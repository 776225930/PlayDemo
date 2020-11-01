package com.jhao.playdemo.applications.greendao;

import android.content.Context;

import org.greenrobot.greendao.query.QueryBuilder;

/**
 * @author JiangHao
 * @date 2020/4/23
 * @describe
 */
public class DBManager {
    private static final String DB_NAME = "appinfo.db";
    private static DBManager dbManager;
    private static DaoMaster daoMaster;
    private static DaoMaster.DevOpenHelper devOpenHelper;
    private static DaoSession daoSession;
    private Context mContext;

    /**
     * 使用单例模式获得操作数据库的对象
     *
     * @return
     */
    public static DBManager getInstance() {
        DBManager instance = null;
        if (dbManager == null) {
            synchronized (DBManager.class) {
                if (instance == null) {
                    instance = new DBManager();
                    dbManager = instance;
                }
            }
        }
        return dbManager;
    }

    public void init(Context context) {
        this.mContext = context;
    }

    /**
     * 判断数据库是否存在，如果不存在则创建
     */
    public DaoMaster getDaoMaster() {
        if (daoMaster == null) {
            devOpenHelper = new DaoMaster.DevOpenHelper(mContext, DB_NAME, null);
            daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        }
        return daoMaster;
    }

    /**
     * 完成对数据库的增删查找
     *
     * @return
     */
    public DaoSession getDaoSession() {
        if (daoSession == null) {
            if (daoMaster == null) {
                daoMaster = getDaoMaster();
            }
            daoSession = daoMaster.newSession();
        }
        return daoSession;
    }

    /**
     * 设置debug模式开启或关闭，默认关闭
     */
    public void setDebug(boolean flag) {
        QueryBuilder.LOG_SQL = flag;
        QueryBuilder.LOG_VALUES = flag;
    }

    /**
     * 关闭数据库
     */
    public void closeDataBase() {
        closeHelper();
        calseDaosession();
    }

    private void calseDaosession() {
        if (daoSession != null) {
            daoSession.clear();
            daoSession = null;
        }
    }

    private void closeHelper() {
        if (devOpenHelper != null) {
            devOpenHelper.close();
            devOpenHelper = null;
        }
    }


}
