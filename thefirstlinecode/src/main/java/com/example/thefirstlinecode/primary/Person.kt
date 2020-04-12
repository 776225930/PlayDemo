package com.example.thefirstlinecode

/**
 * @date   2020/4/13
 * @author JiangHao
 * @describe
 */
open class Person(var name: String, var age: Int) {

    constructor() : this("", 0) {}

    fun eat() {
        println(name + " eating...")
    }
}