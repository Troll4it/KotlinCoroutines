package com.lxtx.kotlincoroutines

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log

class ClosureActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_closure)

        /**
         *
         * https://www.cnblogs.com/ssp2110/p/3797666.html
         *
         *闭包：函数的运行环境
         * 函数内部可以定义函数，也可以定义类
         *.在函数中返回一个函数，被返回的函数可以调用主函数的属性
         * 自由变量   引用环境
         *
         * 为自由变量提供一个生存环境
         */

        val x = queueUp()
        x()
        x()
        x()
        x()
        x()
        x()
        x()
        x()

        val queueUp = QueueUp()
        val action = queueUp.doAction()
        action.add()
        action.add()
        action.add()
        action.add()
        action.add()
        action.add()
        action.add()
        action.add()

    }

    private fun queueUp(): () -> Unit {
        var sum = 1
        Log.i("Java排队:", "排队开始KotlinKotlinKotlinKotlinKotlinKotlinKotlin")
        return fun() {
            Log.i("Kotlin排队位置:", "第" + sum + "位")
            sum++
        }
    }


}