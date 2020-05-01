package com.example.thefirstlinecode.primary

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * @date   2020/5/1
 * @author JiangHao
 * @describe
 */

fun main() {
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