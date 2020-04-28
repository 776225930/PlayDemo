package com.example.annotationdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.annotationdemo.inject.InjectUtils;
import com.example.annotationdemo.inject.InjectView;
import com.example.annotationdemo.starttheactivity.ParamActivity;
import com.example.annotationdemo.starttheactivity.Student;
import com.example.annotationdemo.starttheactivity.Teacher;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    @InjectView(R.id.tv_test)
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InjectUtils.injectView(this);
        mTextView.setText("hhaha");

    }

    public void jump(View view) {
        Student student1 = new Student(1, "Tom");
        Student student2 = new Student(2, "Jerry");
        Student[] students = new Student[]{student1, student2};
        Teacher teacher1 = new Teacher(1, "Tony", 1000L);
        Teacher teacher2 = new Teacher(2, "Anssy", 20000L);
        Teacher[] teachers = new Teacher[]{teacher1, teacher2};
        int[] ints = new int[]{1, 2, 3, 4, 5};

        Intent intent = new Intent(this, ParamActivity.class)
                .putExtra("name", "Lance")
                .putExtra("boy", true)//页面跳转携带参数
                .putExtra("students", students)
                .putExtra("teachers", teachers)
                .putExtra("ints", ints);
        startActivity(intent);

    }
}
