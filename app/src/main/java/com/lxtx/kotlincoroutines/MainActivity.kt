package com.lxtx.kotlincoroutines

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        testGlobalScope1()
    }

    private fun testGlobalScope1() {
        GlobalScope.launch {
            delay(2000L)  //特殊的挂起函数，不会造成线程阻塞，会挂起协程，只能在协程中使用
            println("World")
        }
        println("Hello,")
        Thread.sleep(3000L)
    }
}
