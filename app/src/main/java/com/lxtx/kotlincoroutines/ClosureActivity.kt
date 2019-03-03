package com.lxtx.kotlincoroutines

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView

class ClosureActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_closure)

        /**
         *闭包：函数的运行环境
         * 持有函数的运行环境
         * 函数内部可以定义函数，也可以定义类
         *
         * 自由变量   引用环境
         *
         */
        var test1 = test1()
        test1
        test1
        test1
        test()

        findViewById<TextView>(R.id.tv).text= test().toString()
    }


    fun closure():()->Unit{
        var i=1
        return {
            println("${++i}")
        }
    }

    fun test(){
        val closure = closure()
        closure
        closure
    }

    private fun test1(): Int {

        val a = 1
        val b = 2

        fun closure(): Int {
            return a + b
        }

        return closure()


    }

}