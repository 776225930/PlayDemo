@file:JvmName("LearnKotlinKt")

package com.example.thefirstlinecode

/**
 * @date   2020/4/12
 * @author JiangHao
 * @describe
 */
fun main() {
    fun lagerNumber(a: Int, b: Int): Int {
        val value = if (a > b) {
            a
        } else {
            b
        }
        return value
    }

    fun lagerNumber1(a: Int, b: Int) = if (a > b) {
        a
    } else {
        b
    }

    fun lagerNumber2(a: Int, b: Int) = if (a > b) a else b

    println(lagerNumber2(3, 4))

    fun getScore(name: String) = when (name) {
        "Tom" -> 12
        "Jerry" -> 14
        "Henry" -> 13
        else -> 0
    }

    println(getScore("Tom"))

    val person: Person = Person("Tom", 12)
    person.name = "Tom"
    person.age = 11
    person.eat()

    Singleton.singletonTest()

}
