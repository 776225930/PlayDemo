package com.example.thefirstlinecode.primary

import kotlinx.coroutines.*

/**
 * @date   2020/5/1
 * @author JiangHao
 * @describe
 */

fun main() {
//      test1()
//    test2()
//    test3()
    test4()

}

//协程的简单使用
fun test1() {
    //不会阻塞当前线程,可能程序运行太快结束来不及执行
    GlobalScope.launch {
        println("codes run in coroutinue scope")
        delay(1500)
        println("codes run in coroutinue scope finished")
    }
//    Thread.sleep(1000)
    //会阻塞当前线程
    runBlocking {
        println("codes1 run in coroutinue scope")
        delay(1500)
        println("codes1 run in coroutinue scope finished")
    }
}

//多协程的使用
fun test2() {

    runBlocking {
        launch {
            println("launch1")
            delay(1000)
            println("launch1 finished")
        }
        launch {
            println("launch2")
            delay(1000)
            println("launch2 finished")
        }
        launch {
            println("launch3")
            delay(1000)
            println("launch3 finished")
        }
    }
}

//协程的并发效率测试
fun test3() {
    val start = System.currentTimeMillis()
    runBlocking {
        repeat(100000) {
            launch {
                println(".")
            }
        }
    }
    val end = System.currentTimeMillis()
    println(end - start)

}

//挂起函数
suspend fun printDot() {
    println(".")
    delay(1000)
}

//coroutineScope函数,给函数提供协程作用域
suspend fun printDot1() = coroutineScope {
    launch {
        print(".")
        delay(1000)
    }
}

fun test4() {
    runBlocking {
        coroutineScope {
            launch {
                for (i in 1..10) {
                    println(i)
                    delay(1000)
                }
            }
        }
        println("coroutineScope finished")
    }
    println("runBlocking finished")
}
