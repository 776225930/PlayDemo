package com.example.thefirstlinecode.primary

/**
 * @date   2020/5/1
 * @author JiangHao
 * @describe
 */
//泛型实化 在kotlin 中这么写是允许的
inline fun <reified T> getGenericType() = T::class.java

fun main() {
    val result1 = getGenericType<String>();
    println(result1)
    val result2 = getGenericType<Int>();
    println(result2)

}