package com.xzy.lifecycle.mvp

import android.util.Log

/**
 * @author ：created by xzy.
 * @date ：2020/7/29
 */
internal class MyPresenter : IPresenter {
    override fun onResume() {
        Log.d("xzy", "MyPresenter -> lifecycle call onResume")
    }

    override fun onPause() {
        Log.d("xzy", "MyPresenter -> lifecycle call onPause")
    }
}