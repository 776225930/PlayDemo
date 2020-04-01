package com.jhao.roomdemo;

import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.List;

/**
 * @author JiangHao
 * @date 2020/4/1
 * @describe 数据仓库, 统一提供数据获取方式的实现
 */
public class StudentRepository {
    private LiveData<List<Student>> mListLiveDataAllStudent;
    private StudentDao mStudentDao;

    public StudentRepository(Context context) {
        mStudentDao = AppDatabase.getInstance(context).studentDao();
        if (mListLiveDataAllStudent == null) {
            mListLiveDataAllStudent = mStudentDao.getAllLiveDataStudent();
        }
    }

    //提供一些API给viewmodel使用

    void insert(Student... students) {
        mStudentDao.insert(students);
    }

    void delete(Student student) {
        mStudentDao.delete(student);
    }

    void update(Student student) {
        mStudentDao.update(student);
    }


    List<Student> getAll() {
        return mStudentDao.getAll();
    }


    Student getStudentById(int studentId) {
        return mStudentDao.getStudentById(studentId);
    }

    Student getStudentByIds(int... studentIds) {
        return mStudentDao.getStudentByIds(studentIds);
    }

    Student getStudentByNameAndId(int studentId, String name) {
        return mStudentDao.getStudentByNameAndId(studentId, name);
    }
    LiveData<Student> getLast( ) {
        return mStudentDao.getLast();
    }

    LiveData<List<Student>> getAllLiveDataStudent() {
        return mStudentDao.getAllLiveDataStudent();
    }

}
