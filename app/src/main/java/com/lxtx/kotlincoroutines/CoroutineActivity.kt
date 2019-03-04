package com.lxtx.kotlincoroutines

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

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
    }


    private fun test1() {
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

    /**
     * async 异步， await 等待  同步出现
     */
    private fun test4() {
        runBlocking {
            var time = measureTimeMillis {
                println("同步 ${doTest4One() + doTest4Two()}")
            }
            println("同步运行的时间 $time ms")

            time = measureTimeMillis {
                val asyncOne = async {
                    doTest4One()
                }
                val asyncTwo = async {
                    doTest4Two()
                }
                println("异步 ${asyncOne.await() + asyncTwo.await()}")
            }
            println("异步运行的时间 $time ms")
        }

    }

    private suspend fun doTest4One(): Int {
        delay(1000L)
        return 1
    }

    private suspend fun doTest4Two(): Int {
        delay(1000L)
        return 2
    }

}