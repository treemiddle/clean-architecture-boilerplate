package com.jay.wj_clean_architecture.mapper

/**
 * @param <V> the view input type
 * @param <D> the view model output type
 */
interface Mapper<out V, in D> {

    fun mapToViewModel(type: D): V
}