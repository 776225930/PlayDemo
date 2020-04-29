package com.example.thefirstlinecode.primary

import java.lang.StringBuilder
import kotlin.math.min

/**
 * @date   2020/4/29
 * @author JiangHao
 * @describe
 */

fun num1AndNum2(num1: Int, num2: Int, operation: (Int, Int) -> Int): Int {
    return operation(num1, num2)
}

fun plus(a: Int, b: Int): Int {
    return a + b
}

fun minus(a: Int, b: Int): Int {
    return a - b
}

//StringBuildr扩展函数，StringBuilder.  （ClassName.）表示这个函数类型是定义在该类中
fun StringBuilder.build(block: StringBuilder.() -> Unit): StringBuilder {
    block()
    return this;
}

fun main() {
    val result1 = num1AndNum2(12, 10, ::plus)
    println(result1)
    val result2 = num1AndNum2(12, 10, ::minus)
    println(result2)
    val result3 = num1AndNum2(12, 3) { n1, n2 ->
        n1 * n2
    }
    println(result3)
    val list = listOf<String>("Apple", "Orange", "Pear")
    val stringBuilder = StringBuilder().build() {
        append("Start")
        for (str in list) {
            append(str + " , ")
        }
        append("End")
    }
    println(stringBuilder.toString())
}

