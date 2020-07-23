package com.example.xzy.model

import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import android.app.Application
import android.util.Log

/**
 * Description :
 * Created by XuZhuYun 2019/5/9 17:03 .
 */
class MyViewModel(application: Application) : AndroidViewModel(application) {
    val result = MutableLiveData<String>()

    // 当 MAinActivity 被销毁时，Framework 会调用 ViewModel 的 onCleared()
    override fun onCleared() {
        super.onCleared()
        Log.d("xzy", "onCleared")
    }
}