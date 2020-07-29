package com.xzy.lifecycle

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.xzy.lifecycle.mvp.MyPresenter

/**
 * lifecycle 用法参考 https://zhuanlan.zhihu.com/p/88905213
 * Lifecycle的基本用法
 * */
class MainActivity : AppCompatActivity() {
    private lateinit var presenter: MyPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // activity 中使用 lifecycle
        lifecycle.addObserver(MyObserver())
        // mvp 中使用 lifecycle
        presenter = MyPresenter()
        lifecycle.addObserver(presenter)
    }

    override fun onResume() {
        super.onResume()
        Log.d("xzy", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("xzy", "onPause")
    }

    class MyObserver : LifecycleObserver {
        @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
        fun onResume() {
            Log.d("xzy", "MyObserver -> Lifecycle call onResume")
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
        fun onPause() {
            Log.d("xzy", "MyObserver -> Lifecycle call onPause")
        }
    }
}

