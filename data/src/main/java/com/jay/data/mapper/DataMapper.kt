package com.jay.data.mapper

internal interface DataMapper<in D, out M> {

    fun mapToModel(from: D): M

}