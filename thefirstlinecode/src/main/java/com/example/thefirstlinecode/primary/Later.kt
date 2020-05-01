package com.example.thefirstlinecode.primary

import kotlin.reflect.KProperty

/**
 * @date   2020/5/1
 * @author JiangHao
 * @describe 实现一个lazy init 功能 类似于kotlin 自带的 lazy
 */

class Later<T>(val block: () -> T) {
    var value: Any? = null

    operator fun getValue(any: Any?, prop: KProperty<*>): T {
        if (value == null) {
            value = block
        }
        return value as T
    }
}

fun <T> later(block: () -> T) = Later(block)

