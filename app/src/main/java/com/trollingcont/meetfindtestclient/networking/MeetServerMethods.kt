package com.trollingcont.meetfindtestclient.networking

import com.trollingcont.meetfindtestclient.model.*
import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface MeetServerMethods {
    @POST("register")
    fun registerUser(@Body user: User): Single<ResponseBody>

    @POST("login")
    fun loginUser(@Body user: User): Single<ResponseBody>

    @GET("test_req")
    fun testRequest(): Single<ResponseBody>

    @POST("create_meet")
    fun createMeet(@Body meet: MeetCreationData): Single<Meet>

    @GET("meets")
    fun getMeetsList(): Single<List<Meet>>

    @GET("meet/{id}")
    fun getMeetById(@Path("id") id: Long): Single<Meet>

    @POST("add_participant")
    fun addParticipant(@Body addParticipantData: AddParticipantData): Single<ResponseBody>

    @POST("delete_participant")
    fun deleteParticipant(@Body addParticipantData: AddParticipantData): Single<ResponseBody>

    @POST("delete_meet/{id}")
    fun deleteMeet(@Path("id") id: Long): Single<ResponseBody>

    @GET("meet_participants/{id}")
    fun getMeetParticipants(@Path("id") id: Long): Single<List<String>>

    @POST("user_meets")
    fun getUserMeets(@Body username: GetUserMeetsData): Single<List<Int>>
}