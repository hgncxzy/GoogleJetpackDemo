package com.xzy.study.hilt

import com.xzy.study.hilt.interfaces.Engine
import javax.inject.Inject

/**
 *
 * @author ：created by xzy.
 * @date ：2021/6/25
 */
class GasEngine @Inject constructor() : Engine {
    override fun start() {
        println("GasEngine start.")
    }

    override fun shutdown() {
        println("GasEngine shutdown.")
    }
}