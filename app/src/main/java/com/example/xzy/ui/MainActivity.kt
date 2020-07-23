package com.example.xzy.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.xzy.R
import com.example.xzy.model.MyViewModel
import kotlinx.android.synthetic.main.activity_main.*

/**
 *  1.得到 viewModel 对象,并定义一个 MutableLiveData<T> 类型的对象
 *  2. viewModel 绑定监听
 *  3. post 一条数据
 *  4. 监听里面更新 UI
 *
 *
 * */
class MainActivity : AppCompatActivity() {

    private lateinit var mModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // 1.得到 viewModel 对象
        mModel = ViewModelProviders.of(this).get(MyViewModel::class.java)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container_1, TopFragment())
            .commit()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container_2, BottomFragment())
            .commit()
        // 2. 绑定监听
        mModel.result.observe(this, Observer {
            tv_result.text = it
        })

        // 3. 更新数据
        main_set_button.setOnClickListener {
            mModel.result.postValue("我来自 MainActivity")
        }
    }
}