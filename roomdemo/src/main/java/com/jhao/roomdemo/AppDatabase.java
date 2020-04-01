package com.jhao.roomdemo;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

/**
 * @author JiangHao
 * @date 2020/4/1
 * @describe 包含数据库持有者，并充当与应用程序持久化的、关系型的数据的底层连接的主要访问点
 */
@Database(entities = {Student.class}, version = 1,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase instance;

    public static AppDatabase getInstance(Context context) {
        //双检查
        if (instance == null) {
            synchronized (AppDatabase.class) {
                if (instance == null) {
                    instance = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "myDB")
                            //可强制在主线程运行数据库操作
                            .allowMainThreadQueries()
                            //强制升级,不建议使用
//                            .fallbackToDestructiveMigration()
                            //正常使用这个
                            .addMigrations(MIGRATION_1_2)
                            .build();
                }
            }
        }
        return instance;
    }

    //数据库升级使用策略,数据库版本发生变化时调用
    static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("alter table student add column flag2 integer not null default 1");
//            database.execSQL("create table student_temp (uid integer primary key not null,name text,pwd text,addressId)");
//            database.execSQL("insert into student (uid,name,pwd,addressid)" + " select uid,name,pwd,addressid from student");
//            database.execSQL("drop table student");
//            database.execSQL("alter table student_temp rename to student");
        }
    };

    public abstract StudentDao studentDao();
}
