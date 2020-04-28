package com.example.annotationdemo.starttheactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.annotationdemo.R;

public class ParamActivity extends AppCompatActivity {

    private static final String TAG = ParamActivity.class.getSimpleName();
    @Autowired("name")
    private String name;
    @Autowired("boy")
    private boolean isBoy;
    @Autowired("students")
    private Student[] mStudents;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_param);
        AutowireUtil.autoWired(this);
        Log.e(TAG, "onCreate: name == " + name + " isBOy == " + isBoy);
        for (Student student : mStudents) {
            Log.e(TAG, "onCreate: " + student);
        }
    }
}
