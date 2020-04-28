@file:JvmName("LearnKotlinKt")

package com.example.thefirstlinecode.primary

import java.lang.StringBuilder

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

    val arrayList = ArrayList<String>()
    val map = HashMap<String, Int>()
    map.put("Tom", 100)

    val list = listOf<String>("Apple", "Pear", "Watermelon", "emon")
    list.maxBy { it.length }

    Thread(object : Runnable {
        override fun run() {

        }
    }).start()
    Thread(Runnable {}).start()
    Thread({}).start()
    Thread() {}.start()
    Thread {}.start()
    var p: People = People("hello", 12)
    val (a, b) = p
    println("a == " + a + " b == " + b)

    fun test(func: () -> Unit): Unit {
        fun test1() {
            func
        }
        return test1();
    }

    fun hello() {
        println("hello ")
    }

    test(::hello)

    val str = with(StringBuilder()) {
        append("hello")
                .append("world")
        toString()
    }
    println(str)

    val str2 = StringBuilder().run {
        append("hehe ")
                .append(" ooo")
        toString()
    }
    println(str2)

    //运算符重载
    data class Money(val value: Int) {

        operator fun plus(o1: Money): Money {
            //处理相加逻辑
            val sum = value + o1.value;
            return Money(sum)
        }
    }

    val m1: Money = Money(12)
    val m2: Money = Money(13)
    println(m1 + m2)
}