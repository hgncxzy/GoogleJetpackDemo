package com.xzy.study.hilt.bean

import com.xzy.study.hilt.annotations.BindElectricAnnotation
import com.xzy.study.hilt.annotations.BindGasAnnotation
import com.xzy.study.hilt.interfaces.Engine
import javax.inject.Inject

/**
 *
 * @author ：created by xzy.
 * @date ：2021/6/25
 */
class Truck @Inject constructor(val driver: Driver) {
    @BindGasAnnotation
    @Inject
    lateinit var gasEngine: Engine

    @BindElectricAnnotation
    @Inject
    lateinit var electricEngine: Engine

    fun deliver() {
        gasEngine.start()
        electricEngine.start()
        println("Truck is delivering cargo.Driven by $driver")
        gasEngine.shutdown()
        electricEngine.shutdown()
    }
}