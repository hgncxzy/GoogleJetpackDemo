package com.example.xzy.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.xzy.model.AccountModel
import com.example.xzy.bean.AccountBean
import com.example.xzy.databinding.ActivityMainBinding
import android.databinding.DataBindingUtil
import com.example.xzy.R
import kotlinx.android.synthetic.main.activity_main.*

/**
 * 在 ViewModel + LiveData 的基础上，添加了 DataBinding 组件
 * */
class MainActivity : AppCompatActivity() {

    private var mModel: AccountModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // test dataBinding
        val binding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        val accountBean = AccountBean("xzy", "1367****6850", "csdn.net")
        binding.bean = accountBean
        mModel = ViewModelProviders.of(this).get(AccountModel::class.java)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container_1, TopFragment())
            .commit()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container_2, BottomFragment())
            .commit()
        binding.apply {
            mainSetButton.setOnClickListener {
                // 设置一条数据
                // mModel.setAccount("arthining", "136*****850", "http://www.baidu.com");
                // post一条数据
                mModel?.account?.postValue(
                    AccountBean(
                        "arthining",
                        "136*****850",
                        "http://www.baidu.com"
                    )
                )
            }
        }

        mModel?.account?.observe(this, Observer {
            textView.text = AccountModel.getFormatContent(
                it?.name,
                it?.phone,
                it?.blog
            )
        })
    }
}