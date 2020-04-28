package com.example.annotationdemo.starttheactivity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author JiangHao
 * @date 2020/4/28
 * @describe
 */
public class Student implements Parcelable {
    private int id;
    private String name;

    public Student() {
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    protected Student(Parcel in) {
        id = in.readInt();
        name = in.readString();
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            Student student = new Student();
            student.id = in.readInt();
            student.name = in.readString();
            return student;
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
