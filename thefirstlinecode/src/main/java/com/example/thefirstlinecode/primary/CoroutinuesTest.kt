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
//    test4()
//    test6()
    test7()

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

fun test5() {
    val job = Job()
    val scope = CoroutineScope(job)
    scope.launch {
        //处理具体逻辑
    }
    job.cancel()
}

fun test6() {
    //协程的串行化执行
    runBlocking {
        val start = System.currentTimeMillis()
        val result = async {
            delay(1000)
            5 + 5
        }.await()
        println(result)
        val result1 = async {
            delay(1000)
            5 + 12
        }.await()
        println("result is ${result + result1}")
        val end = System.currentTimeMillis()
        println(end - start)
    }
}

fun test7() {
    //协程的串行化执行
    runBlocking {
        val start = System.currentTimeMillis()
        val deferred = async {
            delay(1000)
            5 + 5
        }
        println(deferred)
        val deferred1 = async {
            delay(1000)
            5 + 12
        }
        println("result is ${deferred.await() + deferred1.await()}")
        val end = System.currentTimeMillis()
        println(end - start)
    }
}
