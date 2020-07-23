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
import com.example.xzy.databinding.FragmentTopBinding

/**
 * Description :
 * Created by XuZhuYun 2019/5/9 17:06 .
 */
class TopFragment : Fragment() {

    private var mModel: AccountModel? = null
    private var binding: FragmentTopBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTopBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mModel = activity?.let { ViewModelProviders.of(it).get(AccountModel::class.java) }
        binding?.fragmentSetButton?.setOnClickListener {
            mModel?.account?.postValue(
                AccountBean(
                    "xzy",
                    "136*****850",
                    "这段数据是从Fragment中Post出来的"
                )
            )
        }

        mModel?.account?.observe(this,
            Observer { accountBean ->
                binding?.fragmentTextView?.text = AccountModel.getFormatContent(
                    accountBean!!.name,
                    accountBean.phone,
                    accountBean.blog
                )
            })
    }

}
