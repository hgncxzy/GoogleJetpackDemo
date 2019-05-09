package com.example.xzy.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.Fragment
import com.example.xzy.model.AccountModel
import com.example.xzy.bean.AccountBean
import android.os.Bundle
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.example.xzy.R

/**
 * Description :
 * Created by XuZhuYun 2019/5/9 17:06 .
 */
class TopFragment : Fragment() {

    private var mModel: AccountModel? = null
    private var mText: TextView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_top, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mText = view.findViewById(R.id.fragment_text_view)
        mModel = activity?.let { ViewModelProviders.of(it).get(AccountModel::class.java) }
        view.findViewById<TextView>(R.id.fragment_set_button).setOnClickListener {
            mModel!!.account.postValue(
                AccountBean(
                    "arthining",
                    "136*****850",
                    "这段数据是从Fragment中Post出来的"
                )
            )
        }
        mModel!!.account.observe(this,
            Observer { accountBean ->
                mText!!.text = AccountModel.getFormatContent(accountBean!!.name, accountBean.phone, accountBean.blog)
            })
    }
}
