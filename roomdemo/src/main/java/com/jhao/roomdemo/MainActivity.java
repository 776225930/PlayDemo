package com.jhao.roomdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private StudentViewModel mStudentViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mStudentViewModel = ViewModelProviders.of(this).get(StudentViewModel.class);
        mStudentViewModel.getAllLiveDataStudent().observe(this, new Observer<List<Student>>() {
            @Override
            public void onChanged(List<Student> students) {
                Log.e(TAG, "onChanged: size == " + students.size() + " ; "
                        + Thread.currentThread().getName());
//                for (int i = 0; i < 50; i++) {
//                    Log.e(TAG, "onChanged: student[" + i + "]" + students.get(i));
//                }
            }
        });
        mStudentViewModel.getLast().observe(this, new Observer<Student>() {
            @Override
            public void onChanged(Student student) {
                Log.e(TAG, "onChanged: student " + student);
            }
        });
        for (int i = 0; i < 50; i++) {
            Log.e(TAG, "onCreate: insert " + i);
            mStudentViewModel.insert(new Student("jett", "123", 1));
        }
    }

    int i = 0;

    public void insert(View view) {
        if (mStudentViewModel != null) {
            mStudentViewModel.insert(new Student("Tom" + i, "123456", 456124));
            i++;
        }
    }
}
