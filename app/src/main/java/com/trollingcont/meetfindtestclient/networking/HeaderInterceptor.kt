package com.trollingcont.meetfindtestclient.networking

import android.util.Log
import com.trollingcont.meetfindtestclient.datasource.LocalDataSource
import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor (
    private val localDataSource: LocalDataSource
) : Interceptor {

    companion object {
        const val CONTENT_TYPE_HEADER_NAME = "Content-Type"
        const val CONTENT_MIME_TYPE = "application/json"
        const val AUTH_HEADER_NAME = "Authorization"
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val requestUrl = request.url()
        val newRequest = request.newBuilder()
        val userToken = localDataSource.getUserAuthToken()

        newRequest.addHeader(CONTENT_TYPE_HEADER_NAME, CONTENT_MIME_TYPE)

        if (
            (!requestUrl.encodedPath().equals("/login") && !requestUrl.encodedPath()
                .equals("/register")) &&
            userToken != null
        ) {
            Log.d("SERVER-TEST", "Authorization header :: $userToken")
            newRequest.addHeader(AUTH_HEADER_NAME, userToken)
        }

        return chain.proceed(newRequest.build())
    }
}