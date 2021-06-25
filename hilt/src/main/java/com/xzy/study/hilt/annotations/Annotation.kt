package com.xzy.study.hilt.annotations

import javax.inject.Qualifier

/**
 *
 * @author ：created by xzy.
 * @date ：2021/6/25
 */
@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class BindGasAnnotation

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class BindElectricAnnotation

