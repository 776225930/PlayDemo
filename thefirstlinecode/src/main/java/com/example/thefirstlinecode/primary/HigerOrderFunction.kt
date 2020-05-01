package com.example.thefirstlinecode.primary

import java.lang.StringBuilder
import kotlin.math.min
import kotlin.reflect.KProperty

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

    //不使用泛型,只能作用于固定类型
    fun StringBuilder.build(block: StringBuilder.() -> Unit): StringBuilder {
        block()
        return this;
    }

    //使用泛型后
    fun <T> T.build(block: T.() -> Unit): T {
        block()
        return this
    }

    //类委托和委托属性
    //委托模式的一般写法,需要手动重写所有方法
    class MySet<T>(val helperSet: HashSet<T>) : Set<T> {

        override val size: Int
            get() = helperSet.size

        override fun contains(element: T): Boolean {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun containsAll(elements: Collection<T>): Boolean {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun isEmpty(): Boolean {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun iterator(): Iterator<T> {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

    }

    //使用类委托:类委托核心是将一个类的具体实现交给另一个类完成
    class MySet1<T>(val heplerSet: HashSet<T>) : Set<T> by heplerSet {

        //重写一个方法
        override fun isEmpty() = false

        //新增一个方法
        fun helloWorld() = println("hello kotlin")
    }

    //属性委托
    var myClass: MyClass = MyClass();
    myClass.p = "Tom"
    println(myClass.p)
}


//委托属性
class MyClass {
    var p by Delegate()
}

class Delegate {
    var propValue: Any? = null
    //KProperty<*> 属性操作类。用于获取各种属性相关的值
    operator fun getValue(myClass: MyClass, prop: KProperty<*>): Any? {
        println("i am getvalue")
        return propValue

    }

    operator fun setValue(myClass: MyClass, prop: KProperty<*>, value: Any?) {
        println("i am setValue")
        propValue = value
    }
}