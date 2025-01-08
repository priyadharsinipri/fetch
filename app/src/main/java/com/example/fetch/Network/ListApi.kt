package com.example.fetch.Network

import android.telecom.Call.Details
import com.example.fetch.data.details
import retrofit2.Response
import retrofit2.http.GET

interface ListApi {

    @GET("/hiring.json")
    suspend fun getList():List<details>
}