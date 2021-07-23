package com.xzy.lifecycle.mvp


import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

/**
 * @author ：created by xzy.
 * @date ：2020/7/29
 */
internal interface IPresenter : LifecycleObserver {
    /**
     * onResume
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume()

    /**
     * onPause
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause()
}