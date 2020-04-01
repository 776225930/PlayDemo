package com.jhao.roomdemo;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * @author JiangHao
 * @date 2020/4/1
 * @describe 默认情况下，Room使用类名作为数据库表名。如果希望表具有不同的名称，请设置@Entity注解的tableName属性
 * 注意：SQLite中的表名不区分大小写。
 */
@Entity
public class Student {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "pwd")
    private String password;
    @ColumnInfo(name = "addressId")
    private int addressId;
    @ColumnInfo(name = "flag")
    private boolean flag;


    public Student(String name, String password, int addressId) {
        this.name = name;
        this.password = password;
        this.addressId = addressId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", addressId='" + addressId + '\'' +
                ", flag=" + flag +
                '}';
    }
}
