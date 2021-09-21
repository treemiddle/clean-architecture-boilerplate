package com.jay.local.mapper

/**
 * @param <L> the local model input type
 * @param <D> the model return type
 */
interface LocalMapper<L, D> {

    fun mapToLocal(from: D): L

    fun mapToData(from: L): D

}