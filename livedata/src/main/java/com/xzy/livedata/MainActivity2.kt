package com.xzy.livedata

import android.arch.lifecycle.Observer
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        Data.account.observe(this, Observer {
            tv_test.text = it
        })
        btn_test.setOnClickListener {
            Data.account.value = "我来自 MainActivity2"
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}