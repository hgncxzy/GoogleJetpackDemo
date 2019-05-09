package com.example.xzy.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.xzy.R
import com.example.xzy.model.AccountModel
import com.example.xzy.bean.AccountBean


class MainActivity : AppCompatActivity() {

    private var mModel: AccountModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mText = findViewById<TextView>(R.id.textView)
        mModel = ViewModelProviders.of(this).get(AccountModel::class.java)

        supportFragmentManager.beginTransaction().replace(R.id.fragment_container_1,TopFragment()).commit()
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container_2,BottomFragment()).commit()
        findViewById<Button>(R.id.main_set_button).setOnClickListener {
            // 设置一条数据
            // mModel.setAccount("arthining", "136*****850", "http://www.baidu.com");
            // post一条数据
            mModel!!.account.postValue(AccountBean(
                "arthining",
                "136*****850",
                "http://www.baidu.com"))
        }
        mModel!!.account.observe(this, Observer{accountBean ->
            mText.text = AccountModel.getFormatContent(accountBean!!.name, accountBean.phone, accountBean.blog)
        })
    }
}