package com.xzy.workmanager

import android.arch.lifecycle.Observer
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.work.*
import java.util.concurrent.TimeUnit

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        test1()
//        Log.d(TAG, "=======================")
        test2()
    }

    private fun test1() {
        // 使用 OneTimeWorkRequest.Builder 创建对象 Worker，然后将任务排入 WorkManager 队列
        val workRequestA = OneTimeWorkRequest.Builder(MyWorkA::class.java).build()
        WorkManager.getInstance().enqueue(workRequestA)
        WorkManager.getInstance().getWorkInfoByIdLiveData(workRequestA.id)
            .observe(this, Observer {
                Log.i(TAG, it?.state?.name.toString())
                if (it?.state!!.isFinished) {
                    Log.i(TAG, "Finish !")
                }
            })
    }

    private fun test2() {
        // 使用 PeriodicWorkRequest.Builder 创建重复的任务，然后将任务排入 WorkManager 队列
        val repeatRequest = PeriodicWorkRequest
            .Builder(MyWorkA::class.java, 10, TimeUnit.SECONDS).build()
        WorkManager.getInstance().enqueue(repeatRequest)
        WorkManager.getInstance().getWorkInfoByIdLiveData(repeatRequest.id)
            .observe(this, Observer {
                Log.i(TAG, it?.state?.name.toString())
                if (it?.state!!.isFinished) {
                    Log.i(TAG, "Finish !")
                }
            })
    }
}

/**
 * 定义 Worker 类，并重写其 doWork() 方法
 * */
class MyWorkA(context: Context, workerParameters: WorkerParameters) :
    Worker(context, workerParameters) {

    override fun doWork(): Result {
        Log.i(TAG, "doWork A !")
        Thread.sleep(1000)
        // 模拟任务执行成功
        return Result.success()
    }
}
