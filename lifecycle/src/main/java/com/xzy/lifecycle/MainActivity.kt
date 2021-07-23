package com.xzy.lifecycle


import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.xzy.lifecycle.mvp.MyPresenter

/**
 * 作用：
 * lifecycle是让业务组件(如presenter)感知Activity/Fragment生命周期
 * 实现：
 * 1.让业务组件实现LifecycleObserver接口
 * 2.将业务组件实例添加到观察者队列lifecycle.addObserver(presenter)
 * lifecycle 用法参考 https://github.com/android/architecture-components-samples
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

