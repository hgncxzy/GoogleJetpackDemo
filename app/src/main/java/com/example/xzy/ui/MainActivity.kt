package com.example.xzy.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.xzy.R
import com.example.xzy.model.AccountModel
import com.example.xzy.bean.AccountBean

/**
 *  1.得到 viewModel 对象,并定义一个 MutableLiveData<T> 类型的对象  a
 *  2. viewModel 绑定监听  a
 *  3. post 一条数据
 *  4. 监听里面更新 UI
 *
 *
 * */
class MainActivity : AppCompatActivity() {

    private var mModel: AccountModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mText = findViewById<TextView>(R.id.textView)
        // 1.得到 viewModel 对象
        mModel = ViewModelProviders.of(this).get(AccountModel::class.java)

        supportFragmentManager.beginTransaction().replace(R.id.fragment_container_1, TopFragment())
            .commit()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_2, BottomFragment()).commit()
        findViewById<Button>(R.id.main_set_button).setOnClickListener {
            // 3. post 一条数据
            // 设置一条数据
            // mModel.setAccount("arthining", "136*****850", "http://www.baidu.com");
            // post一条数据
            mModel!!.account.postValue(
                AccountBean(
                    "arthining",
                    "136*****850",
                    "http://www.baidu.com"
                )
            )
            mModel?.result?.postValue("hello world")
        }
        // 2. 绑定监听
        mModel!!.account.observe(this, Observer { accountBean ->
            // 4.更新 UI
            mText.text = AccountModel.getFormatContent(
                accountBean!!.name,
                accountBean.phone,
                accountBean.blog
            )
        })

        mModel?.result?.observe(this, Observer { t ->
            Toast.makeText(this, t, Toast.LENGTH_SHORT).show()
        })
    }
}