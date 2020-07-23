package com.xzy.livedata

import android.annotation.SuppressLint
import android.arch.lifecycle.Observer
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.xzy.livedata.Data.account
import com.xzy.livedata.fragment.BottomFragment
import com.xzy.livedata.fragment.TopFragment
import kotlinx.android.synthetic.main.activity_main.*

/**
 * 更多用法参考  https://www.jianshu.com/p/6a19424e5c62
 * **/
class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container_1, TopFragment())
            .commit()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container_2, BottomFragment())
            .commit()
        btn_set_value.setOnClickListener {
            // 2. 赋值
            // account.value = "xzy"
            account.postValue("我来自 MainActivity")
        }
        // 3. activity 内部的观察者收到更新信息
        account.observe(this, Observer {
            tv_activity_result.text = it
        })

        btn_forward.setOnClickListener {
            account.postValue("我关闭了 MainActivity")
            startActivity(Intent(this, MainActivity2::class.java))
            finish()
        }
    }
}
