package com.lxtx.kotlincoroutines

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btn2).setOnClickListener {
            val intent = Intent(this@MainActivity, ClosureActivity::class.java)
            startActivity(intent)
        }
        findViewById<Button>(R.id.btn1).setOnClickListener {
            val intent = Intent(this@MainActivity, CoroutineActivity::class.java)
            startActivity(intent)
        }
    }


}
