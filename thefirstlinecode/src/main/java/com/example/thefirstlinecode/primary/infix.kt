package com.example.thefirstlinecode.primary

/**
 * @date   2020/5/1
 * @author JiangHao
 * @describe infix函数 只是改变了函数的调用方式:允许将小数点、括号等计算机运相关的语法去掉
 *           必须是某个类的成员函数，可以使用扩展函数，不能使用顶层函数；只能接受一个参数
 */

infix fun String.beginWith(prefix: String) = startsWith(prefix)

infix fun <T> Collection<T>.has(t: T) = contains(t)
//模仿map 的 to
infix fun <K, V> K.with(that: V): Pair<K, V> = Pair(this, that)

fun main() {
    //常规函数调用方式
    val a = "Hello Kotlin".startsWith("Hello")
    println(a)
    //使用infix 函数调用方式
    val b = "Hello Kotlin" beginWith "Hello"
    println(b)
    1 to "a"
    val listOf = listOf<String>("apple", "pear", "watermelon")
    val c = listOf has "apple"
    println(c)


}