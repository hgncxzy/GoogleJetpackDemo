package com.xzy.livedata

import android.arch.lifecycle.MutableLiveData

/**
 *
 * @author ：created by xzy.
 * @date ：2020/7/22
 */
object Data {
    // 1. 定义可观察的对象
    var account = MutableLiveData<String>()
}
