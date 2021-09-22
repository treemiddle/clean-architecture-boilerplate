package com.jay.remote

import com.jay.remote.remote.WJRemoteDataSourceImpl
import com.jay.remote.remote.api.ApiService
import com.jay.remote.remote.mapper.WJRemoteMapper
import com.jay.remote.remote.model.RemoteModel
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import java.util.concurrent.TimeUnit


//@RunWith(JUnit4::class)
//class RemoteTestImpl {
//
//    private lateinit var remoteMapper: WJRemoteMapper
//    private lateinit var service: ApiService
//
//    private lateinit var remoteSource: WJRemoteDataSourceImpl
//
//    @Before
//    fun setup() {
//        remoteMapper = mock()
//        service = mock()
//        remoteSource = WJRemoteDataSourceImpl(service)
//    }
//
//    @Test
//    fun getItemsCompletable() {
//        getItems(Single.just(createResponse()))
//
//        val testObserver = remoteSource.getSearchMovie().test()
//        testObserver.awaitDone(2, TimeUnit.SECONDS)
//            .assertComplete()
//    }
//
//    @Test
//    fun returnItems() {
//        val response = createResponse()
//        getItems(Single.just(response))
//
//        val entities = response.map { remoteMapper.mapToRemote(it) }
//
//        val testObserver = remoteSource.getSearchMovie().test()
//        testObserver.assertValue(entities)
//    }
//
//    private fun createResponse(): List<RemoteModel> {
//        val list = mutableListOf<RemoteModel>()
//        repeat(5) {
//            val model = RemoteModel(it.toLong(), "name: $it", "title: $it", "avatar: $it")
//            list.add(model)
//        }
//
//        return list
//    }
//
//    private fun getItems(observable: Single<List<RemoteModel>>) {
//        whenever(service.getSearchMovie())
//            .thenReturn(observable)
//    }
//
//}