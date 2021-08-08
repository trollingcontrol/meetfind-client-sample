package com.trollingcont.meetfindtestclient

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonSerializer
import com.trollingcont.meetfindtestclient.datasource.LocalDataSource
import com.trollingcont.meetfindtestclient.model.*
import com.trollingcont.meetfindtestclient.networking.HeaderInterceptor
import com.trollingcont.meetfindtestclient.networking.MeetNetworkService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import okhttp3.ResponseBody
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")
        val gsonBuilder = GsonBuilder()
        val dateTimeSerializer: JsonSerializer<LocalDateTime> = DateTimeSerializer(dateTimeFormatter)
        gsonBuilder.registerTypeAdapter(LocalDateTime::class.java, dateTimeSerializer)
        val gson = gsonBuilder.create()

        val localDataSource = LocalDataSource(this)
        val headerInterceptor = HeaderInterceptor(localDataSource)

        val meetNetworkService = MeetNetworkService(headerInterceptor, gson)

        // User register
        /*meetNetworkService.meetNetworkMethods().registerUser(
            User("Android_TestUser", "12345678")
        ).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                object : DisposableSingleObserver<ResponseBody>() {
                    override fun onSuccess(responseBody: ResponseBody) {
                        Log.d("SERVER-TEST", "Success ${response.string()}")
                    }

                    override fun onError(throwable: Throwable) {
                        Log.e("SERVER-TEST", "Error: $throwable")
                    }
                }
            )*/

        // User login
        /*meetNetworkService.meetNetworkMethods().loginUser(
            User("Android_TestUser", "12345678")
        ).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                object : DisposableSingleObserver<ResponseBody>() {
                    override fun onSuccess(token: ResponseBody) {
                        val tokenStr = token.string()
                        Log.d("SERVER-TEST", "Success $tokenStr")
                        localDataSource.setUserAuthToken(tokenStr)
                    }

                    override fun onError(throwable: Throwable) {
                        Log.e("SERVER-TEST", "Error: $throwable")
                    }
                }
            )*/

        // Test request
        /*meetNetworkService.meetNetworkMethods().testRequest()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                object : DisposableSingleObserver<ResponseBody>() {
                    override fun onSuccess(responseBody: ResponseBody) {
                        Log.d("SERVER-TEST", "Success ${responseBody.string()}")
                    }

                    override fun onError(throwable: Throwable) {
                        Log.e("SERVER-TEST", "Error: $throwable")
                    }
                }
            )*/

        // Meet creation
        /*val meetCreationData = MeetCreationData(
            name = "Android Test Meet",
            description = "Test desc",
            latitude = 30.5555,
            longitude = 23.7771,
            time = LocalDateTime.parse("2021-08-30T12:30:00", dateTimeFormatter),
            creatorUsername = "Android_TestUser"
        )

        meetNetworkService.meetNetworkMethods().createMeet(
            meetCreationData
        )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                object : DisposableSingleObserver<Meet>() {
                    override fun onSuccess(meet: Meet) {
                        Log.d("SERVER-TEST", "Success ${gson.toJson(meet)}")
                    }

                    override fun onError(throwable: Throwable) {
                        Log.e("SERVER-TEST", "Error: $throwable")
                    }
                }
            )*/

        // Meets list
        /*meetNetworkService.meetNetworkMethods().getMeetsList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                object : DisposableSingleObserver<List<Meet>>() {
                    override fun onSuccess(meetsList: List<Meet>) {
                        Log.d("SERVER-TEST", "Success <meets list>")
                    }

                    override fun onError(throwable: Throwable) {
                        Log.e("SERVER-TEST", "Error: $throwable")
                    }
                }
            )*/

        // Get meet by id
        /*meetNetworkService.meetNetworkMethods().getMeetById(5)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                object : DisposableSingleObserver<Meet>() {
                    override fun onSuccess(meetsList: Meet) {
                        Log.d("SERVER-TEST", "Success ${gson.toJson(meetsList)}")
                    }

                    override fun onError(throwable: Throwable) {
                        Log.e("SERVER-TEST", "Error: $throwable")
                    }
                }
            )*/

        // Add participant
        /*meetNetworkService.meetNetworkMethods().addParticipant(
            AddParticipantData(5, "Android_TestUser")
        )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                object : DisposableSingleObserver<ResponseBody>() {
                    override fun onSuccess(responseBody: ResponseBody) {
                        Log.d("SERVER-TEST", "Success")
                    }

                    override fun onError(throwable: Throwable) {
                        Log.e("SERVER-TEST", "Error: $throwable")
                    }
                }
            )*/

        // Delete participant
        /*meetNetworkService.meetNetworkMethods().deleteParticipant(
            AddParticipantData(5, "Android_TestUser")
        )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                object : DisposableSingleObserver<ResponseBody>() {
                    override fun onSuccess(responseBody: ResponseBody) {
                        Log.d("SERVER-TEST", "Success")
                    }

                    override fun onError(throwable: Throwable) {
                        Log.e("SERVER-TEST", "Error: $throwable")
                    }
                }
            )*/

        // Delete Meet
        /*meetNetworkService.meetNetworkMethods().deleteMeet(10)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                object : DisposableSingleObserver<ResponseBody>() {
                    override fun onSuccess(responseBody: ResponseBody) {
                        Log.d("SERVER-TEST", "Success")
                    }

                    override fun onError(throwable: Throwable) {
                        Log.e("SERVER-TEST", "Error: $throwable")
                    }
                }
            )*/

        // Get meet participants
        /*meetNetworkService.meetNetworkMethods().getMeetParticipants(9)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                object : DisposableSingleObserver<List<String>>() {
                    override fun onSuccess(participants: List<String>) {
                        Log.d("SERVER-TEST", "Success ${gson.toJson(participants)}")
                    }

                    override fun onError(throwable: Throwable) {
                        Log.e("SERVER-TEST", "Error: $throwable")
                    }
                }
            )*/

        // Get user meets list
        /*meetNetworkService.meetNetworkMethods().getUserMeets(
            GetUserMeetsData("Android_TestU2ser")
        )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                object : DisposableSingleObserver<List<Int>>() {
                    override fun onSuccess(participants: List<Int>) {
                        Log.d("SERVER-TEST", "Success ${gson.toJson(participants)}")
                    }

                    override fun onError(throwable: Throwable) {
                        Log.e("SERVER-TEST", "Error: $throwable")
                    }
                }
            )*/
    }
}