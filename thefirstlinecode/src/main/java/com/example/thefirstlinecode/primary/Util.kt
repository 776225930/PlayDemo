package com.example.thefirstlinecode.primary

/**
 * @date   2020/4/23
 * @author JiangHao
 * @describe 伴生对象
 */
class Util {
    fun doAction() {
        println("do action")
    }

    //伴生对象,Kotlin会保证Util类始终只有一个伴生对象
    companion object {
        @JvmStatic//转变为正正的java静态方法,注意:只能加载单例类或者伴生对象中的方法上
        fun doAction2() {
            println("do action2")
        }
    }
}