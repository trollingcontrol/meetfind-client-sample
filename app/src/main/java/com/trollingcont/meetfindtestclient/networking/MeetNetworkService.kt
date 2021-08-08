package com.trollingcont.meetfindtestclient.networking

import com.google.gson.Gson
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class MeetNetworkService (
    interceptor: HeaderInterceptor,
    gson: Gson
) {
    private companion object {
        const val BASE_URL = "http://5.129.43.56:36600/"
    }

    private val okHttpClient = OkHttpClient()
        .newBuilder()
        .addInterceptor(interceptor)
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()

    private val meetNetwork = retrofit.create(MeetServerMethods::class.java)

    fun meetNetworkMethods(): MeetServerMethods = meetNetwork
}