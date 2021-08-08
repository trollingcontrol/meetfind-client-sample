package com.trollingcont.meetfindtestclient.datasource

import android.content.Context
import android.util.Log

class LocalDataSource (
    context: Context
)  {
    private companion object {
        const val SHARED_PREF_SETTING_NAME = "localRepository"
        const val AUTH_TOKEN_KEY = "authToken"
    }

    private val sharedPref =
        context.getSharedPreferences(SHARED_PREF_SETTING_NAME, Context.MODE_PRIVATE)

    fun getUserAuthToken(): String? =
        sharedPref.getString(AUTH_TOKEN_KEY, null)

    fun setUserAuthToken(token: String?) {
        Log.d("SERVER-TEST", "setUserAuthToken - $token")
        sharedPref
            .edit()
            .putString(AUTH_TOKEN_KEY, token)
            .apply()
    }
}