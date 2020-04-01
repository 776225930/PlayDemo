package com.jhao.roomdemo;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

/**
 * @author JiangHao
 * @date 2020/4/1
 * @describe
 */
@Dao
public interface StudentDao {

    @Insert
    void insert(Student... students);

    @Delete
    void delete(Student student);

    @Update
    void update(Student student);

    @Query("select * from Student")
    List<Student> getAll();

    @Query("select * from Student where id =(:studentId)")
    Student getStudentById(int studentId);

    @Query("select * from Student where id IN (:studentIds)")
    Student getStudentByIds(int... studentIds);

    @Query("select * from Student where id =(:studentId) AND name =(:name)")
    Student getStudentByNameAndId(int studentId, String name);

    @Query("select * from Student order by id desc  limit 1")
    LiveData<Student> getLast();

    @Query("select * from Student order by id")
    LiveData<List<Student>> getAllLiveDataStudent();
}
