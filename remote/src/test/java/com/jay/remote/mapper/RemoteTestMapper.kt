package com.jay.remote.mapper

import com.jay.remote.remote.mapper.WJRemoteMapper
import com.jay.remote.remote.model.RemoteModel
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

//@RunWith(JUnit4::class)
//class RemoteTestMapper {
//
//    private lateinit var mapper: WJRemoteMapper
//
//    @Before
//    fun setup() {
//        mapper = WJRemoteMapper
//    }
//
//    @Test
//    fun mapToRemote() {
//        val remote = RemoteModel(1, "name", "title", "avatar")
//        val mapperModel = mapper.mapToRemote(remote)
//
//        assertEquals(remote.id, mapperModel.id)
//        assertEquals(remote.name, mapperModel.name)
//        assertEquals(remote.title, mapperModel.title)
//        assertEquals(remote.avatar, mapperModel.avatar)
//    }
//
//}