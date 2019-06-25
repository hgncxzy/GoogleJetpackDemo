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
import com.example.xzy.databinding.FragmentTopBinding
import kotlinx.android.synthetic.main.fragment_top.*

/**
 * Description :
 * Created by XuZhuYun 2019/5/9 17:06 .
 */
class TopFragment : Fragment() {

    private var mModel: AccountModel? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var binding = FragmentTopBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mModel = activity?.let { ViewModelProviders.of(it).get(AccountModel::class.java) }
        fragment_set_button.setOnClickListener {
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
                fragment_text_view!!.text = AccountModel.getFormatContent(accountBean!!.name, accountBean.phone, accountBean.blog)
            })
    }
}
