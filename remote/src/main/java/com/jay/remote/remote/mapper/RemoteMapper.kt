package com.jay.remote.remote.mapper

/**
 * @param <M> the remote model input type
 * @param <E> the entity model output type
 */
interface RemoteMapper<in M, out E> {

    fun mapToRemote(from: M): E

}