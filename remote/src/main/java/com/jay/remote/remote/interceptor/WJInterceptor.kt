package com.jay.remote.remote.interceptor

import com.jay.remote.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class WJInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
        val requestURL = chain.request().url.toString()

        if (requestURL.startsWith(BuildConfig.NAVER_BASE_URL)) {
            request.addHeader(HEADER_NAVER_AUTH_CLIENT_ID, BuildConfig.NAVER_CLIENT_ID)
            request.addHeader(HEADER_NAVER_AUTH_CLIENT_SECRET, BuildConfig.NAVER_CLIENT_SECRET)
        }

        return chain.proceed(request.build())
    }

    companion object {
        private const val HEADER_NAVER_AUTH_CLIENT_ID = "X-Naver-Client-Id"
        private const val HEADER_NAVER_AUTH_CLIENT_SECRET = "X-Naver-Client-Secret"
    }

}