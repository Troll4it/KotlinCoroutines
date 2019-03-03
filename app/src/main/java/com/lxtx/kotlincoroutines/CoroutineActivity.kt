package com.lxtx.kotlincoroutines

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel

class CoroutineActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutinescope)
        findViewById<Button>(R.id.btn1).setOnClickListener {
            test1()
        }
        findViewById<Button>(R.id.btn2).setOnClickListener { test2() }
        findViewById<Button>(R.id.btn3).setOnClickListener { test3() }
        findViewById<Button>(R.id.btn4).setOnClickListener { test4() }
        findViewById<Button>(R.id.btn5).setOnClickListener { test5() }
    }


    private fun test1() {

        /**
         *
         */

        GlobalScope.launch {
            println("GlobalScope111111111")
        }
        print("Hello,")
    }


    private fun test2() {

        val job = GlobalScope.launch {
            println("GlobalScope2222222222")

        }
        job.cancel()
//        job.start()

        print("Hello,")

    }

    /**
     * 挂起函数  （关键字  suspendd）
     */
    private fun test3() {

        /**
         * runBlocking 为最高级协程
         */
        runBlocking {
            val job = GlobalScope.launch {
                //                delay(2000L)  //阻塞当前线程 与Thread.sleep()效果差不多
                println("GlobalScope3333333333")
            }
            print("Hello,")
//            job.join()
            job.cancelAndJoin()

//            print("Good ")
        }


    }

    private fun test4() {
        /**
         * 协程运行是有序的吗？  多个协程怎么添加进去
         */
        runBlocking {
            GlobalScope.launch {
                println("GlobalScope44444444")
            }
            println("Hello")
            runBlocking {
                println("child  GlobalScope")
            }
        }


    }

    private fun test5() {

        runBlocking {
            val channel = Channel<String>()
            launch {
                channel.send("GlobalScope555555555")
            }

            GlobalScope.launch {
                println("receive ${channel.receive()}")
            }
        }

    }


}