package com.jhao.roomdemo;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

/**
 * @author JiangHao
 * @date 2020/4/1
 * @describe
 */
public class StudentViewModel extends AndroidViewModel {
    private StudentRepository mStudentRepository;

    public StudentViewModel(@NonNull Application application) {
        super(application);
        mStudentRepository = new StudentRepository(application);
    }

    void insert(Student... students) {
        mStudentRepository.insert(students);
    }

    void delete(Student student) {
        mStudentRepository.delete(student);
    }

    void update(Student student) {
        mStudentRepository.update(student);
    }


    List<Student> getAll() {
        return mStudentRepository.getAll();
    }


    Student getStudentById(int studentId) {
        return mStudentRepository.getStudentById(studentId);
    }

    Student getStudentByIds(int... studentIds) {
        return mStudentRepository.getStudentByIds(studentIds);
    }

    Student getStudentByNameAndId(int studentId, String name) {
        return mStudentRepository.getStudentByNameAndId(studentId, name);
    }

    LiveData<Student> getLast() {
        return mStudentRepository.getLast();
    }

    LiveData<List<Student>> getAllLiveDataStudent() {
        return mStudentRepository.getAllLiveDataStudent();
    }


}
