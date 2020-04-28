package com.jhao.playdemo;

import android.content.Context;

import com.jhao.playdemo.greendao.AppInfoDao;
import com.jhao.playdemo.greendao.DaoSession;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

/**
 * @author JiangHao
 * @date 2020/4/23
 * @describe
 */
public class DBUtils {

    private static final boolean DUBUG = true;
    private DBManager mDBManager;
    private AppInfoDao mAppInfoDao;
    private DaoSession mDaoSession;

    public DBUtils(Context context) {
        mDBManager = DBManager.getInstance();
        mDBManager.init(context);
        mDaoSession = mDBManager.getDaoSession();
        mDBManager.setDebug(true);
    }

    public void insertAppInfo(AppInfo appInfo) {
        mDBManager.getDaoSession().insert(appInfo);
    }

    /**
     * 添加多条数据，需要开辟新的线程
     */
    public void insertMultStudent(final List<AppInfo> appInfos) {
        mDBManager.getDaoSession().runInTx(new Runnable() {
            @Override
            public void run() {
                for (AppInfo student : appInfos) {
                    mDBManager.getDaoSession().insertOrReplace(student);
                }
            }
        });
    }

    /**
     * 删除数据
     */
    public void deleteStudent(AppInfo appInfo) {
        mDBManager.getDaoSession().delete(appInfo);
    }

    /**
     * 删除全部数据
     */
    public void deleteAll(Class cls) {
        mDBManager.getDaoSession().deleteAll(cls);
    }

    /**
     * 更新数据
     */
    public void updateStudent(AppInfo appInfo) {
        mDBManager.getDaoSession().update(appInfo);
    }

    /**
     * 按照主键返回单条数据
     */
    public AppInfo listOneStudent(long key) {
        return mDBManager.getDaoSession().load(AppInfo.class, key);
    }

    /**
     * 根据指定条件查询数据
     */
//    public List<AppInfo> queryStudent() {
//        查询构建器
//        QueryBuilder<AppInfo> builder = mDBManager.getDaoSession().queryBuilder(Student.class);
//        List<AppInfo> list = builder.where(AppInfoDao.Properties.Name.like()).where(StudentDao.Properties.Name.like("王小二")).list();
//        return list;
//    }

    /**
     * 查询全部数据
     */
    public List<AppInfo> queryAll() {
        return mDBManager.getDaoSession().loadAll(AppInfo.class);
    }
}
