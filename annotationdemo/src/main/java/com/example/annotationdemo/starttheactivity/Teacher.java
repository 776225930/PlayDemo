package com.example.annotationdemo.starttheactivity;

import java.io.Serializable;

/**
 * @author JiangHao
 * @date 2020/4/28
 * @describe
 */
public class Teacher implements Serializable {

    private int id;
    private String name;
    private Long salary;

    public Teacher(int id, String name, Long salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
