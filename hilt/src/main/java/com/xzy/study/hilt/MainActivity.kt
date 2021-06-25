package com.xzy.study.hilt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.xzy.study.hilt.bean.Truck
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Retrofit
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var truck: Truck

    @Inject
    lateinit var retrofit: Retrofit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        truck.deliver()

        retrofit.baseUrl().isHttps
    }
}