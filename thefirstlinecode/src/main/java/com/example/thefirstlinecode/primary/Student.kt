package com.example.thefirstlinecode

/**
 * @date   2020/4/13
 * @author JiangHao
 * @describe
 */
class Student(val sno: String, val grade: Int, name: String, age: Int) : Person(name, age), Study {
    init {

    }

    override fun readBooks() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}