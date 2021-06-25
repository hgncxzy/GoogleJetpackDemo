package com.xzy.study.hilt

import com.xzy.study.hilt.annotations.BindElectricAnnotation
import com.xzy.study.hilt.annotations.BindGasAnnotation
import com.xzy.study.hilt.interfaces.Engine
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

/**
 *
 * @author ：created by xzy.
 * @date ：2021/6/25
 */
@Module
@InstallIn(ActivityComponent::class)
abstract class EngineModule {

    @BindGasAnnotation
    @Binds
    abstract fun gasEngine(gasEngine: GasEngine):Engine

    @BindElectricAnnotation
    @Binds
    abstract fun electricEngine(electricEngine: ElectricEngine):Engine


}