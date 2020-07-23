package com.example.xzy.ui

import android.arch.lifecycle.Observer
import android.support.v4.app.Fragment
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import com.example.xzy.R
import com.example.xzy.model.MyViewModel
import kotlinx.android.synthetic.main.fragment_bottom.*

/**
 * Description :
 * Created by XuZhuYun 2019/5/9 17:07 .
 */
class BottomFragment : Fragment() {

    private lateinit var mModel: MyViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_bottom, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mModel = ViewModelProviders.of(requireActivity()).get(MyViewModel::class.java)
        mModel.result.observe(this,
            Observer { tv_bottom_fragment_result.text = it })
    }
}
